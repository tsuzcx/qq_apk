package com.tencent.mm.plugin.multitask.d;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.gg;
import com.tencent.mm.g.b.a.gh;
import com.tencent.mm.g.b.a.gi;
import com.tencent.mm.g.b.a.gj;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.crr;
import com.tencent.mm.protocal.protobuf.crs;
import com.tencent.mm.protocal.protobuf.crt;
import com.tencent.mm.protocal.protobuf.ffq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitask/report/MultiTaskReportLogic;", "", "()V", "IDKEY_ID", "", "IDKEY_TYPE_APPBRAND", "IDKEY_TYPE_FAV", "IDKEY_TYPE_FILES", "IDKEY_TYPE_FINDER_MEGA_VIDEO", "IDKEY_TYPE_LUGGAGE", "IDKEY_TYPE_TOPSTORY_VIDEO", "IDKEY_TYPE_UNKOWN", "IDKEY_TYPE_WEBPAGE", "TAG", "", "getTAG", "()Ljava/lang/String;", "reportInfoMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getReportInfoMap", "()Ljava/util/HashMap;", "clear", "", "getItemType", "multiTaskType", "getLastExposeTime", "itemId", "(Ljava/lang/String;)Ljava/lang/Long;", "getMultiTaskContextId", "getScene", "index", "multiTaskItemActionReport", "multiTaskInfo", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "contextId", "position", "action", "itemSubId", "multiTaskItemAddReport", "addType", "status", "multiTaskItemPageActionReport", "reportInfo", "Lcom/tencent/mm/protocal/protobuf/MultiTaskReportData;", "multiTaskItemPageBrowse", "multiTaskPerformanceReport", "performanceData", "Lcom/tencent/mm/protocal/protobuf/MultiTaskPerformanceData;", "reportIDKey", "type", "time", "canConvertTranslucent", "", "setReportInfo", "exposeTime", "plugin-multitask_release"})
public final class a
{
  private static final HashMap<String, Long> AbY;
  public static final a AbZ;
  private static final String TAG = "MicroMsg.MultiTaskReportLogic";
  
  static
  {
    AppMethodBeat.i(200637);
    AbZ = new a();
    TAG = "MicroMsg.MultiTaskReportLogic";
    AbY = new HashMap();
    AppMethodBeat.o(200637);
  }
  
