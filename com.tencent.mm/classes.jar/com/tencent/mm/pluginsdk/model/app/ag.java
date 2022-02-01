package com.tencent.mm.pluginsdk.model.app;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.q.b;
import com.tencent.mm.ak.t;
import com.tencent.mm.chatroom.d.aa;
import com.tencent.mm.g.a.aax;
import com.tencent.mm.g.a.aax.a;
import com.tencent.mm.g.a.aay;
import com.tencent.mm.g.a.aay.a;
import com.tencent.mm.g.a.p;
import com.tencent.mm.g.a.p.a;
import com.tencent.mm.g.b.a.w;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.i.g.a;
import com.tencent.mm.m.a.a;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ac;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.br;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.plugin.groupsolitaire.PluginGroupSolitaire;
import com.tencent.mm.plugin.groupsolitaire.b.d.1;
import com.tencent.mm.plugin.groupsolitaire.b.d.3;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dth;
import com.tencent.mm.protocal.protobuf.dti;
import com.tencent.mm.protocal.protobuf.ecm;
import com.tencent.mm.protocal.protobuf.eco;
import com.tencent.mm.protocal.protobuf.eeq;
import com.tencent.mm.protocal.protobuf.fd;
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
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Locale;
import junit.framework.Assert;

public final class ag
  extends com.tencent.mm.ak.q
  implements com.tencent.mm.network.m
{
  private aax DIA;
  aay DIB;
  a JWD;
  private p JWE;
  long JWF;
  com.tencent.mm.ak.i callback;
  ca dTX;
  int dYz;
  String iYT;
  private g.a iZc;
  String mSessionId;
  private String mSignature;
  long msgId;
  private com.tencent.mm.ak.d rr;
  long startTime;
  
  public ag(long paramLong, String paramString, int paramInt, a parama)
  {
    this(paramLong, paramString, null);
    AppMethodBeat.i(31054);
    this.dYz = paramInt;
    this.JWD = parama;
    Log.i("MicroMsg.NetSceneSendAppMsg", "NetSceneSendAppMsg directShare[%d]", new Object[] { Integer.valueOf(paramInt) });
    if (this.JWD != null) {
      Log.i("MicroMsg.NetSceneSendAppMsg", "NetSceneSendAppMsg tokenValid[%d], pkgName[%s]", new Object[] { Integer.valueOf(this.JWD.JVJ), this.JWD.pkgName });
    }
    AppMethodBeat.o(31054);
  }
  
  public ag(long paramLong, String paramString1, String paramString2)
  {
    AppMethodBeat.i(31053);
    this.dTX = null;
    this.msgId = 0L;
    this.dYz = 0;
    this.startTime = 0L;
    this.iYT = "";
    this.JWF = 0L;
    this.iZc = new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, final com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(31052);
        Log.d("MicroMsg.NetSceneSendAppMsg", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { ag.this.iYT, Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd });
        if (paramAnonymousInt == -21005)
        {
          Log.d("MicroMsg.NetSceneSendAppMsg", "cdntra  ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", new Object[] { ag.this.iYT });
          AppMethodBeat.o(31052);
          return 0;
        }
        if (paramAnonymousInt != 0)
        {
          ag.this.dTX.setStatus(5);
          e.Cxv.idkeyStat(111L, 34L, 1L, true);
          bg.aVF();
          com.tencent.mm.model.c.aSQ().a(ag.this.dTX.field_msgId, ag.this.dTX);
          new com.tencent.mm.g.b.a.y(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(1), Long.valueOf(ag.this.startTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.an.c.cY(MMApplicationContext.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Integer.valueOf(0), "" })).bfK();
          ag.this.callback.onSceneEnd(3, paramAnonymousInt, "", ag.this);
          AppMethodBeat.o(31052);
          return 0;
        }
        if (paramAnonymousd != null)
        {
          if (paramAnonymousd.field_retCode != 0)
          {
            Log.e("MicroMsg.NetSceneSendAppMsg", "cdntra sceneResult.retCode :%d arg[%s] info[%s]", new Object[] { Integer.valueOf(paramAnonymousd.field_retCode), paramAnonymousd.field_arg, paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", paramAnonymousd.gqk });
            ag.this.dTX.setStatus(5);
            e.Cxv.idkeyStat(111L, 34L, 1L, true);
            bg.aVF();
            com.tencent.mm.model.c.aSQ().a(ag.this.dTX.field_msgId, ag.this.dTX);
            paramAnonymousc = com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramAnonymousd.field_retCode), Integer.valueOf(1), Long.valueOf(ag.this.startTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.an.c.cY(MMApplicationContext.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Long.valueOf(paramAnonymousd.field_fileLength), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", paramAnonymousd.gqk });
            new com.tencent.mm.g.b.a.y(paramAnonymousc).bfK();
            new w(paramAnonymousc).bfK();
            ag.this.callback.onSceneEnd(3, paramAnonymousd.field_retCode, "", ag.this);
          }
        }
        else
        {
          if ((paramAnonymousString != null) && (paramAnonymousString.equals(ag.this.iYT)) && (ag.this.DIB != null) && (ag.this.DIB.eid.eie != -1))
          {
            EventCenter.instance.publish(ag.this.DIB);
            ag.this.DIB = null;
          }
          AppMethodBeat.o(31052);
          return 0;
        }
        if ((ag.this.JWF > 0L) && (paramAnonymousd.field_fileLength > 0L) && (ag.this.dTX.getType() != 738197553))
        {
          paramAnonymousc = ag.this.JWF + "," + paramAnonymousd.field_fileLength + "," + paramAnonymousd.field_fileId;
          if (ag.this.JWF * 2L <= paramAnonymousd.field_fileLength) {
            break label941;
          }
        }
        label941:
        for (boolean bool = true;; bool = false)
        {
          MMUncaughtExceptionHandler.assertTrue("SendAppMsgThumbTooBig", paramAnonymousc, bool);
          Log.i("MicroMsg.NetSceneSendAppMsg", "summersafecdn cdnCallback upload attach by cdn, isHitCacheUpload: %d, onlyCheckExist[%b], exist[%b], aesKey[%s], md5[%s]", new Object[] { Integer.valueOf(paramAnonymousd.field_UploadHitCacheType), Boolean.valueOf(paramAnonymousBoolean), Boolean.valueOf(paramAnonymousd.field_exist_whencheck), Util.secPrint(paramAnonymousd.field_aesKey), paramAnonymousd.field_filemd5 });
          if (ag.this.dTX.getType() == 738197553) {
            m.a(ag.this.dTX.field_msgId, "", paramAnonymousd, false);
          }
          bg.azz().a(new ah(ag.this.msgId, paramAnonymousd, new ah.a()
          {
            public final void dq(int paramAnonymous2Int1, int paramAnonymous2Int2)
            {
              AppMethodBeat.i(31051);
              Log.d("MicroMsg.NetSceneSendAppMsg", "summersafecdn cdntra NetSceneSendAppMsgForCdn callback %d,%d", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2) });
              new com.tencent.mm.g.b.a.y(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(1), Long.valueOf(ag.this.startTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.an.c.cY(MMApplicationContext.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Long.valueOf(paramAnonymousd.field_fileLength), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", paramAnonymousd.gqk })).bfK();
              ag.this.callback.onSceneEnd(paramAnonymous2Int1, paramAnonymous2Int2, "", ag.this);
              AppMethodBeat.o(31051);
            }
          }, ag.this.mSessionId, ag.this.dYz, ag.this.JWD), 0);
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
    locala.iLN = new dth();
    locala.iLO = new dti();
    locala.uri = "/cgi-bin/micromsg-bin/sendappmsg";
    locala.funcId = 222;
    locala.iLP = 107;
    locala.respCmdId = 1000000107;
    this.rr = locala.aXF();
    Log.i("MicroMsg.NetSceneSendAppMsg", "summersafecdn NetSceneSendAppMsg msgid[%d], sessionid[%s], signature[%s], stack[%s]", new Object[] { Long.valueOf(paramLong), paramString1, Util.secPrint(paramString2), Util.getStack() });
    AppMethodBeat.o(31053);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.ak.i parami)
  {
    AppMethodBeat.i(31055);
    this.callback = parami;
    if (this.startTime == 0L) {
      this.startTime = Util.nowMilliSecond();
    }
    bg.aVF();
    this.dTX = com.tencent.mm.model.c.aSQ().Hb(this.msgId);
    if ((this.dTX == null) || (this.dTX.field_msgId != this.msgId))
    {
      AppMethodBeat.o(31055);
      return -1;
    }
    parami = k.b.HD(this.dTX.field_content);
    Object localObject1;
    if (parami == null)
    {
      localObject1 = be.bkr(this.dTX.field_content);
      if (Util.isNullOrNil(((be)localObject1).Oph))
      {
        parami = new k.b();
        parami.iwK = ((be)localObject1).md5;
        parami.type = 8;
        Log.i("MicroMsg.NetSceneSendAppMsg", "create new content. loss appid");
      }
    }
    for (;;)
    {
      localObject1 = "content != null [[" + this.dTX.field_content + "]]";
      if (parami != null) {}
      for (boolean bool = true;; bool = false)
      {
        Assert.assertTrue((String)localObject1, bool);
        if (parami != null) {
          break label223;
        }
        this.dTX = null;
        AppMethodBeat.o(31055);
        return -1;
        parami = k.b.HD(((be)localObject1).Oph);
        break;
      }
      label223:
      localObject1 = "";
      Object localObject2;
      if (this.dTX.cWK())
      {
        localObject2 = u.QN(this.dTX.field_imgPath);
        if (localObject2 != null) {
          localObject1 = ((com.tencent.mm.modelvideo.s)localObject2).jsw.ize;
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
            break label959;
          }
          Log.d("MicroMsg.NetSceneSendAppMsg", "cdntra use cdn return -1 for onGYNetEnd clientId:%s", new Object[] { this.iYT });
          AppMethodBeat.o(31055);
          return 0;
          if (Util.isNullOrNil(this.dTX.field_imgPath)) {
            break label2388;
          }
          localObject1 = com.tencent.mm.av.q.bcR().Oz(this.dTX.field_imgPath);
          break;
          if (Util.isNullOrNil((String)localObject1))
          {
            Log.i("MicroMsg.NetSceneSendAppMsg", "cdntra cdn not support no thumb msg type:%d", new Object[] { Integer.valueOf(parami.type) });
            i = 0;
          }
          else
          {
            this.JWF = ((int)com.tencent.mm.vfs.s.boW((String)localObject1));
            if ((parami.type == 33) || (parami.type == 36) || (parami.type == 46) || (parami.type == 44) || (parami.type == 48)) {}
            for (i = 1;; i = 0)
            {
              if ((i != 0) || (this.JWF < 262144L)) {
                break label513;
              }
              Log.w("MicroMsg.NetSceneSendAppMsg", "cdntra thumb[%s][%d] Too Big Not Use CDN TRANS", new Object[] { localObject1, Long.valueOf(this.JWF) });
              i = 0;
              break;
            }
            label513:
            Log.i("MicroMsg.NetSceneSendAppMsg", "cdntra content.type:%d  thumbPath:%s,  thumbLength:%d ", new Object[] { Integer.valueOf(parami.type), localObject1, Long.valueOf(this.JWF) });
            if (!Util.isNullOrNil(parami.dCK))
            {
              Log.w("MicroMsg.NetSceneSendAppMsg", "cdntra attach has been upload by cdn msgid:%d", new Object[] { Long.valueOf(this.msgId) });
              i = 0;
            }
            else
            {
              if (i == 0)
              {
                com.tencent.mm.an.f.baQ();
                if (!com.tencent.mm.an.b.sS(4))
                {
                  com.tencent.mm.an.f.baQ();
                  Log.w("MicroMsg.NetSceneSendAppMsg", "cdntra not use cdn flag:%b ", new Object[] { Boolean.valueOf(com.tencent.mm.an.b.sS(4)) });
                  i = 0;
                  continue;
                }
              }
              this.iYT = com.tencent.mm.an.c.a("upappmsg", this.dTX.field_createTime, this.dTX.field_talker, this.dTX.field_msgId);
              if (Util.isNullOrNil(this.iYT))
              {
                Log.w("MicroMsg.NetSceneSendAppMsg", "cdntra genClientId failed not use cdn msgid:%d", new Object[] { Long.valueOf(this.dTX.field_msgId) });
                i = 0;
              }
              else
              {
                localObject2 = parami.aSv();
                if (((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED)) && ((((com.tencent.mm.i.g)localObject2).gqy != null) || (!Util.isNullOrNil(((com.tencent.mm.i.g)localObject2).field_mediaId)) || (!Util.isNullOrNil(((com.tencent.mm.i.g)localObject2).field_thumbpath)) || (!Util.isNullOrNil(((com.tencent.mm.i.g)localObject2).field_talker))))
                {
                  paramg = new RuntimeException("Do not fill reserved fields!");
                  AppMethodBeat.o(31055);
                  throw paramg;
                }
                ((com.tencent.mm.i.g)localObject2).gqy = this.iZc;
                ((com.tencent.mm.i.g)localObject2).field_mediaId = this.iYT;
                ((com.tencent.mm.i.g)localObject2).field_thumbpath = ((String)localObject1);
                ((com.tencent.mm.i.g)localObject2).field_talker = this.dTX.field_talker;
                Log.i("MicroMsg.NetSceneSendAppMsg", "summersafecdn cdntra checkUseCdn content.type[%d], thumb[%s], useCdnTransClientId[%s], fileType[%d], enable_hitcheck[%b], onlycheckexist[%b], force_aeskeycdn[%b], trysafecdn[%b]", new Object[] { Integer.valueOf(parami.type), localObject1, this.iYT, Integer.valueOf(((com.tencent.mm.i.g)localObject2).field_fileType), Boolean.valueOf(((com.tencent.mm.i.g)localObject2).field_enable_hitcheck), Boolean.valueOf(((com.tencent.mm.i.g)localObject2).field_onlycheckexist), Boolean.valueOf(((com.tencent.mm.i.g)localObject2).field_force_aeskeycdn), Boolean.valueOf(((com.tencent.mm.i.g)localObject2).field_trysafecdn) });
                if (!com.tencent.mm.an.f.baQ().f((com.tencent.mm.i.g)localObject2))
                {
                  Log.e("MicroMsg.NetSceneSendAppMsg", "cdntra addSendTask failed.");
                  this.iYT = "";
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
        label959:
        ad.b localb = com.tencent.mm.ui.transmit.c.bnX(this.mSessionId);
        if ((localb != null) && (localb.containsKey("_tmpl_webview_transfer_scene")))
        {
          this.DIB = new aay();
          this.DIB.eid.eie = localb.getInt("_tmpl_webview_transfer_scene", -1);
        }
        dth localdth = (dth)this.rr.iLK.iLR;
        fd localfd = new fd();
        localfd.jfi = parami.appId;
        localfd.KIz = (this.dTX.field_talker + this.dTX.field_msgId + "T" + this.dTX.field_createTime);
        localfd.iAc = k.b.a(parami, null, null, 0, 0);
        localfd.CreateTime = ((int)Util.nowSecond());
        localfd.xNG = this.dTX.field_talker;
        localfd.xNH = z.aTY();
        localfd.oUv = parami.type;
        localfd.KIy = parami.sdkVer;
        localfd.xub = parami.iwL;
        localObject2 = a.a.anC().o(this.dTX);
        String str;
        eco localeco;
        if (!Util.isNullOrNil((String)localObject2))
        {
          localfd.KHq = ((String)localObject2);
          localfd.KIC = parami.eaj;
          localfd.KID = parami.eak;
          localfd.KIE = parami.eal;
          if (this.JWD != null)
          {
            localfd.KIF = this.JWD.JVJ;
            localfd.xuk = this.JWD.pkgName;
          }
          if (localb != null)
          {
            this.DIA = new aax();
            this.DIA.ehN.url = parami.url;
            this.DIA.ehN.ehO = localb.getString("prePublishId", "");
            this.DIA.ehN.ehQ = localb.getString("preUsername", "");
            this.DIA.ehN.ehR = localb.getString("preChatName", "");
            this.DIA.ehN.ehS = localb.getInt("preMsgIndex", 0);
            this.DIA.ehN.ehW = localb.getInt("sendAppMsgScene", 0);
            this.DIA.ehN.ehX = localb.getInt("getA8KeyScene", 0);
            this.DIA.ehN.ehY = localb.getString("referUrl", null);
            this.DIA.ehN.ehZ = localb.getString("adExtStr", null);
            this.DIA.ehN.ehT = this.dTX.field_talker;
            this.DIA.ehN.eia = parami.title;
            this.DIA.ehN.eic = parami.description;
            bg.aVF();
            localObject2 = com.tencent.mm.model.c.aSN().Kn(this.dTX.field_talker);
            if (localObject2 != null) {
              this.DIA.ehN.ehU = ((as)localObject2).arI();
            }
            this.DIA.ehN.ehV = v.Ie(this.dTX.field_talker);
            str = "";
            localObject2 = str;
            if (parami.ean != null)
            {
              localeco = new eco();
              localObject2 = Base64.decode(parami.ean, 0);
            }
          }
        }
        try
        {
          localeco.parseFrom((byte[])localObject2);
          localObject2 = str;
          if (localeco.NcJ != null) {
            localObject2 = localeco.NcJ.xEN;
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
        localdth.MVw = String.format(Locale.US, "prePublishId=%s&preUserName=%s&preChatName=%s&preChatType=%d&getA8KeyScene=%d&sourceAppId=%s", new Object[] { this.DIA.ehN.ehO, this.DIA.ehN.ehQ, this.DIA.ehN.ehR, Integer.valueOf(ac.aJ(this.DIA.ehN.ehQ, this.DIA.ehN.ehR)), Integer.valueOf(this.DIA.ehN.ehX), localObject2 });
        if ((localb != null) && (parami.type == 33))
        {
          this.JWE = new p();
          i = localb.getInt("fromScene", 1);
          this.JWE.dCt.scene = i;
          j = localb.getInt("appservicetype", 0);
          this.JWE.dCt.cyo = j;
          localObject2 = localb.getString("preChatName", "");
          if (2 == i)
          {
            str = localb.getString("preUsername", "");
            this.JWE.dCt.dCw = ((String)localObject2 + ":" + str);
            label1851:
            localObject2 = this.dTX.field_talker;
            bool = localb.getBoolean("moreRetrAction", false);
            if (!((String)localObject2).endsWith("@chatroom")) {
              break label2344;
            }
            localObject2 = this.JWE.dCt;
            if (!bool) {
              break label2339;
            }
            i = 5;
            label1898:
            ((p.a)localObject2).action = i;
            this.JWE.dCt.dCv = (parami.izz + 1);
            this.JWE.dCt.dCx = parami.izh;
            this.JWE.dCt.dCu = parami.izi;
            this.JWE.dCt.appId = parami.izj;
            this.JWE.dCt.appVersion = parami.izA;
            this.JWE.dCt.dCz = Util.nowSecond();
            this.JWE.dCt.dCA = 1;
            this.JWE.dCt.dCC = parami.izn;
          }
        }
        else
        {
          Log.d("MicroMsg.NetSceneSendAppMsg", "SnsPostOperationFields: ShareUrlOriginal=%s, ShareUrlOpen=%s, JsAppId=%s", new Object[] { parami.eaj, parami.eak, parami.eal });
          if (!Util.isNullOrNil((String)localObject1))
          {
            localObject2 = com.tencent.mm.vfs.s.aW((String)localObject1, 0, -1);
            if (!Util.isNullOrNil((byte[])localObject2)) {
              localfd.KIA = new SKBuiltinBuffer_t().setBuffer((byte[])localObject2);
            }
          }
          if (localfd.KIA == null) {
            break label2374;
          }
        }
        label2339:
        label2344:
        label2374:
        for (int i = localfd.KIA.getILen();; i = -1)
        {
          Log.d("MicroMsg.NetSceneSendAppMsg", "doScene thumbFile:[%s] thumbdata:%d", new Object[] { localObject1, Integer.valueOf(i) });
          localdth.MVu = localfd;
          if ((parami.iwM != 0) || (parami.iwI > 26214400)) {
            localdth.KKA = com.tencent.mm.i.a.gpO;
          }
          localdth.Md5 = parami.filemd5;
          localdth.keb = this.mSignature;
          localdth.MVy = this.dYz;
          if (((com.tencent.mm.plugin.messenger.foundation.a.s)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).ifAddTicketByActionFlag(this.dTX.field_talker)) {
            localdth.LbN = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().bjT(this.dTX.field_talker);
          }
          Log.i("MicroMsg.NetSceneSendAppMsg", "summersafecdn file md5[%s], signature[%s], type[%d], fromScene[%s]", new Object[] { localdth.Md5, Util.secPrint(localdth.keb), Integer.valueOf(localdth.KKA), localdth.MVw });
          i = dispatch(paramg, this.rr, this);
          AppMethodBeat.o(31055);
          return i;
          localfd.KHq = br.ajw();
          break;
          this.JWE.dCt.dCw = ((String)localObject2);
          break label1851;
          i = 2;
          break label1898;
          localObject2 = this.JWE.dCt;
          if (bool) {}
          for (i = 4;; i = 1)
          {
            ((p.a)localObject2).action = i;
            break;
          }
        }
        label2388:
        localObject1 = "";
      }
    }
  }
  
  public final int getType()
  {
    return 222;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(31056);
    Log.i("MicroMsg.NetSceneSendAppMsg", "summersafecdn cdntra onGYNetEnd [%d,%d,%s] msgId:%d, oldContent[%s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Long.valueOf(this.msgId), this.dTX.field_content });
    paramArrayOfByte = (dti)((com.tencent.mm.ak.d)params).iLL.iLR;
    dth localdth = (dth)((com.tencent.mm.ak.d)params).iLK.iLR;
    if ((paramArrayOfByte != null) && ((paramInt2 == 4) || ((paramInt2 == 0) && (paramInt3 == 0)))) {
      ((com.tencent.mm.plugin.messenger.foundation.a.s)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).setEnSendMsgActionFlag(paramArrayOfByte.LbO);
    }
    if ((paramInt2 == 3) && (paramInt3 == -1) && (!Util.isNullOrNil(this.iYT)))
    {
      Log.w("MicroMsg.NetSceneSendAppMsg", "cdntra using cdn trans,  wait cdn service callback! clientid:%s", new Object[] { this.iYT });
      AppMethodBeat.o(31056);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.dTX.setStatus(5);
      e.Cxv.idkeyStat(111L, 34L, 1L, true);
      bg.aVF();
      com.tencent.mm.model.c.aSQ().a(this.dTX.field_msgId, this.dTX);
      Log.e("MicroMsg.NetSceneSendAppMsg", "send app msg failed, err=" + paramInt2 + "," + paramInt3 + ", msgId " + this.dTX.field_msgId);
      if (paramInt2 == 4) {
        com.tencent.mm.plugin.report.service.h.CyF.a(10420, new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.an.c.cY(MMApplicationContext.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_THUMBIMAGE), Integer.valueOf(0) });
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(31056);
      return;
    }
    this.dTX.setStatus(2);
    this.dTX.yF(paramArrayOfByte.Brn);
    bg.aVF();
    com.tencent.mm.model.c.aSQ().a(this.dTX.field_msgId, this.dTX);
    ((com.tencent.mm.plugin.record.a.f)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.record.a.f.class)).HQ(this.dTX.field_msgId);
    com.tencent.mm.modelstat.b.jmd.b(this.dTX, com.tencent.mm.ag.l.t(this.dTX));
    if ((this.DIA != null) && (!Util.isNullOrNil(this.DIA.ehN.url)))
    {
      this.DIA.ehN.ehP = ("msg_" + Long.toString(paramArrayOfByte.Brn));
      EventCenter.instance.publish(this.DIA);
    }
    if ((this.DIB != null) && (this.DIB.eid.eie != -1)) {
      EventCenter.instance.publish(this.DIB);
    }
    k.b localb = k.b.HD(this.dTX.field_content);
    if ((localb != null) && ("wx4310bbd51be7d979".equals(localb.appId))) {
      if ((Util.isNullOrNil(this.dTX.field_talker)) || (!ab.Eq(this.dTX.field_talker))) {
        break label987;
      }
    }
    label987:
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
          params = ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ah(PluginGroupSolitaire.class)).getGroupSolitatireReportManager();
          paramArrayOfByte = this.dTX;
          if ((paramArrayOfByte == null) || (paramArrayOfByte.field_msgSvrId <= 0L)) {}
          for (;;)
          {
            params = ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ah(PluginGroupSolitaire.class)).getGroupSolitatireReportManager();
            paramArrayOfByte = this.dTX;
            if ((paramArrayOfByte == null) || (paramArrayOfByte.field_msgSvrId <= 0L)) {
              break;
            }
            com.tencent.f.h.RTc.aX(new d.3(params, paramArrayOfByte));
            break;
            com.tencent.f.h.RTc.b(new d.1(params, paramArrayOfByte), "GroupSolitaireReport");
          }
          ((com.tencent.mm.plugin.msgquote.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.msgquote.a.class)).handleQuoteMsgSendResuld(this.dTX.field_msgId, this.dTX.field_msgSvrId);
        }
      }
      paramArrayOfByte = new StringBuilder("1,");
      if (paramInt1 == 0) {
        break;
      }
      paramInt1 = 2;
      params = paramInt1 + ",," + params;
      Log.i("MicroMsg.NetSceneSendAppMsg", "androidSystemShareFixed(13717) %s", new Object[] { params });
      com.tencent.mm.plugin.report.service.h.CyF.kvStat(13717, params);
      if (localb != null) {}
      switch (localb.type)
      {
      default: 
        if ((localb != null) && (ab.Ix(this.dTX.field_talker)))
        {
          params = (com.tencent.mm.ag.a)localb.as(com.tencent.mm.ag.a.class);
          if ((params != null) && (params.ivq)) {
            com.tencent.mm.chatroom.d.y.a(this.dTX, localb);
          }
          if (aa.ame()) {
            ((com.tencent.mm.chatroom.plugin.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.chatroom.plugin.a.class)).handleGroupToolByReceiverAppMsg(this.dTX);
          }
        }
        if (this.JWE != null)
        {
          this.JWE.dCt.dCy = ("msg_" + this.dTX.field_msgSvrId);
          EventCenter.instance.publish(this.JWE);
        }
        if (localdth.MVu.KIA != null) {
          com.tencent.mm.plugin.report.service.h.CyF.a(10420, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.an.c.cY(MMApplicationContext.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_THUMBIMAGE), Integer.valueOf(localdth.MVu.KIA.getILen()) });
        }
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(31056);
        return;
      }
    }
  }
  
  public final q.b securityVerificationChecked(com.tencent.mm.network.s params)
  {
    return q.b.iMq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.ag
 * JD-Core Version:    0.7.0.1
 */