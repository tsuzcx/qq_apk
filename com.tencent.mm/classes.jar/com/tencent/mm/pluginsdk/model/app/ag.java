package com.tencent.mm.pluginsdk.model.app;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.aj.l;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.q.b;
import com.tencent.mm.an.t;
import com.tencent.mm.chatroom.d.aa;
import com.tencent.mm.f.a.acf;
import com.tencent.mm.f.a.acf.a;
import com.tencent.mm.f.a.acg;
import com.tencent.mm.f.a.acg.a;
import com.tencent.mm.f.a.q.a;
import com.tencent.mm.f.b.a.ae;
import com.tencent.mm.f.c.et;
import com.tencent.mm.i.g.a;
import com.tencent.mm.m.a.a;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bs;
import com.tencent.mm.model.z;
import com.tencent.mm.modelvideo.w;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.groupsolitaire.PluginGroupSolitaire;
import com.tencent.mm.plugin.groupsolitaire.b.d.1;
import com.tencent.mm.plugin.groupsolitaire.b.d.3;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.edg;
import com.tencent.mm.protocal.protobuf.edh;
import com.tencent.mm.protocal.protobuf.emn;
import com.tencent.mm.protocal.protobuf.emp;
import com.tencent.mm.protocal.protobuf.eor;
import com.tencent.mm.protocal.protobuf.fa;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMUncaughtExceptionHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.viewitems.o;
import com.tencent.mm.ui.chatting.viewitems.o.d;
import com.tencent.mm.vfs.u;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Locale;
import junit.framework.Assert;

