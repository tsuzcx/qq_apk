package com.tencent.mm.plugin.sns.j;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.fi;
import com.tencent.mm.g.b.a.dy;
import com.tencent.mm.g.b.a.ea;
import com.tencent.mm.g.b.a.ec;
import com.tencent.mm.g.b.a.eg;
import com.tencent.mm.g.b.a.fm;
import com.tencent.mm.g.b.a.fo;
import com.tencent.mm.g.b.a.ig;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.sns.i.m;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.ui.bf;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.zf;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ah;
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
  private static final Integer ydD;
  public static f ydE;
  public ad fnt;
  public int gdl;
  private com.tencent.mm.sdk.b.c<fi> wUV;
  public HashMap<String, Integer> ydF;
  public HashMap<String, String> ydG;
  public HashSet<String> ydH;
  private LinkedHashMap<Long, Object> ydI;
  private int ydJ;
  public int ydK;
  public int ydL;
  public fm ydM;
  public Map<String, Integer> ydN;
  public Map<String, b> ydO;
  public Map<String, a> ydP;
  public eg ydQ;
  public List<String> ydR;
  public List<String> ydS;
  public List<String> ydT;
  public List<String> ydU;
  public List<String> ydV;
  public List<String> ydW;
  public long ydX;
  public long ydY;
  public long ydZ;
  public long yea;
  public long yeb;
  public long yec;
  private LinkedList<dy> yed;
  private List<String> yee;
  private List<String> yef;
  public long yeg;
  private long yeh;
  public long yei;
  public long yej;
  public fo yek;
  
  static
  {
    AppMethodBeat.i(96248);
    ydD = Integer.valueOf(1);
    ydE = new f();
    AppMethodBeat.o(96248);
  }
  
  private f()
  {
    AppMethodBeat.i(96212);
    this.ydJ = 0;
    this.ydK = 200;
    this.ydL = 86400;
    this.gdl = 0;
    this.wUV = new com.tencent.mm.sdk.b.c() {};
    this.ydM = new fm();
    this.ydN = new HashMap();
    this.ydO = new HashMap();
    this.ydP = new HashMap();
    this.ydQ = new eg();
    this.ydR = new ArrayList();
    this.ydS = new ArrayList();
    this.ydT = new ArrayList();
    this.ydU = new ArrayList();
    this.ydV = new ArrayList();
    this.ydW = new ArrayList();
    this.ydX = 0L;
    this.ydY = 0L;
    this.ydZ = 0L;
    this.yea = 0L;
    this.yeb = 0L;
    this.yec = 0L;
    this.yed = new LinkedList();
    this.yee = new ArrayList();
    this.yef = new ArrayList();
    this.yeg = 0L;
    this.yeh = 0L;
    this.yei = 0L;
    this.yej = 0L;
    this.yek = new fo();
    Object localObject1 = com.tencent.mm.model.c.d.aAp().tJ("100077");
    if (((com.tencent.mm.storage.c)localObject1).isValid())
    {
      localObject1 = ((com.tencent.mm.storage.c)localObject1).eYV();
      this.ydK = bs.getInt((String)((Map)localObject1).get("maxCacheFeedCount"), 200);
      this.ydL = bs.getInt((String)((Map)localObject1).get("maxCacheSeconds"), 86400);
      this.gdl = bs.getInt((String)((Map)localObject1).get("needUploadData"), 0);
    }
    ac.i("MicroMsg.SnsReportHelper", "initAbtestArg maxCacheFeedCount:%d, maxCacheSeconds:%d, needUploadData:%d", new Object[] { Integer.valueOf(this.ydK), Integer.valueOf(this.ydL), Integer.valueOf(this.gdl) });
    dJr();
    this.fnt = new ad(ah.GDu + "snsreport.cfg");
    localObject1 = this.fnt.get(3, new HashMap());
    Object localObject2 = this.fnt.get(4, new HashMap());
    Object localObject3 = this.fnt.get(5, new HashSet());
    Object localObject4 = this.fnt.get(6, new LinkedHashMap());
    if ((!(localObject1 instanceof HashMap)) || (!(localObject2 instanceof HashMap)) || (!(localObject3 instanceof HashSet)) || (!(localObject4 instanceof LinkedHashMap)))
    {
      i.deleteFile(ah.GDu + "snsreport.cfg");
      this.fnt.reset();
      this.ydF = new HashMap();
      this.ydG = new HashMap();
      this.ydH = new HashSet();
    }
    for (this.ydI = new LinkedHashMap();; this.ydI = ((LinkedHashMap)localObject4))
    {
      ac.d("MicroMsg.SnsReportHelper", "obj[%d] objForAppId[%d] objForFold[%d] objForAppIdCgi[%d] ", new Object[] { Integer.valueOf(this.ydF.size()), Integer.valueOf(this.ydG.size()), Integer.valueOf(this.ydH.size()), Integer.valueOf(this.ydI.size()) });
      com.tencent.mm.sdk.b.a.GpY.b(this.wUV);
      AppMethodBeat.o(96212);
      return;
      this.ydF = ((HashMap)localObject1);
      this.ydG = ((HashMap)localObject2);
      this.ydH = ((HashSet)localObject3);
    }
  }
  
  public static void auA(String paramString)
  {
    AppMethodBeat.i(96226);
    ig localig = new ig();
    localig.pm(paramString);
    localig.ejs = 3L;
    localig.ejt = 1L;
    localig.aHZ();
    AppMethodBeat.o(96226);
  }
  
  public static void auz(String paramString)
  {
    AppMethodBeat.i(96224);
    ig localig = new ig();
    localig.pm(paramString);
    localig.ejs = 1L;
    localig.ejt = 1L;
    localig.aHZ();
    AppMethodBeat.o(96224);
  }
  
  private void dJA()
  {
    AppMethodBeat.i(96245);
    this.yee.clear();
    this.yef.clear();
    this.yeg = 0L;
    this.yei = 0L;
    this.yeh = 0L;
    this.yej = 0L;
    AppMethodBeat.o(96245);
  }
  
  private void dJr()
  {
    AppMethodBeat.i(96215);
    this.ydJ = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pMf, 0);
    ac.i("MicroMsg.SnsReportHelper", "resetXExptControl maxFeedIdForCgiRecord[%d]", new Object[] { Integer.valueOf(this.ydJ) });
    AppMethodBeat.o(96215);
  }
  
  public static void eH(String paramString, int paramInt)
  {
    AppMethodBeat.i(96225);
    ig localig = new ig();
    localig.pm(paramString);
    localig.ejs = 2L;
    localig.ejt = paramInt;
    localig.aHZ();
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
  
  public final void E(p paramp)
  {
    AppMethodBeat.i(96234);
    if (paramp != null)
    {
      paramp = com.tencent.mm.plugin.sns.data.q.wX(paramp.field_snsId);
      if (!this.ydR.contains(paramp)) {
        this.ydR.add(paramp);
      }
    }
    AppMethodBeat.o(96234);
  }
  
  public final void F(p paramp)
  {
    AppMethodBeat.i(96235);
    if (paramp != null)
    {
      paramp = com.tencent.mm.plugin.sns.data.q.wX(paramp.field_snsId);
      if (!this.ydS.contains(paramp)) {
        this.ydS.add(paramp);
      }
    }
    AppMethodBeat.o(96235);
  }
  
  public final void G(p paramp)
  {
    AppMethodBeat.i(96236);
    if (paramp != null)
    {
      paramp = com.tencent.mm.plugin.sns.data.q.wX(paramp.field_snsId);
      if (!this.ydT.contains(paramp)) {
        this.ydT.add(paramp);
      }
    }
    AppMethodBeat.o(96236);
  }
  
  public final void OD(int paramInt)
  {
    if (this.ydM != null) {}
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      this.ydM.dXM = 1;
      return;
    case 1: 
      this.ydM.dXM = 2;
      return;
    case 2: 
      this.ydM.dXM = 3;
      return;
    }
    this.ydM.dXM = 4;
  }
  
  public final void a(View paramView, bf parambf, String paramString1, String paramString2, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(96227);
    String str;
    int i;
    if ((paramView != null) && (parambf != null) && (parambf.yUR != null) && (parambf.xHc != null) && (parambf.xHc.dLV() != null) && (parambf.xHc.dLV().FQo != null) && (this.ydO.get(com.tencent.mm.plugin.sns.data.q.wW(parambf.xHc.field_snsId)) == null))
    {
      str = u.axw();
      paramView = new ec();
      paramView.dJb = paramView.t("Username", parambf.xHc.field_userName, true);
      paramView.dTr = paramView.t("PublicID", com.tencent.mm.plugin.sns.data.q.wW(parambf.xHc.field_snsId), true);
      paramView.dTs = parambf.xHc.dLV().FQo.Ety;
      i = 0;
      paramString1 = paramString1.split(",");
      if (paramString1 != null) {
        i = paramString1.length;
      }
      paramView.dTt = i;
      i = 0;
      paramString1 = paramString2.split(",");
      if (paramString1 != null) {
        i = paramString1.length;
      }
      paramView.dTu = i;
      paramView.dTv = paramInt1;
      paramView.dTw = paramInt2;
      if (!paramBoolean) {
        break label434;
      }
      paramView.dTx = 1L;
      if (parambf.yVF == null) {
        break label468;
      }
      paramInt1 = 0;
      label232:
      if (paramInt1 >= parambf.yVF.size()) {
        break label468;
      }
      if (!bs.lr(str, (String)((com.tencent.mm.vending.j.a)parambf.yVF.get(paramInt1)).get(0))) {
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
      if (parambf.yVG != null) {
        i = 0;
      }
      for (;;)
      {
        paramInt2 = paramInt1;
        if (i < parambf.yVG.size())
        {
          paramString1 = (com.tencent.mm.vending.j.a)parambf.yVG.get(i);
          if ((!(paramString1.get(1) instanceof String)) || (!bs.lr(str, (String)paramString1.get(1)))) {
            break label459;
          }
          if (paramInt1 != 1) {
            break label453;
          }
        }
        for (paramInt2 = 3;; paramInt2 = 2)
        {
          paramView.dTy = parambf.yVG.size();
          paramView.dTB = paramInt2;
          paramView.dTJ = paramInt4;
          paramView.dTD = System.currentTimeMillis();
          paramString1 = new b();
          paramString1.position = paramInt3;
          paramString1.yer = paramView;
          this.ydO.put(com.tencent.mm.plugin.sns.data.q.wW(parambf.xHc.field_snsId), paramString1);
          AppMethodBeat.o(96227);
          return;
          paramView.dTx = 2L;
          break;
          paramInt1 += 1;
          break label232;
        }
        i += 1;
      }
    }
  }
  
  public final void aG(Map<String, List<String>> paramMap)
  {
    AppMethodBeat.i(96220);
    if ((paramMap != null) && (!paramMap.isEmpty()) && (this.ydM != null))
    {
      this.ydM.dXQ = paramMap.keySet().size();
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
      paramMap = this.ydM;
      paramMap.dXR = paramMap.t("SelectedChatroomList", localStringBuilder.toString(), true);
    }
    AppMethodBeat.o(96220);
  }
  
  public final void aH(Map<String, List<String>> paramMap)
  {
    AppMethodBeat.i(96222);
    if ((paramMap != null) && (!paramMap.isEmpty()) && (this.ydM != null))
    {
      this.ydM.dXW = paramMap.keySet().size();
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
      paramMap = this.ydM;
      paramMap.dXX = paramMap.t("SelectedLabelList", localStringBuilder.toString(), true);
    }
    AppMethodBeat.o(96222);
  }
  
  public final void b(p paramp, int paramInt)
  {
    AppMethodBeat.i(96237);
    if (paramp != null)
    {
      paramp = com.tencent.mm.plugin.sns.data.q.wX(paramp.field_snsId) + "_" + paramInt;
      if (!this.ydU.contains(paramp)) {
        this.ydU.add(paramp);
      }
    }
    AppMethodBeat.o(96237);
  }
  
  public final void bH(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(96213);
    if (this.gdl == 0)
    {
      AppMethodBeat.o(96213);
      return;
    }
    HashMap localHashMap = this.ydF;
    if (this.ydF.containsKey(paramString)) {}
    for (int i = ((Integer)this.ydF.get(paramString)).intValue() + 1;; i = 1)
    {
      localHashMap.put(paramString, Integer.valueOf(i));
      if (paramBoolean) {
        this.ydH.add(paramString);
      }
      AppMethodBeat.o(96213);
      return;
    }
  }
  
  public final void bI(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(96229);
    if (paramString != null)
    {
      paramString = (b)this.ydO.get(paramString);
      if ((paramString != null) && (paramString.yer != null))
      {
        if (paramBoolean)
        {
          paramString.yer.dTz = 1L;
          AppMethodBeat.o(96229);
          return;
        }
        paramString.yer.dTz = 3L;
      }
    }
    AppMethodBeat.o(96229);
  }
  
  public final void bJ(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(96230);
    if (paramString != null)
    {
      paramString = (b)this.ydO.get(paramString);
      if ((paramString != null) && (paramString.yer != null))
      {
        if (paramBoolean)
        {
          paramString.yer.dTC = 1L;
          AppMethodBeat.o(96230);
          return;
        }
        paramString.yer.dTK = 1L;
      }
    }
    AppMethodBeat.o(96230);
  }
  
  public final void c(p paramp, int paramInt)
  {
    AppMethodBeat.i(96238);
    if (paramp != null)
    {
      paramp = com.tencent.mm.plugin.sns.data.q.wX(paramp.field_snsId) + "_" + paramInt;
      if (!this.ydW.contains(paramp)) {
        this.ydW.add(paramp);
      }
    }
    AppMethodBeat.o(96238);
  }
  
  public final void d(p paramp, int paramInt)
  {
    AppMethodBeat.i(96243);
    if (paramp != null)
    {
      paramp = com.tencent.mm.plugin.sns.data.q.wX(paramp.field_snsId) + "_" + paramInt;
      if (!this.yee.contains(paramp)) {
        this.yee.add(paramp);
      }
    }
    AppMethodBeat.o(96243);
  }
  
  public final void dJB()
  {
    AppMethodBeat.i(96246);
    dy localdy = dJw();
    localdy.dTc = this.yee.size();
    localdy.dTd = this.yef.size();
    localdy.dTe = this.yej;
    localdy.dTf = this.yeh;
    ac.d("MicroMsg.SnsReportHelper", "doSnsAlbumFeedBehaviourReport:\n %s", new Object[] { localdy.PS() });
    localdy.aHZ();
    try
    {
      this.yed.removeLast();
      dJA();
      AppMethodBeat.o(96246);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.w("MicroMsg.SnsReportHelper", "doSnsAlbumFeedBehaviourReport remove err: %s", new Object[] { localException.getMessage() });
      }
    }
  }
  
  /* Error */
  public final void dJs()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 680
    //   5: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 108	com/tencent/mm/plugin/sns/j/f:ydJ	I
    //   12: ifgt +12 -> 24
    //   15: ldc_w 680
    //   18: invokestatic 103	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: new 6	com/tencent/mm/plugin/sns/j/f$1
    //   27: dup
    //   28: aload_0
    //   29: aload_0
    //   30: getfield 296	com/tencent/mm/plugin/sns/j/f:ydI	Ljava/util/LinkedHashMap;
    //   33: invokevirtual 683	java/util/LinkedHashMap:clone	()Ljava/lang/Object;
    //   36: checkcast 278	java/util/LinkedHashMap
    //   39: invokespecial 686	com/tencent/mm/plugin/sns/j/f$1:<init>	(Lcom/tencent/mm/plugin/sns/j/f;Ljava/util/LinkedHashMap;)V
    //   42: ldc_w 688
    //   45: invokestatic 693	com/tencent/mm/sdk/g/b:c	(Ljava/lang/Runnable;Ljava/lang/String;)V
    //   48: ldc_w 680
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
  
  public final LinkedList<Long> dJt()
  {
    try
    {
      AppMethodBeat.i(96218);
      Object localObject3 = (LinkedHashMap)this.ydI.clone();
      if ((((LinkedHashMap)localObject3).size() <= 0) || (this.ydJ <= 0))
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
          if (i > this.ydJ) {
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
  
  public final void dJu()
  {
    AppMethodBeat.i(96219);
    if ((this.ydM != null) && (this.ydM.dXM != -1))
    {
      Object localObject1 = this.ydM;
      ((fm)localObject1).dYb = ((fm)localObject1).t("MediaEditedPublishIds", com.tencent.mm.plugin.sns.data.q.dGE(), true);
      Object localObject2 = new StringBuilder();
      localObject1 = new StringBuilder();
      Object localObject3 = this.ydN.entrySet().iterator();
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
        localObject3 = this.ydM;
        ((fm)localObject3).dXO = ((fm)localObject3).t("ChatroomMemClickList", ((StringBuilder)localObject2).substring(0, i), true);
      }
      if (j != -1)
      {
        localObject2 = this.ydM;
        ((fm)localObject2).dXZ = ((fm)localObject2).t("ChatroomMemClickNumList", ((StringBuilder)localObject1).substring(0, j), true);
      }
      this.ydM.aHZ();
      this.ydM = new fm();
      this.ydN.clear();
    }
    AppMethodBeat.o(96219);
  }
  
  public final void dJv()
  {
    AppMethodBeat.i(96233);
    this.ydR.clear();
    this.ydS.clear();
    this.ydT.clear();
    this.ydU.clear();
    this.ydV.clear();
    this.ydW.clear();
    this.ydX = 0L;
    this.ydY = 0L;
    this.ydZ = 0L;
    this.yea = 0L;
    this.yeb = 0L;
    this.yec = 0L;
    AppMethodBeat.o(96233);
  }
  
  public final dy dJw()
  {
    AppMethodBeat.i(96239);
    dy localdy2 = (dy)this.yed.peekLast();
    dy localdy1 = localdy2;
    if (localdy2 == null) {
      localdy1 = new dy();
    }
    AppMethodBeat.o(96239);
    return localdy1;
  }
  
  public final dy dJx()
  {
    AppMethodBeat.i(96240);
    dy localdy = (dy)this.yed.peekLast();
    AppMethodBeat.o(96240);
    return localdy;
  }
  
  public final dy dJy()
  {
    AppMethodBeat.i(96241);
    dJA();
    dy localdy = new dy();
    this.yed.push(localdy);
    AppMethodBeat.o(96241);
    return localdy;
  }
  
  public final void dJz()
  {
    AppMethodBeat.i(96242);
    if (this.yeg != 0L)
    {
      this.yeh += System.currentTimeMillis() - this.yeg;
      this.yeg = 0L;
    }
    AppMethodBeat.o(96242);
  }
  
  public final void e(p paramp, int paramInt)
  {
    AppMethodBeat.i(96244);
    if (paramp != null)
    {
      paramp = com.tencent.mm.plugin.sns.data.q.wX(paramp.field_snsId) + "_" + paramInt;
      if (!this.yef.contains(paramp)) {
        this.yef.add(paramp);
      }
    }
    AppMethodBeat.o(96244);
  }
  
  public final void fB(List<String> paramList)
  {
    AppMethodBeat.i(96221);
    if ((paramList != null) && (!paramList.isEmpty()) && (this.ydM != null))
    {
      this.ydM.dXT = paramList.size();
      fm localfm = this.ydM;
      localfm.dXU = localfm.t("SelectedUINList", bs.n(paramList, "|"), true);
    }
    AppMethodBeat.o(96221);
  }
  
  public final void fC(List<m> paramList)
  {
    AppMethodBeat.i(96223);
    if ((paramList != null) && (!paramList.isEmpty()) && (this.ydM != null))
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
          localObject5 = com.tencent.mm.plugin.label.a.a.cWd().ajD(com.tencent.mm.plugin.label.a.a.cWd().ajA((String)localObject4));
          if ((localObject5 != null) && (((List)localObject5).size() != 0)) {
            paramList.append((String)localObject4).append("|").append(((List)localObject5).size()).append(";");
          }
        }
        this.ydM.dXK = ((List)localObject2).size();
        localObject2 = this.ydM;
        ((fm)localObject2).dXL = ((fm)localObject2).t("LatestTimelinePsotSettingLabelList", paramList.toString(), true);
      }
      if (((List)localObject1).size() > 0)
      {
        paramList = new StringBuilder();
        localObject2 = ((List)localObject1).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (String)((Iterator)localObject2).next();
          localObject4 = new ArrayList();
          localObject5 = com.tencent.mm.model.q.wa((String)localObject3);
          if (localObject5 != null)
          {
            localObject5 = ((List)localObject5).iterator();
            while (((Iterator)localObject5).hasNext())
            {
              String str = (String)((Iterator)localObject5).next();
              if (w.wG(str)) {
                ((List)localObject4).add(str);
              }
            }
            paramList.append((String)localObject3).append("|").append(((List)localObject4).size()).append(";");
          }
        }
        this.ydM.dXG = ((List)localObject1).size();
        localObject1 = this.ydM;
        ((fm)localObject1).dXH = ((fm)localObject1).t("LatestTimelinePsotSettingGroupList", paramList.toString(), true);
      }
      this.ydM.dXI = localArrayList.size();
      paramList = this.ydM;
      paramList.dXJ = paramList.t("LatestTimelinePsotSettingUinList", bs.n(localArrayList, "|"), true);
    }
    AppMethodBeat.o(96223);
  }
  
  public final void hk(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(96228);
    Iterator localIterator = ydE.ydO.entrySet().iterator();
    Object localObject = new ArrayList();
    while (localIterator.hasNext())
    {
      b localb = (b)((Map.Entry)localIterator.next()).getValue();
      if ((localb != null) && (localb.yer != null) && ((localb.position < paramInt1 - 1) || (localb.position > paramInt2)))
      {
        localb.yer.dTE = System.currentTimeMillis();
        localb.yer.aHZ();
        ((List)localObject).add(localb.yer.dTr);
      }
    }
    localIterator = ((List)localObject).iterator();
    while (localIterator.hasNext())
    {
      localObject = (String)localIterator.next();
      this.ydO.remove(localObject);
    }
    AppMethodBeat.o(96228);
  }
  
  public final void hl(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(96231);
    Iterator localIterator = this.ydP.entrySet().iterator();
    Object localObject = new ArrayList();
    while (localIterator.hasNext())
    {
      a locala = (a)((Map.Entry)localIterator.next()).getValue();
      if ((locala != null) && (locala.yeo != null) && ((locala.position < paramInt1 - 1) || (locala.position > paramInt2)))
      {
        ea localea = locala.yeo;
        localea.dTp = localea.t("ClickEmojiIconIdList", n(locala.yep, "|"), true);
        localea = locala.yeo;
        localea.dTq = localea.t("ClickEmojiIdList", n(locala.yeq, "|"), true);
        locala.yeo.aHZ();
        ((List)localObject).add(locala.yeo.dTm);
      }
    }
    localIterator = ((List)localObject).iterator();
    while (localIterator.hasNext())
    {
      localObject = (String)localIterator.next();
      this.ydP.remove(localObject);
    }
    AppMethodBeat.o(96231);
  }
  
  public final void jk(String paramString1, String paramString2)
  {
    AppMethodBeat.i(96214);
    if ((this.gdl == 0) || (bs.isNullOrNil(paramString1)) || (bs.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(96214);
      return;
    }
    this.ydG.put(paramString1, paramString2);
    AppMethodBeat.o(96214);
  }
  
  public final void xw(long paramLong)
  {
    try
    {
      AppMethodBeat.i(96216);
      if (this.ydJ > 0) {
        this.ydI.put(Long.valueOf(paramLong), ydD);
      }
      AppMethodBeat.o(96216);
      return;
    }
    finally {}
  }
  
  public final class a
  {
    public int position;
    public ea yeo;
    public List<String> yep;
    public List<String> yeq;
    
    public a()
    {
      AppMethodBeat.i(96211);
      this.yep = new ArrayList();
      this.yeq = new ArrayList();
      AppMethodBeat.o(96211);
    }
  }
  
  public final class b
  {
    public int position;
    public ec yer;
    
    b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.j.f
 * JD-Core Version:    0.7.0.1
 */