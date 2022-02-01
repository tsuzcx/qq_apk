package com.tencent.mm.plugin.multitask.d;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.ib;
import com.tencent.mm.f.b.a.ic;
import com.tencent.mm.f.b.a.id;
import com.tencent.mm.f.b.a.ie;
import com.tencent.mm.f.b.a.if;
import com.tencent.mm.kernel.b;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.protocal.protobuf.dam;
import com.tencent.mm.protocal.protobuf.dan;
import com.tencent.mm.protocal.protobuf.dao;
import com.tencent.mm.protocal.protobuf.dap;
import com.tencent.mm.protocal.protobuf.daq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitask/report/MultiTaskReportLogic;", "", "()V", "IDKEY_ID", "", "IDKEY_TYPE_APPBRAND", "IDKEY_TYPE_FAV", "IDKEY_TYPE_FILES", "IDKEY_TYPE_FINDER_MEGA_VIDEO", "IDKEY_TYPE_LUGGAGE", "IDKEY_TYPE_TOPSTORY_VIDEO", "IDKEY_TYPE_UNKOWN", "IDKEY_TYPE_WEBPAGE", "MAX_COST_TIME", "", "TAG", "", "getTAG", "()Ljava/lang/String;", "reportInfoMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getReportInfoMap", "()Ljava/util/HashMap;", "clear", "", "getItemType", "multiTaskType", "getLastExposeTime", "itemId", "(Ljava/lang/String;)Ljava/lang/Long;", "getMultiTaskContextId", "getScene", "index", "multiTaskEduReport", "reportInfo", "Lcom/tencent/mm/protocal/protobuf/MultiTaskEduReportData;", "multiTaskItemActionReport", "multiTaskInfo", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "contextId", "position", "action", "itemSubId", "multiTaskItemAddReport", "addType", "status", "multiTaskItemPageActionReport", "Lcom/tencent/mm/protocal/protobuf/MultiTaskReportData;", "multiTaskItemPageBrowse", "multiTaskPerformanceReport", "performanceData", "Lcom/tencent/mm/protocal/protobuf/MultiTaskPerformanceData;", "reportIDKey", "type", "time", "canConvertTranslucent", "", "setReportInfo", "exposeTime", "plugin-multitask_release"})
public final class a
{
  private static final HashMap<String, Long> FHN;
  public static final a FHO;
  private static final String TAG = "MicroMsg.MultiTaskReportLogic";
  
  static
  {
    AppMethodBeat.i(248868);
    FHO = new a();
    TAG = "MicroMsg.MultiTaskReportLogic";
    FHN = new HashMap();
    AppMethodBeat.o(248868);
  }
  
  private static long Yd(int paramInt)
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
  
