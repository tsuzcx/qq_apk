package com.tencent.mm.pluginsdk.model.app;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.n.b;
import com.tencent.mm.chatroom.d.aa;
import com.tencent.mm.g.a.o;
import com.tencent.mm.g.a.o.a;
import com.tencent.mm.g.a.zk;
import com.tencent.mm.g.a.zk.a;
import com.tencent.mm.g.a.zl;
import com.tencent.mm.g.a.zl.a;
import com.tencent.mm.g.b.a.j;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.a;
import com.tencent.mm.m.a.a;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.w;
import com.tencent.mm.model.x;
import com.tencent.mm.model.y.b;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.network.k;
import com.tencent.mm.plugin.groupsolitaire.PluginGroupSolitaire;
import com.tencent.mm.plugin.groupsolitaire.b.d.1;
import com.tencent.mm.plugin.groupsolitaire.b.d.3;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.czj;
import com.tencent.mm.protocal.protobuf.czk;
import com.tencent.mm.protocal.protobuf.dif;
import com.tencent.mm.protocal.protobuf.dih;
import com.tencent.mm.protocal.protobuf.dki;
import com.tencent.mm.protocal.protobuf.eq;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.ay;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bu;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Locale;
import junit.framework.Assert;

public final class ag
  extends n
  implements k
{
  a ENp;
  private o ENq;
  long ENr;
  com.tencent.mm.al.f callback;
  private String cff;
  bu dBd;
  int dFL;
  String ibe;
  private g.a ibn;
  String mSessionId;
  long msgId;
  private com.tencent.mm.al.b rr;
  long startTime;
  private zk zhC;
  zl zhD;
  
  public ag(long paramLong, String paramString, int paramInt, a parama)
  {
    this(paramLong, paramString, null);
    AppMethodBeat.i(31054);
    this.dFL = paramInt;
    this.ENp = parama;
    ad.i("MicroMsg.NetSceneSendAppMsg", "NetSceneSendAppMsg directShare[%d]", new Object[] { Integer.valueOf(paramInt) });
    if (this.ENp != null) {
      ad.i("MicroMsg.NetSceneSendAppMsg", "NetSceneSendAppMsg tokenValid[%d], pkgName[%s]", new Object[] { Integer.valueOf(this.ENp.EMu), this.ENp.dFD });
    }
    AppMethodBeat.o(31054);
  }
  
  public ag(long paramLong, String paramString1, String paramString2)
  {
    AppMethodBeat.i(31053);
    this.dBd = null;
    this.msgId = 0L;
    this.dFL = 0;
    this.startTime = 0L;
    this.ibe = "";
    this.ENr = 0L;
    this.ibn = new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, final d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(31052);
        ad.d("MicroMsg.NetSceneSendAppMsg", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { ag.this.ibe, Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd });
        if (paramAnonymousInt == -21005)
        {
          ad.d("MicroMsg.NetSceneSendAppMsg", "cdntra  ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", new Object[] { ag.this.ibe });
          AppMethodBeat.o(31052);
          return 0;
        }
        if (paramAnonymousInt != 0)
        {
          ag.this.dBd.setStatus(5);
          com.tencent.mm.plugin.report.e.ygI.idkeyStat(111L, 34L, 1L, true);
          ba.aBQ();
          com.tencent.mm.model.c.azs().a(ag.this.dBd.field_msgId, ag.this.dBd);
          new j(com.tencent.mm.plugin.report.a.u(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(1), Long.valueOf(ag.this.startTime), Long.valueOf(bt.flT()), Integer.valueOf(com.tencent.mm.ao.c.cA(aj.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Integer.valueOf(0), "" })).aLk();
          ag.this.callback.onSceneEnd(3, paramAnonymousInt, "", ag.this);
          AppMethodBeat.o(31052);
          return 0;
        }
        if (paramAnonymousd != null)
        {
          if (paramAnonymousd.field_retCode != 0)
          {
            ad.e("MicroMsg.NetSceneSendAppMsg", "cdntra sceneResult.retCode :%d arg[%s] info[%s]", new Object[] { Integer.valueOf(paramAnonymousd.field_retCode), paramAnonymousd.field_arg, paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", paramAnonymousd.fIT });
            ag.this.dBd.setStatus(5);
            com.tencent.mm.plugin.report.e.ygI.idkeyStat(111L, 34L, 1L, true);
            ba.aBQ();
            com.tencent.mm.model.c.azs().a(ag.this.dBd.field_msgId, ag.this.dBd);
            paramAnonymousc = com.tencent.mm.plugin.report.a.u(new Object[] { Integer.valueOf(paramAnonymousd.field_retCode), Integer.valueOf(1), Long.valueOf(ag.this.startTime), Long.valueOf(bt.flT()), Integer.valueOf(com.tencent.mm.ao.c.cA(aj.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Long.valueOf(paramAnonymousd.field_fileLength), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", paramAnonymousd.fIT });
            new j(paramAnonymousc).aLk();
            new com.tencent.mm.g.b.a.h(paramAnonymousc).aLk();
            ag.this.callback.onSceneEnd(3, paramAnonymousd.field_retCode, "", ag.this);
          }
        }
        else
        {
          if ((paramAnonymousString != null) && (paramAnonymousString.equals(ag.this.ibe)) && (ag.this.zhD != null) && (ag.this.zhD.dOK.dOL != -1))
          {
            com.tencent.mm.sdk.b.a.IbL.l(ag.this.zhD);
            ag.this.zhD = null;
          }
          AppMethodBeat.o(31052);
          return 0;
        }
        if ((ag.this.ENr > 0L) && (paramAnonymousd.field_fileLength > 0L) && (ag.this.dBd.getType() != 738197553))
        {
          paramAnonymousc = ag.this.ENr + "," + paramAnonymousd.field_fileLength + "," + paramAnonymousd.field_fileId;
          if (ag.this.ENr * 2L <= paramAnonymousd.field_fileLength) {
            break label941;
          }
        }
        label941:
        for (boolean bool = true;; bool = false)
        {
          au.D("SendAppMsgThumbTooBig", paramAnonymousc, bool);
          ad.i("MicroMsg.NetSceneSendAppMsg", "summersafecdn cdnCallback upload attach by cdn, isHitCacheUpload: %d, onlyCheckExist[%b], exist[%b], aesKey[%s], md5[%s]", new Object[] { Integer.valueOf(paramAnonymousd.field_UploadHitCacheType), Boolean.valueOf(paramAnonymousBoolean), Boolean.valueOf(paramAnonymousd.field_exist_whencheck), bt.aRp(paramAnonymousd.field_aesKey), paramAnonymousd.field_filemd5 });
          if (ag.this.dBd.getType() == 738197553) {
            m.a(ag.this.dBd.field_msgId, "", paramAnonymousd, false);
          }
          ba.aiU().a(new ah(ag.this.msgId, paramAnonymousd, new ah.a()
          {
            public final void dg(int paramAnonymous2Int1, int paramAnonymous2Int2)
            {
              AppMethodBeat.i(31051);
              ad.d("MicroMsg.NetSceneSendAppMsg", "summersafecdn cdntra NetSceneSendAppMsgForCdn callback %d,%d", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2) });
              new j(com.tencent.mm.plugin.report.a.u(new Object[] { Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(1), Long.valueOf(ag.this.startTime), Long.valueOf(bt.flT()), Integer.valueOf(com.tencent.mm.ao.c.cA(aj.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Long.valueOf(paramAnonymousd.field_fileLength), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", paramAnonymousd.fIT })).aLk();
              ag.this.callback.onSceneEnd(paramAnonymous2Int1, paramAnonymous2Int2, "", ag.this);
              AppMethodBeat.o(31051);
            }
          }, ag.this.mSessionId, ag.this.dFL, ag.this.ENp), 0);
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
    locala.hNM = new czj();
    locala.hNN = new czk();
    locala.uri = "/cgi-bin/micromsg-bin/sendappmsg";
    locala.funcId = 222;
    locala.hNO = 107;
    locala.respCmdId = 1000000107;
    this.rr = locala.aDC();
    ad.i("MicroMsg.NetSceneSendAppMsg", "summersafecdn NetSceneSendAppMsg msgid[%d], sessionid[%s], signature[%s], stack[%s]", new Object[] { Long.valueOf(paramLong), paramString1, bt.aRp(paramString2), bt.flS() });
    AppMethodBeat.o(31053);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.f paramf)
  {
    AppMethodBeat.i(31055);
    this.callback = paramf;
    if (this.startTime == 0L) {
      this.startTime = bt.flT();
    }
    ba.aBQ();
    this.dBd = com.tencent.mm.model.c.azs().xY(this.msgId);
    if ((this.dBd == null) || (this.dBd.field_msgId != this.msgId))
    {
      AppMethodBeat.o(31055);
      return -1;
    }
    paramf = k.b.yr(this.dBd.field_content);
    Object localObject1;
    if (paramf == null)
    {
      localObject1 = ay.aTS(this.dBd.field_content);
      if (bt.isNullOrNil(((ay)localObject1).IKG))
      {
        paramf = new k.b();
        paramf.hzQ = ((ay)localObject1).md5;
        paramf.type = 8;
        ad.i("MicroMsg.NetSceneSendAppMsg", "create new content. loss appid");
      }
    }
    for (;;)
    {
      localObject1 = "content != null [[" + this.dBd.field_content + "]]";
      if (paramf != null) {}
      for (boolean bool = true;; bool = false)
      {
        Assert.assertTrue((String)localObject1, bool);
        if (paramf != null) {
          break label223;
        }
        this.dBd = null;
        AppMethodBeat.o(31055);
        return -1;
        paramf = k.b.yr(((ay)localObject1).IKG);
        break;
      }
      label223:
      localObject1 = "";
      Object localObject2;
      if (this.dBd.cxg())
      {
        localObject2 = com.tencent.mm.modelvideo.u.Hy(this.dBd.field_imgPath);
        if (localObject2 != null) {
          localObject1 = ((s)localObject2).iun.hCj;
        }
      }
      for (;;)
      {
        localObject2 = com.tencent.mm.model.y.aBq().AF(this.mSessionId);
        if ((localObject2 != null) && (((y.b)localObject2).containsKey("_tmpl_webview_transfer_scene")))
        {
          this.zhD = new zl();
          this.zhD.dOK.dOL = ((y.b)localObject2).getInt("_tmpl_webview_transfer_scene", -1);
        }
        if ((paramf.type == 8) || (paramf.type == 9))
        {
          ad.i("MicroMsg.NetSceneSendAppMsg", "cdntra cdn not support Emoji or voiceremind now type:%d", new Object[] { Integer.valueOf(paramf.type) });
          i = 0;
        }
        for (;;)
        {
          if (i == 0) {
            break label1017;
          }
          ad.d("MicroMsg.NetSceneSendAppMsg", "cdntra use cdn return -1 for onGYNetEnd clientId:%s", new Object[] { this.ibe });
          AppMethodBeat.o(31055);
          return 0;
          if (bt.isNullOrNil(this.dBd.field_imgPath)) {
            break label2375;
          }
          localObject1 = com.tencent.mm.aw.q.aIF().Fm(this.dBd.field_imgPath);
          break;
          if (bt.isNullOrNil((String)localObject1))
          {
            ad.i("MicroMsg.NetSceneSendAppMsg", "cdntra cdn not support no thumb msg type:%d", new Object[] { Integer.valueOf(paramf.type) });
            i = 0;
          }
          else
          {
            this.ENr = ((int)com.tencent.mm.vfs.i.aYo((String)localObject1));
            if ((paramf.type == 33) || (paramf.type == 36) || (paramf.type == 46) || (paramf.type == 44) || (paramf.type == 48)) {}
            for (i = 1;; i = 0)
            {
              if ((i != 0) || (this.ENr < 262144L)) {
                break label571;
              }
              ad.w("MicroMsg.NetSceneSendAppMsg", "cdntra thumb[%s][%d] Too Big Not Use CDN TRANS", new Object[] { localObject1, Long.valueOf(this.ENr) });
              i = 0;
              break;
            }
            label571:
            ad.i("MicroMsg.NetSceneSendAppMsg", "cdntra content.type:%d  thumbPath:%s,  thumbLength:%d ", new Object[] { Integer.valueOf(paramf.type), localObject1, Long.valueOf(this.ENr) });
            if (!bt.isNullOrNil(paramf.dks))
            {
              ad.w("MicroMsg.NetSceneSendAppMsg", "cdntra attach has been upload by cdn msgid:%d", new Object[] { Long.valueOf(this.msgId) });
              i = 0;
            }
            else
            {
              if (i == 0)
              {
                com.tencent.mm.ao.f.aGI();
                if (!com.tencent.mm.ao.b.pa(4))
                {
                  com.tencent.mm.ao.f.aGI();
                  ad.w("MicroMsg.NetSceneSendAppMsg", "cdntra not use cdn flag:%b ", new Object[] { Boolean.valueOf(com.tencent.mm.ao.b.pa(4)) });
                  i = 0;
                  continue;
                }
              }
              this.ibe = com.tencent.mm.ao.c.a("upappmsg", this.dBd.field_createTime, this.dBd.field_talker, this.dBd.field_msgId);
              if (bt.isNullOrNil(this.ibe))
              {
                ad.w("MicroMsg.NetSceneSendAppMsg", "cdntra genClientId failed not use cdn msgid:%d", new Object[] { Long.valueOf(this.dBd.field_msgId) });
                i = 0;
              }
              else
              {
                localObject2 = paramf.ayZ();
                if (((com.tencent.mm.sdk.platformtools.i.DEBUG) || (com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_RED)) && ((((com.tencent.mm.i.g)localObject2).fJj != null) || (!bt.isNullOrNil(((com.tencent.mm.i.g)localObject2).field_mediaId)) || (!bt.isNullOrNil(((com.tencent.mm.i.g)localObject2).field_thumbpath)) || (!bt.isNullOrNil(((com.tencent.mm.i.g)localObject2).field_talker))))
                {
                  parame = new RuntimeException("Do not fill reserved fields!");
                  AppMethodBeat.o(31055);
                  throw parame;
                }
                ((com.tencent.mm.i.g)localObject2).fJj = this.ibn;
                ((com.tencent.mm.i.g)localObject2).field_mediaId = this.ibe;
                ((com.tencent.mm.i.g)localObject2).field_thumbpath = ((String)localObject1);
                ((com.tencent.mm.i.g)localObject2).field_talker = this.dBd.field_talker;
                ad.i("MicroMsg.NetSceneSendAppMsg", "summersafecdn cdntra checkUseCdn content.type[%d], thumb[%s], useCdnTransClientId[%s], fileType[%d], enable_hitcheck[%b], onlycheckexist[%b], force_aeskeycdn[%b], trysafecdn[%b]", new Object[] { Integer.valueOf(paramf.type), localObject1, this.ibe, Integer.valueOf(((com.tencent.mm.i.g)localObject2).field_fileType), Boolean.valueOf(((com.tencent.mm.i.g)localObject2).field_enable_hitcheck), Boolean.valueOf(((com.tencent.mm.i.g)localObject2).field_onlycheckexist), Boolean.valueOf(((com.tencent.mm.i.g)localObject2).field_force_aeskeycdn), Boolean.valueOf(((com.tencent.mm.i.g)localObject2).field_trysafecdn) });
                if (!com.tencent.mm.ao.f.aGI().f((com.tencent.mm.i.g)localObject2))
                {
                  ad.e("MicroMsg.NetSceneSendAppMsg", "cdntra addSendTask failed.");
                  this.ibe = "";
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
        czj localczj = (czj)this.rr.hNK.hNQ;
        eq localeq = new eq();
        localeq.iht = paramf.appId;
        localeq.Fwt = (this.dBd.field_talker + this.dBd.field_msgId + "T" + this.dBd.field_createTime);
        localeq.hDa = k.b.a(paramf, null, null, 0, 0);
        localeq.CreateTime = ((int)bt.aQJ());
        localeq.uki = this.dBd.field_talker;
        localeq.ukj = com.tencent.mm.model.u.aAm();
        localeq.nEf = paramf.type;
        localeq.Fws = paramf.sdkVer;
        localeq.tRT = paramf.hzR;
        localObject2 = a.a.ZG().o(this.dBd);
        y.b localb;
        String str;
        dih localdih;
        if (!bt.isNullOrNil((String)localObject2))
        {
          localeq.Fvn = ((String)localObject2);
          localeq.Fww = paramf.dHr;
          localeq.Fwx = paramf.dHs;
          localeq.Fwy = paramf.dHt;
          if (this.ENp != null)
          {
            localeq.Fwz = this.ENp.EMu;
            localeq.ufi = this.ENp.dFD;
          }
          localb = com.tencent.mm.model.y.aBq().AG(this.mSessionId);
          if (localb != null)
          {
            this.zhC = new zk();
            this.zhC.dOu.url = paramf.url;
            this.zhC.dOu.dOv = localb.getString("prePublishId", "");
            this.zhC.dOu.dOx = localb.getString("preUsername", "");
            this.zhC.dOu.dOy = localb.getString("preChatName", "");
            this.zhC.dOu.dOz = localb.getInt("preMsgIndex", 0);
            this.zhC.dOu.dOD = localb.getInt("sendAppMsgScene", 0);
            this.zhC.dOu.dOE = localb.getInt("getA8KeyScene", 0);
            this.zhC.dOu.dOF = localb.getString("referUrl", null);
            this.zhC.dOu.dOG = localb.getString("adExtStr", null);
            this.zhC.dOu.dOA = this.dBd.field_talker;
            this.zhC.dOu.dOH = paramf.title;
            this.zhC.dOu.dOJ = paramf.description;
            ba.aBQ();
            localObject2 = com.tencent.mm.model.c.azp().Bf(this.dBd.field_talker);
            if (localObject2 != null) {
              this.zhC.dOu.dOB = ((am)localObject2).adu();
            }
            this.zhC.dOu.dOC = com.tencent.mm.model.q.yS(this.dBd.field_talker);
            str = "";
            localObject2 = str;
            if (paramf.dHv != null)
            {
              localdih = new dih();
              localObject2 = Base64.decode(paramf.dHv, 0);
            }
          }
        }
        try
        {
          localdih.parseFrom((byte[])localObject2);
          localObject2 = str;
          if (localdih.Hxc != null) {
            localObject2 = localdih.Hxc.ubt;
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
        localczj.Hqh = String.format(Locale.US, "prePublishId=%s&preUserName=%s&preChatName=%s&preChatType=%d&getA8KeyScene=%d&sourceAppId=%s", new Object[] { this.zhC.dOu.dOv, this.zhC.dOu.dOx, this.zhC.dOu.dOy, Integer.valueOf(x.aG(this.zhC.dOu.dOx, this.zhC.dOu.dOy)), Integer.valueOf(this.zhC.dOu.dOE), localObject2 });
        if ((localb != null) && (paramf.type == 33))
        {
          this.ENq = new o();
          i = localb.getInt("fromScene", 1);
          this.ENq.dkf.scene = i;
          j = localb.getInt("appservicetype", 0);
          this.ENq.dkf.cmr = j;
          localObject2 = localb.getString("preChatName", "");
          if (2 == i)
          {
            str = localb.getString("preUsername", "");
            this.ENq.dkf.dkh = ((String)localObject2 + ":" + str);
            label1866:
            localObject2 = this.dBd.field_talker;
            bool = localb.getBoolean("moreRetrAction", false);
            if (!((String)localObject2).endsWith("@chatroom")) {
              break label2331;
            }
            localObject2 = this.ENq.dkf;
            if (!bool) {
              break label2326;
            }
            i = 5;
            label1913:
            ((o.a)localObject2).action = i;
            this.ENq.dkf.dkg = (paramf.hCz + 1);
            this.ENq.dkf.dki = paramf.hCm;
            this.ENq.dkf.djX = paramf.hCn;
            this.ENq.dkf.appId = paramf.hCo;
            this.ENq.dkf.dkk = bt.aQJ();
            this.ENq.dkf.dkl = 1;
          }
        }
        else
        {
          ad.d("MicroMsg.NetSceneSendAppMsg", "SnsPostOperationFields: ShareUrlOriginal=%s, ShareUrlOpen=%s, JsAppId=%s", new Object[] { paramf.dHr, paramf.dHs, paramf.dHt });
          if (!bt.isNullOrNil((String)localObject1))
          {
            localObject2 = com.tencent.mm.vfs.i.aY((String)localObject1, 0, -1);
            if (!bt.cC((byte[])localObject2)) {
              localeq.Fwu = new SKBuiltinBuffer_t().setBuffer((byte[])localObject2);
            }
          }
          if (localeq.Fwu == null) {
            break label2361;
          }
        }
        label2326:
        label2331:
        label2361:
        for (int i = localeq.Fwu.getILen();; i = -1)
        {
          ad.d("MicroMsg.NetSceneSendAppMsg", "doScene thumbFile:[%s] thumbdata:%d", new Object[] { localObject1, Integer.valueOf(i) });
          localczj.Hqf = localeq;
          if ((paramf.hzS != 0) || (paramf.hzO > 26214400)) {
            localczj.Fyv = com.tencent.mm.i.a.fIy;
          }
          localczj.Md5 = paramf.filemd5;
          localczj.jdf = this.cff;
          localczj.Hqj = this.dFL;
          if (((r)com.tencent.mm.kernel.g.ad(r.class)).ifAddTicketByActionFlag(this.dBd.field_talker)) {
            localczj.FOL = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().aTu(this.dBd.field_talker);
          }
          ad.i("MicroMsg.NetSceneSendAppMsg", "summersafecdn file md5[%s], signature[%s], type[%d], fromScene[%s]", new Object[] { localczj.Md5, bt.aRp(localczj.jdf), Integer.valueOf(localczj.Fyv), localczj.Hqh });
          i = dispatch(parame, this.rr, this);
          AppMethodBeat.o(31055);
          return i;
          localeq.Fvn = bl.VW();
          break;
          this.ENq.dkf.dkh = ((String)localObject2);
          break label1866;
          i = 2;
          break label1913;
          localObject2 = this.ENq.dkf;
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
    ad.i("MicroMsg.NetSceneSendAppMsg", "summersafecdn cdntra onGYNetEnd [%d,%d,%s] msgId:%d, oldContent[%s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Long.valueOf(this.msgId), this.dBd.field_content });
    paramArrayOfByte = (czk)((com.tencent.mm.al.b)paramq).hNL.hNQ;
    czj localczj = (czj)((com.tencent.mm.al.b)paramq).hNK.hNQ;
    if ((paramArrayOfByte != null) && ((paramInt2 == 4) || ((paramInt2 == 0) && (paramInt3 == 0)))) {
      ((r)com.tencent.mm.kernel.g.ad(r.class)).setEnSendMsgActionFlag(paramArrayOfByte.FOM);
    }
    if ((paramInt2 == 3) && (paramInt3 == -1) && (!bt.isNullOrNil(this.ibe)))
    {
      ad.w("MicroMsg.NetSceneSendAppMsg", "cdntra using cdn trans,  wait cdn service callback! clientid:%s", new Object[] { this.ibe });
      AppMethodBeat.o(31056);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.dBd.setStatus(5);
      com.tencent.mm.plugin.report.e.ygI.idkeyStat(111L, 34L, 1L, true);
      ba.aBQ();
      com.tencent.mm.model.c.azs().a(this.dBd.field_msgId, this.dBd);
      ad.e("MicroMsg.NetSceneSendAppMsg", "send app msg failed, err=" + paramInt2 + "," + paramInt3 + ", msgId " + this.dBd.field_msgId);
      if (paramInt2 == 4) {
        com.tencent.mm.plugin.report.service.g.yhR.f(10420, new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bt.flT()), Integer.valueOf(com.tencent.mm.ao.c.cA(aj.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_THUMBIMAGE), Integer.valueOf(0) });
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(31056);
      return;
    }
    this.dBd.setStatus(2);
    this.dBd.qz(paramArrayOfByte.xbt);
    ba.aBQ();
    com.tencent.mm.model.c.azs().a(this.dBd.field_msgId, this.dBd);
    ((com.tencent.mm.plugin.record.a.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.record.a.f.class)).yB(this.dBd.field_msgId);
    com.tencent.mm.modelstat.b.inZ.b(this.dBd, com.tencent.mm.ai.l.r(this.dBd));
    if ((this.zhC != null) && (!bt.isNullOrNil(this.zhC.dOu.url)))
    {
      this.zhC.dOu.dOw = ("msg_" + Long.toString(paramArrayOfByte.xbt));
      com.tencent.mm.sdk.b.a.IbL.l(this.zhC);
    }
    if ((this.zhD != null) && (this.zhD.dOK.dOL != -1)) {
      com.tencent.mm.sdk.b.a.IbL.l(this.zhD);
    }
    k.b localb = k.b.yr(this.dBd.field_content);
    if ((localb != null) && ("wx4310bbd51be7d979".equals(localb.appId))) {
      if ((bt.isNullOrNil(this.dBd.field_talker)) || (!w.vF(this.dBd.field_talker))) {
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
          ad.printErrStackTrace("MicroMsg.NetSceneSendAppMsg", paramArrayOfByte, "", new Object[0]);
          continue;
          paramInt1 = 1;
          continue;
          paramq = ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireReportManager();
          paramArrayOfByte = this.dBd;
          if ((paramArrayOfByte == null) || (paramArrayOfByte.field_msgSvrId <= 0L)) {}
          for (;;)
          {
            paramq = ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireReportManager();
            paramArrayOfByte = this.dBd;
            if ((paramArrayOfByte == null) || (paramArrayOfByte.field_msgSvrId <= 0L)) {
              break;
            }
            com.tencent.e.h.LTJ.aR(new d.3(paramq, paramArrayOfByte));
            break;
            com.tencent.e.h.LTJ.f(new d.1(paramq, paramArrayOfByte), "GroupSolitaireReport");
          }
          ((com.tencent.mm.plugin.msgquote.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.msgquote.a.class)).handleQuoteMsgSendResuld(this.dBd.field_msgId, this.dBd.field_msgSvrId);
        }
      }
      paramArrayOfByte = new StringBuilder("1,");
      if (paramInt1 == 0) {
        break;
      }
      paramInt1 = 2;
      paramq = paramInt1 + ",," + paramq;
      ad.i("MicroMsg.NetSceneSendAppMsg", "androidSystemShareFixed(13717) %s", new Object[] { paramq });
      com.tencent.mm.plugin.report.service.g.yhR.kvStat(13717, paramq);
      if (localb != null) {}
      switch (localb.type)
      {
      default: 
        if ((localb != null) && (w.zk(this.dBd.field_talker)))
        {
          paramq = (com.tencent.mm.ai.a)localb.ao(com.tencent.mm.ai.a.class);
          if ((paramq != null) && (paramq.hyw)) {
            com.tencent.mm.chatroom.d.y.a(this.dBd, localb);
          }
          if (aa.Yh()) {
            ((com.tencent.mm.chatroom.plugin.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.chatroom.plugin.a.class)).handleGroupToolByReceiverAppMsg(this.dBd);
          }
        }
        if (this.ENq != null)
        {
          this.ENq.dkf.dkj = ("msg_" + this.dBd.field_msgSvrId);
          com.tencent.mm.sdk.b.a.IbL.l(this.ENq);
        }
        if (localczj.Hqf.Fwu != null) {
          com.tencent.mm.plugin.report.service.g.yhR.f(10420, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bt.flT()), Integer.valueOf(com.tencent.mm.ao.c.cA(aj.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_THUMBIMAGE), Integer.valueOf(localczj.Hqf.Fwu.getILen()) });
        }
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(31056);
        return;
      }
    }
  }
  
  public final n.b securityVerificationChecked(com.tencent.mm.network.q paramq)
  {
    return n.b.hOp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.ag
 * JD-Core Version:    0.7.0.1
 */