package com.tencent.mm.pluginsdk.model.app;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.ah.l;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.chatroom.d.aa;
import com.tencent.mm.g.a.o.a;
import com.tencent.mm.g.a.yq;
import com.tencent.mm.g.a.yq.a;
import com.tencent.mm.g.a.yr;
import com.tencent.mm.g.a.yr.a;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.i.d;
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
import com.tencent.mm.protocal.protobuf.ctz;
import com.tencent.mm.protocal.protobuf.cua;
import com.tencent.mm.protocal.protobuf.dcs;
import com.tencent.mm.protocal.protobuf.dcu;
import com.tencent.mm.protocal.protobuf.dev;
import com.tencent.mm.protocal.protobuf.em;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bo;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Locale;
import junit.framework.Assert;

public final class ah
  extends n
  implements com.tencent.mm.network.k
{
  a DiC;
  private com.tencent.mm.g.a.o DiD;
  long DiE;
  private String bUS;
  com.tencent.mm.ak.g callback;
  bo dpq;
  int dtL;
  String hIq;
  private g.a hIz;
  String mSessionId;
  long msgId;
  private com.tencent.mm.ak.b rr;
  long startTime;
  private yq xRI;
  yr xRJ;
  
  public ah(long paramLong, String paramString, int paramInt, a parama)
  {
    this(paramLong, paramString, null);
    AppMethodBeat.i(31054);
    this.dtL = paramInt;
    this.DiC = parama;
    ac.i("MicroMsg.NetSceneSendAppMsg", "NetSceneSendAppMsg directShare[%d]", new Object[] { Integer.valueOf(paramInt) });
    if (this.DiC != null) {
      ac.i("MicroMsg.NetSceneSendAppMsg", "NetSceneSendAppMsg tokenValid[%d], pkgName[%s]", new Object[] { Integer.valueOf(this.DiC.DhJ), this.DiC.dtC });
    }
    AppMethodBeat.o(31054);
  }
  
  public ah(long paramLong, String paramString1, String paramString2)
  {
    AppMethodBeat.i(31053);
    this.dpq = null;
    this.msgId = 0L;
    this.dtL = 0;
    this.startTime = 0L;
    this.hIq = "";
    this.DiE = 0L;
    this.hIz = new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, final d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(31052);
        ac.d("MicroMsg.NetSceneSendAppMsg", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { ah.this.hIq, Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd });
        if (paramAnonymousInt == -21005)
        {
          ac.d("MicroMsg.NetSceneSendAppMsg", "cdntra  ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", new Object[] { ah.this.hIq });
          AppMethodBeat.o(31052);
          return 0;
        }
        if (paramAnonymousInt != 0)
        {
          ah.this.dpq.setStatus(5);
          com.tencent.mm.plugin.report.e.wTc.idkeyStat(111L, 34L, 1L, true);
          az.ayM();
          com.tencent.mm.model.c.awD().a(ah.this.dpq.field_msgId, ah.this.dpq);
          new com.tencent.mm.g.b.a.h(com.tencent.mm.plugin.report.a.u(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(1), Long.valueOf(ah.this.startTime), Long.valueOf(bs.eWj()), Integer.valueOf(com.tencent.mm.an.c.cD(com.tencent.mm.sdk.platformtools.ai.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Integer.valueOf(0), "" })).aHZ();
          ah.this.callback.onSceneEnd(3, paramAnonymousInt, "", ah.this);
          AppMethodBeat.o(31052);
          return 0;
        }
        if (paramAnonymousd != null)
        {
          if (paramAnonymousd.field_retCode != 0)
          {
            ac.e("MicroMsg.NetSceneSendAppMsg", "cdntra sceneResult.retCode :%d arg[%s] info[%s]", new Object[] { Integer.valueOf(paramAnonymousd.field_retCode), paramAnonymousd.field_arg, paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", paramAnonymousd.fqM });
            ah.this.dpq.setStatus(5);
            com.tencent.mm.plugin.report.e.wTc.idkeyStat(111L, 34L, 1L, true);
            az.ayM();
            com.tencent.mm.model.c.awD().a(ah.this.dpq.field_msgId, ah.this.dpq);
            paramAnonymousc = com.tencent.mm.plugin.report.a.u(new Object[] { Integer.valueOf(paramAnonymousd.field_retCode), Integer.valueOf(1), Long.valueOf(ah.this.startTime), Long.valueOf(bs.eWj()), Integer.valueOf(com.tencent.mm.an.c.cD(com.tencent.mm.sdk.platformtools.ai.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Long.valueOf(paramAnonymousd.field_fileLength), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", paramAnonymousd.fqM });
            new com.tencent.mm.g.b.a.h(paramAnonymousc).aHZ();
            new com.tencent.mm.g.b.a.f(paramAnonymousc).aHZ();
            ah.this.callback.onSceneEnd(3, paramAnonymousd.field_retCode, "", ah.this);
          }
        }
        else
        {
          if ((paramAnonymousString != null) && (paramAnonymousString.equals(ah.this.hIq)) && (ah.this.xRJ != null) && (ah.this.xRJ.dCx.dCy != -1))
          {
            com.tencent.mm.sdk.b.a.GpY.l(ah.this.xRJ);
            ah.this.xRJ = null;
          }
          AppMethodBeat.o(31052);
          return 0;
        }
        if ((ah.this.DiE > 0L) && (paramAnonymousd.field_fileLength > 0L) && (ah.this.dpq.getType() != 738197553))
        {
          paramAnonymousc = ah.this.DiE + "," + paramAnonymousd.field_fileLength + "," + paramAnonymousd.field_fileId;
          if (ah.this.DiE * 2L <= paramAnonymousd.field_fileLength) {
            break label941;
          }
        }
        label941:
        for (boolean bool = true;; bool = false)
        {
          at.D("SendAppMsgThumbTooBig", paramAnonymousc, bool);
          ac.i("MicroMsg.NetSceneSendAppMsg", "summersafecdn cdnCallback upload attach by cdn, isHitCacheUpload: %d, onlyCheckExist[%b], exist[%b], aesKey[%s], md5[%s]", new Object[] { Integer.valueOf(paramAnonymousd.field_UploadHitCacheType), Boolean.valueOf(paramAnonymousBoolean), Boolean.valueOf(paramAnonymousd.field_exist_whencheck), bs.aLJ(paramAnonymousd.field_aesKey), paramAnonymousd.field_filemd5 });
          if (ah.this.dpq.getType() == 738197553) {
            m.a(ah.this.dpq.field_msgId, "", paramAnonymousd, false);
          }
          az.agi().a(new ai(ah.this.msgId, paramAnonymousd, new ai.a()
          {
            public final void dm(int paramAnonymous2Int1, int paramAnonymous2Int2)
            {
              AppMethodBeat.i(31051);
              ac.d("MicroMsg.NetSceneSendAppMsg", "summersafecdn cdntra NetSceneSendAppMsgForCdn callback %d,%d", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2) });
              new com.tencent.mm.g.b.a.h(com.tencent.mm.plugin.report.a.u(new Object[] { Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(1), Long.valueOf(ah.this.startTime), Long.valueOf(bs.eWj()), Integer.valueOf(com.tencent.mm.an.c.cD(com.tencent.mm.sdk.platformtools.ai.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Long.valueOf(paramAnonymousd.field_fileLength), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", paramAnonymousd.fqM })).aHZ();
              ah.this.callback.onSceneEnd(paramAnonymous2Int1, paramAnonymous2Int2, "", ah.this);
              AppMethodBeat.o(31051);
            }
          }, ah.this.mSessionId, ah.this.dtL, ah.this.DiC), 0);
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
    this.bUS = paramString2;
    b.a locala = new b.a();
    locala.hvt = new ctz();
    locala.hvu = new cua();
    locala.uri = "/cgi-bin/micromsg-bin/sendappmsg";
    locala.funcId = 222;
    locala.reqCmdId = 107;
    locala.respCmdId = 1000000107;
    this.rr = locala.aAz();
    ac.i("MicroMsg.NetSceneSendAppMsg", "summersafecdn NetSceneSendAppMsg msgid[%d], sessionid[%s], signature[%s], stack[%s]", new Object[] { Long.valueOf(paramLong), paramString1, bs.aLJ(paramString2), bs.eWi() });
    AppMethodBeat.o(31053);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(31055);
    this.callback = paramg;
    if (this.startTime == 0L) {
      this.startTime = bs.eWj();
    }
    az.ayM();
    this.dpq = com.tencent.mm.model.c.awD().vP(this.msgId);
    if ((this.dpq == null) || (this.dpq.field_msgId != this.msgId))
    {
      AppMethodBeat.o(31055);
      return -1;
    }
    paramg = k.b.vA(this.dpq.field_content);
    Object localObject1;
    if (paramg == null)
    {
      localObject1 = au.aOb(this.dpq.field_content);
      if (bs.isNullOrNil(((au)localObject1).GXs))
      {
        paramg = new k.b();
        paramg.hhH = ((au)localObject1).md5;
        paramg.type = 8;
        ac.i("MicroMsg.NetSceneSendAppMsg", "create new content. loss appid");
      }
    }
    for (;;)
    {
      localObject1 = "content != null [[" + this.dpq.field_content + "]]";
      if (paramg != null) {}
      for (boolean bool = true;; bool = false)
      {
        Assert.assertTrue((String)localObject1, bool);
        if (paramg != null) {
          break label223;
        }
        this.dpq = null;
        AppMethodBeat.o(31055);
        return -1;
        paramg = k.b.vA(((au)localObject1).GXs);
        break;
      }
      label223:
      localObject1 = "";
      Object localObject2;
      if (this.dpq.cru())
      {
        localObject2 = com.tencent.mm.modelvideo.u.Ej(this.dpq.field_imgPath);
        if (localObject2 != null) {
          localObject1 = ((s)localObject2).iaR.hka;
        }
      }
      for (;;)
      {
        localObject2 = com.tencent.mm.model.y.ayq().xH(this.mSessionId);
        if ((localObject2 != null) && (((y.b)localObject2).containsKey("_tmpl_webview_transfer_scene")))
        {
          this.xRJ = new yr();
          this.xRJ.dCx.dCy = ((y.b)localObject2).getInt("_tmpl_webview_transfer_scene", -1);
        }
        if ((paramg.type == 8) || (paramg.type == 9))
        {
          ac.i("MicroMsg.NetSceneSendAppMsg", "cdntra cdn not support Emoji or voiceremind now type:%d", new Object[] { Integer.valueOf(paramg.type) });
          i = 0;
        }
        for (;;)
        {
          if (i == 0) {
            break label1017;
          }
          ac.d("MicroMsg.NetSceneSendAppMsg", "cdntra use cdn return -1 for onGYNetEnd clientId:%s", new Object[] { this.hIq });
          AppMethodBeat.o(31055);
          return 0;
          if (bs.isNullOrNil(this.dpq.field_imgPath)) {
            break label2375;
          }
          localObject1 = com.tencent.mm.av.o.aFx().Cl(this.dpq.field_imgPath);
          break;
          if (bs.isNullOrNil((String)localObject1))
          {
            ac.i("MicroMsg.NetSceneSendAppMsg", "cdntra cdn not support no thumb msg type:%d", new Object[] { Integer.valueOf(paramg.type) });
            i = 0;
          }
          else
          {
            this.DiE = ((int)com.tencent.mm.vfs.i.aSp((String)localObject1));
            if ((paramg.type == 33) || (paramg.type == 36) || (paramg.type == 46) || (paramg.type == 44) || (paramg.type == 48)) {}
            for (i = 1;; i = 0)
            {
              if ((i != 0) || (this.DiE < 262144L)) {
                break label571;
              }
              ac.w("MicroMsg.NetSceneSendAppMsg", "cdntra thumb[%s][%d] Too Big Not Use CDN TRANS", new Object[] { localObject1, Long.valueOf(this.DiE) });
              i = 0;
              break;
            }
            label571:
            ac.i("MicroMsg.NetSceneSendAppMsg", "cdntra content.type:%d  thumbPath:%s,  thumbLength:%d ", new Object[] { Integer.valueOf(paramg.type), localObject1, Long.valueOf(this.DiE) });
            if (!bs.isNullOrNil(paramg.cZa))
            {
              ac.w("MicroMsg.NetSceneSendAppMsg", "cdntra attach has been upload by cdn msgid:%d", new Object[] { Long.valueOf(this.msgId) });
              i = 0;
            }
            else
            {
              if (i == 0)
              {
                com.tencent.mm.an.f.aDD();
                if (!com.tencent.mm.an.b.oz(4))
                {
                  com.tencent.mm.an.f.aDD();
                  ac.w("MicroMsg.NetSceneSendAppMsg", "cdntra not use cdn flag:%b ", new Object[] { Boolean.valueOf(com.tencent.mm.an.b.oz(4)) });
                  i = 0;
                  continue;
                }
              }
              this.hIq = com.tencent.mm.an.c.a("upappmsg", this.dpq.field_createTime, this.dpq.field_talker, this.dpq.field_msgId);
              if (bs.isNullOrNil(this.hIq))
              {
                ac.w("MicroMsg.NetSceneSendAppMsg", "cdntra genClientId failed not use cdn msgid:%d", new Object[] { Long.valueOf(this.dpq.field_msgId) });
                i = 0;
              }
              else
              {
                localObject2 = paramg.awm();
                if (((com.tencent.mm.sdk.platformtools.h.DEBUG) || (com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED)) && ((((com.tencent.mm.i.g)localObject2).frb != null) || (!bs.isNullOrNil(((com.tencent.mm.i.g)localObject2).field_mediaId)) || (!bs.isNullOrNil(((com.tencent.mm.i.g)localObject2).field_thumbpath)) || (!bs.isNullOrNil(((com.tencent.mm.i.g)localObject2).field_talker))))
                {
                  parame = new RuntimeException("Do not fill reserved fields!");
                  AppMethodBeat.o(31055);
                  throw parame;
                }
                ((com.tencent.mm.i.g)localObject2).frb = this.hIz;
                ((com.tencent.mm.i.g)localObject2).field_mediaId = this.hIq;
                ((com.tencent.mm.i.g)localObject2).field_thumbpath = ((String)localObject1);
                ((com.tencent.mm.i.g)localObject2).field_talker = this.dpq.field_talker;
                ac.i("MicroMsg.NetSceneSendAppMsg", "summersafecdn cdntra checkUseCdn content.type[%d], thumb[%s], useCdnTransClientId[%s], fileType[%d], enable_hitcheck[%b], onlycheckexist[%b], force_aeskeycdn[%b], trysafecdn[%b]", new Object[] { Integer.valueOf(paramg.type), localObject1, this.hIq, Integer.valueOf(((com.tencent.mm.i.g)localObject2).field_fileType), Boolean.valueOf(((com.tencent.mm.i.g)localObject2).field_enable_hitcheck), Boolean.valueOf(((com.tencent.mm.i.g)localObject2).field_onlycheckexist), Boolean.valueOf(((com.tencent.mm.i.g)localObject2).field_force_aeskeycdn), Boolean.valueOf(((com.tencent.mm.i.g)localObject2).field_trysafecdn) });
                if (!com.tencent.mm.an.f.aDD().f((com.tencent.mm.i.g)localObject2))
                {
                  ac.e("MicroMsg.NetSceneSendAppMsg", "cdntra addSendTask failed.");
                  this.hIq = "";
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
        ctz localctz = (ctz)this.rr.hvr.hvw;
        em localem = new em();
        localem.hOf = paramg.appId;
        localem.DRb = (this.dpq.field_talker + this.dpq.field_msgId + "T" + this.dpq.field_createTime);
        localem.hkR = k.b.a(paramg, null, null, 0, 0);
        localem.CreateTime = ((int)bs.aNx());
        localem.tlJ = this.dpq.field_talker;
        localem.tlK = com.tencent.mm.model.u.axw();
        localem.ndI = paramg.type;
        localem.DRa = paramg.sdkVer;
        localem.sVo = paramg.hhI;
        localObject2 = a.a.Xf().o(this.dpq);
        y.b localb;
        String str;
        dcu localdcu;
        if (!bs.isNullOrNil((String)localObject2))
        {
          localem.DPY = ((String)localObject2);
          localem.DRe = paramg.dvo;
          localem.DRf = paramg.dvp;
          localem.DRg = paramg.dvq;
          if (this.DiC != null)
          {
            localem.DRh = this.DiC.DhJ;
            localem.thr = this.DiC.dtC;
          }
          localb = com.tencent.mm.model.y.ayq().xI(this.mSessionId);
          if (localb != null)
          {
            this.xRI = new yq();
            this.xRI.dCh.url = paramg.url;
            this.xRI.dCh.dCi = localb.getString("prePublishId", "");
            this.xRI.dCh.dCk = localb.getString("preUsername", "");
            this.xRI.dCh.dCl = localb.getString("preChatName", "");
            this.xRI.dCh.dCm = localb.getInt("preMsgIndex", 0);
            this.xRI.dCh.dCq = localb.getInt("sendAppMsgScene", 0);
            this.xRI.dCh.dCr = localb.getInt("getA8KeyScene", 0);
            this.xRI.dCh.dCs = localb.getString("referUrl", null);
            this.xRI.dCh.dCt = localb.getString("adExtStr", null);
            this.xRI.dCh.dCn = this.dpq.field_talker;
            this.xRI.dCh.dCu = paramg.title;
            this.xRI.dCh.dCw = paramg.description;
            az.ayM();
            localObject2 = com.tencent.mm.model.c.awB().aNt(this.dpq.field_talker);
            if (localObject2 != null) {
              this.xRI.dCh.dCo = ((com.tencent.mm.storage.ai)localObject2).aaR();
            }
            this.xRI.dCh.dCp = com.tencent.mm.model.q.wb(this.dpq.field_talker);
            str = "";
            localObject2 = str;
            if (paramg.dvs != null)
            {
              localdcu = new dcu();
              localObject2 = Base64.decode(paramg.dvs, 0);
            }
          }
        }
        try
        {
          localdcu.parseFrom((byte[])localObject2);
          localObject2 = str;
          if (localdcu.FMu != null) {
            localObject2 = localdcu.FMu.tdD;
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
        localctz.FFI = String.format(Locale.US, "prePublishId=%s&preUserName=%s&preChatName=%s&preChatType=%d&getA8KeyScene=%d&sourceAppId=%s", new Object[] { this.xRI.dCh.dCi, this.xRI.dCh.dCk, this.xRI.dCh.dCl, Integer.valueOf(x.aE(this.xRI.dCh.dCk, this.xRI.dCh.dCl)), Integer.valueOf(this.xRI.dCh.dCr), localObject2 });
        if ((localb != null) && (paramg.type == 33))
        {
          this.DiD = new com.tencent.mm.g.a.o();
          i = localb.getInt("fromScene", 1);
          this.DiD.cYN.scene = i;
          j = localb.getInt("appservicetype", 0);
          this.DiD.cYN.cca = j;
          localObject2 = localb.getString("preChatName", "");
          if (2 == i)
          {
            str = localb.getString("preUsername", "");
            this.DiD.cYN.cYP = ((String)localObject2 + ":" + str);
            label1866:
            localObject2 = this.dpq.field_talker;
            bool = localb.getBoolean("moreRetrAction", false);
            if (!((String)localObject2).endsWith("@chatroom")) {
              break label2331;
            }
            localObject2 = this.DiD.cYN;
            if (!bool) {
              break label2326;
            }
            i = 5;
            label1913:
            ((o.a)localObject2).action = i;
            this.DiD.cYN.cYO = (paramg.hkq + 1);
            this.DiD.cYN.cYQ = paramg.hkd;
            this.DiD.cYN.cYF = paramg.hke;
            this.DiD.cYN.appId = paramg.hkf;
            this.DiD.cYN.cYS = bs.aNx();
            this.DiD.cYN.cYT = 1;
          }
        }
        else
        {
          ac.d("MicroMsg.NetSceneSendAppMsg", "SnsPostOperationFields: ShareUrlOriginal=%s, ShareUrlOpen=%s, JsAppId=%s", new Object[] { paramg.dvo, paramg.dvp, paramg.dvq });
          if (!bs.isNullOrNil((String)localObject1))
          {
            localObject2 = com.tencent.mm.vfs.i.aU((String)localObject1, 0, -1);
            if (!bs.cv((byte[])localObject2)) {
              localem.DRc = new SKBuiltinBuffer_t().setBuffer((byte[])localObject2);
            }
          }
          if (localem.DRc == null) {
            break label2361;
          }
        }
        label2326:
        label2331:
        label2361:
        for (int i = localem.DRc.getILen();; i = -1)
        {
          ac.d("MicroMsg.NetSceneSendAppMsg", "doScene thumbFile:[%s] thumbdata:%d", new Object[] { localObject1, Integer.valueOf(i) });
          localctz.FFG = localem;
          if ((paramg.hhJ != 0) || (paramg.hhF > 26214400)) {
            localctz.DTc = com.tencent.mm.i.a.fqr;
          }
          localctz.Md5 = paramg.filemd5;
          localctz.iJW = this.bUS;
          localctz.FFK = this.dtL;
          if (((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).ifAddTicketByActionFlag(this.dpq.field_talker)) {
            localctz.EhE = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aND(this.dpq.field_talker);
          }
          ac.i("MicroMsg.NetSceneSendAppMsg", "summersafecdn file md5[%s], signature[%s], type[%d], fromScene[%s]", new Object[] { localctz.Md5, bs.aLJ(localctz.iJW), Integer.valueOf(localctz.DTc), localctz.FFI });
          i = dispatch(parame, this.rr, this);
          AppMethodBeat.o(31055);
          return i;
          localem.DPY = bk.TG();
          break;
          this.DiD.cYN.cYP = ((String)localObject2);
          break label1866;
          i = 2;
          break label1913;
          localObject2 = this.DiD.cYN;
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
    ac.i("MicroMsg.NetSceneSendAppMsg", "summersafecdn cdntra onGYNetEnd [%d,%d,%s] msgId:%d, oldContent[%s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Long.valueOf(this.msgId), this.dpq.field_content });
    paramArrayOfByte = (cua)((com.tencent.mm.ak.b)paramq).hvs.hvw;
    ctz localctz = (ctz)((com.tencent.mm.ak.b)paramq).hvr.hvw;
    if ((paramArrayOfByte != null) && ((paramInt2 == 4) || ((paramInt2 == 0) && (paramInt3 == 0)))) {
      ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).setEnSendMsgActionFlag(paramArrayOfByte.EhF);
    }
    if ((paramInt2 == 3) && (paramInt3 == -1) && (!bs.isNullOrNil(this.hIq)))
    {
      ac.w("MicroMsg.NetSceneSendAppMsg", "cdntra using cdn trans,  wait cdn service callback! clientid:%s", new Object[] { this.hIq });
      AppMethodBeat.o(31056);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.dpq.setStatus(5);
      com.tencent.mm.plugin.report.e.wTc.idkeyStat(111L, 34L, 1L, true);
      az.ayM();
      com.tencent.mm.model.c.awD().a(this.dpq.field_msgId, this.dpq);
      ac.e("MicroMsg.NetSceneSendAppMsg", "send app msg failed, err=" + paramInt2 + "," + paramInt3 + ", msgId " + this.dpq.field_msgId);
      if (paramInt2 == 4) {
        com.tencent.mm.plugin.report.service.h.wUl.f(10420, new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bs.eWj()), Integer.valueOf(com.tencent.mm.an.c.cD(com.tencent.mm.sdk.platformtools.ai.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_THUMBIMAGE), Integer.valueOf(0) });
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(31056);
      return;
    }
    this.dpq.setStatus(2);
    this.dpq.oz(paramArrayOfByte.vTQ);
    az.ayM();
    com.tencent.mm.model.c.awD().a(this.dpq.field_msgId, this.dpq);
    com.tencent.mm.modelstat.b.hUE.b(this.dpq, l.r(this.dpq));
    if ((this.xRI != null) && (!bs.isNullOrNil(this.xRI.dCh.url)))
    {
      this.xRI.dCh.dCj = ("msg_" + Long.toString(paramArrayOfByte.vTQ));
      com.tencent.mm.sdk.b.a.GpY.l(this.xRI);
    }
    if ((this.xRJ != null) && (this.xRJ.dCx.dCy != -1)) {
      com.tencent.mm.sdk.b.a.GpY.l(this.xRJ);
    }
    k.b localb = k.b.vA(this.dpq.field_content);
    if ((localb != null) && ("wx4310bbd51be7d979".equals(localb.appId))) {
      if ((bs.isNullOrNil(this.dpq.field_talker)) || (!w.sQ(this.dpq.field_talker))) {
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
          ac.printErrStackTrace("MicroMsg.NetSceneSendAppMsg", paramArrayOfByte, "", new Object[0]);
          continue;
          paramInt1 = 1;
          continue;
          paramq = ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireReportManager();
          paramArrayOfByte = this.dpq;
          if ((paramArrayOfByte == null) || (paramArrayOfByte.field_msgSvrId <= 0L)) {}
          for (;;)
          {
            paramq = ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireReportManager();
            paramArrayOfByte = this.dpq;
            if ((paramArrayOfByte == null) || (paramArrayOfByte.field_msgSvrId <= 0L)) {
              break;
            }
            com.tencent.e.h.JZN.aS(new d.3(paramq, paramArrayOfByte));
            break;
            com.tencent.e.h.JZN.f(new d.1(paramq, paramArrayOfByte), "GroupSolitaireReport");
          }
          ((com.tencent.mm.plugin.msgquote.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.msgquote.a.class)).handleQuoteMsgSendResuld(this.dpq.field_msgId, this.dpq.field_msgSvrId);
        }
      }
      paramArrayOfByte = new StringBuilder("1,");
      if (paramInt1 == 0) {
        break;
      }
      paramInt1 = 2;
      paramq = paramInt1 + ",," + paramq;
      ac.i("MicroMsg.NetSceneSendAppMsg", "androidSystemShareFixed(13717) %s", new Object[] { paramq });
      com.tencent.mm.plugin.report.service.h.wUl.kvStat(13717, paramq);
      if (localb != null) {}
      switch (localb.type)
      {
      default: 
        if ((localb != null) && (w.wp(this.dpq.field_talker)))
        {
          paramq = (com.tencent.mm.ah.a)localb.ao(com.tencent.mm.ah.a.class);
          if ((paramq != null) && (paramq.hgn)) {
            com.tencent.mm.chatroom.d.y.a(this.dpq, localb);
          }
          if (aa.VQ()) {
            ((com.tencent.mm.chatroom.plugin.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.chatroom.plugin.a.class)).handleGroupToolByReceiverAppMsg(this.dpq);
          }
        }
        if (this.DiD != null)
        {
          this.DiD.cYN.cYR = ("msg_" + this.dpq.field_msgSvrId);
          com.tencent.mm.sdk.b.a.GpY.l(this.DiD);
        }
        if (localctz.FFG.DRc != null) {
          com.tencent.mm.plugin.report.service.h.wUl.f(10420, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bs.eWj()), Integer.valueOf(com.tencent.mm.an.c.cD(com.tencent.mm.sdk.platformtools.ai.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_THUMBIMAGE), Integer.valueOf(localctz.FFG.DRc.getILen()) });
        }
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(31056);
        return;
      }
    }
  }
  
  public final n.b securityVerificationChecked(com.tencent.mm.network.q paramq)
  {
    return n.b.hwa;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.ah
 * JD-Core Version:    0.7.0.1
 */