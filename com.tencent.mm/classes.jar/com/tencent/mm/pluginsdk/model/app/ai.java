package com.tencent.mm.pluginsdk.model.app;

import android.graphics.BitmapFactory.Options;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.ai.l;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.n.b;
import com.tencent.mm.chatroom.d.aa;
import com.tencent.mm.g.a.yf;
import com.tencent.mm.g.a.yf.a;
import com.tencent.mm.g.c.du;
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
import com.tencent.mm.protocal.protobuf.cos;
import com.tencent.mm.protocal.protobuf.cot;
import com.tencent.mm.protocal.protobuf.cxg;
import com.tencent.mm.protocal.protobuf.cxi;
import com.tencent.mm.protocal.protobuf.ek;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bl;
import java.util.Locale;

public final class ai
  extends n
  implements com.tencent.mm.network.k
{
  private a BQo;
  private com.tencent.mm.g.a.o BQp;
  private c BQt;
  private ai.a BQu;
  private com.tencent.mm.al.g callback;
  private bl drF;
  private int dvY;
  private d fYG;
  private boolean ghP;
  private String mSessionId;
  private long msgId;
  private com.tencent.mm.al.b rr;
  private yf wFo;
  
  public ai(long paramLong, d paramd, ai.a parama, String paramString, int paramInt, a parama1)
  {
    this(paramLong, false, paramd, parama, paramString, null);
    this.dvY = paramInt;
    this.BQo = parama1;
  }
  
  public ai(long paramLong, boolean paramBoolean, d paramd, ai.a parama, String paramString, c paramc)
  {
    AppMethodBeat.i(31057);
    this.msgId = 0L;
    this.fYG = null;
    this.BQt = null;
    this.drF = null;
    this.ghP = false;
    this.dvY = 0;
    this.BQu = null;
    this.msgId = paramLong;
    this.mSessionId = paramString;
    this.fYG = paramd;
    this.BQu = parama;
    this.ghP = paramBoolean;
    this.BQt = paramc;
    parama = new b.a();
    parama.gUU = new cos();
    parama.gUV = new cot();
    parama.uri = "/cgi-bin/micromsg-bin/sendappmsg";
    parama.funcId = 222;
    parama.reqCmdId = 107;
    parama.respCmdId = 1000000107;
    this.rr = parama.atI();
    ad.i("MicroMsg.NetSceneSendAppMsgForCdn", "summerbig NetSceneSendAppMsgForCdn msgId[%d], sceneResult[%s], sessionId[%s], attachInfo[%s]. stack[%s]", new Object[] { Long.valueOf(paramLong), paramd, paramString, paramc, bt.eGN() });
    AppMethodBeat.o(31057);
  }
  
  public final int doScene(e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(31058);
    this.callback = paramg;
    az.arV();
    this.drF = com.tencent.mm.model.c.apO().rm(this.msgId);
    if ((this.drF == null) || (this.drF.field_msgId != this.msgId))
    {
      ad.e("MicroMsg.NetSceneSendAppMsgForCdn", "summerbig cdntra doscene msginfo null id:%d", new Object[] { Long.valueOf(this.msgId) });
      this.BQu.dm(3, -1);
      AppMethodBeat.o(31058);
      return -1;
    }
    k.b localb = k.b.rx(this.drF.field_content);
    if (localb == null)
    {
      ad.e("MicroMsg.NetSceneSendAppMsgForCdn", "summerbig cdntra doscene AppMessage.Content.parse null id:%d", new Object[] { Long.valueOf(this.msgId) });
      this.BQu.dm(3, -1);
    }
    cos localcos = (cos)this.rr.gUS.gUX;
    ek localek = new ek();
    localek.hnC = localb.appId;
    localek.CyF = (this.drF.field_talker + this.drF.field_msgId + "T" + this.drF.field_createTime);
    localek.CreateTime = ((int)bt.aGK());
    localek.sdP = this.drF.field_talker;
    localek.sdQ = u.aqG();
    localek.mBH = localb.type;
    localek.CyE = localb.sdkVer;
    localek.rNz = localb.gHh;
    paramg = a.a.Wh().o(this.drF);
    y.b localb1;
    cxi localcxi;
    if (!bt.isNullOrNil(paramg))
    {
      localek.CxC = paramg;
      localek.CyI = localb.dxC;
      localek.CyJ = localb.dxD;
      localek.CyK = localb.dxE;
      if (this.BQo != null)
      {
        localek.CyL = this.BQo.BPv;
        localek.rZy = this.BQo.dvP;
      }
      localcos.EiM = this.dvY;
      localb1 = com.tencent.mm.model.y.arz().tC(this.mSessionId);
      if (localb1 != null)
      {
        this.wFo = new yf();
        this.wFo.dEv.url = localb.url;
        this.wFo.dEv.dEw = localb1.getString("prePublishId", "");
        this.wFo.dEv.dEy = localb1.getString("preUsername", "");
        this.wFo.dEv.dEz = localb1.getString("preChatName", "");
        this.wFo.dEv.dEA = localb1.getInt("preMsgIndex", 0);
        this.wFo.dEv.dEE = localb1.getInt("sendAppMsgScene", 0);
        this.wFo.dEv.dEF = localb1.getInt("getA8KeyScene", 0);
        this.wFo.dEv.dEG = localb1.getString("referUrl", null);
        this.wFo.dEv.dEH = localb1.getString("adExtStr", null);
        this.wFo.dEv.dEB = this.drF.field_talker;
        this.wFo.dEv.dEI = localb.title;
        this.wFo.dEv.dEK = localb.description;
        az.arV();
        paramg = com.tencent.mm.model.c.apM().aHY(this.drF.field_talker);
        if (paramg != null) {
          this.wFo.dEv.dEC = paramg.ZW();
        }
        this.wFo.dEv.dED = com.tencent.mm.model.q.rY(this.drF.field_talker);
        str = "";
        paramg = str;
        if (localb.dxG != null)
        {
          localcxi = new cxi();
          paramg = Base64.decode(localb.dxG, 0);
        }
      }
    }
    label1668:
    try
    {
      localcxi.parseFrom(paramg);
      paramg = str;
      if (localcxi.Epv != null) {
        paramg = localcxi.Epv.rVL;
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
    localcos.EiK = String.format(Locale.US, "prePublishId=%s&preUserName=%s&preChatName=%s&preChatType=%d&getA8KeyScene=%d&sourceAppId=%s", new Object[] { this.wFo.dEv.dEw, this.wFo.dEv.dEy, this.wFo.dEv.dEz, Integer.valueOf(x.aw(this.wFo.dEv.dEy, this.wFo.dEv.dEz)), Integer.valueOf(this.wFo.dEv.dEF), paramg });
    if ((localb1 != null) && (localb.type == 33))
    {
      this.BQp = new com.tencent.mm.g.a.o();
      i = localb1.getInt("fromScene", 1);
      this.BQp.dbr.scene = i;
      j = localb1.getInt("appservicetype", 0);
      this.BQp.dbr.cfd = j;
      paramg = localb1.getString("preChatName", "");
      if (2 == i)
      {
        str = localb1.getString("preUsername", "");
        this.BQp.dbr.dbt = (paramg + ":" + str);
        paramg = this.drF.field_talker;
        bool = localb1.getBoolean("moreRetrAction", false);
        if (!paramg.endsWith("@chatroom")) {
          break label1668;
        }
        paramg = this.BQp.dbr;
        if (!bool) {
          break label1663;
        }
        i = 5;
        paramg.action = i;
        this.BQp.dbr.dbs = (localb.gJQ + 1);
        this.BQp.dbr.dbu = localb.gJD;
        this.BQp.dbr.dbj = localb.gJE;
        this.BQp.dbr.appId = localb.gJF;
        this.BQp.dbr.actionTime = bt.aGK();
        this.BQp.dbr.dbw = 1;
      }
    }
    else
    {
      ad.d("MicroMsg.NetSceneSendAppMsgForCdn", "stev summerbig SnsPostOperationFields: ShareUrlOriginal=%s, ShareUrlOpen=%s, JsAppId=%s", new Object[] { localb.dxC, localb.dxD, localb.dxE });
      k = 0;
      m = 0;
      j = m;
      i = k;
      if (!bt.isNullOrNil(this.drF.field_imgPath))
      {
        paramg = f.aFf(com.tencent.mm.aw.o.ayF().yg(this.drF.field_imgPath));
        j = m;
        i = k;
        if (paramg != null)
        {
          i = paramg.outWidth;
          j = paramg.outHeight;
        }
      }
      if (this.fYG.UC())
      {
        ad.i("MicroMsg.NetSceneSendAppMsgForCdn", "summersafecdn app sceneResult crc[%d], safecdn[%b], hitcachetype[%d], aeskey[%s]", new Object[] { Integer.valueOf(this.fYG.field_filecrc), Boolean.valueOf(this.fYG.field_upload_by_safecdn), Integer.valueOf(this.fYG.field_UploadHitCacheType), this.fYG.field_aesKey });
        this.fYG.field_aesKey = "";
        localcos.EiL = 1;
      }
      localcos.COR = this.fYG.field_filecrc;
      paramg = null;
      if (this.ghP) {
        paramg = "@cdn_" + this.fYG.field_fileId + "_" + this.fYG.field_aesKey + "_1";
      }
      localek.gKr = k.b.a(localb, paramg, this.fYG, i, j);
      localcos.EiI = localek;
      if ((this.BQt != null) && ((localb.gHi != 0) || (localb.gHe > 26214400)))
      {
        localcos.ijP = this.BQt.field_signature;
        localcos.CAG = com.tencent.mm.i.a.fmX;
      }
      localcos.Md5 = localb.filemd5;
      if (!bt.isNullOrNil(this.fYG.field_filemd5)) {
        break label1696;
      }
      ad.i("MicroMsg.NetSceneSendAppMsgForCdn", "summerbig sceneResult filemd5 is null use content.filemd5[%s]", new Object[] { localb.filemd5 });
    }
    for (;;)
    {
      if (((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).ifAddTicketByActionFlag(this.drF.field_talker)) {
        localcos.COT = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aIi(this.drF.field_talker);
      }
      ad.i("MicroMsg.NetSceneSendAppMsgForCdn", "summerbig file md5[%s], HitMd5[%d], signature[%s], type[%d], sceneResult[%s], fromScene[%s]", new Object[] { localcos.Md5, Integer.valueOf(localcos.EiL), bt.aGs(localcos.ijP), Integer.valueOf(localcos.CAG), this.fYG, localcos.EiK });
      i = dispatch(parame, this.rr, this);
      AppMethodBeat.o(31058);
      return i;
      localek.CxC = bk.SM();
      break;
      this.BQp.dbr.dbt = paramg;
      break label991;
      i = 2;
      break label1035;
      paramg = this.BQp.dbr;
      if (bool) {}
      for (i = 4;; i = 1)
      {
        paramg.action = i;
        break;
      }
      localcos.Md5 = this.fYG.field_filemd5;
    }
  }
  
  public final int getType()
  {
    return 222;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(31059);
    paramArrayOfByte = (cos)((com.tencent.mm.al.b)paramq).gUS.gUX;
    ad.i("MicroMsg.NetSceneSendAppMsgForCdn", "summerbig cdntra onGYNetEnd [%d,%d,%s] msgId:%d, oldContent[%s], newContent[%s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Long.valueOf(this.msgId), this.drF.field_content, paramArrayOfByte.EiI.gKr });
    paramq = (cot)((com.tencent.mm.al.b)paramq).gUT.gUX;
    if ((paramq != null) && ((paramInt2 == 4) || ((paramInt2 == 0) && (paramInt3 == 0)))) {
      ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).setEnSendMsgActionFlag(paramq.COU);
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      if ((paramInt2 == 4) && (paramInt3 == 102))
      {
        ad.w("MicroMsg.NetSceneSendAppMsgForCdn", "summersafecdn MM_ERR_GET_AESKEY_FAILED");
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        this.BQu.dm(paramInt2, paramInt3);
        AppMethodBeat.o(31059);
        return;
      }
      this.drF.setStatus(5);
      az.arV();
      com.tencent.mm.model.c.apO().a(this.drF.field_msgId, this.drF);
      ad.e("MicroMsg.NetSceneSendAppMsgForCdn", "summerbig send app msg failed, err=" + paramInt2 + "," + paramInt3);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      this.BQu.dm(paramInt2, paramInt3);
      AppMethodBeat.o(31059);
      return;
    }
    ad.i("MicroMsg.NetSceneSendAppMsgForCdn", "summersafecdn svrid[%d]. aeskey[%s], old content[%s]", new Object[] { Long.valueOf(paramq.uKZ), paramq.COP, this.drF.field_content });
    if ((this.fYG != null) && (this.fYG.UC()))
    {
      if (bt.isNullOrNil(paramq.COP)) {
        break label728;
      }
      paramArrayOfByte = k.b.rx(this.drF.field_content);
      paramArrayOfByte.fMw = paramq.COP;
      this.drF.setContent(k.b.a(paramArrayOfByte, null, null));
      ad.i("MicroMsg.NetSceneSendAppMsgForCdn", "summersafecdn aeskey[%s], new content[%s]", new Object[] { paramq.COP, this.drF.field_content });
    }
    for (;;)
    {
      this.drF.setStatus(2);
      this.drF.kX(paramq.uKZ);
      az.arV();
      com.tencent.mm.model.c.apO().a(this.drF.field_msgId, this.drF);
      com.tencent.mm.modelstat.b.huc.b(this.drF, l.r(this.drF));
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      this.BQu.dm(paramInt2, paramInt3);
      if ((this.wFo != null) && (!bt.isNullOrNil(this.wFo.dEv.url)))
      {
        this.wFo.dEv.dEx = ("msg_" + Long.toString(paramq.uKZ));
        com.tencent.mm.sdk.b.a.ESL.l(this.wFo);
      }
      if (this.BQp != null)
      {
        this.BQp.dbr.dbv = ("msg_" + this.drF.field_msgSvrId);
        com.tencent.mm.sdk.b.a.ESL.l(this.BQp);
      }
      paramString = k.b.rx(this.drF.field_content);
      if ((paramString != null) && (w.sm(this.drF.field_talker)))
      {
        paramq = (com.tencent.mm.ai.a)paramString.ao(com.tencent.mm.ai.a.class);
        if ((paramq != null) && (paramq.gFM)) {
          com.tencent.mm.chatroom.d.y.a(this.drF, paramString);
        }
        if (aa.UU()) {
          ((com.tencent.mm.chatroom.plugin.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.chatroom.plugin.a.class)).handleGroupToolByReceiverAppMsg(this.drF);
        }
      }
      AppMethodBeat.o(31059);
      return;
      label728:
      ad.w("MicroMsg.NetSceneSendAppMsgForCdn", "summersafecdn need aeskey but ret null");
    }
  }
  
  public final n.b securityVerificationChecked(com.tencent.mm.network.q paramq)
  {
    return n.b.gVB;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.ai
 * JD-Core Version:    0.7.0.1
 */