public final class ag
  extends com.tencent.mm.an.q
  implements com.tencent.mm.network.m
{
  private acf JVA;
  private acg JVB;
  private a QWW;
  private com.tencent.mm.f.a.q QWX;
  private long QWY;
  private com.tencent.mm.an.i callback;
  private ca fNz;
  private int fSq;
  private String lPn;
  private g.a lPx;
  private String mSessionId;
  private String mSignature;
  private long msgId;
  private com.tencent.mm.an.d rr;
  private long startTime;
  
  public ag(long paramLong, String paramString, int paramInt, a parama)
  {
    this(paramLong, paramString, null);
    AppMethodBeat.i(31054);
    this.fSq = paramInt;
    this.QWW = parama;
    Log.i("MicroMsg.NetSceneSendAppMsg", "NetSceneSendAppMsg directShare[%d]", new Object[] { Integer.valueOf(paramInt) });
    if (this.QWW != null) {
      Log.i("MicroMsg.NetSceneSendAppMsg", "NetSceneSendAppMsg tokenValid[%d], pkgName[%s]", new Object[] { Integer.valueOf(this.QWW.QVW), this.QWW.pkgName });
    }
    AppMethodBeat.o(31054);
  }
  
  public ag(long paramLong, String paramString1, String paramString2)
  {
    AppMethodBeat.i(31053);
    this.fNz = null;
    this.msgId = 0L;
    this.fSq = 0;
    this.startTime = 0L;
    this.lPn = "";
    this.QWY = 0L;
    this.lPx = new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, final com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(31052);
        Log.d("MicroMsg.NetSceneSendAppMsg", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { ag.a(ag.this), Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd });
        if (paramAnonymousInt == -21005)
        {
          Log.d("MicroMsg.NetSceneSendAppMsg", "cdntra  ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", new Object[] { ag.a(ag.this) });
          AppMethodBeat.o(31052);
          return 0;
        }
        bh.beI();
        paramAnonymousc = com.tencent.mm.model.c.bbO().Oq(ag.b(ag.this).field_msgId);
        if (paramAnonymousInt != 0)
        {
          paramAnonymousc.setStatus(5);
          com.tencent.mm.plugin.report.f.Iyx.idkeyStat(111L, 34L, 1L, true);
          bh.beI();
          com.tencent.mm.model.c.bbO().a(paramAnonymousc.field_msgId, paramAnonymousc);
          new ae(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(1), Long.valueOf(ag.c(ag.this)), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.aq.c.cV(MMApplicationContext.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Integer.valueOf(0), "" })).bpa();
          ag.d(ag.this).onSceneEnd(3, paramAnonymousInt, "", ag.this);
          AppMethodBeat.o(31052);
          return 0;
        }
        if (paramAnonymousd != null)
        {
          if (paramAnonymousd.field_retCode != 0)
          {
            Log.e("MicroMsg.NetSceneSendAppMsg", "cdntra sceneResult.retCode :%d arg[%s] info[%s]", new Object[] { Integer.valueOf(paramAnonymousd.field_retCode), paramAnonymousd.field_arg, paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", paramAnonymousd.iUs });
            paramAnonymousc.setStatus(5);
            com.tencent.mm.plugin.report.f.Iyx.idkeyStat(111L, 34L, 1L, true);
            bh.beI();
            com.tencent.mm.model.c.bbO().a(paramAnonymousc.field_msgId, paramAnonymousc);
            paramAnonymousc = com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramAnonymousd.field_retCode), Integer.valueOf(1), Long.valueOf(ag.c(ag.this)), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.aq.c.cV(MMApplicationContext.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Long.valueOf(paramAnonymousd.field_fileLength), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", paramAnonymousd.iUs });
            new ae(paramAnonymousc).bpa();
            new com.tencent.mm.f.b.a.ac(paramAnonymousc).bpa();
            ag.d(ag.this).onSceneEnd(3, paramAnonymousd.field_retCode, "", ag.this);
          }
        }
        else
        {
          if ((paramAnonymousString != null) && (paramAnonymousString.equals(ag.a(ag.this))) && (ag.j(ag.this) != null) && (ag.j(ag.this).gcu.gcv != -1))
          {
            EventCenter.instance.publish(ag.j(ag.this));
            ag.k(ag.this);
          }
          AppMethodBeat.o(31052);
          return 0;
        }
        String str;
        if ((ag.e(ag.this) > 0L) && (paramAnonymousd.field_fileLength > 0L) && (paramAnonymousc.getType() != 738197553))
        {
          str = ag.e(ag.this) + "," + paramAnonymousd.field_fileLength + "," + paramAnonymousd.field_fileId;
          if (ag.e(ag.this) * 2L <= paramAnonymousd.field_fileLength) {
            break label913;
          }
        }
        label913:
        for (boolean bool = true;; bool = false)
        {
          MMUncaughtExceptionHandler.assertTrue("SendAppMsgThumbTooBig", str, bool);
          Log.i("MicroMsg.NetSceneSendAppMsg", "summersafecdn cdnCallback upload attach by cdn, isHitCacheUpload: %d, onlyCheckExist[%b], exist[%b], aesKey[%s], md5[%s]", new Object[] { Integer.valueOf(paramAnonymousd.field_UploadHitCacheType), Boolean.valueOf(paramAnonymousBoolean), Boolean.valueOf(paramAnonymousd.field_exist_whencheck), Util.secPrint(paramAnonymousd.field_aesKey), paramAnonymousd.field_filemd5 });
          if (paramAnonymousc.getType() == 738197553) {
            m.a(paramAnonymousc.field_msgId, "", paramAnonymousd, false);
          }
          bh.aGY().a(new ah(ag.f(ag.this), paramAnonymousd, new ah.a()
          {
            public final void dN(int paramAnonymous2Int1, int paramAnonymous2Int2)
            {
              AppMethodBeat.i(31051);
              Log.d("MicroMsg.NetSceneSendAppMsg", "summersafecdn cdntra NetSceneSendAppMsgForCdn callback %d,%d", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2) });
              new ae(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(1), Long.valueOf(ag.c(ag.this)), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.aq.c.cV(MMApplicationContext.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Long.valueOf(paramAnonymousd.field_fileLength), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", paramAnonymousd.iUs })).bpa();
              ag.d(ag.this).onSceneEnd(paramAnonymous2Int1, paramAnonymous2Int2, "", ag.this);
              AppMethodBeat.o(31051);
            }
          }, ag.g(ag.this), ag.h(ag.this), ag.i(ag.this)), 0);
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
    this.mSignature = paramString2;
    d.a locala = new d.a();
    locala.lBU = new edg();
    locala.lBV = new edh();
    locala.uri = "/cgi-bin/micromsg-bin/sendappmsg";
    locala.funcId = 222;
    locala.lBW = 107;
    locala.respCmdId = 1000000107;
    this.rr = locala.bgN();
    Log.i("MicroMsg.NetSceneSendAppMsg", "summersafecdn NetSceneSendAppMsg msgid[%d], sessionid[%s], signature[%s], stack[%s]", new Object[] { Long.valueOf(paramLong), paramString1, Util.secPrint(paramString2), Util.getStack() });
    AppMethodBeat.o(31053);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.an.i parami)
  {
    AppMethodBeat.i(31055);
    this.callback = parami;
    if (this.startTime == 0L) {
      this.startTime = Util.nowMilliSecond();
    }
    bh.beI();
    this.fNz = com.tencent.mm.model.c.bbO().Oq(this.msgId);
    if ((this.fNz == null) || (this.fNz.field_msgId != this.msgId))
    {
      AppMethodBeat.o(31055);
      return -1;
    }
    Object localObject1 = k.b.OQ(this.fNz.field_content);
    if (localObject1 == null)
    {
      localObject1 = be.bwQ(this.fNz.field_content);
      if (Util.isNullOrNil(((be)localObject1).VFa))
      {
        parami = new k.b();
        parami.llZ = ((be)localObject1).md5;
        parami.type = 8;
        Log.i("MicroMsg.NetSceneSendAppMsg", "create new content. loss appid");
        localObject1 = "content != null [[" + this.fNz.field_content + "]]";
        if (parami == null) {
          break label359;
        }
      }
    }
    Object localObject2;
    label359:
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue((String)localObject1, bool);
      if (parami != null) {
        break label365;
      }
      this.fNz = null;
      AppMethodBeat.o(31055);
      return -1;
      parami = k.b.OQ(((be)localObject1).VFa);
      break;
      parami = (com.tencent.mm.an.i)localObject1;
      if (((k.b)localObject1).type != 6) {
        break;
      }
      if (this.fNz.field_msgSvrId > 0L)
      {
        parami = (com.tencent.mm.an.i)localObject1;
        if (this.fNz.field_status == 2) {
          break;
        }
      }
      localObject2 = (com.tencent.mm.aj.a.b)((k.b)localObject1).ar(com.tencent.mm.aj.a.b.class);
      parami = (com.tencent.mm.an.i)localObject1;
      if (localObject2 == null) {
        break;
      }
      if (((com.tencent.mm.aj.a.b)localObject2).lqB == 0L)
      {
        parami = (com.tencent.mm.an.i)localObject1;
        if (Util.isNullOrNil(((com.tencent.mm.aj.a.b)localObject2).lqC)) {
          break;
        }
      }
      ((com.tencent.mm.aj.a.b)localObject2).reset();
      this.fNz.setContent(k.b.a((k.b)localObject1, null, null));
      ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().a(this.fNz.field_msgId, this.fNz);
      parami = (com.tencent.mm.an.i)localObject1;
      break;
    }
    label365:
    localObject1 = "";
    if (this.fNz.dlS())
    {
      localObject2 = com.tencent.mm.modelvideo.y.Yk(this.fNz.field_imgPath);
      if (localObject2 != null) {
        localObject1 = ((w)localObject2).mhZ.low;
      }
    }
    for (;;)
    {
      if ((parami.type == 8) || (parami.type == 9))
      {
        Log.i("MicroMsg.NetSceneSendAppMsg", "cdntra cdn not support Emoji or voiceremind now type:%d", new Object[] { Integer.valueOf(parami.type) });
        i = 0;
      }
      for (;;)
      {
        if (i == 0) {
          break label1101;
        }
        Log.d("MicroMsg.NetSceneSendAppMsg", "cdntra use cdn return -1 for onGYNetEnd clientId:%s", new Object[] { this.lPn });
        AppMethodBeat.o(31055);
        return 0;
        if (Util.isNullOrNil(this.fNz.field_imgPath)) {
          break label2530;
        }
        localObject1 = com.tencent.mm.ay.q.bmh().VW(this.fNz.field_imgPath);
        break;
        if (Util.isNullOrNil((String)localObject1))
        {
          Log.i("MicroMsg.NetSceneSendAppMsg", "cdntra cdn not support no thumb msg type:%d", new Object[] { Integer.valueOf(parami.type) });
          i = 0;
        }
        else
        {
          this.QWY = ((int)u.bBQ((String)localObject1));
          if ((parami.type == 33) || (parami.type == 36) || (parami.type == 46) || (parami.type == 44) || (parami.type == 48)) {}
          for (i = 1;; i = 0)
          {
            if ((i != 0) || (this.QWY < 262144L)) {
              break label655;
            }
            Log.w("MicroMsg.NetSceneSendAppMsg", "cdntra thumb[%s][%d] Too Big Not Use CDN TRANS", new Object[] { localObject1, Long.valueOf(this.QWY) });
            i = 0;
            break;
          }
          label655:
          Log.i("MicroMsg.NetSceneSendAppMsg", "cdntra content.type:%d  thumbPath:%s,  thumbLength:%d ", new Object[] { Integer.valueOf(parami.type), localObject1, Long.valueOf(this.QWY) });
          if (!Util.isNullOrNil(parami.fvr))
          {
            Log.w("MicroMsg.NetSceneSendAppMsg", "cdntra attach has been upload by cdn msgid:%d", new Object[] { Long.valueOf(this.msgId) });
            i = 0;
          }
          else
          {
            if (i == 0)
            {
              com.tencent.mm.aq.f.bkg();
              if (!com.tencent.mm.aq.b.vQ(4))
              {
                com.tencent.mm.aq.f.bkg();
                Log.w("MicroMsg.NetSceneSendAppMsg", "cdntra not use cdn flag:%b ", new Object[] { Boolean.valueOf(com.tencent.mm.aq.b.vQ(4)) });
                i = 0;
                continue;
              }
            }
            this.lPn = com.tencent.mm.aq.c.a("upappmsg", this.fNz.field_createTime, this.fNz.field_talker, this.fNz.field_msgId);
            if (Util.isNullOrNil(this.lPn))
            {
              Log.w("MicroMsg.NetSceneSendAppMsg", "cdntra genClientId failed not use cdn msgid:%d", new Object[] { Long.valueOf(this.fNz.field_msgId) });
              i = 0;
            }
            else
            {
              localObject2 = parami.bbs();
              if (((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED)) && ((((com.tencent.mm.i.g)localObject2).iUG != null) || (!Util.isNullOrNil(((com.tencent.mm.i.g)localObject2).field_mediaId)) || (!Util.isNullOrNil(((com.tencent.mm.i.g)localObject2).field_thumbpath)) || (!Util.isNullOrNil(((com.tencent.mm.i.g)localObject2).field_talker))))
              {
                paramg = new RuntimeException("Do not fill reserved fields!");
                AppMethodBeat.o(31055);
                throw paramg;
              }
              ((com.tencent.mm.i.g)localObject2).iUG = this.lPx;
              ((com.tencent.mm.i.g)localObject2).field_mediaId = this.lPn;
              ((com.tencent.mm.i.g)localObject2).field_thumbpath = ((String)localObject1);
              ((com.tencent.mm.i.g)localObject2).field_talker = this.fNz.field_talker;
              Log.i("MicroMsg.NetSceneSendAppMsg", "summersafecdn cdntra checkUseCdn content.type[%d], thumb[%s], useCdnTransClientId[%s], fileType[%d], enable_hitcheck[%b], onlycheckexist[%b], force_aeskeycdn[%b], trysafecdn[%b]", new Object[] { Integer.valueOf(parami.type), localObject1, this.lPn, Integer.valueOf(((com.tencent.mm.i.g)localObject2).field_fileType), Boolean.valueOf(((com.tencent.mm.i.g)localObject2).field_enable_hitcheck), Boolean.valueOf(((com.tencent.mm.i.g)localObject2).field_onlycheckexist), Boolean.valueOf(((com.tencent.mm.i.g)localObject2).field_force_aeskeycdn), Boolean.valueOf(((com.tencent.mm.i.g)localObject2).field_trysafecdn) });
              if (!com.tencent.mm.aq.f.bkg().f((com.tencent.mm.i.g)localObject2))
              {
                Log.e("MicroMsg.NetSceneSendAppMsg", "cdntra addSendTask failed.");
                this.lPn = "";
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
      label1101:
      ad.b localb = com.tencent.mm.ui.transmit.c.bAK(this.mSessionId);
      if ((localb != null) && (localb.containsKey("_tmpl_webview_transfer_scene")))
      {
        this.JVB = new acg();
        this.JVB.gcu.gcv = localb.getInt("_tmpl_webview_transfer_scene", -1);
      }
      edg localedg = (edg)d.b.b(this.rr.lBR);
      fa localfa = new fa();
      localfa.lVG = parami.appId;
      localfa.RJQ = (this.fNz.field_talker + this.fNz.field_msgId + "T" + this.fNz.field_createTime);
      localfa.lpy = k.b.a(parami, null, null, 0, 0);
      localfa.CreateTime = ((int)Util.nowSecond());
      localfa.CRQ = this.fNz.field_talker;
      localfa.CRR = z.bcZ();
      localfa.rWu = parami.type;
      localfa.RJP = parami.sdkVer;
      localfa.Cqs = parami.lma;
      localObject2 = a.a.atD().o(this.fNz);
      String str;
      emp localemp;
      if (!Util.isNullOrNil((String)localObject2))
      {
        localfa.RII = ((String)localObject2);
        localfa.RJT = parami.fUg;
        localfa.RJU = parami.fUh;
        localfa.RJV = parami.fUi;
        if (this.QWW != null)
        {
          localfa.RJW = this.QWW.QVW;
          localfa.CqB = this.QWW.pkgName;
        }
        if (localb != null)
        {
          this.JVA = new acf();
          this.JVA.gce.url = parami.url;
          this.JVA.gce.gcf = localb.getString("prePublishId", "");
          this.JVA.gce.gch = localb.getString("preUsername", "");
          this.JVA.gce.gci = localb.getString("preChatName", "");
          this.JVA.gce.gcj = localb.getInt("preMsgIndex", 0);
          this.JVA.gce.gcn = localb.getInt("sendAppMsgScene", 0);
          this.JVA.gce.gco = localb.getInt("getA8KeyScene", 0);
          this.JVA.gce.gcp = localb.getString("referUrl", null);
          this.JVA.gce.gcq = localb.getString("adExtStr", null);
          this.JVA.gce.gck = this.fNz.field_talker;
          this.JVA.gce.gcr = parami.title;
          this.JVA.gce.gct = parami.description;
          bh.beI();
          localObject2 = com.tencent.mm.model.c.bbL().RG(this.fNz.field_talker);
          if (localObject2 != null) {
            this.JVA.gce.gcl = ((as)localObject2).ayr();
          }
          this.JVA.gce.gcm = com.tencent.mm.model.v.Pu(this.fNz.field_talker);
          str = "";
          localObject2 = str;
          if (parami.fUk != null)
          {
            localemp = new emp();
            localObject2 = Base64.decode(parami.fUk, 0);
          }
        }
      }
      try
      {
        localemp.parseFrom((byte[])localObject2);
        localObject2 = str;
        if (localemp.Upg != null) {
          localObject2 = localemp.Upg.CIO;
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
      localedg.UhK = String.format(Locale.US, "prePublishId=%s&preUserName=%s&preChatName=%s&preChatType=%d&getA8KeyScene=%d&sourceAppId=%s", new Object[] { this.JVA.gce.gcf, this.JVA.gce.gch, this.JVA.gce.gci, Integer.valueOf(com.tencent.mm.model.ac.aN(this.JVA.gce.gch, this.JVA.gce.gci)), Integer.valueOf(this.JVA.gce.gco), localObject2 });
      if ((localb != null) && (parami.type == 33))
      {
        this.QWX = new com.tencent.mm.f.a.q();
        i = localb.getInt("fromScene", 1);
        this.QWX.fva.scene = i;
        j = localb.getInt("appservicetype", 0);
        this.QWX.fva.cwR = j;
        localObject2 = localb.getString("preChatName", "");
        if (2 == i)
        {
          str = localb.getString("preUsername", "");
          this.QWX.fva.fvd = ((String)localObject2 + ":" + str);
          label1993:
          localObject2 = this.fNz.field_talker;
          bool = localb.getBoolean("moreRetrAction", false);
          if (!((String)localObject2).endsWith("@chatroom")) {
            break label2486;
          }
          localObject2 = this.QWX.fva;
          if (!bool) {
            break label2481;
          }
          i = 5;
          label2040:
          ((q.a)localObject2).action = i;
          this.QWX.fva.fvc = (parami.loT + 1);
          this.QWX.fva.fve = parami.loz;
          this.QWX.fva.fvb = parami.loA;
          this.QWX.fva.appId = parami.loB;
          this.QWX.fva.appVersion = parami.loU;
          this.QWX.fva.fvg = Util.nowSecond();
          this.QWX.fva.fvh = 1;
          this.QWX.fva.fvj = parami.loF;
        }
      }
      else
      {
        Log.d("MicroMsg.NetSceneSendAppMsg", "SnsPostOperationFields: ShareUrlOriginal=%s, ShareUrlOpen=%s, JsAppId=%s", new Object[] { parami.fUg, parami.fUh, parami.fUi });
        if (!Util.isNullOrNil((String)localObject1))
        {
          localObject2 = u.aY((String)localObject1, 0, -1);
          if (!Util.isNullOrNil((byte[])localObject2)) {
            localfa.RJR = new eae().dc((byte[])localObject2);
          }
        }
        if (localfa.RJR == null) {
          break label2516;
        }
      }
      label2481:
      label2486:
      label2516:
      for (int i = localfa.RJR.Ufv;; i = -1)
      {
        Log.d("MicroMsg.NetSceneSendAppMsg", "doScene thumbFile:[%s] thumbdata:%d", new Object[] { localObject1, Integer.valueOf(i) });
        localedg.UhI = localfa;
        if ((parami.lmb != 0) || (parami.llX > 26214400)) {
          localedg.RLs = com.tencent.mm.i.a.iTW;
        }
        localedg.Md5 = parami.filemd5;
        localedg.mVB = this.mSignature;
        localedg.UhM = this.fSq;
        if (((com.tencent.mm.plugin.messenger.foundation.a.v)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.messenger.foundation.a.v.class)).ifAddTicketByActionFlag(this.fNz.field_talker)) {
          localedg.ScZ = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().bws(this.fNz.field_talker);
        }
        Log.i("MicroMsg.NetSceneSendAppMsg", "summersafecdn file md5[%s], signature[%s], type[%d], fromScene[%s]", new Object[] { localedg.Md5, Util.secPrint(localedg.mVB), Integer.valueOf(localedg.RLs), localedg.UhK });
        i = dispatch(paramg, this.rr, this);
        AppMethodBeat.o(31055);
        return i;
        localfa.RII = bs.apc();
        break;
        this.QWX.fva.fvd = ((String)localObject2);
        break label1993;
        i = 2;
        break label2040;
        localObject2 = this.QWX.fva;
        if (bool) {}
        for (i = 4;; i = 1)
        {
          ((q.a)localObject2).action = i;
          break;
        }
      }
      label2530:
      localObject1 = "";
    }
  }
  
  public final int getType()
  {
    return 222;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(31056);
    Log.i("MicroMsg.NetSceneSendAppMsg", "summersafecdn cdntra onGYNetEnd [%d,%d,%s] msgId:%d, oldContent[%s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Long.valueOf(this.msgId), Util.secPrint(this.fNz.field_content) });
    paramArrayOfByte = (edh)d.c.b(((com.tencent.mm.an.d)params).lBS);
    edg localedg = (edg)d.b.b(((com.tencent.mm.an.d)params).lBR);
    if ((paramArrayOfByte != null) && ((paramInt2 == 4) || ((paramInt2 == 0) && (paramInt3 == 0)))) {
      ((com.tencent.mm.plugin.messenger.foundation.a.v)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.messenger.foundation.a.v.class)).setEnSendMsgActionFlag(paramArrayOfByte.Sda);
    }
    if ((paramInt2 == 3) && (paramInt3 == -1) && (!Util.isNullOrNil(this.lPn)))
    {
      Log.w("MicroMsg.NetSceneSendAppMsg", "cdntra using cdn trans,  wait cdn service callback! clientid:%s", new Object[] { this.lPn });
      AppMethodBeat.o(31056);
      return;
    }
    bh.beI();
    localca = com.tencent.mm.model.c.bbO().Oq(this.fNz.field_msgId);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      localca.setStatus(5);
      com.tencent.mm.plugin.report.f.Iyx.idkeyStat(111L, 34L, 1L, true);
      bh.beI();
      com.tencent.mm.model.c.bbO().a(localca.field_msgId, localca);
      Log.e("MicroMsg.NetSceneSendAppMsg", "send app msg failed, err=" + paramInt2 + "," + paramInt3 + ", msgId " + localca.field_msgId);
      if (paramInt2 == 4) {
        com.tencent.mm.plugin.report.service.h.IzE.a(10420, new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.aq.c.cV(MMApplicationContext.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_THUMBIMAGE), Integer.valueOf(0) });
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(31056);
      return;
    }
    localca.setStatus(2);
    localca.EG(paramArrayOfByte.HlH);
    bh.beI();
    com.tencent.mm.model.c.bbO().a(localca.field_msgId, localca);
    ((com.tencent.mm.plugin.record.a.f)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.record.a.f.class)).Pl(localca.field_msgId);
    com.tencent.mm.modelstat.b.mcf.d(localca, l.v(localca));
    if ((this.JVA != null) && (!Util.isNullOrNil(this.JVA.gce.url)))
    {
      this.JVA.gce.gcg = ("msg_" + Long.toString(paramArrayOfByte.HlH));
      EventCenter.instance.publish(this.JVA);
    }
    if ((this.JVB != null) && (this.JVB.gcu.gcv != -1)) {
      EventCenter.instance.publish(this.JVB);
    }
    localb = k.b.OQ(localca.field_content);
    if ((localb != null) && ("wx4310bbd51be7d979".equals(localb.appId))) {
      if ((Util.isNullOrNil(localca.field_talker)) || (!ab.Lj(localca.field_talker))) {
        break label983;
      }
    }
    label983:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      params = "";
      try
      {
        paramArrayOfByte = URLEncoder.encode(localb.description, "UTF-8");
        params = paramArrayOfByte;
      }
      catch (UnsupportedEncodingException paramArrayOfByte)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.NetSceneSendAppMsg", paramArrayOfByte, "", new Object[0]);
          continue;
          paramInt1 = 1;
          continue;
          params = ((PluginGroupSolitaire)com.tencent.mm.kernel.h.ag(PluginGroupSolitaire.class)).getGroupSolitatireReportManager();
          if (localca.field_msgSvrId > 0L) {
            com.tencent.e.h.ZvG.d(new d.1(params, localca), "GroupSolitaireReport");
          }
          params = ((PluginGroupSolitaire)com.tencent.mm.kernel.h.ag(PluginGroupSolitaire.class)).getGroupSolitatireReportManager();
          if (localca.field_msgSvrId > 0L)
          {
            com.tencent.e.h.ZvG.be(new d.3(params, localca));
            continue;
            ((com.tencent.mm.plugin.msgquote.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.msgquote.a.class)).handleQuoteMsgSendResuld(localca.field_msgId, localca.field_msgSvrId);
            continue;
            params = o.XfQ;
            o.d.a(6, localb, localca);
          }
        }
      }
      paramArrayOfByte = new StringBuilder("1,");
      if (paramInt1 == 0) {
        break;
      }
      paramInt1 = 2;
      params = paramInt1 + ",," + params;
      Log.i("MicroMsg.NetSceneSendAppMsg", "androidSystemShareFixed(13717) %s", new Object[] { params });
      com.tencent.mm.plugin.report.service.h.IzE.kvStat(13717, params);
      if (localb != null) {}
      switch (localb.type)
      {
      default: 
        if ((localb != null) && (ab.PP(localca.field_talker)))
        {
          params = (com.tencent.mm.aj.a)localb.ar(com.tencent.mm.aj.a.class);
          if ((params != null) && (params.lkz)) {
            com.tencent.mm.chatroom.d.y.a(localca, localb);
          }
          if (aa.asf()) {
            ((com.tencent.mm.chatroom.plugin.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.chatroom.plugin.a.class)).handleGroupToolByReceiverAppMsg(localca);
          }
        }
        if (this.QWX != null)
        {
          this.QWX.fva.fvf = ("msg_" + localca.field_msgSvrId);
          EventCenter.instance.publish(this.QWX);
        }
        if (localedg.UhI.RJR != null) {
          com.tencent.mm.plugin.report.service.h.IzE.a(10420, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.aq.c.cV(MMApplicationContext.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_THUMBIMAGE), Integer.valueOf(localedg.UhI.RJR.Ufv) });
        }
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(31056);
        return;
      }
    }
  }
  
  public final q.b securityVerificationChecked(s params)
  {
    return q.b.lCx;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.ag
 * JD-Core Version:    0.7.0.1
 */