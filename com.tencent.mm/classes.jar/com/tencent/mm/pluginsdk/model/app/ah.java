package com.tencent.mm.pluginsdk.model.app;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.ai.l;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.n.b;
import com.tencent.mm.ao.f;
import com.tencent.mm.chatroom.d.aa;
import com.tencent.mm.g.a.o.a;
import com.tencent.mm.g.a.yf;
import com.tencent.mm.g.a.yf.a;
import com.tencent.mm.g.a.yg;
import com.tencent.mm.g.a.yg.a;
import com.tencent.mm.g.c.du;
import com.tencent.mm.i.g.a;
import com.tencent.mm.l.a.a;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bk;
import com.tencent.mm.model.w;
import com.tencent.mm.model.x;
import com.tencent.mm.model.y.b;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.plugin.groupsolitaire.PluginGroupSolitaire;
import com.tencent.mm.plugin.groupsolitaire.b.d.1;
import com.tencent.mm.plugin.groupsolitaire.b.d.3;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cos;
import com.tencent.mm.protocal.protobuf.cot;
import com.tencent.mm.protocal.protobuf.cxg;
import com.tencent.mm.protocal.protobuf.cxi;
import com.tencent.mm.protocal.protobuf.czj;
import com.tencent.mm.protocal.protobuf.ek;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bl;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Locale;
import junit.framework.Assert;