  private static long RM(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return -1L;
    case 5: 
      return 0L;
    case 2: 
      return 1L;
    case 1: 
      return 2L;
    case 4: 
      return 3L;
    case 3: 
      return 4L;
    case 22: 
      return 5L;
    }
    return 6L;
  }
  
  public static long RN(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return -1L;
    case 0: 
      return 1L;
    case 1: 
      return 2L;
    case 2: 
      return 3L;
    }
    return 4L;
  }
  
  private static void a(int paramInt, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(258586);
    Log.v(TAG, "reportIDKey: type=%d time=%d translucent=%b", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong), Boolean.valueOf(paramBoolean) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(258586);
      return;
      IDKey localIDKey1 = new IDKey();
      localIDKey1.SetID(1627);
      localIDKey1.SetKey(paramInt + 1);
      localIDKey1.SetValue(paramLong);
      IDKey localIDKey2 = new IDKey();
      localIDKey2.SetID(1627);
      localIDKey2.SetKey(paramInt + 2);
      localIDKey2.SetValue(1L);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(localIDKey1);
      localArrayList.add(localIDKey2);
      if (!paramBoolean)
      {
        localIDKey1 = new IDKey();
        localIDKey1.SetID(1627);
        localIDKey1.SetKey(paramInt + 3);
        localIDKey1.SetValue(1L);
        localArrayList.add(localIDKey1);
      }
      h.CyF.b(localArrayList, false);
    }
  }
  
  public static void a(int paramInt, ffq paramffq)
  {
    AppMethodBeat.i(258585);
    if (paramffq != null)
    {
      switch (paramInt)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(258585);
        return;
        a(0, paramffq.UtZ, paramffq.Uua);
        AppMethodBeat.o(258585);
        return;
        a(5, paramffq.UtZ, paramffq.Uua);
        AppMethodBeat.o(258585);
        return;
        a(10, paramffq.UtZ, paramffq.Uua);
        AppMethodBeat.o(258585);
        return;
        a(15, paramffq.UtZ, paramffq.Uua);
        AppMethodBeat.o(258585);
        return;
        a(20, paramffq.UtZ, paramffq.Uua);
        AppMethodBeat.o(258585);
        return;
        a(25, paramffq.UtZ, paramffq.Uua);
        AppMethodBeat.o(258585);
        return;
        a(30, paramffq.UtZ, paramffq.Uua);
      }
    }
    AppMethodBeat.o(258585);
  }
  
  public static void a(MultiTaskInfo paramMultiTaskInfo, long paramLong1, long paramLong2, String paramString1, String paramString2)
  {
    AppMethodBeat.i(200633);
    if (paramMultiTaskInfo != null)
    {
      gh localgh = new gh();
      localgh.tP(paramMultiTaskInfo.field_id);
      localgh.qc(RM(paramMultiTaskInfo.field_type));
      localgh.qd(paramLong1);
      localgh.qe(paramLong2);
      localgh.tQ(paramString1);
      localgh.tR(paramString2);
      localgh.bfK();
      AppMethodBeat.o(200633);
      return;
    }
    AppMethodBeat.o(200633);
  }
  
  public static void a(MultiTaskInfo paramMultiTaskInfo, String paramString1, long paramLong1, long paramLong2, String paramString2)
  {
    AppMethodBeat.i(200634);
    if (paramMultiTaskInfo != null)
    {
      gg localgg = new gg();
      localgg.tN(paramMultiTaskInfo.field_id);
      localgg.pX(RM(paramMultiTaskInfo.field_type));
      localgg.tM(paramString1);
      localgg.pY(paramLong1);
      localgg.pZ(cl.aWA());
      localgg.qa(paramLong2);
      localgg.tO(paramString2);
      paramMultiTaskInfo = paramMultiTaskInfo.field_id;
      p.g(paramMultiTaskInfo, "it.field_id");
      p.h(paramMultiTaskInfo, "itemId");
      if (AbY.containsKey(paramMultiTaskInfo))
      {
        paramMultiTaskInfo = (Long)AbY.get(paramMultiTaskInfo);
        if (paramMultiTaskInfo == null) {
          break label158;
        }
      }
      label158:
      for (paramLong1 = paramMultiTaskInfo.longValue();; paramLong1 = cl.aWA())
      {
        localgg.qb(paramLong1);
        localgg.bfK();
        AppMethodBeat.o(200634);
        return;
        paramMultiTaskInfo = Long.valueOf(cl.aWA());
        break;
      }
    }
    AppMethodBeat.o(200634);
  }
  
  public static void a(crt paramcrt)
  {
    AppMethodBeat.i(200635);
    if (paramcrt != null)
    {
      crr localcrr = paramcrt.MwN;
      if (localcrr != null)
      {
        gi localgi = new gi();
        localgi.tT(paramcrt.MwM);
        localgi.qf(RM(paramcrt.dUm));
        localgi.tS(paramcrt.sGQ);
        localgi.tU(paramcrt.MwB);
        localgi.qg(localcrr.duration);
        localgi.bfK();
        AppMethodBeat.o(200635);
        return;
      }
    }
    AppMethodBeat.o(200635);
  }
  
  public static void b(crt paramcrt)
  {
    AppMethodBeat.i(200636);
    if (paramcrt != null)
    {
      crs localcrs = paramcrt.MwP;
      if (localcrs != null)
      {
        gj localgj = new gj();
        localgj.tV(paramcrt.sGQ);
        localgj.qh(localcrs.hlf);
        localgj.qi(localcrs.igp);
        localgj.qj(localcrs.MwJ);
        localgj.qk(localcrs.MwK);
        localgj.ql(localcrs.MwL);
        localgj.qm(localcrs.duration);
        localgj.bfK();
        AppMethodBeat.o(200636);
        return;
      }
    }
    AppMethodBeat.o(200636);
  }
  
  public static void bb(String paramString, long paramLong)
  {
    AppMethodBeat.i(200631);
    p.h(paramString, "itemId");
    AbY.put(paramString, Long.valueOf(paramLong));
    AppMethodBeat.o(200631);
  }
  
  public static void clear()
  {
    AppMethodBeat.i(200630);
    AbY.clear();
    AppMethodBeat.o(200630);
  }
  
  public static String erj()
  {
    AppMethodBeat.i(200632);
    Object localObject = new StringBuilder();
    p.g(g.aAf(), "MMKernel.account()");
    localObject = MD5Util.getMD5String(Util.nullAsNil(String.valueOf(com.tencent.mm.kernel.a.getUin())) + System.currentTimeMillis()).toString();
    AppMethodBeat.o(200632);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.d.a
 * JD-Core Version:    0.7.0.1
 */