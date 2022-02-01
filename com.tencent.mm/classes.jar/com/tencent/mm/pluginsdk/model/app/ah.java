package com.tencent.mm.pluginsdk.model.app;

import android.graphics.BitmapFactory.Options;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.aj.l;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.q.b;
import com.tencent.mm.chatroom.d.aa;
import com.tencent.mm.chatroom.d.y;
import com.tencent.mm.f.a.acf;
import com.tencent.mm.f.a.acf.a;
import com.tencent.mm.f.c.et;
import com.tencent.mm.kernel.h;
import com.tencent.mm.m.a.a;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ac;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bs;
import com.tencent.mm.model.z;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.record.a.f;
import com.tencent.mm.protocal.protobuf.edg;
import com.tencent.mm.protocal.protobuf.edh;
import com.tencent.mm.protocal.protobuf.emn;
import com.tencent.mm.protocal.protobuf.emp;
import com.tencent.mm.protocal.protobuf.fa;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.viewitems.o;
import com.tencent.mm.ui.chatting.viewitems.o.d;
import java.util.Locale;

public final class ah
  extends com.tencent.mm.an.q
  implements m
{
  private acf JVA;
  private a QWW;
  private com.tencent.mm.f.a.q QWX;
  private c QXb;
  private boolean QXc;
  private a QXd;
  private com.tencent.mm.an.i callback;
  private ca fNz;
  private int fSq;
  private com.tencent.mm.i.d jYa;
  private String mSessionId;
  private long msgId;
  private com.tencent.mm.an.d rr;
  
  public ah(long paramLong, com.tencent.mm.i.d paramd, a parama, String paramString, int paramInt, a parama1)
  {
    this(paramLong, false, paramd, parama, paramString, null);
    this.fSq = paramInt;
    this.QWW = parama1;
  }
  
  public ah(long paramLong, boolean paramBoolean, com.tencent.mm.i.d paramd, a parama, String paramString, c paramc)
  {
    AppMethodBeat.i(31057);
    this.msgId = 0L;
    this.jYa = null;
    this.QXb = null;
    this.fNz = null;
    this.QXc = false;
    this.fSq = 0;
    this.QXd = null;
    this.msgId = paramLong;
    this.mSessionId = paramString;
    this.jYa = paramd;
    this.QXd = parama;
    this.QXc = paramBoolean;
    this.QXb = paramc;
    parama = new d.a();
    parama.lBU = new edg();
    parama.lBV = new edh();
    parama.uri = "/cgi-bin/micromsg-bin/sendappmsg";
    parama.funcId = 222;
    parama.lBW = 107;
    parama.respCmdId = 1000000107;
    this.rr = parama.bgN();
    Log.i("MicroMsg.NetSceneSendAppMsgForCdn", "summerbig NetSceneSendAppMsgForCdn msgId[%d], sceneResult[%s], sessionId[%s], attachInfo[%s]. stack[%s]", new Object[] { Long.valueOf(paramLong), paramd, paramString, paramc, Util.getStack() });
    AppMethodBeat.o(31057);
  }
  
  public final int doScene(g paramg, com.tencent.mm.an.i parami)
  {
    AppMethodBeat.i(31058);
    this.callback = parami;
    bh.beI();
    this.fNz = com.tencent.mm.model.c.bbO().Oq(this.msgId);
    if ((this.fNz == null) || (this.fNz.field_msgId != this.msgId))
    {
      Log.e("MicroMsg.NetSceneSendAppMsgForCdn", "summerbig cdntra doscene msginfo null id:%d", new Object[] { Long.valueOf(this.msgId) });
      this.QXd.dN(3, -1);
      AppMethodBeat.o(31058);
      return -1;
    }
    k.b localb = k.b.OQ(this.fNz.field_content);
    if (localb == null)
    {
      Log.e("MicroMsg.NetSceneSendAppMsgForCdn", "summerbig cdntra doscene AppMessage.Content.parse null id:%d", new Object[] { Long.valueOf(this.msgId) });
      this.QXd.dN(3, -1);
    }
    if ((localb != null) && (localb.type == 6) && (this.fNz.getType() == 10000))
    {
      Log.e("MicroMsg.NetSceneSendAppMsgForCdn", "stop send revoke msg(%s)", new Object[] { Long.valueOf(this.fNz.field_msgId) });
      AppMethodBeat.o(31058);
      return -1;
    }
    if ((localb.type == 6) && ((this.fNz.field_msgSvrId <= 0L) || (this.fNz.field_status != 2)))
    {
      parami = (com.tencent.mm.aj.a.b)localb.ar(com.tencent.mm.aj.a.b.class);
      if ((parami != null) && ((parami.lqB != 0L) || (!Util.isNullOrNil(parami.lqC))))
      {
        parami.reset();
        this.fNz.setContent(k.b.a(localb, null, null));
        ((n)h.ae(n.class)).eSe().a(this.fNz.field_msgId, this.fNz);
      }
    }
    edg localedg = (edg)d.b.b(this.rr.lBR);
    fa localfa = new fa();
    localfa.lVG = localb.appId;
    localfa.RJQ = (this.fNz.field_talker + this.fNz.field_msgId + "T" + this.fNz.field_createTime);
    localfa.CreateTime = ((int)Util.nowSecond());
    localfa.CRQ = this.fNz.field_talker;
    localfa.CRR = z.bcZ();
    localfa.rWu = localb.type;
    localfa.RJP = localb.sdkVer;
    localfa.Cqs = localb.lma;
    parami = a.a.atD().o(this.fNz);
    ad.b localb1;
    emp localemp;
    if (!Util.isNullOrNil(parami))
    {
      localfa.RII = parami;
      localfa.RJT = localb.fUg;
      localfa.RJU = localb.fUh;
      localfa.RJV = localb.fUi;
      if (this.QWW != null)
      {
        localfa.RJW = this.QWW.QVW;
        localfa.CqB = this.QWW.pkgName;
      }
      localedg.UhM = this.fSq;
      localb1 = com.tencent.mm.ui.transmit.c.bAK(this.mSessionId);
      if (localb1 != null)
      {
        this.JVA = new acf();
        this.JVA.gce.url = localb.url;
        this.JVA.gce.gcf = localb1.getString("prePublishId", "");
        this.JVA.gce.gch = localb1.getString("preUsername", "");
        this.JVA.gce.gci = localb1.getString("preChatName", "");
        this.JVA.gce.gcj = localb1.getInt("preMsgIndex", 0);
        this.JVA.gce.gcn = localb1.getInt("sendAppMsgScene", 0);
        this.JVA.gce.gco = localb1.getInt("getA8KeyScene", 0);
        this.JVA.gce.gcp = localb1.getString("referUrl", null);
        this.JVA.gce.gcq = localb1.getString("adExtStr", null);
        this.JVA.gce.gck = this.fNz.field_talker;
        this.JVA.gce.gcr = localb.title;
        this.JVA.gce.gct = localb.description;
        bh.beI();
        parami = com.tencent.mm.model.c.bbL().RG(this.fNz.field_talker);
        if (parami != null) {
          this.JVA.gce.gcl = parami.ayr();
        }
        this.JVA.gce.gcm = com.tencent.mm.model.v.Pu(this.fNz.field_talker);
        str = "";
        parami = str;
        if (localb.fUk != null)
        {
          localemp = new emp();
          parami = Base64.decode(localb.fUk, 0);
        }
      }
    }
    try
    {
      localemp.parseFrom(parami);
      parami = str;
      if (localemp.Upg != null) {
        parami = localemp.Upg.CIO;
      }
    }
    catch (Exception parami)
    {
      for (;;)
      {
        int i;
        int j;
        label1163:
        boolean bool;
        label1207:
        int k;
        int m;
        label1864:
        label1869:
        label1897:
        parami = str;
      }
    }
    localedg.UhK = String.format(Locale.US, "prePublishId=%s&preUserName=%s&preChatName=%s&preChatType=%d&getA8KeyScene=%d&sourceAppId=%s", new Object[] { this.JVA.gce.gcf, this.JVA.gce.gch, this.JVA.gce.gci, Integer.valueOf(ac.aN(this.JVA.gce.gch, this.JVA.gce.gci)), Integer.valueOf(this.JVA.gce.gco), parami });
    if ((localb1 != null) && (localb.type == 33))
    {
      this.QWX = new com.tencent.mm.f.a.q();
      i = localb1.getInt("fromScene", 1);
      this.QWX.fva.scene = i;
      j = localb1.getInt("appservicetype", 0);
      this.QWX.fva.cwR = j;
      parami = localb1.getString("preChatName", "");
      if (2 == i)
      {
        str = localb1.getString("preUsername", "");
        this.QWX.fva.fvd = (parami + ":" + str);
        parami = this.fNz.field_talker;
        bool = localb1.getBoolean("moreRetrAction", false);
        if (!parami.endsWith("@chatroom")) {
          break label1869;
        }
        parami = this.QWX.fva;
        if (!bool) {
          break label1864;
        }
        i = 5;
        parami.action = i;
        this.QWX.fva.fvc = (localb.loT + 1);
        this.QWX.fva.fve = localb.loz;
        this.QWX.fva.fvb = localb.loA;
        this.QWX.fva.appId = localb.loB;
        this.QWX.fva.appVersion = localb.loU;
        this.QWX.fva.fvg = Util.nowSecond();
        this.QWX.fva.fvh = 1;
        this.QWX.fva.fvj = localb.loF;
      }
    }
    else
    {
      Log.d("MicroMsg.NetSceneSendAppMsgForCdn", "stev summerbig SnsPostOperationFields: ShareUrlOriginal=%s, ShareUrlOpen=%s, JsAppId=%s", new Object[] { localb.fUg, localb.fUh, localb.fUi });
      k = 0;
      m = 0;
      j = m;
      i = k;
      if (!Util.isNullOrNil(this.fNz.field_imgPath))
      {
        parami = BitmapUtil.getImageOptions(com.tencent.mm.ay.q.bmh().VW(this.fNz.field_imgPath));
        j = m;
        i = k;
        if (parami != null)
        {
          i = parami.outWidth;
          j = parami.outHeight;
        }
      }
      if (this.jYa.arK())
      {
        Log.i("MicroMsg.NetSceneSendAppMsgForCdn", "summersafecdn app sceneResult crc[%d], safecdn[%b], hitcachetype[%d], aeskey[%s]", new Object[] { Integer.valueOf(this.jYa.field_filecrc), Boolean.valueOf(this.jYa.field_upload_by_safecdn), Integer.valueOf(this.jYa.field_UploadHitCacheType), this.jYa.field_aesKey });
        this.jYa.field_aesKey = "";
        localedg.UhL = 1;
      }
      localedg.ScX = this.jYa.field_filecrc;
      parami = null;
      if (this.QXc) {
        parami = "@cdn_" + this.jYa.field_fileId + "_" + this.jYa.field_aesKey + "_1";
      }
      localfa.lpy = k.b.a(localb, parami, this.jYa, i, j);
      localedg.UhI = localfa;
      if ((this.QXb != null) && ((localb.lmb != 0) || (localb.llX > 26214400)))
      {
        localedg.mVB = this.QXb.field_signature;
        localedg.RLs = com.tencent.mm.i.a.iTW;
      }
      localedg.Md5 = localb.filemd5;
      if (!Util.isNullOrNil(this.jYa.field_filemd5)) {
        break label1897;
      }
      Log.i("MicroMsg.NetSceneSendAppMsgForCdn", "summerbig sceneResult filemd5 is null use content.filemd5[%s]", new Object[] { localb.filemd5 });
    }
    for (;;)
    {
      if (((com.tencent.mm.plugin.messenger.foundation.a.v)h.ag(com.tencent.mm.plugin.messenger.foundation.a.v.class)).ifAddTicketByActionFlag(this.fNz.field_talker)) {
        localedg.ScZ = ((n)h.ae(n.class)).bbL().bws(this.fNz.field_talker);
      }
      Log.i("MicroMsg.NetSceneSendAppMsgForCdn", "summerbig file md5[%s], HitMd5[%d], signature[%s], type[%d], sceneResult[%s], fromScene[%s]", new Object[] { localedg.Md5, Integer.valueOf(localedg.UhL), Util.secPrint(localedg.mVB), Integer.valueOf(localedg.RLs), this.jYa, localedg.UhK });
      i = dispatch(paramg, this.rr, this);
      AppMethodBeat.o(31058);
      return i;
      localfa.RII = bs.apc();
      break;
      this.QWX.fva.fvd = parami;
      break label1163;
      i = 2;
      break label1207;
      parami = this.QWX.fva;
      if (bool) {}
      for (i = 4;; i = 1)
      {
        parami.action = i;
        break;
      }
      localedg.Md5 = this.jYa.field_filemd5;
    }
  }
  
  public final int getType()
  {
    return 222;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(31059);
    paramArrayOfByte = (edg)d.b.b(((com.tencent.mm.an.d)params).lBR);
    Log.i("MicroMsg.NetSceneSendAppMsgForCdn", "summerbig cdntra onGYNetEnd [%d,%d,%s] msgId:%d, oldContent[%s], newContent[%s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Long.valueOf(this.msgId), Util.secPrint(this.fNz.field_content), paramArrayOfByte.UhI.lpy });
    paramArrayOfByte = (edh)d.c.b(((com.tencent.mm.an.d)params).lBS);
    if ((paramArrayOfByte != null) && ((paramInt2 == 4) || ((paramInt2 == 0) && (paramInt3 == 0)))) {
      ((com.tencent.mm.plugin.messenger.foundation.a.v)h.ag(com.tencent.mm.plugin.messenger.foundation.a.v.class)).setEnSendMsgActionFlag(paramArrayOfByte.Sda);
    }
    bh.beI();
    params = com.tencent.mm.model.c.bbO().Oq(this.fNz.field_msgId);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      if ((paramInt2 == 4) && (paramInt3 == 102))
      {
        Log.w("MicroMsg.NetSceneSendAppMsgForCdn", "summersafecdn MM_ERR_GET_AESKEY_FAILED");
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        this.QXd.dN(paramInt2, paramInt3);
        AppMethodBeat.o(31059);
        return;
      }
      params.setStatus(5);
      bh.beI();
      com.tencent.mm.model.c.bbO().a(params.field_msgId, params);
      Log.e("MicroMsg.NetSceneSendAppMsgForCdn", "summerbig send app msg failed, err=" + paramInt2 + "," + paramInt3);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      this.QXd.dN(paramInt2, paramInt3);
      AppMethodBeat.o(31059);
      return;
    }
    Log.i("MicroMsg.NetSceneSendAppMsgForCdn", "summersafecdn svrid[%d]. aeskey[%s], old content[%s]", new Object[] { Long.valueOf(paramArrayOfByte.HlH), paramArrayOfByte.ScV, Util.secPrint(params.field_content) });
    if ((this.jYa != null) && (this.jYa.arK()))
    {
      if (Util.isNullOrNil(paramArrayOfByte.ScV)) {
        break label765;
      }
      k.b localb = k.b.OQ(params.field_content);
      localb.aesKey = paramArrayOfByte.ScV;
      params.setContent(k.b.a(localb, null, null));
      Log.i("MicroMsg.NetSceneSendAppMsgForCdn", "summersafecdn aeskey[%s], new content[%s]", new Object[] { paramArrayOfByte.ScV, Util.secPrint(params.field_content) });
    }
    for (;;)
    {
      params.setStatus(2);
      params.EG(paramArrayOfByte.HlH);
      bh.beI();
      com.tencent.mm.model.c.bbO().a(params.field_msgId, params);
      ((f)h.ae(f.class)).Pl(params.field_msgId);
      com.tencent.mm.modelstat.b.mcf.d(params, l.v(params));
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      this.QXd.dN(paramInt2, paramInt3);
      if ((this.JVA != null) && (!Util.isNullOrNil(this.JVA.gce.url)))
      {
        this.JVA.gce.gcg = ("msg_" + Long.toString(paramArrayOfByte.HlH));
        EventCenter.instance.publish(this.JVA);
      }
      if (this.QWX != null)
      {
        this.QWX.fva.fvf = ("msg_" + params.field_msgSvrId);
        EventCenter.instance.publish(this.QWX);
      }
      paramString = k.b.OQ(params.field_content);
      if (paramString != null)
      {
        if (ab.PP(params.field_talker))
        {
          paramArrayOfByte = (com.tencent.mm.aj.a)paramString.ar(com.tencent.mm.aj.a.class);
          if ((paramArrayOfByte != null) && (paramArrayOfByte.lkz)) {
            y.a(params, paramString);
          }
          if (aa.asf()) {
            ((com.tencent.mm.chatroom.plugin.a)h.ag(com.tencent.mm.chatroom.plugin.a.class)).handleGroupToolByReceiverAppMsg(params);
          }
        }
        if (paramString.type == 6)
        {
          paramArrayOfByte = o.XfQ;
          o.d.a(6, paramString, params);
        }
      }
      AppMethodBeat.o(31059);
      return;
      label765:
      Log.w("MicroMsg.NetSceneSendAppMsgForCdn", "summersafecdn need aeskey but ret null");
    }
  }
  
  public final q.b securityVerificationChecked(s params)
  {
    return q.b.lCx;
  }
  
  static abstract interface a
  {
    public abstract void dN(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.ah
 * JD-Core Version:    0.7.0.1
 */