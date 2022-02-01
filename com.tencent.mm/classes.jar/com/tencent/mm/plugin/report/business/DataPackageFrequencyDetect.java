package com.tencent.mm.plugin.report.business;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.af;
import com.tencent.mm.network.af.a;
import com.tencent.mm.plugin.expt.h.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.vendor.Huawei;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/report/business/DataPackageFrequencyDetect;", "Lcom/tencent/mm/network/MMPushCore$IDataPackageReporter;", "()V", "TAG", "", "dataPackageInfoList", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/report/business/DataPackageFrequencyDetect$DataPackageInfo;", "isScreenOff", "", "receiver", "Lcom/tencent/mm/plugin/report/business/DataPackageFrequencyDetect$Receiver;", "addNetReq", "", "type", "", "length", "addNetResp", "cgi", "canDataPackageFrequencyStatistics", "canStatisticsOtherStratagy", "dataPackageStatisticsOnlyHuawei", "formatTimeMillis", "timeMillis", "ifMatchHuaweiBatteryStratagy", "Lcom/tencent/mm/plugin/report/business/DataPackageFrequencyDetect$CheckResult;", "sortedTimeList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "maxInterval", "eachInterval", "init", "application", "Landroid/app/Application;", "reportDataFrequency", "action", "reqNum", "respNum", "dataStartTime", "dataEndTime", "reqContent", "respContent", "checkResult", "reportDataPackageFrequency", "CheckResult", "DataPackageInfo", "Receiver", "plugin-report_release"})
public final class DataPackageFrequencyDetect
  implements af.a
{
  private static final Receiver IyA;
  private static final ConcurrentHashMap<Long, b> IyB;
  public static final DataPackageFrequencyDetect IyC;
  private static final String TAG = "MicroMsg.DataPackageFrequencyDetect";
  private static boolean ddZ;
  
  static
  {
    AppMethodBeat.i(194586);
    IyC = new DataPackageFrequencyDetect();
    TAG = "MicroMsg.DataPackageFrequencyDetect";
    IyA = new Receiver();
    IyB = new ConcurrentHashMap();
    AppMethodBeat.o(194586);
  }
  
  public static String GD(long paramLong)
  {
    AppMethodBeat.i(194578);
    Object localObject = new Date(paramLong);
    localObject = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format((Date)localObject);
    AppMethodBeat.o(194578);
    return localObject;
  }
  
  private static a a(ArrayList<Long> paramArrayList, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(194561);
    if (paramArrayList.size() < 2)
    {
      paramArrayList = new a(false, 0L, 0L);
      AppMethodBeat.o(194561);
      return paramArrayList;
    }
    long l1 = ((Number)paramArrayList.get(paramArrayList.size() - 1)).longValue();
    Object localObject1 = paramArrayList.get(0);
    p.j(localObject1, "sortedTimeList[0]");
    if (l1 - ((Number)localObject1).longValue() < paramLong1)
    {
      paramArrayList = new a(false, 0L, 0L);
      AppMethodBeat.o(194561);
      return paramArrayList;
    }
    localObject1 = new ArrayList();
    Object localObject2 = (Iterable)paramArrayList;
    int i = 0;
    localObject2 = ((Iterable)localObject2).iterator();
    long l2;
    for (l1 = -1L; ((Iterator)localObject2).hasNext(); l1 = l2)
    {
      Object localObject3 = ((Iterator)localObject2).next();
      if (i < 0) {
        j.iBO();
      }
      l2 = ((Number)localObject3).longValue();
      if ((l1 != -1L) && (l2 - l1 > paramLong2)) {
        ((ArrayList)localObject1).add(Integer.valueOf(i));
      }
      i += 1;
    }
    if (((ArrayList)localObject1).size() == 0)
    {
      localObject1 = paramArrayList.get(0);
      p.j(localObject1, "sortedTimeList[0]");
      paramLong1 = ((Number)localObject1).longValue();
      paramArrayList = paramArrayList.get(paramArrayList.size() - 1);
      p.j(paramArrayList, "sortedTimeList[sortedTimeList.size - 1]");
      paramArrayList = new a(true, paramLong1, ((Number)paramArrayList).longValue());
      AppMethodBeat.o(194561);
      return paramArrayList;
    }
    localObject2 = paramArrayList.get(0);
    p.j(localObject2, "sortedTimeList[0]");
    paramLong2 = ((Number)localObject2).longValue();
    localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Integer)((Iterator)localObject1).next();
      if (((Number)paramArrayList.get(((Integer)localObject2).intValue() - 1)).longValue() - paramLong2 >= paramLong1)
      {
        paramArrayList = paramArrayList.get(((Integer)localObject2).intValue() - 1);
        p.j(paramArrayList, "sortedTimeList[i - 1]");
        paramArrayList = new a(true, paramLong2, ((Number)paramArrayList).longValue());
        AppMethodBeat.o(194561);
        return paramArrayList;
      }
      p.j(localObject2, "i");
      localObject2 = paramArrayList.get(((Integer)localObject2).intValue());
      p.j(localObject2, "sortedTimeList[i]");
      paramLong2 = ((Number)localObject2).longValue();
    }
    paramArrayList = new a(false, 0L, 0L);
    AppMethodBeat.o(194561);
    return paramArrayList;
  }
  
  private static void a(int paramInt, ArrayList<Long> paramArrayList, ConcurrentHashMap<Long, b> paramConcurrentHashMap, a parama)
  {
    AppMethodBeat.i(194574);
    int i = paramArrayList.indexOf(Long.valueOf(parama.startTime));
    int k = paramArrayList.indexOf(Long.valueOf(parama.endTime));
    Object localObject2 = new HashMap();
    Object localObject1 = new HashMap();
    long l2 = 0L;
    long l1 = 0L;
    long l3 = l1;
    long l4 = l2;
    Object localObject3;
    if (i <= k)
    {
      l3 = l2;
      l4 = l1;
      localObject3 = (b)paramConcurrentHashMap.get(paramArrayList.get(i));
      l1 = l4;
      l2 = l3;
      int j;
      Object localObject4;
      if (localObject3 != null)
      {
        if (!((b)localObject3).IyD) {
          break label229;
        }
        l2 = l3 + 1L;
        j = 0;
        if (((HashMap)localObject2).containsKey(Integer.valueOf(((b)localObject3).type)))
        {
          localObject4 = ((HashMap)localObject2).get(Integer.valueOf(((b)localObject3).type));
          if (localObject4 == null) {
            p.iCn();
          }
          j = ((Number)localObject4).intValue();
        }
        ((HashMap)localObject2).put(Integer.valueOf(((b)localObject3).type), Integer.valueOf(j + 1));
        l1 = l4;
      }
      for (;;)
      {
        l3 = l1;
        l4 = l2;
        if (i == k) {
          break label306;
        }
        i += 1;
        l4 = l1;
        l3 = l2;
        break;
        label229:
        l1 = l4 + 1L;
        j = 0;
        if (((HashMap)localObject1).containsKey(((b)localObject3).cgi))
        {
          localObject4 = ((HashMap)localObject1).get(((b)localObject3).cgi);
          if (localObject4 == null) {
            p.iCn();
          }
          j = ((Number)localObject4).intValue();
        }
        ((HashMap)localObject1).put(((b)localObject3).cgi, Integer.valueOf(j + 1));
        l2 = l3;
      }
    }
    label306:
    paramArrayList = new StringBuilder();
    paramConcurrentHashMap = ((HashMap)localObject2).entrySet();
    p.j(paramConcurrentHashMap, "reqMap.entries");
    paramConcurrentHashMap = ((Iterable)paramConcurrentHashMap).iterator();
    while (paramConcurrentHashMap.hasNext())
    {
      localObject2 = (Map.Entry)paramConcurrentHashMap.next();
      paramArrayList.append((Integer)((Map.Entry)localObject2).getKey() + '_' + (Integer)((Map.Entry)localObject2).getValue() + ';');
    }
    paramConcurrentHashMap = new StringBuilder();
    localObject1 = ((HashMap)localObject1).entrySet();
    p.j(localObject1, "respMap.entries");
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      localObject3 = ((Map.Entry)localObject2).getKey();
      p.j(localObject3, "it.key");
      localObject3 = kotlin.n.n.pz((String)localObject3, "/");
      paramConcurrentHashMap.append((String)localObject3 + '_' + (Integer)((Map.Entry)localObject2).getValue() + ';');
    }
    l1 = parama.startTime;
    l2 = parama.endTime;
    paramArrayList = paramArrayList.toString();
    p.j(paramArrayList, "reqContent.toString()");
    paramConcurrentHashMap = paramConcurrentHashMap.toString();
    p.j(paramConcurrentHashMap, "respContent.toString()");
    parama = new com.tencent.mm.f.b.a.n();
    parama.kV(paramInt);
    parama.cb(l4);
    parama.cc(l3);
    parama.cd(l1);
    parama.ce(l2);
    parama.iF(paramArrayList);
    parama.iG(paramConcurrentHashMap);
    parama.cf(l4 + l3);
    parama.bpa();
    Log.i(TAG, parama.agI());
    AppMethodBeat.o(194574);
  }
  
  public static void fBo()
  {
    AppMethodBeat.i(194553);
    if (IyB.size() <= 0)
    {
      AppMethodBeat.o(194553);
      return;
    }
    ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap((Map)IyB);
    IyB.clear();
    ArrayList localArrayList = new ArrayList();
    Object localObject = ((Map)localConcurrentHashMap).entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      Log.d(TAG, String.valueOf(localEntry.getValue()));
      localArrayList.add(localEntry.getKey());
    }
    j.lm((List)localArrayList);
    localObject = a(localArrayList, 300000L, 5000L);
    if (((a)localObject).result)
    {
      a(1, localArrayList, localConcurrentHashMap, (a)localObject);
      AppMethodBeat.o(194553);
      return;
    }
    localObject = a(localArrayList, 3600000L, 60000L);
    if (((a)localObject).result)
    {
      a(2, localArrayList, localConcurrentHashMap, (a)localObject);
      AppMethodBeat.o(194553);
      return;
    }
    localObject = d.dgX().a("clicfg_android_data_package_frequency_statistic_other_report_switch", "1", false, true);
    Log.d(TAG, "canStatisticsOtherStratagy() sw:%s", new Object[] { localObject });
    if (Util.isEqual((String)localObject, "1"))
    {
      localObject = localArrayList.get(0);
      p.j(localObject, "timeList[0]");
      long l = ((Number)localObject).longValue();
      localObject = localArrayList.get(localArrayList.size() - 1);
      p.j(localObject, "timeList[timeList.size - 1]");
      a(3, localArrayList, localConcurrentHashMap, new a(false, l, ((Number)localObject).longValue()));
    }
    AppMethodBeat.o(194553);
  }
  
  public static boolean fBp()
  {
    AppMethodBeat.i(194580);
    String str = d.dgX().a("clicfg_android_data_package_frequency_statistic_switch", "1", false, true);
    Log.d(TAG, "canDataPackageFrequencyStatistics() sw:%s", new Object[] { str });
    boolean bool = Util.isEqual(str, "1");
    AppMethodBeat.o(194580);
    return bool;
  }
  
  public static boolean fBq()
  {
    AppMethodBeat.i(194584);
    String str = d.dgX().a("clicfg_android_data_package_frequency_statistic_only_huawei_switch", "0", false, true);
    Log.d(TAG, "dataPackageStatisticsOnlyHuawei() sw:%s", new Object[] { str });
    boolean bool = Util.isEqual(str, "1");
    AppMethodBeat.o(194584);
    return bool;
  }
  
  public final void F(int paramInt, long paramLong)
  {
    AppMethodBeat.i(194546);
    if (ddZ)
    {
      long l = System.currentTimeMillis();
      IyB.put(Long.valueOf(l), new b(l, true, paramInt, "", paramLong));
    }
    AppMethodBeat.o(194546);
  }
  
  public final void J(String paramString, long paramLong)
  {
    AppMethodBeat.i(194549);
    long l;
    ConcurrentHashMap localConcurrentHashMap;
    if (ddZ)
    {
      l = System.currentTimeMillis();
      localConcurrentHashMap = IyB;
      if (paramString != null) {
        break label61;
      }
      paramString = "";
    }
    label61:
    for (;;)
    {
      localConcurrentHashMap.put(Long.valueOf(l), new b(l, false, -1, paramString, paramLong));
      AppMethodBeat.o(194549);
      return;
    }
  }
  
  public final void c(Application paramApplication)
  {
    AppMethodBeat.i(194545);
    p.k(paramApplication, "application");
    if (MMApplicationContext.isPushProcess())
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.SCREEN_ON");
      localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
      paramApplication.registerReceiver((BroadcastReceiver)IyA, localIntentFilter);
      af.a((af.a)this);
    }
    AppMethodBeat.o(194545);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/report/business/DataPackageFrequencyDetect$Receiver;", "Landroid/content/BroadcastReceiver;", "()V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "plugin-report_release"})
  public static final class Receiver
    extends BroadcastReceiver
  {
    public final void onReceive(Context paramContext, Intent paramIntent)
    {
      AppMethodBeat.i(194800);
      if (paramIntent != null)
      {
        paramContext = paramIntent.getAction();
        paramIntent = DataPackageFrequencyDetect.IyC;
        paramIntent = DataPackageFrequencyDetect.fBr();
        StringBuilder localStringBuilder = new StringBuilder("ACTION_SCREEN:").append(Util.nullAs(paramContext, "")).append(" isScreenOff:");
        DataPackageFrequencyDetect localDataPackageFrequencyDetect = DataPackageFrequencyDetect.IyC;
        localStringBuilder = localStringBuilder.append(DataPackageFrequencyDetect.fBs()).append(" dataPackageInfoList:");
        localDataPackageFrequencyDetect = DataPackageFrequencyDetect.IyC;
        Log.i(paramIntent, DataPackageFrequencyDetect.fBt().size());
        paramIntent = DataPackageFrequencyDetect.IyC;
        DataPackageFrequencyDetect.xh(p.h("android.intent.action.SCREEN_OFF", paramContext));
        paramContext = DataPackageFrequencyDetect.IyC;
        if (!DataPackageFrequencyDetect.fBs()) {
          try
          {
            paramContext = DataPackageFrequencyDetect.IyC;
            if (DataPackageFrequencyDetect.fBp())
            {
              paramContext = DataPackageFrequencyDetect.IyC;
              boolean bool = DataPackageFrequencyDetect.fBq();
              if ((!bool) || ((bool) && (Huawei.ifHUAWEI())))
              {
                paramContext = DataPackageFrequencyDetect.IyC;
                DataPackageFrequencyDetect.fBo();
                AppMethodBeat.o(194800);
                return;
              }
            }
          }
          catch (Exception paramContext)
          {
            paramIntent = DataPackageFrequencyDetect.IyC;
            Log.e(DataPackageFrequencyDetect.fBr(), paramContext.getClass().getSimpleName() + ", " + paramContext.getMessage());
          }
        }
        AppMethodBeat.o(194800);
        return;
      }
      AppMethodBeat.o(194800);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/report/business/DataPackageFrequencyDetect$CheckResult;", "", "result", "", "startTime", "", "endTime", "(ZJJ)V", "getEndTime", "()J", "getResult", "()Z", "getStartTime", "plugin-report_release"})
  public static final class a
  {
    final long endTime;
    final boolean result;
    final long startTime;
    
    public a(boolean paramBoolean, long paramLong1, long paramLong2)
    {
      this.result = paramBoolean;
      this.startTime = paramLong1;
      this.endTime = paramLong2;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/report/business/DataPackageFrequencyDetect$DataPackageInfo;", "", "time", "", "req", "", "type", "", "cgi", "", "length", "(JZILjava/lang/String;J)V", "getCgi", "()Ljava/lang/String;", "getLength", "()J", "getReq", "()Z", "getTime", "getType", "()I", "toString", "plugin-report_release"})
  public static final class b
  {
    final boolean IyD;
    private final long aFL;
    final String cgi;
    private final long time;
    final int type;
    
    public b(long paramLong1, boolean paramBoolean, int paramInt, String paramString, long paramLong2)
    {
      AppMethodBeat.i(193799);
      this.time = paramLong1;
      this.IyD = paramBoolean;
      this.type = paramInt;
      this.cgi = paramString;
      this.aFL = paramLong2;
      AppMethodBeat.o(193799);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(193798);
      StringBuilder localStringBuilder = new StringBuilder("DataPackageInfo(time=");
      Object localObject = DataPackageFrequencyDetect.IyC;
      String str = DataPackageFrequencyDetect.GD(this.time);
      localObject = str;
      if (str == null) {
        localObject = Long.valueOf(this.time);
      }
      localObject = localObject + ", req=" + this.IyD + ", type=" + this.type + ", cgi='" + this.cgi + "', length=" + this.aFL + ')';
      AppMethodBeat.o(193798);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.report.business.DataPackageFrequencyDetect
 * JD-Core Version:    0.7.0.1
 */