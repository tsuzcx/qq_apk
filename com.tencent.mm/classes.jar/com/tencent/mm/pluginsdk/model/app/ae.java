package com.tencent.mm.pluginsdk.model.app;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.m.b;
import com.tencent.mm.at.o;
import com.tencent.mm.g.a.n.a;
import com.tencent.mm.g.a.wg;
import com.tencent.mm.g.a.wg.a;
import com.tencent.mm.g.a.wh;
import com.tencent.mm.g.a.wh.a;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.i.g.a;
import com.tencent.mm.l.a.a;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.model.u;
import com.tencent.mm.model.v;
import com.tencent.mm.model.v.b;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.byp;
import com.tencent.mm.protocal.protobuf.byq;
import com.tencent.mm.protocal.protobuf.cgf;
import com.tencent.mm.protocal.protobuf.cgh;
import com.tencent.mm.protocal.protobuf.dx;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bi;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Locale;
import junit.framework.Assert;

public final class ae
  extends m
  implements com.tencent.mm.network.k
{
  bi cEE;
  com.tencent.mm.ai.f callback;
  long cpO;
  String fFo;
  private g.a fFy;
  int fWd;
  String mSessionId;
  private String mSignature;
  private wg reQ;
  wh reR;
  private com.tencent.mm.ai.b rr;
  long startTime;
  private com.tencent.mm.g.a.n vLE;
  
  public ae(long paramLong, String paramString1, String paramString2)
  {
    AppMethodBeat.i(27360);
    this.cEE = null;
    this.cpO = 0L;
    this.startTime = 0L;
    this.fFo = "";
    this.fWd = 0;
    this.fFy = new ae.1(this);
    this.cpO = paramLong;
    this.mSessionId = paramString1;
    this.mSignature = paramString2;
    b.a locala = new b.a();
    locala.fsX = new byp();
    locala.fsY = new byq();
    locala.uri = "/cgi-bin/micromsg-bin/sendappmsg";
    locala.funcId = 222;
    locala.reqCmdId = 107;
    locala.respCmdId = 1000000107;
    this.rr = locala.ado();
    ab.i("MicroMsg.NetSceneSendAppMsg", "summersafecdn NetSceneSendAppMsg msgid[%d], sessionid[%s], signature[%s], stack[%s]", new Object[] { Long.valueOf(paramLong), paramString1, bo.aqg(paramString2), bo.dtY() });
    AppMethodBeat.o(27360);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ai.f paramf)
  {
    AppMethodBeat.i(27361);
    this.callback = paramf;
    if (this.startTime == 0L) {
      this.startTime = bo.aoy();
    }
    aw.aaz();
    this.cEE = com.tencent.mm.model.c.YC().kB(this.cpO);
    if ((this.cEE == null) || (this.cEE.field_msgId != this.cpO))
    {
      AppMethodBeat.o(27361);
      return -1;
    }
    paramf = j.b.mY(this.cEE.field_content);
    Object localObject1;
    if (paramf == null)
    {
      localObject1 = ap.arZ(this.cEE.field_content);
      if (bo.isNullOrNil(((ap)localObject1).yML))
      {
        paramf = new j.b();
        paramf.fgy = ((ap)localObject1).cqq;
        paramf.type = 8;
        ab.i("MicroMsg.NetSceneSendAppMsg", "create new content. loss appid");
      }
    }
    for (;;)
    {
      localObject1 = "content != null [[" + this.cEE.field_content + "]]";
      if (paramf != null) {}
      for (boolean bool = true;; bool = false)
      {
        Assert.assertTrue((String)localObject1, bool);
        if (paramf != null) {
          break label223;
        }
        this.cEE = null;
        AppMethodBeat.o(27361);
        return -1;
        paramf = j.b.mY(((ap)localObject1).yML);
        break;
      }
      label223:
      if (!bo.isNullOrNil(this.cEE.field_imgPath)) {}
      label531:
      String str;
      for (localObject1 = o.ahC().te(this.cEE.field_imgPath);; localObject1 = "")
      {
        Object localObject2 = v.aae().oO(this.mSessionId);
        if ((localObject2 != null) && (((v.b)localObject2).containsKey("_tmpl_webview_transfer_scene")))
        {
          this.reR = new wh();
          this.reR.cNM.cNN = ((v.b)localObject2).getInt("_tmpl_webview_transfer_scene", -1);
        }
        if ((paramf.type == 8) || (paramf.type == 9) || (paramf.type == 6))
        {
          ab.i("MicroMsg.NetSceneSendAppMsg", "cdntra cdn not support Emoji or voiceremind now type:%d", new Object[] { Integer.valueOf(paramf.type) });
          i = 0;
        }
        while (i != 0)
        {
          ab.d("MicroMsg.NetSceneSendAppMsg", "cdntra use cdn return -1 for onGYNetEnd clientId:%s", new Object[] { this.fFo });
          AppMethodBeat.o(27361);
          return 0;
          if (bo.isNullOrNil((String)localObject1))
          {
            ab.i("MicroMsg.NetSceneSendAppMsg", "cdntra cdn not support no thumb msg type:%d", new Object[] { Integer.valueOf(paramf.type) });
            i = 0;
          }
          else
          {
            this.fWd = com.tencent.mm.a.e.cM((String)localObject1);
            if ((paramf.type == 33) || (paramf.type == 36) || (paramf.type == 46) || (paramf.type == 44) || (paramf.type == 48)) {}
            for (i = 1;; i = 0)
            {
              if ((i != 0) || (this.fWd < 262144)) {
                break label531;
              }
              ab.w("MicroMsg.NetSceneSendAppMsg", "cdntra thumb[%s][%d] Too Big Not Use CDN TRANS", new Object[] { localObject1, Integer.valueOf(this.fWd) });
              i = 0;
              break;
            }
            ab.i("MicroMsg.NetSceneSendAppMsg", "cdntra content.type:%d  thumbPath:%s,  thumbLength:%d ", new Object[] { Integer.valueOf(paramf.type), localObject1, Integer.valueOf(this.fWd) });
            if (!bo.isNullOrNil(paramf.cmN))
            {
              ab.w("MicroMsg.NetSceneSendAppMsg", "cdntra attach has been upload by cdn msgid:%d", new Object[] { Long.valueOf(this.cpO) });
              i = 0;
            }
            else
            {
              if (i == 0)
              {
                com.tencent.mm.al.f.afO();
                if (!com.tencent.mm.al.b.lc(4))
                {
                  com.tencent.mm.al.f.afO();
                  ab.w("MicroMsg.NetSceneSendAppMsg", "cdntra not use cdn flag:%b ", new Object[] { Boolean.valueOf(com.tencent.mm.al.b.lc(4)) });
                  i = 0;
                  continue;
                }
              }
              this.fFo = com.tencent.mm.al.c.a("upappmsg", this.cEE.field_createTime, this.cEE.field_talker, this.cEE.field_msgId);
              if (bo.isNullOrNil(this.fFo))
              {
                ab.w("MicroMsg.NetSceneSendAppMsg", "cdntra genClientId failed not use cdn msgid:%d", new Object[] { Long.valueOf(this.cEE.field_msgId) });
                i = 0;
              }
              else
              {
                localObject2 = paramf.Ym();
                if (((com.tencent.mm.sdk.platformtools.f.DEBUG) || (com.tencent.mm.sdk.platformtools.f.IS_FLAVOR_RED)) && ((((com.tencent.mm.i.g)localObject2).edp != null) || (!bo.isNullOrNil(((com.tencent.mm.i.g)localObject2).field_mediaId)) || (!bo.isNullOrNil(((com.tencent.mm.i.g)localObject2).field_thumbpath)) || (!bo.isNullOrNil(((com.tencent.mm.i.g)localObject2).field_talker))))
                {
                  parame = new RuntimeException("Do not fill reserved fields!");
                  AppMethodBeat.o(27361);
                  throw parame;
                }
                ((com.tencent.mm.i.g)localObject2).edp = this.fFy;
                ((com.tencent.mm.i.g)localObject2).field_mediaId = this.fFo;
                ((com.tencent.mm.i.g)localObject2).field_thumbpath = ((String)localObject1);
                ((com.tencent.mm.i.g)localObject2).field_talker = this.cEE.field_talker;
                ab.i("MicroMsg.NetSceneSendAppMsg", "summersafecdn cdntra checkUseCdn content.type[%d], thumb[%s], useCdnTransClientId[%s], fileType[%d], enable_hitcheck[%b], onlycheckexist[%b], force_aeskeycdn[%b], trysafecdn[%b]", new Object[] { Integer.valueOf(paramf.type), localObject1, this.fFo, Integer.valueOf(((com.tencent.mm.i.g)localObject2).field_fileType), Boolean.valueOf(((com.tencent.mm.i.g)localObject2).field_enable_hitcheck), Boolean.valueOf(((com.tencent.mm.i.g)localObject2).field_onlycheckexist), Boolean.valueOf(((com.tencent.mm.i.g)localObject2).field_force_aeskeycdn), Boolean.valueOf(((com.tencent.mm.i.g)localObject2).field_trysafecdn) });
                if (!com.tencent.mm.al.f.afO().e((com.tencent.mm.i.g)localObject2))
                {
                  ab.e("MicroMsg.NetSceneSendAppMsg", "cdntra addSendTask failed.");
                  this.fFo = "";
                  i = 0;
                }
                else
                {
                  i = 1;
                }
              }
            }
          }
        }
        byp localbyp = (byp)this.rr.fsV.fta;
        dx localdx = new dx();
        localdx.fKw = paramf.appId;
        localdx.wpS = (this.cEE.field_talker + this.cEE.field_msgId + "T" + this.cEE.field_createTime);
        localdx.ntu = j.b.a(paramf, null, null, 0, 0);
        localdx.CreateTime = ((int)bo.aox());
        localdx.nul = this.cEE.field_talker;
        localdx.num = r.Zn();
        localdx.jKs = paramf.type;
        localdx.wpR = paramf.sdkVer;
        localdx.niK = paramf.fgz;
        localObject2 = a.a.Ky().h(this.cEE);
        v.b localb;
        cgh localcgh;
        if (!bo.isNullOrNil((String)localObject2))
        {
          localdx.woU = ((String)localObject2);
          localdx.wpV = paramf.cGQ;
          localdx.wpW = paramf.cGR;
          localdx.wpX = paramf.cGS;
          localb = v.aae().oP(this.mSessionId);
          if (localb != null)
          {
            this.reQ = new wg();
            this.reQ.cNx.url = paramf.url;
            this.reQ.cNx.cNy = localb.getString("prePublishId", "");
            this.reQ.cNx.cNA = localb.getString("preUsername", "");
            this.reQ.cNx.cNB = localb.getString("preChatName", "");
            this.reQ.cNx.cNC = localb.getInt("preMsgIndex", 0);
            this.reQ.cNx.cNG = localb.getInt("sendAppMsgScene", 0);
            this.reQ.cNx.cNH = localb.getInt("getA8KeyScene", 0);
            this.reQ.cNx.cNI = localb.getString("referUrl", null);
            this.reQ.cNx.cNJ = localb.getString("adExtStr", null);
            this.reQ.cNx.cND = this.cEE.field_talker;
            this.reQ.cNx.cNK = paramf.title;
            aw.aaz();
            localObject2 = com.tencent.mm.model.c.YA().arw(this.cEE.field_talker);
            if (localObject2 != null) {
              this.reQ.cNx.cNE = ((ad)localObject2).Oe();
            }
            this.reQ.cNx.cNF = com.tencent.mm.model.n.nv(this.cEE.field_talker);
            str = "";
            localObject2 = str;
            if (paramf.cGU != null)
            {
              localcgh = new cgh();
              localObject2 = Base64.decode(paramf.cGU, 0);
            }
          }
        }
        try
        {
          localcgh.parseFrom((byte[])localObject2);
          localObject2 = str;
          if (localcgh.xRa != null) {
            localObject2 = localcgh.xRa.nmH;
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            int j;
            Object localObject3 = str;
          }
        }
        localbyp.xKY = String.format(Locale.US, "prePublishId=%s&preUserName=%s&preChatName=%s&preChatType=%d&getA8KeyScene=%d&sourceAppId=%s", new Object[] { this.reQ.cNx.cNy, this.reQ.cNx.cNA, this.reQ.cNx.cNB, Integer.valueOf(u.ah(this.reQ.cNx.cNA, this.reQ.cNx.cNB)), Integer.valueOf(this.reQ.cNx.cNH), localObject2 });
        if ((localb != null) && (paramf.type == 33))
        {
          this.vLE = new com.tencent.mm.g.a.n();
          i = localb.getInt("fromScene", 1);
          this.vLE.cmD.scene = i;
          j = localb.getInt("appservicetype", 0);
          this.vLE.cmD.bCV = j;
          localObject2 = localb.getString("preChatName", "");
          if (2 == i)
          {
            str = localb.getString("preUsername", "");
            this.vLE.cmD.cmF = ((String)localObject2 + ":" + str);
            label1781:
            localObject2 = this.cEE.field_talker;
            bool = localb.getBoolean("moreRetrAction", false);
            if (!((String)localObject2).endsWith("@chatroom")) {
              break label2182;
            }
            localObject2 = this.vLE.cmD;
            if (!bool) {
              break label2177;
            }
            i = 5;
            label1828:
            ((n.a)localObject2).action = i;
            this.vLE.cmD.cmE = (paramf.fjh + 1);
            this.vLE.cmD.cmG = paramf.fiW;
            this.vLE.cmD.cmx = paramf.fiX;
            this.vLE.cmD.appId = paramf.fiY;
            this.vLE.cmD.cmI = bo.aox();
            this.vLE.cmD.cmJ = 1;
          }
        }
        else
        {
          ab.d("MicroMsg.NetSceneSendAppMsg", "SnsPostOperationFields: ShareUrlOriginal=%s, ShareUrlOpen=%s, JsAppId=%s", new Object[] { paramf.cGQ, paramf.cGR, paramf.cGS });
          if (!bo.isNullOrNil((String)localObject1))
          {
            localObject2 = com.tencent.mm.a.e.i((String)localObject1, 0, -1);
            if (!bo.ce((byte[])localObject2)) {
              localdx.wpT = new SKBuiltinBuffer_t().setBuffer((byte[])localObject2);
            }
          }
          if (localdx.wpT == null) {
            break label2212;
          }
        }
        label2177:
        label2182:
        label2212:
        for (int i = localdx.wpT.getILen();; i = -1)
        {
          ab.d("MicroMsg.NetSceneSendAppMsg", "doScene thumbFile:[%s] thumbdata:%d", new Object[] { localObject1, Integer.valueOf(i) });
          localbyp.xKW = localdx;
          if ((paramf.fgA != 0) || (paramf.fgw > 26214400)) {
            localbyp.wrs = com.tencent.mm.i.a.ecH;
          }
          localbyp.Md5 = paramf.filemd5;
          localbyp.gwS = this.mSignature;
          ab.i("MicroMsg.NetSceneSendAppMsg", "summersafecdn file md5[%s], signature[%s], type[%d], fromScene[%s]", new Object[] { localbyp.Md5, bo.aqg(localbyp.gwS), Integer.valueOf(localbyp.wrs), localbyp.xKY });
          i = dispatch(parame, this.rr, this);
          AppMethodBeat.o(27361);
          return i;
          localdx.woU = bh.aaQ();
          break;
          this.vLE.cmD.cmF = ((String)localObject2);
          break label1781;
          i = 2;
          break label1828;
          localObject2 = this.vLE.cmD;
          if (bool) {}
          for (i = 4;; i = 1)
          {
            ((n.a)localObject2).action = i;
            break;
          }
        }
      }
    }
  }
  
  public final int getType()
  {
    return 222;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(27362);
    ab.i("MicroMsg.NetSceneSendAppMsg", "summersafecdn cdntra onGYNetEnd [%d,%d,%s] msgId:%d, oldContent[%s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Long.valueOf(this.cpO), this.cEE.field_content });
    if ((paramInt2 == 3) && (paramInt3 == -1) && (!bo.isNullOrNil(this.fFo)))
    {
      ab.w("MicroMsg.NetSceneSendAppMsg", "cdntra using cdn trans,  wait cdn service callback! clientid:%s", new Object[] { this.fFo });
      AppMethodBeat.o(27362);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.cEE.setStatus(5);
      com.tencent.mm.plugin.report.e.qrI.idkeyStat(111L, 34L, 1L, true);
      aw.aaz();
      com.tencent.mm.model.c.YC().a(this.cEE.field_msgId, this.cEE);
      ab.e("MicroMsg.NetSceneSendAppMsg", "send app msg failed, err=" + paramInt2 + "," + paramInt3 + ", msgId " + this.cEE.field_msgId);
      if (paramInt2 == 4) {
        com.tencent.mm.plugin.report.service.h.qsU.e(10420, new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bo.aoy()), Integer.valueOf(com.tencent.mm.al.c.cb(ah.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_THUMBIMAGE), Integer.valueOf(0) });
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(27362);
      return;
    }
    paramArrayOfByte = (byq)((com.tencent.mm.ai.b)paramq).fsW.fta;
    byp localbyp = (byp)((com.tencent.mm.ai.b)paramq).fsV.fta;
    this.cEE.setStatus(2);
    this.cEE.fP(paramArrayOfByte.pIG);
    aw.aaz();
    com.tencent.mm.model.c.YC().a(this.cEE.field_msgId, this.cEE);
    com.tencent.mm.modelstat.b.fRu.a(this.cEE, com.tencent.mm.af.k.k(this.cEE));
    if ((this.reQ != null) && (!bo.isNullOrNil(this.reQ.cNx.url)))
    {
      this.reQ.cNx.cNz = ("msg_" + Long.toString(paramArrayOfByte.pIG));
      com.tencent.mm.sdk.b.a.ymk.l(this.reQ);
    }
    if ((this.reR != null) && (this.reR.cNM.cNN != -1)) {
      com.tencent.mm.sdk.b.a.ymk.l(this.reR);
    }
    paramArrayOfByte = j.b.mY(this.cEE.field_content);
    if ((paramArrayOfByte != null) && ("wx4310bbd51be7d979".equals(paramArrayOfByte.appId))) {
      if ((bo.isNullOrNil(this.cEE.field_talker)) || (!t.lA(this.cEE.field_talker))) {
        break label815;
      }
    }
    label815:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      paramq = "";
      try
      {
        paramArrayOfByte = URLEncoder.encode(paramArrayOfByte.description, "UTF-8");
        paramq = paramArrayOfByte;
      }
      catch (UnsupportedEncodingException paramArrayOfByte)
      {
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.NetSceneSendAppMsg", paramArrayOfByte, "", new Object[0]);
          continue;
          paramInt1 = 1;
        }
      }
      paramArrayOfByte = new StringBuilder("1,");
      if (paramInt1 == 0) {
        break;
      }
      paramInt1 = 2;
      paramq = paramInt1 + ",," + paramq;
      ab.i("MicroMsg.NetSceneSendAppMsg", "androidSystemShareFixed(13717) %s", new Object[] { paramq });
      com.tencent.mm.plugin.report.service.h.qsU.kvStat(13717, paramq);
      if (this.vLE != null)
      {
        this.vLE.cmD.cmH = ("msg_" + this.cEE.field_msgSvrId);
        com.tencent.mm.sdk.b.a.ymk.l(this.vLE);
      }
      if (localbyp.xKW.wpT != null) {
        com.tencent.mm.plugin.report.service.h.qsU.e(10420, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bo.aoy()), Integer.valueOf(com.tencent.mm.al.c.cb(ah.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_THUMBIMAGE), Integer.valueOf(localbyp.xKW.wpT.getILen()) });
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(27362);
      return;
    }
  }
  
  public final m.b securityVerificationChecked(q paramq)
  {
    return m.b.ftu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.ae
 * JD-Core Version:    0.7.0.1
 */