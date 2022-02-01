package com.tencent.mm.plugin.sns.k;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.fw;
import com.tencent.mm.f.b.a.ev;
import com.tencent.mm.f.b.a.jy;
import com.tencent.mm.f.b.a.jz;
import com.tencent.mm.f.b.a.ko;
import com.tencent.mm.f.b.a.kt;
import com.tencent.mm.f.b.a.kw;
import com.tencent.mm.f.b.a.kx;
import com.tencent.mm.f.b.a.lb;
import com.tencent.mm.f.b.a.lc;
import com.tencent.mm.f.b.a.ld;
import com.tencent.mm.f.b.a.mt;
import com.tencent.mm.f.b.a.mv;
import com.tencent.mm.f.b.a.mw;
import com.tencent.mm.f.b.a.qk;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.bn;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adw;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.c;
import com.tencent.mm.vfs.u;
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

public final class g
{
  private static final Integer KhZ;
  public static g Kia;
  public long Gdf;
  public long KiA;
  private LinkedList<ko> KiB;
  private List<String> KiC;
  private List<String> KiD;
  public long KiE;
  private long KiF;
  public long KiG;
  public long KiH;
  public mv KiI;
  public mw KiJ;
  public mw KiK;
  public String KiL;
  public int KiM;
  public int KiN;
  public ev KiO;
  public int KiP;
  public jy KiQ;
  public Map<Long, lc> KiR;
  public lb KiS;
  public List<Long> KiT;
  public HashMap<String, Integer> Kib;
  public HashMap<String, String> Kic;
  public HashSet<String> Kid;
  private LinkedHashMap<Long, Object> Kie;
  private int Kif;
  public String Kig;
  public int Kih;
  public int Kii;
  public int Kij;
  public mt Kik;
  public Map<String, Integer> Kil;
  public Map<String, b> Kim;
  public Map<String, a> Kin;
  public ld Kio;
  public List<String> Kip;
  public List<String> Kiq;
  public List<String> Kir;
  public List<String> Kis;
  public List<String> Kit;
  public List<String> Kiu;
  public long Kiv;
  public long Kiw;
  public long Kix;
  public long Kiy;
  public long Kiz;
  public com.tencent.mm.storage.an iRa;
  public int jXZ;
  private IListener<fw> uCc;
  public long zUF;
  
  static
  {
    AppMethodBeat.i(96248);
    KhZ = Integer.valueOf(1);
    Kia = new g();
    AppMethodBeat.o(96248);
  }
  
