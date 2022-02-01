package com.tencent.mm.plugin.sns.k;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.fh;
import com.tencent.mm.g.b.a.ck;
import com.tencent.mm.g.b.a.cm;
import com.tencent.mm.g.b.a.co;
import com.tencent.mm.g.b.a.cs;
import com.tencent.mm.g.b.a.dw;
import com.tencent.mm.g.b.a.dy;
import com.tencent.mm.g.b.a.go;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.sns.j.m;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.ui.bf;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.yk;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.ae;
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

public final class f
{
  private static final Integer wQX;
  public static f wQY;
  public int fYF;
  public aa fjZ;
  private com.tencent.mm.sdk.b.c<fh> vKR;
  public HashMap<String, Integer> wQZ;
  public long wRA;
  private long wRB;
  public long wRC;
  public long wRD;
  public dy wRE;
  public HashMap<String, String> wRa;
  public HashSet<String> wRb;
  private LinkedHashMap<Long, Object> wRc;
  private int wRd;
  public int wRe;
  public int wRf;
  public dw wRg;
  public Map<String, Integer> wRh;
  public Map<String, b> wRi;
  public Map<String, a> wRj;
  public cs wRk;
  public List<String> wRl;
  public List<String> wRm;
  public List<String> wRn;
  public List<String> wRo;
  public List<String> wRp;
  public List<String> wRq;
  public long wRr;
  public long wRs;
  public long wRt;
  public long wRu;
  public long wRv;
  public long wRw;
  private LinkedList<ck> wRx;
  private List<String> wRy;
  private List<String> wRz;
  
  static
  {
    AppMethodBeat.i(96248);
    wQX = Integer.valueOf(1);
    wQY = new f();
    AppMethodBeat.o(96248);
  }
  
  private f()
  {
    AppMethodBeat.i(96212);
    this.wRd = 0;
    this.wRe = 200;
    this.wRf = 86400;
    this.fYF = 0;
    this.vKR = new com.tencent.mm.sdk.b.c() {};
    this.wRg = new dw();
    this.wRh = new HashMap();
    this.wRi = new HashMap();
    this.wRj = new HashMap();
    this.wRk = new cs();
    this.wRl = new ArrayList();
    this.wRm = new ArrayList();
    this.wRn = new ArrayList();
    this.wRo = new ArrayList();
    this.wRp = new ArrayList();
    this.wRq = new ArrayList();
    this.wRr = 0L;
    this.wRs = 0L;
    this.wRt = 0L;
    this.wRu = 0L;
    this.wRv = 0L;
    this.wRw = 0L;
    this.wRx = new LinkedList();
    this.wRy = new ArrayList();
    this.wRz = new ArrayList();
    this.wRA = 0L;
    this.wRB = 0L;
    this.wRC = 0L;
    this.wRD = 0L;
    this.wRE = new dy();
    Object localObject1 = com.tencent.mm.model.c.d.aty().qu("100077");
    if (((com.tencent.mm.storage.c)localObject1).isValid())
    {
      localObject1 = ((com.tencent.mm.storage.c)localObject1).eJy();
      this.wRe = bt.getInt((String)((Map)localObject1).get("maxCacheFeedCount"), 200);
      this.wRf = bt.getInt((String)((Map)localObject1).get("maxCacheSeconds"), 86400);
      this.fYF = bt.getInt((String)((Map)localObject1).get("needUploadData"), 0);
    }
    ad.i("MicroMsg.SnsReportHelper", "initAbtestArg maxCacheFeedCount:%d, maxCacheSeconds:%d, needUploadData:%d", new Object[] { Integer.valueOf(this.wRe), Integer.valueOf(this.wRf), Integer.valueOf(this.fYF) });
    duS();
    this.fjZ = new aa(ae.FfH + "snsreport.cfg");
    localObject1 = this.fjZ.get(3, new HashMap());
    Object localObject2 = this.fjZ.get(4, new HashMap());
    Object localObject3 = this.fjZ.get(5, new HashSet());
    Object localObject4 = this.fjZ.get(6, new LinkedHashMap());
    if ((!(localObject1 instanceof HashMap)) || (!(localObject2 instanceof HashMap)) || (!(localObject3 instanceof HashSet)) || (!(localObject4 instanceof LinkedHashMap)))
    {
      i.deleteFile(ae.FfH + "snsreport.cfg");
      this.fjZ.reset();
      this.wQZ = new HashMap();
      this.wRa = new HashMap();
      this.wRb = new HashSet();
    }
    for (this.wRc = new LinkedHashMap();; this.wRc = ((LinkedHashMap)localObject4))
    {
      ad.d("MicroMsg.SnsReportHelper", "obj[%d] objForAppId[%d] objForFold[%d] objForAppIdCgi[%d] ", new Object[] { Integer.valueOf(this.wQZ.size()), Integer.valueOf(this.wRa.size()), Integer.valueOf(this.wRb.size()), Integer.valueOf(this.wRc.size()) });
      com.tencent.mm.sdk.b.a.ESL.b(this.vKR);
      AppMethodBeat.o(96212);
      return;
      this.wQZ = ((HashMap)localObject1);
      this.wRa = ((HashMap)localObject2);
      this.wRb = ((HashSet)localObject3);
    }
  }
  
