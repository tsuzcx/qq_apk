package com.tencent.mm.pluginsdk.model.app;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.chatroom.d.aa;
import com.tencent.mm.g.a.o.a;
import com.tencent.mm.g.a.zq;
import com.tencent.mm.g.a.zq.a;
import com.tencent.mm.g.a.zr;
import com.tencent.mm.g.a.zr.a;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.a;
import com.tencent.mm.m.a.a;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bn;
import com.tencent.mm.model.r;
import com.tencent.mm.model.v;
import com.tencent.mm.model.x;
import com.tencent.mm.model.z;
import com.tencent.mm.model.z.b;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.network.k;
import com.tencent.mm.plugin.groupsolitaire.PluginGroupSolitaire;
import com.tencent.mm.plugin.groupsolitaire.b.d.1;
import com.tencent.mm.plugin.groupsolitaire.b.d.3;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dad;
import com.tencent.mm.protocal.protobuf.dae;
import com.tencent.mm.protocal.protobuf.dja;
import com.tencent.mm.protocal.protobuf.djc;
import com.tencent.mm.protocal.protobuf.dld;
import com.tencent.mm.protocal.protobuf.eq;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bv;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Locale;
import junit.framework.Assert;

public final class ag
  extends n
  implements k
{
  a FfM;
  private com.tencent.mm.g.a.o FfN;
  long FfO;
  com.tencent.mm.ak.f callback;
  private String cff;
  bv dCi;
  int dGQ;
  String idX;
  private g.a ieg;
  String mSessionId;
  long msgId;
  private com.tencent.mm.ak.b rr;
  long startTime;
  private zq zyr;
  zr zys;
  
  public ag(long paramLong, String paramString, int paramInt, a parama)
  {
    this(paramLong, paramString, null);
    AppMethodBeat.i(31054);
    this.dGQ = paramInt;
    this.FfM = parama;
    ae.i("MicroMsg.NetSceneSendAppMsg", "NetSceneSendAppMsg directShare[%d]", new Object[] { Integer.valueOf(paramInt) });
    if (this.FfM != null) {
      ae.i("MicroMsg.NetSceneSendAppMsg", "NetSceneSendAppMsg tokenValid[%d], pkgName[%s]", new Object[] { Integer.valueOf(this.FfM.FeS), this.FfM.dGI });
    }
    AppMethodBeat.o(31054);
  }
  
  public ag(long paramLong, String paramString1, String paramString2)
  {
    AppMethodBeat.i(31053);
    this.dCi = null;
    this.msgId = 0L;
    this.dGQ = 0;
    this.startTime = 0L;
    this.idX = "";
    this.FfO = 0L;
    this.ieg = new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, final d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(31052);
        ae.d("MicroMsg.NetSceneSendAppMsg", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { ag.this.idX, Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd });
        if (paramAnonymousInt == -21005)
        {
          ae.d("MicroMsg.NetSceneSendAppMsg", "cdntra  ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", new Object[] { ag.this.idX });
          AppMethodBeat.o(31052);
          return 0;
        }
        if (paramAnonymousInt != 0)
        {
          ag.this.dCi.setStatus(5);
          com.tencent.mm.plugin.report.e.ywz.idkeyStat(111L, 34L, 1L, true);
          bc.aCg();
          com.tencent.mm.model.c.azI().a(ag.this.dCi.field_msgId, ag.this.dCi);
          new com.tencent.mm.g.b.a.j(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(1), Long.valueOf(ag.this.startTime), Long.valueOf(bu.fpO()), Integer.valueOf(com.tencent.mm.an.c.cC(ak.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Integer.valueOf(0), "" })).aLH();
          ag.this.callback.onSceneEnd(3, paramAnonymousInt, "", ag.this);
          AppMethodBeat.o(31052);
          return 0;
        }
        if (paramAnonymousd != null)
        {
          if (paramAnonymousd.field_retCode != 0)
          {
            ae.e("MicroMsg.NetSceneSendAppMsg", "cdntra sceneResult.retCode :%d arg[%s] info[%s]", new Object[] { Integer.valueOf(paramAnonymousd.field_retCode), paramAnonymousd.field_arg, paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", paramAnonymousd.fKX });
            ag.this.dCi.setStatus(5);
            com.tencent.mm.plugin.report.e.ywz.idkeyStat(111L, 34L, 1L, true);
            bc.aCg();
            com.tencent.mm.model.c.azI().a(ag.this.dCi.field_msgId, ag.this.dCi);
            paramAnonymousc = com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramAnonymousd.field_retCode), Integer.valueOf(1), Long.valueOf(ag.this.startTime), Long.valueOf(bu.fpO()), Integer.valueOf(com.tencent.mm.an.c.cC(ak.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Long.valueOf(paramAnonymousd.field_fileLength), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", paramAnonymousd.fKX });
            new com.tencent.mm.g.b.a.j(paramAnonymousc).aLH();
            new com.tencent.mm.g.b.a.h(paramAnonymousc).aLH();
            ag.this.callback.onSceneEnd(3, paramAnonymousd.field_retCode, "", ag.this);
          }
        }
        else
        {
          if ((paramAnonymousString != null) && (paramAnonymousString.equals(ag.this.idX)) && (ag.this.zys != null) && (ag.this.zys.dQa.dQb != -1))
          {
            com.tencent.mm.sdk.b.a.IvT.l(ag.this.zys);
            ag.this.zys = null;
          }
          AppMethodBeat.o(31052);
          return 0;
        }
        if ((ag.this.FfO > 0L) && (paramAnonymousd.field_fileLength > 0L) && (ag.this.dCi.getType() != 738197553))
        {
          paramAnonymousc = ag.this.FfO + "," + paramAnonymousd.field_fileLength + "," + paramAnonymousd.field_fileId;
          if (ag.this.FfO * 2L <= paramAnonymousd.field_fileLength) {
            break label941;
          }
        }
        label941:
        for (boolean bool = true;; bool = false)
        {
          av.D("SendAppMsgThumbTooBig", paramAnonymousc, bool);
          ae.i("MicroMsg.NetSceneSendAppMsg", "summersafecdn cdnCallback upload attach by cdn, isHitCacheUpload: %d, onlyCheckExist[%b], exist[%b], aesKey[%s], md5[%s]", new Object[] { Integer.valueOf(paramAnonymousd.field_UploadHitCacheType), Boolean.valueOf(paramAnonymousBoolean), Boolean.valueOf(paramAnonymousd.field_exist_whencheck), bu.aSM(paramAnonymousd.field_aesKey), paramAnonymousd.field_filemd5 });
          if (ag.this.dCi.getType() == 738197553) {
            m.a(ag.this.dCi.field_msgId, "", paramAnonymousd, false);
          }
          bc.ajj().a(new ah(ag.this.msgId, paramAnonymousd, new ah.a()
          {
            public final void dg(int paramAnonymous2Int1, int paramAnonymous2Int2)
            {
              AppMethodBeat.i(31051);
              ae.d("MicroMsg.NetSceneSendAppMsg", "summersafecdn cdntra NetSceneSendAppMsgForCdn callback %d,%d", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2) });
              new com.tencent.mm.g.b.a.j(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(1), Long.valueOf(ag.this.startTime), Long.valueOf(bu.fpO()), Integer.valueOf(com.tencent.mm.an.c.cC(ak.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Long.valueOf(paramAnonymousd.field_fileLength), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", paramAnonymousd.fKX })).aLH();
              ag.this.callback.onSceneEnd(paramAnonymous2Int1, paramAnonymous2Int2, "", ag.this);
              AppMethodBeat.o(31051);
            }
          }, ag.this.mSessionId, ag.this.dGQ, ag.this.FfM), 0);
          break;
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
      
      public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        return null;
      }
    };
    this.msgId = paramLong;
    this.mSessionId = paramString1;
    this.cff = paramString2;
    b.a locala = new b.a();
    locala.hQF = new dad();
    locala.hQG = new dae();
    locala.uri = "/cgi-bin/micromsg-bin/sendappmsg";
    locala.funcId = 222;
    locala.hQH = 107;
    locala.respCmdId = 1000000107;
    this.rr = locala.aDS();
    ae.i("MicroMsg.NetSceneSendAppMsg", "summersafecdn NetSceneSendAppMsg msgid[%d], sessionid[%s], signature[%s], stack[%s]", new Object[] { Long.valueOf(paramLong), paramString1, bu.aSM(paramString2), bu.fpN() });
    AppMethodBeat.o(31053);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.f paramf)
  {
    AppMethodBeat.i(31055);
    this.callback = paramf;
    if (this.startTime == 0L) {
      this.startTime = bu.fpO();
    }
    bc.aCg();
    this.dCi = com.tencent.mm.model.c.azI().ys(this.msgId);
    if ((this.dCi == null) || (this.dCi.field_msgId != this.msgId))
    {
      AppMethodBeat.o(31055);
      return -1;
    }
    paramf = k.b.zb(this.dCi.field_content);
    Object localObject1;
    if (paramf == null)
    {
      localObject1 = az.aVt(this.dCi.field_content);
      if (bu.isNullOrNil(((az)localObject1).Jfn))
      {
        paramf = new k.b();
        paramf.hCE = ((az)localObject1).md5;
        paramf.type = 8;
        ae.i("MicroMsg.NetSceneSendAppMsg", "create new content. loss appid");
      }
    }
    for (;;)
    {
      localObject1 = "content != null [[" + this.dCi.field_content + "]]";
      if (paramf != null) {}
      for (boolean bool = true;; bool = false)
      {
        Assert.assertTrue((String)localObject1, bool);
        if (paramf != null) {
          break label223;
        }
        this.dCi = null;
        AppMethodBeat.o(31055);
        return -1;
        paramf = k.b.zb(((az)localObject1).Jfn);
        break;
      }
      label223:
      localObject1 = "";
      Object localObject2;
      if (this.dCi.cyH())
      {
        localObject2 = u.Ia(this.dCi.field_imgPath);
        if (localObject2 != null) {
          localObject1 = ((com.tencent.mm.modelvideo.s)localObject2).ixh.hEY;
        }
      }
      for (;;)
      {
        localObject2 = z.aBG().Bp(this.mSessionId);
        if ((localObject2 != null) && (((z.b)localObject2).containsKey("_tmpl_webview_transfer_scene")))
        {
          this.zys = new zr();
          this.zys.dQa.dQb = ((z.b)localObject2).getInt("_tmpl_webview_transfer_scene", -1);
        }
        if ((paramf.type == 8) || (paramf.type == 9))
        {
          ae.i("MicroMsg.NetSceneSendAppMsg", "cdntra cdn not support Emoji or voiceremind now type:%d", new Object[] { Integer.valueOf(paramf.type) });
          i = 0;
        }
        for (;;)
        {
          if (i == 0) {
            break label1017;
          }
          ae.d("MicroMsg.NetSceneSendAppMsg", "cdntra use cdn return -1 for onGYNetEnd clientId:%s", new Object[] { this.idX });
          AppMethodBeat.o(31055);
          return 0;
          if (bu.isNullOrNil(this.dCi.field_imgPath)) {
            break label2375;
          }
          localObject1 = com.tencent.mm.av.q.aIX().FO(this.dCi.field_imgPath);
          break;
          if (bu.isNullOrNil((String)localObject1))
          {
            ae.i("MicroMsg.NetSceneSendAppMsg", "cdntra cdn not support no thumb msg type:%d", new Object[] { Integer.valueOf(paramf.type) });
            i = 0;
          }
          else
          {
            this.FfO = ((int)com.tencent.mm.vfs.o.aZR((String)localObject1));
            if ((paramf.type == 33) || (paramf.type == 36) || (paramf.type == 46) || (paramf.type == 44) || (paramf.type == 48)) {}
            for (i = 1;; i = 0)
            {
              if ((i != 0) || (this.FfO < 262144L)) {
                break label571;
              }
              ae.w("MicroMsg.NetSceneSendAppMsg", "cdntra thumb[%s][%d] Too Big Not Use CDN TRANS", new Object[] { localObject1, Long.valueOf(this.FfO) });
              i = 0;
              break;
            }
            label571:
            ae.i("MicroMsg.NetSceneSendAppMsg", "cdntra content.type:%d  thumbPath:%s,  thumbLength:%d ", new Object[] { Integer.valueOf(paramf.type), localObject1, Long.valueOf(this.FfO) });
            if (!bu.isNullOrNil(paramf.dlu))
            {
              ae.w("MicroMsg.NetSceneSendAppMsg", "cdntra attach has been upload by cdn msgid:%d", new Object[] { Long.valueOf(this.msgId) });
              i = 0;
            }
            else
            {
              if (i == 0)
              {
                com.tencent.mm.an.f.aGZ();
                if (!com.tencent.mm.an.b.pd(4))
                {
                  com.tencent.mm.an.f.aGZ();
                  ae.w("MicroMsg.NetSceneSendAppMsg", "cdntra not use cdn flag:%b ", new Object[] { Boolean.valueOf(com.tencent.mm.an.b.pd(4)) });
                  i = 0;
                  continue;
                }
              }
              this.idX = com.tencent.mm.an.c.a("upappmsg", this.dCi.field_createTime, this.dCi.field_talker, this.dCi.field_msgId);
              if (bu.isNullOrNil(this.idX))
              {
                ae.w("MicroMsg.NetSceneSendAppMsg", "cdntra genClientId failed not use cdn msgid:%d", new Object[] { Long.valueOf(this.dCi.field_msgId) });
                i = 0;
              }
              else
              {
                localObject2 = paramf.azo();
                if (((com.tencent.mm.sdk.platformtools.j.DEBUG) || (com.tencent.mm.sdk.platformtools.j.IS_FLAVOR_RED)) && ((((com.tencent.mm.i.g)localObject2).fLm != null) || (!bu.isNullOrNil(((com.tencent.mm.i.g)localObject2).field_mediaId)) || (!bu.isNullOrNil(((com.tencent.mm.i.g)localObject2).field_thumbpath)) || (!bu.isNullOrNil(((com.tencent.mm.i.g)localObject2).field_talker))))
                {
                  parame = new RuntimeException("Do not fill reserved fields!");
                  AppMethodBeat.o(31055);
                  throw parame;
                }
                ((com.tencent.mm.i.g)localObject2).fLm = this.ieg;
                ((com.tencent.mm.i.g)localObject2).field_mediaId = this.idX;
                ((com.tencent.mm.i.g)localObject2).field_thumbpath = ((String)localObject1);
                ((com.tencent.mm.i.g)localObject2).field_talker = this.dCi.field_talker;
                ae.i("MicroMsg.NetSceneSendAppMsg", "summersafecdn cdntra checkUseCdn content.type[%d], thumb[%s], useCdnTransClientId[%s], fileType[%d], enable_hitcheck[%b], onlycheckexist[%b], force_aeskeycdn[%b], trysafecdn[%b]", new Object[] { Integer.valueOf(paramf.type), localObject1, this.idX, Integer.valueOf(((com.tencent.mm.i.g)localObject2).field_fileType), Boolean.valueOf(((com.tencent.mm.i.g)localObject2).field_enable_hitcheck), Boolean.valueOf(((com.tencent.mm.i.g)localObject2).field_onlycheckexist), Boolean.valueOf(((com.tencent.mm.i.g)localObject2).field_force_aeskeycdn), Boolean.valueOf(((com.tencent.mm.i.g)localObject2).field_trysafecdn) });
                if (!com.tencent.mm.an.f.aGZ().f((com.tencent.mm.i.g)localObject2))
                {
                  ae.e("MicroMsg.NetSceneSendAppMsg", "cdntra addSendTask failed.");
                  this.idX = "";
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
        dad localdad = (dad)this.rr.hQD.hQJ;
        eq localeq = new eq();
        localeq.ikm = paramf.appId;
        localeq.FOR = (this.dCi.field_talker + this.dCi.field_msgId + "T" + this.dCi.field_createTime);
        localeq.hFS = k.b.a(paramf, null, null, 0, 0);
        localeq.CreateTime = ((int)bu.aRi());
        localeq.uvF = this.dCi.field_talker;
        localeq.uvG = v.aAC();
        localeq.nJA = paramf.type;
        localeq.FOQ = paramf.sdkVer;
        localeq.ucK = paramf.hCF;
        localObject2 = a.a.ZP().o(this.dCi);
        z.b localb;
        String str;
        djc localdjc;
        if (!bu.isNullOrNil((String)localObject2))
        {
          localeq.FNL = ((String)localObject2);
          localeq.FOU = paramf.dIw;
          localeq.FOV = paramf.dIx;
          localeq.FOW = paramf.dIy;
          if (this.FfM != null)
          {
            localeq.FOX = this.FfM.FeS;
            localeq.uqs = this.FfM.dGI;
          }
          localb = z.aBG().Bq(this.mSessionId);
          if (localb != null)
          {
            this.zyr = new zq();
            this.zyr.dPK.url = paramf.url;
            this.zyr.dPK.dPL = localb.getString("prePublishId", "");
            this.zyr.dPK.dPN = localb.getString("preUsername", "");
            this.zyr.dPK.dPO = localb.getString("preChatName", "");
            this.zyr.dPK.dPP = localb.getInt("preMsgIndex", 0);
            this.zyr.dPK.dPT = localb.getInt("sendAppMsgScene", 0);
            this.zyr.dPK.dPU = localb.getInt("getA8KeyScene", 0);
            this.zyr.dPK.dPV = localb.getString("referUrl", null);
            this.zyr.dPK.dPW = localb.getString("adExtStr", null);
            this.zyr.dPK.dPQ = this.dCi.field_talker;
            this.zyr.dPK.dPX = paramf.title;
            this.zyr.dPK.dPZ = paramf.description;
            bc.aCg();
            localObject2 = com.tencent.mm.model.c.azF().BH(this.dCi.field_talker);
            if (localObject2 != null) {
              this.zyr.dPK.dPR = ((an)localObject2).adF();
            }
            this.zyr.dPK.dPS = r.zC(this.dCi.field_talker);
            str = "";
            localObject2 = str;
            if (paramf.dIA != null)
            {
              localdjc = new djc();
              localObject2 = Base64.decode(paramf.dIA, 0);
            }
          }
        }
        try
        {
          localdjc.parseFrom((byte[])localObject2);
          localObject2 = str;
          if (localdjc.HQL != null) {
            localObject2 = localdjc.HQL.umv;
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
        localdad.HJJ = String.format(Locale.US, "prePublishId=%s&preUserName=%s&preChatName=%s&preChatType=%d&getA8KeyScene=%d&sourceAppId=%s", new Object[] { this.zyr.dPK.dPL, this.zyr.dPK.dPN, this.zyr.dPK.dPO, Integer.valueOf(com.tencent.mm.model.y.aH(this.zyr.dPK.dPN, this.zyr.dPK.dPO)), Integer.valueOf(this.zyr.dPK.dPU), localObject2 });
        if ((localb != null) && (paramf.type == 33))
        {
          this.FfN = new com.tencent.mm.g.a.o();
          i = localb.getInt("fromScene", 1);
          this.FfN.dlh.scene = i;
          j = localb.getInt("appservicetype", 0);
          this.FfN.dlh.cmt = j;
          localObject2 = localb.getString("preChatName", "");
          if (2 == i)
          {
            str = localb.getString("preUsername", "");
            this.FfN.dlh.dlj = ((String)localObject2 + ":" + str);
            label1866:
            localObject2 = this.dCi.field_talker;
            bool = localb.getBoolean("moreRetrAction", false);
            if (!((String)localObject2).endsWith("@chatroom")) {
              break label2331;
            }
            localObject2 = this.FfN.dlh;
            if (!bool) {
              break label2326;
            }
            i = 5;
            label1913:
            ((o.a)localObject2).action = i;
            this.FfN.dlh.dli = (paramf.hFr + 1);
            this.FfN.dlh.dlk = paramf.hFb;
            this.FfN.dlh.dkZ = paramf.hFc;
            this.FfN.dlh.appId = paramf.hFd;
            this.FfN.dlh.dlm = bu.aRi();
            this.FfN.dlh.dln = 1;
          }
        }
        else
        {
          ae.d("MicroMsg.NetSceneSendAppMsg", "SnsPostOperationFields: ShareUrlOriginal=%s, ShareUrlOpen=%s, JsAppId=%s", new Object[] { paramf.dIw, paramf.dIx, paramf.dIy });
          if (!bu.isNullOrNil((String)localObject1))
          {
            localObject2 = com.tencent.mm.vfs.o.bb((String)localObject1, 0, -1);
            if (!bu.cF((byte[])localObject2)) {
              localeq.FOS = new SKBuiltinBuffer_t().setBuffer((byte[])localObject2);
            }
          }
          if (localeq.FOS == null) {
            break label2361;
          }
        }
        label2326:
        label2331:
        label2361:
        for (int i = localeq.FOS.getILen();; i = -1)
        {
          ae.d("MicroMsg.NetSceneSendAppMsg", "doScene thumbFile:[%s] thumbdata:%d", new Object[] { localObject1, Integer.valueOf(i) });
          localdad.HJH = localeq;
          if ((paramf.hCG != 0) || (paramf.hCC > 26214400)) {
            localdad.FQT = com.tencent.mm.i.a.fKC;
          }
          localdad.Md5 = paramf.filemd5;
          localdad.jfY = this.cff;
          localdad.HJL = this.dGQ;
          if (((com.tencent.mm.plugin.messenger.foundation.a.s)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.s.class)).ifAddTicketByActionFlag(this.dCi.field_talker)) {
            localdad.Ghk = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().aUV(this.dCi.field_talker);
          }
          ae.i("MicroMsg.NetSceneSendAppMsg", "summersafecdn file md5[%s], signature[%s], type[%d], fromScene[%s]", new Object[] { localdad.Md5, bu.aSM(localdad.jfY), Integer.valueOf(localdad.FQT), localdad.HJJ });
          i = dispatch(parame, this.rr, this);
          AppMethodBeat.o(31055);
          return i;
          localeq.FNL = bn.We();
          break;
          this.FfN.dlh.dlj = ((String)localObject2);
          break label1866;
          i = 2;
          break label1913;
          localObject2 = this.FfN.dlh;
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
    ae.i("MicroMsg.NetSceneSendAppMsg", "summersafecdn cdntra onGYNetEnd [%d,%d,%s] msgId:%d, oldContent[%s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Long.valueOf(this.msgId), this.dCi.field_content });
    paramArrayOfByte = (dae)((com.tencent.mm.ak.b)paramq).hQE.hQJ;
    dad localdad = (dad)((com.tencent.mm.ak.b)paramq).hQD.hQJ;
    if ((paramArrayOfByte != null) && ((paramInt2 == 4) || ((paramInt2 == 0) && (paramInt3 == 0)))) {
      ((com.tencent.mm.plugin.messenger.foundation.a.s)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.s.class)).setEnSendMsgActionFlag(paramArrayOfByte.Ghl);
    }
    if ((paramInt2 == 3) && (paramInt3 == -1) && (!bu.isNullOrNil(this.idX)))
    {
      ae.w("MicroMsg.NetSceneSendAppMsg", "cdntra using cdn trans,  wait cdn service callback! clientid:%s", new Object[] { this.idX });
      AppMethodBeat.o(31056);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.dCi.setStatus(5);
      com.tencent.mm.plugin.report.e.ywz.idkeyStat(111L, 34L, 1L, true);
      bc.aCg();
      com.tencent.mm.model.c.azI().a(this.dCi.field_msgId, this.dCi);
      ae.e("MicroMsg.NetSceneSendAppMsg", "send app msg failed, err=" + paramInt2 + "," + paramInt3 + ", msgId " + this.dCi.field_msgId);
      if (paramInt2 == 4) {
        com.tencent.mm.plugin.report.service.g.yxI.f(10420, new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bu.fpO()), Integer.valueOf(com.tencent.mm.an.c.cC(ak.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_THUMBIMAGE), Integer.valueOf(0) });
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(31056);
      return;
    }
    this.dCi.setStatus(2);
    this.dCi.qM(paramArrayOfByte.xrk);
    bc.aCg();
    com.tencent.mm.model.c.azI().a(this.dCi.field_msgId, this.dCi);
    ((com.tencent.mm.plugin.record.a.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.record.a.f.class)).za(this.dCi.field_msgId);
    com.tencent.mm.modelstat.b.iqT.b(this.dCi, com.tencent.mm.ah.l.r(this.dCi));
    if ((this.zyr != null) && (!bu.isNullOrNil(this.zyr.dPK.url)))
    {
      this.zyr.dPK.dPM = ("msg_" + Long.toString(paramArrayOfByte.xrk));
      com.tencent.mm.sdk.b.a.IvT.l(this.zyr);
    }
    if ((this.zys != null) && (this.zys.dQa.dQb != -1)) {
      com.tencent.mm.sdk.b.a.IvT.l(this.zys);
    }
    k.b localb = k.b.zb(this.dCi.field_content);
    if ((localb != null) && ("wx4310bbd51be7d979".equals(localb.appId))) {
      if ((bu.isNullOrNil(this.dCi.field_talker)) || (!x.wb(this.dCi.field_talker))) {
        break label987;
      }
    }
    label987:
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
          ae.printErrStackTrace("MicroMsg.NetSceneSendAppMsg", paramArrayOfByte, "", new Object[0]);
          continue;
          paramInt1 = 1;
          continue;
          paramq = ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireReportManager();
          paramArrayOfByte = this.dCi;
          if ((paramArrayOfByte == null) || (paramArrayOfByte.field_msgSvrId <= 0L)) {}
          for (;;)
          {
            paramq = ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireReportManager();
            paramArrayOfByte = this.dCi;
            if ((paramArrayOfByte == null) || (paramArrayOfByte.field_msgSvrId <= 0L)) {
              break;
            }
            com.tencent.e.h.MqF.aO(new d.3(paramq, paramArrayOfByte));
            break;
            com.tencent.e.h.MqF.f(new d.1(paramq, paramArrayOfByte), "GroupSolitaireReport");
          }
          ((com.tencent.mm.plugin.msgquote.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.msgquote.a.class)).handleQuoteMsgSendResuld(this.dCi.field_msgId, this.dCi.field_msgSvrId);
        }
      }
      paramArrayOfByte = new StringBuilder("1,");
      if (paramInt1 == 0) {
        break;
      }
      paramInt1 = 2;
      paramq = paramInt1 + ",," + paramq;
      ae.i("MicroMsg.NetSceneSendAppMsg", "androidSystemShareFixed(13717) %s", new Object[] { paramq });
      com.tencent.mm.plugin.report.service.g.yxI.kvStat(13717, paramq);
      if (localb != null) {}
      switch (localb.type)
      {
      default: 
        if ((localb != null) && (x.zU(this.dCi.field_talker)))
        {
          paramq = (com.tencent.mm.ah.a)localb.ao(com.tencent.mm.ah.a.class);
          if ((paramq != null) && (paramq.hBk)) {
            com.tencent.mm.chatroom.d.y.a(this.dCi, localb);
          }
          if (aa.Yr()) {
            ((com.tencent.mm.chatroom.plugin.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.chatroom.plugin.a.class)).handleGroupToolByReceiverAppMsg(this.dCi);
          }
        }
        if (this.FfN != null)
        {
          this.FfN.dlh.dll = ("msg_" + this.dCi.field_msgSvrId);
          com.tencent.mm.sdk.b.a.IvT.l(this.FfN);
        }
        if (localdad.HJH.FOS != null) {
          com.tencent.mm.plugin.report.service.g.yxI.f(10420, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bu.fpO()), Integer.valueOf(com.tencent.mm.an.c.cC(ak.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_THUMBIMAGE), Integer.valueOf(localdad.HJH.FOS.getILen()) });
        }
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(31056);
        return;
      }
    }
  }
  
  public final n.b securityVerificationChecked(com.tencent.mm.network.q paramq)
  {
    return n.b.hRi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.ag
 * JD-Core Version:    0.7.0.1
 */