  private g()
  {
    AppMethodBeat.i(96212);
    this.Kif = 0;
    this.Kig = "0";
    this.Kih = -1;
    this.Kii = 200;
    this.Kij = 86400;
    this.jXZ = 0;
    this.uCc = new IListener() {};
    this.Kik = new mt();
    this.Kil = new HashMap();
    this.Kim = new HashMap();
    this.Kin = new HashMap();
    this.Kio = new ld();
    this.Kip = new ArrayList();
    this.Kiq = new ArrayList();
    this.Kir = new ArrayList();
    this.Kis = new ArrayList();
    this.Kit = new ArrayList();
    this.Kiu = new ArrayList();
    this.Kiv = 0L;
    this.Kiw = 0L;
    this.Kix = 0L;
    this.Kiy = 0L;
    this.Kiz = 0L;
    this.KiA = 0L;
    this.KiB = new LinkedList();
    this.KiC = new ArrayList();
    this.KiD = new ArrayList();
    this.KiE = 0L;
    this.KiF = 0L;
    this.KiG = 0L;
    this.KiH = 0L;
    this.KiI = new mv();
    this.KiJ = new mw();
    this.KiK = new mw();
    this.KiL = "";
    this.KiM = 0;
    this.Gdf = 0L;
    this.KiN = 0;
    this.KiO = new ev();
    this.KiP = 0;
    this.KiQ = new jy();
    this.KiR = Collections.synchronizedMap(new HashMap());
    this.KiS = new lb();
    this.KiT = new ArrayList();
    this.zUF = 0L;
    Object localObject1 = com.tencent.mm.model.c.d.bgB().Mu("100077");
    if (((c)localObject1).isValid())
    {
      localObject1 = ((c)localObject1).hvz();
      this.Kii = Util.getInt((String)((Map)localObject1).get("maxCacheFeedCount"), 200);
      this.Kij = Util.getInt((String)((Map)localObject1).get("maxCacheSeconds"), 86400);
      this.jXZ = Util.getInt((String)((Map)localObject1).get("needUploadData"), 0);
    }
    Log.i("MicroMsg.SnsReportHelper", "initAbtestArg maxCacheFeedCount:%d, maxCacheSeconds:%d, needUploadData:%d", new Object[] { Integer.valueOf(this.Kii), Integer.valueOf(this.Kij), Integer.valueOf(this.jXZ) });
    fQm();
    this.iRa = new com.tencent.mm.storage.an(ar.Vgb + "snsreport.cfg");
    localObject1 = this.iRa.b(3, new HashMap());
    Object localObject2 = this.iRa.b(4, new HashMap());
    Object localObject3 = this.iRa.b(5, new HashSet());
    Object localObject4 = this.iRa.b(6, new LinkedHashMap());
    if ((!(localObject1 instanceof HashMap)) || (!(localObject2 instanceof HashMap)) || (!(localObject3 instanceof HashSet)) || (!(localObject4 instanceof LinkedHashMap)))
    {
      u.deleteFile(ar.Vgb + "snsreport.cfg");
      this.iRa.reset();
      this.Kib = new HashMap();
      this.Kic = new HashMap();
      this.Kid = new HashSet();
    }
    for (this.Kie = new LinkedHashMap();; this.Kie = ((LinkedHashMap)localObject4))
    {
      Log.d("MicroMsg.SnsReportHelper", "obj[%d] objForAppId[%d] objForFold[%d] objForAppIdCgi[%d] ", new Object[] { Integer.valueOf(this.Kib.size()), Integer.valueOf(this.Kic.size()), Integer.valueOf(this.Kid.size()), Integer.valueOf(this.Kie.size()) });
      EventCenter.instance.add(this.uCc);
      AppMethodBeat.o(96212);
      return;
      this.Kib = ((HashMap)localObject1);
      this.Kic = ((HashMap)localObject2);
      this.Kid = ((HashSet)localObject3);
    }
  }
  
  public static void a(int paramInt1, String paramString, int paramInt2, int paramInt3, long paramLong, int paramInt4)
  {
    AppMethodBeat.i(267123);
    a(paramInt1, paramString, paramInt2, paramInt3, paramLong, 0L, 0L, paramInt4);
    AppMethodBeat.o(267123);
  }
  
  public static void a(int paramInt1, String paramString, int paramInt2, int paramInt3, long paramLong1, long paramLong2, long paramLong3, int paramInt4)
  {
    AppMethodBeat.i(267124);
    int i;
    if (paramInt4 == 2)
    {
      i = ((Integer)h.aHG().aHp().get(ar.a.VDx, Integer.valueOf(0))).intValue();
      paramInt3 = 0;
      paramString = "";
    }
    for (;;)
    {
      ((ak)h.ag(ak.class)).snsToFinderPostReport(Kia.KiL, paramInt1, paramString, paramInt2, paramInt3, i, paramLong2, paramLong3, paramLong1, paramInt4);
      AppMethodBeat.o(267124);
      return;
      i = ((Integer)h.aHG().aHp().get(ar.a.VDw, Integer.valueOf(0))).intValue();
    }
  }
  
  public static void a(SnsObject paramSnsObject, int paramInt, String paramString)
  {
    AppMethodBeat.i(267126);
    int i;
    if (paramSnsObject != null)
    {
      if (!Util.isEqual(paramSnsObject.Username, z.bcZ())) {
        break label132;
      }
      if (!Util.isEqual(paramString, z.bcZ())) {
        break label127;
      }
      i = 2;
    }
    for (;;)
    {
      int j = paramSnsObject.CommentCount;
      int k = paramSnsObject.LikeCount;
      kw localkw = new kw();
      localkw.BJ(t.Qv(paramSnsObject.Id));
      localkw.BL(String.valueOf(paramInt));
      localkw.gPl = i;
      localkw.BK(paramString);
      localkw.gPo = 1;
      localkw.gPm = k;
      localkw.gPn = j;
      localkw.bpa();
      AppMethodBeat.o(267126);
      return;
      label127:
      i = 3;
      continue;
      label132:
      i = 1;
    }
  }
  
