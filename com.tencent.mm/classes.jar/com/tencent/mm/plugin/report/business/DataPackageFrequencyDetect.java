package com.tencent.mm.plugin.report.business;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.ag;
import com.tencent.mm.network.ag.a;
import com.tencent.mm.plugin.expt.e.d;
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
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/report/business/DataPackageFrequencyDetect;", "Lcom/tencent/mm/network/MMPushCore$IDataPackageReporter;", "()V", "TAG", "", "dataPackageInfoList", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/report/business/DataPackageFrequencyDetect$DataPackageInfo;", "isScreenOff", "", "receiver", "Lcom/tencent/mm/plugin/report/business/DataPackageFrequencyDetect$Receiver;", "addNetReq", "", "type", "", "length", "addNetResp", "cgi", "canDataPackageFrequencyStatistics", "canStatisticsOtherStratagy", "dataPackageStatisticsOnlyHuawei", "formatTimeMillis", "timeMillis", "ifMatchHuaweiBatteryStratagy", "Lcom/tencent/mm/plugin/report/business/DataPackageFrequencyDetect$CheckResult;", "sortedTimeList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "maxInterval", "eachInterval", "init", "application", "Landroid/app/Application;", "reportDataFrequency", "action", "reqNum", "respNum", "dataStartTime", "dataEndTime", "reqContent", "respContent", "checkResult", "reportDataPackageFrequency", "CheckResult", "DataPackageInfo", "Receiver", "plugin-report_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class DataPackageFrequencyDetect
  implements ag.a
{
  public static final DataPackageFrequencyDetect Ozf;
  private static final Receiver Ozg;
  private static final ConcurrentHashMap<Long, DataPackageFrequencyDetect.b> Ozh;
  private static final String TAG;
  private static boolean fcK;
  
  static
  {
    AppMethodBeat.i(261722);
    Ozf = new DataPackageFrequencyDetect();
    TAG = "MicroMsg.DataPackageFrequencyDetect";
    Ozg = new Receiver();
    Ozh = new ConcurrentHashMap();
    AppMethodBeat.o(261722);
  }
  
  private static a a(ArrayList<Long> paramArrayList, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(261697);
    if (paramArrayList.size() < 2)
    {
      paramArrayList = new a(false, 0L, 0L);
      AppMethodBeat.o(261697);
      return paramArrayList;
    }
    long l1 = ((Number)paramArrayList.get(paramArrayList.size() - 1)).longValue();
    Object localObject1 = paramArrayList.get(0);
    s.s(localObject1, "sortedTimeList[0]");
    if (l1 - ((Number)localObject1).longValue() < paramLong1)
    {
      paramArrayList = new a(false, 0L, 0L);
      AppMethodBeat.o(261697);
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
        kotlin.a.p.kkW();
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
      s.s(localObject1, "sortedTimeList[0]");
      paramLong1 = ((Number)localObject1).longValue();
      paramArrayList = paramArrayList.get(paramArrayList.size() - 1);
      s.s(paramArrayList, "sortedTimeList[sortedTimeList.size - 1]");
      paramArrayList = new a(true, paramLong1, ((Number)paramArrayList).longValue());
      AppMethodBeat.o(261697);
      return paramArrayList;
    }
    localObject2 = paramArrayList.get(0);
    s.s(localObject2, "sortedTimeList[0]");
    paramLong2 = ((Number)localObject2).longValue();
    localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Integer)((Iterator)localObject1).next();
      if (((Number)paramArrayList.get(((Integer)localObject2).intValue() - 1)).longValue() - paramLong2 >= paramLong1)
      {
        paramArrayList = paramArrayList.get(((Integer)localObject2).intValue() - 1);
        s.s(paramArrayList, "sortedTimeList[i - 1]");
        paramArrayList = new a(true, paramLong2, ((Number)paramArrayList).longValue());
        AppMethodBeat.o(261697);
        return paramArrayList;
      }
      s.s(localObject2, "i");
      localObject2 = paramArrayList.get(((Integer)localObject2).intValue());
      s.s(localObject2, "sortedTimeList[i]");
      paramLong2 = ((Number)localObject2).longValue();
    }
    paramArrayList = new a(false, 0L, 0L);
    AppMethodBeat.o(261697);
    return paramArrayList;
  }
  
  private static void a(int paramInt, ArrayList<Long> paramArrayList, ConcurrentHashMap<Long, DataPackageFrequencyDetect.b> paramConcurrentHashMap, a parama)
  {
    AppMethodBeat.i(261705);
    int i = paramArrayList.indexOf(Long.valueOf(parama.startTime));
    int k = paramArrayList.indexOf(Long.valueOf(parama.endTime));
    Object localObject2 = new HashMap();
    Object localObject1 = new HashMap();
    long l3 = 0L;
    long l4 = 0L;
    long l1 = l4;
    long l2 = l3;
    if (i <= k) {
      l1 = l4;
    }
    for (;;)
    {
      Object localObject3 = (DataPackageFrequencyDetect.b)paramConcurrentHashMap.get(paramArrayList.get(i));
      l2 = l1;
      int j;
      Object localObject4;
      if (localObject3 != null) {
        if (((DataPackageFrequencyDetect.b)localObject3).Ozi)
        {
          l2 = l3 + 1L;
          j = 0;
          if (((HashMap)localObject2).containsKey(Integer.valueOf(((DataPackageFrequencyDetect.b)localObject3).type)))
          {
            localObject4 = ((HashMap)localObject2).get(Integer.valueOf(((DataPackageFrequencyDetect.b)localObject3).type));
            s.checkNotNull(localObject4);
            s.s(localObject4, "reqMap[it.type]!!");
            j = ((Number)localObject4).intValue();
          }
          ((HashMap)localObject2).put(Integer.valueOf(((DataPackageFrequencyDetect.b)localObject3).type), Integer.valueOf(j + 1));
        }
      }
      while (i == k)
      {
        paramArrayList = new StringBuilder();
        paramConcurrentHashMap = ((HashMap)localObject2).entrySet();
        s.s(paramConcurrentHashMap, "reqMap.entries");
        paramConcurrentHashMap = ((Iterable)paramConcurrentHashMap).iterator();
        for (;;)
        {
          if (paramConcurrentHashMap.hasNext())
          {
            localObject2 = (Map.Entry)paramConcurrentHashMap.next();
            paramArrayList.append(((Number)((Map.Entry)localObject2).getKey()).intValue() + '_' + ((Number)((Map.Entry)localObject2).getValue()).intValue() + ';');
            continue;
            l2 = l1 + 1L;
            j = 0;
            if (((HashMap)localObject1).containsKey(((DataPackageFrequencyDetect.b)localObject3).cgi))
            {
              localObject4 = ((HashMap)localObject1).get(((DataPackageFrequencyDetect.b)localObject3).cgi);
              s.checkNotNull(localObject4);
              s.s(localObject4, "respMap[it.cgi]!!");
              j = ((Number)localObject4).intValue();
            }
            ((HashMap)localObject1).put(((DataPackageFrequencyDetect.b)localObject3).cgi, Integer.valueOf(j + 1));
            l1 = l2;
            l2 = l3;
            break;
          }
        }
        paramConcurrentHashMap = new StringBuilder();
        localObject1 = ((HashMap)localObject1).entrySet();
        s.s(localObject1, "respMap.entries");
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Map.Entry)((Iterator)localObject1).next();
          localObject3 = ((Map.Entry)localObject2).getKey();
          s.s(localObject3, "it.key");
          localObject3 = n.rw((String)localObject3, "/");
          paramConcurrentHashMap.append((String)localObject3 + '_' + ((Number)((Map.Entry)localObject2).getValue()).intValue() + ';');
        }
        l3 = parama.startTime;
        l4 = parama.endTime;
        paramArrayList = paramArrayList.toString();
        s.s(paramArrayList, "reqContent.toString()");
        paramConcurrentHashMap = paramConcurrentHashMap.toString();
        s.s(paramConcurrentHashMap, "respContent.toString()");
        parama = new com.tencent.mm.autogen.mmdata.rpt.p();
        parama.ilm = paramInt;
        parama.iln = l2;
        parama.ilo = l1;
        parama.ilp = l3;
        parama.ilq = l4;
        parama.ilr = parama.F("ReqContent", paramArrayList, true);
        parama.ils = parama.F("RespContent", paramConcurrentHashMap, true);
        parama.ilt = (l2 + l1);
        parama.bMH();
        Log.i(TAG, parama.aIF());
        AppMethodBeat.o(261705);
        return;
      }
      i += 1;
      l3 = l2;
    }
  }
  
  public static void gNI()
  {
    AppMethodBeat.i(261693);
    if (Ozh.size() <= 0)
    {
      AppMethodBeat.o(261693);
      return;
    }
    ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap((Map)Ozh);
    Ozh.clear();
    ArrayList localArrayList = new ArrayList();
    Object localObject = ((Map)localConcurrentHashMap).entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      Log.d(TAG, String.valueOf(localEntry.getValue()));
      localArrayList.add(localEntry.getKey());
    }
    kotlin.a.p.N((List)localArrayList);
    localObject = a(localArrayList, 300000L, 5000L);
    if (((a)localObject).result)
    {
      a(1, localArrayList, localConcurrentHashMap, (a)localObject);
      AppMethodBeat.o(261693);
      return;
    }
    localObject = a(localArrayList, 3600000L, 60000L);
    if (((a)localObject).result)
    {
      a(2, localArrayList, localConcurrentHashMap, (a)localObject);
      AppMethodBeat.o(261693);
      return;
    }
    localObject = d.dNI().a("clicfg_android_data_package_frequency_statistic_other_report_switch", "1", false, true);
    Log.d(TAG, "canStatisticsOtherStratagy() sw:%s", new Object[] { localObject });
    if (Util.isEqual((String)localObject, "1"))
    {
      localObject = localArrayList.get(0);
      s.s(localObject, "timeList[0]");
      long l = ((Number)localObject).longValue();
      localObject = localArrayList.get(localArrayList.size() - 1);
      s.s(localObject, "timeList[timeList.size - 1]");
      a(3, localArrayList, localConcurrentHashMap, new a(false, l, ((Number)localObject).longValue()));
    }
    AppMethodBeat.o(261693);
  }
  
  public static boolean gNJ()
  {
    return false;
  }
  
  public static boolean gNK()
  {
    AppMethodBeat.i(261712);
    String str = d.dNI().a("clicfg_android_data_package_frequency_statistic_only_huawei_switch", "0", false, true);
    Log.d(TAG, "dataPackageStatisticsOnlyHuawei() sw:%s", new Object[] { str });
    boolean bool = Util.isEqual(str, "1");
    AppMethodBeat.o(261712);
    return bool;
  }
  
  public static String iO(long paramLong)
  {
    AppMethodBeat.i(261709);
    Object localObject = new Date(paramLong);
    localObject = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format((Date)localObject);
    AppMethodBeat.o(261709);
    return localObject;
  }
  
  public final void I(int paramInt, long paramLong)
  {
    AppMethodBeat.i(261729);
    if (fcK)
    {
      long l = System.currentTimeMillis();
      Ozh.put(Long.valueOf(l), new DataPackageFrequencyDetect.b(l, true, paramInt, "", paramLong));
    }
    AppMethodBeat.o(261729);
  }
  
  public final void N(String paramString, long paramLong)
  {
    AppMethodBeat.i(261733);
    long l;
    ConcurrentHashMap localConcurrentHashMap;
    if (fcK)
    {
      l = System.currentTimeMillis();
      localConcurrentHashMap = Ozh;
      if (paramString != null) {
        break label61;
      }
      paramString = "";
    }
    label61:
    for (;;)
    {
      localConcurrentHashMap.put(Long.valueOf(l), new DataPackageFrequencyDetect.b(l, false, -1, paramString, paramLong));
      AppMethodBeat.o(261733);
      return;
    }
  }
  
  public final void c(Application paramApplication)
  {
    AppMethodBeat.i(261725);
    s.u(paramApplication, "application");
    if (MMApplicationContext.isPushProcess())
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.SCREEN_ON");
      localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
      paramApplication.registerReceiver((BroadcastReceiver)Ozg, localIntentFilter);
      ag.a((ag.a)this);
    }
    AppMethodBeat.o(261725);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/report/business/DataPackageFrequencyDetect$Receiver;", "Landroid/content/BroadcastReceiver;", "()V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "plugin-report_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class Receiver
    extends BroadcastReceiver
  {
    public final void onReceive(Context paramContext, Intent paramIntent)
    {
      AppMethodBeat.i(261686);
      if (paramIntent != null)
      {
        paramContext = paramIntent.getAction();
        Log.i(DataPackageFrequencyDetect.aUw(), "ACTION_SCREEN:" + Util.nullAs(paramContext, "") + " isScreenOff:" + DataPackageFrequencyDetect.gNL() + " dataPackageInfoList:" + DataPackageFrequencyDetect.gNM().size());
        paramIntent = DataPackageFrequencyDetect.Ozf;
        DataPackageFrequencyDetect.BI(s.p("android.intent.action.SCREEN_OFF", paramContext));
        if (!DataPackageFrequencyDetect.gNL()) {
          try
          {
            paramContext = DataPackageFrequencyDetect.Ozf;
            if (DataPackageFrequencyDetect.gNJ())
            {
              paramContext = DataPackageFrequencyDetect.Ozf;
              boolean bool = DataPackageFrequencyDetect.gNK();
              if ((!bool) || ((bool) && (Huawei.ifHUAWEI())))
              {
                paramContext = DataPackageFrequencyDetect.Ozf;
                DataPackageFrequencyDetect.gNI();
                AppMethodBeat.o(261686);
                return;
              }
            }
          }
          catch (Exception paramContext)
          {
            Log.e(DataPackageFrequencyDetect.aUw(), paramContext.getClass().getSimpleName() + ", " + paramContext.getMessage());
          }
        }
      }
      AppMethodBeat.o(261686);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/report/business/DataPackageFrequencyDetect$CheckResult;", "", "result", "", "startTime", "", "endTime", "(ZJJ)V", "getEndTime", "()J", "getResult", "()Z", "getStartTime", "plugin-report_release"}, k=1, mv={1, 5, 1}, xi=48)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.report.business.DataPackageFrequencyDetect
 * JD-Core Version:    0.7.0.1
 */