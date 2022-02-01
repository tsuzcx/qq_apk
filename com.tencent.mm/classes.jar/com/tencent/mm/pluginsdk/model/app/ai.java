package com.tencent.mm.pluginsdk.model.app;

import android.graphics.BitmapFactory.Options;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.ah.l;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.chatroom.d.aa;
import com.tencent.mm.g.a.yq;
import com.tencent.mm.g.a.yq.a;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.i.d;
import com.tencent.mm.l.a.a;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bk;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.model.x;
import com.tencent.mm.model.y.b;
import com.tencent.mm.network.e;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.protocal.protobuf.ctz;
import com.tencent.mm.protocal.protobuf.cua;
import com.tencent.mm.protocal.protobuf.dcs;
import com.tencent.mm.protocal.protobuf.dcu;
import com.tencent.mm.protocal.protobuf.em;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bo;
import java.util.Locale;

public final class ai
  extends n
  implements com.tencent.mm.network.k
{
  private a DiC;
  private com.tencent.mm.g.a.o DiD;
  private c DiH;
  private boolean DiI;
  private a DiJ;
  private com.tencent.mm.ak.g callback;
  private bo dpq;
  private int dtL;
  private d gdm;
  private String mSessionId;
  private long msgId;
  private com.tencent.mm.ak.b rr;
  private yq xRI;
  
  public ai(long paramLong, d paramd, a parama, String paramString, int paramInt, a parama1)
  {
    this(paramLong, false, paramd, parama, paramString, null);
    this.dtL = paramInt;
    this.DiC = parama1;
  }
  
  public ai(long paramLong, boolean paramBoolean, d paramd, a parama, String paramString, c paramc)
  {
    AppMethodBeat.i(31057);
    this.msgId = 0L;
    this.gdm = null;
    this.DiH = null;
    this.dpq = null;
    this.DiI = false;
    this.dtL = 0;
    this.DiJ = null;
    this.msgId = paramLong;
    this.mSessionId = paramString;
    this.gdm = paramd;
    this.DiJ = parama;
    this.DiI = paramBoolean;
    this.DiH = paramc;
    parama = new b.a();
    parama.hvt = new ctz();
    parama.hvu = new cua();
    parama.uri = "/cgi-bin/micromsg-bin/sendappmsg";
    parama.funcId = 222;
    parama.reqCmdId = 107;
    parama.respCmdId = 1000000107;
    this.rr = parama.aAz();
    ac.i("MicroMsg.NetSceneSendAppMsgForCdn", "summerbig NetSceneSendAppMsgForCdn msgId[%d], sceneResult[%s], sessionId[%s], attachInfo[%s]. stack[%s]", new Object[] { Long.valueOf(paramLong), paramd, paramString, paramc, bs.eWi() });
    AppMethodBeat.o(31057);
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(31058);
    this.callback = paramg;
    az.ayM();
    this.dpq = com.tencent.mm.model.c.awD().vP(this.msgId);
    if ((this.dpq == null) || (this.dpq.field_msgId != this.msgId))
    {
      ac.e("MicroMsg.NetSceneSendAppMsgForCdn", "summerbig cdntra doscene msginfo null id:%d", new Object[] { Long.valueOf(this.msgId) });
      this.DiJ.dm(3, -1);
      AppMethodBeat.o(31058);
      return -1;
    }
    k.b localb = k.b.vA(this.dpq.field_content);
    if (localb == null)
    {
      ac.e("MicroMsg.NetSceneSendAppMsgForCdn", "summerbig cdntra doscene AppMessage.Content.parse null id:%d", new Object[] { Long.valueOf(this.msgId) });
      this.DiJ.dm(3, -1);
    }
    ctz localctz = (ctz)this.rr.hvr.hvw;
    em localem = new em();
    localem.hOf = localb.appId;
    localem.DRb = (this.dpq.field_talker + this.dpq.field_msgId + "T" + this.dpq.field_createTime);
    localem.CreateTime = ((int)bs.aNx());
    localem.tlJ = this.dpq.field_talker;
    localem.tlK = u.axw();
    localem.ndI = localb.type;
    localem.DRa = localb.sdkVer;
    localem.sVo = localb.hhI;
    paramg = a.a.Xf().o(this.dpq);
    y.b localb1;
    dcu localdcu;
    if (!bs.isNullOrNil(paramg))
    {
      localem.DPY = paramg;
      localem.DRe = localb.dvo;
      localem.DRf = localb.dvp;
      localem.DRg = localb.dvq;
      if (this.DiC != null)
      {
        localem.DRh = this.DiC.DhJ;
        localem.thr = this.DiC.dtC;
      }
      localctz.FFK = this.dtL;
      localb1 = com.tencent.mm.model.y.ayq().xI(this.mSessionId);
      if (localb1 != null)
      {
        this.xRI = new yq();
        this.xRI.dCh.url = localb.url;
        this.xRI.dCh.dCi = localb1.getString("prePublishId", "");
        this.xRI.dCh.dCk = localb1.getString("preUsername", "");
        this.xRI.dCh.dCl = localb1.getString("preChatName", "");
        this.xRI.dCh.dCm = localb1.getInt("preMsgIndex", 0);
        this.xRI.dCh.dCq = localb1.getInt("sendAppMsgScene", 0);
        this.xRI.dCh.dCr = localb1.getInt("getA8KeyScene", 0);
        this.xRI.dCh.dCs = localb1.getString("referUrl", null);
        this.xRI.dCh.dCt = localb1.getString("adExtStr", null);
        this.xRI.dCh.dCn = this.dpq.field_talker;
        this.xRI.dCh.dCu = localb.title;
        this.xRI.dCh.dCw = localb.description;
        az.ayM();
        paramg = com.tencent.mm.model.c.awB().aNt(this.dpq.field_talker);
        if (paramg != null) {
          this.xRI.dCh.dCo = paramg.aaR();
        }
        this.xRI.dCh.dCp = com.tencent.mm.model.q.wb(this.dpq.field_talker);
        str = "";
        paramg = str;
        if (localb.dvs != null)
        {
          localdcu = new dcu();
          paramg = Base64.decode(localb.dvs, 0);
        }
      }
    }
    label1668:
    try
    {
      localdcu.parseFrom(paramg);
      paramg = str;
      if (localdcu.FMu != null) {
        paramg = localdcu.FMu.tdD;
      }
    }
    catch (Exception paramg)
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
        paramg = str;
      }
    }
    localctz.FFI = String.format(Locale.US, "prePublishId=%s&preUserName=%s&preChatName=%s&preChatType=%d&getA8KeyScene=%d&sourceAppId=%s", new Object[] { this.xRI.dCh.dCi, this.xRI.dCh.dCk, this.xRI.dCh.dCl, Integer.valueOf(x.aE(this.xRI.dCh.dCk, this.xRI.dCh.dCl)), Integer.valueOf(this.xRI.dCh.dCr), paramg });
    if ((localb1 != null) && (localb.type == 33))
    {
      this.DiD = new com.tencent.mm.g.a.o();
      i = localb1.getInt("fromScene", 1);
      this.DiD.cYN.scene = i;
      j = localb1.getInt("appservicetype", 0);
      this.DiD.cYN.cca = j;
      paramg = localb1.getString("preChatName", "");
      if (2 == i)
      {
        str = localb1.getString("preUsername", "");
        this.DiD.cYN.cYP = (paramg + ":" + str);
        paramg = this.dpq.field_talker;
        bool = localb1.getBoolean("moreRetrAction", false);
        if (!paramg.endsWith("@chatroom")) {
          break label1668;
        }
        paramg = this.DiD.cYN;
        if (!bool) {
          break label1663;
        }
        i = 5;
        paramg.action = i;
        this.DiD.cYN.cYO = (localb.hkq + 1);
        this.DiD.cYN.cYQ = localb.hkd;
        this.DiD.cYN.cYF = localb.hke;
        this.DiD.cYN.appId = localb.hkf;
        this.DiD.cYN.cYS = bs.aNx();
        this.DiD.cYN.cYT = 1;
      }
    }
    else
    {
      ac.d("MicroMsg.NetSceneSendAppMsgForCdn", "stev summerbig SnsPostOperationFields: ShareUrlOriginal=%s, ShareUrlOpen=%s, JsAppId=%s", new Object[] { localb.dvo, localb.dvp, localb.dvq });
      k = 0;
      m = 0;
      j = m;
      i = k;
      if (!bs.isNullOrNil(this.dpq.field_imgPath))
      {
        paramg = f.aKw(com.tencent.mm.av.o.aFx().Cl(this.dpq.field_imgPath));
        j = m;
        i = k;
        if (paramg != null)
        {
          i = paramg.outWidth;
          j = paramg.outHeight;
        }
      }
      if (this.gdm.Vx())
      {
        ac.i("MicroMsg.NetSceneSendAppMsgForCdn", "summersafecdn app sceneResult crc[%d], safecdn[%b], hitcachetype[%d], aeskey[%s]", new Object[] { Integer.valueOf(this.gdm.field_filecrc), Boolean.valueOf(this.gdm.field_upload_by_safecdn), Integer.valueOf(this.gdm.field_UploadHitCacheType), this.gdm.field_aesKey });
        this.gdm.field_aesKey = "";
        localctz.FFJ = 1;
      }
      localctz.EhC = this.gdm.field_filecrc;
      paramg = null;
      if (this.DiI) {
        paramg = "@cdn_" + this.gdm.field_fileId + "_" + this.gdm.field_aesKey + "_1";
      }
      localem.hkR = k.b.a(localb, paramg, this.gdm, i, j);
      localctz.FFG = localem;
      if ((this.DiH != null) && ((localb.hhJ != 0) || (localb.hhF > 26214400)))
      {
        localctz.iJW = this.DiH.field_signature;
        localctz.DTc = com.tencent.mm.i.a.fqr;
      }
      localctz.Md5 = localb.filemd5;
      if (!bs.isNullOrNil(this.gdm.field_filemd5)) {
        break label1696;
      }
      ac.i("MicroMsg.NetSceneSendAppMsgForCdn", "summerbig sceneResult filemd5 is null use content.filemd5[%s]", new Object[] { localb.filemd5 });
    }
    for (;;)
    {
      if (((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).ifAddTicketByActionFlag(this.dpq.field_talker)) {
        localctz.EhE = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aND(this.dpq.field_talker);
      }
      ac.i("MicroMsg.NetSceneSendAppMsgForCdn", "summerbig file md5[%s], HitMd5[%d], signature[%s], type[%d], sceneResult[%s], fromScene[%s]", new Object[] { localctz.Md5, Integer.valueOf(localctz.FFJ), bs.aLJ(localctz.iJW), Integer.valueOf(localctz.DTc), this.gdm, localctz.FFI });
      i = dispatch(parame, this.rr, this);
      AppMethodBeat.o(31058);
      return i;
      localem.DPY = bk.TG();
      break;
      this.DiD.cYN.cYP = paramg;
      break label991;
      i = 2;
      break label1035;
      paramg = this.DiD.cYN;
      if (bool) {}
      for (i = 4;; i = 1)
      {
        paramg.action = i;
        break;
      }
      localctz.Md5 = this.gdm.field_filemd5;
    }
  }
  
  public final int getType()
  {
    return 222;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(31059);
    paramArrayOfByte = (ctz)((com.tencent.mm.ak.b)paramq).hvr.hvw;
    ac.i("MicroMsg.NetSceneSendAppMsgForCdn", "summerbig cdntra onGYNetEnd [%d,%d,%s] msgId:%d, oldContent[%s], newContent[%s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Long.valueOf(this.msgId), this.dpq.field_content, paramArrayOfByte.FFG.hkR });
    paramq = (cua)((com.tencent.mm.ak.b)paramq).hvs.hvw;
    if ((paramq != null) && ((paramInt2 == 4) || ((paramInt2 == 0) && (paramInt3 == 0)))) {
      ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).setEnSendMsgActionFlag(paramq.EhF);
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      if ((paramInt2 == 4) && (paramInt3 == 102))
      {
        ac.w("MicroMsg.NetSceneSendAppMsgForCdn", "summersafecdn MM_ERR_GET_AESKEY_FAILED");
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        this.DiJ.dm(paramInt2, paramInt3);
        AppMethodBeat.o(31059);
        return;
      }
      this.dpq.setStatus(5);
      az.ayM();
      com.tencent.mm.model.c.awD().a(this.dpq.field_msgId, this.dpq);
      ac.e("MicroMsg.NetSceneSendAppMsgForCdn", "summerbig send app msg failed, err=" + paramInt2 + "," + paramInt3);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      this.DiJ.dm(paramInt2, paramInt3);
      AppMethodBeat.o(31059);
      return;
    }
    ac.i("MicroMsg.NetSceneSendAppMsgForCdn", "summersafecdn svrid[%d]. aeskey[%s], old content[%s]", new Object[] { Long.valueOf(paramq.vTQ), paramq.EhA, this.dpq.field_content });
    if ((this.gdm != null) && (this.gdm.Vx()))
    {
      if (bs.isNullOrNil(paramq.EhA)) {
        break label728;
      }
      paramArrayOfByte = k.b.vA(this.dpq.field_content);
      paramArrayOfByte.fQi = paramq.EhA;
      this.dpq.setContent(k.b.a(paramArrayOfByte, null, null));
      ac.i("MicroMsg.NetSceneSendAppMsgForCdn", "summersafecdn aeskey[%s], new content[%s]", new Object[] { paramq.EhA, this.dpq.field_content });
    }
    for (;;)
    {
      this.dpq.setStatus(2);
      this.dpq.oz(paramq.vTQ);
      az.ayM();
      com.tencent.mm.model.c.awD().a(this.dpq.field_msgId, this.dpq);
      com.tencent.mm.modelstat.b.hUE.b(this.dpq, l.r(this.dpq));
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      this.DiJ.dm(paramInt2, paramInt3);
      if ((this.xRI != null) && (!bs.isNullOrNil(this.xRI.dCh.url)))
      {
        this.xRI.dCh.dCj = ("msg_" + Long.toString(paramq.vTQ));
        com.tencent.mm.sdk.b.a.GpY.l(this.xRI);
      }
      if (this.DiD != null)
      {
        this.DiD.cYN.cYR = ("msg_" + this.dpq.field_msgSvrId);
        com.tencent.mm.sdk.b.a.GpY.l(this.DiD);
      }
      paramString = k.b.vA(this.dpq.field_content);
      if ((paramString != null) && (w.wp(this.dpq.field_talker)))
      {
        paramq = (com.tencent.mm.ah.a)paramString.ao(com.tencent.mm.ah.a.class);
        if ((paramq != null) && (paramq.hgn)) {
          com.tencent.mm.chatroom.d.y.a(this.dpq, paramString);
        }
        if (aa.VQ()) {
          ((com.tencent.mm.chatroom.plugin.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.chatroom.plugin.a.class)).handleGroupToolByReceiverAppMsg(this.dpq);
        }
      }
      AppMethodBeat.o(31059);
      return;
      label728:
      ac.w("MicroMsg.NetSceneSendAppMsgForCdn", "summersafecdn need aeskey but ret null");
    }
  }
  
  public final n.b securityVerificationChecked(com.tencent.mm.network.q paramq)
  {
    return n.b.hwa;
  }
  
  static abstract interface a
  {
    public abstract void dm(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.ai
 * JD-Core Version:    0.7.0.1
 */