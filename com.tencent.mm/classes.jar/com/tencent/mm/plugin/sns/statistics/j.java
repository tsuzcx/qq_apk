package com.tencent.mm.plugin.sns.statistics;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.gh;
import com.tencent.mm.autogen.mmdata.rpt.gj;
import com.tencent.mm.autogen.mmdata.rpt.mp;
import com.tencent.mm.autogen.mmdata.rpt.mq;
import com.tencent.mm.autogen.mmdata.rpt.ni;
import com.tencent.mm.autogen.mmdata.rpt.nn;
import com.tencent.mm.autogen.mmdata.rpt.no;
import com.tencent.mm.autogen.mmdata.rpt.np;
import com.tencent.mm.autogen.mmdata.rpt.nu;
import com.tencent.mm.autogen.mmdata.rpt.nw;
import com.tencent.mm.autogen.mmdata.rpt.ob;
import com.tencent.mm.autogen.mmdata.rpt.oc;
import com.tencent.mm.autogen.mmdata.rpt.od;
import com.tencent.mm.autogen.mmdata.rpt.od.a;
import com.tencent.mm.autogen.mmdata.rpt.pv;
import com.tencent.mm.autogen.mmdata.rpt.px;
import com.tencent.mm.autogen.mmdata.rpt.py;
import com.tencent.mm.autogen.mmdata.rpt.ue;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.bo;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.agh;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.vfs.y;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class j
{
  private static final Integer QFR;
  public static j QFS;
  public long AxK;
  public long LYR;
  public HashMap<String, Integer> QFT;
  public HashMap<String, String> QFU;
  public HashSet<String> QFV;
  private LinkedHashMap<Long, Object> QFW;
  private int QFX;
  public od.a QFY;
  public String QFZ;
  public long QGA;
  public long QGB;
  public px QGC;
  public py QGD;
  public py QGE;
  public String QGF;
  public int QGG;
  public int QGH;
  public gj QGI;
  public int QGJ;
  public mp QGK;
  public np QGL;
  public int QGM;
  public no QGN;
  public Map<Long, oc> QGO;
  public ob QGP;
  public List<Long> QGQ;
  public int QGa;
  public int QGb;
  public int QGc;
  public pv QGd;
  public Map<String, Integer> QGe;
  public Map<String, b> QGf;
  public Map<String, a> QGg;
  public od QGh;
  public List<String> QGi;
  public List<String> QGj;
  public List<String> QGk;
  public List<String> QGl;
  public List<String> QGm;
  public List<String> QGn;
  public List<String> QGo;
  public long QGp;
  public long QGq;
  public long QGr;
  public long QGs;
  public long QGt;
  public long QGu;
  private LinkedList<ni> QGv;
  private List<String> QGw;
  private List<String> QGx;
  public long QGy;
  private long QGz;
  public com.tencent.mm.storage.ap lsW;
  public int mxT;
  private IListener<gh> qlY;
  
  static
  {
    AppMethodBeat.i(96248);
    QFR = Integer.valueOf(1);
    QFS = new j();
    AppMethodBeat.o(96248);
  }
  
  private j()
  {
    AppMethodBeat.i(96212);
    this.QFX = 0;
    this.QFZ = "0";
    this.QGa = -1;
    this.QGb = 100;
    this.QGc = 14400;
    this.mxT = 1;
    this.qlY = new SnsReportHelper.2(this, com.tencent.mm.app.f.hfK);
    this.QGd = new pv();
    this.QGe = new HashMap();
    this.QGf = new HashMap();
    this.QGg = new HashMap();
    this.QGh = new od();
    this.QGi = new ArrayList();
    this.QGj = new ArrayList();
    this.QGk = new ArrayList();
    this.QGl = new ArrayList();
    this.QGm = new ArrayList();
    this.QGn = new ArrayList();
    this.QGo = new ArrayList();
    this.QGp = 0L;
    this.QGq = 0L;
    this.QGr = 0L;
    this.QGs = 0L;
    this.QGt = 0L;
    this.QGu = 0L;
    this.QGv = new LinkedList();
    this.QGw = new ArrayList();
    this.QGx = new ArrayList();
    this.QGy = 0L;
    this.QGz = 0L;
    this.QGA = 0L;
    this.QGB = 0L;
    this.QGC = new px();
    this.QGD = new py();
    this.QGE = new py();
    this.QGF = "";
    this.QGG = 0;
    this.LYR = 0L;
    this.QGH = 0;
    this.QGI = new gj();
    this.QGJ = 0;
    this.QGK = new mp();
    this.QGL = new np();
    this.QGM = 0;
    this.QGN = new no();
    this.QGO = Collections.synchronizedMap(new HashMap());
    this.QGP = new ob();
    this.QGQ = new ArrayList();
    this.AxK = 0L;
    this.QGb = ((c)h.ax(c.class)).a(c.a.zwA, 100);
    this.QGc = ((c)h.ax(c.class)).a(c.a.zwB, 14400);
    this.mxT = ((c)h.ax(c.class)).a(c.a.zwC, 1);
    Log.i("MicroMsg.SnsReportHelper", "initAbtestArg maxCacheFeedCount:%d, maxCacheSeconds:%d, needUploadData:%d", new Object[] { Integer.valueOf(this.QGb), Integer.valueOf(this.QGc), Integer.valueOf(this.mxT) });
    hik();
    try
    {
      this.lsW = new com.tencent.mm.storage.ap(at.acHq + "snsreport.cfg");
      Object localObject1 = this.lsW.d(3, new HashMap());
      localObject2 = this.lsW.d(4, new HashMap());
      localObject3 = this.lsW.d(5, new HashSet());
      localObject4 = this.lsW.d(6, new LinkedHashMap());
      if ((!(localObject1 instanceof HashMap)) || (!(localObject2 instanceof HashMap)) || (!(localObject3 instanceof HashSet)) || (!(localObject4 instanceof LinkedHashMap)))
      {
        y.deleteFile(at.acHq + "snsreport.cfg");
        this.lsW.reset();
        this.QFT = new HashMap();
        this.QFU = new HashMap();
        this.QFV = new HashSet();
        this.QFW = new LinkedHashMap();
        Log.d("MicroMsg.SnsReportHelper", "obj[%d] objForAppId[%d] objForFold[%d] objForAppIdCgi[%d] ", new Object[] { Integer.valueOf(this.QFT.size()), Integer.valueOf(this.QFU.size()), Integer.valueOf(this.QFV.size()), Integer.valueOf(this.QFW.size()) });
        this.qlY.alive();
        AppMethodBeat.o(96212);
        return;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        Object localObject2;
        Object localObject3;
        Object localObject4;
        Log.printErrStackTrace("MicroMsg.SnsReportHelper", localOutOfMemoryError, "", new Object[0]);
        y.deleteFile(at.acHq + "snsreport.cfg");
        this.lsW = new com.tencent.mm.storage.ap(at.acHq + "snsreport.cfg");
        continue;
        this.QFT = ((HashMap)localOutOfMemoryError);
        this.QFU = ((HashMap)localObject2);
        this.QFV = ((HashSet)localObject3);
        this.QFW = ((LinkedHashMap)localObject4);
      }
    }
  }
  
  public static void a(int paramInt1, String paramString, int paramInt2, int paramInt3, long paramLong, int paramInt4)
  {
    AppMethodBeat.i(306560);
    a(paramInt1, paramString, paramInt2, paramInt3, paramLong, 0L, 0L, paramInt4);
    AppMethodBeat.o(306560);
  }
  
  public static void a(int paramInt1, String paramString, int paramInt2, int paramInt3, long paramLong1, long paramLong2, long paramLong3, int paramInt4)
  {
    AppMethodBeat.i(306563);
    int i;
    if (paramInt4 == 2)
    {
      i = ((Integer)h.baE().ban().get(at.a.adgu, Integer.valueOf(0))).intValue();
      paramInt3 = 0;
      paramString = "";
    }
    for (;;)
    {
      ((cn)h.az(cn.class)).snsToFinderPostReport(QFS.QGF, paramInt1, paramString, paramInt2, paramInt3, i, paramLong2, paramLong3, paramLong1, paramInt4);
      AppMethodBeat.o(306563);
      return;
      i = ((Integer)h.baE().ban().get(at.a.adgt, Integer.valueOf(0))).intValue();
    }
  }
  
  public static void a(SnsObject paramSnsObject, int paramInt, String paramString)
  {
    AppMethodBeat.i(306571);
    int i;
    if (paramSnsObject != null)
    {
      if (!Util.isEqual(paramSnsObject.Username, z.bAM())) {
        break label132;
      }
      if (!Util.isEqual(paramString, z.bAM())) {
        break label127;
      }
      i = 2;
    }
    for (;;)
    {
      int j = paramSnsObject.CommentCount;
      int k = paramSnsObject.LikeCount;
      nu localnu = new nu();
      localnu.vN(t.uB(paramSnsObject.Id));
      localnu.vP(String.valueOf(paramInt));
      localnu.jgb = i;
      localnu.vO(paramString);
      localnu.jge = 1;
      localnu.jgc = k;
      localnu.jgd = j;
      localnu.bMH();
      AppMethodBeat.o(306571);
      return;
      label127:
      i = 3;
      continue;
      label132:
      i = 1;
    }
  }
  
  public static void aZp(String paramString)
  {
    AppMethodBeat.i(96224);
    ue localue = new ue();
    localue.Ab(paramString);
    localue.jFN = 1L;
    localue.jFO = 1L;
    localue.bMH();
    AppMethodBeat.o(96224);
  }
  
  public static void aZq(String paramString)
  {
    AppMethodBeat.i(96226);
    ue localue = new ue();
    localue.Ab(paramString);
    localue.jFN = 3L;
    localue.jFO = 1L;
    localue.bMH();
    AppMethodBeat.o(96226);
  }
  
  public static void b(SnsInfo paramSnsInfo, int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(306566);
    int i;
    Object localObject;
    int k;
    int j;
    if (paramSnsInfo != null)
    {
      if (!Util.isEqual(paramSnsInfo.getUserName(), z.bAM())) {
        break label148;
      }
      if (!Util.isEqual(paramString, z.bAM())) {
        break label142;
      }
      i = 2;
      localObject = com.tencent.mm.plugin.sns.model.ap.E(paramSnsInfo);
      if (localObject == null) {
        break label154;
      }
      k = ((SnsObject)localObject).CommentCount;
      j = ((SnsObject)localObject).LikeCount;
    }
    for (;;)
    {
      localObject = new nu();
      ((nu)localObject).vN(t.uB(paramSnsInfo.field_snsId));
      ((nu)localObject).vP(String.valueOf(paramInt1));
      ((nu)localObject).jgb = i;
      ((nu)localObject).vO(paramString);
      ((nu)localObject).jge = paramInt2;
      ((nu)localObject).jgc = j;
      ((nu)localObject).jgd = k;
      ((nu)localObject).bMH();
      AppMethodBeat.o(306566);
      return;
      label142:
      i = 3;
      break;
      label148:
      i = 1;
      break;
      label154:
      j = 0;
      k = 0;
    }
  }
  
  public static void hd(String paramString, int paramInt)
  {
    AppMethodBeat.i(96225);
    ue localue = new ue();
    localue.Ab(paramString);
    localue.jFN = 2L;
    localue.jFO = paramInt;
    localue.bMH();
    AppMethodBeat.o(96225);
  }
  
  public static void he(String paramString, int paramInt)
  {
    int i = 2;
    AppMethodBeat.i(306577);
    mq localmq = new mq();
    localmq.vc(paramString);
    localmq.ipH = paramInt;
    localmq.jbV = 2;
    paramString = com.tencent.mm.plugin.recordvideo.util.b.Obj;
    paramInt = i;
    if (com.tencent.mm.plugin.recordvideo.util.b.D(MMApplicationContext.getContext(), "com.tencent.phoenix", "A24DC0755072F64C480DC06DCD3412BF")) {
      paramInt = 1;
    }
    localmq.jbU = paramInt;
    localmq.bMH();
    AppMethodBeat.o(306577);
  }
  
  private void hik()
  {
    AppMethodBeat.i(96215);
    this.QFX = ((c)h.ax(c.class)).a(c.a.yGL, 100);
    Log.i("MicroMsg.SnsReportHelper", "resetXExptControl maxFeedIdForCgiRecord[%d]", new Object[] { Integer.valueOf(this.QFX) });
    AppMethodBeat.o(96215);
  }
  
  private void hit()
  {
    AppMethodBeat.i(96245);
    this.QGw.clear();
    this.QGx.clear();
    this.QGy = 0L;
    this.QGA = 0L;
    this.QGz = 0L;
    this.QGB = 0L;
    AppMethodBeat.o(96245);
  }
  
  public static void l(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    int i = 1;
    AppMethodBeat.i(306583);
    mq localmq = new mq();
    localmq.vc(paramString1);
    localmq.ipH = paramInt;
    localmq.jbV = 1;
    localmq.jbW = localmq.F("EgID", paramString2, true);
    localmq.jbX = localmq.F("MusicID", paramString3, true);
    paramString1 = com.tencent.mm.plugin.recordvideo.util.b.Obj;
    if (com.tencent.mm.plugin.recordvideo.util.b.D(MMApplicationContext.getContext(), "com.tencent.phoenix", "A24DC0755072F64C480DC06DCD3412BF")) {}
    for (paramInt = i;; paramInt = 2)
    {
      localmq.jbU = paramInt;
      localmq.bMH();
      AppMethodBeat.o(306583);
      return;
    }
  }
  
  private static <T> String listToString(List<T> paramList, String paramString)
  {
    AppMethodBeat.i(96232);
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      int i = 0;
      while (i < paramList.size())
      {
        Object localObject = paramList.get(i);
        if (localObject != null) {
          localStringBuilder.append(localObject.toString()).append(paramString);
        }
        i += 1;
      }
    }
    paramList = localStringBuilder.toString();
    AppMethodBeat.o(96232);
    return paramList;
  }
  
  public final void Q(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(96234);
    if (paramSnsInfo != null)
    {
      String str = t.uB(paramSnsInfo.field_snsId);
      if (!this.QGi.contains(str)) {
        this.QGi.add(str);
      }
      if ((com.tencent.mm.plugin.sns.model.ap.D(paramSnsInfo).NewWithTaListCount > 0) && (!this.QGj.contains(str))) {
        this.QGj.add(str);
      }
    }
    AppMethodBeat.o(96234);
  }
  
  public final void R(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(96235);
    if (paramSnsInfo != null)
    {
      paramSnsInfo = t.uB(paramSnsInfo.field_snsId);
      if (!this.QGk.contains(paramSnsInfo)) {
        this.QGk.add(paramSnsInfo);
      }
    }
    AppMethodBeat.o(96235);
  }
  
  public final void S(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(96236);
    if (paramSnsInfo != null)
    {
      paramSnsInfo = t.uB(paramSnsInfo.field_snsId);
      if (!this.QGl.contains(paramSnsInfo)) {
        this.QGl.add(paramSnsInfo);
      }
    }
    AppMethodBeat.o(96236);
  }
  
  public final void a(View paramView, bo parambo, String paramString1, String paramString2, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(96227);
    String str;
    int i;
    if ((paramView != null) && (parambo != null) && (parambo.PNx != null) && (parambo.PJQ != null) && (parambo.PJQ.getTimeLine() != null) && (parambo.PJQ.getTimeLine().ContentObj != null) && (this.QGf.get(t.uA(parambo.PJQ.field_snsId)) == null))
    {
      str = z.bAM();
      paramView = new nw();
      paramView.imU = paramView.F("Username", parambo.PJQ.getUserName(), true);
      paramView.jgm = paramView.F("PublicID", t.uA(parambo.PJQ.field_snsId), true);
      paramView.jgn = parambo.PJQ.getTimeLine().ContentObj.Zpq;
      i = 0;
      paramString1 = paramString1.split(",");
      if (paramString1 != null) {
        i = paramString1.length;
      }
      paramView.jgo = i;
      i = 0;
      paramString1 = paramString2.split(",");
      if (paramString1 != null) {
        i = paramString1.length;
      }
      paramView.jgp = i;
      paramView.jgq = paramInt1;
      paramView.jgr = paramInt2;
      if (!paramBoolean) {
        break label434;
      }
      paramView.jgs = 1L;
      if (parambo.RCd == null) {
        break label468;
      }
      paramInt1 = 0;
      label232:
      if (paramInt1 >= parambo.RCd.size()) {
        break label468;
      }
      if (!Util.isEqual(str, (String)((com.tencent.mm.vending.j.a)parambo.RCd.get(paramInt1)).get(0))) {
        break label444;
      }
    }
    label434:
    label444:
    label453:
    label459:
    label468:
    for (paramInt1 = 1;; paramInt1 = 4)
    {
      paramInt2 = paramInt1;
      if (parambo.RCe != null) {
        i = 0;
      }
      for (;;)
      {
        paramInt2 = paramInt1;
        if (i < parambo.RCe.size())
        {
          paramString1 = (com.tencent.mm.vending.j.a)parambo.RCe.get(i);
          if ((!(paramString1.get(1) instanceof String)) || (!Util.isEqual(str, (String)paramString1.get(1)))) {
            break label459;
          }
          if (paramInt1 != 1) {
            break label453;
          }
        }
        for (paramInt2 = 3;; paramInt2 = 2)
        {
          paramView.jgt = parambo.RCe.size();
          paramView.jgv = paramInt2;
          paramView.jgC = paramInt4;
          paramView.jgx = System.currentTimeMillis();
          paramString1 = new b();
          paramString1.position = paramInt3;
          paramString1.QGX = paramView;
          this.QGf.put(t.uA(parambo.PJQ.field_snsId), paramString1);
          AppMethodBeat.o(96227);
          return;
          paramView.jgs = 2L;
          break;
          paramInt1 += 1;
          break label232;
        }
        i += 1;
      }
    }
  }
  
  public final void a(List<Long> paramList, long paramLong, String paramString)
  {
    AppMethodBeat.i(306792);
    this.AxK = System.currentTimeMillis();
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = paramList.iterator();
    while (((Iterator)localObject).hasNext()) {
      localStringBuilder.append(t.uB(((Long)((Iterator)localObject).next()).longValue())).append("#");
    }
    localObject = this.QGP;
    ((ob)localObject).jin = ((ob)localObject).F("FeedList", localStringBuilder.toString(), true);
    this.QGP.jil = paramList.size();
    this.QGP.wd(t.uB(paramLong));
    this.QGP.wd(t.uB(paramLong));
    paramList = this.QGP;
    paramList.irj = paramList.F("UserName", paramString, true);
    AppMethodBeat.o(306792);
  }
  
  public final void aZ(Map<String, List<String>> paramMap)
  {
    AppMethodBeat.i(96220);
    if ((paramMap != null) && (!paramMap.isEmpty()) && (this.QGd != null))
    {
      this.QGd.jpb = paramMap.keySet().size();
      StringBuilder localStringBuilder = new StringBuilder();
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        List localList = (List)localEntry.getValue();
        if (localList != null) {
          localStringBuilder.append((String)localEntry.getKey()).append("|").append(localList.size()).append(";");
        }
      }
      paramMap = this.QGd;
      paramMap.jpc = paramMap.F("SelectedChatroomList", localStringBuilder.toString(), true);
    }
    AppMethodBeat.o(96220);
  }
  
  public final void aZo(String paramString)
  {
    AppMethodBeat.i(306647);
    Integer localInteger = (Integer)this.QGe.get(paramString);
    if (localInteger == null)
    {
      this.QGe.put(paramString, Integer.valueOf(1));
      AppMethodBeat.o(306647);
      return;
    }
    this.QGe.put(paramString, Integer.valueOf(localInteger.intValue() + 1));
    AppMethodBeat.o(306647);
  }
  
  public final void akX(int paramInt)
  {
    if (this.QGd != null) {}
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      this.QGd.joX = 1;
      return;
    case 1: 
      this.QGd.joX = 2;
      return;
    case 2: 
      this.QGd.joX = 3;
      return;
    }
    this.QGd.joX = 4;
  }
  
  public final void akY(int paramInt)
  {
    AppMethodBeat.i(306782);
    com.tencent.mm.plugin.sns.cover.b.a locala = com.tencent.mm.plugin.sns.cover.b.a.QkS;
    if (!com.tencent.mm.plugin.sns.cover.b.a.hes())
    {
      AppMethodBeat.o(306782);
      return;
    }
    if ((this.QGN.jfr == 1) || (this.QGN.jfr == 2)) {
      this.QGN.vJ("");
    }
    this.QGN.ilm = paramInt;
    this.QGN.bMH();
    AppMethodBeat.o(306782);
  }
  
  public final void akZ(int paramInt)
  {
    AppMethodBeat.i(306790);
    Iterator localIterator = this.QGO.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      oc localoc = (oc)localEntry.getValue();
      if (localoc != null)
      {
        localoc.jis = paramInt;
        ((oc)localEntry.getValue()).bMH();
      }
    }
    this.QGO.clear();
    AppMethodBeat.o(306790);
  }
  
  public final void ba(Map<String, List<String>> paramMap)
  {
    AppMethodBeat.i(96222);
    if ((paramMap != null) && (!paramMap.isEmpty()) && (this.QGd != null))
    {
      this.QGd.jph = paramMap.keySet().size();
      StringBuilder localStringBuilder = new StringBuilder();
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        List localList = (List)localEntry.getValue();
        if (localList != null) {
          localStringBuilder.append((String)localEntry.getKey()).append("|").append(localList.size()).append(";");
        }
      }
      paramMap = this.QGd;
      paramMap.jpi = paramMap.F("SelectedLabelList", localStringBuilder.toString(), true);
    }
    AppMethodBeat.o(96222);
  }
  
  public final void cY(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(96213);
    if (this.mxT == 0)
    {
      AppMethodBeat.o(96213);
      return;
    }
    HashMap localHashMap = this.QFT;
    if (this.QFT.containsKey(paramString)) {}
    for (int i = ((Integer)this.QFT.get(paramString)).intValue() + 1;; i = 1)
    {
      localHashMap.put(paramString, Integer.valueOf(i));
      if (paramBoolean) {
        this.QFV.add(paramString);
      }
      AppMethodBeat.o(96213);
      return;
    }
  }
  
  public final void cZ(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(96229);
    if (paramString != null)
    {
      paramString = (b)this.QGf.get(paramString);
      if ((paramString != null) && (paramString.QGX != null))
      {
        if (paramBoolean)
        {
          paramString.QGX.jgu = 1L;
          AppMethodBeat.o(96229);
          return;
        }
        paramString.QGX.jgu = 3L;
      }
    }
    AppMethodBeat.o(96229);
  }
  
  public final void da(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(96230);
    if (paramString != null)
    {
      paramString = (b)this.QGf.get(paramString);
      if ((paramString != null) && (paramString.QGX != null))
      {
        if (paramBoolean)
        {
          paramString.QGX.jgw = 1L;
          AppMethodBeat.o(96230);
          return;
        }
        paramString.QGX.jgD = 1L;
      }
    }
    AppMethodBeat.o(96230);
  }
  
  public final void e(SnsInfo paramSnsInfo, int paramInt)
  {
    AppMethodBeat.i(96237);
    if (paramSnsInfo != null)
    {
      paramSnsInfo = t.uB(paramSnsInfo.field_snsId) + "_" + paramInt;
      if (!this.QGm.contains(paramSnsInfo)) {
        this.QGm.add(paramSnsInfo);
      }
    }
    AppMethodBeat.o(96237);
  }
  
  public final void f(SnsInfo paramSnsInfo, int paramInt)
  {
    AppMethodBeat.i(96238);
    if (paramSnsInfo != null)
    {
      paramSnsInfo = t.uB(paramSnsInfo.field_snsId) + "_" + paramInt;
      if (!this.QGo.contains(paramSnsInfo)) {
        this.QGo.add(paramSnsInfo);
      }
    }
    AppMethodBeat.o(96238);
  }
  
  public final void g(SnsInfo paramSnsInfo, int paramInt)
  {
    AppMethodBeat.i(96243);
    if (paramSnsInfo != null)
    {
      paramSnsInfo = t.uB(paramSnsInfo.field_snsId) + "_" + paramInt;
      if (!this.QGw.contains(paramSnsInfo)) {
        this.QGw.add(paramSnsInfo);
      }
    }
    AppMethodBeat.o(96243);
  }
  
  public final void h(SnsInfo paramSnsInfo, int paramInt)
  {
    AppMethodBeat.i(96244);
    if (paramSnsInfo != null)
    {
      paramSnsInfo = t.uB(paramSnsInfo.field_snsId) + "_" + paramInt;
      if (!this.QGx.contains(paramSnsInfo)) {
        this.QGx.add(paramSnsInfo);
      }
    }
    AppMethodBeat.o(96244);
  }
  
  /* Error */
  public final void hil()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 936
    //   5: invokestatic 117	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 140	com/tencent/mm/plugin/sns/statistics/j:QFX	I
    //   12: ifgt +12 -> 24
    //   15: ldc_w 936
    //   18: invokestatic 133	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: new 8	com/tencent/mm/plugin/sns/statistics/j$1
    //   27: dup
    //   28: aload_0
    //   29: aload_0
    //   30: getfield 378	com/tencent/mm/plugin/sns/statistics/j:QFW	Ljava/util/LinkedHashMap;
    //   33: invokevirtual 939	java/util/LinkedHashMap:clone	()Ljava/lang/Object;
    //   36: checkcast 360	java/util/LinkedHashMap
    //   39: invokespecial 942	com/tencent/mm/plugin/sns/statistics/j$1:<init>	(Lcom/tencent/mm/plugin/sns/statistics/j;Ljava/util/LinkedHashMap;)V
    //   42: ldc_w 944
    //   45: invokestatic 950	com/tencent/mm/sdk/thread/ThreadPool:post	(Ljava/lang/Runnable;Ljava/lang/String;)V
    //   48: ldc_w 936
    //   51: invokestatic 133	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   54: goto -33 -> 21
    //   57: astore_1
    //   58: aload_0
    //   59: monitorexit
    //   60: aload_1
    //   61: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	62	0	this	j
    //   57	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	21	57	finally
    //   24	54	57	finally
  }
  
  public final LinkedList<Long> him()
  {
    try
    {
      AppMethodBeat.i(96218);
      Object localObject3 = (LinkedHashMap)this.QFW.clone();
      if ((((LinkedHashMap)localObject3).size() <= 0) || (this.QFX <= 0))
      {
        localObject1 = null;
        AppMethodBeat.o(96218);
        return localObject1;
      }
      Object localObject1 = new LinkedList();
      int i = 0;
      localObject3 = ((LinkedHashMap)localObject3).keySet().iterator();
      for (;;)
      {
        if (((Iterator)localObject3).hasNext())
        {
          ((LinkedList)localObject1).addFirst((Long)((Iterator)localObject3).next());
          i += 1;
          if (i > this.QFX) {
            ((LinkedList)localObject1).removeLast();
          }
        }
        else
        {
          AppMethodBeat.o(96218);
          break;
        }
      }
    }
    finally {}
  }
  
  public final void hin()
  {
    AppMethodBeat.i(96219);
    if ((this.QGd != null) && (this.QGd.joX != -1))
    {
      Object localObject1 = this.QGd;
      ((pv)localObject1).jpm = ((pv)localObject1).F("MediaEditedPublishIds", t.heT(), true);
      Object localObject2 = new StringBuilder();
      localObject1 = new StringBuilder();
      Object localObject3 = this.QGe.entrySet().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject3).next();
        ((StringBuilder)localObject2).append((String)localEntry.getKey()).append("|");
        ((StringBuilder)localObject1).append(localEntry.getValue()).append("|");
      }
      int i = ((StringBuilder)localObject2).lastIndexOf("|");
      int j = ((StringBuilder)localObject1).lastIndexOf("|");
      if (i != -1)
      {
        localObject3 = this.QGd;
        ((pv)localObject3).joZ = ((pv)localObject3).F("ChatroomMemClickList", ((StringBuilder)localObject2).substring(0, i), true);
      }
      if (j != -1)
      {
        localObject2 = this.QGd;
        ((pv)localObject2).jpk = ((pv)localObject2).F("ChatroomMemClickNumList", ((StringBuilder)localObject1).substring(0, j), true);
      }
      this.QGd.bMH();
      this.QGd = new pv();
      this.QGe.clear();
    }
    AppMethodBeat.o(96219);
  }
  
  public final void hio()
  {
    AppMethodBeat.i(96233);
    this.QGi.clear();
    this.QGj.clear();
    this.QGk.clear();
    this.QGl.clear();
    this.QGm.clear();
    this.QGn.clear();
    this.QGo.clear();
    this.QGp = 0L;
    this.QGq = 0L;
    this.QGr = 0L;
    this.QGs = 0L;
    this.QGt = 0L;
    this.QGu = 0L;
    AppMethodBeat.o(96233);
  }
  
  public final ni hip()
  {
    AppMethodBeat.i(96239);
    ni localni2 = (ni)this.QGv.peekLast();
    ni localni1 = localni2;
    if (localni2 == null) {
      localni1 = new ni();
    }
    AppMethodBeat.o(96239);
    return localni1;
  }
  
  public final ni hiq()
  {
    AppMethodBeat.i(96240);
    ni localni = (ni)this.QGv.peekLast();
    AppMethodBeat.o(96240);
    return localni;
  }
  
  public final ni hir()
  {
    AppMethodBeat.i(96241);
    hit();
    ni localni = new ni();
    this.QGv.push(localni);
    AppMethodBeat.o(96241);
    return localni;
  }
  
  public final void his()
  {
    AppMethodBeat.i(96242);
    if (this.QGy != 0L)
    {
      this.QGz += System.currentTimeMillis() - this.QGy;
      this.QGy = 0L;
    }
    AppMethodBeat.o(96242);
  }
  
  public final void hiu()
  {
    AppMethodBeat.i(96246);
    ni localni = hip();
    localni.jeP = this.QGw.size();
    localni.jeQ = this.QGx.size();
    localni.jeR = this.QGB;
    localni.jeS = this.QGz;
    Log.d("MicroMsg.SnsReportHelper", "doSnsAlbumFeedBehaviourReport:\n %s", new Object[] { localni.aIF() });
    localni.bMH();
    try
    {
      this.QGv.removeLast();
      hit();
      AppMethodBeat.o(96246);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.w("MicroMsg.SnsReportHelper", "doSnsAlbumFeedBehaviourReport remove err: %s", new Object[] { localException.getMessage() });
      }
    }
  }
  
  public final void hiv()
  {
    AppMethodBeat.i(306766);
    this.QGE.ioV = 2L;
    this.QGE.bMH();
    this.QGE = new py();
    AppMethodBeat.o(306766);
  }
  
  public final void hiw()
  {
    AppMethodBeat.i(306771);
    this.QGI.bMH();
    this.QGI = new gj();
    AppMethodBeat.o(306771);
  }
  
  public final void hix()
  {
    AppMethodBeat.i(306775);
    this.QGK.bMH();
    this.QGK = new mp();
    AppMethodBeat.o(306775);
  }
  
  public final void kD(List<String> paramList)
  {
    AppMethodBeat.i(96221);
    if ((paramList != null) && (!paramList.isEmpty()) && (this.QGd != null))
    {
      this.QGd.jpe = paramList.size();
      pv localpv = this.QGd;
      localpv.jpf = localpv.F("SelectedUINList", Util.listToString(paramList, "|"), true);
    }
    AppMethodBeat.o(96221);
  }
  
  public final void ls(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(96228);
    Iterator localIterator = QFS.QGf.entrySet().iterator();
    Object localObject = new ArrayList();
    while (localIterator.hasNext())
    {
      b localb = (b)((Map.Entry)localIterator.next()).getValue();
      if ((localb != null) && (localb.QGX != null) && ((localb.position < paramInt1 - 1) || (localb.position > paramInt2)))
      {
        localb.QGX.jgy = System.currentTimeMillis();
        localb.QGX.bMH();
        ((List)localObject).add(localb.QGX.jgm);
      }
    }
    localIterator = ((List)localObject).iterator();
    while (localIterator.hasNext())
    {
      localObject = (String)localIterator.next();
      this.QGf.remove(localObject);
    }
    AppMethodBeat.o(96228);
  }
  
  public final void lt(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(96231);
    Iterator localIterator = this.QGg.entrySet().iterator();
    Object localObject = new ArrayList();
    while (localIterator.hasNext())
    {
      a locala = (a)((Map.Entry)localIterator.next()).getValue();
      if ((locala != null) && (locala.QGU != null) && ((locala.position < paramInt1 - 1) || (locala.position > paramInt2)))
      {
        nn localnn = locala.QGU;
        localnn.jfp = localnn.F("ClickEmojiIconIdList", listToString(locala.QGV, "|"), true);
        localnn = locala.QGU;
        localnn.jfq = localnn.F("ClickEmojiIdList", listToString(locala.QGW, "|"), true);
        locala.QGU.bMH();
        ((List)localObject).add(locala.QGU.iVg);
      }
    }
    localIterator = ((List)localObject).iterator();
    while (localIterator.hasNext())
    {
      localObject = (String)localIterator.next();
      this.QGg.remove(localObject);
    }
    AppMethodBeat.o(96231);
  }
  
  public final void ms(String paramString1, String paramString2)
  {
    AppMethodBeat.i(96214);
    if ((this.mxT == 0) || (Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(96214);
      return;
    }
    this.QFU.put(paramString1, paramString2);
    AppMethodBeat.o(96214);
  }
  
  public final void uY(long paramLong)
  {
    try
    {
      AppMethodBeat.i(96216);
      if (this.QFX > 0) {
        this.QFW.put(Long.valueOf(paramLong), QFR);
      }
      AppMethodBeat.o(96216);
      return;
    }
    finally {}
  }
  
  public final class a
  {
    public nn QGU;
    public List<String> QGV;
    public List<String> QGW;
    public int position;
    
    public a()
    {
      AppMethodBeat.i(96211);
      this.QGV = new ArrayList();
      this.QGW = new ArrayList();
      AppMethodBeat.o(96211);
    }
  }
  
  public final class b
  {
    public nw QGX;
    public int position;
    
    b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.statistics.j
 * JD-Core Version:    0.7.0.1
 */