package com.tencent.mm.pluginsdk.model.app;

import android.graphics.BitmapFactory.Options;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.chatroom.d.aa;
import com.tencent.mm.g.a.o;
import com.tencent.mm.g.a.zq;
import com.tencent.mm.g.a.zq.a;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.i.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.m.a.a;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bn;
import com.tencent.mm.model.r;
import com.tencent.mm.model.v;
import com.tencent.mm.model.x;
import com.tencent.mm.model.z;
import com.tencent.mm.model.z.b;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.protocal.protobuf.dad;
import com.tencent.mm.protocal.protobuf.dae;
import com.tencent.mm.protocal.protobuf.dja;
import com.tencent.mm.protocal.protobuf.djc;
import com.tencent.mm.protocal.protobuf.eq;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bv;
import java.util.Locale;

public final class ah
  extends n
  implements k
{
  private a FfM;
  private o FfN;
  private c FfR;
  private boolean FfS;
  private a FfT;
  private com.tencent.mm.ak.f callback;
  private bv dCi;
  private int dGQ;
  private d gzD;
  private String mSessionId;
  private long msgId;
  private com.tencent.mm.ak.b rr;
  private zq zyr;
  
  public ah(long paramLong, d paramd, a parama, String paramString, int paramInt, a parama1)
  {
    this(paramLong, false, paramd, parama, paramString, null);
    this.dGQ = paramInt;
    this.FfM = parama1;
  }
  
  public ah(long paramLong, boolean paramBoolean, d paramd, a parama, String paramString, c paramc)
  {
    AppMethodBeat.i(31057);
    this.msgId = 0L;
    this.gzD = null;
    this.FfR = null;
    this.dCi = null;
    this.FfS = false;
    this.dGQ = 0;
    this.FfT = null;
    this.msgId = paramLong;
    this.mSessionId = paramString;
    this.gzD = paramd;
    this.FfT = parama;
    this.FfS = paramBoolean;
    this.FfR = paramc;
    parama = new b.a();
    parama.hQF = new dad();
    parama.hQG = new dae();
    parama.uri = "/cgi-bin/micromsg-bin/sendappmsg";
    parama.funcId = 222;
    parama.hQH = 107;
    parama.respCmdId = 1000000107;
    this.rr = parama.aDS();
    ae.i("MicroMsg.NetSceneSendAppMsgForCdn", "summerbig NetSceneSendAppMsgForCdn msgId[%d], sceneResult[%s], sessionId[%s], attachInfo[%s]. stack[%s]", new Object[] { Long.valueOf(paramLong), paramd, paramString, paramc, bu.fpN() });
    AppMethodBeat.o(31057);
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.f paramf)
  {
    AppMethodBeat.i(31058);
    this.callback = paramf;
    bc.aCg();
    this.dCi = com.tencent.mm.model.c.azI().ys(this.msgId);
    if ((this.dCi == null) || (this.dCi.field_msgId != this.msgId))
    {
      ae.e("MicroMsg.NetSceneSendAppMsgForCdn", "summerbig cdntra doscene msginfo null id:%d", new Object[] { Long.valueOf(this.msgId) });
      this.FfT.dg(3, -1);
      AppMethodBeat.o(31058);
      return -1;
    }
    k.b localb = k.b.zb(this.dCi.field_content);
    if (localb == null)
    {
      ae.e("MicroMsg.NetSceneSendAppMsgForCdn", "summerbig cdntra doscene AppMessage.Content.parse null id:%d", new Object[] { Long.valueOf(this.msgId) });
      this.FfT.dg(3, -1);
    }
    dad localdad = (dad)this.rr.hQD.hQJ;
    eq localeq = new eq();
    localeq.ikm = localb.appId;
    localeq.FOR = (this.dCi.field_talker + this.dCi.field_msgId + "T" + this.dCi.field_createTime);
    localeq.CreateTime = ((int)bu.aRi());
    localeq.uvF = this.dCi.field_talker;
    localeq.uvG = v.aAC();
    localeq.nJA = localb.type;
    localeq.FOQ = localb.sdkVer;
    localeq.ucK = localb.hCF;
    paramf = a.a.ZP().o(this.dCi);
    z.b localb1;
    djc localdjc;
    if (!bu.isNullOrNil(paramf))
    {
      localeq.FNL = paramf;
      localeq.FOU = localb.dIw;
      localeq.FOV = localb.dIx;
      localeq.FOW = localb.dIy;
      if (this.FfM != null)
      {
        localeq.FOX = this.FfM.FeS;
        localeq.uqs = this.FfM.dGI;
      }
      localdad.HJL = this.dGQ;
      localb1 = z.aBG().Bq(this.mSessionId);
      if (localb1 != null)
      {
        this.zyr = new zq();
        this.zyr.dPK.url = localb.url;
        this.zyr.dPK.dPL = localb1.getString("prePublishId", "");
        this.zyr.dPK.dPN = localb1.getString("preUsername", "");
        this.zyr.dPK.dPO = localb1.getString("preChatName", "");
        this.zyr.dPK.dPP = localb1.getInt("preMsgIndex", 0);
        this.zyr.dPK.dPT = localb1.getInt("sendAppMsgScene", 0);
        this.zyr.dPK.dPU = localb1.getInt("getA8KeyScene", 0);
        this.zyr.dPK.dPV = localb1.getString("referUrl", null);
        this.zyr.dPK.dPW = localb1.getString("adExtStr", null);
        this.zyr.dPK.dPQ = this.dCi.field_talker;
        this.zyr.dPK.dPX = localb.title;
        this.zyr.dPK.dPZ = localb.description;
        bc.aCg();
        paramf = com.tencent.mm.model.c.azF().BH(this.dCi.field_talker);
        if (paramf != null) {
          this.zyr.dPK.dPR = paramf.adF();
        }
        this.zyr.dPK.dPS = r.zC(this.dCi.field_talker);
        str = "";
        paramf = str;
        if (localb.dIA != null)
        {
          localdjc = new djc();
          paramf = Base64.decode(localb.dIA, 0);
        }
      }
    }
    label1668:
    try
    {
      localdjc.parseFrom(paramf);
      paramf = str;
      if (localdjc.HQL != null) {
        paramf = localdjc.HQL.umv;
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
    localdad.HJJ = String.format(Locale.US, "prePublishId=%s&preUserName=%s&preChatName=%s&preChatType=%d&getA8KeyScene=%d&sourceAppId=%s", new Object[] { this.zyr.dPK.dPL, this.zyr.dPK.dPN, this.zyr.dPK.dPO, Integer.valueOf(com.tencent.mm.model.y.aH(this.zyr.dPK.dPN, this.zyr.dPK.dPO)), Integer.valueOf(this.zyr.dPK.dPU), paramf });
    if ((localb1 != null) && (localb.type == 33))
    {
      this.FfN = new o();
      i = localb1.getInt("fromScene", 1);
      this.FfN.dlh.scene = i;
      j = localb1.getInt("appservicetype", 0);
      this.FfN.dlh.cmt = j;
      paramf = localb1.getString("preChatName", "");
      if (2 == i)
      {
        str = localb1.getString("preUsername", "");
        this.FfN.dlh.dlj = (paramf + ":" + str);
        paramf = this.dCi.field_talker;
        bool = localb1.getBoolean("moreRetrAction", false);
        if (!paramf.endsWith("@chatroom")) {
          break label1668;
        }
        paramf = this.FfN.dlh;
        if (!bool) {
          break label1663;
        }
        i = 5;
        paramf.action = i;
        this.FfN.dlh.dli = (localb.hFr + 1);
        this.FfN.dlh.dlk = localb.hFb;
        this.FfN.dlh.dkZ = localb.hFc;
        this.FfN.dlh.appId = localb.hFd;
        this.FfN.dlh.dlm = bu.aRi();
        this.FfN.dlh.dln = 1;
      }
    }
    else
    {
      ae.d("MicroMsg.NetSceneSendAppMsgForCdn", "stev summerbig SnsPostOperationFields: ShareUrlOriginal=%s, ShareUrlOpen=%s, JsAppId=%s", new Object[] { localb.dIw, localb.dIx, localb.dIy });
      k = 0;
      m = 0;
      j = m;
      i = k;
      if (!bu.isNullOrNil(this.dCi.field_imgPath))
      {
        paramf = h.aRz(com.tencent.mm.av.q.aIX().FO(this.dCi.field_imgPath));
        j = m;
        i = k;
        if (paramf != null)
        {
          i = paramf.outWidth;
          j = paramf.outHeight;
        }
      }
      if (this.gzD.XY())
      {
        ae.i("MicroMsg.NetSceneSendAppMsgForCdn", "summersafecdn app sceneResult crc[%d], safecdn[%b], hitcachetype[%d], aeskey[%s]", new Object[] { Integer.valueOf(this.gzD.field_filecrc), Boolean.valueOf(this.gzD.field_upload_by_safecdn), Integer.valueOf(this.gzD.field_UploadHitCacheType), this.gzD.field_aesKey });
        this.gzD.field_aesKey = "";
        localdad.HJK = 1;
      }
      localdad.Ghi = this.gzD.field_filecrc;
      paramf = null;
      if (this.FfS) {
        paramf = "@cdn_" + this.gzD.field_fileId + "_" + this.gzD.field_aesKey + "_1";
      }
      localeq.hFS = k.b.a(localb, paramf, this.gzD, i, j);
      localdad.HJH = localeq;
      if ((this.FfR != null) && ((localb.hCG != 0) || (localb.hCC > 26214400)))
      {
        localdad.jfY = this.FfR.field_signature;
        localdad.FQT = com.tencent.mm.i.a.fKC;
      }
      localdad.Md5 = localb.filemd5;
      if (!bu.isNullOrNil(this.gzD.field_filemd5)) {
        break label1696;
      }
      ae.i("MicroMsg.NetSceneSendAppMsgForCdn", "summerbig sceneResult filemd5 is null use content.filemd5[%s]", new Object[] { localb.filemd5 });
    }
    for (;;)
    {
      if (((s)g.ad(s.class)).ifAddTicketByActionFlag(this.dCi.field_talker)) {
        localdad.Ghk = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().aUV(this.dCi.field_talker);
      }
      ae.i("MicroMsg.NetSceneSendAppMsgForCdn", "summerbig file md5[%s], HitMd5[%d], signature[%s], type[%d], sceneResult[%s], fromScene[%s]", new Object[] { localdad.Md5, Integer.valueOf(localdad.HJK), bu.aSM(localdad.jfY), Integer.valueOf(localdad.FQT), this.gzD, localdad.HJJ });
      i = dispatch(parame, this.rr, this);
      AppMethodBeat.o(31058);
      return i;
      localeq.FNL = bn.We();
      break;
      this.FfN.dlh.dlj = paramf;
      break label991;
      i = 2;
      break label1035;
      paramf = this.FfN.dlh;
      if (bool) {}
      for (i = 4;; i = 1)
      {
        paramf.action = i;
        break;
      }
      localdad.Md5 = this.gzD.field_filemd5;
    }
  }
  
  public final int getType()
  {
    return 222;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(31059);
    paramArrayOfByte = (dad)((com.tencent.mm.ak.b)paramq).hQD.hQJ;
    ae.i("MicroMsg.NetSceneSendAppMsgForCdn", "summerbig cdntra onGYNetEnd [%d,%d,%s] msgId:%d, oldContent[%s], newContent[%s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Long.valueOf(this.msgId), this.dCi.field_content, paramArrayOfByte.HJH.hFS });
    paramq = (dae)((com.tencent.mm.ak.b)paramq).hQE.hQJ;
    if ((paramq != null) && ((paramInt2 == 4) || ((paramInt2 == 0) && (paramInt3 == 0)))) {
      ((s)g.ad(s.class)).setEnSendMsgActionFlag(paramq.Ghl);
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      if ((paramInt2 == 4) && (paramInt3 == 102))
      {
        ae.w("MicroMsg.NetSceneSendAppMsgForCdn", "summersafecdn MM_ERR_GET_AESKEY_FAILED");
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        this.FfT.dg(paramInt2, paramInt3);
        AppMethodBeat.o(31059);
        return;
      }
      this.dCi.setStatus(5);
      bc.aCg();
      com.tencent.mm.model.c.azI().a(this.dCi.field_msgId, this.dCi);
      ae.e("MicroMsg.NetSceneSendAppMsgForCdn", "summerbig send app msg failed, err=" + paramInt2 + "," + paramInt3);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      this.FfT.dg(paramInt2, paramInt3);
      AppMethodBeat.o(31059);
      return;
    }
    ae.i("MicroMsg.NetSceneSendAppMsgForCdn", "summersafecdn svrid[%d]. aeskey[%s], old content[%s]", new Object[] { Long.valueOf(paramq.xrk), paramq.Ghg, this.dCi.field_content });
    if ((this.gzD != null) && (this.gzD.XY()))
    {
      if (bu.isNullOrNil(paramq.Ghg)) {
        break label749;
      }
      paramArrayOfByte = k.b.zb(this.dCi.field_content);
      paramArrayOfByte.gmb = paramq.Ghg;
      this.dCi.setContent(k.b.a(paramArrayOfByte, null, null));
      ae.i("MicroMsg.NetSceneSendAppMsgForCdn", "summersafecdn aeskey[%s], new content[%s]", new Object[] { paramq.Ghg, this.dCi.field_content });
    }
    for (;;)
    {
      this.dCi.setStatus(2);
      this.dCi.qM(paramq.xrk);
      bc.aCg();
      com.tencent.mm.model.c.azI().a(this.dCi.field_msgId, this.dCi);
      ((com.tencent.mm.plugin.record.a.f)g.ab(com.tencent.mm.plugin.record.a.f.class)).za(this.dCi.field_msgId);
      com.tencent.mm.modelstat.b.iqT.b(this.dCi, com.tencent.mm.ah.l.r(this.dCi));
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      this.FfT.dg(paramInt2, paramInt3);
      if ((this.zyr != null) && (!bu.isNullOrNil(this.zyr.dPK.url)))
      {
        this.zyr.dPK.dPM = ("msg_" + Long.toString(paramq.xrk));
        com.tencent.mm.sdk.b.a.IvT.l(this.zyr);
      }
      if (this.FfN != null)
      {
        this.FfN.dlh.dll = ("msg_" + this.dCi.field_msgSvrId);
        com.tencent.mm.sdk.b.a.IvT.l(this.FfN);
      }
      paramString = k.b.zb(this.dCi.field_content);
      if ((paramString != null) && (x.zU(this.dCi.field_talker)))
      {
        paramq = (com.tencent.mm.ah.a)paramString.ao(com.tencent.mm.ah.a.class);
        if ((paramq != null) && (paramq.hBk)) {
          com.tencent.mm.chatroom.d.y.a(this.dCi, paramString);
        }
        if (aa.Yr()) {
          ((com.tencent.mm.chatroom.plugin.a)g.ad(com.tencent.mm.chatroom.plugin.a.class)).handleGroupToolByReceiverAppMsg(this.dCi);
        }
      }
      AppMethodBeat.o(31059);
      return;
      label749:
      ae.w("MicroMsg.NetSceneSendAppMsgForCdn", "summersafecdn need aeskey but ret null");
    }
  }
  
  public final n.b securityVerificationChecked(com.tencent.mm.network.q paramq)
  {
    return n.b.hRi;
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