package com.tencent.mm.plugin.sns.k;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.fp;
import com.tencent.mm.g.b.a.dz;
import com.tencent.mm.g.b.a.ht;
import com.tencent.mm.g.b.a.ih;
import com.tencent.mm.g.b.a.il;
import com.tencent.mm.g.b.a.in;
import com.tencent.mm.g.b.a.io;
import com.tencent.mm.g.b.a.is;
import com.tencent.mm.g.b.a.it;
import com.tencent.mm.g.b.a.iu;
import com.tencent.mm.g.b.a.kb;
import com.tencent.mm.g.b.a.kd;
import com.tencent.mm.g.b.a.ke;
import com.tencent.mm.g.b.a.nk;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.bl;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adp;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.c;
import com.tencent.mm.vending.j.a;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class e
{
  private static final Integer DUP;
  public static e DUQ;
  public long Aqq;
  public HashMap<String, Integer> DUR;
  public HashMap<String, String> DUS;
  public HashSet<String> DUT;
  private LinkedHashMap<Long, Object> DUU;
  private int DUV;
  public String DUW;
  public int DUX;
  public int DUY;
  public int DUZ;
  public ke DVA;
  public String DVB;
  public int DVC;
  public int DVD;
  public dz DVE;
  public int DVF;
  public ht DVG;
  public Map<Long, it> DVH;
  public is DVI;
  public List<Long> DVJ;
  public kb DVa;
  public Map<String, Integer> DVb;
  public Map<String, b> DVc;
  public Map<String, a> DVd;
  public iu DVe;
  public List<String> DVf;
  public List<String> DVg;
  public List<String> DVh;
  public List<String> DVi;
  public List<String> DVj;
  public List<String> DVk;
  public long DVl;
  public long DVm;
  public long DVn;
  public long DVo;
  public long DVp;
  public long DVq;
  private LinkedList<ih> DVr;
  private List<String> DVs;
  private List<String> DVt;
  public long DVu;
  private long DVv;
  public long DVw;
  public long DVx;
  public kd DVy;
  public ke DVz;
  public com.tencent.mm.storage.an gmR;
  public int hmp;
  private IListener<fp> qZd;
  public long viC;
  
  static
  {
    AppMethodBeat.i(96248);
    DUP = Integer.valueOf(1);
    DUQ = new e();
    AppMethodBeat.o(96248);
  }
  
  private e()
  {
    AppMethodBeat.i(96212);
    this.DUV = 0;
    this.DUW = "0";
    this.DUX = -1;
    this.DUY = 200;
    this.DUZ = 86400;
    this.hmp = 0;
    this.qZd = new IListener() {};
    this.DVa = new kb();
    this.DVb = new HashMap();
    this.DVc = new HashMap();
    this.DVd = new HashMap();
    this.DVe = new iu();
    this.DVf = new ArrayList();
    this.DVg = new ArrayList();
    this.DVh = new ArrayList();
    this.DVi = new ArrayList();
    this.DVj = new ArrayList();
    this.DVk = new ArrayList();
    this.DVl = 0L;
    this.DVm = 0L;
    this.DVn = 0L;
    this.DVo = 0L;
    this.DVp = 0L;
    this.DVq = 0L;
    this.DVr = new LinkedList();
    this.DVs = new ArrayList();
    this.DVt = new ArrayList();
    this.DVu = 0L;
    this.DVv = 0L;
    this.DVw = 0L;
    this.DVx = 0L;
    this.DVy = new kd();
    this.DVz = new ke();
    this.DVA = new ke();
    this.DVB = "";
    this.DVC = 0;
    this.Aqq = 0L;
    this.DVD = 0;
    this.DVE = new dz();
    this.DVF = 0;
    this.DVG = new ht();
    this.DVH = new HashMap();
    this.DVI = new is();
    this.DVJ = new ArrayList();
    this.viC = 0L;
    Object localObject1 = com.tencent.mm.model.c.d.aXu().Fu("100077");
    if (((c)localObject1).isValid())
    {
      localObject1 = ((c)localObject1).gzz();
      this.DUY = Util.getInt((String)((Map)localObject1).get("maxCacheFeedCount"), 200);
      this.DUZ = Util.getInt((String)((Map)localObject1).get("maxCacheSeconds"), 86400);
      this.hmp = Util.getInt((String)((Map)localObject1).get("needUploadData"), 0);
    }
    Log.i("MicroMsg.SnsReportHelper", "initAbtestArg maxCacheFeedCount:%d, maxCacheSeconds:%d, needUploadData:%d", new Object[] { Integer.valueOf(this.DUY), Integer.valueOf(this.DUZ), Integer.valueOf(this.hmp) });
    fct();
    this.gmR = new com.tencent.mm.storage.an(ar.NSe + "snsreport.cfg");
    localObject1 = this.gmR.get(3, new HashMap());
    Object localObject2 = this.gmR.get(4, new HashMap());
    Object localObject3 = this.gmR.get(5, new HashSet());
    Object localObject4 = this.gmR.get(6, new LinkedHashMap());
    if ((!(localObject1 instanceof HashMap)) || (!(localObject2 instanceof HashMap)) || (!(localObject3 instanceof HashSet)) || (!(localObject4 instanceof LinkedHashMap)))
    {
      s.deleteFile(ar.NSe + "snsreport.cfg");
      this.gmR.reset();
      this.DUR = new HashMap();
      this.DUS = new HashMap();
      this.DUT = new HashSet();
    }
    for (this.DUU = new LinkedHashMap();; this.DUU = ((LinkedHashMap)localObject4))
    {
      Log.d("MicroMsg.SnsReportHelper", "obj[%d] objForAppId[%d] objForFold[%d] objForAppIdCgi[%d] ", new Object[] { Integer.valueOf(this.DUR.size()), Integer.valueOf(this.DUS.size()), Integer.valueOf(this.DUT.size()), Integer.valueOf(this.DUU.size()) });
      EventCenter.instance.add(this.qZd);
      AppMethodBeat.o(96212);
      return;
      this.DUR = ((HashMap)localObject1);
      this.DUS = ((HashMap)localObject2);
      this.DUT = ((HashSet)localObject3);
    }
  }
  
  public static void a(int paramInt1, String paramString, int paramInt2, int paramInt3, long paramLong, int paramInt4)
  {
    AppMethodBeat.i(202802);
    a(paramInt1, paramString, paramInt2, paramInt3, paramLong, 0L, 0L, paramInt4);
    AppMethodBeat.o(202802);
  }
  
  public static void a(int paramInt1, String paramString, int paramInt2, int paramInt3, long paramLong1, long paramLong2, long paramLong3, int paramInt4)
  {
    AppMethodBeat.i(202803);
    int i;
    if (paramInt4 == 2)
    {
      i = ((Integer)g.aAh().azQ().get(ar.a.Ooe, Integer.valueOf(0))).intValue();
      paramInt3 = 0;
      paramString = "";
    }
    for (;;)
    {
      ((aj)g.ah(aj.class)).snsToFinderPostReport(DUQ.DVB, paramInt1, paramString, paramInt2, paramInt3, i, paramLong2, paramLong3, paramLong1, paramInt4);
      AppMethodBeat.o(202803);
      return;
      i = ((Integer)g.aAh().azQ().get(ar.a.Ood, Integer.valueOf(0))).intValue();
    }
  }
  
  public static void a(SnsObject paramSnsObject, int paramInt, String paramString)
  {
    AppMethodBeat.i(202805);
    int i;
    if (paramSnsObject != null)
    {
      if (!Util.isEqual(paramSnsObject.Username, z.aTY())) {
        break label132;
      }
      if (!Util.isEqual(paramString, z.aTY())) {
        break label127;
      }
      i = 2;
    }
    for (;;)
    {
      int j = paramSnsObject.CommentCount;
      int k = paramSnsObject.LikeCount;
      in localin = new in();
      localin.wk(r.Jc(paramSnsObject.Id));
      localin.wm(String.valueOf(paramInt));
      localin.eOM = i;
      localin.wl(paramString);
      localin.eOP = 1;
      localin.eON = k;
      localin.eOO = j;
      localin.bfK();
      AppMethodBeat.o(202805);
      return;
      label127:
      i = 3;
      continue;
      label132:
      i = 1;
    }
  }
  
  public static void aPQ(String paramString)
  {
    AppMethodBeat.i(96224);
    nk localnk = new nk();
    localnk.Az(paramString);
    localnk.fgC = 1L;
    localnk.fgD = 1L;
    localnk.bfK();
    AppMethodBeat.o(96224);
  }
  
  public static void aPR(String paramString)
  {
    AppMethodBeat.i(96226);
    nk localnk = new nk();
    localnk.Az(paramString);
    localnk.fgC = 3L;
    localnk.fgD = 1L;
    localnk.bfK();
    AppMethodBeat.o(96226);
  }
  
  public static void b(SnsInfo paramSnsInfo, int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(202804);
    int i;
    Object localObject;
    int k;
    int j;
    if (paramSnsInfo != null)
    {
      if (!Util.isEqual(paramSnsInfo.getUserName(), z.aTY())) {
        break label148;
      }
      if (!Util.isEqual(paramString, z.aTY())) {
        break label142;
      }
      i = 2;
      localObject = com.tencent.mm.plugin.sns.model.an.C(paramSnsInfo);
      if (localObject == null) {
        break label154;
      }
      k = ((SnsObject)localObject).CommentCount;
      j = ((SnsObject)localObject).LikeCount;
    }
    for (;;)
    {
      localObject = new in();
      ((in)localObject).wk(r.Jc(paramSnsInfo.field_snsId));
      ((in)localObject).wm(String.valueOf(paramInt1));
      ((in)localObject).eOM = i;
      ((in)localObject).wl(paramString);
      ((in)localObject).eOP = paramInt2;
      ((in)localObject).eON = j;
      ((in)localObject).eOO = k;
      ((in)localObject).bfK();
      AppMethodBeat.o(202804);
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
  
  public static void fG(String paramString, int paramInt)
  {
    AppMethodBeat.i(96225);
    nk localnk = new nk();
    localnk.Az(paramString);
    localnk.fgC = 2L;
    localnk.fgD = paramInt;
    localnk.bfK();
    AppMethodBeat.o(96225);
  }
  
  private void fcC()
  {
    AppMethodBeat.i(96245);
    this.DVs.clear();
    this.DVt.clear();
    this.DVu = 0L;
    this.DVw = 0L;
    this.DVv = 0L;
    this.DVx = 0L;
    AppMethodBeat.o(96245);
  }
  
  private void fct()
  {
    AppMethodBeat.i(96215);
    this.DUV = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rOl, 0);
    Log.i("MicroMsg.SnsReportHelper", "resetXExptControl maxFeedIdForCgiRecord[%d]", new Object[] { Integer.valueOf(this.DUV) });
    AppMethodBeat.o(96215);
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
  
  public final void Jz(long paramLong)
  {
    try
    {
      AppMethodBeat.i(96216);
      if (this.DUV > 0) {
        this.DUU.put(Long.valueOf(paramLong), DUP);
      }
      AppMethodBeat.o(96216);
      return;
    }
    finally {}
  }
  
  public final void N(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(96234);
    if (paramSnsInfo != null)
    {
      paramSnsInfo = r.Jc(paramSnsInfo.field_snsId);
      if (!this.DVf.contains(paramSnsInfo)) {
        this.DVf.add(paramSnsInfo);
      }
    }
    AppMethodBeat.o(96234);
  }
  
  public final void O(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(96235);
    if (paramSnsInfo != null)
    {
      paramSnsInfo = r.Jc(paramSnsInfo.field_snsId);
      if (!this.DVg.contains(paramSnsInfo)) {
        this.DVg.add(paramSnsInfo);
      }
    }
    AppMethodBeat.o(96235);
  }
  
  public final void P(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(96236);
    if (paramSnsInfo != null)
    {
      paramSnsInfo = r.Jc(paramSnsInfo.field_snsId);
      if (!this.DVh.contains(paramSnsInfo)) {
        this.DVh.add(paramSnsInfo);
      }
    }
    AppMethodBeat.o(96236);
  }
  
  public final void YP(int paramInt)
  {
    if (this.DVa != null) {}
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      this.DVa.eTn = 1;
      return;
    case 1: 
      this.DVa.eTn = 2;
      return;
    case 2: 
      this.DVa.eTn = 3;
      return;
    }
    this.DVa.eTn = 4;
  }
  
  public final void YQ(int paramInt)
  {
    AppMethodBeat.i(202808);
    Iterator localIterator = this.DVH.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      it localit = (it)localEntry.getValue();
      if (localit != null)
      {
        localit.ePI = paramInt;
        ((it)localEntry.getValue()).bfK();
      }
    }
    this.DVH.clear();
    AppMethodBeat.o(202808);
  }
  
  public final void a(View paramView, bl parambl, String paramString1, String paramString2, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(96227);
    String str;
    int i;
    if ((paramView != null) && (parambl != null) && (parambl.Dsr != null) && (parambl.DqO != null) && (parambl.DqO.getTimeLine() != null) && (parambl.DqO.getTimeLine().ContentObj != null) && (this.DVc.get(r.Jb(parambl.DqO.field_snsId)) == null))
    {
      str = z.aTY();
      paramView = new io();
      paramView.etW = paramView.x("Username", parambl.DqO.getUserName(), true);
      paramView.eOQ = paramView.x("PublicID", r.Jb(parambl.DqO.field_snsId), true);
      paramView.eOR = parambl.DqO.getTimeLine().ContentObj.LoU;
      i = 0;
      paramString1 = paramString1.split(",");
      if (paramString1 != null) {
        i = paramString1.length;
      }
      paramView.eOS = i;
      i = 0;
      paramString1 = paramString2.split(",");
      if (paramString1 != null) {
        i = paramString1.length;
      }
      paramView.eOT = i;
      paramView.eOU = paramInt1;
      paramView.eOV = paramInt2;
      if (!paramBoolean) {
        break label434;
      }
      paramView.eOW = 1L;
      if (parambl.EOd == null) {
        break label468;
      }
      paramInt1 = 0;
      label232:
      if (paramInt1 >= parambl.EOd.size()) {
        break label468;
      }
      if (!Util.isEqual(str, (String)((a)parambl.EOd.get(paramInt1)).get(0))) {
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
      if (parambl.EOe != null) {
        i = 0;
      }
      for (;;)
      {
        paramInt2 = paramInt1;
        if (i < parambl.EOe.size())
        {
          paramString1 = (a)parambl.EOe.get(i);
          if ((!(paramString1.get(1) instanceof String)) || (!Util.isEqual(str, (String)paramString1.get(1)))) {
            break label459;
          }
          if (paramInt1 != 1) {
            break label453;
          }
        }
        for (paramInt2 = 3;; paramInt2 = 2)
        {
          paramView.eOX = parambl.EOe.size();
          paramView.ePa = paramInt2;
          paramView.ePi = paramInt4;
          paramView.ePc = System.currentTimeMillis();
          paramString1 = new b();
          paramString1.position = paramInt3;
          paramString1.DVQ = paramView;
          this.DVc.put(r.Jb(parambl.DqO.field_snsId), paramString1);
          AppMethodBeat.o(96227);
          return;
          paramView.eOW = 2L;
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
    AppMethodBeat.i(202809);
    this.viC = System.currentTimeMillis();
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = paramList.iterator();
    while (((Iterator)localObject).hasNext()) {
      localStringBuilder.append(r.Jc(((Long)((Iterator)localObject).next()).longValue())).append("#");
    }
    localObject = this.DVI;
    ((is)localObject).ePD = ((is)localObject).x("FeedList", localStringBuilder.toString(), true);
    this.DVI.ePB = paramList.size();
    this.DVI.ws(r.Jc(paramLong));
    this.DVI.ws(r.Jc(paramLong));
    paramList = this.DVI;
    paramList.eoK = paramList.x("UserName", paramString, true);
    AppMethodBeat.o(202809);
  }
  
  public final void aO(Map<String, List<String>> paramMap)
  {
    AppMethodBeat.i(96220);
    if ((paramMap != null) && (!paramMap.isEmpty()) && (this.DVa != null))
    {
      this.DVa.eTr = paramMap.keySet().size();
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
      paramMap = this.DVa;
      paramMap.eTs = paramMap.x("SelectedChatroomList", localStringBuilder.toString(), true);
    }
    AppMethodBeat.o(96220);
  }
  
  public final void aP(Map<String, List<String>> paramMap)
  {
    AppMethodBeat.i(96222);
    if ((paramMap != null) && (!paramMap.isEmpty()) && (this.DVa != null))
    {
      this.DVa.eTx = paramMap.keySet().size();
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
      paramMap = this.DVa;
      paramMap.eTy = paramMap.x("SelectedLabelList", localStringBuilder.toString(), true);
    }
    AppMethodBeat.o(96222);
  }
  
  public final void c(SnsInfo paramSnsInfo, int paramInt)
  {
    AppMethodBeat.i(96237);
    if (paramSnsInfo != null)
    {
      paramSnsInfo = r.Jc(paramSnsInfo.field_snsId) + "_" + paramInt;
      if (!this.DVi.contains(paramSnsInfo)) {
        this.DVi.add(paramSnsInfo);
      }
    }
    AppMethodBeat.o(96237);
  }
  
  public final void ck(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(96213);
    if (this.hmp == 0)
    {
      AppMethodBeat.o(96213);
      return;
    }
    HashMap localHashMap = this.DUR;
    if (this.DUR.containsKey(paramString)) {}
    for (int i = ((Integer)this.DUR.get(paramString)).intValue() + 1;; i = 1)
    {
      localHashMap.put(paramString, Integer.valueOf(i));
      if (paramBoolean) {
        this.DUT.add(paramString);
      }
      AppMethodBeat.o(96213);
      return;
    }
  }
  
  public final void cl(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(96229);
    if (paramString != null)
    {
      paramString = (b)this.DVc.get(paramString);
      if ((paramString != null) && (paramString.DVQ != null))
      {
        if (paramBoolean)
        {
          paramString.DVQ.eOY = 1L;
          AppMethodBeat.o(96229);
          return;
        }
        paramString.DVQ.eOY = 3L;
      }
    }
    AppMethodBeat.o(96229);
  }
  
  public final void cm(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(96230);
    if (paramString != null)
    {
      paramString = (b)this.DVc.get(paramString);
      if ((paramString != null) && (paramString.DVQ != null))
      {
        if (paramBoolean)
        {
          paramString.DVQ.ePb = 1L;
          AppMethodBeat.o(96230);
          return;
        }
        paramString.DVQ.ePj = 1L;
      }
    }
    AppMethodBeat.o(96230);
  }
  
  public final void d(SnsInfo paramSnsInfo, int paramInt)
  {
    AppMethodBeat.i(96238);
    if (paramSnsInfo != null)
    {
      paramSnsInfo = r.Jc(paramSnsInfo.field_snsId) + "_" + paramInt;
      if (!this.DVk.contains(paramSnsInfo)) {
        this.DVk.add(paramSnsInfo);
      }
    }
    AppMethodBeat.o(96238);
  }
  
  public final void e(SnsInfo paramSnsInfo, int paramInt)
  {
    AppMethodBeat.i(96243);
    if (paramSnsInfo != null)
    {
      paramSnsInfo = r.Jc(paramSnsInfo.field_snsId) + "_" + paramInt;
      if (!this.DVs.contains(paramSnsInfo)) {
        this.DVs.add(paramSnsInfo);
      }
    }
    AppMethodBeat.o(96243);
  }
  
  public final void f(SnsInfo paramSnsInfo, int paramInt)
  {
    AppMethodBeat.i(96244);
    if (paramSnsInfo != null)
    {
      paramSnsInfo = r.Jc(paramSnsInfo.field_snsId) + "_" + paramInt;
      if (!this.DVt.contains(paramSnsInfo)) {
        this.DVt.add(paramSnsInfo);
      }
    }
    AppMethodBeat.o(96244);
  }
  
  public final ih fcA()
  {
    AppMethodBeat.i(96241);
    fcC();
    ih localih = new ih();
    this.DVr.push(localih);
    AppMethodBeat.o(96241);
    return localih;
  }
  
  public final void fcB()
  {
    AppMethodBeat.i(96242);
    if (this.DVu != 0L)
    {
      this.DVv += System.currentTimeMillis() - this.DVu;
      this.DVu = 0L;
    }
    AppMethodBeat.o(96242);
  }
  
  public final void fcD()
  {
    AppMethodBeat.i(96246);
    ih localih = fcy();
    localih.eOu = this.DVs.size();
    localih.eOv = this.DVt.size();
    localih.eOw = this.DVx;
    localih.eOx = this.DVv;
    Log.d("MicroMsg.SnsReportHelper", "doSnsAlbumFeedBehaviourReport:\n %s", new Object[] { localih.abW() });
    localih.bfK();
    try
    {
      this.DVr.removeLast();
      fcC();
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
  
  public final void fcE()
  {
    AppMethodBeat.i(202801);
    this.DVA.enl = 2L;
    this.DVA.bfK();
    this.DVA = new ke();
    AppMethodBeat.o(202801);
  }
  
  public final void fcF()
  {
    AppMethodBeat.i(202806);
    this.DVE.bfK();
    this.DVE = new dz();
    AppMethodBeat.o(202806);
  }
  
  public final void fcG()
  {
    AppMethodBeat.i(202807);
    this.DVG.bfK();
    this.DVG = new ht();
    AppMethodBeat.o(202807);
  }
  
  /* Error */
  public final void fcu()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 908
    //   5: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 130	com/tencent/mm/plugin/sns/k/e:DUV	I
    //   12: ifgt +12 -> 24
    //   15: ldc_w 908
    //   18: invokestatic 125	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: new 6	com/tencent/mm/plugin/sns/k/e$1
    //   27: dup
    //   28: aload_0
    //   29: aload_0
    //   30: getfield 363	com/tencent/mm/plugin/sns/k/e:DUU	Ljava/util/LinkedHashMap;
    //   33: invokevirtual 911	java/util/LinkedHashMap:clone	()Ljava/lang/Object;
    //   36: checkcast 345	java/util/LinkedHashMap
    //   39: invokespecial 914	com/tencent/mm/plugin/sns/k/e$1:<init>	(Lcom/tencent/mm/plugin/sns/k/e;Ljava/util/LinkedHashMap;)V
    //   42: ldc_w 916
    //   45: invokestatic 922	com/tencent/mm/sdk/thread/ThreadPool:post	(Ljava/lang/Runnable;Ljava/lang/String;)V
    //   48: ldc_w 908
    //   51: invokestatic 125	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   54: goto -33 -> 21
    //   57: astore_1
    //   58: aload_0
    //   59: monitorexit
    //   60: aload_1
    //   61: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	62	0	this	e
    //   57	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	21	57	finally
    //   24	54	57	finally
  }
  
  public final LinkedList<Long> fcv()
  {
    try
    {
      AppMethodBeat.i(96218);
      Object localObject3 = (LinkedHashMap)this.DUU.clone();
      if ((((LinkedHashMap)localObject3).size() <= 0) || (this.DUV <= 0))
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
          if (i > this.DUV) {
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
  
  public final void fcw()
  {
    AppMethodBeat.i(96219);
    if ((this.DVa != null) && (this.DVa.eTn != -1))
    {
      Object localObject1 = this.DVa;
      ((kb)localObject1).eTC = ((kb)localObject1).x("MediaEditedPublishIds", r.eZz(), true);
      Object localObject2 = new StringBuilder();
      localObject1 = new StringBuilder();
      Object localObject3 = this.DVb.entrySet().iterator();
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
        localObject3 = this.DVa;
        ((kb)localObject3).eTp = ((kb)localObject3).x("ChatroomMemClickList", ((StringBuilder)localObject2).substring(0, i), true);
      }
      if (j != -1)
      {
        localObject2 = this.DVa;
        ((kb)localObject2).eTA = ((kb)localObject2).x("ChatroomMemClickNumList", ((StringBuilder)localObject1).substring(0, j), true);
      }
      this.DVa.bfK();
      this.DVa = new kb();
      this.DVb.clear();
    }
    AppMethodBeat.o(96219);
  }
  
  public final void fcx()
  {
    AppMethodBeat.i(96233);
    this.DVf.clear();
    this.DVg.clear();
    this.DVh.clear();
    this.DVi.clear();
    this.DVj.clear();
    this.DVk.clear();
    this.DVl = 0L;
    this.DVm = 0L;
    this.DVn = 0L;
    this.DVo = 0L;
    this.DVp = 0L;
    this.DVq = 0L;
    AppMethodBeat.o(96233);
  }
  
  public final ih fcy()
  {
    AppMethodBeat.i(96239);
    ih localih2 = (ih)this.DVr.peekLast();
    ih localih1 = localih2;
    if (localih2 == null) {
      localih1 = new ih();
    }
    AppMethodBeat.o(96239);
    return localih1;
  }
  
  public final ih fcz()
  {
    AppMethodBeat.i(96240);
    ih localih = (ih)this.DVr.peekLast();
    AppMethodBeat.o(96240);
    return localih;
  }
  
  public final void gT(List<String> paramList)
  {
    AppMethodBeat.i(96221);
    if ((paramList != null) && (!paramList.isEmpty()) && (this.DVa != null))
    {
      this.DVa.eTu = paramList.size();
      kb localkb = this.DVa;
      localkb.eTv = localkb.x("SelectedUINList", Util.listToString(paramList, "|"), true);
    }
    AppMethodBeat.o(96221);
  }
  
  public final void ix(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(96228);
    Iterator localIterator = DUQ.DVc.entrySet().iterator();
    Object localObject = new ArrayList();
    while (localIterator.hasNext())
    {
      b localb = (b)((Map.Entry)localIterator.next()).getValue();
      if ((localb != null) && (localb.DVQ != null) && ((localb.position < paramInt1 - 1) || (localb.position > paramInt2)))
      {
        localb.DVQ.ePd = System.currentTimeMillis();
        localb.DVQ.bfK();
        ((List)localObject).add(localb.DVQ.eOQ);
      }
    }
    localIterator = ((List)localObject).iterator();
    while (localIterator.hasNext())
    {
      localObject = (String)localIterator.next();
      this.DVc.remove(localObject);
    }
    AppMethodBeat.o(96228);
  }
  
  public final void iy(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(96231);
    Iterator localIterator = this.DVd.entrySet().iterator();
    Object localObject = new ArrayList();
    while (localIterator.hasNext())
    {
      a locala = (a)((Map.Entry)localIterator.next()).getValue();
      if ((locala != null) && (locala.DVN != null) && ((locala.position < paramInt1 - 1) || (locala.position > paramInt2)))
      {
        il localil = locala.DVN;
        localil.eOJ = localil.x("ClickEmojiIconIdList", listToString(locala.DVO, "|"), true);
        localil = locala.DVN;
        localil.eOK = localil.x("ClickEmojiIdList", listToString(locala.DVP, "|"), true);
        locala.DVN.bfK();
        ((List)localObject).add(locala.DVN.eOG);
      }
    }
    localIterator = ((List)localObject).iterator();
    while (localIterator.hasNext())
    {
      localObject = (String)localIterator.next();
      this.DVd.remove(localObject);
    }
    AppMethodBeat.o(96231);
  }
  
  public final void kq(String paramString1, String paramString2)
  {
    AppMethodBeat.i(96214);
    if ((this.hmp == 0) || (Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(96214);
      return;
    }
    this.DUS.put(paramString1, paramString2);
    AppMethodBeat.o(96214);
  }
  
  public final class a
  {
    public il DVN;
    public List<String> DVO;
    public List<String> DVP;
    public int position;
    
    public a()
    {
      AppMethodBeat.i(96211);
      this.DVO = new ArrayList();
      this.DVP = new ArrayList();
      AppMethodBeat.o(96211);
    }
  }
  
  public final class b
  {
    public io DVQ;
    public int position;
    
    b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.k.e
 * JD-Core Version:    0.7.0.1
 */