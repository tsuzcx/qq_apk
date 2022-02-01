package com.tencent.mm.plugin.sns.model;

import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.a.aec;
import com.tencent.mm.autogen.a.aec.a;
import com.tencent.mm.autogen.a.aed;
import com.tencent.mm.autogen.a.aed.a;
import com.tencent.mm.autogen.a.tm;
import com.tencent.mm.autogen.a.yw;
import com.tencent.mm.autogen.a.yx;
import com.tencent.mm.autogen.a.yy;
import com.tencent.mm.autogen.mmdata.rpt.gj;
import com.tencent.mm.autogen.mmdata.rpt.mp;
import com.tencent.mm.autogen.mmdata.rpt.np;
import com.tencent.mm.autogen.mmdata.rpt.pv;
import com.tencent.mm.autogen.mmdata.rpt.py;
import com.tencent.mm.model.ac;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.model.cn;
import com.tencent.mm.modelsns.o;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.modelvideo.u.a;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.comm.b.e;
import com.tencent.mm.plugin.comm.b.e.a;
import com.tencent.mm.plugin.sns.l.a.a;
import com.tencent.mm.plugin.sns.statistics.h.a;
import com.tencent.mm.plugin.sns.statistics.j;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.aa;
import com.tencent.mm.plugin.sns.storage.w;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.agh;
import com.tencent.mm.protocal.protobuf.bd;
import com.tencent.mm.protocal.protobuf.bh;
import com.tencent.mm.protocal.protobuf.djp;
import com.tencent.mm.protocal.protobuf.dmx;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.protocal.protobuf.dna;
import com.tencent.mm.protocal.protobuf.dnc;
import com.tencent.mm.protocal.protobuf.dyq;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.fdr;
import com.tencent.mm.protocal.protobuf.fee;
import com.tencent.mm.protocal.protobuf.feu;
import com.tencent.mm.protocal.protobuf.fev;
import com.tencent.mm.protocal.protobuf.few;
import com.tencent.mm.protocal.protobuf.fez;
import com.tencent.mm.protocal.protobuf.ffa;
import com.tencent.mm.protocal.protobuf.ffo;
import com.tencent.mm.protocal.protobuf.fhl;
import com.tencent.mm.protocal.protobuf.fhn;
import com.tencent.mm.protocal.protobuf.fjo;
import com.tencent.mm.protocal.protobuf.fqo;
import com.tencent.mm.protocal.protobuf.fr;
import com.tencent.mm.protocal.protobuf.gdd;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.protocal.protobuf.vm;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.vfs.y;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public final class t
  extends p
  implements com.tencent.mm.network.m
{
  long PZu;
  private int QsA;
  private aec QsB;
  private aed QsC;
  private int QsD;
  private HashMap<Integer, Integer> QsE;
  private String QsF;
  private HashMap<String, dmz> QsG;
  private HashMap<String, Integer> QsH;
  private HashMap<Integer, Integer> QsI;
  private String QsJ;
  private TimeLineObject Qsy;
  private TimeLineObject Qsz;
  public com.tencent.mm.am.h callback;
  int icg;
  boolean lKI;
  private int mxT;
  private IListener mxW;
  private IListener mxX;
  private com.tencent.mm.am.c rr;
  
  public t(String paramString1, int paramInt1, int paramInt2, List<String> paramList, TimeLineObject paramTimeLineObject, int paramInt3, String paramString2, int paramInt4, LinkedList<Long> paramLinkedList, int paramInt5, dna paramdna, boolean paramBoolean, LinkedList<etl> paramLinkedList1, feu paramfeu, com.tencent.mm.bx.b paramb, String paramString3, int paramInt6, String paramString4)
  {
    AppMethodBeat.i(95612);
    this.PZu = 0L;
    this.lKI = false;
    this.QsA = 0;
    this.QsE = new HashMap();
    this.mxT = 0;
    this.QsF = "";
    this.QsG = new HashMap();
    this.QsH = new HashMap();
    this.QsI = new HashMap();
    this.QsJ = "";
    this.mxW = new NetSceneSnsPost.2(this, com.tencent.mm.app.f.hfK);
    this.mxX = new NetSceneSnsPost.3(this, com.tencent.mm.app.f.hfK);
    this.Qsy = paramTimeLineObject;
    this.icg = paramInt3;
    this.QsD = paramInt5;
    localObject1 = new c.a();
    ((c.a)localObject1).otE = new fev();
    ((c.a)localObject1).otF = new few();
    ((c.a)localObject1).uri = "/cgi-bin/micromsg-bin/mmsnspost";
    ((c.a)localObject1).funcId = 209;
    ((c.a)localObject1).otG = 97;
    ((c.a)localObject1).respCmdId = 1000000097;
    this.rr = ((c.a)localObject1).bEF();
    fev localfev = (fev)c.b.b(this.rr.otB);
    localObject1 = com.tencent.mm.plugin.sns.statistics.h.QFO;
    localObject1 = h.a.aZn(String.valueOf(paramInt3));
    if (((com.tencent.mm.plugin.sns.k.f)localObject1).QCG == 0) {
      ((com.tencent.mm.plugin.sns.k.f)localObject1).QCI = cn.bDv();
    }
    Object localObject2 = com.tencent.mm.plugin.sns.statistics.h.QFO;
    h.a.a((com.tencent.mm.plugin.sns.k.f)localObject1);
    if ((paramTimeLineObject.actionInfo != null) && (paramTimeLineObject.actionInfo.YCC != null) && (!TextUtils.isEmpty(paramTimeLineObject.actionInfo.YCC.YCn)))
    {
      localObject1 = new vm();
      ((vm)localObject1).Zbj = paramTimeLineObject.actionInfo.YCC.YCn;
      localfev.abEs = ((vm)localObject1);
    }
    localObject1 = ad.bCb().Jn(paramdna.sessionId);
    if (localObject1 != null)
    {
      this.QsB = new aec();
      this.QsB.iiq.iir = ((ad.b)localObject1).getString("prePublishId", "");
      this.QsB.iiq.url = ((ad.b)localObject1).getString("url", "");
      this.QsB.iiq.iit = ((ad.b)localObject1).getString("preUsername", "");
      this.QsB.iiq.iiu = ((ad.b)localObject1).getString("preChatName", "");
      this.QsB.iiq.iiv = ((ad.b)localObject1).getInt("preMsgIndex", 0);
      this.QsB.iiq.iiz = ((ad.b)localObject1).getInt("sendAppMsgScene", 0);
      this.QsB.iiq.iiA = ((ad.b)localObject1).getInt("getA8KeyScene", 0);
      this.QsB.iiq.iiB = ((ad.b)localObject1).getString("referUrl", null);
      this.QsB.iiq.iiC = ((ad.b)localObject1).getString("adExtStr", null);
      this.QsB.iiq.iiD = paramString3;
      if (((ad.b)localObject1).containsKey("_tmpl_webview_transfer_scene"))
      {
        this.QsC = new aed();
        this.QsC.iiG.iiH = ((ad.b)localObject1).getInt("_tmpl_webview_transfer_scene", -1);
      }
      localObject1 = "";
      paramString3 = (String)localObject1;
      if (paramTimeLineObject.statExtStr != null)
      {
        localObject2 = new fhn();
        paramString3 = Base64.decode(paramTimeLineObject.statExtStr, 0);
      }
    }
    try
    {
      ((fhn)localObject2).parseFrom(paramString3);
      paramString3 = (String)localObject1;
      if (((fhn)localObject2).abIe != null) {
        paramString3 = ((fhn)localObject2).abIe.ICZ;
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
    paramString3 = (String)localObject1;
    if (Util.isNullOrNil((String)localObject1))
    {
      paramString3 = (String)localObject1;
      if (paramTimeLineObject.actionInfo != null)
      {
        paramString3 = (String)localObject1;
        if (paramTimeLineObject.actionInfo.YCC != null) {
          paramString3 = paramTimeLineObject.actionInfo.YCC.oOI;
        }
      }
    }
    localfev.abEr = String.format(Locale.US, "prePublishId=%s&preUserName=%s&preChatName=%s&preChatType=%d&getA8KeyScene=%d&sourceAppId=%s", new Object[] { this.QsB.iiq.iir, this.QsB.iiq.iit, this.QsB.iiq.iiu, Integer.valueOf(ac.aX(this.QsB.iiq.iit, this.QsB.iiq.iiu)), Integer.valueOf(this.QsB.iiq.iiA), paramString3 });
    paramString3 = new gol();
    paramString3.df(paramString1.getBytes());
    i = paramString1.length();
    j = paramString3.abwJ;
    if (paramb == null) {}
    for (paramInt3 = 0;; paramInt3 = paramb.Op.length)
    {
      Log.i("MicroMsg.NetSceneSnsPost", "len:%d   skb:%d ctx.len:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramInt3) });
      localfev.ObjectDesc = paramString3;
      localfev.abEm = paramInt1;
      localfev.aaTH = paramInt2;
      localfev.nUv = paramString2;
      this.QsA = paramInt1;
      if (com.tencent.mm.platformtools.z.pBN)
      {
        localfev.ObjectDesc = new gol();
        Log.e("MicroMsg.NetSceneSnsPost", "post error setObjectDesc is null!");
      }
      paramString3 = new LinkedList();
      if ((paramList == null) || (paramList.size() <= 0)) {
        break label1118;
      }
      paramList = paramList.iterator();
      for (paramString1 = ""; paramList.hasNext(); paramString1 = paramString1 + "; + " + (String)localObject1)
      {
        localObject1 = (String)paramList.next();
        localObject2 = new etl();
        ((etl)localObject2).btH((String)localObject1);
        paramString3.add(localObject2);
      }
    }
    Log.d("MicroMsg.NetSceneSnsPost", "post with list : ".concat(String.valueOf(paramString1)));
    label1118:
    localfev.WithUserList = paramString3;
    localfev.WithUserListCount = paramString3.size();
    if (aj.hga())
    {
      localfev.abEy = paramString3;
      localfev.abEx = paramString3.size();
    }
    localfev.abEn = paramInt4;
    paramString1 = localfev.abEr;
    if (paramdna.aaTY != null)
    {
      paramInt1 = paramdna.aaTY.abDt;
      Log.i("MicroMsg.NetSceneSnsPost", "setObjectSource: %d, clientid:%s fromScene:%s, score:%d, sdkTokenValid:%s, sdkPkgName:%s", new Object[] { Integer.valueOf(paramInt5), paramString2, paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt6), paramString4 });
      if ((paramLinkedList1 != null) && (paramLinkedList1.size() > 0))
      {
        if (!paramBoolean) {
          break label1428;
        }
        localfev.BlackList = paramLinkedList1;
        localfev.BlackListCount = paramLinkedList1.size();
      }
    }
    for (;;)
    {
      Log.d("MicroMsg.NetSceneSnsPost", "setObjectSource ".concat(String.valueOf(paramInt5)));
      localfev.abEo = paramInt5;
      paramString1 = new fqo();
      if (!Util.isNullOrNil(paramdna.token))
      {
        paramString1.abQw = paramdna.token;
        paramString1.abQx = paramdna.aaTQ;
        localfev.abld = paramString1;
      }
      if ((paramLinkedList == null) || (paramLinkedList.isEmpty())) {
        break label1492;
      }
      localfev.GroupCount = paramLinkedList.size();
      paramString1 = paramLinkedList.iterator();
      while (paramString1.hasNext())
      {
        paramList = (Long)paramString1.next();
        paramString2 = new fee();
        paramString2.abDQ = paramList.longValue();
        localfev.aaTN.add(paramString2);
      }
      paramInt1 = 0;
      break;
      label1428:
      localfev.GroupUser = paramLinkedList1;
      localfev.GroupUserCount = paramLinkedList1.size();
    }
    Log.d("MicroMsg.NetSceneSnsPost", "tagid " + paramLinkedList.size() + " " + localfev.aaTN.toString());
    label1492:
    localfev.aaTS = paramfeu;
    if (!Util.isNullOrNil(paramdna.aaTU)) {
      localfev.SnsRedEnvelops = new fez();
    }
    if (paramfeu != null) {
      Log.d("MicroMsg.NetSceneSnsPost", "SnsPostOperationFields: ShareUrlOriginal=%s, ShareUrlOpen=%s, JsAppId=%s", new Object[] { paramfeu.YHn, paramfeu.YHo, paramfeu.YHp });
    }
    if (paramb != null) {
      localfev.abEq = new gol().m(paramb);
    }
    localfev.abEv = paramdna.aaTY;
    paramString1 = al.hgB().alB(this.icg);
    if ((paramString1 != null) && ((paramString1.getTypeFlag() == 1) || (paramString1.getTypeFlag() == 15)) && (paramTimeLineObject.ContentObj != null) && (paramTimeLineObject.ContentObj.Zpr != null) && (paramTimeLineObject.ContentObj.Zpr.size() > 0) && (paramdna.aaTI != null) && (paramdna.aaTI.size() == paramTimeLineObject.ContentObj.Zpr.size()))
    {
      paramString1 = al.getAccSnsPath();
      paramList = paramTimeLineObject.ContentObj.Zpr.iterator();
      paramInt1 = 0;
    }
    for (;;)
    {
      if (paramList.hasNext())
      {
        paramLinkedList = (dmz)paramList.next();
        if ((paramLinkedList.vhJ == 2) || (paramLinkedList.vhJ == 6))
        {
          paramTimeLineObject = new dmx();
          if (paramLinkedList.vhJ != 2) {
            break label2018;
          }
          paramInt2 = 2;
          label1771:
          paramTimeLineObject.Idt = paramInt2;
          if (paramLinkedList.vhJ == 6)
          {
            paramString2 = as.mg(paramString1, paramLinkedList.Id);
            paramLinkedList = com.tencent.mm.plugin.sns.data.t.o(paramLinkedList);
            paramString2 = com.tencent.mm.plugin.sight.base.f.aVX(paramString2 + paramLinkedList);
            if (paramString2 != null) {
              paramTimeLineObject.aaTi = ((int)Math.round(paramString2.videoDuration / 1000.0D));
            }
          }
          paramString2 = (djp)paramdna.aaTI.get(paramInt1);
          paramString2 = al.hgq().vk(paramString2.aaPC);
        }
      }
      try
      {
        paramLinkedList = (dnc)new dnc().parseFrom(paramString2.QZv);
        paramTimeLineObject.IcB = paramLinkedList.aaUl;
        this.QsE.put(Integer.valueOf(paramString2.localid), Integer.valueOf(paramLinkedList.aaUl));
        label1936:
        paramTimeLineObject.SessionId = paramdna.sessionId;
        Log.i("MicroMsg.NetSceneSnsPost", "post add mediaInfo, Source: %s, videoPlayLength: %s, MediaType: %s, SessionId: %s", new Object[] { Integer.valueOf(paramTimeLineObject.IcB), Integer.valueOf(paramTimeLineObject.aaTi), Integer.valueOf(paramTimeLineObject.Idt), paramTimeLineObject.SessionId });
        localfev.abEu.add(paramTimeLineObject);
        paramInt1 += 1;
        continue;
        label2018:
        paramInt2 = 1;
        break label1771;
        localfev.abEt = localfev.abEu.size();
        Log.i("MicroMsg.NetSceneSnsPost", "post mediaCount: %s", new Object[] { Integer.valueOf(localfev.abEt) });
        if (com.tencent.mm.plugin.normsg.a.d.MtP.aQk("ie_sns_upload")) {
          com.tencent.mm.plugin.normsg.a.d.MtP.aQj("ie_sns_upload");
        }
        for (;;)
        {
          try
          {
            paramString1 = new gdd();
            paramString1.acaV = new gol().df(com.tencent.mm.plugin.normsg.a.d.MtP.aQl("ie_sns_upload"));
            if (paramString1.acaV == null) {
              continue;
            }
            paramInt1 = paramString1.acaV.abwJ;
            Log.d("MicroMsg.NetSceneSnsPost", "[debug] wcstf set on snspost, len: %s", new Object[] { Integer.valueOf(paramInt1) });
            paramString1.acaW = new gol().df(com.tencent.mm.plugin.normsg.a.d.MtP.aQo("ce_sns_upload"));
            if (paramString1.acaW == null) {
              continue;
            }
            paramInt1 = paramString1.acaW.abwJ;
            Log.d("MicroMsg.NetSceneSnsPost", "[debug] wcste set on snspost, len: %s", new Object[] { Integer.valueOf(paramInt1) });
            paramString1.acaX = new gol().df(com.tencent.mm.plugin.normsg.a.d.MtP.gtE());
            if (paramString1.acaX == null) {
              continue;
            }
            paramInt1 = paramString1.acaX.abwJ;
            Log.d("MicroMsg.NetSceneSnsPost", "[debug] ccData set on snspost, len: %s", new Object[] { Integer.valueOf(paramInt1) });
            localfev.YKb = new gol().df(paramString1.toByteArray());
          }
          finally
          {
            continue;
          }
          if ((paramdna == null) || (paramdna.aaTT == null)) {
            continue;
          }
          paramString1 = paramdna.aaTT.iterator();
          paramInt1 = 0;
          if (!paramString1.hasNext()) {
            continue;
          }
          paramList = (ffa)paramString1.next();
          this.QsI.put(Integer.valueOf(paramInt1), Integer.valueOf(paramList.abEN));
          paramInt1 += 1;
          continue;
          paramInt1 = -1;
          continue;
          paramInt1 = -1;
          continue;
          paramInt1 = -1;
        }
        paramString1 = new dyq();
        paramString1.YHq = paramInt6;
        paramString1.IcK = paramString4;
        localfev.abEw = paramString1;
        e.xfd.f("SnsPublishProcess", "upload_time", Long.valueOf(System.currentTimeMillis()));
        paramString1 = com.tencent.mm.plugin.sns.l.a.akV(1);
        if (paramString1 != null)
        {
          paramInt1 = 0;
          if (((paramString1.eQp & 0x4) == 0) && ((paramString1.eQp & 0x8) == 0)) {
            break label2526;
          }
          if ((paramString1.eQp & 0x4) != 0)
          {
            paramInt1 = 2;
            Log.i("MicroMsg.NetSceneSnsPost", "has paste fully flag, %d", new Object[] { Integer.valueOf(paramInt1) });
            label2470:
            localfev.abDB = com.tencent.mm.plugin.sns.data.t.dd(paramInt1, paramString1.QCX);
            com.tencent.mm.plugin.sns.l.a.akW(1);
          }
        }
        else
        {
          if (localfev.abDB != null) {
            break label2586;
          }
        }
        label2586:
        for (paramString1 = "";; paramString1 = localfev.abDB)
        {
          Log.d("MicroMsg.NetSceneSnsPost", "snsPost req.ReportData：%s", new Object[] { paramString1 });
          AppMethodBeat.o(95612);
          return;
          paramInt1 = 3;
          break;
          label2526:
          if (((paramString1.eQp & 0x10) == 0) && ((paramString1.eQp & 0x20) == 0)) {
            break label2470;
          }
          if ((paramString1.eQp & 0x10) != 0) {}
          for (paramInt1 = 4;; paramInt1 = 5)
          {
            Log.i("MicroMsg.NetSceneSnsPost", "has paste similar change flag, %d", new Object[] { Integer.valueOf(paramInt1) });
            break;
          }
        }
      }
      catch (Exception paramString2)
      {
        break label1936;
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
    String str1 = al.getAccSnsPath();
    int i = 0;
    while ((i < paramTimeLineObject1.ContentObj.Zpr.size()) && (i < paramTimeLineObject2.ContentObj.Zpr.size()))
    {
      Object localObject2 = (dmz)paramTimeLineObject1.ContentObj.Zpr.get(i);
      Object localObject1 = (dmz)paramTimeLineObject2.ContentObj.Zpr.get(i);
      String str2 = com.tencent.mm.plugin.sns.data.t.l((dmz)localObject2);
      String str3 = com.tencent.mm.plugin.sns.data.t.m((dmz)localObject2);
      String str4 = com.tencent.mm.plugin.sns.data.t.n((dmz)localObject2);
      String str5 = com.tencent.mm.plugin.sns.data.t.o((dmz)localObject2);
      String str6 = com.tencent.mm.plugin.sns.data.t.k((dmz)localObject1);
      String str7 = com.tencent.mm.plugin.sns.data.t.d((dmz)localObject1);
      String str8 = com.tencent.mm.plugin.sns.data.t.e((dmz)localObject1);
      String str9 = com.tencent.mm.plugin.sns.data.t.i((dmz)localObject1);
      Log.d("MicroMsg.NetSceneSnsPost", "updateMediaFileName " + str2 + "  - " + str6);
      localObject2 = as.mg(str1, ((dmz)localObject2).Id);
      localObject1 = as.mg(str1, ((dmz)localObject1).Id);
      y.bDX((String)localObject1);
      y.qn((String)localObject2 + str2, (String)localObject1 + str6);
      y.qn((String)localObject2 + str3, (String)localObject1 + str7);
      y.qn((String)localObject2 + str4, (String)localObject1 + str8);
      if (y.ZC((String)localObject2 + str5))
      {
        Log.i("MicroMsg.NetSceneSnsPost", "post done copy file %s", new Object[] { (String)localObject1 + str9 });
        y.qn((String)localObject2 + str5, (String)localObject1 + str9);
      }
      i += 1;
    }
    AppMethodBeat.o(95616);
    return true;
  }
  
  private void aYl(String paramString)
  {
    AppMethodBeat.i(95615);
    this.QsJ = paramString;
    this.mxT = 1;
    Log.i("MicroMsg.NetSceneSnsPost", "needUploadData:%s", new Object[] { Integer.valueOf(this.mxT) });
    if ((this.QsD != 12) && (this.mxT == 0))
    {
      AppMethodBeat.o(95615);
      return;
    }
    if ((this.Qsz != null) && (this.Qsz.ContentObj != null) && (this.Qsz.ContentObj.Zpr != null) && (this.Qsz.ContentObj.Zpr.size() > 0))
    {
      paramString = this.Qsz.ContentObj.Zpr;
      this.mxW.alive();
      this.mxX.alive();
      paramString = paramString.iterator();
      int i = 0;
      while (paramString.hasNext())
      {
        Object localObject = (dmz)paramString.next();
        if (((dmz)localObject).vhJ == 2)
        {
          String str = g.D((dmz)localObject);
          if (!Util.isNullOrNil(str))
          {
            this.QsH.put(str, Integer.valueOf(i));
            this.QsG.put(str, localObject);
            localObject = new tm();
            ((tm)localObject).hXd.hBk = System.nanoTime();
            ((tm)localObject).hXd.filePath = str;
            ((tm)localObject).publish();
            i += 1;
          }
        }
      }
    }
    AppMethodBeat.o(95615);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(95613);
    this.callback = paramh;
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
    paramArrayOfByte = com.tencent.mm.plugin.sns.statistics.h.QFO;
    paramArrayOfByte = h.a.aZn(String.valueOf(this.icg));
    few localfew = (few)c.c.b(((com.tencent.mm.am.c)params).otC);
    Object localObject1;
    if (paramInt2 == 4)
    {
      params = al.hgB().alB(this.icg);
      for (;;)
      {
        try
        {
          localObject1 = (dna)new dna().parseFrom(params.field_postBuf);
          ((dna)localObject1).aaTP = paramInt3;
          if (paramInt3 != 2006) {
            continue;
          }
          ((dna)localObject1).aaTW = localfew.abEA.abFz;
          ((dna)localObject1).aaUa = localfew.abEC;
          ((dna)localObject1).aaTX = false;
          params.setPostBuf(((dna)localObject1).toByteArray());
        }
        catch (Exception localException)
        {
          continue;
          com.tencent.mm.plugin.sns.lucky.a.b.rG(17);
          continue;
          com.tencent.mm.plugin.sns.lucky.a.b.rG(19);
          continue;
          com.tencent.mm.plugin.sns.lucky.a.b.rG(18);
          continue;
        }
        if (params != null)
        {
          params.setItemDie();
          al.hgB().f(this.icg, params);
          al.hgA().akC(this.icg);
          Log.d("MicroMsg.NetSceneSnsPost", "onErrorServer, publish SnsPostFailEvent, snsInfoLocalId: " + params.getLocalid());
          params = new yw();
          params.icd.ice = this.icg;
          params.publish();
        }
        if ((this.Qsy != null) && (this.Qsy.ContentObj != null) && (this.Qsy.ContentObj.Zpq == 21)) {
          com.tencent.mm.plugin.sns.lucky.a.b.rG(8);
        }
        switch (paramInt3)
        {
        default: 
          com.tencent.mm.plugin.sns.lucky.a.b.rG(20);
          if (j.QFS.QGH == this.icg)
          {
            j.QFS.QGI.iyr = 1L;
            j.QFS.hiw();
            j.QFS.QGH = 0;
          }
          if (j.QFS.QGJ == this.icg)
          {
            j.QFS.QGK.iyr = 1L;
            j.QFS.hix();
            j.QFS.QGJ = 0;
          }
          this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
          paramString = com.tencent.mm.plugin.sns.statistics.h.QFO;
          h.a.a(this.icg, paramArrayOfByte, paramInt2);
          AppMethodBeat.o(95614);
          return;
          ((dna)localObject1).aaTW = localfew.aaTW;
        }
      }
    }
    if (paramInt3 != 0)
    {
      al.hgA().akC(this.icg);
      if ((this.Qsy != null) && (this.Qsy.ContentObj != null) && (this.Qsy.ContentObj.Zpq == 21))
      {
        com.tencent.mm.plugin.sns.lucky.a.b.rG(8);
        com.tencent.mm.plugin.sns.lucky.a.b.rG(16);
      }
      if (j.QFS.QGH == this.icg)
      {
        j.QFS.QGI.iyr = 1L;
        j.QFS.hiw();
        j.QFS.QGH = 0;
      }
      if (j.QFS.QGJ == this.icg)
      {
        j.QFS.QGK.iyr = 1L;
        j.QFS.hix();
        j.QFS.QGJ = 0;
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      paramString = com.tencent.mm.plugin.sns.statistics.h.QFO;
      h.a.a(this.icg, paramArrayOfByte, paramInt3);
      AppMethodBeat.o(95614);
      return;
    }
    if ((localException.abCS == null) || (localException.abCS.ObjectDesc == null) || (localException.abCS.ObjectDesc.aaxD == null))
    {
      Log.e("MicroMsg.NetSceneSnsPost", "err respone buffer is null ignore");
      al.hgA().akC(this.icg);
      params = al.hgB().alB(this.icg);
      if (params != null)
      {
        params.clearItemDie();
        al.hgB().f(this.icg, params);
        params = new yy();
        params.ici.ice = this.icg;
        params.publish();
      }
      if (j.QFS.QGH == this.icg)
      {
        j.QFS.QGI.iyr = 1L;
        j.QFS.hiw();
        j.QFS.QGH = 0;
      }
      if (j.QFS.QGJ == this.icg)
      {
        j.QFS.QGK.iyr = 1L;
        j.QFS.hix();
        j.QFS.QGJ = 0;
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(95614);
      return;
    }
    paramArrayOfByte = new String(localException.abCS.ObjectDesc.aaxD.toByteArray());
    if (this.QsA == 0) {
      Log.d("MicroMsg.NetSceneSnsPost", "resp " + paramArrayOfByte + "  ");
    }
    this.Qsz = o.Pm(paramArrayOfByte);
    Object localObject2;
    Object localObject3;
    if (this.Qsz.streamvideo != null)
    {
      params = this.Qsz.Id;
      localObject1 = this.Qsz.streamvideo.nTB;
      localObject2 = this.Qsz.streamvideo.nTA;
      localObject3 = new com.tencent.mm.modelsns.n();
      ((com.tencent.mm.modelsns.n)localObject3).s("20CurrPublishId", params + ",");
      ((com.tencent.mm.modelsns.n)localObject3).s("20SourcePublishId", (String)localObject1 + ",");
      ((com.tencent.mm.modelsns.n)localObject3).s("20SourceAdUxInfo", (String)localObject2 + ",");
      Log.i("MicroMsg.SnsVideoStatistic", "report snsad_shareReport: " + ((com.tencent.mm.modelsns.n)localObject3).aIF());
      com.tencent.mm.plugin.report.service.h.OAn.b(13004, new Object[] { localObject3 });
    }
    params = al.hgB().alB(this.icg);
    if (params == null)
    {
      Log.e("MicroMsg.NetSceneSnsPost", "the item has delete");
      params = new SnsInfo();
    }
    for (;;)
    {
      params.setCreateTime(localException.abCS.CreateTime);
      params.setContent(paramArrayOfByte);
      params.setPostFinish();
      params.setSnsId(localException.abCS.Id);
      params.setStringSeq(localException.abCS.Id);
      if ((localException.abCS.ExtFlag & 0x1) > 0) {
        params.setExtFlag();
      }
      this.PZu = localException.abCS.Id;
      if (this.QsB != null)
      {
        this.QsB.iiq.iis = ("sns_" + com.tencent.mm.plugin.sns.data.t.uA(this.PZu));
        this.QsB.publish();
      }
      if ((this.QsC != null) && (this.QsC.iiG.iiH != -1)) {
        this.QsC.publish();
      }
      localObject1 = localException.abCS;
      ((SnsObject)localObject1).ObjectDesc.df(new byte[0]);
      try
      {
        if ((((SnsObject)localObject1).CommentUserListCount == 0) && (((SnsObject)localObject1).LikeUserListCount == 0) && (((SnsObject)localObject1).WithUserListCount == 0) && (((SnsObject)localObject1).GroupCount == 0)) {
          Log.d("MicroMsg.NetSceneSnsPost", "no use! this buf");
        }
        for (;;)
        {
          params.clearItemDie();
          al.hgB().delete(this.PZu);
          al.hgB().f(this.icg, params);
          al.hgA().akC(this.icg);
          if ((aj.hga()) && (ap.E(params).NewWithTaListCount > 0) && (aj.hgd())) {
            MultiProcessMMKV.getDefault().encode("sns_with_together_red", 1);
          }
          if (((this.Qsy.ContentObj.Zpq == 1) && (this.Qsy.showFlag == 0) && (this.Qsz.showFlag == 1)) || ((this.Qsy.ContentObj.Zpq == 15) && (this.Qsy.sightFolded == 0) && (this.Qsz.sightFolded == 1) && (com.tencent.mm.plugin.sns.storage.n.vf(com.tencent.mm.plugin.sns.storage.ai.aXe(params.getSnsId()))))) {
            new MMHandler(Looper.getMainLooper()).post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(95607);
                v.jZ();
                AppMethodBeat.o(95607);
              }
            });
          }
          paramArrayOfByte = com.tencent.mm.plugin.sns.statistics.l.QGY.gr(Integer.valueOf(this.icg));
          if ((paramArrayOfByte != null) && (this.Qsz != null))
          {
            paramArrayOfByte.bME();
            paramArrayOfByte.bMF();
            paramArrayOfByte.Pj(this.Qsz.Id);
            paramArrayOfByte.wR(this.Qsz.ContentObj.Zpq);
            paramArrayOfByte.bMH();
          }
          paramArrayOfByte = com.tencent.mm.plugin.sns.statistics.m.QGY.gr(Integer.valueOf(this.icg));
          if ((paramArrayOfByte != null) && (this.Qsz != null))
          {
            paramArrayOfByte.bME();
            paramArrayOfByte.bMF();
            paramArrayOfByte.Pj(this.Qsz.Id);
            paramArrayOfByte.wR(this.Qsz.ContentObj.Zpq);
            paramArrayOfByte.bMH();
          }
          paramArrayOfByte = new yy();
          paramArrayOfByte.ici.ice = this.icg;
          paramArrayOfByte.publish();
          if (params.getTypeFlag() == 21)
          {
            params.getPravited();
            com.tencent.mm.plugin.sns.lucky.a.b.rG(7);
            System.currentTimeMillis();
          }
          a(this.Qsy, this.Qsz);
          if (this.Qsz != null) {
            break;
          }
          paramArrayOfByte = "";
          aYl(paramArrayOfByte);
          if (al.hgx() != null) {
            al.hgx().hej();
          }
          try
          {
            if (params.getTypeFlag() == 15)
            {
              paramInt1 = ((djp)((dna)new dna().parseFrom(params.getPostBuf())).aaTI.getFirst()).aaPC;
              if (paramInt1 > 0)
              {
                localObject3 = (dmz)this.Qsz.ContentObj.Zpr.get(0);
                if (localObject3 != null)
                {
                  paramArrayOfByte = as.mg(al.getAccSnsPath(), ((dmz)localObject3).Id) + com.tencent.mm.plugin.sns.data.t.i((dmz)localObject3);
                  localObject2 = u.bOf();
                  localObject3 = ((dmz)localObject3).Url;
                  l = ((SnsObject)localObject1).Id;
                  if (!Util.isNullOrNil((String)localObject3))
                  {
                    boolean bool = Util.isNullOrNil(paramArrayOfByte);
                    if (!bool) {
                      break label2613;
                    }
                  }
                }
              }
            }
          }
          catch (Exception paramArrayOfByte)
          {
            long l;
            label1945:
            com.tencent.mm.plugin.sns.cover.b.a locala;
            String str;
            u.a locala1;
            break label1945;
          }
          l = ((SnsObject)localObject1).Id;
          paramArrayOfByte = new yx();
          paramArrayOfByte.icf.ibq = l;
          paramArrayOfByte.icf.icg = this.icg;
          paramArrayOfByte.icf.ich = this.QsE;
          paramArrayOfByte.publish();
          l = ((SnsObject)localObject1).Id;
          paramArrayOfByte = (String)com.tencent.mm.kernel.h.baE().ban().get(at.a.adfE, "");
          if (!Util.isNullOrNil(paramArrayOfByte))
          {
            ((com.tencent.mm.plugin.expt.b.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.d.class)).aa("snspublicid", com.tencent.mm.plugin.sns.data.t.uA(l), paramArrayOfByte);
            com.tencent.mm.kernel.h.baE().ban().set(at.a.adfE, "");
          }
          paramArrayOfByte = j.QFS.QGd;
          paramArrayOfByte.jpj = paramArrayOfByte.F("Published", com.tencent.mm.plugin.sns.data.t.uA(localException.abCS.Id), true);
          j.QFS.hin();
          if (j.QFS.QGE.jpR == 1L)
          {
            paramArrayOfByte = j.QFS.QGE;
            paramArrayOfByte.jpT = paramArrayOfByte.F("NextPublishId", com.tencent.mm.plugin.sns.data.t.uB(((SnsObject)localObject1).Id), true);
            j.QFS.hiv();
          }
          if (j.QFS.QGG == this.icg)
          {
            paramArrayOfByte = j.QFS;
            j.a(9, "", 0, 0, cn.bDv(), ((SnsObject)localObject1).Id, j.QFS.LYR, 0);
            j.QFS.QGG = 0;
          }
          if (j.QFS.QGH == this.icg)
          {
            j.QFS.QGI.iyr = 2L;
            paramArrayOfByte = j.QFS.QGI;
            paramArrayOfByte.irF = paramArrayOfByte.F("Publishid", com.tencent.mm.plugin.sns.data.t.uB(params.field_snsId), true);
            j.QFS.hiw();
            j.QFS.QGH = 0;
          }
          if (j.QFS.QGJ == this.icg)
          {
            j.QFS.QGK.iyr = 2L;
            paramArrayOfByte = j.QFS.QGK;
            paramArrayOfByte.irF = paramArrayOfByte.F("Publishid", com.tencent.mm.plugin.sns.data.t.uB(params.field_snsId), true);
            j.QFS.hix();
            j.QFS.QGJ = 0;
          }
          if (j.QFS.QGM == this.icg)
          {
            paramArrayOfByte = j.QFS.QGL;
            paramArrayOfByte.jfv = paramArrayOfByte.F("PublishID", com.tencent.mm.plugin.sns.data.t.uB(params.field_snsId), true);
            paramArrayOfByte = j.QFS;
            locala = com.tencent.mm.plugin.sns.cover.b.a.QkS;
            if (com.tencent.mm.plugin.sns.cover.b.a.hes())
            {
              paramArrayOfByte.QGL.bMH();
              paramArrayOfByte.QGL = new np();
            }
          }
          e.xfd.f("SnsPublishProcess", "send_type", Integer.valueOf(params.getTypeFlag()));
          e.xfd.f("SnsPublishProcess", "publishid_", com.tencent.mm.plugin.sns.data.t.uA(params.field_snsId));
          e.xfd.a("SnsPublishProcess", "upload_time", Long.valueOf(System.currentTimeMillis()), com.tencent.mm.plugin.comm.b.c.xeV);
          paramArrayOfByte = com.tencent.mm.plugin.sns.statistics.h.QFO;
          h.a.aZm(this.icg);
          ((com.tencent.mm.plugin.secdata.g)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.secdata.g.class)).removeFromStorage(16, params.localid, null);
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
          paramArrayOfByte = this.Qsz.ContentDesc;
          continue;
          label2613:
          str = String.valueOf(paramInt1);
          Log.d("MicroMsg.SubCoreMediaRpt", "rpt sns video upload info snsKey[%s] url[%s] snsId[%d] path[%s]", new Object[] { str, localObject3, Long.valueOf(l), paramArrayOfByte });
          locala1 = (u.a)((u)localObject2).pai.get(str);
          if (locala1 != null)
          {
            locala1.paA = String.valueOf(l);
            locala1.paz = paramArrayOfByte;
            locala1.hQU = ((String)localObject3);
            ((u)localObject2).a(locala1.oJJ, str, "", l);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.t
 * JD-Core Version:    0.7.0.1
 */