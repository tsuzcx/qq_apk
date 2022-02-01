package com.tencent.mm.plugin.sns.j;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.fm;
import com.tencent.mm.g.b.a.ey;
import com.tencent.mm.g.b.a.fa;
import com.tencent.mm.g.b.a.fc;
import com.tencent.mm.g.b.a.fd;
import com.tencent.mm.g.b.a.fh;
import com.tencent.mm.g.b.a.gn;
import com.tencent.mm.g.b.a.gp;
import com.tencent.mm.g.b.a.gq;
import com.tencent.mm.g.b.a.jm;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.i.a.t;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.ui.bi;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abo;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.vfs.o;
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
  private static final Integer zKN;
  public static e zKO;
  public ai fHF;
  public int gzC;
  private com.tencent.mm.sdk.b.c<fm> sCA;
  public HashMap<String, Integer> zKP;
  public HashMap<String, String> zKQ;
  public HashSet<String> zKR;
  private LinkedHashMap<Long, Object> zKS;
  private int zKT;
  public String zKU;
  public int zKV;
  public int zKW;
  public int zKX;
  public gn zKY;
  public Map<String, Integer> zKZ;
  public int zLA;
  public long zLB;
  public Map<String, b> zLa;
  public Map<String, a> zLb;
  public fh zLc;
  public List<String> zLd;
  public List<String> zLe;
  public List<String> zLf;
  public List<String> zLg;
  public List<String> zLh;
  public List<String> zLi;
  public long zLj;
  public long zLk;
  public long zLl;
  public long zLm;
  public long zLn;
  public long zLo;
  private LinkedList<ey> zLp;
  private List<String> zLq;
  private List<String> zLr;
  public long zLs;
  private long zLt;
  public long zLu;
  public long zLv;
  public gp zLw;
  public gq zLx;
  public gq zLy;
  public String zLz;
  
  static
  {
    AppMethodBeat.i(96248);
    zKN = Integer.valueOf(1);
    zKO = new e();
    AppMethodBeat.o(96248);
  }
  
  private e()
  {
    AppMethodBeat.i(96212);
    this.zKT = 0;
    this.zKU = "0";
    this.zKV = -1;
    this.zKW = 200;
    this.zKX = 86400;
    this.gzC = 0;
    this.sCA = new com.tencent.mm.sdk.b.c() {};
    this.zKY = new gn();
    this.zKZ = new HashMap();
    this.zLa = new HashMap();
    this.zLb = new HashMap();
    this.zLc = new fh();
    this.zLd = new ArrayList();
    this.zLe = new ArrayList();
    this.zLf = new ArrayList();
    this.zLg = new ArrayList();
    this.zLh = new ArrayList();
    this.zLi = new ArrayList();
    this.zLj = 0L;
    this.zLk = 0L;
    this.zLl = 0L;
    this.zLm = 0L;
    this.zLn = 0L;
    this.zLo = 0L;
    this.zLp = new LinkedList();
    this.zLq = new ArrayList();
    this.zLr = new ArrayList();
    this.zLs = 0L;
    this.zLt = 0L;
    this.zLu = 0L;
    this.zLv = 0L;
    this.zLw = new gp();
    this.zLx = new gq();
    this.zLy = new gq();
    this.zLz = "";
    this.zLA = 0;
    this.zLB = 0L;
    Object localObject1 = com.tencent.mm.model.c.d.aDI().xi("100077");
    if (((com.tencent.mm.storage.c)localObject1).isValid())
    {
      localObject1 = ((com.tencent.mm.storage.c)localObject1).fsy();
      this.zKW = bu.getInt((String)((Map)localObject1).get("maxCacheFeedCount"), 200);
      this.zKX = bu.getInt((String)((Map)localObject1).get("maxCacheSeconds"), 86400);
      this.gzC = bu.getInt((String)((Map)localObject1).get("needUploadData"), 0);
    }
    ae.i("MicroMsg.SnsReportHelper", "initAbtestArg maxCacheFeedCount:%d, maxCacheSeconds:%d, needUploadData:%d", new Object[] { Integer.valueOf(this.zKW), Integer.valueOf(this.zKX), Integer.valueOf(this.gzC) });
    dZf();
    this.fHF = new ai(am.IKh + "snsreport.cfg");
    localObject1 = this.fHF.get(3, new HashMap());
    Object localObject2 = this.fHF.get(4, new HashMap());
    Object localObject3 = this.fHF.get(5, new HashSet());
    Object localObject4 = this.fHF.get(6, new LinkedHashMap());
    if ((!(localObject1 instanceof HashMap)) || (!(localObject2 instanceof HashMap)) || (!(localObject3 instanceof HashSet)) || (!(localObject4 instanceof LinkedHashMap)))
    {
      o.deleteFile(am.IKh + "snsreport.cfg");
      this.fHF.reset();
      this.zKP = new HashMap();
      this.zKQ = new HashMap();
      this.zKR = new HashSet();
    }
    for (this.zKS = new LinkedHashMap();; this.zKS = ((LinkedHashMap)localObject4))
    {
      ae.d("MicroMsg.SnsReportHelper", "obj[%d] objForAppId[%d] objForFold[%d] objForAppIdCgi[%d] ", new Object[] { Integer.valueOf(this.zKP.size()), Integer.valueOf(this.zKQ.size()), Integer.valueOf(this.zKR.size()), Integer.valueOf(this.zKS.size()) });
      com.tencent.mm.sdk.b.a.IvT.b(this.sCA);
      AppMethodBeat.o(96212);
      return;
      this.zKP = ((HashMap)localObject1);
      this.zKQ = ((HashMap)localObject2);
      this.zKR = ((HashSet)localObject3);
    }
  }
  
  public static void a(int paramInt1, String paramString, int paramInt2, int paramInt3, long paramLong, int paramInt4)
  {
    AppMethodBeat.i(219365);
    a(paramInt1, paramString, paramInt2, paramInt3, paramLong, 0L, 0L, paramInt4);
    AppMethodBeat.o(219365);
  }
  
  public static void a(int paramInt1, String paramString, int paramInt2, int paramInt3, long paramLong1, long paramLong2, long paramLong3, int paramInt4)
  {
    AppMethodBeat.i(219366);
    int i;
    if (paramInt4 == 2)
    {
      i = ((Integer)g.ajR().ajA().get(am.a.Jew, Integer.valueOf(0))).intValue();
      paramInt3 = 0;
      paramString = "";
    }
    for (;;)
    {
      ((t)g.ad(t.class)).snsToFinderPostReport(zKO.zLz, paramInt1, paramString, paramInt2, paramInt3, i, paramLong2, paramLong3, paramLong1, paramInt4);
      AppMethodBeat.o(219366);
      return;
      i = ((Integer)g.ajR().ajA().get(am.a.Jev, Integer.valueOf(0))).intValue();
    }
  }
  
  public static void a(SnsObject paramSnsObject, int paramInt, String paramString)
  {
    AppMethodBeat.i(219368);
    int i;
    if (paramSnsObject != null)
    {
      if (!bu.lX(paramSnsObject.Username, v.aAC())) {
        break label132;
      }
      if (!bu.lX(paramString, v.aAC())) {
        break label127;
      }
      i = 2;
    }
    for (;;)
    {
      int j = paramSnsObject.CommentCount;
      int k = paramSnsObject.LikeCount;
      fc localfc = new fc();
      localfc.oC(r.zW(paramSnsObject.Id));
      localfc.oE(String.valueOf(paramInt));
      localfc.elm = i;
      localfc.oD(paramString);
      localfc.elp = 1;
      localfc.eln = k;
      localfc.elo = j;
      localfc.aLH();
      AppMethodBeat.o(219368);
      return;
      label127:
      i = 3;
      continue;
      label132:
      i = 1;
    }
  }
  
  public static void aAW(String paramString)
  {
    AppMethodBeat.i(96224);
    jm localjm = new jm();
    localjm.so(paramString);
    localjm.eCb = 1L;
    localjm.eCc = 1L;
    localjm.aLH();
    AppMethodBeat.o(96224);
  }
  
  public static void aAX(String paramString)
  {
    AppMethodBeat.i(96226);
    jm localjm = new jm();
    localjm.so(paramString);
    localjm.eCb = 3L;
    localjm.eCc = 1L;
    localjm.aLH();
    AppMethodBeat.o(96226);
  }
  
  public static void b(p paramp, int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(219367);
    int i;
    Object localObject;
    int k;
    int j;
    if (paramp != null)
    {
      if (!bu.lX(paramp.field_userName, v.aAC())) {
        break label148;
      }
      if (!bu.lX(paramString, v.aAC())) {
        break label142;
      }
      i = 2;
      localObject = al.v(paramp);
      if (localObject == null) {
        break label154;
      }
      k = ((SnsObject)localObject).CommentCount;
      j = ((SnsObject)localObject).LikeCount;
    }
    for (;;)
    {
      localObject = new fc();
      ((fc)localObject).oC(r.zW(paramp.field_snsId));
      ((fc)localObject).oE(String.valueOf(paramInt1));
      ((fc)localObject).elm = i;
      ((fc)localObject).oD(paramString);
      ((fc)localObject).elp = paramInt2;
      ((fc)localObject).eln = j;
      ((fc)localObject).elo = k;
      ((fc)localObject).aLH();
      AppMethodBeat.o(219367);
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
  
  private void dZf()
  {
    AppMethodBeat.i(96215);
    this.zKT = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qwA, 0);
    ae.i("MicroMsg.SnsReportHelper", "resetXExptControl maxFeedIdForCgiRecord[%d]", new Object[] { Integer.valueOf(this.zKT) });
    AppMethodBeat.o(96215);
  }
  
  private void dZo()
  {
    AppMethodBeat.i(96245);
    this.zLq.clear();
    this.zLr.clear();
    this.zLs = 0L;
    this.zLu = 0L;
    this.zLt = 0L;
    this.zLv = 0L;
    AppMethodBeat.o(96245);
  }
  
  public static void fi(String paramString, int paramInt)
  {
    AppMethodBeat.i(96225);
    jm localjm = new jm();
    localjm.so(paramString);
    localjm.eCb = 2L;
    localjm.eCc = paramInt;
    localjm.aLH();
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
  
  public final void As(long paramLong)
  {
    try
    {
      AppMethodBeat.i(96216);
      if (this.zKT > 0) {
        this.zKS.put(Long.valueOf(paramLong), zKN);
      }
      AppMethodBeat.o(96216);
      return;
    }
    finally {}
  }
  
  public final void G(p paramp)
  {
    AppMethodBeat.i(96234);
    if (paramp != null)
    {
      paramp = r.zW(paramp.field_snsId);
      if (!this.zLd.contains(paramp)) {
        this.zLd.add(paramp);
      }
    }
    AppMethodBeat.o(96234);
  }
  
  public final void H(p paramp)
  {
    AppMethodBeat.i(96235);
    if (paramp != null)
    {
      paramp = r.zW(paramp.field_snsId);
      if (!this.zLe.contains(paramp)) {
        this.zLe.add(paramp);
      }
    }
    AppMethodBeat.o(96235);
  }
  
  public final void I(p paramp)
  {
    AppMethodBeat.i(96236);
    if (paramp != null)
    {
      paramp = r.zW(paramp.field_snsId);
      if (!this.zLf.contains(paramp)) {
        this.zLf.add(paramp);
      }
    }
    AppMethodBeat.o(96236);
  }
  
  public final void QS(int paramInt)
  {
    if (this.zKY != null) {}
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      this.zKY.epK = 1;
      return;
    case 1: 
      this.zKY.epK = 2;
      return;
    case 2: 
      this.zKY.epK = 3;
      return;
    }
    this.zKY.epK = 4;
  }
  
  public final void a(View paramView, bi parambi, String paramString1, String paramString2, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(96227);
    String str;
    int i;
    if ((paramView != null) && (parambi != null) && (parambi.ADO != null) && (parambi.zlW != null) && (parambi.zlW.ebP() != null) && (parambi.zlW.ebP().HUG != null) && (this.zLa.get(r.zV(parambi.zlW.field_snsId)) == null))
    {
      str = v.aAC();
      paramView = new fd();
      paramView.dYc = paramView.t("Username", parambi.zlW.field_userName, true);
      paramView.elq = paramView.t("PublicID", r.zV(parambi.zlW.field_snsId), true);
      paramView.elr = parambi.zlW.ebP().HUG.Gtw;
      i = 0;
      paramString1 = paramString1.split(",");
      if (paramString1 != null) {
        i = paramString1.length;
      }
      paramView.els = i;
      i = 0;
      paramString1 = paramString2.split(",");
      if (paramString1 != null) {
        i = paramString1.length;
      }
      paramView.elt = i;
      paramView.elu = paramInt1;
      paramView.elv = paramInt2;
      if (!paramBoolean) {
        break label434;
      }
      paramView.elw = 1L;
      if (parambi.AEC == null) {
        break label468;
      }
      paramInt1 = 0;
      label232:
      if (paramInt1 >= parambi.AEC.size()) {
        break label468;
      }
      if (!bu.lX(str, (String)((com.tencent.mm.vending.j.a)parambi.AEC.get(paramInt1)).get(0))) {
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
      if (parambi.AED != null) {
        i = 0;
      }
      for (;;)
      {
        paramInt2 = paramInt1;
        if (i < parambi.AED.size())
        {
          paramString1 = (com.tencent.mm.vending.j.a)parambi.AED.get(i);
          if ((!(paramString1.get(1) instanceof String)) || (!bu.lX(str, (String)paramString1.get(1)))) {
            break label459;
          }
          if (paramInt1 != 1) {
            break label453;
          }
        }
        for (paramInt2 = 3;; paramInt2 = 2)
        {
          paramView.elx = parambi.AED.size();
          paramView.elA = paramInt2;
          paramView.elI = paramInt4;
          paramView.elC = System.currentTimeMillis();
          paramString1 = new b();
          paramString1.position = paramInt3;
          paramString1.zLI = paramView;
          this.zLa.put(r.zV(parambi.zlW.field_snsId), paramString1);
          AppMethodBeat.o(96227);
          return;
          paramView.elw = 2L;
          break;
          paramInt1 += 1;
          break label232;
        }
        i += 1;
      }
    }
  }
  
  public final void aP(Map<String, List<String>> paramMap)
  {
    AppMethodBeat.i(96220);
    if ((paramMap != null) && (!paramMap.isEmpty()) && (this.zKY != null))
    {
      this.zKY.epO = paramMap.keySet().size();
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
      paramMap = this.zKY;
      paramMap.epP = paramMap.t("SelectedChatroomList", localStringBuilder.toString(), true);
    }
    AppMethodBeat.o(96220);
  }
  
  public final void aQ(Map<String, List<String>> paramMap)
  {
    AppMethodBeat.i(96222);
    if ((paramMap != null) && (!paramMap.isEmpty()) && (this.zKY != null))
    {
      this.zKY.epU = paramMap.keySet().size();
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
      paramMap = this.zKY;
      paramMap.epV = paramMap.t("SelectedLabelList", localStringBuilder.toString(), true);
    }
    AppMethodBeat.o(96222);
  }
  
  public final void bS(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(96213);
    if (this.gzC == 0)
    {
      AppMethodBeat.o(96213);
      return;
    }
    HashMap localHashMap = this.zKP;
    if (this.zKP.containsKey(paramString)) {}
    for (int i = ((Integer)this.zKP.get(paramString)).intValue() + 1;; i = 1)
    {
      localHashMap.put(paramString, Integer.valueOf(i));
      if (paramBoolean) {
        this.zKR.add(paramString);
      }
      AppMethodBeat.o(96213);
      return;
    }
  }
  
  public final void bT(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(96229);
    if (paramString != null)
    {
      paramString = (b)this.zLa.get(paramString);
      if ((paramString != null) && (paramString.zLI != null))
      {
        if (paramBoolean)
        {
          paramString.zLI.ely = 1L;
          AppMethodBeat.o(96229);
          return;
        }
        paramString.zLI.ely = 3L;
      }
    }
    AppMethodBeat.o(96229);
  }
  
  public final void bU(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(96230);
    if (paramString != null)
    {
      paramString = (b)this.zLa.get(paramString);
      if ((paramString != null) && (paramString.zLI != null))
      {
        if (paramBoolean)
        {
          paramString.zLI.elB = 1L;
          AppMethodBeat.o(96230);
          return;
        }
        paramString.zLI.elJ = 1L;
      }
    }
    AppMethodBeat.o(96230);
  }
  
  public final void c(p paramp, int paramInt)
  {
    AppMethodBeat.i(96237);
    if (paramp != null)
    {
      paramp = r.zW(paramp.field_snsId) + "_" + paramInt;
      if (!this.zLg.contains(paramp)) {
        this.zLg.add(paramp);
      }
    }
    AppMethodBeat.o(96237);
  }
  
  public final void d(p paramp, int paramInt)
  {
    AppMethodBeat.i(96238);
    if (paramp != null)
    {
      paramp = r.zW(paramp.field_snsId) + "_" + paramInt;
      if (!this.zLi.contains(paramp)) {
        this.zLi.add(paramp);
      }
    }
    AppMethodBeat.o(96238);
  }
  
  /* Error */
  public final void dZg()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 767
    //   5: invokestatic 96	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 117	com/tencent/mm/plugin/sns/j/e:zKT	I
    //   12: ifgt +12 -> 24
    //   15: ldc_w 767
    //   18: invokestatic 112	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: new 6	com/tencent/mm/plugin/sns/j/e$1
    //   27: dup
    //   28: aload_0
    //   29: aload_0
    //   30: getfield 325	com/tencent/mm/plugin/sns/j/e:zKS	Ljava/util/LinkedHashMap;
    //   33: invokevirtual 770	java/util/LinkedHashMap:clone	()Ljava/lang/Object;
    //   36: checkcast 307	java/util/LinkedHashMap
    //   39: invokespecial 773	com/tencent/mm/plugin/sns/j/e$1:<init>	(Lcom/tencent/mm/plugin/sns/j/e;Ljava/util/LinkedHashMap;)V
    //   42: ldc_w 775
    //   45: invokestatic 780	com/tencent/mm/sdk/g/b:c	(Ljava/lang/Runnable;Ljava/lang/String;)V
    //   48: ldc_w 767
    //   51: invokestatic 112	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public final LinkedList<Long> dZh()
  {
    try
    {
      AppMethodBeat.i(96218);
      Object localObject3 = (LinkedHashMap)this.zKS.clone();
      if ((((LinkedHashMap)localObject3).size() <= 0) || (this.zKT <= 0))
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
          if (i > this.zKT) {
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
  
  public final void dZi()
  {
    AppMethodBeat.i(96219);
    if ((this.zKY != null) && (this.zKY.epK != -1))
    {
      Object localObject1 = this.zKY;
      ((gn)localObject1).epZ = ((gn)localObject1).t("MediaEditedPublishIds", r.dWr(), true);
      Object localObject2 = new StringBuilder();
      localObject1 = new StringBuilder();
      Object localObject3 = this.zKZ.entrySet().iterator();
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
        localObject3 = this.zKY;
        ((gn)localObject3).epM = ((gn)localObject3).t("ChatroomMemClickList", ((StringBuilder)localObject2).substring(0, i), true);
      }
      if (j != -1)
      {
        localObject2 = this.zKY;
        ((gn)localObject2).epX = ((gn)localObject2).t("ChatroomMemClickNumList", ((StringBuilder)localObject1).substring(0, j), true);
      }
      this.zKY.aLH();
      this.zKY = new gn();
      this.zKZ.clear();
    }
    AppMethodBeat.o(96219);
  }
  
  public final void dZj()
  {
    AppMethodBeat.i(96233);
    this.zLd.clear();
    this.zLe.clear();
    this.zLf.clear();
    this.zLg.clear();
    this.zLh.clear();
    this.zLi.clear();
    this.zLj = 0L;
    this.zLk = 0L;
    this.zLl = 0L;
    this.zLm = 0L;
    this.zLn = 0L;
    this.zLo = 0L;
    AppMethodBeat.o(96233);
  }
  
  public final ey dZk()
  {
    AppMethodBeat.i(96239);
    ey localey2 = (ey)this.zLp.peekLast();
    ey localey1 = localey2;
    if (localey2 == null) {
      localey1 = new ey();
    }
    AppMethodBeat.o(96239);
    return localey1;
  }
  
  public final ey dZl()
  {
    AppMethodBeat.i(96240);
    ey localey = (ey)this.zLp.peekLast();
    AppMethodBeat.o(96240);
    return localey;
  }
  
  public final ey dZm()
  {
    AppMethodBeat.i(96241);
    dZo();
    ey localey = new ey();
    this.zLp.push(localey);
    AppMethodBeat.o(96241);
    return localey;
  }
  
  public final void dZn()
  {
    AppMethodBeat.i(96242);
    if (this.zLs != 0L)
    {
      this.zLt += System.currentTimeMillis() - this.zLs;
      this.zLs = 0L;
    }
    AppMethodBeat.o(96242);
  }
  
  public final void dZp()
  {
    AppMethodBeat.i(96246);
    ey localey = dZk();
    localey.ekW = this.zLq.size();
    localey.ekX = this.zLr.size();
    localey.ekY = this.zLv;
    localey.ekZ = this.zLt;
    ae.d("MicroMsg.SnsReportHelper", "doSnsAlbumFeedBehaviourReport:\n %s", new Object[] { localey.RD() });
    localey.aLH();
    try
    {
      this.zLp.removeLast();
      dZo();
      AppMethodBeat.o(96246);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.w("MicroMsg.SnsReportHelper", "doSnsAlbumFeedBehaviourReport remove err: %s", new Object[] { localException.getMessage() });
      }
    }
  }
  
  public final void dZq()
  {
    AppMethodBeat.i(219364);
    this.zLy.dTq = 2L;
    this.zLy.aLH();
    this.zLy = new gq();
    AppMethodBeat.o(219364);
  }
  
  public final void e(p paramp, int paramInt)
  {
    AppMethodBeat.i(96243);
    if (paramp != null)
    {
      paramp = r.zW(paramp.field_snsId) + "_" + paramInt;
      if (!this.zLq.contains(paramp)) {
        this.zLq.add(paramp);
      }
    }
    AppMethodBeat.o(96243);
  }
  
  public final void f(p paramp, int paramInt)
  {
    AppMethodBeat.i(96244);
    if (paramp != null)
    {
      paramp = r.zW(paramp.field_snsId) + "_" + paramInt;
      if (!this.zLr.contains(paramp)) {
        this.zLr.add(paramp);
      }
    }
    AppMethodBeat.o(96244);
  }
  
  public final void fW(List<String> paramList)
  {
    AppMethodBeat.i(96221);
    if ((paramList != null) && (!paramList.isEmpty()) && (this.zKY != null))
    {
      this.zKY.epR = paramList.size();
      gn localgn = this.zKY;
      localgn.epS = localgn.t("SelectedUINList", bu.m(paramList, "|"), true);
    }
    AppMethodBeat.o(96221);
  }
  
  public final void hE(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(96228);
    Iterator localIterator = zKO.zLa.entrySet().iterator();
    Object localObject = new ArrayList();
    while (localIterator.hasNext())
    {
      b localb = (b)((Map.Entry)localIterator.next()).getValue();
      if ((localb != null) && (localb.zLI != null) && ((localb.position < paramInt1 - 1) || (localb.position > paramInt2)))
      {
        localb.zLI.elD = System.currentTimeMillis();
        localb.zLI.aLH();
        ((List)localObject).add(localb.zLI.elq);
      }
    }
    localIterator = ((List)localObject).iterator();
    while (localIterator.hasNext())
    {
      localObject = (String)localIterator.next();
      this.zLa.remove(localObject);
    }
    AppMethodBeat.o(96228);
  }
  
  public final void hF(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(96231);
    Iterator localIterator = this.zLb.entrySet().iterator();
    Object localObject = new ArrayList();
    while (localIterator.hasNext())
    {
      a locala = (a)((Map.Entry)localIterator.next()).getValue();
      if ((locala != null) && (locala.zLF != null) && ((locala.position < paramInt1 - 1) || (locala.position > paramInt2)))
      {
        fa localfa = locala.zLF;
        localfa.elj = localfa.t("ClickEmojiIconIdList", m(locala.zLG, "|"), true);
        localfa = locala.zLF;
        localfa.elk = localfa.t("ClickEmojiIdList", m(locala.zLH, "|"), true);
        locala.zLF.aLH();
        ((List)localObject).add(locala.zLF.elg);
      }
    }
    localIterator = ((List)localObject).iterator();
    while (localIterator.hasNext())
    {
      localObject = (String)localIterator.next();
      this.zLb.remove(localObject);
    }
    AppMethodBeat.o(96231);
  }
  
  public final void jD(String paramString1, String paramString2)
  {
    AppMethodBeat.i(96214);
    if ((this.gzC == 0) || (bu.isNullOrNil(paramString1)) || (bu.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(96214);
      return;
    }
    this.zKQ.put(paramString1, paramString2);
    AppMethodBeat.o(96214);
  }
  
  public final class a
  {
    public int position;
    public fa zLF;
    public List<String> zLG;
    public List<String> zLH;
    
    public a()
    {
      AppMethodBeat.i(96211);
      this.zLG = new ArrayList();
      this.zLH = new ArrayList();
      AppMethodBeat.o(96211);
    }
  }
  
  public final class b
  {
    public int position;
    public fd zLI;
    
    b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.j.e
 * JD-Core Version:    0.7.0.1
 */