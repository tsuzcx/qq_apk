package com.tencent.mm.plugin.sns.j;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.fl;
import com.tencent.mm.g.b.a.ew;
import com.tencent.mm.g.b.a.ey;
import com.tencent.mm.g.b.a.fa;
import com.tencent.mm.g.b.a.fb;
import com.tencent.mm.g.b.a.ff;
import com.tencent.mm.g.b.a.gl;
import com.tencent.mm.g.b.a.gn;
import com.tencent.mm.g.b.a.go;
import com.tencent.mm.g.b.a.jk;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.i.a.t;
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.plugin.sns.model.ak;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.ui.bi;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.vfs.i;
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
  private static final Integer zty;
  public static e ztz;
  public ah fFB;
  public int gwV;
  private com.tencent.mm.sdk.b.c<fl> ssq;
  public HashMap<String, Integer> ztA;
  public HashMap<String, String> ztB;
  public HashSet<String> ztC;
  private LinkedHashMap<Long, Object> ztD;
  private int ztE;
  public int ztF;
  public int ztG;
  public gl ztH;
  public Map<String, Integer> ztI;
  public Map<String, b> ztJ;
  public Map<String, a> ztK;
  public ff ztL;
  public List<String> ztM;
  public List<String> ztN;
  public List<String> ztO;
  public List<String> ztP;
  public List<String> ztQ;
  public List<String> ztR;
  public long ztS;
  public long ztT;
  public long ztU;
  public long ztV;
  public long ztW;
  public long ztX;
  private LinkedList<ew> ztY;
  private List<String> ztZ;
  private List<String> zua;
  public long zub;
  private long zuc;
  public long zud;
  public long zue;
  public gn zuf;
  public go zug;
  public go zuh;
  public String zui;
  public int zuj;
  public long zuk;
  
  static
  {
    AppMethodBeat.i(96248);
    zty = Integer.valueOf(1);
    ztz = new e();
    AppMethodBeat.o(96248);
  }
  
  private e()
  {
    AppMethodBeat.i(96212);
    this.ztE = 0;
    this.ztF = 200;
    this.ztG = 86400;
    this.gwV = 0;
    this.ssq = new com.tencent.mm.sdk.b.c() {};
    this.ztH = new gl();
    this.ztI = new HashMap();
    this.ztJ = new HashMap();
    this.ztK = new HashMap();
    this.ztL = new ff();
    this.ztM = new ArrayList();
    this.ztN = new ArrayList();
    this.ztO = new ArrayList();
    this.ztP = new ArrayList();
    this.ztQ = new ArrayList();
    this.ztR = new ArrayList();
    this.ztS = 0L;
    this.ztT = 0L;
    this.ztU = 0L;
    this.ztV = 0L;
    this.ztW = 0L;
    this.ztX = 0L;
    this.ztY = new LinkedList();
    this.ztZ = new ArrayList();
    this.zua = new ArrayList();
    this.zub = 0L;
    this.zuc = 0L;
    this.zud = 0L;
    this.zue = 0L;
    this.zuf = new gn();
    this.zug = new go();
    this.zuh = new go();
    this.zui = "";
    this.zuj = 0;
    this.zuk = 0L;
    Object localObject1 = com.tencent.mm.model.c.d.aDs().wz("100077");
    if (((com.tencent.mm.storage.c)localObject1).isValid())
    {
      localObject1 = ((com.tencent.mm.storage.c)localObject1).foF();
      this.ztF = bt.getInt((String)((Map)localObject1).get("maxCacheFeedCount"), 200);
      this.ztG = bt.getInt((String)((Map)localObject1).get("maxCacheSeconds"), 86400);
      this.gwV = bt.getInt((String)((Map)localObject1).get("needUploadData"), 0);
    }
    ad.i("MicroMsg.SnsReportHelper", "initAbtestArg maxCacheFeedCount:%d, maxCacheSeconds:%d, needUploadData:%d", new Object[] { Integer.valueOf(this.ztF), Integer.valueOf(this.ztG), Integer.valueOf(this.gwV) });
    dVE();
    this.fFB = new ah(al.IpN + "snsreport.cfg");
    localObject1 = this.fFB.get(3, new HashMap());
    Object localObject2 = this.fFB.get(4, new HashMap());
    Object localObject3 = this.fFB.get(5, new HashSet());
    Object localObject4 = this.fFB.get(6, new LinkedHashMap());
    if ((!(localObject1 instanceof HashMap)) || (!(localObject2 instanceof HashMap)) || (!(localObject3 instanceof HashSet)) || (!(localObject4 instanceof LinkedHashMap)))
    {
      i.deleteFile(al.IpN + "snsreport.cfg");
      this.fFB.reset();
      this.ztA = new HashMap();
      this.ztB = new HashMap();
      this.ztC = new HashSet();
    }
    for (this.ztD = new LinkedHashMap();; this.ztD = ((LinkedHashMap)localObject4))
    {
      ad.d("MicroMsg.SnsReportHelper", "obj[%d] objForAppId[%d] objForFold[%d] objForAppIdCgi[%d] ", new Object[] { Integer.valueOf(this.ztA.size()), Integer.valueOf(this.ztB.size()), Integer.valueOf(this.ztC.size()), Integer.valueOf(this.ztD.size()) });
      com.tencent.mm.sdk.b.a.IbL.b(this.ssq);
      AppMethodBeat.o(96212);
      return;
      this.ztA = ((HashMap)localObject1);
      this.ztB = ((HashMap)localObject2);
      this.ztC = ((HashSet)localObject3);
    }
  }
  
  public static void a(int paramInt1, String paramString, int paramInt2, int paramInt3, long paramLong)
  {
    AppMethodBeat.i(197871);
    a(paramInt1, paramString, paramInt2, paramInt3, paramLong, 0L, 0L);
    AppMethodBeat.o(197871);
  }
  
  public static void a(int paramInt1, String paramString, int paramInt2, int paramInt3, long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(197872);
    t localt = (t)g.ad(t.class);
    String str = ztz.zui;
    g.ajD();
    localt.snsToFinderPostReport(str, paramInt1, paramString, paramInt2, paramInt3, ((Integer)g.ajC().ajl().get(al.a.IJP, Integer.valueOf(0))).intValue(), paramLong2, paramLong3, paramLong1);
    AppMethodBeat.o(197872);
  }
  
  public static void a(SnsObject paramSnsObject, int paramInt, String paramString)
  {
    AppMethodBeat.i(197874);
    int i;
    if (paramSnsObject != null)
    {
      if (!bt.lQ(paramSnsObject.Username, u.aAm())) {
        break label132;
      }
      if (!bt.lQ(paramString, u.aAm())) {
        break label127;
      }
      i = 2;
    }
    for (;;)
    {
      int j = paramSnsObject.CommentCount;
      int k = paramSnsObject.LikeCount;
      fa localfa = new fa();
      localfa.oh(q.zx(paramSnsObject.Id));
      localfa.oj(String.valueOf(paramInt));
      localfa.ejF = i;
      localfa.oi(paramString);
      localfa.ejI = 1;
      localfa.ejG = k;
      localfa.ejH = j;
      localfa.aLk();
      AppMethodBeat.o(197874);
      return;
      label127:
      i = 3;
      continue;
      label132:
      i = 1;
    }
  }
  
  public static void azF(String paramString)
  {
    AppMethodBeat.i(96224);
    jk localjk = new jk();
    localjk.rT(paramString);
    localjk.eAs = 1L;
    localjk.eAt = 1L;
    localjk.aLk();
    AppMethodBeat.o(96224);
  }
  
  public static void azG(String paramString)
  {
    AppMethodBeat.i(96226);
    jk localjk = new jk();
    localjk.rT(paramString);
    localjk.eAs = 3L;
    localjk.eAt = 1L;
    localjk.aLk();
    AppMethodBeat.o(96226);
  }
  
  public static void b(p paramp, int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(197873);
    int i;
    Object localObject;
    int k;
    int j;
    if (paramp != null)
    {
      if (!bt.lQ(paramp.field_userName, u.aAm())) {
        break label148;
      }
      if (!bt.lQ(paramString, u.aAm())) {
        break label142;
      }
      i = 2;
      localObject = ak.v(paramp);
      if (localObject == null) {
        break label154;
      }
      k = ((SnsObject)localObject).CommentCount;
      j = ((SnsObject)localObject).LikeCount;
    }
    for (;;)
    {
      localObject = new fa();
      ((fa)localObject).oh(q.zx(paramp.field_snsId));
      ((fa)localObject).oj(String.valueOf(paramInt1));
      ((fa)localObject).ejF = i;
      ((fa)localObject).oi(paramString);
      ((fa)localObject).ejI = paramInt2;
      ((fa)localObject).ejG = j;
      ((fa)localObject).ejH = k;
      ((fa)localObject).aLk();
      AppMethodBeat.o(197873);
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
  
  private void dVE()
  {
    AppMethodBeat.i(96215);
    this.ztE = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qpT, 0);
    ad.i("MicroMsg.SnsReportHelper", "resetXExptControl maxFeedIdForCgiRecord[%d]", new Object[] { Integer.valueOf(this.ztE) });
    AppMethodBeat.o(96215);
  }
  
  private void dVN()
  {
    AppMethodBeat.i(96245);
    this.ztZ.clear();
    this.zua.clear();
    this.zub = 0L;
    this.zud = 0L;
    this.zuc = 0L;
    this.zue = 0L;
    AppMethodBeat.o(96245);
  }
  
  public static void eZ(String paramString, int paramInt)
  {
    AppMethodBeat.i(96225);
    jk localjk = new jk();
    localjk.rT(paramString);
    localjk.eAs = 2L;
    localjk.eAt = paramInt;
    localjk.aLk();
    AppMethodBeat.o(96225);
  }
  
  private static <T> String m(List<T> paramList, String paramString)
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
  
  public final void G(p paramp)
  {
    AppMethodBeat.i(96234);
    if (paramp != null)
    {
      paramp = q.zx(paramp.field_snsId);
      if (!this.ztM.contains(paramp)) {
        this.ztM.add(paramp);
      }
    }
    AppMethodBeat.o(96234);
  }
  
  public final void H(p paramp)
  {
    AppMethodBeat.i(96235);
    if (paramp != null)
    {
      paramp = q.zx(paramp.field_snsId);
      if (!this.ztN.contains(paramp)) {
        this.ztN.add(paramp);
      }
    }
    AppMethodBeat.o(96235);
  }
  
  public final void I(p paramp)
  {
    AppMethodBeat.i(96236);
    if (paramp != null)
    {
      paramp = q.zx(paramp.field_snsId);
      if (!this.ztO.contains(paramp)) {
        this.ztO.add(paramp);
      }
    }
    AppMethodBeat.o(96236);
  }
  
  public final void Ql(int paramInt)
  {
    if (this.ztH != null) {}
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      this.ztH.eoc = 1;
      return;
    case 1: 
      this.ztH.eoc = 2;
      return;
    case 2: 
      this.ztH.eoc = 3;
      return;
    }
    this.ztH.eoc = 4;
  }
  
  public final void a(View paramView, bi parambi, String paramString1, String paramString2, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(96227);
    String str;
    int i;
    if ((paramView != null) && (parambi != null) && (parambi.AmA != null) && (parambi.yVM != null) && (parambi.yVM.dYl() != null) && (parambi.yVM.dYl().HAT != null) && (this.ztJ.get(q.zw(parambi.yVM.field_snsId)) == null))
    {
      str = u.aAm();
      paramView = new fb();
      paramView.dWK = paramView.t("Username", parambi.yVM.field_userName, true);
      paramView.ejJ = paramView.t("PublicID", q.zw(parambi.yVM.field_snsId), true);
      paramView.ejK = parambi.yVM.dYl().HAT.GaP;
      i = 0;
      paramString1 = paramString1.split(",");
      if (paramString1 != null) {
        i = paramString1.length;
      }
      paramView.ejL = i;
      i = 0;
      paramString1 = paramString2.split(",");
      if (paramString1 != null) {
        i = paramString1.length;
      }
      paramView.ejM = i;
      paramView.ejN = paramInt1;
      paramView.ejO = paramInt2;
      if (!paramBoolean) {
        break label434;
      }
      paramView.ejP = 1L;
      if (parambi.Ano == null) {
        break label468;
      }
      paramInt1 = 0;
      label232:
      if (paramInt1 >= parambi.Ano.size()) {
        break label468;
      }
      if (!bt.lQ(str, (String)((com.tencent.mm.vending.j.a)parambi.Ano.get(paramInt1)).get(0))) {
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
      if (parambi.Anp != null) {
        i = 0;
      }
      for (;;)
      {
        paramInt2 = paramInt1;
        if (i < parambi.Anp.size())
        {
          paramString1 = (com.tencent.mm.vending.j.a)parambi.Anp.get(i);
          if ((!(paramString1.get(1) instanceof String)) || (!bt.lQ(str, (String)paramString1.get(1)))) {
            break label459;
          }
          if (paramInt1 != 1) {
            break label453;
          }
        }
        for (paramInt2 = 3;; paramInt2 = 2)
        {
          paramView.ejQ = parambi.Anp.size();
          paramView.ejT = paramInt2;
          paramView.ekb = paramInt4;
          paramView.ejV = System.currentTimeMillis();
          paramString1 = new b();
          paramString1.position = paramInt3;
          paramString1.zur = paramView;
          this.ztJ.put(q.zw(parambi.yVM.field_snsId), paramString1);
          AppMethodBeat.o(96227);
          return;
          paramView.ejP = 2L;
          break;
          paramInt1 += 1;
          break label232;
        }
        i += 1;
      }
    }
  }
  
  public final void aJ(Map<String, List<String>> paramMap)
  {
    AppMethodBeat.i(96220);
    if ((paramMap != null) && (!paramMap.isEmpty()) && (this.ztH != null))
    {
      this.ztH.eoh = paramMap.keySet().size();
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
      paramMap = this.ztH;
      paramMap.eoi = paramMap.t("SelectedChatroomList", localStringBuilder.toString(), true);
    }
    AppMethodBeat.o(96220);
  }
  
  public final void aK(Map<String, List<String>> paramMap)
  {
    AppMethodBeat.i(96222);
    if ((paramMap != null) && (!paramMap.isEmpty()) && (this.ztH != null))
    {
      this.ztH.eon = paramMap.keySet().size();
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
      paramMap = this.ztH;
      paramMap.eoo = paramMap.t("SelectedLabelList", localStringBuilder.toString(), true);
    }
    AppMethodBeat.o(96222);
  }
  
  public final void bO(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(96213);
    if (this.gwV == 0)
    {
      AppMethodBeat.o(96213);
      return;
    }
    HashMap localHashMap = this.ztA;
    if (this.ztA.containsKey(paramString)) {}
    for (int i = ((Integer)this.ztA.get(paramString)).intValue() + 1;; i = 1)
    {
      localHashMap.put(paramString, Integer.valueOf(i));
      if (paramBoolean) {
        this.ztC.add(paramString);
      }
      AppMethodBeat.o(96213);
      return;
    }
  }
  
  public final void bP(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(96229);
    if (paramString != null)
    {
      paramString = (b)this.ztJ.get(paramString);
      if ((paramString != null) && (paramString.zur != null))
      {
        if (paramBoolean)
        {
          paramString.zur.ejR = 1L;
          AppMethodBeat.o(96229);
          return;
        }
        paramString.zur.ejR = 3L;
      }
    }
    AppMethodBeat.o(96229);
  }
  
  public final void bQ(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(96230);
    if (paramString != null)
    {
      paramString = (b)this.ztJ.get(paramString);
      if ((paramString != null) && (paramString.zur != null))
      {
        if (paramBoolean)
        {
          paramString.zur.ejU = 1L;
          AppMethodBeat.o(96230);
          return;
        }
        paramString.zur.ekc = 1L;
      }
    }
    AppMethodBeat.o(96230);
  }
  
  public final void c(p paramp, int paramInt)
  {
    AppMethodBeat.i(96237);
    if (paramp != null)
    {
      paramp = q.zx(paramp.field_snsId) + "_" + paramInt;
      if (!this.ztP.contains(paramp)) {
        this.ztP.add(paramp);
      }
    }
    AppMethodBeat.o(96237);
  }
  
  public final void d(p paramp, int paramInt)
  {
    AppMethodBeat.i(96238);
    if (paramp != null)
    {
      paramp = q.zx(paramp.field_snsId) + "_" + paramInt;
      if (!this.ztR.contains(paramp)) {
        this.ztR.add(paramp);
      }
    }
    AppMethodBeat.o(96238);
  }
  
  /* Error */
  public final void dVF()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 751
    //   5: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 115	com/tencent/mm/plugin/sns/j/e:ztE	I
    //   12: ifgt +12 -> 24
    //   15: ldc_w 751
    //   18: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: new 6	com/tencent/mm/plugin/sns/j/e$1
    //   27: dup
    //   28: aload_0
    //   29: aload_0
    //   30: getfield 317	com/tencent/mm/plugin/sns/j/e:ztD	Ljava/util/LinkedHashMap;
    //   33: invokevirtual 754	java/util/LinkedHashMap:clone	()Ljava/lang/Object;
    //   36: checkcast 299	java/util/LinkedHashMap
    //   39: invokespecial 757	com/tencent/mm/plugin/sns/j/e$1:<init>	(Lcom/tencent/mm/plugin/sns/j/e;Ljava/util/LinkedHashMap;)V
    //   42: ldc_w 759
    //   45: invokestatic 764	com/tencent/mm/sdk/g/b:c	(Ljava/lang/Runnable;Ljava/lang/String;)V
    //   48: ldc_w 751
    //   51: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public final LinkedList<Long> dVG()
  {
    try
    {
      AppMethodBeat.i(96218);
      Object localObject3 = (LinkedHashMap)this.ztD.clone();
      if ((((LinkedHashMap)localObject3).size() <= 0) || (this.ztE <= 0))
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
          if (i > this.ztE) {
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
  
  public final void dVH()
  {
    AppMethodBeat.i(96219);
    if ((this.ztH != null) && (this.ztH.eoc != -1))
    {
      Object localObject1 = this.ztH;
      ((gl)localObject1).eos = ((gl)localObject1).t("MediaEditedPublishIds", q.dSR(), true);
      Object localObject2 = new StringBuilder();
      localObject1 = new StringBuilder();
      Object localObject3 = this.ztI.entrySet().iterator();
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
        localObject3 = this.ztH;
        ((gl)localObject3).eoe = ((gl)localObject3).t("ChatroomMemClickList", ((StringBuilder)localObject2).substring(0, i), true);
      }
      if (j != -1)
      {
        localObject2 = this.ztH;
        ((gl)localObject2).eoq = ((gl)localObject2).t("ChatroomMemClickNumList", ((StringBuilder)localObject1).substring(0, j), true);
      }
      this.ztH.aLk();
      this.ztH = new gl();
      this.ztI.clear();
    }
    AppMethodBeat.o(96219);
  }
  
  public final void dVI()
  {
    AppMethodBeat.i(96233);
    this.ztM.clear();
    this.ztN.clear();
    this.ztO.clear();
    this.ztP.clear();
    this.ztQ.clear();
    this.ztR.clear();
    this.ztS = 0L;
    this.ztT = 0L;
    this.ztU = 0L;
    this.ztV = 0L;
    this.ztW = 0L;
    this.ztX = 0L;
    AppMethodBeat.o(96233);
  }
  
  public final ew dVJ()
  {
    AppMethodBeat.i(96239);
    ew localew2 = (ew)this.ztY.peekLast();
    ew localew1 = localew2;
    if (localew2 == null) {
      localew1 = new ew();
    }
    AppMethodBeat.o(96239);
    return localew1;
  }
  
  public final ew dVK()
  {
    AppMethodBeat.i(96240);
    ew localew = (ew)this.ztY.peekLast();
    AppMethodBeat.o(96240);
    return localew;
  }
  
  public final ew dVL()
  {
    AppMethodBeat.i(96241);
    dVN();
    ew localew = new ew();
    this.ztY.push(localew);
    AppMethodBeat.o(96241);
    return localew;
  }
  
  public final void dVM()
  {
    AppMethodBeat.i(96242);
    if (this.zub != 0L)
    {
      this.zuc += System.currentTimeMillis() - this.zub;
      this.zub = 0L;
    }
    AppMethodBeat.o(96242);
  }
  
  public final void dVO()
  {
    AppMethodBeat.i(96246);
    ew localew = dVJ();
    localew.ejp = this.ztZ.size();
    localew.ejq = this.zua.size();
    localew.ejr = this.zue;
    localew.ejs = this.zuc;
    ad.d("MicroMsg.SnsReportHelper", "doSnsAlbumFeedBehaviourReport:\n %s", new Object[] { localew.RE() });
    localew.aLk();
    try
    {
      this.ztY.removeLast();
      dVN();
      AppMethodBeat.o(96246);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.w("MicroMsg.SnsReportHelper", "doSnsAlbumFeedBehaviourReport remove err: %s", new Object[] { localException.getMessage() });
      }
    }
  }
  
  public final void dVP()
  {
    AppMethodBeat.i(197870);
    this.zuh.dSa = 2L;
    this.zuh.aLk();
    this.zuh = new go();
    AppMethodBeat.o(197870);
  }
  
  public final void e(p paramp, int paramInt)
  {
    AppMethodBeat.i(96243);
    if (paramp != null)
    {
      paramp = q.zx(paramp.field_snsId) + "_" + paramInt;
      if (!this.ztZ.contains(paramp)) {
        this.ztZ.add(paramp);
      }
    }
    AppMethodBeat.o(96243);
  }
  
  public final void f(p paramp, int paramInt)
  {
    AppMethodBeat.i(96244);
    if (paramp != null)
    {
      paramp = q.zx(paramp.field_snsId) + "_" + paramInt;
      if (!this.zua.contains(paramp)) {
        this.zua.add(paramp);
      }
    }
    AppMethodBeat.o(96244);
  }
  
  public final void fN(List<String> paramList)
  {
    AppMethodBeat.i(96221);
    if ((paramList != null) && (!paramList.isEmpty()) && (this.ztH != null))
    {
      this.ztH.eok = paramList.size();
      gl localgl = this.ztH;
      localgl.eol = localgl.t("SelectedUINList", bt.m(paramList, "|"), true);
    }
    AppMethodBeat.o(96221);
  }
  
  public final void hB(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(96228);
    Iterator localIterator = ztz.ztJ.entrySet().iterator();
    Object localObject = new ArrayList();
    while (localIterator.hasNext())
    {
      b localb = (b)((Map.Entry)localIterator.next()).getValue();
      if ((localb != null) && (localb.zur != null) && ((localb.position < paramInt1 - 1) || (localb.position > paramInt2)))
      {
        localb.zur.ejW = System.currentTimeMillis();
        localb.zur.aLk();
        ((List)localObject).add(localb.zur.ejJ);
      }
    }
    localIterator = ((List)localObject).iterator();
    while (localIterator.hasNext())
    {
      localObject = (String)localIterator.next();
      this.ztJ.remove(localObject);
    }
    AppMethodBeat.o(96228);
  }
  
  public final void hC(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(96231);
    Iterator localIterator = this.ztK.entrySet().iterator();
    Object localObject = new ArrayList();
    while (localIterator.hasNext())
    {
      a locala = (a)((Map.Entry)localIterator.next()).getValue();
      if ((locala != null) && (locala.zuo != null) && ((locala.position < paramInt1 - 1) || (locala.position > paramInt2)))
      {
        ey localey = locala.zuo;
        localey.ejC = localey.t("ClickEmojiIconIdList", m(locala.zup, "|"), true);
        localey = locala.zuo;
        localey.ejD = localey.t("ClickEmojiIdList", m(locala.zuq, "|"), true);
        locala.zuo.aLk();
        ((List)localObject).add(locala.zuo.ejz);
      }
    }
    localIterator = ((List)localObject).iterator();
    while (localIterator.hasNext())
    {
      localObject = (String)localIterator.next();
      this.ztK.remove(localObject);
    }
    AppMethodBeat.o(96231);
  }
  
  public final void jw(String paramString1, String paramString2)
  {
    AppMethodBeat.i(96214);
    if ((this.gwV == 0) || (bt.isNullOrNil(paramString1)) || (bt.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(96214);
      return;
    }
    this.ztB.put(paramString1, paramString2);
    AppMethodBeat.o(96214);
  }
  
  public final void zU(long paramLong)
  {
    try
    {
      AppMethodBeat.i(96216);
      if (this.ztE > 0) {
        this.ztD.put(Long.valueOf(paramLong), zty);
      }
      AppMethodBeat.o(96216);
      return;
    }
    finally {}
  }
  
  public final class a
  {
    public int position;
    public ey zuo;
    public List<String> zup;
    public List<String> zuq;
    
    public a()
    {
      AppMethodBeat.i(96211);
      this.zup = new ArrayList();
      this.zuq = new ArrayList();
      AppMethodBeat.o(96211);
    }
  }
  
  public final class b
  {
    public int position;
    public fb zur;
    
    b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.j.e
 * JD-Core Version:    0.7.0.1
 */