public final class ah
  extends n
  implements com.tencent.mm.network.k
{
  a BQo;
  private com.tencent.mm.g.a.o BQp;
  long BQq;
  private String bXk;
  com.tencent.mm.al.g callback;
  bl drF;
  int dvY;
  String hhN;
  private g.a hhW;
  String mSessionId;
  long msgId;
  private com.tencent.mm.al.b rr;
  long startTime;
  private yf wFo;
  yg wFp;
  
  public ah(long paramLong, String paramString, int paramInt, a parama)
  {
    this(paramLong, paramString, null);
    AppMethodBeat.i(31054);
    this.dvY = paramInt;
    this.BQo = parama;
    ad.i("MicroMsg.NetSceneSendAppMsg", "NetSceneSendAppMsg directShare[%d]", new Object[] { Integer.valueOf(paramInt) });
    if (this.BQo != null) {
      ad.i("MicroMsg.NetSceneSendAppMsg", "NetSceneSendAppMsg tokenValid[%d], pkgName[%s]", new Object[] { Integer.valueOf(this.BQo.BPv), this.BQo.dvP });
    }
    AppMethodBeat.o(31054);
  }
  
  public ah(long paramLong, String paramString1, String paramString2)
  {
    AppMethodBeat.i(31053);
    this.drF = null;
    this.msgId = 0L;
    this.dvY = 0;
    this.startTime = 0L;
    this.hhN = "";
    this.BQq = 0L;
    this.hhW = new ah.1(this);
    this.msgId = paramLong;
    this.mSessionId = paramString1;
    this.bXk = paramString2;
    b.a locala = new b.a();
    locala.gUU = new cos();
    locala.gUV = new cot();
    locala.uri = "/cgi-bin/micromsg-bin/sendappmsg";
    locala.funcId = 222;
    locala.reqCmdId = 107;
    locala.respCmdId = 1000000107;
    this.rr = locala.atI();
    ad.i("MicroMsg.NetSceneSendAppMsg", "summersafecdn NetSceneSendAppMsg msgid[%d], sessionid[%s], signature[%s], stack[%s]", new Object[] { Long.valueOf(paramLong), paramString1, bt.aGs(paramString2), bt.eGN() });
    AppMethodBeat.o(31053);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(31055);
    this.callback = paramg;
    if (this.startTime == 0L) {
      this.startTime = bt.eGO();
    }
    az.arV();
    this.drF = com.tencent.mm.model.c.apO().rm(this.msgId);
    if ((this.drF == null) || (this.drF.field_msgId != this.msgId))
    {
      AppMethodBeat.o(31055);
      return -1;
    }
    paramg = k.b.rx(this.drF.field_content);
    Object localObject1;
    if (paramg == null)
    {
      localObject1 = ar.aIF(this.drF.field_content);
      if (bt.isNullOrNil(((ar)localObject1).Fys))
      {
        paramg = new k.b();
        paramg.gHg = ((ar)localObject1).md5;
        paramg.type = 8;
        ad.i("MicroMsg.NetSceneSendAppMsg", "create new content. loss appid");
      }
    }
    for (;;)
    {
      localObject1 = "content != null [[" + this.drF.field_content + "]]";
      if (paramg != null) {}
      for (boolean bool = true;; bool = false)
      {
        Assert.assertTrue((String)localObject1, bool);
        if (paramg != null) {
          break label223;
        }
        this.drF = null;
        AppMethodBeat.o(31055);
        return -1;
        paramg = k.b.rx(((ar)localObject1).Fys);
        break;
      }
      label223:
      localObject1 = "";
      Object localObject2;
      if (this.drF.cjN())
      {
        localObject2 = com.tencent.mm.modelvideo.u.Ae(this.drF.field_imgPath);
        if (localObject2 != null) {
          localObject1 = ((s)localObject2).hAq.gJA;
        }
      }
      for (;;)
      {
        localObject2 = com.tencent.mm.model.y.arz().tB(this.mSessionId);
        if ((localObject2 != null) && (((y.b)localObject2).containsKey("_tmpl_webview_transfer_scene")))
        {
          this.wFp = new yg();
          this.wFp.dEL.dEM = ((y.b)localObject2).getInt("_tmpl_webview_transfer_scene", -1);
        }
        if ((paramg.type == 8) || (paramg.type == 9))
        {
          ad.i("MicroMsg.NetSceneSendAppMsg", "cdntra cdn not support Emoji or voiceremind now type:%d", new Object[] { Integer.valueOf(paramg.type) });
          i = 0;
        }
        for (;;)
        {
          if (i == 0) {
            break label1017;
          }
          ad.d("MicroMsg.NetSceneSendAppMsg", "cdntra use cdn return -1 for onGYNetEnd clientId:%s", new Object[] { this.hhN });
          AppMethodBeat.o(31055);
          return 0;
          if (bt.isNullOrNil(this.drF.field_imgPath)) {
            break label2375;
          }
          localObject1 = com.tencent.mm.aw.o.ayF().yg(this.drF.field_imgPath);
          break;
          if (bt.isNullOrNil((String)localObject1))
          {
            ad.i("MicroMsg.NetSceneSendAppMsg", "cdntra cdn not support no thumb msg type:%d", new Object[] { Integer.valueOf(paramg.type) });
            i = 0;
          }
          else
          {
            this.BQq = ((int)com.tencent.mm.vfs.i.aMN((String)localObject1));
            if ((paramg.type == 33) || (paramg.type == 36) || (paramg.type == 46) || (paramg.type == 44) || (paramg.type == 48)) {}
            for (i = 1;; i = 0)
            {
              if ((i != 0) || (this.BQq < 262144L)) {
                break label571;
              }
              ad.w("MicroMsg.NetSceneSendAppMsg", "cdntra thumb[%s][%d] Too Big Not Use CDN TRANS", new Object[] { localObject1, Long.valueOf(this.BQq) });
              i = 0;
              break;
            }
            label571:
            ad.i("MicroMsg.NetSceneSendAppMsg", "cdntra content.type:%d  thumbPath:%s,  thumbLength:%d ", new Object[] { Integer.valueOf(paramg.type), localObject1, Long.valueOf(this.BQq) });
            if (!bt.isNullOrNil(paramg.dbA))
            {
              ad.w("MicroMsg.NetSceneSendAppMsg", "cdntra attach has been upload by cdn msgid:%d", new Object[] { Long.valueOf(this.msgId) });
              i = 0;
            }
            else
            {
              if (i == 0)
              {
                f.awL();
                if (!com.tencent.mm.ao.b.nL(4))
                {
                  f.awL();
                  ad.w("MicroMsg.NetSceneSendAppMsg", "cdntra not use cdn flag:%b ", new Object[] { Boolean.valueOf(com.tencent.mm.ao.b.nL(4)) });
                  i = 0;
                  continue;
                }
              }
              this.hhN = com.tencent.mm.ao.c.a("upappmsg", this.drF.field_createTime, this.drF.field_talker, this.drF.field_msgId);
              if (bt.isNullOrNil(this.hhN))
              {
                ad.w("MicroMsg.NetSceneSendAppMsg", "cdntra genClientId failed not use cdn msgid:%d", new Object[] { Long.valueOf(this.drF.field_msgId) });
                i = 0;
              }
              else
              {
                localObject2 = paramg.apw();
                if (((com.tencent.mm.sdk.platformtools.h.DEBUG) || (com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED)) && ((((com.tencent.mm.i.g)localObject2).fnH != null) || (!bt.isNullOrNil(((com.tencent.mm.i.g)localObject2).field_mediaId)) || (!bt.isNullOrNil(((com.tencent.mm.i.g)localObject2).field_thumbpath)) || (!bt.isNullOrNil(((com.tencent.mm.i.g)localObject2).field_talker))))
                {
                  parame = new RuntimeException("Do not fill reserved fields!");
                  AppMethodBeat.o(31055);
                  throw parame;
                }
                ((com.tencent.mm.i.g)localObject2).fnH = this.hhW;
                ((com.tencent.mm.i.g)localObject2).field_mediaId = this.hhN;
                ((com.tencent.mm.i.g)localObject2).field_thumbpath = ((String)localObject1);
                ((com.tencent.mm.i.g)localObject2).field_talker = this.drF.field_talker;
                ad.i("MicroMsg.NetSceneSendAppMsg", "summersafecdn cdntra checkUseCdn content.type[%d], thumb[%s], useCdnTransClientId[%s], fileType[%d], enable_hitcheck[%b], onlycheckexist[%b], force_aeskeycdn[%b], trysafecdn[%b]", new Object[] { Integer.valueOf(paramg.type), localObject1, this.hhN, Integer.valueOf(((com.tencent.mm.i.g)localObject2).field_fileType), Boolean.valueOf(((com.tencent.mm.i.g)localObject2).field_enable_hitcheck), Boolean.valueOf(((com.tencent.mm.i.g)localObject2).field_onlycheckexist), Boolean.valueOf(((com.tencent.mm.i.g)localObject2).field_force_aeskeycdn), Boolean.valueOf(((com.tencent.mm.i.g)localObject2).field_trysafecdn) });
                if (!f.awL().e((com.tencent.mm.i.g)localObject2))
                {
                  ad.e("MicroMsg.NetSceneSendAppMsg", "cdntra addSendTask failed.");
                  this.hhN = "";
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
        label1017:
        cos localcos = (cos)this.rr.gUS.gUX;
        ek localek = new ek();
        localek.hnC = paramg.appId;
        localek.CyF = (this.drF.field_talker + this.drF.field_msgId + "T" + this.drF.field_createTime);
        localek.gKr = k.b.a(paramg, null, null, 0, 0);
        localek.CreateTime = ((int)bt.aGK());
        localek.sdP = this.drF.field_talker;
        localek.sdQ = com.tencent.mm.model.u.aqG();
        localek.mBH = paramg.type;
        localek.CyE = paramg.sdkVer;
        localek.rNz = paramg.gHh;
        localObject2 = a.a.Wh().o(this.drF);
        y.b localb;
        String str;
        cxi localcxi;
        if (!bt.isNullOrNil((String)localObject2))
        {
          localek.CxC = ((String)localObject2);
          localek.CyI = paramg.dxC;
          localek.CyJ = paramg.dxD;
          localek.CyK = paramg.dxE;
          if (this.BQo != null)
          {
            localek.CyL = this.BQo.BPv;
            localek.rZy = this.BQo.dvP;
          }
          localb = com.tencent.mm.model.y.arz().tC(this.mSessionId);
          if (localb != null)
          {
            this.wFo = new yf();
            this.wFo.dEv.url = paramg.url;
            this.wFo.dEv.dEw = localb.getString("prePublishId", "");
            this.wFo.dEv.dEy = localb.getString("preUsername", "");
            this.wFo.dEv.dEz = localb.getString("preChatName", "");
            this.wFo.dEv.dEA = localb.getInt("preMsgIndex", 0);
            this.wFo.dEv.dEE = localb.getInt("sendAppMsgScene", 0);
            this.wFo.dEv.dEF = localb.getInt("getA8KeyScene", 0);
            this.wFo.dEv.dEG = localb.getString("referUrl", null);
            this.wFo.dEv.dEH = localb.getString("adExtStr", null);
            this.wFo.dEv.dEB = this.drF.field_talker;
            this.wFo.dEv.dEI = paramg.title;
            this.wFo.dEv.dEK = paramg.description;
            az.arV();
            localObject2 = com.tencent.mm.model.c.apM().aHY(this.drF.field_talker);
            if (localObject2 != null) {
              this.wFo.dEv.dEC = ((af)localObject2).ZW();
            }
            this.wFo.dEv.dED = com.tencent.mm.model.q.rY(this.drF.field_talker);
            str = "";
            localObject2 = str;
            if (paramg.dxG != null)
            {
              localcxi = new cxi();
              localObject2 = Base64.decode(paramg.dxG, 0);
            }
          }
        }
        try
        {
          localcxi.parseFrom((byte[])localObject2);
          localObject2 = str;
          if (localcxi.Epv != null) {
            localObject2 = localcxi.Epv.rVL;
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
        localcos.EiK = String.format(Locale.US, "prePublishId=%s&preUserName=%s&preChatName=%s&preChatType=%d&getA8KeyScene=%d&sourceAppId=%s", new Object[] { this.wFo.dEv.dEw, this.wFo.dEv.dEy, this.wFo.dEv.dEz, Integer.valueOf(x.aw(this.wFo.dEv.dEy, this.wFo.dEv.dEz)), Integer.valueOf(this.wFo.dEv.dEF), localObject2 });
        if ((localb != null) && (paramg.type == 33))
        {
          this.BQp = new com.tencent.mm.g.a.o();
          i = localb.getInt("fromScene", 1);
          this.BQp.dbr.scene = i;
          j = localb.getInt("appservicetype", 0);
          this.BQp.dbr.cfd = j;
          localObject2 = localb.getString("preChatName", "");
          if (2 == i)
          {
            str = localb.getString("preUsername", "");
            this.BQp.dbr.dbt = ((String)localObject2 + ":" + str);
            label1866:
            localObject2 = this.drF.field_talker;
            bool = localb.getBoolean("moreRetrAction", false);
            if (!((String)localObject2).endsWith("@chatroom")) {
              break label2331;
            }
            localObject2 = this.BQp.dbr;
            if (!bool) {
              break label2326;
            }
            i = 5;
            label1913:
            ((o.a)localObject2).action = i;
            this.BQp.dbr.dbs = (paramg.gJQ + 1);
            this.BQp.dbr.dbu = paramg.gJD;
            this.BQp.dbr.dbj = paramg.gJE;
            this.BQp.dbr.appId = paramg.gJF;
            this.BQp.dbr.actionTime = bt.aGK();
            this.BQp.dbr.dbw = 1;
          }
        }
        else
        {
          ad.d("MicroMsg.NetSceneSendAppMsg", "SnsPostOperationFields: ShareUrlOriginal=%s, ShareUrlOpen=%s, JsAppId=%s", new Object[] { paramg.dxC, paramg.dxD, paramg.dxE });
          if (!bt.isNullOrNil((String)localObject1))
          {
            localObject2 = com.tencent.mm.vfs.i.aR((String)localObject1, 0, -1);
            if (!bt.cw((byte[])localObject2)) {
              localek.CyG = new SKBuiltinBuffer_t().setBuffer((byte[])localObject2);
            }
          }
          if (localek.CyG == null) {
            break label2361;
          }
        }
        label2326:
        label2331:
        label2361:
        for (int i = localek.CyG.getILen();; i = -1)
        {
          ad.d("MicroMsg.NetSceneSendAppMsg", "doScene thumbFile:[%s] thumbdata:%d", new Object[] { localObject1, Integer.valueOf(i) });
          localcos.EiI = localek;
          if ((paramg.gHi != 0) || (paramg.gHe > 26214400)) {
            localcos.CAG = com.tencent.mm.i.a.fmX;
          }
          localcos.Md5 = paramg.filemd5;
          localcos.ijP = this.bXk;
          localcos.EiM = this.dvY;
          if (((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).ifAddTicketByActionFlag(this.drF.field_talker)) {
            localcos.COT = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aIi(this.drF.field_talker);
          }
          ad.i("MicroMsg.NetSceneSendAppMsg", "summersafecdn file md5[%s], signature[%s], type[%d], fromScene[%s]", new Object[] { localcos.Md5, bt.aGs(localcos.ijP), Integer.valueOf(localcos.CAG), localcos.EiK });
          i = dispatch(parame, this.rr, this);
          AppMethodBeat.o(31055);
          return i;
          localek.CxC = bk.SM();
          break;
          this.BQp.dbr.dbt = ((String)localObject2);
          break label1866;
          i = 2;
          break label1913;
          localObject2 = this.BQp.dbr;
          if (bool) {}
          for (i = 4;; i = 1)
          {
            ((o.a)localObject2).action = i;
            break;
          }
        }
        label2375:
        localObject1 = "";
      }
    }
  }
  
  public final int getType()
  {
    return 222;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(31056);
    ad.i("MicroMsg.NetSceneSendAppMsg", "summersafecdn cdntra onGYNetEnd [%d,%d,%s] msgId:%d, oldContent[%s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Long.valueOf(this.msgId), this.drF.field_content });
    paramArrayOfByte = (cot)((com.tencent.mm.al.b)paramq).gUT.gUX;
    cos localcos = (cos)((com.tencent.mm.al.b)paramq).gUS.gUX;
    if ((paramArrayOfByte != null) && ((paramInt2 == 4) || ((paramInt2 == 0) && (paramInt3 == 0)))) {
      ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).setEnSendMsgActionFlag(paramArrayOfByte.COU);
    }
    if ((paramInt2 == 3) && (paramInt3 == -1) && (!bt.isNullOrNil(this.hhN)))
    {
      ad.w("MicroMsg.NetSceneSendAppMsg", "cdntra using cdn trans,  wait cdn service callback! clientid:%s", new Object[] { this.hhN });
      AppMethodBeat.o(31056);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.drF.setStatus(5);
      com.tencent.mm.plugin.report.e.vIY.idkeyStat(111L, 34L, 1L, true);
      az.arV();
      com.tencent.mm.model.c.apO().a(this.drF.field_msgId, this.drF);
      ad.e("MicroMsg.NetSceneSendAppMsg", "send app msg failed, err=" + paramInt2 + "," + paramInt3 + ", msgId " + this.drF.field_msgId);
      if (paramInt2 == 4) {
        com.tencent.mm.plugin.report.service.h.vKh.f(10420, new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bt.eGO()), Integer.valueOf(com.tencent.mm.ao.c.cu(aj.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_THUMBIMAGE), Integer.valueOf(0) });
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(31056);
      return;
    }
    this.drF.setStatus(2);
    this.drF.kX(paramArrayOfByte.uKZ);
    az.arV();
    com.tencent.mm.model.c.apO().a(this.drF.field_msgId, this.drF);
    com.tencent.mm.modelstat.b.huc.b(this.drF, l.r(this.drF));
    if ((this.wFo != null) && (!bt.isNullOrNil(this.wFo.dEv.url)))
    {
      this.wFo.dEv.dEx = ("msg_" + Long.toString(paramArrayOfByte.uKZ));
      com.tencent.mm.sdk.b.a.ESL.l(this.wFo);
    }
    if ((this.wFp != null) && (this.wFp.dEL.dEM != -1)) {
      com.tencent.mm.sdk.b.a.ESL.l(this.wFp);
    }
    k.b localb = k.b.rx(this.drF.field_content);
    if ((localb != null) && ("wx4310bbd51be7d979".equals(localb.appId))) {
      if ((bt.isNullOrNil(this.drF.field_talker)) || (!w.pF(this.drF.field_talker))) {
        break label967;
      }
    }
    label967:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      paramq = "";
      try
      {
        paramArrayOfByte = URLEncoder.encode(localb.description, "UTF-8");
        paramq = paramArrayOfByte;
      }
      catch (UnsupportedEncodingException paramArrayOfByte)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.NetSceneSendAppMsg", paramArrayOfByte, "", new Object[0]);
          continue;
          paramInt1 = 1;
          continue;
          paramq = ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireReportManager();
          paramArrayOfByte = this.drF;
          if ((paramArrayOfByte == null) || (paramArrayOfByte.field_msgSvrId <= 0L)) {}
          for (;;)
          {
            paramq = ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireReportManager();
            paramArrayOfByte = this.drF;
            if ((paramArrayOfByte == null) || (paramArrayOfByte.field_msgSvrId <= 0L)) {
              break;
            }
            com.tencent.e.h.Iye.aP(new d.3(paramq, paramArrayOfByte));
            break;
            com.tencent.e.h.Iye.f(new d.1(paramq, paramArrayOfByte), "GroupSolitaireReport");
          }
          ((com.tencent.mm.plugin.msgquote.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.msgquote.a.class)).handleQuoteMsgSendResuld(this.drF.field_msgId, this.drF.field_msgSvrId);
        }
      }
      paramArrayOfByte = new StringBuilder("1,");
      if (paramInt1 == 0) {
        break;
      }
      paramInt1 = 2;
      paramq = paramInt1 + ",," + paramq;
      ad.i("MicroMsg.NetSceneSendAppMsg", "androidSystemShareFixed(13717) %s", new Object[] { paramq });
      com.tencent.mm.plugin.report.service.h.vKh.kvStat(13717, paramq);
      if (localb != null) {}
      switch (localb.type)
      {
      default: 
        if ((localb != null) && (w.sm(this.drF.field_talker)))
        {
          paramq = (com.tencent.mm.ai.a)localb.ao(com.tencent.mm.ai.a.class);
          if ((paramq != null) && (paramq.gFM)) {
            com.tencent.mm.chatroom.d.y.a(this.drF, localb);
          }
          if (aa.UU()) {
            ((com.tencent.mm.chatroom.plugin.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.chatroom.plugin.a.class)).handleGroupToolByReceiverAppMsg(this.drF);
          }
        }
        if (this.BQp != null)
        {
          this.BQp.dbr.dbv = ("msg_" + this.drF.field_msgSvrId);
          com.tencent.mm.sdk.b.a.ESL.l(this.BQp);
        }
        if (localcos.EiI.CyG != null) {
          com.tencent.mm.plugin.report.service.h.vKh.f(10420, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bt.eGO()), Integer.valueOf(com.tencent.mm.ao.c.cu(aj.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_THUMBIMAGE), Integer.valueOf(localcos.EiI.CyG.getILen()) });
        }
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(31056);
        return;
      }
    }
  }
  
  public final n.b securityVerificationChecked(com.tencent.mm.network.q paramq)
  {
    return n.b.gVB;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.ah
 * JD-Core Version:    0.7.0.1
 */