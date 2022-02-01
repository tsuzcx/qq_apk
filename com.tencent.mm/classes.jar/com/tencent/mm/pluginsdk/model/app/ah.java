package com.tencent.mm.pluginsdk.model.app;

import android.graphics.BitmapFactory.Options;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.n.b;
import com.tencent.mm.chatroom.d.aa;
import com.tencent.mm.g.a.o;
import com.tencent.mm.g.a.zk;
import com.tencent.mm.g.a.zk.a;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.i.d;
import com.tencent.mm.m.a.a;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.model.x;
import com.tencent.mm.model.y.b;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.protocal.protobuf.czj;
import com.tencent.mm.protocal.protobuf.czk;
import com.tencent.mm.protocal.protobuf.dif;
import com.tencent.mm.protocal.protobuf.dih;
import com.tencent.mm.protocal.protobuf.eq;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bu;
import java.util.Locale;

public final class ah
  extends n
  implements k
{
  private a ENp;
  private o ENq;
  private c ENu;
  private boolean ENv;
  private a ENw;
  private com.tencent.mm.al.f callback;
  private bu dBd;
  private int dFL;
  private d gwW;
  private String mSessionId;
  private long msgId;
  private com.tencent.mm.al.b rr;
  private zk zhC;
  
  public ah(long paramLong, d paramd, a parama, String paramString, int paramInt, a parama1)
  {
    this(paramLong, false, paramd, parama, paramString, null);
    this.dFL = paramInt;
    this.ENp = parama1;
  }
  
  public ah(long paramLong, boolean paramBoolean, d paramd, a parama, String paramString, c paramc)
  {
    AppMethodBeat.i(31057);
    this.msgId = 0L;
    this.gwW = null;
    this.ENu = null;
    this.dBd = null;
    this.ENv = false;
    this.dFL = 0;
    this.ENw = null;
    this.msgId = paramLong;
    this.mSessionId = paramString;
    this.gwW = paramd;
    this.ENw = parama;
    this.ENv = paramBoolean;
    this.ENu = paramc;
    parama = new b.a();
    parama.hNM = new czj();
    parama.hNN = new czk();
    parama.uri = "/cgi-bin/micromsg-bin/sendappmsg";
    parama.funcId = 222;
    parama.hNO = 107;
    parama.respCmdId = 1000000107;
    this.rr = parama.aDC();
    ad.i("MicroMsg.NetSceneSendAppMsgForCdn", "summerbig NetSceneSendAppMsgForCdn msgId[%d], sceneResult[%s], sessionId[%s], attachInfo[%s]. stack[%s]", new Object[] { Long.valueOf(paramLong), paramd, paramString, paramc, bt.flS() });
    AppMethodBeat.o(31057);
  }
  
  public final int doScene(e parame, com.tencent.mm.al.f paramf)
  {
    AppMethodBeat.i(31058);
    this.callback = paramf;
    ba.aBQ();
    this.dBd = com.tencent.mm.model.c.azs().xY(this.msgId);
    if ((this.dBd == null) || (this.dBd.field_msgId != this.msgId))
    {
      ad.e("MicroMsg.NetSceneSendAppMsgForCdn", "summerbig cdntra doscene msginfo null id:%d", new Object[] { Long.valueOf(this.msgId) });
      this.ENw.dg(3, -1);
      AppMethodBeat.o(31058);
      return -1;
    }
    k.b localb = k.b.yr(this.dBd.field_content);
    if (localb == null)
    {
      ad.e("MicroMsg.NetSceneSendAppMsgForCdn", "summerbig cdntra doscene AppMessage.Content.parse null id:%d", new Object[] { Long.valueOf(this.msgId) });
      this.ENw.dg(3, -1);
    }
    czj localczj = (czj)this.rr.hNK.hNQ;
    eq localeq = new eq();
    localeq.iht = localb.appId;
    localeq.Fwt = (this.dBd.field_talker + this.dBd.field_msgId + "T" + this.dBd.field_createTime);
    localeq.CreateTime = ((int)bt.aQJ());
    localeq.uki = this.dBd.field_talker;
    localeq.ukj = u.aAm();
    localeq.nEf = localb.type;
    localeq.Fws = localb.sdkVer;
    localeq.tRT = localb.hzR;
    paramf = a.a.ZG().o(this.dBd);
    y.b localb1;
    dih localdih;
    if (!bt.isNullOrNil(paramf))
    {
      localeq.Fvn = paramf;
      localeq.Fww = localb.dHr;
      localeq.Fwx = localb.dHs;
      localeq.Fwy = localb.dHt;
      if (this.ENp != null)
      {
        localeq.Fwz = this.ENp.EMu;
        localeq.ufi = this.ENp.dFD;
      }
      localczj.Hqj = this.dFL;
      localb1 = com.tencent.mm.model.y.aBq().AG(this.mSessionId);
      if (localb1 != null)
      {
        this.zhC = new zk();
        this.zhC.dOu.url = localb.url;
        this.zhC.dOu.dOv = localb1.getString("prePublishId", "");
        this.zhC.dOu.dOx = localb1.getString("preUsername", "");
        this.zhC.dOu.dOy = localb1.getString("preChatName", "");
        this.zhC.dOu.dOz = localb1.getInt("preMsgIndex", 0);
        this.zhC.dOu.dOD = localb1.getInt("sendAppMsgScene", 0);
        this.zhC.dOu.dOE = localb1.getInt("getA8KeyScene", 0);
        this.zhC.dOu.dOF = localb1.getString("referUrl", null);
        this.zhC.dOu.dOG = localb1.getString("adExtStr", null);
        this.zhC.dOu.dOA = this.dBd.field_talker;
        this.zhC.dOu.dOH = localb.title;
        this.zhC.dOu.dOJ = localb.description;
        ba.aBQ();
        paramf = com.tencent.mm.model.c.azp().Bf(this.dBd.field_talker);
        if (paramf != null) {
          this.zhC.dOu.dOB = paramf.adu();
        }
        this.zhC.dOu.dOC = com.tencent.mm.model.q.yS(this.dBd.field_talker);
        str = "";
        paramf = str;
        if (localb.dHv != null)
        {
          localdih = new dih();
          paramf = Base64.decode(localb.dHv, 0);
        }
      }
    }
    label1668:
    try
    {
      localdih.parseFrom(paramf);
      paramf = str;
      if (localdih.Hxc != null) {
        paramf = localdih.Hxc.ubt;
      }
    }
    catch (Exception paramf)
    {
      label1035:
      label1696:
      for (;;)
      {
        int i;
        int j;
        label991:
        boolean bool;
        int k;
        int m;
        label1663:
        paramf = str;
      }
    }
    localczj.Hqh = String.format(Locale.US, "prePublishId=%s&preUserName=%s&preChatName=%s&preChatType=%d&getA8KeyScene=%d&sourceAppId=%s", new Object[] { this.zhC.dOu.dOv, this.zhC.dOu.dOx, this.zhC.dOu.dOy, Integer.valueOf(x.aG(this.zhC.dOu.dOx, this.zhC.dOu.dOy)), Integer.valueOf(this.zhC.dOu.dOE), paramf });
    if ((localb1 != null) && (localb.type == 33))
    {
      this.ENq = new o();
      i = localb1.getInt("fromScene", 1);
      this.ENq.dkf.scene = i;
      j = localb1.getInt("appservicetype", 0);
      this.ENq.dkf.cmr = j;
      paramf = localb1.getString("preChatName", "");
      if (2 == i)
      {
        str = localb1.getString("preUsername", "");
        this.ENq.dkf.dkh = (paramf + ":" + str);
        paramf = this.dBd.field_talker;
        bool = localb1.getBoolean("moreRetrAction", false);
        if (!paramf.endsWith("@chatroom")) {
          break label1668;
        }
        paramf = this.ENq.dkf;
        if (!bool) {
          break label1663;
        }
        i = 5;
        paramf.action = i;
        this.ENq.dkf.dkg = (localb.hCz + 1);
        this.ENq.dkf.dki = localb.hCm;
        this.ENq.dkf.djX = localb.hCn;
        this.ENq.dkf.appId = localb.hCo;
        this.ENq.dkf.dkk = bt.aQJ();
        this.ENq.dkf.dkl = 1;
      }
    }
    else
    {
      ad.d("MicroMsg.NetSceneSendAppMsgForCdn", "stev summerbig SnsPostOperationFields: ShareUrlOriginal=%s, ShareUrlOpen=%s, JsAppId=%s", new Object[] { localb.dHr, localb.dHs, localb.dHt });
      k = 0;
      m = 0;
      j = m;
      i = k;
      if (!bt.isNullOrNil(this.dBd.field_imgPath))
      {
        paramf = com.tencent.mm.sdk.platformtools.g.aQc(com.tencent.mm.aw.q.aIF().Fm(this.dBd.field_imgPath));
        j = m;
        i = k;
        if (paramf != null)
        {
          i = paramf.outWidth;
          j = paramf.outHeight;
        }
      }
      if (this.gwW.XO())
      {
        ad.i("MicroMsg.NetSceneSendAppMsgForCdn", "summersafecdn app sceneResult crc[%d], safecdn[%b], hitcachetype[%d], aeskey[%s]", new Object[] { Integer.valueOf(this.gwW.field_filecrc), Boolean.valueOf(this.gwW.field_upload_by_safecdn), Integer.valueOf(this.gwW.field_UploadHitCacheType), this.gwW.field_aesKey });
        this.gwW.field_aesKey = "";
        localczj.Hqi = 1;
      }
      localczj.FOJ = this.gwW.field_filecrc;
      paramf = null;
      if (this.ENv) {
        paramf = "@cdn_" + this.gwW.field_fileId + "_" + this.gwW.field_aesKey + "_1";
      }
      localeq.hDa = k.b.a(localb, paramf, this.gwW, i, j);
      localczj.Hqf = localeq;
      if ((this.ENu != null) && ((localb.hzS != 0) || (localb.hzO > 26214400)))
      {
        localczj.jdf = this.ENu.field_signature;
        localczj.Fyv = com.tencent.mm.i.a.fIy;
      }
      localczj.Md5 = localb.filemd5;
      if (!bt.isNullOrNil(this.gwW.field_filemd5)) {
        break label1696;
      }
      ad.i("MicroMsg.NetSceneSendAppMsgForCdn", "summerbig sceneResult filemd5 is null use content.filemd5[%s]", new Object[] { localb.filemd5 });
    }
    for (;;)
    {
      if (((r)com.tencent.mm.kernel.g.ad(r.class)).ifAddTicketByActionFlag(this.dBd.field_talker)) {
        localczj.FOL = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().aTu(this.dBd.field_talker);
      }
      ad.i("MicroMsg.NetSceneSendAppMsgForCdn", "summerbig file md5[%s], HitMd5[%d], signature[%s], type[%d], sceneResult[%s], fromScene[%s]", new Object[] { localczj.Md5, Integer.valueOf(localczj.Hqi), bt.aRp(localczj.jdf), Integer.valueOf(localczj.Fyv), this.gwW, localczj.Hqh });
      i = dispatch(parame, this.rr, this);
      AppMethodBeat.o(31058);
      return i;
      localeq.Fvn = bl.VW();
      break;
      this.ENq.dkf.dkh = paramf;
      break label991;
      i = 2;
      break label1035;
      paramf = this.ENq.dkf;
      if (bool) {}
      for (i = 4;; i = 1)
      {
        paramf.action = i;
        break;
      }
      localczj.Md5 = this.gwW.field_filemd5;
    }
  }
  
  public final int getType()
  {
    return 222;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(31059);
    paramArrayOfByte = (czj)((com.tencent.mm.al.b)paramq).hNK.hNQ;
    ad.i("MicroMsg.NetSceneSendAppMsgForCdn", "summerbig cdntra onGYNetEnd [%d,%d,%s] msgId:%d, oldContent[%s], newContent[%s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Long.valueOf(this.msgId), this.dBd.field_content, paramArrayOfByte.Hqf.hDa });
    paramq = (czk)((com.tencent.mm.al.b)paramq).hNL.hNQ;
    if ((paramq != null) && ((paramInt2 == 4) || ((paramInt2 == 0) && (paramInt3 == 0)))) {
      ((r)com.tencent.mm.kernel.g.ad(r.class)).setEnSendMsgActionFlag(paramq.FOM);
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      if ((paramInt2 == 4) && (paramInt3 == 102))
      {
        ad.w("MicroMsg.NetSceneSendAppMsgForCdn", "summersafecdn MM_ERR_GET_AESKEY_FAILED");
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        this.ENw.dg(paramInt2, paramInt3);
        AppMethodBeat.o(31059);
        return;
      }
      this.dBd.setStatus(5);
      ba.aBQ();
      com.tencent.mm.model.c.azs().a(this.dBd.field_msgId, this.dBd);
      ad.e("MicroMsg.NetSceneSendAppMsgForCdn", "summerbig send app msg failed, err=" + paramInt2 + "," + paramInt3);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      this.ENw.dg(paramInt2, paramInt3);
      AppMethodBeat.o(31059);
      return;
    }
    ad.i("MicroMsg.NetSceneSendAppMsgForCdn", "summersafecdn svrid[%d]. aeskey[%s], old content[%s]", new Object[] { Long.valueOf(paramq.xbt), paramq.FOH, this.dBd.field_content });
    if ((this.gwW != null) && (this.gwW.XO()))
    {
      if (bt.isNullOrNil(paramq.FOH)) {
        break label749;
      }
      paramArrayOfByte = k.b.yr(this.dBd.field_content);
      paramArrayOfByte.gjI = paramq.FOH;
      this.dBd.setContent(k.b.a(paramArrayOfByte, null, null));
      ad.i("MicroMsg.NetSceneSendAppMsgForCdn", "summersafecdn aeskey[%s], new content[%s]", new Object[] { paramq.FOH, this.dBd.field_content });
    }
    for (;;)
    {
      this.dBd.setStatus(2);
      this.dBd.qz(paramq.xbt);
      ba.aBQ();
      com.tencent.mm.model.c.azs().a(this.dBd.field_msgId, this.dBd);
      ((com.tencent.mm.plugin.record.a.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.record.a.f.class)).yB(this.dBd.field_msgId);
      com.tencent.mm.modelstat.b.inZ.b(this.dBd, com.tencent.mm.ai.l.r(this.dBd));
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      this.ENw.dg(paramInt2, paramInt3);
      if ((this.zhC != null) && (!bt.isNullOrNil(this.zhC.dOu.url)))
      {
        this.zhC.dOu.dOw = ("msg_" + Long.toString(paramq.xbt));
        com.tencent.mm.sdk.b.a.IbL.l(this.zhC);
      }
      if (this.ENq != null)
      {
        this.ENq.dkf.dkj = ("msg_" + this.dBd.field_msgSvrId);
        com.tencent.mm.sdk.b.a.IbL.l(this.ENq);
      }
      paramString = k.b.yr(this.dBd.field_content);
      if ((paramString != null) && (w.zk(this.dBd.field_talker)))
      {
        paramq = (com.tencent.mm.ai.a)paramString.ao(com.tencent.mm.ai.a.class);
        if ((paramq != null) && (paramq.hyw)) {
          com.tencent.mm.chatroom.d.y.a(this.dBd, paramString);
        }
        if (aa.Yh()) {
          ((com.tencent.mm.chatroom.plugin.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.chatroom.plugin.a.class)).handleGroupToolByReceiverAppMsg(this.dBd);
        }
      }
      AppMethodBeat.o(31059);
      return;
      label749:
      ad.w("MicroMsg.NetSceneSendAppMsgForCdn", "summersafecdn need aeskey but ret null");
    }
  }
  
  public final n.b securityVerificationChecked(com.tencent.mm.network.q paramq)
  {
    return n.b.hOp;
  }
  
  static abstract interface a
  {
    public abstract void dg(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.ah
 * JD-Core Version:    0.7.0.1
 */