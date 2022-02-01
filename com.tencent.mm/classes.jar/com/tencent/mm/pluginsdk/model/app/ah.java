package com.tencent.mm.pluginsdk.model.app;

import android.graphics.BitmapFactory.Options;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.q.b;
import com.tencent.mm.chatroom.d.aa;
import com.tencent.mm.chatroom.d.y;
import com.tencent.mm.g.a.aax;
import com.tencent.mm.g.a.aax.a;
import com.tencent.mm.g.a.p;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.m.a.a;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ac;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.br;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.modelstat.b;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.record.a.f;
import com.tencent.mm.protocal.protobuf.dth;
import com.tencent.mm.protocal.protobuf.dti;
import com.tencent.mm.protocal.protobuf.ecm;
import com.tencent.mm.protocal.protobuf.eco;
import com.tencent.mm.protocal.protobuf.fd;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.ca;
import java.util.Locale;

public final class ah
  extends com.tencent.mm.ak.q
  implements m
{
  private aax DIA;
  private a JWD;
  private p JWE;
  private c JWI;
  private boolean JWJ;
  private a JWK;
  private com.tencent.mm.ak.i callback;
  private ca dTX;
  private int dYz;
  private com.tencent.mm.i.d hmq;
  private String mSessionId;
  private long msgId;
  private com.tencent.mm.ak.d rr;
  
  public ah(long paramLong, com.tencent.mm.i.d paramd, a parama, String paramString, int paramInt, a parama1)
  {
    this(paramLong, false, paramd, parama, paramString, null);
    this.dYz = paramInt;
    this.JWD = parama1;
  }
  
  public ah(long paramLong, boolean paramBoolean, com.tencent.mm.i.d paramd, a parama, String paramString, c paramc)
  {
    AppMethodBeat.i(31057);
    this.msgId = 0L;
    this.hmq = null;
    this.JWI = null;
    this.dTX = null;
    this.JWJ = false;
    this.dYz = 0;
    this.JWK = null;
    this.msgId = paramLong;
    this.mSessionId = paramString;
    this.hmq = paramd;
    this.JWK = parama;
    this.JWJ = paramBoolean;
    this.JWI = paramc;
    parama = new d.a();
    parama.iLN = new dth();
    parama.iLO = new dti();
    parama.uri = "/cgi-bin/micromsg-bin/sendappmsg";
    parama.funcId = 222;
    parama.iLP = 107;
    parama.respCmdId = 1000000107;
    this.rr = parama.aXF();
    Log.i("MicroMsg.NetSceneSendAppMsgForCdn", "summerbig NetSceneSendAppMsgForCdn msgId[%d], sceneResult[%s], sessionId[%s], attachInfo[%s]. stack[%s]", new Object[] { Long.valueOf(paramLong), paramd, paramString, paramc, Util.getStack() });
    AppMethodBeat.o(31057);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.ak.i parami)
  {
    AppMethodBeat.i(31058);
    this.callback = parami;
    bg.aVF();
    this.dTX = com.tencent.mm.model.c.aSQ().Hb(this.msgId);
    if ((this.dTX == null) || (this.dTX.field_msgId != this.msgId))
    {
      Log.e("MicroMsg.NetSceneSendAppMsgForCdn", "summerbig cdntra doscene msginfo null id:%d", new Object[] { Long.valueOf(this.msgId) });
      this.JWK.dq(3, -1);
      AppMethodBeat.o(31058);
      return -1;
    }
    k.b localb = k.b.HD(this.dTX.field_content);
    if (localb == null)
    {
      Log.e("MicroMsg.NetSceneSendAppMsgForCdn", "summerbig cdntra doscene AppMessage.Content.parse null id:%d", new Object[] { Long.valueOf(this.msgId) });
      this.JWK.dq(3, -1);
    }
    dth localdth = (dth)this.rr.iLK.iLR;
    fd localfd = new fd();
    localfd.jfi = localb.appId;
    localfd.KIz = (this.dTX.field_talker + this.dTX.field_msgId + "T" + this.dTX.field_createTime);
    localfd.CreateTime = ((int)Util.nowSecond());
    localfd.xNG = this.dTX.field_talker;
    localfd.xNH = z.aTY();
    localfd.oUv = localb.type;
    localfd.KIy = localb.sdkVer;
    localfd.xub = localb.iwL;
    parami = a.a.anC().o(this.dTX);
    ad.b localb1;
    eco localeco;
    if (!Util.isNullOrNil(parami))
    {
      localfd.KHq = parami;
      localfd.KIC = localb.eaj;
      localfd.KID = localb.eak;
      localfd.KIE = localb.eal;
      if (this.JWD != null)
      {
        localfd.KIF = this.JWD.JVJ;
        localfd.xuk = this.JWD.pkgName;
      }
      localdth.MVy = this.dYz;
      localb1 = com.tencent.mm.ui.transmit.c.bnX(this.mSessionId);
      if (localb1 != null)
      {
        this.DIA = new aax();
        this.DIA.ehN.url = localb.url;
        this.DIA.ehN.ehO = localb1.getString("prePublishId", "");
        this.DIA.ehN.ehQ = localb1.getString("preUsername", "");
        this.DIA.ehN.ehR = localb1.getString("preChatName", "");
        this.DIA.ehN.ehS = localb1.getInt("preMsgIndex", 0);
        this.DIA.ehN.ehW = localb1.getInt("sendAppMsgScene", 0);
        this.DIA.ehN.ehX = localb1.getInt("getA8KeyScene", 0);
        this.DIA.ehN.ehY = localb1.getString("referUrl", null);
        this.DIA.ehN.ehZ = localb1.getString("adExtStr", null);
        this.DIA.ehN.ehT = this.dTX.field_talker;
        this.DIA.ehN.eia = localb.title;
        this.DIA.ehN.eic = localb.description;
        bg.aVF();
        parami = com.tencent.mm.model.c.aSN().Kn(this.dTX.field_talker);
        if (parami != null) {
          this.DIA.ehN.ehU = parami.arI();
        }
        this.DIA.ehN.ehV = v.Ie(this.dTX.field_talker);
        str = "";
        parami = str;
        if (localb.ean != null)
        {
          localeco = new eco();
          parami = Base64.decode(localb.ean, 0);
        }
      }
    }
    try
    {
      localeco.parseFrom(parami);
      parami = str;
      if (localeco.NcJ != null) {
        parami = localeco.NcJ.xEN;
      }
    }
    catch (Exception parami)
    {
      for (;;)
      {
        int i;
        int j;
        label988:
        boolean bool;
        label1032:
        int k;
        int m;
        label1690:
        label1695:
        label1723:
        parami = str;
      }
    }
    localdth.MVw = String.format(Locale.US, "prePublishId=%s&preUserName=%s&preChatName=%s&preChatType=%d&getA8KeyScene=%d&sourceAppId=%s", new Object[] { this.DIA.ehN.ehO, this.DIA.ehN.ehQ, this.DIA.ehN.ehR, Integer.valueOf(ac.aJ(this.DIA.ehN.ehQ, this.DIA.ehN.ehR)), Integer.valueOf(this.DIA.ehN.ehX), parami });
    if ((localb1 != null) && (localb.type == 33))
    {
      this.JWE = new p();
      i = localb1.getInt("fromScene", 1);
      this.JWE.dCt.scene = i;
      j = localb1.getInt("appservicetype", 0);
      this.JWE.dCt.cyo = j;
      parami = localb1.getString("preChatName", "");
      if (2 == i)
      {
        str = localb1.getString("preUsername", "");
        this.JWE.dCt.dCw = (parami + ":" + str);
        parami = this.dTX.field_talker;
        bool = localb1.getBoolean("moreRetrAction", false);
        if (!parami.endsWith("@chatroom")) {
          break label1695;
        }
        parami = this.JWE.dCt;
        if (!bool) {
          break label1690;
        }
        i = 5;
        parami.action = i;
        this.JWE.dCt.dCv = (localb.izz + 1);
        this.JWE.dCt.dCx = localb.izh;
        this.JWE.dCt.dCu = localb.izi;
        this.JWE.dCt.appId = localb.izj;
        this.JWE.dCt.appVersion = localb.izA;
        this.JWE.dCt.dCz = Util.nowSecond();
        this.JWE.dCt.dCA = 1;
        this.JWE.dCt.dCC = localb.izn;
      }
    }
    else
    {
      Log.d("MicroMsg.NetSceneSendAppMsgForCdn", "stev summerbig SnsPostOperationFields: ShareUrlOriginal=%s, ShareUrlOpen=%s, JsAppId=%s", new Object[] { localb.eaj, localb.eak, localb.eal });
      k = 0;
      m = 0;
      j = m;
      i = k;
      if (!Util.isNullOrNil(this.dTX.field_imgPath))
      {
        parami = BitmapUtil.getImageOptions(com.tencent.mm.av.q.bcR().Oz(this.dTX.field_imgPath));
        j = m;
        i = k;
        if (parami != null)
        {
          i = parami.outWidth;
          j = parami.outHeight;
        }
      }
      if (this.hmq.alL())
      {
        Log.i("MicroMsg.NetSceneSendAppMsgForCdn", "summersafecdn app sceneResult crc[%d], safecdn[%b], hitcachetype[%d], aeskey[%s]", new Object[] { Integer.valueOf(this.hmq.field_filecrc), Boolean.valueOf(this.hmq.field_upload_by_safecdn), Integer.valueOf(this.hmq.field_UploadHitCacheType), this.hmq.field_aesKey });
        this.hmq.field_aesKey = "";
        localdth.MVx = 1;
      }
      localdth.LbL = this.hmq.field_filecrc;
      parami = null;
      if (this.JWJ) {
        parami = "@cdn_" + this.hmq.field_fileId + "_" + this.hmq.field_aesKey + "_1";
      }
      localfd.iAc = k.b.a(localb, parami, this.hmq, i, j);
      localdth.MVu = localfd;
      if ((this.JWI != null) && ((localb.iwM != 0) || (localb.iwI > 26214400)))
      {
        localdth.keb = this.JWI.field_signature;
        localdth.KKA = com.tencent.mm.i.a.gpO;
      }
      localdth.Md5 = localb.filemd5;
      if (!Util.isNullOrNil(this.hmq.field_filemd5)) {
        break label1723;
      }
      Log.i("MicroMsg.NetSceneSendAppMsgForCdn", "summerbig sceneResult filemd5 is null use content.filemd5[%s]", new Object[] { localb.filemd5 });
    }
    for (;;)
    {
      if (((com.tencent.mm.plugin.messenger.foundation.a.s)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).ifAddTicketByActionFlag(this.dTX.field_talker)) {
        localdth.LbN = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().bjT(this.dTX.field_talker);
      }
      Log.i("MicroMsg.NetSceneSendAppMsgForCdn", "summerbig file md5[%s], HitMd5[%d], signature[%s], type[%d], sceneResult[%s], fromScene[%s]", new Object[] { localdth.Md5, Integer.valueOf(localdth.MVx), Util.secPrint(localdth.keb), Integer.valueOf(localdth.KKA), this.hmq, localdth.MVw });
      i = dispatch(paramg, this.rr, this);
      AppMethodBeat.o(31058);
      return i;
      localfd.KHq = br.ajw();
      break;
      this.JWE.dCt.dCw = parami;
      break label988;
      i = 2;
      break label1032;
      parami = this.JWE.dCt;
      if (bool) {}
      for (i = 4;; i = 1)
      {
        parami.action = i;
        break;
      }
      localdth.Md5 = this.hmq.field_filemd5;
    }
  }
  
  public final int getType()
  {
    return 222;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(31059);
    paramArrayOfByte = (dth)((com.tencent.mm.ak.d)params).iLK.iLR;
    Log.i("MicroMsg.NetSceneSendAppMsgForCdn", "summerbig cdntra onGYNetEnd [%d,%d,%s] msgId:%d, oldContent[%s], newContent[%s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Long.valueOf(this.msgId), this.dTX.field_content, paramArrayOfByte.MVu.iAc });
    params = (dti)((com.tencent.mm.ak.d)params).iLL.iLR;
    if ((params != null) && ((paramInt2 == 4) || ((paramInt2 == 0) && (paramInt3 == 0)))) {
      ((com.tencent.mm.plugin.messenger.foundation.a.s)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).setEnSendMsgActionFlag(params.LbO);
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      if ((paramInt2 == 4) && (paramInt3 == 102))
      {
        Log.w("MicroMsg.NetSceneSendAppMsgForCdn", "summersafecdn MM_ERR_GET_AESKEY_FAILED");
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        this.JWK.dq(paramInt2, paramInt3);
        AppMethodBeat.o(31059);
        return;
      }
      this.dTX.setStatus(5);
      bg.aVF();
      com.tencent.mm.model.c.aSQ().a(this.dTX.field_msgId, this.dTX);
      Log.e("MicroMsg.NetSceneSendAppMsgForCdn", "summerbig send app msg failed, err=" + paramInt2 + "," + paramInt3);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      this.JWK.dq(paramInt2, paramInt3);
      AppMethodBeat.o(31059);
      return;
    }
    Log.i("MicroMsg.NetSceneSendAppMsgForCdn", "summersafecdn svrid[%d]. aeskey[%s], old content[%s]", new Object[] { Long.valueOf(params.Brn), params.LbJ, this.dTX.field_content });
    if ((this.hmq != null) && (this.hmq.alL()))
    {
      if (Util.isNullOrNil(params.LbJ)) {
        break label749;
      }
      paramArrayOfByte = k.b.HD(this.dTX.field_content);
      paramArrayOfByte.aesKey = params.LbJ;
      this.dTX.setContent(k.b.a(paramArrayOfByte, null, null));
      Log.i("MicroMsg.NetSceneSendAppMsgForCdn", "summersafecdn aeskey[%s], new content[%s]", new Object[] { params.LbJ, this.dTX.field_content });
    }
    for (;;)
    {
      this.dTX.setStatus(2);
      this.dTX.yF(params.Brn);
      bg.aVF();
      com.tencent.mm.model.c.aSQ().a(this.dTX.field_msgId, this.dTX);
      ((f)com.tencent.mm.kernel.g.af(f.class)).HQ(this.dTX.field_msgId);
      b.jmd.b(this.dTX, com.tencent.mm.ag.l.t(this.dTX));
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      this.JWK.dq(paramInt2, paramInt3);
      if ((this.DIA != null) && (!Util.isNullOrNil(this.DIA.ehN.url)))
      {
        this.DIA.ehN.ehP = ("msg_" + Long.toString(params.Brn));
        EventCenter.instance.publish(this.DIA);
      }
      if (this.JWE != null)
      {
        this.JWE.dCt.dCy = ("msg_" + this.dTX.field_msgSvrId);
        EventCenter.instance.publish(this.JWE);
      }
      paramString = k.b.HD(this.dTX.field_content);
      if ((paramString != null) && (ab.Ix(this.dTX.field_talker)))
      {
        params = (com.tencent.mm.ag.a)paramString.as(com.tencent.mm.ag.a.class);
        if ((params != null) && (params.ivq)) {
          y.a(this.dTX, paramString);
        }
        if (aa.ame()) {
          ((com.tencent.mm.chatroom.plugin.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.chatroom.plugin.a.class)).handleGroupToolByReceiverAppMsg(this.dTX);
        }
      }
      AppMethodBeat.o(31059);
      return;
      label749:
      Log.w("MicroMsg.NetSceneSendAppMsgForCdn", "summersafecdn need aeskey but ret null");
    }
  }
  
  public final q.b securityVerificationChecked(com.tencent.mm.network.s params)
  {
    return q.b.iMq;
  }
  
  static abstract interface a
  {
    public abstract void dq(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.ah
 * JD-Core Version:    0.7.0.1
 */