  public static void b(SnsInfo paramSnsInfo, int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(267125);
    int i;
    Object localObject;
    int k;
    int j;
    if (paramSnsInfo != null)
    {
      if (!Util.isEqual(paramSnsInfo.getUserName(), z.bcZ())) {
        break label148;
      }
      if (!Util.isEqual(paramString, z.bcZ())) {
        break label142;
      }
      i = 2;
      localObject = com.tencent.mm.plugin.sns.model.an.D(paramSnsInfo);
      if (localObject == null) {
        break label154;
      }
      k = ((SnsObject)localObject).CommentCount;
      j = ((SnsObject)localObject).LikeCount;
    }
    for (;;)
    {
      localObject = new kw();
      ((kw)localObject).BJ(t.Qv(paramSnsInfo.field_snsId));
      ((kw)localObject).BL(String.valueOf(paramInt1));
      ((kw)localObject).gPl = i;
      ((kw)localObject).BK(paramString);
      ((kw)localObject).gPo = paramInt2;
      ((kw)localObject).gPm = j;
      ((kw)localObject).gPn = k;
      ((kw)localObject).bpa();
      AppMethodBeat.o(267125);
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
  
  public static void baO(String paramString)
  {
    AppMethodBeat.i(96224);
    qk localqk = new qk();
    localqk.Hl(paramString);
    localqk.hjO = 1L;
    localqk.hjP = 1L;
    localqk.bpa();
    AppMethodBeat.o(96224);
  }
  
  public static void baP(String paramString)
  {
    AppMethodBeat.i(96226);
    qk localqk = new qk();
    localqk.Hl(paramString);
    localqk.hjO = 3L;
    localqk.hjP = 1L;
    localqk.bpa();
    AppMethodBeat.o(96226);
  }
  
  private void fQm()
  {
    AppMethodBeat.i(96215);
    this.Kif = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vug, 0);
    Log.i("MicroMsg.SnsReportHelper", "resetXExptControl maxFeedIdForCgiRecord[%d]", new Object[] { Integer.valueOf(this.Kif) });
    AppMethodBeat.o(96215);
  }
  
  private void fQv()
  {
    AppMethodBeat.i(96245);
    this.KiC.clear();
    this.KiD.clear();
    this.KiE = 0L;
    this.KiG = 0L;
    this.KiF = 0L;
    this.KiH = 0L;
    AppMethodBeat.o(96245);
  }
  
  public static void gj(String paramString, int paramInt)
  {
    AppMethodBeat.i(96225);
    qk localqk = new qk();
    localqk.Hl(paramString);
    localqk.hjO = 2L;
    localqk.hjP = paramInt;
    localqk.bpa();
    AppMethodBeat.o(96225);
  }
  
  public static void gk(String paramString, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(267129);
    jz localjz = new jz();
    localjz.gks = localjz.z("Publishid", paramString, true);
    localjz.giX = paramInt;
    paramString = com.tencent.mm.plugin.recordvideo.e.a.IeL;
    if (com.tencent.mm.plugin.recordvideo.e.a.M(MMApplicationContext.getContext(), "com.tencent.phoenix", "A24DC0755072F64C480DC06DCD3412BF")) {}
    for (paramInt = i;; paramInt = 2)
    {
      localjz.gMj = paramInt;
      localjz.bpa();
      AppMethodBeat.o(267129);
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
  
  public final void O(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(96234);
    if (paramSnsInfo != null)
    {
      paramSnsInfo = t.Qv(paramSnsInfo.field_snsId);
      if (!this.Kip.contains(paramSnsInfo)) {
        this.Kip.add(paramSnsInfo);
      }
    }
    AppMethodBeat.o(96234);
  }
  
  public final void P(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(96235);
    if (paramSnsInfo != null)
    {
      paramSnsInfo = t.Qv(paramSnsInfo.field_snsId);
      if (!this.Kiq.contains(paramSnsInfo)) {
        this.Kiq.add(paramSnsInfo);
      }
    }
    AppMethodBeat.o(96235);
  }
  
  public final void Q(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(96236);
    if (paramSnsInfo != null)
    {
      paramSnsInfo = t.Qv(paramSnsInfo.field_snsId);
      if (!this.Kir.contains(paramSnsInfo)) {
        this.Kir.add(paramSnsInfo);
      }
    }
    AppMethodBeat.o(96236);
  }
  
  public final void QS(long paramLong)
  {
    try
    {
      AppMethodBeat.i(96216);
      if (this.Kif > 0) {
        this.Kie.put(Long.valueOf(paramLong), KhZ);
      }
      AppMethodBeat.o(96216);
      return;
    }
    finally {}
  }
  
  public final void a(View paramView, bn parambn, String paramString1, String paramString2, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(96227);
    String str;
    int i;
    if ((paramView != null) && (parambn != null) && (parambn.JyZ != null) && (parambn.Jws != null) && (parambn.Jws.getTimeLine() != null) && (parambn.Jws.getTimeLine().ContentObj != null) && (this.Kim.get(t.Qu(parambn.Jws.field_snsId)) == null))
    {
      str = z.bcZ();
      paramView = new kx();
      paramView.gqd = paramView.z("Username", parambn.Jws.getUserName(), true);
      paramView.gPp = paramView.z("PublicID", t.Qu(parambn.Jws.field_snsId), true);
      paramView.gPq = parambn.Jws.getTimeLine().ContentObj.Sqq;
      i = 0;
      paramString1 = paramString1.split(",");
      if (paramString1 != null) {
        i = paramString1.length;
      }
      paramView.gPr = i;
      i = 0;
      paramString1 = paramString2.split(",");
      if (paramString1 != null) {
        i = paramString1.length;
      }
      paramView.gPs = i;
      paramView.gPt = paramInt1;
      paramView.gPu = paramInt2;
      if (!paramBoolean) {
        break label434;
      }
      paramView.gPv = 1L;
      if (parambn.LbZ == null) {
        break label468;
      }
      paramInt1 = 0;
      label232:
      if (paramInt1 >= parambn.LbZ.size()) {
        break label468;
      }
      if (!Util.isEqual(str, (String)((com.tencent.mm.vending.j.a)parambn.LbZ.get(paramInt1)).get(0))) {
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
      if (parambn.Lca != null) {
        i = 0;
      }
      for (;;)
      {
        paramInt2 = paramInt1;
        if (i < parambn.Lca.size())
        {
          paramString1 = (com.tencent.mm.vending.j.a)parambn.Lca.get(i);
          if ((!(paramString1.get(1) instanceof String)) || (!Util.isEqual(str, (String)paramString1.get(1)))) {
            break label459;
          }
          if (paramInt1 != 1) {
            break label453;
          }
        }
        for (paramInt2 = 3;; paramInt2 = 2)
        {
          paramView.gPw = parambn.Lca.size();
          paramView.gPy = paramInt2;
          paramView.gPF = paramInt4;
          paramView.gPA = System.currentTimeMillis();
          paramString1 = new b();
          paramString1.position = paramInt3;
          paramString1.Kja = paramView;
          this.Kim.put(t.Qu(parambn.Jws.field_snsId), paramString1);
          AppMethodBeat.o(96227);
          return;
          paramView.gPv = 2L;
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
    AppMethodBeat.i(267131);
    this.zUF = System.currentTimeMillis();
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = paramList.iterator();
    while (((Iterator)localObject).hasNext()) {
      localStringBuilder.append(t.Qv(((Long)((Iterator)localObject).next()).longValue())).append("#");
    }
    localObject = this.KiS;
    ((lb)localObject).gPZ = ((lb)localObject).z("FeedList", localStringBuilder.toString(), true);
    this.KiS.gPX = paramList.size();
    this.KiS.BT(t.Qv(paramLong));
    this.KiS.BT(t.Qv(paramLong));
    paramList = this.KiS;
    paramList.gjX = paramList.z("UserName", paramString, true);
    AppMethodBeat.o(267131);
  }
  
  public final void aI(Map<String, List<String>> paramMap)
  {
    AppMethodBeat.i(96220);
    if ((paramMap != null) && (!paramMap.isEmpty()) && (this.Kik != null))
    {
      this.Kik.gVF = paramMap.keySet().size();
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
      paramMap = this.Kik;
      paramMap.gVG = paramMap.z("SelectedChatroomList", localStringBuilder.toString(), true);
    }
    AppMethodBeat.o(96220);
  }
  
  public final void aJ(Map<String, List<String>> paramMap)
  {
    AppMethodBeat.i(96222);
    if ((paramMap != null) && (!paramMap.isEmpty()) && (this.Kik != null))
    {
      this.Kik.gVL = paramMap.keySet().size();
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
      paramMap = this.Kik;
      paramMap.gVM = paramMap.z("SelectedLabelList", localStringBuilder.toString(), true);
    }
    AppMethodBeat.o(96222);
  }
  
  public final void agg(int paramInt)
  {
    if (this.Kik != null) {}
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      this.Kik.gVB = 1;
      return;
    case 1: 
      this.Kik.gVB = 2;
      return;
    case 2: 
      this.Kik.gVB = 3;
      return;
    }
    this.Kik.gVB = 4;
  }
  
  public final void agh(int paramInt)
  {
    AppMethodBeat.i(267130);
    Iterator localIterator = this.KiR.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      lc locallc = (lc)localEntry.getValue();
      if (locallc != null)
      {
        locallc.gQe = paramInt;
        ((lc)localEntry.getValue()).bpa();
      }
    }
    this.KiR.clear();
    AppMethodBeat.o(267130);
  }
  
  public final void baN(String paramString)
  {
    AppMethodBeat.i(267121);
    Integer localInteger = (Integer)this.Kil.get(paramString);
    if (localInteger == null)
    {
      this.Kil.put(paramString, Integer.valueOf(1));
      AppMethodBeat.o(267121);
      return;
    }
    this.Kil.put(paramString, Integer.valueOf(localInteger.intValue() + 1));
    AppMethodBeat.o(267121);
  }
  
  public final void cx(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(96213);
    if (this.jXZ == 0)
    {
      AppMethodBeat.o(96213);
      return;
    }
    HashMap localHashMap = this.Kib;
    if (this.Kib.containsKey(paramString)) {}
    for (int i = ((Integer)this.Kib.get(paramString)).intValue() + 1;; i = 1)
    {
      localHashMap.put(paramString, Integer.valueOf(i));
      if (paramBoolean) {
        this.Kid.add(paramString);
      }
      AppMethodBeat.o(96213);
      return;
    }
  }
  
  public final void cy(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(96229);
    if (paramString != null)
    {
      paramString = (b)this.Kim.get(paramString);
      if ((paramString != null) && (paramString.Kja != null))
      {
        if (paramBoolean)
        {
          paramString.Kja.gPx = 1L;
          AppMethodBeat.o(96229);
          return;
        }
        paramString.Kja.gPx = 3L;
      }
    }
    AppMethodBeat.o(96229);
  }
  
  public final void cz(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(96230);
    if (paramString != null)
    {
      paramString = (b)this.Kim.get(paramString);
      if ((paramString != null) && (paramString.Kja != null))
      {
        if (paramBoolean)
        {
          paramString.Kja.gPz = 1L;
          AppMethodBeat.o(96230);
          return;
        }
        paramString.Kja.gPG = 1L;
      }
    }
    AppMethodBeat.o(96230);
  }
  
  public final void d(SnsInfo paramSnsInfo, int paramInt)
  {
    AppMethodBeat.i(96237);
    if (paramSnsInfo != null)
    {
      paramSnsInfo = t.Qv(paramSnsInfo.field_snsId) + "_" + paramInt;
      if (!this.Kis.contains(paramSnsInfo)) {
        this.Kis.add(paramSnsInfo);
      }
    }
    AppMethodBeat.o(96237);
  }
  
  public final void e(SnsInfo paramSnsInfo, int paramInt)
  {
    AppMethodBeat.i(96238);
    if (paramSnsInfo != null)
    {
      paramSnsInfo = t.Qv(paramSnsInfo.field_snsId) + "_" + paramInt;
      if (!this.Kiu.contains(paramSnsInfo)) {
        this.Kiu.add(paramSnsInfo);
      }
    }
    AppMethodBeat.o(96238);
  }
  
  public final void f(SnsInfo paramSnsInfo, int paramInt)
  {
    AppMethodBeat.i(96243);
    if (paramSnsInfo != null)
    {
      paramSnsInfo = t.Qv(paramSnsInfo.field_snsId) + "_" + paramInt;
      if (!this.KiC.contains(paramSnsInfo)) {
        this.KiC.add(paramSnsInfo);
      }
    }
    AppMethodBeat.o(96243);
  }
  
  /* Error */
  public final void fQn()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 891
    //   5: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 130	com/tencent/mm/plugin/sns/k/g:Kif	I
    //   12: ifgt +12 -> 24
    //   15: ldc_w 891
    //   18: invokestatic 125	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: new 6	com/tencent/mm/plugin/sns/k/g$1
    //   27: dup
    //   28: aload_0
    //   29: aload_0
    //   30: getfield 369	com/tencent/mm/plugin/sns/k/g:Kie	Ljava/util/LinkedHashMap;
    //   33: invokevirtual 894	java/util/LinkedHashMap:clone	()Ljava/lang/Object;
    //   36: checkcast 351	java/util/LinkedHashMap
    //   39: invokespecial 897	com/tencent/mm/plugin/sns/k/g$1:<init>	(Lcom/tencent/mm/plugin/sns/k/g;Ljava/util/LinkedHashMap;)V
    //   42: ldc_w 899
    //   45: invokestatic 905	com/tencent/mm/sdk/thread/ThreadPool:post	(Ljava/lang/Runnable;Ljava/lang/String;)V
    //   48: ldc_w 891
    //   51: invokestatic 125	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   54: goto -33 -> 21
    //   57: astore_1
    //   58: aload_0
    //   59: monitorexit
    //   60: aload_1
    //   61: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	62	0	this	g
    //   57	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	21	57	finally
    //   24	54	57	finally
  }
  
  public final LinkedList<Long> fQo()
  {
    try
    {
      AppMethodBeat.i(96218);
      Object localObject3 = (LinkedHashMap)this.Kie.clone();
      if ((((LinkedHashMap)localObject3).size() <= 0) || (this.Kif <= 0))
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
          if (i > this.Kif) {
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
  
  public final void fQp()
  {
    AppMethodBeat.i(96219);
    if ((this.Kik != null) && (this.Kik.gVB != -1))
    {
      Object localObject1 = this.Kik;
      ((mt)localObject1).gVQ = ((mt)localObject1).z("MediaEditedPublishIds", t.fNr(), true);
      Object localObject2 = new StringBuilder();
      localObject1 = new StringBuilder();
      Object localObject3 = this.Kil.entrySet().iterator();
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
        localObject3 = this.Kik;
        ((mt)localObject3).gVD = ((mt)localObject3).z("ChatroomMemClickList", ((StringBuilder)localObject2).substring(0, i), true);
      }
      if (j != -1)
      {
        localObject2 = this.Kik;
        ((mt)localObject2).gVO = ((mt)localObject2).z("ChatroomMemClickNumList", ((StringBuilder)localObject1).substring(0, j), true);
      }
      this.Kik.bpa();
      this.Kik = new mt();
      this.Kil.clear();
    }
    AppMethodBeat.o(96219);
  }
  
  public final void fQq()
  {
    AppMethodBeat.i(96233);
    this.Kip.clear();
    this.Kiq.clear();
    this.Kir.clear();
    this.Kis.clear();
    this.Kit.clear();
    this.Kiu.clear();
    this.Kiv = 0L;
    this.Kiw = 0L;
    this.Kix = 0L;
    this.Kiy = 0L;
    this.Kiz = 0L;
    this.KiA = 0L;
    AppMethodBeat.o(96233);
  }
  
  public final ko fQr()
  {
    AppMethodBeat.i(96239);
    ko localko2 = (ko)this.KiB.peekLast();
    ko localko1 = localko2;
    if (localko2 == null) {
      localko1 = new ko();
    }
    AppMethodBeat.o(96239);
    return localko1;
  }
  
  public final ko fQs()
  {
    AppMethodBeat.i(96240);
    ko localko = (ko)this.KiB.peekLast();
    AppMethodBeat.o(96240);
    return localko;
  }
  
  public final ko fQt()
  {
    AppMethodBeat.i(96241);
    fQv();
    ko localko = new ko();
    this.KiB.push(localko);
    AppMethodBeat.o(96241);
    return localko;
  }
  
  public final void fQu()
  {
    AppMethodBeat.i(96242);
    if (this.KiE != 0L)
    {
      this.KiF += System.currentTimeMillis() - this.KiE;
      this.KiE = 0L;
    }
    AppMethodBeat.o(96242);
  }
  
  public final void fQw()
  {
    AppMethodBeat.i(96246);
    ko localko = fQr();
    localko.gOA = this.KiC.size();
    localko.gOB = this.KiD.size();
    localko.gOC = this.KiH;
    localko.gOD = this.KiF;
    Log.d("MicroMsg.SnsReportHelper", "doSnsAlbumFeedBehaviourReport:\n %s", new Object[] { localko.agI() });
    localko.bpa();
    try
    {
      this.KiB.removeLast();
      fQv();
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
  
  public final void fQx()
  {
    AppMethodBeat.i(267122);
    this.KiK.giq = 2L;
    this.KiK.bpa();
    this.KiK = new mw();
    AppMethodBeat.o(267122);
  }
  
  public final void fQy()
  {
    AppMethodBeat.i(267127);
    this.KiO.bpa();
    this.KiO = new ev();
    AppMethodBeat.o(267127);
  }
  
  public final void fQz()
  {
    AppMethodBeat.i(267128);
    this.KiQ.bpa();
    this.KiQ = new jy();
    AppMethodBeat.o(267128);
  }
  
  public final void g(SnsInfo paramSnsInfo, int paramInt)
  {
    AppMethodBeat.i(96244);
    if (paramSnsInfo != null)
    {
      paramSnsInfo = t.Qv(paramSnsInfo.field_snsId) + "_" + paramInt;
      if (!this.KiD.contains(paramSnsInfo)) {
        this.KiD.add(paramSnsInfo);
      }
    }
    AppMethodBeat.o(96244);
  }
  
  public final void hC(List<String> paramList)
  {
    AppMethodBeat.i(96221);
    if ((paramList != null) && (!paramList.isEmpty()) && (this.Kik != null))
    {
      this.Kik.gVI = paramList.size();
      mt localmt = this.Kik;
      localmt.gVJ = localmt.z("SelectedUINList", Util.listToString(paramList, "|"), true);
    }
    AppMethodBeat.o(96221);
  }
  
  public final void jG(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(96228);
    Iterator localIterator = Kia.Kim.entrySet().iterator();
    Object localObject = new ArrayList();
    while (localIterator.hasNext())
    {
      b localb = (b)((Map.Entry)localIterator.next()).getValue();
      if ((localb != null) && (localb.Kja != null) && ((localb.position < paramInt1 - 1) || (localb.position > paramInt2)))
      {
        localb.Kja.gPB = System.currentTimeMillis();
        localb.Kja.bpa();
        ((List)localObject).add(localb.Kja.gPp);
      }
    }
    localIterator = ((List)localObject).iterator();
    while (localIterator.hasNext())
    {
      localObject = (String)localIterator.next();
      this.Kim.remove(localObject);
    }
    AppMethodBeat.o(96228);
  }
  
  public final void jH(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(96231);
    Iterator localIterator = this.Kin.entrySet().iterator();
    Object localObject = new ArrayList();
    while (localIterator.hasNext())
    {
      a locala = (a)((Map.Entry)localIterator.next()).getValue();
      if ((locala != null) && (locala.KiX != null) && ((locala.position < paramInt1 - 1) || (locala.position > paramInt2)))
      {
        kt localkt = locala.KiX;
        localkt.gPa = localkt.z("ClickEmojiIconIdList", listToString(locala.KiY, "|"), true);
        localkt = locala.KiX;
        localkt.gPb = localkt.z("ClickEmojiIdList", listToString(locala.KiZ, "|"), true);
        locala.KiX.bpa();
        ((List)localObject).add(locala.KiX.gOX);
      }
    }
    localIterator = ((List)localObject).iterator();
    while (localIterator.hasNext())
    {
      localObject = (String)localIterator.next();
      this.Kin.remove(localObject);
    }
    AppMethodBeat.o(96231);
  }
  
  public final void kL(String paramString1, String paramString2)
  {
    AppMethodBeat.i(96214);
    if ((this.jXZ == 0) || (Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(96214);
      return;
    }
    this.Kic.put(paramString1, paramString2);
    AppMethodBeat.o(96214);
  }
  
  public final class a
  {
    public kt KiX;
    public List<String> KiY;
    public List<String> KiZ;
    public int position;
    
    public a()
    {
      AppMethodBeat.i(96211);
      this.KiY = new ArrayList();
      this.KiZ = new ArrayList();
      AppMethodBeat.o(96211);
    }
  }
  
  public final class b
  {
    public kx Kja;
    public int position;
    
    b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.k.g
 * JD-Core Version:    0.7.0.1
 */