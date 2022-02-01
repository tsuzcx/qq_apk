package com.tencent.mm.pluginsdk.model.app;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.p.b;
import com.tencent.mm.autogen.a.aec;
import com.tencent.mm.autogen.a.aec.a;
import com.tencent.mm.autogen.a.aed;
import com.tencent.mm.autogen.a.aed.a;
import com.tencent.mm.autogen.a.s.a;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.g.d;
import com.tencent.mm.g.g.a;
import com.tencent.mm.j.a.a;
import com.tencent.mm.message.k.b;
import com.tencent.mm.message.l;
import com.tencent.mm.model.ac;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bt;
import com.tencent.mm.modelcdntran.k;
import com.tencent.mm.modelimage.j;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.groupsolitaire.PluginGroupSolitaire;
import com.tencent.mm.plugin.groupsolitaire.b.d.1;
import com.tencent.mm.plugin.groupsolitaire.b.d.3;
import com.tencent.mm.protocal.protobuf.ewx;
import com.tencent.mm.protocal.protobuf.ewy;
import com.tencent.mm.protocal.protobuf.fhl;
import com.tencent.mm.protocal.protobuf.fhn;
import com.tencent.mm.protocal.protobuf.fjp;
import com.tencent.mm.protocal.protobuf.fu;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMUncaughtExceptionHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.chatting.viewitems.o;
import com.tencent.mm.ui.chatting.viewitems.o.d;
import com.tencent.mm.vfs.y;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Locale;
import junit.framework.Assert;

