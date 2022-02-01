package com.tencent.mm.plugin.sns.model;

import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.f.a.acf;
import com.tencent.mm.f.a.acf.a;
import com.tencent.mm.f.a.acg;
import com.tencent.mm.f.a.acg.a;
import com.tencent.mm.f.a.rx;
import com.tencent.mm.f.a.ry;
import com.tencent.mm.f.a.ry.a;
import com.tencent.mm.f.a.rz;
import com.tencent.mm.f.a.rz.a;
import com.tencent.mm.f.a.xd;
import com.tencent.mm.f.a.xe;
import com.tencent.mm.f.a.xf;
import com.tencent.mm.f.b.a.ev;
import com.tencent.mm.f.b.a.jy;
import com.tencent.mm.f.b.a.mt;
import com.tencent.mm.f.b.a.mw;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.model.cm;
import com.tencent.mm.modelsns.l;
import com.tencent.mm.modelsns.o;
import com.tencent.mm.modelvideo.r.a;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.sns.k.j;
import com.tencent.mm.plugin.sns.k.k;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.y;
import com.tencent.mm.pluginsdk.ui.tools.p;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adw;
import com.tencent.mm.protocal.protobuf.ba;
import com.tencent.mm.protocal.protobuf.bc;
import com.tencent.mm.protocal.protobuf.csn;
import com.tencent.mm.protocal.protobuf.cvr;
import com.tencent.mm.protocal.protobuf.cvt;
import com.tencent.mm.protocal.protobuf.cvu;
import com.tencent.mm.protocal.protobuf.cvw;
import com.tencent.mm.protocal.protobuf.dgj;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.ejk;
import com.tencent.mm.protocal.protobuf.ejw;
import com.tencent.mm.protocal.protobuf.ekm;
import com.tencent.mm.protocal.protobuf.ekn;
import com.tencent.mm.protocal.protobuf.eko;
import com.tencent.mm.protocal.protobuf.ekr;
import com.tencent.mm.protocal.protobuf.eks;
import com.tencent.mm.protocal.protobuf.emn;
import com.tencent.mm.protocal.protobuf.emp;
import com.tencent.mm.protocal.protobuf.eoq;
import com.tencent.mm.protocal.protobuf.evb;
import com.tencent.mm.protocal.protobuf.ex;
import com.tencent.mm.protocal.protobuf.fgr;
import com.tencent.mm.protocal.protobuf.tv;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.vfs.u;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public final class t
  extends com.tencent.mm.an.q
  implements m
{
  long JIs;
  private acf JVA;
  private acg JVB;
  private int JVC;
  private HashMap<Integer, Integer> JVD;
  private String JVE;
  private HashMap<String, cvt> JVF;
  private HashMap<String, Integer> JVG;
  private HashMap<Integer, Integer> JVH;
  private String JVI;
  private TimeLineObject JVx;
  private TimeLineObject JVy;
  private int JVz;
  public com.tencent.mm.an.i callback;
  int fWh;
  private int jXZ;
  private IListener jYc;
  private IListener jYd;
  boolean jis;
  private com.tencent.mm.an.d rr;
  
  public t(String paramString1, int paramInt1, int paramInt2, List<String> paramList, TimeLineObject paramTimeLineObject, int paramInt3, String paramString2, int paramInt4, LinkedList<Long> paramLinkedList, int paramInt5, cvu paramcvu, boolean paramBoolean, LinkedList<eaf> paramLinkedList1, ekm paramekm, com.tencent.mm.cd.b paramb, String paramString3, int paramInt6, String paramString4)
  {
    AppMethodBeat.i(95612);
    this.JIs = 0L;
    this.jis = false;
    this.JVz = 0;
    this.JVD = new HashMap();
    this.jXZ = 0;
    this.JVE = "";
    this.JVF = new HashMap();
    this.JVG = new HashMap();
    this.JVH = new HashMap();
    this.JVI = "";
    this.jYc = new IListener()
    {
      private boolean a(rz paramAnonymousrz)
      {
        AppMethodBeat.i(95608);
        if (!t.a(t.this).containsKey(paramAnonymousrz.fRl.filePath))
        {
          Log.e("MicroMsg.NetSceneSnsPost", "recog succ, but not found %s", new Object[] { paramAnonymousrz.fRl.filePath });
          AppMethodBeat.o(95608);
          return false;
        }
        i = ((Integer)t.a(t.this).remove(paramAnonymousrz.fRl.filePath)).intValue();
        localObject5 = "";
        localObject2 = "";
        localObject1 = localObject2;
        try
        {
          localObject6 = p.RxG;
          localObject1 = localObject2;
          localObject2 = p.d(paramAnonymousrz);
          localObject1 = localObject2;
          localObject6 = URLEncoder.encode((String)localObject2, "UTF-8");
          localObject1 = localObject6;
          localObject5 = localObject2;
          localObject2 = localObject1;
          localObject1 = localObject5;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException1)
        {
          try
          {
            StringBuilder localStringBuilder;
            String str1;
            String str2;
            p localp;
            localObject2 = (String)localObject6 + "," + URLEncoder.encode(t.f(t.this), "UTF-8");
            Log.i("MicroMsg.NetSceneSnsPost", "androidSystemShareFixed(13717) fileToIndex:%d,  %s", new Object[] { Integer.valueOf(i), localObject2 });
            com.tencent.mm.plugin.report.service.h.IzE.kvStat(13717, (String)localObject2);
            t.g(t.this);
            localObject2 = t.this;
            localObject6 = paramAnonymousrz.fRl.filePath;
            if (localObject5 == null) {
              break label478;
            }
            paramAnonymousrz = ((cvt)localObject5).TDM;
            if (t.a(t.this, i) != 1) {
              break label484;
            }
            i = 3;
            t.a((t)localObject2, (String)localObject6, localObject1, paramAnonymousrz, i);
            AppMethodBeat.o(95608);
            return false;
            localUnsupportedEncodingException1 = localUnsupportedEncodingException1;
            Log.printErrStackTrace("MicroMsg.NetSceneSnsPost", localUnsupportedEncodingException1, "", new Object[0]);
            Object localObject3 = localObject5;
          }
          catch (UnsupportedEncodingException localUnsupportedEncodingException2)
          {
            for (;;)
            {
              Object localObject6;
              Log.e("MicroMsg.NetSceneSnsPost", "", new Object[] { localUnsupportedEncodingException2.getMessage() });
              Object localObject4 = localObject6;
              continue;
              paramAnonymousrz = "";
              continue;
              i = 2;
            }
          }
        }
        localObject5 = null;
        if (t.b(t.this) != 0)
        {
          localObject5 = (cvt)t.c(t.this).get(paramAnonymousrz.fRl.filePath);
          localObject6 = t.this;
          localStringBuilder = new StringBuilder().append(t.d(t.this));
          str1 = ((cvt)localObject5).TDS;
          str2 = ((cvt)localObject5).Url;
          localp = p.RxG;
          t.a((t)localObject6, String.format("position=%d&qrUrl=%s&md5=%s&imgUrl=%s&codeType=%d|", new Object[] { Integer.valueOf(i), localObject2, str1, str2, Integer.valueOf(p.e(paramAnonymousrz)) }));
        }
        if (t.e(t.this) == 12)
        {
          localObject6 = "2,3,,".concat(String.valueOf(localObject2));
          localObject2 = localObject6;
          if (i != 0) {}
        }
      }
    };
    this.jYd = new IListener()
    {
      private boolean a(ry paramAnonymousry)
      {
        int i = 2;
        AppMethodBeat.i(95610);
        if (!t.a(t.this).containsKey(paramAnonymousry.fRk.filePath))
        {
          Log.e("MicroMsg.NetSceneSnsPost", "recog succ, but not found %s", new Object[] { paramAnonymousry.fRk.filePath });
          AppMethodBeat.o(95610);
          return false;
        }
        Object localObject1 = (Integer)t.a(t.this).remove(paramAnonymousry.fRk.filePath);
        if (localObject1 == null)
        {
          AppMethodBeat.o(95610);
          return false;
        }
        int j = ((Integer)localObject1).intValue();
        Object localObject3;
        if (t.e(t.this) == 12)
        {
          localObject3 = "2,3,,";
          localObject1 = localObject3;
          if (j != 0) {}
        }
        try
        {
          localObject1 = "2,3,," + "," + URLEncoder.encode(t.f(t.this), "UTF-8");
          Log.i("MicroMsg.NetSceneSnsPost", "androidSystemShareFixed(13717) fileToIndex:%d,  %s", new Object[] { Integer.valueOf(j), localObject1 });
          com.tencent.mm.plugin.report.service.h.IzE.kvStat(13717, (String)localObject1);
          t.g(t.this);
          if (t.b(t.this) != 0)
          {
            localObject1 = (cvt)t.c(t.this).get(paramAnonymousry.fRk.filePath);
            localObject3 = t.this;
            String str = paramAnonymousry.fRk.filePath;
            if (localObject1 != null)
            {
              paramAnonymousry = ((cvt)localObject1).TDM;
              if (t.a(t.this, j) == 1) {
                i = 3;
              }
              t.a((t)localObject3, str, null, paramAnonymousry, i);
              AppMethodBeat.o(95610);
              return false;
            }
          }
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          for (;;)
          {
            Log.e("MicroMsg.NetSceneSnsPost", "", new Object[] { localUnsupportedEncodingException.getMessage() });
            Object localObject2 = localObject3;
            continue;
            paramAnonymousry = "";
            continue;
            localObject2 = null;
          }
        }
      }
    };
    this.JVx = paramTimeLineObject;
    this.fWh = paramInt3;
    this.JVC = paramInt5;
    localObject1 = new d.a();
    ((d.a)localObject1).lBU = new ekn();
    ((d.a)localObject1).lBV = new eko();
    ((d.a)localObject1).uri = "/cgi-bin/micromsg-bin/mmsnspost";
    ((d.a)localObject1).funcId = 209;
    ((d.a)localObject1).lBW = 97;
    ((d.a)localObject1).respCmdId = 1000000097;
    this.rr = ((d.a)localObject1).bgN();
    ekn localekn = (ekn)d.b.b(this.rr.lBR);
    if ((paramTimeLineObject.actionInfo != null) && (paramTimeLineObject.actionInfo.RFO != null) && (!TextUtils.isEmpty(paramTimeLineObject.actionInfo.RFO.RFJ)))
    {
      localObject1 = new tv();
      ((tv)localObject1).Sdq = paramTimeLineObject.actionInfo.RFO.RFJ;
      localekn.Umr = ((tv)localObject1);
    }
    localObject1 = ad.beh().Ro(paramcvu.sessionId);
    Object localObject2;
    if (localObject1 != null)
    {
      this.JVA = new acf();
      this.JVA.gce.gcf = ((ad.b)localObject1).getString("prePublishId", "");
      this.JVA.gce.url = ((ad.b)localObject1).getString("url", "");
      this.JVA.gce.gch = ((ad.b)localObject1).getString("preUsername", "");
      this.JVA.gce.gci = ((ad.b)localObject1).getString("preChatName", "");
      this.JVA.gce.gcj = ((ad.b)localObject1).getInt("preMsgIndex", 0);
      this.JVA.gce.gcn = ((ad.b)localObject1).getInt("sendAppMsgScene", 0);
      this.JVA.gce.gco = ((ad.b)localObject1).getInt("getA8KeyScene", 0);
      this.JVA.gce.gcp = ((ad.b)localObject1).getString("referUrl", null);
      this.JVA.gce.gcq = ((ad.b)localObject1).getString("adExtStr", null);
      this.JVA.gce.gcr = paramString3;
      if (((ad.b)localObject1).containsKey("_tmpl_webview_transfer_scene"))
      {
        this.JVB = new acg();
        this.JVB.gcu.gcv = ((ad.b)localObject1).getInt("_tmpl_webview_transfer_scene", -1);
      }
      localObject1 = "";
      paramString3 = (String)localObject1;
      if (paramTimeLineObject.statExtStr != null)
      {
        localObject2 = new emp();
        paramString3 = Base64.decode(paramTimeLineObject.statExtStr, 0);
      }
    }
    try
    {
      ((emp)localObject2).parseFrom(paramString3);
      paramString3 = (String)localObject1;
      if (((emp)localObject2).Upg != null) {
        paramString3 = ((emp)localObject2).Upg.CIO;
      }
    }
    catch (Exception paramString3)
    {
      for (;;)
      {
        int i;
        int j;
        paramString3 = (String)localObject1;
      }
    }
    localObject1 = paramString3;
    if (Util.isNullOrNil(paramString3))
    {
      localObject1 = paramString3;
      if (paramTimeLineObject.AppInfo != null) {
        localObject1 = paramTimeLineObject.AppInfo.Id;
      }
    }
    localekn.Umq = String.format(Locale.US, "prePublishId=%s&preUserName=%s&preChatName=%s&preChatType=%d&getA8KeyScene=%d&sourceAppId=%s", new Object[] { this.JVA.gce.gcf, this.JVA.gce.gch, this.JVA.gce.gci, Integer.valueOf(com.tencent.mm.model.ac.aN(this.JVA.gce.gch, this.JVA.gce.gci)), Integer.valueOf(this.JVA.gce.gco), localObject1 });
    paramString3 = new eae();
    paramString3.dc(paramString1.getBytes());
    i = paramString1.length();
    j = paramString3.Ufv;
    if (paramb == null) {}
    for (paramInt3 = 0;; paramInt3 = paramb.UH.length)
    {
      Log.i("MicroMsg.NetSceneSnsPost", "len:%d   skb:%d ctx.len:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramInt3) });
      localekn.ObjectDesc = paramString3;
      localekn.Uml = paramInt1;
      localekn.TEb = paramInt2;
      localekn.lps = paramString2;
      this.JVz = paramInt1;
      if (com.tencent.mm.platformtools.ac.mFm)
      {
        localekn.ObjectDesc = new eae();
        Log.e("MicroMsg.NetSceneSnsPost", "post error setObjectDesc is null!");
      }
      paramString3 = new LinkedList();
      if ((paramList == null) || (paramList.size() <= 0)) {
        break label1012;
      }
      paramList = paramList.iterator();
      for (paramString1 = ""; paramList.hasNext(); paramString1 = paramString1 + "; + " + (String)localObject1)
      {
        localObject1 = (String)paramList.next();
        localObject2 = new eaf();
        ((eaf)localObject2).btQ((String)localObject1);
        paramString3.add(localObject2);
      }
    }
    Log.d("MicroMsg.NetSceneSnsPost", "post with list : ".concat(String.valueOf(paramString1)));
    label1012:
    localekn.WithUserList = paramString3;
    localekn.WithUserListCount = paramString3.size();
    localekn.Umm = paramInt4;
    paramString1 = localekn.Umq;
    if (paramcvu.TEs != null)
    {
      paramInt1 = paramcvu.TEs.Ulz;
      Log.i("MicroMsg.NetSceneSnsPost", "setObjectSource: %d, clientid:%s fromScene:%s, score:%d, sdkTokenValid:%s, sdkPkgName:%s", new Object[] { Integer.valueOf(paramInt5), paramString2, paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt6), paramString4 });
      if ((paramLinkedList1 != null) && (paramLinkedList1.size() > 0))
      {
        if (!paramBoolean) {
          break label1299;
        }
        localekn.BlackList = paramLinkedList1;
        localekn.BlackListCount = paramLinkedList1.size();
      }
    }
    for (;;)
    {
      Log.d("MicroMsg.NetSceneSnsPost", "setObjectSource ".concat(String.valueOf(paramInt5)));
      localekn.Umn = paramInt5;
      paramString1 = new evb();
      if (!Util.isNullOrNil(paramcvu.token))
      {
        paramString1.UwO = paramcvu.token;
        paramString1.UwP = paramcvu.TEk;
        localekn.TUs = paramString1;
      }
      if ((paramLinkedList == null) || (paramLinkedList.isEmpty())) {
        break label1363;
      }
      localekn.GroupCount = paramLinkedList.size();
      paramString1 = paramLinkedList.iterator();
      while (paramString1.hasNext())
      {
        paramList = (Long)paramString1.next();
        paramString2 = new ejw();
        paramString2.UlP = paramList.longValue();
        localekn.TEh.add(paramString2);
      }
      paramInt1 = 0;
      break;
      label1299:
      localekn.GroupUser = paramLinkedList1;
      localekn.GroupUserCount = paramLinkedList1.size();
    }
    Log.d("MicroMsg.NetSceneSnsPost", "tagid " + paramLinkedList.size() + " " + localekn.TEh.toString());
    label1363:
    localekn.TEm = paramekm;
    if (!Util.isNullOrNil(paramcvu.TEo)) {
      localekn.SnsRedEnvelops = new ekr();
    }
    if (paramekm != null) {
      Log.d("MicroMsg.NetSceneSnsPost", "SnsPostOperationFields: ShareUrlOriginal=%s, ShareUrlOpen=%s, JsAppId=%s", new Object[] { paramekm.RJT, paramekm.RJU, paramekm.RJV });
    }
    if (paramb != null) {
      localekn.Ump = new eae().g(paramb);
    }
    localekn.Umu = paramcvu.TEs;
    paramString1 = aj.fOI().agI(this.fWh);
    if ((paramString1 != null) && ((paramString1.getTypeFlag() == 1) || (paramString1.getTypeFlag() == 15)) && (paramTimeLineObject.ContentObj != null) && (paramTimeLineObject.ContentObj.Sqr != null) && (paramTimeLineObject.ContentObj.Sqr.size() > 0) && (paramcvu.TEc != null) && (paramcvu.TEc.size() == paramTimeLineObject.ContentObj.Sqr.size()))
    {
      paramString1 = aj.getAccSnsPath();
      paramList = paramTimeLineObject.ContentObj.Sqr.iterator();
      paramInt1 = 0;
    }
    for (;;)
    {
      if (paramList.hasNext())
      {
        paramLinkedList = (cvt)paramList.next();
        if ((paramLinkedList.rWu == 2) || (paramLinkedList.rWu == 6))
        {
          paramTimeLineObject = new cvr();
          if (paramLinkedList.rWu != 2) {
            break label1889;
          }
          paramInt2 = 2;
          label1642:
          paramTimeLineObject.Crm = paramInt2;
          if (paramLinkedList.rWu == 6)
          {
            paramString2 = aq.kD(paramString1, paramLinkedList.Id);
            paramLinkedList = com.tencent.mm.plugin.sns.data.t.o(paramLinkedList);
            paramString2 = com.tencent.mm.plugin.sight.base.f.aYg(paramString2 + paramLinkedList);
            if (paramString2 != null) {
              paramTimeLineObject.TDC = ((int)Math.round(paramString2.videoDuration / 1000.0D));
            }
          }
          paramString2 = (csn)paramcvu.TEc.get(paramInt1);
          paramString2 = aj.fOx().Re(paramString2.TAo);
        }
      }
      try
      {
        paramLinkedList = (cvw)new cvw().parseFrom(paramString2.KAa);
        paramTimeLineObject.Cqs = paramLinkedList.TEE;
        this.JVD.put(Integer.valueOf(paramString2.localid), Integer.valueOf(paramLinkedList.TEE));
        label1807:
        paramTimeLineObject.SessionId = paramcvu.sessionId;
        Log.i("MicroMsg.NetSceneSnsPost", "post add mediaInfo, Source: %s, videoPlayLength: %s, MediaType: %s, SessionId: %s", new Object[] { Integer.valueOf(paramTimeLineObject.Cqs), Integer.valueOf(paramTimeLineObject.TDC), Integer.valueOf(paramTimeLineObject.Crm), paramTimeLineObject.SessionId });
        localekn.Umt.add(paramTimeLineObject);
        paramInt1 += 1;
        continue;
        label1889:
        paramInt2 = 1;
        break label1642;
        localekn.Ums = localekn.Umt.size();
        Log.i("MicroMsg.NetSceneSnsPost", "post mediaCount: %s", new Object[] { Integer.valueOf(localekn.Ums) });
        if (com.tencent.mm.plugin.normsg.a.d.GxJ.aTk("ie_sns_upload")) {
          com.tencent.mm.plugin.normsg.a.d.GxJ.aTj("ie_sns_upload");
        }
        for (;;)
        {
          try
          {
            paramString1 = new fgr();
            paramString1.UGM = new eae().dc(com.tencent.mm.plugin.normsg.a.d.GxJ.aTl("ie_sns_upload"));
            if (paramString1.UGM == null) {
              continue;
            }
            paramInt1 = paramString1.UGM.Ufv;
            Log.d("MicroMsg.NetSceneSnsPost", "[debug] wcstf set on snspost, len: %s", new Object[] { Integer.valueOf(paramInt1) });
            paramString1.UGN = new eae().dc(com.tencent.mm.plugin.normsg.a.d.GxJ.aTo("ce_sns_upload"));
            if (paramString1.UGN == null) {
              continue;
            }
            paramInt1 = paramString1.UGN.Ufv;
            Log.d("MicroMsg.NetSceneSnsPost", "[debug] wcste set on snspost, len: %s", new Object[] { Integer.valueOf(paramInt1) });
            paramString1.UGO = new eae().dc(com.tencent.mm.plugin.normsg.a.d.GxJ.fjn());
            if (paramString1.UGO == null) {
              continue;
            }
            paramInt1 = paramString1.UGO.Ufv;
            Log.d("MicroMsg.NetSceneSnsPost", "[debug] ccData set on snspost, len: %s", new Object[] { Integer.valueOf(paramInt1) });
            localekn.RMN = new eae().dc(paramString1.toByteArray());
          }
          catch (Throwable paramString1)
          {
            continue;
          }
          if ((paramcvu == null) || (paramcvu.TEn == null)) {
            continue;
          }
          paramString1 = paramcvu.TEn.iterator();
          paramInt1 = 0;
          if (!paramString1.hasNext()) {
            continue;
          }
          paramList = (eks)paramString1.next();
          this.JVH.put(Integer.valueOf(paramInt1), Integer.valueOf(paramList.UmG));
          paramInt1 += 1;
          continue;
          paramInt1 = -1;
          continue;
          paramInt1 = -1;
          continue;
          paramInt1 = -1;
        }
        paramString1 = new dgj();
        paramString1.RJW = paramInt6;
        paramString1.CqB = paramString4;
        localekn.Umv = paramString1;
        AppMethodBeat.o(95612);
        return;
      }
      catch (Exception paramString2)
      {
        break label1807;
      }
    }
  }
  
  private static boolean a(TimeLineObject paramTimeLineObject1, TimeLineObject paramTimeLineObject2)
  {
    AppMethodBeat.i(95616);
    if ((paramTimeLineObject1 == null) || (paramTimeLineObject2 == null) || (paramTimeLineObject1.ContentObj == null) || (paramTimeLineObject2.ContentObj == null))
    {
      AppMethodBeat.o(95616);
      return false;
    }
    String str1 = aj.getAccSnsPath();
    int i = 0;
    while ((i < paramTimeLineObject1.ContentObj.Sqr.size()) && (i < paramTimeLineObject2.ContentObj.Sqr.size()))
    {
      Object localObject2 = (cvt)paramTimeLineObject1.ContentObj.Sqr.get(i);
      Object localObject1 = (cvt)paramTimeLineObject2.ContentObj.Sqr.get(i);
      String str2 = com.tencent.mm.plugin.sns.data.t.l((cvt)localObject2);
      String str3 = com.tencent.mm.plugin.sns.data.t.m((cvt)localObject2);
      String str4 = com.tencent.mm.plugin.sns.data.t.n((cvt)localObject2);
      String str5 = com.tencent.mm.plugin.sns.data.t.o((cvt)localObject2);
      String str6 = com.tencent.mm.plugin.sns.data.t.k((cvt)localObject1);
      String str7 = com.tencent.mm.plugin.sns.data.t.d((cvt)localObject1);
      String str8 = com.tencent.mm.plugin.sns.data.t.e((cvt)localObject1);
      String str9 = com.tencent.mm.plugin.sns.data.t.i((cvt)localObject1);
      Log.d("MicroMsg.NetSceneSnsPost", "updateMediaFileName " + str2 + "  - " + str6);
      localObject2 = aq.kD(str1, ((cvt)localObject2).Id);
      localObject1 = aq.kD(str1, ((cvt)localObject1).Id);
      u.bBD((String)localObject1);
      u.oo((String)localObject2 + str2, (String)localObject1 + str6);
      u.oo((String)localObject2 + str3, (String)localObject1 + str7);
      u.oo((String)localObject2 + str4, (String)localObject1 + str8);
      if (u.agG((String)localObject2 + str5))
      {
        Log.i("MicroMsg.NetSceneSnsPost", "post done copy file %s", new Object[] { (String)localObject1 + str9 });
        u.oo((String)localObject2 + str5, (String)localObject1 + str9);
      }
      i += 1;
    }
    AppMethodBeat.o(95616);
    return true;
  }
  
  private void aZX(String paramString)
  {
    AppMethodBeat.i(95615);
    this.JVI = paramString;
    paramString = com.tencent.mm.model.c.d.bgB().Mu("100132");
    if (paramString.isValid()) {
      this.jXZ = Util.getInt((String)paramString.hvz().get("needUploadData"), 1);
    }
    if ((this.JVC != 12) && (this.jXZ == 0))
    {
      AppMethodBeat.o(95615);
      return;
    }
    if ((this.JVy != null) && (this.JVy.ContentObj != null) && (this.JVy.ContentObj.Sqr != null) && (this.JVy.ContentObj.Sqr.size() > 0))
    {
      paramString = this.JVy.ContentObj.Sqr;
      EventCenter.instance.addListener(this.jYc);
      EventCenter.instance.addListener(this.jYd);
      paramString = paramString.iterator();
      int i = 0;
      while (paramString.hasNext())
      {
        Object localObject = (cvt)paramString.next();
        if (((cvt)localObject).rWu == 2)
        {
          String str = g.D((cvt)localObject);
          if (!Util.isNullOrNil(str))
          {
            this.JVG.put(str, Integer.valueOf(i));
            this.JVF.put(str, localObject);
            localObject = new rx();
            ((rx)localObject).fRg.fwK = System.nanoTime();
            ((rx)localObject).fRg.filePath = str;
            EventCenter.instance.publish((IEvent)localObject);
            i += 1;
          }
        }
      }
    }
    AppMethodBeat.o(95615);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.an.i parami)
  {
    AppMethodBeat.i(95613);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(95613);
    return i;
  }
  
  public final int getType()
  {
    return 209;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(95614);
    Log.i("MicroMsg.NetSceneSnsPost", "post netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    eko localeko = (eko)d.c.b(((com.tencent.mm.an.d)params).lBS);
    if (paramInt2 == 4) {
      params = aj.fOI().agI(this.fWh);
    }
    try
    {
      paramArrayOfByte = (cvu)new cvu().parseFrom(params.field_postBuf);
      paramArrayOfByte.TEj = paramInt3;
      paramArrayOfByte.TEq = localeko.TEq;
      paramArrayOfByte.TEr = false;
      params.setPostBuf(paramArrayOfByte.toByteArray());
      if (params != null)
      {
        params.setItemDie();
        aj.fOI().d(this.fWh, params);
        aj.fOH().afN(this.fWh);
        Log.d("MicroMsg.NetSceneSnsPost", "onErrorServer, publish SnsPostFailEvent, snsInfoLocalId: " + params.getLocalid());
        params = new xd();
        params.fWd.fWe = this.fWh;
        EventCenter.instance.publish(params);
      }
      if ((this.JVx != null) && (this.JVx.ContentObj != null) && (this.JVx.ContentObj.Sqq == 21))
      {
        com.tencent.mm.plugin.sns.lucky.a.b.rE(8);
        switch (paramInt3)
        {
        default: 
          com.tencent.mm.plugin.sns.lucky.a.b.rE(20);
        }
      }
      for (;;)
      {
        if (com.tencent.mm.plugin.sns.k.g.Kia.KiN == this.fWh)
        {
          com.tencent.mm.plugin.sns.k.g.Kia.KiO.goQ = 1L;
          com.tencent.mm.plugin.sns.k.g.Kia.fQy();
          com.tencent.mm.plugin.sns.k.g.Kia.KiN = 0;
        }
        if (com.tencent.mm.plugin.sns.k.g.Kia.KiP == this.fWh)
        {
          com.tencent.mm.plugin.sns.k.g.Kia.KiQ.goQ = 1L;
          com.tencent.mm.plugin.sns.k.g.Kia.fQz();
          com.tencent.mm.plugin.sns.k.g.Kia.KiP = 0;
        }
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(95614);
        return;
        com.tencent.mm.plugin.sns.lucky.a.b.rE(17);
        continue;
        com.tencent.mm.plugin.sns.lucky.a.b.rE(19);
        continue;
        com.tencent.mm.plugin.sns.lucky.a.b.rE(18);
      }
      if (paramInt3 != 0)
      {
        aj.fOH().afN(this.fWh);
        if ((this.JVx != null) && (this.JVx.ContentObj != null) && (this.JVx.ContentObj.Sqq == 21))
        {
          com.tencent.mm.plugin.sns.lucky.a.b.rE(8);
          com.tencent.mm.plugin.sns.lucky.a.b.rE(16);
        }
        if (com.tencent.mm.plugin.sns.k.g.Kia.KiN == this.fWh)
        {
          com.tencent.mm.plugin.sns.k.g.Kia.KiO.goQ = 1L;
          com.tencent.mm.plugin.sns.k.g.Kia.fQy();
          com.tencent.mm.plugin.sns.k.g.Kia.KiN = 0;
        }
        if (com.tencent.mm.plugin.sns.k.g.Kia.KiP == this.fWh)
        {
          com.tencent.mm.plugin.sns.k.g.Kia.KiQ.goQ = 1L;
          com.tencent.mm.plugin.sns.k.g.Kia.fQz();
          com.tencent.mm.plugin.sns.k.g.Kia.KiP = 0;
        }
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(95614);
        return;
      }
      if ((localeko.Ulb == null) || (localeko.Ulb.ObjectDesc == null) || (localeko.Ulb.ObjectDesc.Tkb == null))
      {
        Log.e("MicroMsg.NetSceneSnsPost", "err respone buffer is null ignore");
        aj.fOH().afN(this.fWh);
        params = aj.fOI().agI(this.fWh);
        if (params != null)
        {
          params.clearItemDie();
          aj.fOI().d(this.fWh, params);
          params = new xf();
          params.fWj.fWe = this.fWh;
          EventCenter.instance.publish(params);
        }
        if (com.tencent.mm.plugin.sns.k.g.Kia.KiN == this.fWh)
        {
          com.tencent.mm.plugin.sns.k.g.Kia.KiO.goQ = 1L;
          com.tencent.mm.plugin.sns.k.g.Kia.fQy();
          com.tencent.mm.plugin.sns.k.g.Kia.KiN = 0;
        }
        if (com.tencent.mm.plugin.sns.k.g.Kia.KiP == this.fWh)
        {
          com.tencent.mm.plugin.sns.k.g.Kia.KiQ.goQ = 1L;
          com.tencent.mm.plugin.sns.k.g.Kia.fQz();
          com.tencent.mm.plugin.sns.k.g.Kia.KiP = 0;
        }
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(95614);
        return;
      }
      paramArrayOfByte = new String(localeko.Ulb.ObjectDesc.Tkb.toByteArray());
      if (this.JVz == 0) {
        Log.d("MicroMsg.NetSceneSnsPost", "resp " + paramArrayOfByte + "  ");
      }
      this.JVy = o.Xk(paramArrayOfByte);
      Object localObject1;
      Object localObject2;
      Object localObject3;
      if (this.JVy.streamvideo != null)
      {
        params = this.JVy.Id;
        localObject1 = this.JVy.streamvideo.loy;
        localObject2 = this.JVy.streamvideo.lox;
        localObject3 = new com.tencent.mm.modelsns.n();
        ((com.tencent.mm.modelsns.n)localObject3).m("20CurrPublishId", params + ",");
        ((com.tencent.mm.modelsns.n)localObject3).m("20SourcePublishId", (String)localObject1 + ",");
        ((com.tencent.mm.modelsns.n)localObject3).m("20SourceAdUxInfo", (String)localObject2 + ",");
        Log.i("MicroMsg.SnsVideoStatistic", "report snsad_shareReport: " + ((com.tencent.mm.modelsns.n)localObject3).agI());
        com.tencent.mm.plugin.report.service.h.IzE.a(13004, new Object[] { localObject3 });
      }
      params = aj.fOI().agI(this.fWh);
      if (params == null)
      {
        Log.e("MicroMsg.NetSceneSnsPost", "the item has delete");
        params = new SnsInfo();
        params.setCreateTime(localeko.Ulb.CreateTime);
        params.setContent(paramArrayOfByte);
        params.setPostFinish();
        params.setSnsId(localeko.Ulb.Id);
        params.setStringSeq(localeko.Ulb.Id);
        if ((localeko.Ulb.ExtFlag & 0x1) > 0) {
          params.setExtFlag();
        }
        this.JIs = localeko.Ulb.Id;
        if (this.JVA != null)
        {
          this.JVA.gce.gcg = ("sns_" + com.tencent.mm.plugin.sns.data.t.Qu(this.JIs));
          EventCenter.instance.publish(this.JVA);
        }
        if ((this.JVB != null) && (this.JVB.gcu.gcv != -1)) {
          EventCenter.instance.publish(this.JVB);
        }
        localObject1 = localeko.Ulb;
        ((SnsObject)localObject1).ObjectDesc.dc(new byte[0]);
        try
        {
          if ((((SnsObject)localObject1).CommentUserListCount == 0) && (((SnsObject)localObject1).LikeUserListCount == 0) && (((SnsObject)localObject1).WithUserListCount == 0) && (((SnsObject)localObject1).GroupCount == 0)) {
            Log.d("MicroMsg.NetSceneSnsPost", "no use! this buf");
          }
          for (;;)
          {
            params.clearItemDie();
            aj.fOI().delete(this.JIs);
            aj.fOI().d(this.fWh, params);
            aj.fOH().afN(this.fWh);
            if (((this.JVx.ContentObj.Sqq == 1) && (this.JVx.showFlag == 0) && (this.JVy.showFlag == 1)) || ((this.JVx.ContentObj.Sqq == 15) && (this.JVx.sightFolded == 0) && (this.JVy.sightFolded == 1) && (com.tencent.mm.plugin.sns.storage.g.QZ(y.aYS(params.getSnsId()))))) {
              new MMHandler(Looper.getMainLooper()).post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(95607);
                  v.fOb();
                  AppMethodBeat.o(95607);
                }
              });
            }
            paramArrayOfByte = com.tencent.mm.plugin.sns.k.i.Kjb.dU(Integer.valueOf(this.fWh));
            if ((paramArrayOfByte != null) && (this.JVy != null))
            {
              paramArrayOfByte.boX();
              paramArrayOfByte.boY();
              paramArrayOfByte.Xh(this.JVy.Id);
              paramArrayOfByte.wR(this.JVy.ContentObj.Sqq);
              paramArrayOfByte.bpa();
            }
            paramArrayOfByte = j.Kjb.dU(Integer.valueOf(this.fWh));
            if ((paramArrayOfByte != null) && (this.JVy != null))
            {
              paramArrayOfByte.boX();
              paramArrayOfByte.boY();
              paramArrayOfByte.Xh(this.JVy.Id);
              paramArrayOfByte.wR(this.JVy.ContentObj.Sqq);
              paramArrayOfByte.bpa();
            }
            paramArrayOfByte = new xf();
            paramArrayOfByte.fWj.fWe = this.fWh;
            EventCenter.instance.publish(paramArrayOfByte);
            if (params.getTypeFlag() == 21)
            {
              params.getPravited();
              com.tencent.mm.plugin.sns.lucky.a.b.rE(7);
              System.currentTimeMillis();
            }
            a(this.JVx, this.JVy);
            if (this.JVy != null) {
              break;
            }
            paramArrayOfByte = "";
            aZX(paramArrayOfByte);
            if (aj.fOE() != null) {
              aj.fOE().fNd();
            }
            try
            {
              if (params.getTypeFlag() == 15)
              {
                paramInt1 = ((csn)((cvu)new cvu().parseFrom(params.getPostBuf())).TEc.getFirst()).TAo;
                if (paramInt1 > 0)
                {
                  localObject3 = (cvt)this.JVy.ContentObj.Sqr.get(0);
                  if (localObject3 != null)
                  {
                    paramArrayOfByte = aq.kD(aj.getAccSnsPath(), ((cvt)localObject3).Id) + com.tencent.mm.plugin.sns.data.t.i((cvt)localObject3);
                    localObject2 = com.tencent.mm.modelvideo.r.bqz();
                    localObject3 = ((cvt)localObject3).Url;
                    l = ((SnsObject)localObject1).Id;
                    if (!Util.isNullOrNil((String)localObject3))
                    {
                      boolean bool = Util.isNullOrNil(paramArrayOfByte);
                      if (!bool) {
                        break label2309;
                      }
                    }
                  }
                }
              }
            }
            catch (Exception paramArrayOfByte)
            {
              long l;
              label1839:
              String str;
              r.a locala;
              break label1839;
            }
            l = ((SnsObject)localObject1).Id;
            paramArrayOfByte = new xe();
            paramArrayOfByte.fWf.fWg = l;
            paramArrayOfByte.fWf.fWh = this.fWh;
            paramArrayOfByte.fWf.fWi = this.JVD;
            EventCenter.instance.publish(paramArrayOfByte);
            l = ((SnsObject)localObject1).Id;
            paramArrayOfByte = (String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VCK, "");
            if (!Util.isNullOrNil(paramArrayOfByte))
            {
              ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.c.class)).X("snspublicid", com.tencent.mm.plugin.sns.data.t.Qu(l), paramArrayOfByte);
              com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VCK, "");
            }
            paramArrayOfByte = com.tencent.mm.plugin.sns.k.g.Kia.Kik;
            paramArrayOfByte.gVN = paramArrayOfByte.z("Published", com.tencent.mm.plugin.sns.data.t.Qu(localeko.Ulb.Id), true);
            com.tencent.mm.plugin.sns.k.g.Kia.fQp();
            if (com.tencent.mm.plugin.sns.k.g.Kia.KiK.gWv == 1L)
            {
              paramArrayOfByte = com.tencent.mm.plugin.sns.k.g.Kia.KiK;
              paramArrayOfByte.gWx = paramArrayOfByte.z("NextPublishId", com.tencent.mm.plugin.sns.data.t.Qv(((SnsObject)localObject1).Id), true);
              com.tencent.mm.plugin.sns.k.g.Kia.fQx();
            }
            if (com.tencent.mm.plugin.sns.k.g.Kia.KiM == this.fWh)
            {
              paramArrayOfByte = com.tencent.mm.plugin.sns.k.g.Kia;
              com.tencent.mm.plugin.sns.k.g.a(9, "", 0, 0, cm.bfD(), ((SnsObject)localObject1).Id, com.tencent.mm.plugin.sns.k.g.Kia.Gdf, 0);
              com.tencent.mm.plugin.sns.k.g.Kia.KiM = 0;
            }
            if (com.tencent.mm.plugin.sns.k.g.Kia.KiN == this.fWh)
            {
              com.tencent.mm.plugin.sns.k.g.Kia.KiO.goQ = 2L;
              paramArrayOfByte = com.tencent.mm.plugin.sns.k.g.Kia.KiO;
              paramArrayOfByte.gks = paramArrayOfByte.z("Publishid", com.tencent.mm.plugin.sns.data.t.Qv(params.field_snsId), true);
              com.tencent.mm.plugin.sns.k.g.Kia.fQy();
              com.tencent.mm.plugin.sns.k.g.Kia.KiN = 0;
            }
            if (com.tencent.mm.plugin.sns.k.g.Kia.KiP == this.fWh)
            {
              com.tencent.mm.plugin.sns.k.g.Kia.KiQ.goQ = 2L;
              paramArrayOfByte = com.tencent.mm.plugin.sns.k.g.Kia.KiQ;
              paramArrayOfByte.gks = paramArrayOfByte.z("Publishid", com.tencent.mm.plugin.sns.data.t.Qv(params.field_snsId), true);
              com.tencent.mm.plugin.sns.k.g.Kia.fQz();
              com.tencent.mm.plugin.sns.k.g.Kia.KiP = 0;
            }
            this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
            AppMethodBeat.o(95614);
            return;
            params.setAttrBuf(((SnsObject)localObject1).toByteArray());
          }
        }
        catch (IOException paramArrayOfByte)
        {
          for (;;)
          {
            Log.printErrStackTrace("MicroMsg.NetSceneSnsPost", paramArrayOfByte, "", new Object[0]);
            continue;
            paramArrayOfByte = this.JVy.ContentDesc;
            continue;
            label2309:
            str = String.valueOf(paramInt1);
            Log.d("MicroMsg.SubCoreMediaRpt", "rpt sns video upload info snsKey[%s] url[%s] snsId[%d] path[%s]", new Object[] { str, localObject3, Long.valueOf(l), paramArrayOfByte });
            locala = (r.a)((com.tencent.mm.modelvideo.r)localObject2).mgY.get(str);
            if (locala != null)
            {
              locala.mhp = String.valueOf(l);
              locala.mho = paramArrayOfByte;
              locala.fLm = ((String)localObject3);
              ((com.tencent.mm.modelvideo.r)localObject2).a(locala.lQZ, str, "", l);
            }
          }
        }
      }
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.t
 * JD-Core Version:    0.7.0.1
 */