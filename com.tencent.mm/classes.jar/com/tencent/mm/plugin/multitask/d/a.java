package com.tencent.mm.plugin.multitask.d;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.kf;
import com.tencent.mm.autogen.mmdata.rpt.kg;
import com.tencent.mm.autogen.mmdata.rpt.kh;
import com.tencent.mm.autogen.mmdata.rpt.ki;
import com.tencent.mm.autogen.mmdata.rpt.kj;
import com.tencent.mm.kernel.b;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.protocal.protobuf.dru;
import com.tencent.mm.protocal.protobuf.drv;
import com.tencent.mm.protocal.protobuf.drw;
import com.tencent.mm.protocal.protobuf.drx;
import com.tencent.mm.protocal.protobuf.dry;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitask/report/MultiTaskReportLogic;", "", "()V", "IDKEY_ID", "", "IDKEY_TYPE_APPBRAND", "IDKEY_TYPE_FAV", "IDKEY_TYPE_FILES", "IDKEY_TYPE_FINDER_MEGA_VIDEO", "IDKEY_TYPE_LUGGAGE", "IDKEY_TYPE_TOPSTORY_VIDEO", "IDKEY_TYPE_UNKOWN", "IDKEY_TYPE_WEBPAGE", "MAX_COST_TIME", "", "TAG", "", "getTAG", "()Ljava/lang/String;", "reportInfoMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getReportInfoMap", "()Ljava/util/HashMap;", "clear", "", "getItemType", "multiTaskType", "getLastExposeTime", "itemId", "(Ljava/lang/String;)Ljava/lang/Long;", "getMultiTaskContextId", "getScene", "index", "multiTaskEduReport", "reportInfo", "Lcom/tencent/mm/protocal/protobuf/MultiTaskEduReportData;", "multiTaskItemActionReport", "multiTaskInfo", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "contextId", "position", "action", "itemSubId", "multiTaskItemAddReport", "addType", "status", "multiTaskItemPageActionReport", "Lcom/tencent/mm/protocal/protobuf/MultiTaskReportData;", "multiTaskItemPageBrowse", "multiTaskPerformanceReport", "performanceData", "Lcom/tencent/mm/protocal/protobuf/MultiTaskPerformanceData;", "reportIDKey", "type", "time", "canConvertTranslucent", "", "setReportInfo", "exposeTime", "plugin-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a LDj;
  private static final HashMap<String, Long> LDk;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(303806);
    LDj = new a();
    TAG = "MicroMsg.MultiTaskReportLogic";
    LDk = new HashMap();
    AppMethodBeat.o(303806);
  }
  
  public static void a(int paramInt, drx paramdrx)
  {
    AppMethodBeat.i(303772);
    if (paramdrx != null) {
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(303772);
      return;
      b(0, paramdrx.aaXD, paramdrx.aaXE);
      AppMethodBeat.o(303772);
      return;
      b(5, paramdrx.aaXD, paramdrx.aaXE);
      AppMethodBeat.o(303772);
      return;
      b(10, paramdrx.aaXD, paramdrx.aaXE);
      AppMethodBeat.o(303772);
      return;
      b(15, paramdrx.aaXD, paramdrx.aaXE);
      AppMethodBeat.o(303772);
      return;
      b(20, paramdrx.aaXD, paramdrx.aaXE);
      AppMethodBeat.o(303772);
      return;
      b(25, paramdrx.aaXD, paramdrx.aaXE);
      AppMethodBeat.o(303772);
      return;
      b(30, paramdrx.aaXD, paramdrx.aaXE);
    }
  }
  
  public static void a(MultiTaskInfo paramMultiTaskInfo, long paramLong1, long paramLong2, String paramString1, String paramString2)
  {
    AppMethodBeat.i(303735);
    if (paramMultiTaskInfo != null)
    {
      kh localkh = new kh();
      localkh.iBL = localkh.F("ItemId", paramMultiTaskInfo.field_id, true);
      localkh.iuW = acq(paramMultiTaskInfo.field_type);
      localkh.iWn = paramLong1;
      localkh.iyK = paramLong2;
      localkh.ipT = localkh.F("ContextId", paramString1, true);
      localkh.iWl = localkh.F("ItemSubId", paramString2, true);
      localkh.bMH();
    }
    AppMethodBeat.o(303735);
  }
  
  public static void a(MultiTaskInfo paramMultiTaskInfo, String paramString1, long paramLong1, long paramLong2, String paramString2)
  {
    AppMethodBeat.i(303744);
    kg localkg;
    if (paramMultiTaskInfo != null)
    {
      localkg = new kg();
      localkg.iBL = localkg.F("ItemId", paramMultiTaskInfo.field_id, true);
      localkg.iuW = acq(paramMultiTaskInfo.field_type);
      localkg.ipT = localkg.F("ContextId", paramString1, true);
      localkg.iMe = paramLong1;
      localkg.iWk = cn.bDw();
      localkg.ikE = paramLong2;
      localkg.iWl = localkg.F("ItemSubId", paramString2, true);
      paramMultiTaskInfo = paramMultiTaskInfo.field_id;
      s.s(paramMultiTaskInfo, "it.field_id");
      s.u(paramMultiTaskInfo, "itemId");
      if (!LDk.containsKey(paramMultiTaskInfo)) {
        break label161;
      }
      paramMultiTaskInfo = (Long)LDk.get(paramMultiTaskInfo);
      if (paramMultiTaskInfo != null) {
        break label171;
      }
    }
    label161:
    label171:
    for (paramLong1 = cn.bDw();; paramLong1 = paramMultiTaskInfo.longValue())
    {
      localkg.iWm = paramLong1;
      localkg.bMH();
      AppMethodBeat.o(303744);
      return;
      paramMultiTaskInfo = Long.valueOf(cn.bDw());
      break;
    }
  }
  
  public static void a(drv paramdrv)
  {
    AppMethodBeat.i(303764);
    if (paramdrv != null)
    {
      kf localkf = new kf();
      localkf.iWi = paramdrv.aaXw;
      localkf.iDn = paramdrv.aaXx;
      localkf.iCW = paramdrv.duration;
      localkf.iWj = paramdrv.aaXy;
      localkf.bMH();
    }
    AppMethodBeat.o(303764);
  }
  
  public static void a(dry paramdry)
  {
    AppMethodBeat.i(303755);
    if (paramdry != null)
    {
      dru localdru = paramdry.aaXG;
      if (localdru != null)
      {
        ki localki = new ki();
        localki.iBL = localki.F("ItemId", paramdry.aaXF, true);
        localki.iuW = acq(paramdry.itemType);
        localki.ipT = localki.F("ContextId", paramdry.zIO, true);
        localki.iWl = localki.F("ItemSubId", paramdry.aaXn, true);
        localki.iCW = localdru.duration;
        localki.bMH();
      }
    }
    AppMethodBeat.o(303755);
  }
  
  private static long acq(int paramInt)
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
  
  public static long acr(int paramInt)
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
  
  private static void b(int paramInt, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(303778);
    Log.v(TAG, "reportIDKey: type=%d time=%d translucent=%b", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong), Boolean.valueOf(paramBoolean) });
    if ((paramLong <= 0L) || (paramLong > 30000L))
    {
      Log.v(TAG, "reportIDKey: error data");
      AppMethodBeat.o(303778);
      return;
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(303778);
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
      com.tencent.mm.plugin.report.service.h.OAn.b(localArrayList, false);
    }
  }
  
  public static void b(dry paramdry)
  {
    AppMethodBeat.i(303760);
    if (paramdry != null)
    {
      drw localdrw = paramdry.aaXI;
      if (localdrw != null)
      {
        kj localkj = new kj();
        localkj.ipT = localkj.F("ContextId", paramdry.zIO, true);
        localkj.ikE = localdrw.mwI;
        localkj.iqr = localdrw.nAz;
        localkj.iWo = localdrw.aaXz;
        localkj.iTq = localdrw.aaXA;
        localkj.iWp = localdrw.aaXB;
        localkj.iCW = localdrw.duration;
        localkj.iWq = localdrw.aaXC;
        localkj.bMH();
      }
    }
    AppMethodBeat.o(303760);
  }
  
  public static void bm(String paramString, long paramLong)
  {
    AppMethodBeat.i(303721);
    s.u(paramString, "itemId");
    LDk.put(paramString, Long.valueOf(paramLong));
    AppMethodBeat.o(303721);
  }
  
  public static void clear()
  {
    AppMethodBeat.i(303716);
    LDk.clear();
    AppMethodBeat.o(303716);
  }
  
  public static String gkk()
  {
    AppMethodBeat.i(303730);
    com.tencent.mm.kernel.h.baC();
    String str = MD5Util.getMD5String(s.X(Util.nullAsNil(String.valueOf(b.getUin())), Long.valueOf(System.currentTimeMillis()))).toString();
    AppMethodBeat.o(303730);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.d.a
 * JD-Core Version:    0.7.0.1
 */