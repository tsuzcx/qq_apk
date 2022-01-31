package com.tencent.mm.pluginsdk.model.app;

import android.graphics.BitmapFactory.Options;
import android.util.Base64;
import com.tencent.mm.ae.g.a;
import com.tencent.mm.ae.h;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.m.b;
import com.tencent.mm.as.o;
import com.tencent.mm.h.a.n;
import com.tencent.mm.h.a.um;
import com.tencent.mm.h.a.um.a;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.j.d;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.t;
import com.tencent.mm.model.u;
import com.tencent.mm.model.u.b;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.c.bos;
import com.tencent.mm.protocal.c.bot;
import com.tencent.mm.protocal.c.bvm;
import com.tencent.mm.protocal.c.bvo;
import com.tencent.mm.protocal.c.dn;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bi;
import java.util.Locale;

public final class aj
  extends com.tencent.mm.ah.m
  implements k
{
  private long bIt = 0L;
  private bi bWO = null;
  private d dGa = null;
  private com.tencent.mm.ah.b dmK;
  private com.tencent.mm.ah.f dmL;
  private String fKV;
  private um oqj;
  private n rUQ;
  private b rUT = null;
  private boolean rUU = false;
  private aj.a rUV = null;
  
  public aj(long paramLong, boolean paramBoolean, d paramd, aj.a parama, String paramString, b paramb)
  {
    this.bIt = paramLong;
    this.fKV = paramString;
    this.dGa = paramd;
    this.rUV = parama;
    this.rUU = paramBoolean;
    this.rUT = paramb;
    parama = new b.a();
    parama.ecH = new bos();
    parama.ecI = new bot();
    parama.uri = "/cgi-bin/micromsg-bin/sendappmsg";
    parama.ecG = 222;
    parama.ecJ = 107;
    parama.ecK = 1000000107;
    this.dmK = parama.Kt();
    y.i("MicroMsg.NetSceneSendAppMsgForCdn", "summerbig NetSceneSendAppMsgForCdn msgId[%d], sceneResult[%s], sessionId[%s], attachInfo[%s]. stack[%s]", new Object[] { Long.valueOf(paramLong), paramd, paramString, paramb, bk.csb() });
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.ah.f paramf)
  {
    this.dmL = paramf;
    au.Hx();
    this.bWO = com.tencent.mm.model.c.Fy().fd(this.bIt);
    if ((this.bWO == null) || (this.bWO.field_msgId != this.bIt))
    {
      y.e("MicroMsg.NetSceneSendAppMsgForCdn", "summerbig cdntra doscene msginfo null id:%d", new Object[] { Long.valueOf(this.bIt) });
      this.rUV.bw(3, -1);
      return -1;
    }
    g.a locala = g.a.gp(this.bWO.field_content);
    if (locala == null)
    {
      y.e("MicroMsg.NetSceneSendAppMsgForCdn", "summerbig cdntra doscene AppMessage.Content.parse null id:%d", new Object[] { Long.valueOf(this.bIt) });
      this.rUV.bw(3, -1);
    }
    bos localbos = (bos)this.dmK.ecE.ecN;
    dn localdn = new dn();
    localdn.euK = locala.appId;
    localdn.swQ = (this.bWO.field_talker + this.bWO.field_msgId + "T" + this.bWO.field_createTime);
    localdn.mPL = ((int)bk.UX());
    localdn.kWm = this.bWO.field_talker;
    localdn.kWn = com.tencent.mm.model.q.Gj();
    localdn.hQR = locala.type;
    localdn.swP = locala.sdkVer;
    localdn.swS = locala.dQy;
    u.b localb;
    bvo localbvo;
    if (com.tencent.mm.ai.f.eW(this.bWO.field_talker))
    {
      localdn.svK = com.tencent.mm.ai.a.e.lv(this.bWO.czr);
      localdn.swU = locala.bYJ;
      localdn.swV = locala.bYK;
      localdn.swW = locala.bYL;
      localb = u.Hc().ii(this.fKV);
      if (localb != null)
      {
        this.oqj = new um();
        this.oqj.ceR.url = locala.url;
        this.oqj.ceR.ceS = localb.getString("prePublishId", "");
        this.oqj.ceR.ceU = localb.getString("preUsername", "");
        this.oqj.ceR.ceV = localb.getString("preChatName", "");
        this.oqj.ceR.ceW = localb.getInt("preMsgIndex", 0);
        this.oqj.ceR.cfa = localb.getInt("sendAppMsgScene", 0);
        this.oqj.ceR.cfb = localb.getInt("getA8KeyScene", 0);
        this.oqj.ceR.cfc = localb.getString("referUrl", null);
        this.oqj.ceR.cfd = localb.getString("adExtStr", null);
        this.oqj.ceR.ceX = this.bWO.field_talker;
        this.oqj.ceR.cfe = locala.title;
        au.Hx();
        paramf = com.tencent.mm.model.c.Fw().abl(this.bWO.field_talker);
        if (paramf != null) {
          this.oqj.ceR.ceY = paramf.Bp();
        }
        this.oqj.ceR.ceZ = com.tencent.mm.model.m.gM(this.bWO.field_talker);
        str = "";
        paramf = str;
        if (locala.bYN != null)
        {
          localbvo = new bvo();
          paramf = Base64.decode(locala.bYN, 0);
        }
      }
    }
    try
    {
      localbvo.aH(paramf);
      paramf = str;
      if (localbvo.tMo != null) {
        paramf = localbvo.tMo.kOK;
      }
    }
    catch (Exception paramf)
    {
      for (;;)
      {
        int i;
        int j;
        boolean bool;
        int k;
        int m;
        paramf = str;
      }
    }
    localbos.tHb = String.format(Locale.US, "prePublishId=%s&preUserName=%s&preChatName=%s&preChatType=%d&getA8KeyScene=%d&sourceAppId=%s", new Object[] { this.oqj.ceR.ceS, this.oqj.ceR.ceU, this.oqj.ceR.ceV, Integer.valueOf(t.R(this.oqj.ceR.ceU, this.oqj.ceR.ceV)), Integer.valueOf(this.oqj.ceR.cfb), paramf });
    if ((localb != null) && (locala.type == 33))
    {
      this.rUQ = new n();
      i = localb.getInt("fromScene", 1);
      this.rUQ.bFt.scene = i;
      j = localb.getInt("appservicetype", 0);
      this.rUQ.bFt.bFB = j;
      paramf = localb.getString("preChatName", "");
      if (2 == i)
      {
        str = localb.getString("preUsername", "");
        this.rUQ.bFt.bFv = (paramf + ":" + str);
        label926:
        paramf = this.bWO.field_talker;
        bool = localb.getBoolean("moreRetrAction", false);
        if (!paramf.endsWith("@chatroom")) {
          break label1540;
        }
        paramf = this.rUQ.bFt;
        if (!bool) {
          break label1535;
        }
        i = 5;
        label970:
        paramf.action = i;
        this.rUQ.bFt.bFu = (locala.dTf + 1);
        this.rUQ.bFt.bFw = locala.dSX;
        this.rUQ.bFt.bFn = locala.dSY;
        this.rUQ.bFt.appId = locala.dSZ;
        this.rUQ.bFt.bFy = bk.UX();
        this.rUQ.bFt.bFz = 1;
      }
    }
    else
    {
      y.d("MicroMsg.NetSceneSendAppMsgForCdn", "stev summerbig SnsPostOperationFields: ShareUrlOriginal=%s, ShareUrlOpen=%s, JsAppId=%s", new Object[] { locala.bYJ, locala.bYK, locala.bYL });
      k = 0;
      m = 0;
      j = m;
      i = k;
      if (!bk.bl(this.bWO.field_imgPath))
      {
        paramf = com.tencent.mm.sdk.platformtools.c.YU(o.OJ().me(this.bWO.field_imgPath));
        j = m;
        i = k;
        if (paramf != null)
        {
          i = paramf.outWidth;
          j = paramf.outHeight;
        }
      }
      if (this.dGa.wV())
      {
        y.i("MicroMsg.NetSceneSendAppMsgForCdn", "summersafecdn app sceneResult crc[%d], safecdn[%b], hitcachetype[%d], aeskey[%s]", new Object[] { Integer.valueOf(this.dGa.field_filecrc), Boolean.valueOf(this.dGa.field_upload_by_safecdn), Integer.valueOf(this.dGa.field_UploadHitCacheType), this.dGa.field_aesKey });
        this.dGa.field_aesKey = "";
        localbos.tHc = 1;
      }
      localbos.sGS = this.dGa.field_filecrc;
      paramf = null;
      if (this.rUU) {
        paramf = "@cdn_" + this.dGa.field_fileId + "_" + this.dGa.field_aesKey + "_1";
      }
      localdn.kVs = g.a.a(locala, paramf, this.dGa, i, j);
      localbos.tGZ = localdn;
      if ((this.rUT != null) && ((locala.dQz != 0) || (locala.dQv > 26214400)))
      {
        localbos.ffk = this.rUT.field_signature;
        localbos.sxP = com.tencent.mm.j.a.dlm;
      }
      localbos.jnU = locala.filemd5;
      if (!bk.bl(this.dGa.field_filemd5)) {
        break label1568;
      }
      y.i("MicroMsg.NetSceneSendAppMsgForCdn", "summerbig sceneResult filemd5 is null use content.filemd5[%s]", new Object[] { locala.filemd5 });
    }
    for (;;)
    {
      y.i("MicroMsg.NetSceneSendAppMsgForCdn", "summerbig file md5[%s], HitMd5[%d], signature[%s], type[%d], sceneResult[%s], fromScene[%s]", new Object[] { localbos.jnU, Integer.valueOf(localbos.tHc), bk.aac(localbos.ffk), Integer.valueOf(localbos.sxP), this.dGa, localbos.tHb });
      return a(parame, this.dmK, this);
      localdn.svK = bf.HR();
      break;
      this.rUQ.bFt.bFv = paramf;
      break label926;
      label1535:
      i = 2;
      break label970;
      label1540:
      paramf = this.rUQ.bFt;
      if (bool) {}
      for (i = 4;; i = 1)
      {
        paramf.action = i;
        break;
      }
      label1568:
      localbos.jnU = this.dGa.field_filemd5;
    }
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    paramArrayOfByte = (bos)((com.tencent.mm.ah.b)paramq).ecE.ecN;
    y.i("MicroMsg.NetSceneSendAppMsgForCdn", "summerbig cdntra onGYNetEnd [%d,%d,%s] msgId:%d, oldContent[%s], newContent[%s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Long.valueOf(this.bIt), this.bWO.field_content, paramArrayOfByte.tGZ.kVs });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      if ((paramInt2 == 4) && (paramInt3 == 102))
      {
        y.w("MicroMsg.NetSceneSendAppMsgForCdn", "summersafecdn MM_ERR_GET_AESKEY_FAILED");
        this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
        this.rUV.bw(paramInt2, paramInt3);
        return;
      }
      this.bWO.setStatus(5);
      au.Hx();
      com.tencent.mm.model.c.Fy().a(this.bWO.field_msgId, this.bWO);
      y.e("MicroMsg.NetSceneSendAppMsgForCdn", "summerbig send app msg failed, err=" + paramInt2 + "," + paramInt3);
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      this.rUV.bw(paramInt2, paramInt3);
      return;
    }
    paramq = (bot)((com.tencent.mm.ah.b)paramq).ecF.ecN;
    y.i("MicroMsg.NetSceneSendAppMsgForCdn", "summersafecdn svrid[%d]. aeskey[%s], old content[%s]", new Object[] { Long.valueOf(paramq.ndp), paramq.sGQ, this.bWO.field_content });
    if ((this.dGa != null) && (this.dGa.wV()))
    {
      if (bk.bl(paramq.sGQ)) {
        break label577;
      }
      paramArrayOfByte = g.a.gp(this.bWO.field_content);
      paramArrayOfByte.dQR = paramq.sGQ;
      this.bWO.setContent(g.a.a(paramArrayOfByte, null, null));
      y.i("MicroMsg.NetSceneSendAppMsgForCdn", "summersafecdn aeskey[%s], new content[%s]", new Object[] { paramq.sGQ, this.bWO.field_content });
    }
    for (;;)
    {
      this.bWO.setStatus(2);
      this.bWO.bf(paramq.ndp);
      au.Hx();
      com.tencent.mm.model.c.Fy().a(this.bWO.field_msgId, this.bWO);
      com.tencent.mm.modelstat.b.eBD.a(this.bWO, h.g(this.bWO));
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      this.rUV.bw(paramInt2, paramInt3);
      if ((this.oqj != null) && (!bk.bl(this.oqj.ceR.url)))
      {
        this.oqj.ceR.ceT = ("msg_" + Long.toString(paramq.ndp));
        com.tencent.mm.sdk.b.a.udP.m(this.oqj);
      }
      if (this.rUQ == null) {
        break;
      }
      this.rUQ.bFt.bFx = ("msg_" + this.bWO.field_msgSvrId);
      com.tencent.mm.sdk.b.a.udP.m(this.rUQ);
      return;
      label577:
      y.w("MicroMsg.NetSceneSendAppMsgForCdn", "summersafecdn need aeskey but ret null");
    }
  }
  
  protected final m.b b(com.tencent.mm.network.q paramq)
  {
    return m.b.edr;
  }
  
  public final int getType()
  {
    return 222;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.aj
 * JD-Core Version:    0.7.0.1
 */