  public static void apo(String paramString)
  {
    AppMethodBeat.i(96224);
    go localgo = new go();
    localgo.mh(paramString);
    localgo.ehm = 1L;
    localgo.ehn = 1L;
    localgo.aBj();
    AppMethodBeat.o(96224);
  }
  
  public static void app(String paramString)
  {
    AppMethodBeat.i(96226);
    go localgo = new go();
    localgo.mh(paramString);
    localgo.ehm = 3L;
    localgo.ehn = 1L;
    localgo.aBj();
    AppMethodBeat.o(96226);
  }
  
  private void duS()
  {
    AppMethodBeat.i(96215);
    this.wRd = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.piS, 0);
    ad.i("MicroMsg.SnsReportHelper", "resetXExptControl maxFeedIdForCgiRecord[%d]", new Object[] { Integer.valueOf(this.wRd) });
    AppMethodBeat.o(96215);
  }
  
  private void dvb()
  {
    AppMethodBeat.i(96245);
    this.wRy.clear();
    this.wRz.clear();
    this.wRA = 0L;
    this.wRC = 0L;
    this.wRB = 0L;
    this.wRD = 0L;
    AppMethodBeat.o(96245);
  }
  
  public static void ez(String paramString, int paramInt)
  {
    AppMethodBeat.i(96225);
    go localgo = new go();
    localgo.mh(paramString);
    localgo.ehm = 2L;
    localgo.ehn = paramInt;
    localgo.aBj();
    AppMethodBeat.o(96225);
  }
  
  private static <T> String n(List<T> paramList, String paramString)
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
  
  public final void D(p paramp)
  {
    AppMethodBeat.i(96234);
    if (paramp != null)
    {
      paramp = com.tencent.mm.plugin.sns.data.q.su(paramp.field_snsId);
      if (!this.wRl.contains(paramp)) {
        this.wRl.add(paramp);
      }
    }
    AppMethodBeat.o(96234);
  }
  
  public final void E(p paramp)
  {
    AppMethodBeat.i(96235);
    if (paramp != null)
    {
      paramp = com.tencent.mm.plugin.sns.data.q.su(paramp.field_snsId);
      if (!this.wRm.contains(paramp)) {
        this.wRm.add(paramp);
      }
    }
    AppMethodBeat.o(96235);
  }
  
  public final void F(p paramp)
  {
    AppMethodBeat.i(96236);
    if (paramp != null)
    {
      paramp = com.tencent.mm.plugin.sns.data.q.su(paramp.field_snsId);
      if (!this.wRn.contains(paramp)) {
        this.wRn.add(paramp);
      }
    }
    AppMethodBeat.o(96236);
  }
  
  public final void MB(int paramInt)
  {
    if (this.wRg != null) {}
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      this.wRg.dVR = 1;
      return;
    case 1: 
      this.wRg.dVR = 2;
      return;
    case 2: 
      this.wRg.dVR = 3;
      return;
    }
    this.wRg.dVR = 4;
  }
  
  public final void a(View paramView, bf parambf, String paramString1, String paramString2, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(96227);
    String str;
    int i;
    if ((paramView != null) && (parambf != null) && (parambf.xIb != null) && (parambf.wvM != null) && (parambf.wvM.dxy() != null) && (parambf.wvM.dxy().Etm != null) && (this.wRi.get(com.tencent.mm.plugin.sns.data.q.st(parambf.wvM.field_snsId)) == null))
    {
      str = u.aqG();
      paramView = new co();
      paramView.dKt = paramView.t("Username", parambf.wvM.field_userName, true);
      paramView.dRD = paramView.t("PublicID", com.tencent.mm.plugin.sns.data.q.st(parambf.wvM.field_snsId), true);
      paramView.dRE = parambf.wvM.dxy().Etm.DaB;
      i = 0;
      paramString1 = paramString1.split(",");
      if (paramString1 != null) {
        i = paramString1.length;
      }
      paramView.dRF = i;
      i = 0;
      paramString1 = paramString2.split(",");
      if (paramString1 != null) {
        i = paramString1.length;
      }
      paramView.dRG = i;
      paramView.dRH = paramInt1;
      paramView.dRI = paramInt2;
      if (!paramBoolean) {
        break label434;
      }
      paramView.dRJ = 1L;
      if (parambf.xIP == null) {
        break label468;
      }
      paramInt1 = 0;
      label232:
      if (paramInt1 >= parambf.xIP.size()) {
        break label468;
      }
      if (!bt.kU(str, (String)((com.tencent.mm.vending.j.a)parambf.xIP.get(paramInt1)).get(0))) {
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
      if (parambf.xIQ != null) {
        i = 0;
      }
      for (;;)
      {
        paramInt2 = paramInt1;
        if (i < parambf.xIQ.size())
        {
          paramString1 = (com.tencent.mm.vending.j.a)parambf.xIQ.get(i);
          if ((!(paramString1.get(1) instanceof String)) || (!bt.kU(str, (String)paramString1.get(1)))) {
            break label459;
          }
          if (paramInt1 != 1) {
            break label453;
          }
        }
        for (paramInt2 = 3;; paramInt2 = 2)
        {
          paramView.dRK = parambf.xIQ.size();
          paramView.dRN = paramInt2;
          paramView.dRV = paramInt4;
          paramView.dRP = System.currentTimeMillis();
          paramString1 = new b();
          paramString1.position = paramInt3;
          paramString1.wRL = paramView;
          this.wRi.put(com.tencent.mm.plugin.sns.data.q.st(parambf.wvM.field_snsId), paramString1);
          AppMethodBeat.o(96227);
          return;
          paramView.dRJ = 2L;
          break;
          paramInt1 += 1;
          break label232;
        }
        i += 1;
      }
    }
  }
  
  public final void aC(Map<String, List<String>> paramMap)
  {
    AppMethodBeat.i(96220);
    if ((paramMap != null) && (!paramMap.isEmpty()) && (this.wRg != null))
    {
      this.wRg.dVV = paramMap.keySet().size();
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
      paramMap = this.wRg;
      paramMap.dVW = paramMap.t("SelectedChatroomList", localStringBuilder.toString(), true);
    }
    AppMethodBeat.o(96220);
  }
  
  public final void aD(Map<String, List<String>> paramMap)
  {
    AppMethodBeat.i(96222);
    if ((paramMap != null) && (!paramMap.isEmpty()) && (this.wRg != null))
    {
      this.wRg.dWb = paramMap.keySet().size();
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
      paramMap = this.wRg;
      paramMap.dWc = paramMap.t("SelectedLabelList", localStringBuilder.toString(), true);
    }
    AppMethodBeat.o(96222);
  }
  
  public final void b(p paramp, int paramInt)
  {
    AppMethodBeat.i(96237);
    if (paramp != null)
    {
      paramp = com.tencent.mm.plugin.sns.data.q.su(paramp.field_snsId) + "_" + paramInt;
      if (!this.wRo.contains(paramp)) {
        this.wRo.add(paramp);
      }
    }
    AppMethodBeat.o(96237);
  }
  
  public final void bA(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(96213);
    if (this.fYF == 0)
    {
      AppMethodBeat.o(96213);
      return;
    }
    HashMap localHashMap = this.wQZ;
    if (this.wQZ.containsKey(paramString)) {}
    for (int i = ((Integer)this.wQZ.get(paramString)).intValue() + 1;; i = 1)
    {
      localHashMap.put(paramString, Integer.valueOf(i));
      if (paramBoolean) {
        this.wRb.add(paramString);
      }
      AppMethodBeat.o(96213);
      return;
    }
  }
  
  public final void bB(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(96229);
    if (paramString != null)
    {
      paramString = (b)this.wRi.get(paramString);
      if ((paramString != null) && (paramString.wRL != null))
      {
        if (paramBoolean)
        {
          paramString.wRL.dRL = 1L;
          AppMethodBeat.o(96229);
          return;
        }
        paramString.wRL.dRL = 3L;
      }
    }
    AppMethodBeat.o(96229);
  }
  
  public final void bC(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(96230);
    if (paramString != null)
    {
      paramString = (b)this.wRi.get(paramString);
      if ((paramString != null) && (paramString.wRL != null))
      {
        if (paramBoolean)
        {
          paramString.wRL.dRO = 1L;
          AppMethodBeat.o(96230);
          return;
        }
        paramString.wRL.dRW = 1L;
      }
    }
    AppMethodBeat.o(96230);
  }
  
  public final void c(p paramp, int paramInt)
  {
    AppMethodBeat.i(96238);
    if (paramp != null)
    {
      paramp = com.tencent.mm.plugin.sns.data.q.su(paramp.field_snsId) + "_" + paramInt;
      if (!this.wRq.contains(paramp)) {
        this.wRq.add(paramp);
      }
    }
    AppMethodBeat.o(96238);
  }
  
  public final void d(p paramp, int paramInt)
  {
    AppMethodBeat.i(96243);
    if (paramp != null)
    {
      paramp = com.tencent.mm.plugin.sns.data.q.su(paramp.field_snsId) + "_" + paramInt;
      if (!this.wRy.contains(paramp)) {
        this.wRy.add(paramp);
      }
    }
    AppMethodBeat.o(96243);
  }
  
  /* Error */
  public final void duT()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 639
    //   5: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 108	com/tencent/mm/plugin/sns/k/f:wRd	I
    //   12: ifgt +12 -> 24
    //   15: ldc_w 639
    //   18: invokestatic 103	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: new 6	com/tencent/mm/plugin/sns/k/f$1
    //   27: dup
    //   28: aload_0
    //   29: aload_0
    //   30: getfield 296	com/tencent/mm/plugin/sns/k/f:wRc	Ljava/util/LinkedHashMap;
    //   33: invokevirtual 642	java/util/LinkedHashMap:clone	()Ljava/lang/Object;
    //   36: checkcast 278	java/util/LinkedHashMap
    //   39: invokespecial 645	com/tencent/mm/plugin/sns/k/f$1:<init>	(Lcom/tencent/mm/plugin/sns/k/f;Ljava/util/LinkedHashMap;)V
    //   42: ldc_w 647
    //   45: invokestatic 652	com/tencent/mm/sdk/g/b:c	(Ljava/lang/Runnable;Ljava/lang/String;)V
    //   48: ldc_w 639
    //   51: invokestatic 103	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   54: goto -33 -> 21
    //   57: astore_1
    //   58: aload_0
    //   59: monitorexit
    //   60: aload_1
    //   61: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	62	0	this	f
    //   57	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	21	57	finally
    //   24	54	57	finally
  }
  
  public final LinkedList<Long> duU()
  {
    try
    {
      AppMethodBeat.i(96218);
      Object localObject3 = (LinkedHashMap)this.wRc.clone();
      if ((((LinkedHashMap)localObject3).size() <= 0) || (this.wRd <= 0))
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
          if (i > this.wRd) {
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
  
  public final void duV()
  {
    AppMethodBeat.i(96219);
    if ((this.wRg != null) && (this.wRg.dVR != -1))
    {
      Object localObject1 = this.wRg;
      ((dw)localObject1).dWg = ((dw)localObject1).t("MediaEditedPublishIds", com.tencent.mm.plugin.sns.data.q.dsf(), true);
      Object localObject2 = new StringBuilder();
      localObject1 = new StringBuilder();
      Object localObject3 = this.wRh.entrySet().iterator();
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
        localObject3 = this.wRg;
        ((dw)localObject3).dVT = ((dw)localObject3).t("ChatroomMemClickList", ((StringBuilder)localObject2).substring(0, i), true);
      }
      if (j != -1)
      {
        localObject2 = this.wRg;
        ((dw)localObject2).dWe = ((dw)localObject2).t("ChatroomMemClickNumList", ((StringBuilder)localObject1).substring(0, j), true);
      }
      this.wRg.aBj();
      this.wRg = new dw();
      this.wRh.clear();
    }
    AppMethodBeat.o(96219);
  }
  
  public final void duW()
  {
    AppMethodBeat.i(96233);
    this.wRl.clear();
    this.wRm.clear();
    this.wRn.clear();
    this.wRo.clear();
    this.wRp.clear();
    this.wRq.clear();
    this.wRr = 0L;
    this.wRs = 0L;
    this.wRt = 0L;
    this.wRu = 0L;
    this.wRv = 0L;
    this.wRw = 0L;
    AppMethodBeat.o(96233);
  }
  
  public final ck duX()
  {
    AppMethodBeat.i(96239);
    ck localck2 = (ck)this.wRx.peekLast();
    ck localck1 = localck2;
    if (localck2 == null) {
      localck1 = new ck();
    }
    AppMethodBeat.o(96239);
    return localck1;
  }
  
  public final ck duY()
  {
    AppMethodBeat.i(96240);
    ck localck = (ck)this.wRx.peekLast();
    AppMethodBeat.o(96240);
    return localck;
  }
  
  public final ck duZ()
  {
    AppMethodBeat.i(96241);
    dvb();
    ck localck = new ck();
    this.wRx.push(localck);
    AppMethodBeat.o(96241);
    return localck;
  }
  
  public final void dva()
  {
    AppMethodBeat.i(96242);
    if (this.wRA != 0L)
    {
      this.wRB += System.currentTimeMillis() - this.wRA;
      this.wRA = 0L;
    }
    AppMethodBeat.o(96242);
  }
  
  public final void dvc()
  {
    AppMethodBeat.i(96246);
    ck localck = duX();
    localck.dRo = this.wRy.size();
    localck.dRp = this.wRz.size();
    localck.dRq = this.wRD;
    localck.dRr = this.wRB;
    ad.d("MicroMsg.SnsReportHelper", "doSnsAlbumFeedBehaviourReport:\n %s", new Object[] { localck.PW() });
    localck.aBj();
    try
    {
      this.wRx.removeLast();
      dvb();
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
  
  public final void e(p paramp, int paramInt)
  {
    AppMethodBeat.i(96244);
    if (paramp != null)
    {
      paramp = com.tencent.mm.plugin.sns.data.q.su(paramp.field_snsId) + "_" + paramInt;
      if (!this.wRz.contains(paramp)) {
        this.wRz.add(paramp);
      }
    }
    AppMethodBeat.o(96244);
  }
  
  public final void ft(List<String> paramList)
  {
    AppMethodBeat.i(96221);
    if ((paramList != null) && (!paramList.isEmpty()) && (this.wRg != null))
    {
      this.wRg.dVY = paramList.size();
      dw localdw = this.wRg;
      localdw.dVZ = localdw.t("SelectedUINList", bt.n(paramList, "|"), true);
    }
    AppMethodBeat.o(96221);
  }
  
  public final void fu(List<m> paramList)
  {
    AppMethodBeat.i(96223);
    if ((paramList != null) && (!paramList.isEmpty()) && (this.wRg != null))
    {
      Object localObject1 = new ArrayList();
      ArrayList localArrayList = new ArrayList();
      Object localObject2 = new ArrayList();
      paramList = paramList.iterator();
      Object localObject3;
      while (paramList.hasNext())
      {
        localObject3 = (m)paramList.next();
        switch (((m)localObject3).type)
        {
        default: 
          break;
        case 0: 
          localArrayList.add(((m)localObject3).name);
          break;
        case 2: 
          ((List)localObject1).add(((m)localObject3).name);
          break;
        case 1: 
          ((List)localObject2).add(((m)localObject3).name);
        }
      }
      Object localObject4;
      Object localObject5;
      if (((List)localObject2).size() > 0)
      {
        paramList = new StringBuilder();
        localObject3 = ((List)localObject2).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (String)((Iterator)localObject3).next();
          localObject5 = com.tencent.mm.plugin.label.a.a.cIS().aeL(com.tencent.mm.plugin.label.a.a.cIS().aeI((String)localObject4));
          if ((localObject5 != null) && (((List)localObject5).size() != 0)) {
            paramList.append((String)localObject4).append("|").append(((List)localObject5).size()).append(";");
          }
        }
        this.wRg.dVP = ((List)localObject2).size();
        localObject2 = this.wRg;
        ((dw)localObject2).dVQ = ((dw)localObject2).t("LatestTimelinePsotSettingLabelList", paramList.toString(), true);
      }
      if (((List)localObject1).size() > 0)
      {
        paramList = new StringBuilder();
        localObject2 = ((List)localObject1).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (String)((Iterator)localObject2).next();
          localObject4 = new ArrayList();
          localObject5 = com.tencent.mm.model.q.rX((String)localObject3);
          if (localObject5 != null)
          {
            localObject5 = ((List)localObject5).iterator();
            while (((Iterator)localObject5).hasNext())
            {
              String str = (String)((Iterator)localObject5).next();
              if (w.sD(str)) {
                ((List)localObject4).add(str);
              }
            }
            paramList.append((String)localObject3).append("|").append(((List)localObject4).size()).append(";");
          }
        }
        this.wRg.dVL = ((List)localObject1).size();
        localObject1 = this.wRg;
        ((dw)localObject1).dVM = ((dw)localObject1).t("LatestTimelinePsotSettingGroupList", paramList.toString(), true);
      }
      this.wRg.dVN = localArrayList.size();
      paramList = this.wRg;
      paramList.dVO = paramList.t("LatestTimelinePsotSettingUinList", bt.n(localArrayList, "|"), true);
    }
    AppMethodBeat.o(96223);
  }
  
  public final void hb(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(96228);
    Iterator localIterator = wQY.wRi.entrySet().iterator();
    Object localObject = new ArrayList();
    while (localIterator.hasNext())
    {
      b localb = (b)((Map.Entry)localIterator.next()).getValue();
      if ((localb != null) && (localb.wRL != null) && ((localb.position < paramInt1 - 1) || (localb.position > paramInt2)))
      {
        localb.wRL.dRQ = System.currentTimeMillis();
        localb.wRL.aBj();
        ((List)localObject).add(localb.wRL.dRD);
      }
    }
    localIterator = ((List)localObject).iterator();
    while (localIterator.hasNext())
    {
      localObject = (String)localIterator.next();
      this.wRi.remove(localObject);
    }
    AppMethodBeat.o(96228);
  }
  
  public final void hc(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(96231);
    Iterator localIterator = this.wRj.entrySet().iterator();
    Object localObject = new ArrayList();
    while (localIterator.hasNext())
    {
      a locala = (a)((Map.Entry)localIterator.next()).getValue();
      if ((locala != null) && (locala.wRI != null) && ((locala.position < paramInt1 - 1) || (locala.position > paramInt2)))
      {
        cm localcm = locala.wRI;
        localcm.dRB = localcm.t("ClickEmojiIconIdList", n(locala.wRJ, "|"), true);
        localcm = locala.wRI;
        localcm.dRC = localcm.t("ClickEmojiIdList", n(locala.wRK, "|"), true);
        locala.wRI.aBj();
        ((List)localObject).add(locala.wRI.dRy);
      }
    }
    localIterator = ((List)localObject).iterator();
    while (localIterator.hasNext())
    {
      localObject = (String)localIterator.next();
      this.wRj.remove(localObject);
    }
    AppMethodBeat.o(96231);
  }
  
  public final void iN(String paramString1, String paramString2)
  {
    AppMethodBeat.i(96214);
    if ((this.fYF == 0) || (bt.isNullOrNil(paramString1)) || (bt.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(96214);
      return;
    }
    this.wRa.put(paramString1, paramString2);
    AppMethodBeat.o(96214);
  }
  
  public final void sT(long paramLong)
  {
    try
    {
      AppMethodBeat.i(96216);
      if (this.wRd > 0) {
        this.wRc.put(Long.valueOf(paramLong), wQX);
      }
      AppMethodBeat.o(96216);
      return;
    }
    finally {}
  }
  
  public final class a
  {
    public int position;
    public cm wRI;
    public List<String> wRJ;
    public List<String> wRK;
    
    public a()
    {
      AppMethodBeat.i(96211);
      this.wRJ = new ArrayList();
      this.wRK = new ArrayList();
      AppMethodBeat.o(96211);
    }
  }
  
  public final class b
  {
    public int position;
    public co wRL;
    
    b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.k.f
 * JD-Core Version:    0.7.0.1
 */