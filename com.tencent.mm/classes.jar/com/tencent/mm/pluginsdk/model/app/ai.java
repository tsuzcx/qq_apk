package com.tencent.mm.pluginsdk.model.app;

import android.util.Base64;
import com.tencent.mm.ae.g.a;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.m.b;
import com.tencent.mm.as.o;
import com.tencent.mm.h.a.n;
import com.tencent.mm.h.a.n.a;
import com.tencent.mm.h.a.um;
import com.tencent.mm.h.a.um.a;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.j.f.a;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.s;
import com.tencent.mm.model.t;
import com.tencent.mm.model.u;
import com.tencent.mm.model.u.b;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.bos;
import com.tencent.mm.protocal.c.bot;
import com.tencent.mm.protocal.c.bvm;
import com.tencent.mm.protocal.c.bvo;
import com.tencent.mm.protocal.c.dn;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bi;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Locale;
import junit.framework.Assert;

public final class ai
  extends com.tencent.mm.ah.m
  implements k
{
  long bIt = 0L;
  bi bWO = null;
  private com.tencent.mm.ah.b dmK;
  com.tencent.mm.ah.f dmL;
  int eGn = 0;
  String eoQ = "";
  private f.a epa = new ai.1(this);
  String fKV;
  private String mSignature;
  private um oqj;
  private n rUQ;
  long startTime = 0L;
  
  public ai(long paramLong, String paramString1, String paramString2)
  {
    this.bIt = paramLong;
    this.fKV = paramString1;
    this.mSignature = paramString2;
    b.a locala = new b.a();
    locala.ecH = new bos();
    locala.ecI = new bot();
    locala.uri = "/cgi-bin/micromsg-bin/sendappmsg";
    locala.ecG = 222;
    locala.ecJ = 107;
    locala.ecK = 1000000107;
    this.dmK = locala.Kt();
    y.i("MicroMsg.NetSceneSendAppMsg", "summersafecdn NetSceneSendAppMsg msgid[%d], sessionid[%s], signature[%s], stack[%s]", new Object[] { Long.valueOf(paramLong), paramString1, bk.aac(paramString2), bk.csb() });
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.ah.f paramf)
  {
    this.dmL = paramf;
    if (this.startTime == 0L) {
      this.startTime = bk.UY();
    }
    au.Hx();
    this.bWO = com.tencent.mm.model.c.Fy().fd(this.bIt);
    if ((this.bWO == null) || (this.bWO.field_msgId != this.bIt)) {
      return -1;
    }
    paramf = g.a.gp(this.bWO.field_content);
    Object localObject1;
    if (paramf == null)
    {
      localObject1 = ap.abP(this.bWO.field_content);
      if (bk.bl(((ap)localObject1).uAC))
      {
        paramf = new g.a();
        paramf.dQx = ((ap)localObject1).bIW;
        paramf.type = 8;
        y.i("MicroMsg.NetSceneSendAppMsg", "create new content. loss appid");
      }
    }
    for (;;)
    {
      localObject1 = "content != null [[" + this.bWO.field_content + "]]";
      if (paramf != null) {}
      for (boolean bool = true;; bool = false)
      {
        Assert.assertTrue((String)localObject1, bool);
        if (paramf != null) {
          break label205;
        }
        this.bWO = null;
        return -1;
        paramf = g.a.gp(((ap)localObject1).uAC);
        break;
      }
      label205:
      if (!bk.bl(this.bWO.field_imgPath)) {}
      String str;
      for (localObject1 = o.OJ().me(this.bWO.field_imgPath);; localObject1 = "")
      {
        if ((paramf.type == 8) || (paramf.type == 9) || (paramf.type == 6))
        {
          y.i("MicroMsg.NetSceneSendAppMsg", "cdntra cdn not support Emoji or voiceremind now type:%d", new Object[] { Integer.valueOf(paramf.type) });
          i = 0;
        }
        Object localObject2;
        while (i != 0)
        {
          y.d("MicroMsg.NetSceneSendAppMsg", "cdntra use cdn return -1 for onGYNetEnd clientId:%s", new Object[] { this.eoQ });
          return 0;
          if (bk.bl((String)localObject1))
          {
            y.i("MicroMsg.NetSceneSendAppMsg", "cdntra cdn not support no thumb msg type:%d", new Object[] { Integer.valueOf(paramf.type) });
            i = 0;
          }
          else
          {
            this.eGn = com.tencent.mm.a.e.bJ((String)localObject1);
            if ((paramf.type != 33) && (paramf.type != 36) && (this.eGn >= 262144))
            {
              y.w("MicroMsg.NetSceneSendAppMsg", "cdntra thumb[%s][%d] Too Big Not Use CDN TRANS", new Object[] { localObject1, Integer.valueOf(this.eGn) });
              i = 0;
            }
            else
            {
              y.i("MicroMsg.NetSceneSendAppMsg", "cdntra content.type:%d  thumbPath:%s,  thumbLength:%d ", new Object[] { Integer.valueOf(paramf.type), localObject1, Integer.valueOf(this.eGn) });
              if (!bk.bl(paramf.bFE))
              {
                y.w("MicroMsg.NetSceneSendAppMsg", "cdntra attach has been upload by cdn msgid:%d", new Object[] { Long.valueOf(this.bIt) });
                i = 0;
              }
              else
              {
                com.tencent.mm.ak.f.Nd();
                if (!com.tencent.mm.ak.b.iq(4))
                {
                  com.tencent.mm.ak.f.Nd();
                  y.w("MicroMsg.NetSceneSendAppMsg", "cdntra not use cdn flag:%b ", new Object[] { Boolean.valueOf(com.tencent.mm.ak.b.iq(4)) });
                  i = 0;
                }
                else
                {
                  this.eoQ = com.tencent.mm.ak.c.a("upappmsg", this.bWO.field_createTime, this.bWO.field_talker, this.bWO.field_msgId);
                  if (bk.bl(this.eoQ))
                  {
                    y.w("MicroMsg.NetSceneSendAppMsg", "cdntra genClientId failed not use cdn msgid:%d", new Object[] { Long.valueOf(this.bWO.field_msgId) });
                    i = 0;
                  }
                  else
                  {
                    localObject2 = new com.tencent.mm.j.f();
                    ((com.tencent.mm.j.f)localObject2).dlP = this.epa;
                    ((com.tencent.mm.j.f)localObject2).field_mediaId = this.eoQ;
                    ((com.tencent.mm.j.f)localObject2).field_fullpath = "";
                    ((com.tencent.mm.j.f)localObject2).field_thumbpath = ((String)localObject1);
                    ((com.tencent.mm.j.f)localObject2).field_fileType = com.tencent.mm.j.a.MediaType_THUMBIMAGE;
                    ((com.tencent.mm.j.f)localObject2).field_talker = this.bWO.field_talker;
                    ((com.tencent.mm.j.f)localObject2).field_priority = com.tencent.mm.j.a.dlk;
                    ((com.tencent.mm.j.f)localObject2).field_needStorage = false;
                    ((com.tencent.mm.j.f)localObject2).field_isStreamMedia = false;
                    ((com.tencent.mm.j.f)localObject2).dlP = this.epa;
                    ((com.tencent.mm.j.f)localObject2).field_force_aeskeycdn = true;
                    ((com.tencent.mm.j.f)localObject2).field_trysafecdn = false;
                    y.i("MicroMsg.NetSceneSendAppMsg", "summersafecdn cdntra checkUseCdn content.type[%d], thumb[%s], useCdnTransClientId[%s], fileType[%d], enable_hitcheck[%b], onlycheckexist[%b], force_aeskeycdn[%b], trysafecdn[%b]", new Object[] { Integer.valueOf(paramf.type), localObject1, this.eoQ, Integer.valueOf(((com.tencent.mm.j.f)localObject2).field_fileType), Boolean.valueOf(((com.tencent.mm.j.f)localObject2).field_enable_hitcheck), Boolean.valueOf(((com.tencent.mm.j.f)localObject2).field_onlycheckexist), Boolean.valueOf(((com.tencent.mm.j.f)localObject2).field_force_aeskeycdn), Boolean.valueOf(((com.tencent.mm.j.f)localObject2).field_trysafecdn) });
                    if (!com.tencent.mm.ak.f.Nd().c((com.tencent.mm.j.f)localObject2))
                    {
                      y.e("MicroMsg.NetSceneSendAppMsg", "cdntra addSendTask failed.");
                      this.eoQ = "";
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
          }
        }
        bos localbos = (bos)this.dmK.ecE.ecN;
        dn localdn = new dn();
        localdn.euK = paramf.appId;
        localdn.swQ = (this.bWO.field_talker + this.bWO.field_msgId + "T" + this.bWO.field_createTime);
        localdn.kVs = g.a.a(paramf, null, null, 0, 0);
        localdn.mPL = ((int)bk.UX());
        localdn.kWm = this.bWO.field_talker;
        localdn.kWn = com.tencent.mm.model.q.Gj();
        localdn.hQR = paramf.type;
        localdn.swP = paramf.sdkVer;
        localdn.swS = paramf.dQy;
        u.b localb;
        bvo localbvo;
        if (com.tencent.mm.ai.f.eW(this.bWO.field_talker))
        {
          localdn.svK = com.tencent.mm.ai.a.e.lv(this.bWO.czr);
          localdn.swU = paramf.bYJ;
          localdn.swV = paramf.bYK;
          localdn.swW = paramf.bYL;
          localb = u.Hc().ii(this.fKV);
          if (localb != null)
          {
            this.oqj = new um();
            this.oqj.ceR.url = paramf.url;
            this.oqj.ceR.ceS = localb.getString("prePublishId", "");
            this.oqj.ceR.ceU = localb.getString("preUsername", "");
            this.oqj.ceR.ceV = localb.getString("preChatName", "");
            this.oqj.ceR.ceW = localb.getInt("preMsgIndex", 0);
            this.oqj.ceR.cfa = localb.getInt("sendAppMsgScene", 0);
            this.oqj.ceR.cfb = localb.getInt("getA8KeyScene", 0);
            this.oqj.ceR.cfc = localb.getString("referUrl", null);
            this.oqj.ceR.cfd = localb.getString("adExtStr", null);
            this.oqj.ceR.ceX = this.bWO.field_talker;
            this.oqj.ceR.cfe = paramf.title;
            au.Hx();
            localObject2 = com.tencent.mm.model.c.Fw().abl(this.bWO.field_talker);
            if (localObject2 != null) {
              this.oqj.ceR.ceY = ((ad)localObject2).Bp();
            }
            this.oqj.ceR.ceZ = com.tencent.mm.model.m.gM(this.bWO.field_talker);
            str = "";
            localObject2 = str;
            if (paramf.bYN != null)
            {
              localbvo = new bvo();
              localObject2 = Base64.decode(paramf.bYN, 0);
            }
          }
        }
        try
        {
          localbvo.aH((byte[])localObject2);
          localObject2 = str;
          if (localbvo.tMo != null) {
            localObject2 = localbvo.tMo.kOK;
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
        localbos.tHb = String.format(Locale.US, "prePublishId=%s&preUserName=%s&preChatName=%s&preChatType=%d&getA8KeyScene=%d&sourceAppId=%s", new Object[] { this.oqj.ceR.ceS, this.oqj.ceR.ceU, this.oqj.ceR.ceV, Integer.valueOf(t.R(this.oqj.ceR.ceU, this.oqj.ceR.ceV)), Integer.valueOf(this.oqj.ceR.cfb), localObject2 });
        if ((localb != null) && (paramf.type == 33))
        {
          this.rUQ = new n();
          i = localb.getInt("fromScene", 1);
          this.rUQ.bFt.scene = i;
          j = localb.getInt("appservicetype", 0);
          this.rUQ.bFt.bFB = j;
          localObject2 = localb.getString("preChatName", "");
          if (2 == i)
          {
            str = localb.getString("preUsername", "");
            this.rUQ.bFt.bFv = ((String)localObject2 + ":" + str);
            label1640:
            localObject2 = this.bWO.field_talker;
            bool = localb.getBoolean("moreRetrAction", false);
            if (!((String)localObject2).endsWith("@chatroom")) {
              break label2033;
            }
            localObject2 = this.rUQ.bFt;
            if (!bool) {
              break label2028;
            }
            i = 5;
            label1687:
            ((n.a)localObject2).action = i;
            this.rUQ.bFt.bFu = (paramf.dTf + 1);
            this.rUQ.bFt.bFw = paramf.dSX;
            this.rUQ.bFt.bFn = paramf.dSY;
            this.rUQ.bFt.appId = paramf.dSZ;
            this.rUQ.bFt.bFy = bk.UX();
            this.rUQ.bFt.bFz = 1;
          }
        }
        else
        {
          y.d("MicroMsg.NetSceneSendAppMsg", "SnsPostOperationFields: ShareUrlOriginal=%s, ShareUrlOpen=%s, JsAppId=%s", new Object[] { paramf.bYJ, paramf.bYK, paramf.bYL });
          if (!bk.bl((String)localObject1))
          {
            localObject2 = com.tencent.mm.a.e.c((String)localObject1, 0, -1);
            if (!bk.bE((byte[])localObject2)) {
              localdn.swR = new bmk().bs((byte[])localObject2);
            }
          }
          if (localdn.swR == null) {
            break label2063;
          }
        }
        label2063:
        for (int i = localdn.swR.tFK;; i = -1)
        {
          y.d("MicroMsg.NetSceneSendAppMsg", "doScene thumbFile:[%s] thumbdata:%d", new Object[] { localObject1, Integer.valueOf(i) });
          localbos.tGZ = localdn;
          if ((paramf.dQz != 0) || (paramf.dQv > 26214400)) {
            localbos.sxP = com.tencent.mm.j.a.dlm;
          }
          localbos.jnU = paramf.filemd5;
          localbos.ffk = this.mSignature;
          y.i("MicroMsg.NetSceneSendAppMsg", "summersafecdn file md5[%s], signature[%s], type[%d], fromScene[%s]", new Object[] { localbos.jnU, bk.aac(localbos.ffk), Integer.valueOf(localbos.sxP), localbos.tHb });
          return a(parame, this.dmK, this);
          localdn.svK = bf.HR();
          break;
          this.rUQ.bFt.bFv = ((String)localObject2);
          break label1640;
          label2028:
          i = 2;
          break label1687;
          label2033:
          localObject2 = this.rUQ.bFt;
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
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneSendAppMsg", "summersafecdn cdntra onGYNetEnd [%d,%d,%s] msgId:%d, oldContent[%s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Long.valueOf(this.bIt), this.bWO.field_content });
    if ((paramInt2 == 3) && (paramInt3 == -1) && (!bk.bl(this.eoQ)))
    {
      y.w("MicroMsg.NetSceneSendAppMsg", "cdntra using cdn trans,  wait cdn service callback! clientid:%s", new Object[] { this.eoQ });
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.bWO.setStatus(5);
      com.tencent.mm.plugin.report.f.nEG.a(111L, 34L, 1L, true);
      au.Hx();
      com.tencent.mm.model.c.Fy().a(this.bWO.field_msgId, this.bWO);
      y.e("MicroMsg.NetSceneSendAppMsg", "send app msg failed, err=" + paramInt2 + "," + paramInt3 + ", msgId " + this.bWO.field_msgId);
      if (paramInt2 == 4) {
        com.tencent.mm.plugin.report.service.h.nFQ.f(10420, new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bk.UY()), Integer.valueOf(com.tencent.mm.ak.c.bx(ae.getContext())), Integer.valueOf(com.tencent.mm.j.a.MediaType_THUMBIMAGE), Integer.valueOf(0) });
      }
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    paramArrayOfByte = (bot)((com.tencent.mm.ah.b)paramq).ecF.ecN;
    bos localbos = (bos)((com.tencent.mm.ah.b)paramq).ecE.ecN;
    this.bWO.setStatus(2);
    this.bWO.bf(paramArrayOfByte.ndp);
    au.Hx();
    com.tencent.mm.model.c.Fy().a(this.bWO.field_msgId, this.bWO);
    com.tencent.mm.modelstat.b.eBD.a(this.bWO, com.tencent.mm.ae.h.g(this.bWO));
    if ((this.oqj != null) && (!bk.bl(this.oqj.ceR.url)))
    {
      this.oqj.ceR.ceT = ("msg_" + Long.toString(paramArrayOfByte.ndp));
      com.tencent.mm.sdk.b.a.udP.m(this.oqj);
    }
    paramArrayOfByte = g.a.gp(this.bWO.field_content);
    if ((paramArrayOfByte != null) && ("wx4310bbd51be7d979".equals(paramArrayOfByte.appId))) {
      if ((bk.bl(this.bWO.field_talker)) || (!s.fn(this.bWO.field_talker))) {
        break label759;
      }
    }
    label759:
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
          y.printErrStackTrace("MicroMsg.NetSceneSendAppMsg", paramArrayOfByte, "", new Object[0]);
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
      y.i("MicroMsg.NetSceneSendAppMsg", "androidSystemShareFixed(13717) %s", new Object[] { paramq });
      com.tencent.mm.plugin.report.service.h.nFQ.aC(13717, paramq);
      if (this.rUQ != null)
      {
        this.rUQ.bFt.bFx = ("msg_" + this.bWO.field_msgSvrId);
        com.tencent.mm.sdk.b.a.udP.m(this.rUQ);
      }
      if (localbos.tGZ.swR != null) {
        com.tencent.mm.plugin.report.service.h.nFQ.f(10420, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bk.UY()), Integer.valueOf(com.tencent.mm.ak.c.bx(ae.getContext())), Integer.valueOf(com.tencent.mm.j.a.MediaType_THUMBIMAGE), Integer.valueOf(localbos.tGZ.swR.tFK) });
      }
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.ai
 * JD-Core Version:    0.7.0.1
 */