  public static long Ye(int paramInt)
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
    AppMethodBeat.i(248867);
    Log.v(TAG, "reportIDKey: type=%d time=%d translucent=%b", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong), Boolean.valueOf(paramBoolean) });
    if ((paramLong <= 0L) || (paramLong > 30000L))
    {
      Log.v(TAG, "reportIDKey: error data");
      AppMethodBeat.o(248867);
      return;
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(248867);
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
      com.tencent.mm.plugin.report.service.h.IzE.b(localArrayList, false);
    }
  }
  
  public static void a(int paramInt, dap paramdap)
  {
    AppMethodBeat.i(248866);
    if (paramdap != null)
    {
      switch (paramInt)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(248866);
        return;
        a(0, paramdap.THU, paramdap.THV);
        AppMethodBeat.o(248866);
        return;
        a(5, paramdap.THU, paramdap.THV);
        AppMethodBeat.o(248866);
        return;
        a(10, paramdap.THU, paramdap.THV);
        AppMethodBeat.o(248866);
        return;
        a(15, paramdap.THU, paramdap.THV);
        AppMethodBeat.o(248866);
        return;
        a(20, paramdap.THU, paramdap.THV);
        AppMethodBeat.o(248866);
        return;
        a(25, paramdap.THU, paramdap.THV);
        AppMethodBeat.o(248866);
        return;
        a(30, paramdap.THU, paramdap.THV);
      }
    }
    AppMethodBeat.o(248866);
  }
  
  public static void a(MultiTaskInfo paramMultiTaskInfo, long paramLong1, long paramLong2, String paramString1, String paramString2)
  {
    AppMethodBeat.i(248861);
    if (paramMultiTaskInfo != null)
    {
      id localid = new id();
      localid.xI(paramMultiTaskInfo.field_id);
      localid.sx(Yd(paramMultiTaskInfo.field_type));
      localid.sy(paramLong1);
      localid.sz(paramLong2);
      localid.xJ(paramString1);
      localid.xK(paramString2);
      localid.bpa();
      AppMethodBeat.o(248861);
      return;
    }
    AppMethodBeat.o(248861);
  }
  
  public static void a(MultiTaskInfo paramMultiTaskInfo, String paramString1, long paramLong1, long paramLong2, String paramString2)
  {
    AppMethodBeat.i(248862);
    if (paramMultiTaskInfo != null)
    {
      ic localic = new ic();
      localic.xG(paramMultiTaskInfo.field_id);
      localic.ss(Yd(paramMultiTaskInfo.field_type));
      localic.xF(paramString1);
      localic.st(paramLong1);
      localic.su(cm.bfE());
      localic.sv(paramLong2);
      localic.xH(paramString2);
      paramMultiTaskInfo = paramMultiTaskInfo.field_id;
      p.j(paramMultiTaskInfo, "it.field_id");
      p.k(paramMultiTaskInfo, "itemId");
      if (FHN.containsKey(paramMultiTaskInfo))
      {
        paramMultiTaskInfo = (Long)FHN.get(paramMultiTaskInfo);
        if (paramMultiTaskInfo == null) {
          break label158;
        }
      }
      label158:
      for (paramLong1 = paramMultiTaskInfo.longValue();; paramLong1 = cm.bfE())
      {
        localic.sw(paramLong1);
        localic.bpa();
        AppMethodBeat.o(248862);
        return;
        paramMultiTaskInfo = Long.valueOf(cm.bfE());
        break;
      }
    }
    AppMethodBeat.o(248862);
  }
  
  public static void a(dan paramdan)
  {
    AppMethodBeat.i(248865);
    if (paramdan != null)
    {
      ib localib = new ib();
      localib.so(paramdan.THN);
      localib.sp(paramdan.THO);
      localib.sq(paramdan.duration);
      localib.sr(paramdan.THP);
      localib.bpa();
      AppMethodBeat.o(248865);
      return;
    }
    AppMethodBeat.o(248865);
  }
  
  public static void a(daq paramdaq)
  {
    AppMethodBeat.i(248863);
    if (paramdaq != null)
    {
      dam localdam = paramdaq.THX;
      if (localdam != null)
      {
        ie localie = new ie();
        localie.xM(paramdaq.THW);
        localie.sA(Yd(paramdaq.fNO));
        localie.xL(paramdaq.wmL);
        localie.xN(paramdaq.THE);
        localie.sB(localdam.duration);
        localie.bpa();
        AppMethodBeat.o(248863);
        return;
      }
    }
    AppMethodBeat.o(248863);
  }
  
  public static void b(daq paramdaq)
  {
    AppMethodBeat.i(248864);
    if (paramdaq != null)
    {
      dao localdao = paramdaq.THZ;
      if (localdao != null)
      {
        if localif = new if();
        localif.xO(paramdaq.wmL);
        localif.sC(localdao.jWO);
        localif.sD(localdao.kVd);
        localif.sE(localdao.THQ);
        localif.sF(localdao.THR);
        localif.sG(localdao.THS);
        localif.sH(localdao.duration);
        localif.sI(localdao.THT);
        localif.bpa();
        AppMethodBeat.o(248864);
        return;
      }
    }
    AppMethodBeat.o(248864);
  }
  
  public static void bc(String paramString, long paramLong)
  {
    AppMethodBeat.i(248858);
    p.k(paramString, "itemId");
    FHN.put(paramString, Long.valueOf(paramLong));
    AppMethodBeat.o(248858);
  }
  
  public static void clear()
  {
    AppMethodBeat.i(248857);
    FHN.clear();
    AppMethodBeat.o(248857);
  }
  
  public static String fbf()
  {
    AppMethodBeat.i(248860);
    Object localObject = new StringBuilder();
    p.j(com.tencent.mm.kernel.h.aHE(), "MMKernel.account()");
    localObject = MD5Util.getMD5String(Util.nullAsNil(String.valueOf(b.getUin())) + System.currentTimeMillis()).toString();
    AppMethodBeat.o(248860);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.d.a
 * JD-Core Version:    0.7.0.1
 */