public final class ak
  extends p
  implements m
{
  private aec QsB;
  private aed QsC;
  private a XSU;
  private com.tencent.mm.autogen.a.s XSV;
  private long XSW;
  private com.tencent.mm.am.h callback;
  private cc hTm;
  private int hYn;
  private String mSessionId;
  private String mSignature;
  private long msgId;
  private String oHX;
  private g.a osH;
  private com.tencent.mm.am.c rr;
  private long startTime;
  
  public ak(long paramLong, String paramString, int paramInt, a parama)
  {
    this(paramLong, paramString, null);
    AppMethodBeat.i(31054);
    this.hYn = paramInt;
    this.XSU = parama;
    Log.i("MicroMsg.NetSceneSendAppMsg", "NetSceneSendAppMsg directShare[%d]", new Object[] { Integer.valueOf(paramInt) });
    if (this.XSU != null) {
      Log.i("MicroMsg.NetSceneSendAppMsg", "NetSceneSendAppMsg tokenValid[%d], pkgName[%s]", new Object[] { Integer.valueOf(this.XSU.XRT), this.XSU.pkgName });
    }
    AppMethodBeat.o(31054);
  }
  
  public ak(long paramLong, String paramString1, String paramString2)
  {
    AppMethodBeat.i(31053);
    this.hTm = null;
    this.msgId = 0L;
    this.hYn = 0;
    this.startTime = 0L;
    this.oHX = "";
    this.XSW = 0L;
    this.osH = new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.g.c paramAnonymousc, d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(31052);
        Log.d("MicroMsg.NetSceneSendAppMsg", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { ak.a(ak.this), Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd });
        if (paramAnonymousInt == -21005)
        {
          Log.d("MicroMsg.NetSceneSendAppMsg", "cdntra  ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", new Object[] { ak.a(ak.this) });
          AppMethodBeat.o(31052);
          return 0;
        }
        bh.bCz();
        paramAnonymousc = com.tencent.mm.model.c.bzD().sl(ak.b(ak.this).field_msgId);
        if (paramAnonymousInt != 0)
        {
          paramAnonymousc.setStatus(5);
          com.tencent.mm.plugin.report.f.Ozc.idkeyStat(111L, 34L, 1L, true);
          bh.bCz();
          com.tencent.mm.model.c.bzD().a(paramAnonymousc.field_msgId, paramAnonymousc);
          ak.c(ak.this).onSceneEnd(3, paramAnonymousInt, "", ak.this);
          AppMethodBeat.o(31052);
          return 0;
        }
        if (paramAnonymousd != null)
        {
          if (paramAnonymousd.field_retCode != 0)
          {
            Log.e("MicroMsg.NetSceneSendAppMsg", "cdntra sceneResult.retCode :%d arg[%s] info[%s]", new Object[] { Integer.valueOf(paramAnonymousd.field_retCode), paramAnonymousd.field_arg, paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", paramAnonymousd.lwx });
            paramAnonymousc.setStatus(5);
            com.tencent.mm.plugin.report.f.Ozc.idkeyStat(111L, 34L, 1L, true);
            bh.bCz();
            com.tencent.mm.model.c.bzD().a(paramAnonymousc.field_msgId, paramAnonymousc);
            ak.c(ak.this).onSceneEnd(3, paramAnonymousd.field_retCode, "", ak.this);
          }
        }
        else
        {
          if ((paramAnonymousString != null) && (paramAnonymousString.equals(ak.a(ak.this))) && (ak.i(ak.this) != null) && (ak.i(ak.this).iiG.iiH != -1))
          {
            ak.i(ak.this).publish();
            ak.j(ak.this);
          }
          AppMethodBeat.o(31052);
          return 0;
        }
        String str;
        if ((ak.d(ak.this) > 0L) && (paramAnonymousd.field_fileLength > 0L) && (paramAnonymousc.getType() != 738197553))
        {
          str = ak.d(ak.this) + "," + paramAnonymousd.field_fileLength + "," + paramAnonymousd.field_fileId;
          if (ak.d(ak.this) * 2L <= paramAnonymousd.field_fileLength) {
            break label651;
          }
        }
        label651:
        for (boolean bool = true;; bool = false)
        {
          MMUncaughtExceptionHandler.assertTrue("SendAppMsgThumbTooBig", str, bool);
          Log.i("MicroMsg.NetSceneSendAppMsg", "summersafecdn cdnCallback upload attach by cdn, isHitCacheUpload: %d, onlyCheckExist[%b], exist[%b], aesKey[%s], md5[%s]", new Object[] { Integer.valueOf(paramAnonymousd.field_UploadHitCacheType), Boolean.valueOf(paramAnonymousBoolean), Boolean.valueOf(paramAnonymousd.field_exist_whencheck), Util.secPrint(paramAnonymousd.field_aesKey), paramAnonymousd.field_filemd5 });
          if (paramAnonymousc.getType() == 738197553) {
            n.a(paramAnonymousc.field_msgId, "", paramAnonymousd, false);
          }
          bh.aZW().a(new al(ak.e(ak.this), paramAnonymousd, new al.a()
          {
            public final void eF(int paramAnonymous2Int1, int paramAnonymous2Int2)
            {
              AppMethodBeat.i(31051);
              Log.d("MicroMsg.NetSceneSendAppMsg", "summersafecdn cdntra NetSceneSendAppMsgForCdn callback %d,%d", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2) });
              ak.c(ak.this).onSceneEnd(paramAnonymous2Int1, paramAnonymous2Int2, "", ak.this);
              AppMethodBeat.o(31051);
            }
          }, ak.f(ak.this), ak.g(ak.this), ak.h(ak.this)), 0);
          break;
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
      
      public final byte[] h(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        return null;
      }
    };
    this.msgId = paramLong;
    this.mSessionId = paramString1;
    this.mSignature = paramString2;
    c.a locala = new c.a();
    locala.otE = new ewx();
    locala.otF = new ewy();
    locala.uri = "/cgi-bin/micromsg-bin/sendappmsg";
    locala.funcId = 222;
    locala.otG = 107;
    locala.respCmdId = 1000000107;
    this.rr = locala.bEF();
    Log.i("MicroMsg.NetSceneSendAppMsg", "summersafecdn NetSceneSendAppMsg msgid[%d], sessionid[%s], signature[%s], stack[%s]", new Object[] { Long.valueOf(paramLong), paramString1, Util.secPrint(paramString2), Util.getStack() });
    AppMethodBeat.o(31053);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(31055);
    this.callback = paramh;
    if (this.startTime == 0L) {
      this.startTime = Util.nowMilliSecond();
    }
    bh.bCz();
    this.hTm = com.tencent.mm.model.c.bzD().sl(this.msgId);
    if ((this.hTm == null) || (this.hTm.field_msgId != this.msgId))
    {
      AppMethodBeat.o(31055);
      return -1;
    }
    Object localObject1 = k.b.Hf(this.hTm.field_content);
    if (localObject1 == null)
    {
      localObject1 = bg.byj(this.hTm.field_content);
      if (Util.isNullOrNil(((bg)localObject1).adiN))
      {
        paramh = new k.b();
        paramh.nRf = ((bg)localObject1).md5;
        paramh.type = 8;
        Log.i("MicroMsg.NetSceneSendAppMsg", "create new content. loss appid");
        localObject1 = "content != null [[" + this.hTm.field_content + "]]";
        if (paramh == null) {
          break label359;
        }
      }
    }
    Object localObject2;
    label359:
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue((String)localObject1, bool);
      if (paramh != null) {
        break label365;
      }
      this.hTm = null;
      AppMethodBeat.o(31055);
      return -1;
      paramh = k.b.Hf(((bg)localObject1).adiN);
      break;
      paramh = (com.tencent.mm.am.h)localObject1;
      if (((k.b)localObject1).type != 6) {
        break;
      }
      if (this.hTm.field_msgSvrId > 0L)
      {
        paramh = (com.tencent.mm.am.h)localObject1;
        if (this.hTm.field_status == 2) {
          break;
        }
      }
      localObject2 = (com.tencent.mm.message.a.b)((k.b)localObject1).aK(com.tencent.mm.message.a.b.class);
      paramh = (com.tencent.mm.am.h)localObject1;
      if (localObject2 == null) {
        break;
      }
      if (((com.tencent.mm.message.a.b)localObject2).nVD == 0L)
      {
        paramh = (com.tencent.mm.am.h)localObject1;
        if (Util.isNullOrNil(((com.tencent.mm.message.a.b)localObject2).nVE)) {
          break;
        }
      }
      ((com.tencent.mm.message.a.b)localObject2).reset();
      this.hTm.setContent(k.b.a((k.b)localObject1, null, null));
      ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().a(this.hTm.field_msgId, this.hTm);
      paramh = (com.tencent.mm.am.h)localObject1;
      break;
    }
    label365:
    localObject1 = "";
    if (this.hTm.dSI())
    {
      localObject2 = com.tencent.mm.modelvideo.ab.Qo(this.hTm.field_imgPath);
      if (localObject2 != null) {
        localObject1 = ((com.tencent.mm.modelvideo.z)localObject2).pbk.nTz;
      }
    }
    for (;;)
    {
      if ((paramh.type == 8) || (paramh.type == 9))
      {
        Log.i("MicroMsg.NetSceneSendAppMsg", "cdntra cdn not support Emoji or voiceremind now type:%d", new Object[] { Integer.valueOf(paramh.type) });
        i = 0;
      }
      for (;;)
      {
        if (i == 0) {
          break label1101;
        }
        Log.d("MicroMsg.NetSceneSendAppMsg", "cdntra use cdn return -1 for onGYNetEnd clientId:%s", new Object[] { this.oHX });
        AppMethodBeat.o(31055);
        return 0;
        if (Util.isNullOrNil(this.hTm.field_imgPath)) {
          break label2530;
        }
        localObject1 = r.bKa().NY(this.hTm.field_imgPath);
        break;
        if (Util.isNullOrNil((String)localObject1))
        {
          Log.i("MicroMsg.NetSceneSendAppMsg", "cdntra cdn not support no thumb msg type:%d", new Object[] { Integer.valueOf(paramh.type) });
          i = 0;
        }
        else
        {
          this.XSW = ((int)y.bEl((String)localObject1));
          if ((paramh.type == 33) || (paramh.type == 36) || (paramh.type == 46) || (paramh.type == 44) || (paramh.type == 48)) {}
          for (i = 1;; i = 0)
          {
            if ((i != 0) || (this.XSW < 262144L)) {
              break label655;
            }
            Log.w("MicroMsg.NetSceneSendAppMsg", "cdntra thumb[%s][%d] Too Big Not Use CDN TRANS", new Object[] { localObject1, Long.valueOf(this.XSW) });
            i = 0;
            break;
          }
          label655:
          Log.i("MicroMsg.NetSceneSendAppMsg", "cdntra content.type:%d  thumbPath:%s,  thumbLength:%d ", new Object[] { Integer.valueOf(paramh.type), localObject1, Long.valueOf(this.XSW) });
          if (!Util.isNullOrNil(paramh.hzM))
          {
            Log.w("MicroMsg.NetSceneSendAppMsg", "cdntra attach has been upload by cdn msgid:%d", new Object[] { Long.valueOf(this.msgId) });
            i = 0;
          }
          else
          {
            if (i == 0)
            {
              k.bHW();
              if (!com.tencent.mm.modelcdntran.g.vV(4))
              {
                k.bHW();
                Log.w("MicroMsg.NetSceneSendAppMsg", "cdntra not use cdn flag:%b ", new Object[] { Boolean.valueOf(com.tencent.mm.modelcdntran.g.vV(4)) });
                i = 0;
                continue;
              }
            }
            this.oHX = com.tencent.mm.modelcdntran.h.a("upappmsg", this.hTm.getCreateTime(), this.hTm.field_talker, this.hTm.field_msgId);
            if (Util.isNullOrNil(this.oHX))
            {
              Log.w("MicroMsg.NetSceneSendAppMsg", "cdntra genClientId failed not use cdn msgid:%d", new Object[] { Long.valueOf(this.hTm.field_msgId) });
              i = 0;
            }
            else
            {
              localObject2 = paramh.bwl();
              if (((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED)) && ((((com.tencent.mm.g.g)localObject2).lwL != null) || (!Util.isNullOrNil(((com.tencent.mm.g.g)localObject2).field_mediaId)) || (!Util.isNullOrNil(((com.tencent.mm.g.g)localObject2).field_thumbpath)) || (!Util.isNullOrNil(((com.tencent.mm.g.g)localObject2).field_talker))))
              {
                paramg = new RuntimeException("Do not fill reserved fields!");
                AppMethodBeat.o(31055);
                throw paramg;
              }
              ((com.tencent.mm.g.g)localObject2).lwL = this.osH;
              ((com.tencent.mm.g.g)localObject2).field_mediaId = this.oHX;
              ((com.tencent.mm.g.g)localObject2).field_thumbpath = ((String)localObject1);
              ((com.tencent.mm.g.g)localObject2).field_talker = this.hTm.field_talker;
              Log.i("MicroMsg.NetSceneSendAppMsg", "summersafecdn cdntra checkUseCdn content.type[%d], thumb[%s], useCdnTransClientId[%s], fileType[%d], enable_hitcheck[%b], onlycheckexist[%b], force_aeskeycdn[%b], trysafecdn[%b]", new Object[] { Integer.valueOf(paramh.type), localObject1, this.oHX, Integer.valueOf(((com.tencent.mm.g.g)localObject2).field_fileType), Boolean.valueOf(((com.tencent.mm.g.g)localObject2).field_enable_hitcheck), Boolean.valueOf(((com.tencent.mm.g.g)localObject2).field_onlycheckexist), Boolean.valueOf(((com.tencent.mm.g.g)localObject2).field_force_aeskeycdn), Boolean.valueOf(((com.tencent.mm.g.g)localObject2).field_trysafecdn) });
              if (!k.bHW().g((com.tencent.mm.g.g)localObject2))
              {
                Log.e("MicroMsg.NetSceneSendAppMsg", "cdntra addSendTask failed.");
                this.oHX = "";
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
      ad.b localb = com.tencent.mm.ui.transmit.c.bCJ(this.mSessionId);
      if ((localb != null) && (localb.containsKey("_tmpl_webview_transfer_scene")))
      {
        this.QsC = new aed();
        this.QsC.iiG.iiH = localb.getInt("_tmpl_webview_transfer_scene", -1);
      }
      ewx localewx = (ewx)c.b.b(this.rr.otB);
      fu localfu = new fu();
      localfu.oOI = paramh.appId;
      localfu.YHk = (this.hTm.field_talker + this.hTm.field_msgId + "T" + this.hTm.getCreateTime());
      localfu.nUB = k.b.a(paramh, null, null, 0, 0);
      localfu.CreateTime = ((int)Util.nowSecond());
      localfu.IMg = this.hTm.field_talker;
      localfu.IMh = com.tencent.mm.model.z.bAM();
      localfu.vhJ = paramh.type;
      localfu.YHj = paramh.sdkVer;
      localfu.IcB = paramh.nRg;
      localObject2 = a.a.aOb().o(this.hTm);
      String str;
      fhn localfhn;
      if (!Util.isNullOrNil((String)localObject2))
      {
        localfu.YFJ = ((String)localObject2);
        localfu.YHn = paramh.iad;
        localfu.YHo = paramh.iae;
        localfu.YHp = paramh.iaf;
        if (this.XSU != null)
        {
          localfu.YHq = this.XSU.XRT;
          localfu.IcK = this.XSU.pkgName;
        }
        if (localb != null)
        {
          this.QsB = new aec();
          this.QsB.iiq.url = paramh.url;
          this.QsB.iiq.iir = localb.getString("prePublishId", "");
          this.QsB.iiq.iit = localb.getString("preUsername", "");
          this.QsB.iiq.iiu = localb.getString("preChatName", "");
          this.QsB.iiq.iiv = localb.getInt("preMsgIndex", 0);
          this.QsB.iiq.iiz = localb.getInt("sendAppMsgScene", 0);
          this.QsB.iiq.iiA = localb.getInt("getA8KeyScene", 0);
          this.QsB.iiq.iiB = localb.getString("referUrl", null);
          this.QsB.iiq.iiC = localb.getString("adExtStr", null);
          this.QsB.iiq.iiw = this.hTm.field_talker;
          this.QsB.iiq.iiD = paramh.title;
          this.QsB.iiq.iiF = paramh.description;
          bh.bCz();
          localObject2 = com.tencent.mm.model.c.bzA().JE(this.hTm.field_talker);
          if (localObject2 != null) {
            this.QsB.iiq.iix = ((au)localObject2).aSU();
          }
          this.QsB.iiq.iiy = com.tencent.mm.model.v.getMembersCountByChatRoomName(this.hTm.field_talker);
          str = "";
          localObject2 = str;
          if (paramh.iah != null)
          {
            localfhn = new fhn();
            localObject2 = Base64.decode(paramh.iah, 0);
          }
        }
      }
      try
      {
        localfhn.parseFrom((byte[])localObject2);
        localObject2 = str;
        if (localfhn.abIe != null) {
          localObject2 = localfhn.abIe.ICZ;
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
      localewx.abza = String.format(Locale.US, "prePublishId=%s&preUserName=%s&preChatName=%s&preChatType=%d&getA8KeyScene=%d&sourceAppId=%s", new Object[] { this.QsB.iiq.iir, this.QsB.iiq.iit, this.QsB.iiq.iiu, Integer.valueOf(ac.aX(this.QsB.iiq.iit, this.QsB.iiq.iiu)), Integer.valueOf(this.QsB.iiq.iiA), localObject2 });
      if ((localb != null) && (paramh.type == 33))
      {
        this.XSV = new com.tencent.mm.autogen.a.s();
        i = localb.getInt("fromScene", 1);
        this.XSV.hzu.scene = i;
        j = localb.getInt("appservicetype", 0);
        this.XSV.hzu.appServiceType = j;
        localObject2 = localb.getString("preChatName", "");
        if (2 == i)
        {
          str = localb.getString("preUsername", "");
          this.XSV.hzu.hzx = ((String)localObject2 + ":" + str);
          label1993:
          localObject2 = this.hTm.field_talker;
          bool = localb.getBoolean("moreRetrAction", false);
          if (!((String)localObject2).endsWith("@chatroom")) {
            break label2486;
          }
          localObject2 = this.XSV.hzu;
          if (!bool) {
            break label2481;
          }
          i = 5;
          label2040:
          ((s.a)localObject2).action = i;
          this.XSV.hzu.hzw = (paramh.nTW + 1);
          this.XSV.hzu.hzy = paramh.nTC;
          this.XSV.hzu.hzv = paramh.nTD;
          this.XSV.hzu.appId = paramh.nTE;
          this.XSV.hzu.appVersion = paramh.nTX;
          this.XSV.hzu.hzA = Util.nowSecond();
          this.XSV.hzu.hzB = 1;
          this.XSV.hzu.hzD = paramh.nTI;
        }
      }
      else
      {
        Log.d("MicroMsg.NetSceneSendAppMsg", "SnsPostOperationFields: ShareUrlOriginal=%s, ShareUrlOpen=%s, JsAppId=%s", new Object[] { paramh.iad, paramh.iae, paramh.iaf });
        if (!Util.isNullOrNil((String)localObject1))
        {
          localObject2 = y.bi((String)localObject1, 0, -1);
          if (!Util.isNullOrNil((byte[])localObject2)) {
            localfu.YHl = new gol().df((byte[])localObject2);
          }
        }
        if (localfu.YHl == null) {
          break label2516;
        }
      }
      label2481:
      label2486:
      label2516:
      for (int i = localfu.YHl.abwJ;; i = -1)
      {
        Log.d("MicroMsg.NetSceneSendAppMsg", "doScene thumbFile:[%s] thumbdata:%d", new Object[] { localObject1, Integer.valueOf(i) });
        localewx.abyY = localfu;
        if ((paramh.nRh != 0) || (paramh.nRd > 26214400)) {
          localewx.YIE = com.tencent.mm.g.a.lwb;
        }
        localewx.Md5 = paramh.filemd5;
        localewx.pSi = this.mSignature;
        localewx.abzc = this.hYn;
        if (((com.tencent.mm.plugin.messenger.foundation.a.v)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.messenger.foundation.a.v.class)).ifAddTicketByActionFlag(this.hTm.field_talker)) {
          localewx.ZaR = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().bxH(this.hTm.field_talker);
        }
        Log.i("MicroMsg.NetSceneSendAppMsg", "summersafecdn file md5[%s], signature[%s], type[%d], fromScene[%s]", new Object[] { localewx.Md5, Util.secPrint(localewx.pSi), Integer.valueOf(localewx.YIE), localewx.abza });
        i = dispatch(paramg, this.rr, this);
        AppMethodBeat.o(31055);
        return i;
        localfu.YFJ = bt.bCQ();
        break;
        this.XSV.hzu.hzx = ((String)localObject2);
        break label1993;
        i = 2;
        break label2040;
        localObject2 = this.XSV.hzu;
        if (bool) {}
        for (i = 4;; i = 1)
        {
          ((s.a)localObject2).action = i;
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
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(31056);
    Log.i("MicroMsg.NetSceneSendAppMsg", "summersafecdn cdntra onGYNetEnd [%d,%d,%s] msgId:%d, oldContent[%s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Long.valueOf(this.msgId), Util.secPrint(this.hTm.field_content) });
    paramArrayOfByte = (ewy)c.c.b(((com.tencent.mm.am.c)params).otC);
    c.b.b(((com.tencent.mm.am.c)params).otB);
    if ((paramArrayOfByte != null) && ((paramInt2 == 4) || ((paramInt2 == 0) && (paramInt3 == 0)))) {
      ((com.tencent.mm.plugin.messenger.foundation.a.v)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.messenger.foundation.a.v.class)).setEnSendMsgActionFlag(paramArrayOfByte.ZaS);
    }
    if ((paramInt2 == 3) && (paramInt3 == -1) && (!Util.isNullOrNil(this.oHX)))
    {
      Log.w("MicroMsg.NetSceneSendAppMsg", "cdntra using cdn trans,  wait cdn service callback! clientid:%s", new Object[] { this.oHX });
      AppMethodBeat.o(31056);
      return;
    }
    bh.bCz();
    localcc = com.tencent.mm.model.c.bzD().sl(this.hTm.field_msgId);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      localcc.setStatus(5);
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(111L, 34L, 1L, true);
      bh.bCz();
      com.tencent.mm.model.c.bzD().a(localcc.field_msgId, localcc);
      Log.e("MicroMsg.NetSceneSendAppMsg", "send app msg failed, err=" + paramInt2 + "," + paramInt3 + ", msgId " + localcc.field_msgId);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(31056);
      return;
    }
    localcc.setStatus(2);
    localcc.gX(paramArrayOfByte.Njv);
    bh.bCz();
    com.tencent.mm.model.c.bzD().a(localcc.field_msgId, localcc);
    ((com.tencent.mm.plugin.record.a.f)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.record.a.f.class)).tl(localcc.field_msgId);
    com.tencent.mm.modelstat.b.oUZ.d(localcc, l.v(localcc));
    if ((this.QsB != null) && (!Util.isNullOrNil(this.QsB.iiq.url)))
    {
      this.QsB.iiq.iis = ("msg_" + Long.toString(paramArrayOfByte.Njv));
      this.QsB.publish();
    }
    if ((this.QsC != null) && (this.QsC.iiG.iiH != -1)) {
      this.QsC.publish();
    }
    localb = k.b.Hf(localcc.field_content);
    if ((localb != null) && ("wx4310bbd51be7d979".equals(localb.appId))) {
      if ((Util.isNullOrNil(localcc.field_talker)) || (!au.bwE(localcc.field_talker))) {
        break label785;
      }
    }
    label785:
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
          params = ((PluginGroupSolitaire)com.tencent.mm.kernel.h.az(PluginGroupSolitaire.class)).getGroupSolitatireReportManager();
          if ((localcc == null) || (localcc.field_msgSvrId <= 0L)) {}
          for (;;)
          {
            params = ((PluginGroupSolitaire)com.tencent.mm.kernel.h.az(PluginGroupSolitaire.class)).getGroupSolitatireReportManager();
            if ((localcc == null) || (localcc.field_msgSvrId <= 0L)) {
              break;
            }
            com.tencent.threadpool.h.ahAA.bm(new d.3(params, localcc));
            break;
            com.tencent.threadpool.h.ahAA.g(new d.1(params, localcc), "GroupSolitaireReport");
          }
          ((com.tencent.mm.plugin.msgquote.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.msgquote.a.class)).handleQuoteMsgSendResuld(localcc.field_msgId, localcc.field_msgSvrId);
          continue;
          params = o.aePR;
          o.d.a(6, localb, localcc);
        }
      }
      paramArrayOfByte = new StringBuilder("1,");
      if (paramInt1 == 0) {
        break;
      }
      paramInt1 = 2;
      params = paramInt1 + ",," + params;
      Log.i("MicroMsg.NetSceneSendAppMsg", "androidSystemShareFixed(13717) %s", new Object[] { params });
      com.tencent.mm.plugin.report.service.h.OAn.kvStat(13717, params);
      if (localb != null) {}
      switch (localb.type)
      {
      default: 
        if ((localb != null) && (au.bwG(localcc.field_talker)))
        {
          params = (com.tencent.mm.message.a)localb.aK(com.tencent.mm.message.a.class);
          if ((params != null) && (params.nPl)) {
            com.tencent.mm.chatroom.d.ab.a(localcc, localb);
          }
          ((com.tencent.mm.chatroom.plugin.a)com.tencent.mm.kernel.h.az(com.tencent.mm.chatroom.plugin.a.class)).handleGroupToolByReceiverAppMsg(localcc);
        }
        if (this.XSV != null)
        {
          this.XSV.hzu.hzz = ("msg_" + localcc.field_msgSvrId);
          this.XSV.publish();
        }
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(31056);
        return;
      }
    }
  }
  
  public final p.b securityVerificationChecked(com.tencent.mm.network.s params)
  {
    return p.b.ouh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.ak
 * JD-Core Version:    0.7.0.1
 */