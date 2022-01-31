package com.tencent.mm.pluginsdk.model.app;

import android.graphics.BitmapFactory.Options;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.m.b;
import com.tencent.mm.at.g;
import com.tencent.mm.at.o;
import com.tencent.mm.g.a.wg;
import com.tencent.mm.g.a.wg.a;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.l.a.a;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.model.u;
import com.tencent.mm.model.v;
import com.tencent.mm.model.v.b;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.protocal.protobuf.byp;
import com.tencent.mm.protocal.protobuf.byq;
import com.tencent.mm.protocal.protobuf.cgf;
import com.tencent.mm.protocal.protobuf.cgh;
import com.tencent.mm.protocal.protobuf.dx;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bi;
import java.util.Locale;

public final class af
  extends m
  implements com.tencent.mm.network.k
{
  private bi cEE;
  private f callback;
  private long cpO;
  private com.tencent.mm.i.d eDC;
  private String mSessionId;
  private wg reQ;
  private com.tencent.mm.ai.b rr;
  private com.tencent.mm.g.a.n vLE;
  private b vLH;
  private boolean vLI;
  private af.a vLJ;
  
  public af(long paramLong, boolean paramBoolean, com.tencent.mm.i.d paramd, af.a parama, String paramString, b paramb)
  {
    AppMethodBeat.i(27363);
    this.cpO = 0L;
    this.eDC = null;
    this.vLH = null;
    this.cEE = null;
    this.vLI = false;
    this.vLJ = null;
    this.cpO = paramLong;
    this.mSessionId = paramString;
    this.eDC = paramd;
    this.vLJ = parama;
    this.vLI = paramBoolean;
    this.vLH = paramb;
    parama = new b.a();
    parama.fsX = new byp();
    parama.fsY = new byq();
    parama.uri = "/cgi-bin/micromsg-bin/sendappmsg";
    parama.funcId = 222;
    parama.reqCmdId = 107;
    parama.respCmdId = 1000000107;
    this.rr = parama.ado();
    ab.i("MicroMsg.NetSceneSendAppMsgForCdn", "summerbig NetSceneSendAppMsgForCdn msgId[%d], sceneResult[%s], sessionId[%s], attachInfo[%s]. stack[%s]", new Object[] { Long.valueOf(paramLong), paramd, paramString, paramb, bo.dtY() });
    AppMethodBeat.o(27363);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(27364);
    this.callback = paramf;
    aw.aaz();
    this.cEE = c.YC().kB(this.cpO);
    if ((this.cEE == null) || (this.cEE.field_msgId != this.cpO))
    {
      ab.e("MicroMsg.NetSceneSendAppMsgForCdn", "summerbig cdntra doscene msginfo null id:%d", new Object[] { Long.valueOf(this.cpO) });
      this.vLJ.cG(3, -1);
      AppMethodBeat.o(27364);
      return -1;
    }
    j.b localb = j.b.mY(this.cEE.field_content);
    if (localb == null)
    {
      ab.e("MicroMsg.NetSceneSendAppMsgForCdn", "summerbig cdntra doscene AppMessage.Content.parse null id:%d", new Object[] { Long.valueOf(this.cpO) });
      this.vLJ.cG(3, -1);
    }
    byp localbyp = (byp)this.rr.fsV.fta;
    dx localdx = new dx();
    localdx.fKw = localb.appId;
    localdx.wpS = (this.cEE.field_talker + this.cEE.field_msgId + "T" + this.cEE.field_createTime);
    localdx.CreateTime = ((int)bo.aox());
    localdx.nul = this.cEE.field_talker;
    localdx.num = r.Zn();
    localdx.jKs = localb.type;
    localdx.wpR = localb.sdkVer;
    localdx.niK = localb.fgz;
    paramf = a.a.Ky().h(this.cEE);
    v.b localb1;
    cgh localcgh;
    if (!bo.isNullOrNil(paramf))
    {
      localdx.woU = paramf;
      localdx.wpV = localb.cGQ;
      localdx.wpW = localb.cGR;
      localdx.wpX = localb.cGS;
      localb1 = v.aae().oP(this.mSessionId);
      if (localb1 != null)
      {
        this.reQ = new wg();
        this.reQ.cNx.url = localb.url;
        this.reQ.cNx.cNy = localb1.getString("prePublishId", "");
        this.reQ.cNx.cNA = localb1.getString("preUsername", "");
        this.reQ.cNx.cNB = localb1.getString("preChatName", "");
        this.reQ.cNx.cNC = localb1.getInt("preMsgIndex", 0);
        this.reQ.cNx.cNG = localb1.getInt("sendAppMsgScene", 0);
        this.reQ.cNx.cNH = localb1.getInt("getA8KeyScene", 0);
        this.reQ.cNx.cNI = localb1.getString("referUrl", null);
        this.reQ.cNx.cNJ = localb1.getString("adExtStr", null);
        this.reQ.cNx.cND = this.cEE.field_talker;
        this.reQ.cNx.cNK = localb.title;
        aw.aaz();
        paramf = c.YA().arw(this.cEE.field_talker);
        if (paramf != null) {
          this.reQ.cNx.cNE = paramf.Oe();
        }
        this.reQ.cNx.cNF = com.tencent.mm.model.n.nv(this.cEE.field_talker);
        str = "";
        paramf = str;
        if (localb.cGU != null)
        {
          localcgh = new cgh();
          paramf = Base64.decode(localb.cGU, 0);
        }
      }
    }
    try
    {
      localcgh.parseFrom(paramf);
      paramf = str;
      if (localcgh.xRa != null) {
        paramf = localcgh.xRa.nmH;
      }
    }
    catch (Exception paramf)
    {
      for (;;)
      {
        int i;
        int j;
        label936:
        boolean bool;
        label980:
        int k;
        int m;
        label1553:
        label1558:
        label1586:
        paramf = str;
      }
    }
    localbyp.xKY = String.format(Locale.US, "prePublishId=%s&preUserName=%s&preChatName=%s&preChatType=%d&getA8KeyScene=%d&sourceAppId=%s", new Object[] { this.reQ.cNx.cNy, this.reQ.cNx.cNA, this.reQ.cNx.cNB, Integer.valueOf(u.ah(this.reQ.cNx.cNA, this.reQ.cNx.cNB)), Integer.valueOf(this.reQ.cNx.cNH), paramf });
    if ((localb1 != null) && (localb.type == 33))
    {
      this.vLE = new com.tencent.mm.g.a.n();
      i = localb1.getInt("fromScene", 1);
      this.vLE.cmD.scene = i;
      j = localb1.getInt("appservicetype", 0);
      this.vLE.cmD.bCV = j;
      paramf = localb1.getString("preChatName", "");
      if (2 == i)
      {
        str = localb1.getString("preUsername", "");
        this.vLE.cmD.cmF = (paramf + ":" + str);
        paramf = this.cEE.field_talker;
        bool = localb1.getBoolean("moreRetrAction", false);
        if (!paramf.endsWith("@chatroom")) {
          break label1558;
        }
        paramf = this.vLE.cmD;
        if (!bool) {
          break label1553;
        }
        i = 5;
        paramf.action = i;
        this.vLE.cmD.cmE = (localb.fjh + 1);
        this.vLE.cmD.cmG = localb.fiW;
        this.vLE.cmD.cmx = localb.fiX;
        this.vLE.cmD.appId = localb.fiY;
        this.vLE.cmD.cmI = bo.aox();
        this.vLE.cmD.cmJ = 1;
      }
    }
    else
    {
      ab.d("MicroMsg.NetSceneSendAppMsgForCdn", "stev summerbig SnsPostOperationFields: ShareUrlOriginal=%s, ShareUrlOpen=%s, JsAppId=%s", new Object[] { localb.cGQ, localb.cGR, localb.cGS });
      k = 0;
      m = 0;
      j = m;
      i = k;
      if (!bo.isNullOrNil(this.cEE.field_imgPath))
      {
        paramf = com.tencent.mm.sdk.platformtools.d.aoT(o.ahC().te(this.cEE.field_imgPath));
        j = m;
        i = k;
        if (paramf != null)
        {
          i = paramf.outWidth;
          j = paramf.outHeight;
        }
      }
      if (this.eDC.Jm())
      {
        ab.i("MicroMsg.NetSceneSendAppMsgForCdn", "summersafecdn app sceneResult crc[%d], safecdn[%b], hitcachetype[%d], aeskey[%s]", new Object[] { Integer.valueOf(this.eDC.field_filecrc), Boolean.valueOf(this.eDC.field_upload_by_safecdn), Integer.valueOf(this.eDC.field_UploadHitCacheType), this.eDC.field_aesKey });
        this.eDC.field_aesKey = "";
        localbyp.xKZ = 1;
      }
      localbyp.wDq = this.eDC.field_filecrc;
      paramf = null;
      if (this.vLI) {
        paramf = "@cdn_" + this.eDC.field_fileId + "_" + this.eDC.field_aesKey + "_1";
      }
      localdx.ntu = j.b.a(localb, paramf, this.eDC, i, j);
      localbyp.xKW = localdx;
      if ((this.vLH != null) && ((localb.fgA != 0) || (localb.fgw > 26214400)))
      {
        localbyp.gwS = this.vLH.field_signature;
        localbyp.wrs = com.tencent.mm.i.a.ecH;
      }
      localbyp.Md5 = localb.filemd5;
      if (!bo.isNullOrNil(this.eDC.field_filemd5)) {
        break label1586;
      }
      ab.i("MicroMsg.NetSceneSendAppMsgForCdn", "summerbig sceneResult filemd5 is null use content.filemd5[%s]", new Object[] { localb.filemd5 });
    }
    for (;;)
    {
      ab.i("MicroMsg.NetSceneSendAppMsgForCdn", "summerbig file md5[%s], HitMd5[%d], signature[%s], type[%d], sceneResult[%s], fromScene[%s]", new Object[] { localbyp.Md5, Integer.valueOf(localbyp.xKZ), bo.aqg(localbyp.gwS), Integer.valueOf(localbyp.wrs), this.eDC, localbyp.xKY });
      i = dispatch(parame, this.rr, this);
      AppMethodBeat.o(27364);
      return i;
      localdx.woU = bh.aaQ();
      break;
      this.vLE.cmD.cmF = paramf;
      break label936;
      i = 2;
      break label980;
      paramf = this.vLE.cmD;
      if (bool) {}
      for (i = 4;; i = 1)
      {
        paramf.action = i;
        break;
      }
      localbyp.Md5 = this.eDC.field_filemd5;
    }
  }
  
  public final int getType()
  {
    return 222;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(27365);
    paramArrayOfByte = (byp)((com.tencent.mm.ai.b)paramq).fsV.fta;
    ab.i("MicroMsg.NetSceneSendAppMsgForCdn", "summerbig cdntra onGYNetEnd [%d,%d,%s] msgId:%d, oldContent[%s], newContent[%s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Long.valueOf(this.cpO), this.cEE.field_content, paramArrayOfByte.xKW.ntu });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      if ((paramInt2 == 4) && (paramInt3 == 102))
      {
        ab.w("MicroMsg.NetSceneSendAppMsgForCdn", "summersafecdn MM_ERR_GET_AESKEY_FAILED");
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        this.vLJ.cG(paramInt2, paramInt3);
        AppMethodBeat.o(27365);
        return;
      }
      this.cEE.setStatus(5);
      aw.aaz();
      c.YC().a(this.cEE.field_msgId, this.cEE);
      ab.e("MicroMsg.NetSceneSendAppMsgForCdn", "summerbig send app msg failed, err=" + paramInt2 + "," + paramInt3);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      this.vLJ.cG(paramInt2, paramInt3);
      AppMethodBeat.o(27365);
      return;
    }
    paramq = (byq)((com.tencent.mm.ai.b)paramq).fsW.fta;
    ab.i("MicroMsg.NetSceneSendAppMsgForCdn", "summersafecdn svrid[%d]. aeskey[%s], old content[%s]", new Object[] { Long.valueOf(paramq.pIG), paramq.wDo, this.cEE.field_content });
    if ((this.eDC != null) && (this.eDC.Jm()))
    {
      if (bo.isNullOrNil(paramq.wDo)) {
        break label601;
      }
      paramArrayOfByte = j.b.mY(this.cEE.field_content);
      paramArrayOfByte.ewj = paramq.wDo;
      this.cEE.setContent(j.b.a(paramArrayOfByte, null, null));
      ab.i("MicroMsg.NetSceneSendAppMsgForCdn", "summersafecdn aeskey[%s], new content[%s]", new Object[] { paramq.wDo, this.cEE.field_content });
    }
    for (;;)
    {
      this.cEE.setStatus(2);
      this.cEE.fP(paramq.pIG);
      aw.aaz();
      c.YC().a(this.cEE.field_msgId, this.cEE);
      com.tencent.mm.modelstat.b.fRu.a(this.cEE, com.tencent.mm.af.k.k(this.cEE));
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      this.vLJ.cG(paramInt2, paramInt3);
      if ((this.reQ != null) && (!bo.isNullOrNil(this.reQ.cNx.url)))
      {
        this.reQ.cNx.cNz = ("msg_" + Long.toString(paramq.pIG));
        com.tencent.mm.sdk.b.a.ymk.l(this.reQ);
      }
      if (this.vLE != null)
      {
        this.vLE.cmD.cmH = ("msg_" + this.cEE.field_msgSvrId);
        com.tencent.mm.sdk.b.a.ymk.l(this.vLE);
      }
      AppMethodBeat.o(27365);
      return;
      label601:
      ab.w("MicroMsg.NetSceneSendAppMsgForCdn", "summersafecdn need aeskey but ret null");
    }
  }
  
  public final m.b securityVerificationChecked(q paramq)
  {
    return m.b.ftu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.af
 * JD-Core Version:    0.7.0.1
 */