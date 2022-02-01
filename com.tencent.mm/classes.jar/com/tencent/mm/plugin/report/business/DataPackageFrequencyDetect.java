package com.tencent.mm.plugin.report.business;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.e;
import com.tencent.mm.network.ad.a;
import com.tencent.mm.plugin.expt.h.d;
import com.tencent.mm.sdk.h.a;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import d.a.j;
import d.g.b.p;
import d.l;
import d.n.n;
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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/report/business/DataPackageFrequencyDetect;", "Lcom/tencent/mm/network/MMPushCore$IDataPackageReporter;", "()V", "TAG", "", "dataPackageInfoList", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/report/business/DataPackageFrequencyDetect$DataPackageInfo;", "isScreenOff", "", "receiver", "Lcom/tencent/mm/plugin/report/business/DataPackageFrequencyDetect$Receiver;", "addNetReq", "", "type", "", "length", "addNetResp", "cgi", "canDataPackageFrequencyStatistics", "canStatisticsOtherStratagy", "dataPackageStatisticsOnlyHuawei", "formatTimeMillis", "timeMillis", "ifMatchHuaweiBatteryStratagy", "Lcom/tencent/mm/plugin/report/business/DataPackageFrequencyDetect$CheckResult;", "sortedTimeList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "maxInterval", "eachInterval", "init", "application", "Landroid/app/Application;", "reportDataFrequency", "action", "reqNum", "respNum", "dataStartTime", "dataEndTime", "reqContent", "respContent", "checkResult", "reportDataPackageFrequency", "CheckResult", "DataPackageInfo", "Receiver", "plugin-report_release"})
public final class DataPackageFrequencyDetect
  implements ad.a
{
  private static final String TAG = "MicroMsg.DataPackageFrequencyDetect";
  private static boolean cSW;
  private static final Receiver ygL;
  private static final ConcurrentHashMap<Long, b> ygM;
  public static final DataPackageFrequencyDetect ygN;
  
  static
  {
    AppMethodBeat.i(197156);
    ygN = new DataPackageFrequencyDetect();
    TAG = "MicroMsg.DataPackageFrequencyDetect";
    ygL = new Receiver();
    ygM = new ConcurrentHashMap();
    AppMethodBeat.o(197156);
  }
  
  private static a a(ArrayList<Long> paramArrayList, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(197151);
    if (paramArrayList.size() < 2)
    {
      paramArrayList = new a(false, 0L, 0L);
      AppMethodBeat.o(197151);
      return paramArrayList;
    }
    long l1 = ((Number)paramArrayList.get(paramArrayList.size() - 1)).longValue();
    Object localObject1 = paramArrayList.get(0);
    p.g(localObject1, "sortedTimeList[0]");
    if (l1 - ((Number)localObject1).longValue() < paramLong1)
    {
      paramArrayList = new a(false, 0L, 0L);
      AppMethodBeat.o(197151);
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
        j.gfB();
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
      p.g(localObject1, "sortedTimeList[0]");
      paramLong1 = ((Number)localObject1).longValue();
      paramArrayList = paramArrayList.get(paramArrayList.size() - 1);
      p.g(paramArrayList, "sortedTimeList[sortedTimeList.size - 1]");
      paramArrayList = new a(true, paramLong1, ((Number)paramArrayList).longValue());
      AppMethodBeat.o(197151);
      return paramArrayList;
    }
    localObject2 = paramArrayList.get(0);
    p.g(localObject2, "sortedTimeList[0]");
    paramLong2 = ((Number)localObject2).longValue();
    localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Integer)((Iterator)localObject1).next();
      if (((Number)paramArrayList.get(((Integer)localObject2).intValue() - 1)).longValue() - paramLong2 >= paramLong1)
      {
        paramArrayList = paramArrayList.get(((Integer)localObject2).intValue() - 1);
        p.g(paramArrayList, "sortedTimeList[i - 1]");
        paramArrayList = new a(true, paramLong2, ((Number)paramArrayList).longValue());
        AppMethodBeat.o(197151);
        return paramArrayList;
      }
      p.g(localObject2, "i");
      localObject2 = paramArrayList.get(((Integer)localObject2).intValue());
      p.g(localObject2, "sortedTimeList[i]");
      paramLong2 = ((Number)localObject2).longValue();
    }
    paramArrayList = new a(false, 0L, 0L);
    AppMethodBeat.o(197151);
    return paramArrayList;
  }
  
  private static void a(int paramInt, ArrayList<Long> paramArrayList, ConcurrentHashMap<Long, b> paramConcurrentHashMap, a parama)
  {
    AppMethodBeat.i(197152);
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
        if (!((b)localObject3).ygO) {
          break label229;
        }
        l2 = l3 + 1L;
        j = 0;
        if (((HashMap)localObject2).containsKey(Integer.valueOf(((b)localObject3).type)))
        {
          localObject4 = ((HashMap)localObject2).get(Integer.valueOf(((b)localObject3).type));
          if (localObject4 == null) {
            p.gfZ();
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
            p.gfZ();
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
    p.g(paramConcurrentHashMap, "reqMap.entries");
    paramConcurrentHashMap = ((Iterable)paramConcurrentHashMap).iterator();
    while (paramConcurrentHashMap.hasNext())
    {
      localObject2 = (Map.Entry)paramConcurrentHashMap.next();
      paramArrayList.append((Integer)((Map.Entry)localObject2).getKey() + '_' + (Integer)((Map.Entry)localObject2).getValue() + ';');
    }
    paramConcurrentHashMap = new StringBuilder();
    localObject1 = ((HashMap)localObject1).entrySet();
    p.g(localObject1, "respMap.entries");
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      localObject3 = ((Map.Entry)localObject2).getKey();
      p.g(localObject3, "it.key");
      localObject3 = n.nF((String)localObject3, "/");
      paramConcurrentHashMap.append((String)localObject3 + '_' + (Integer)((Map.Entry)localObject2).getValue() + ';');
    }
    l1 = parama.startTime;
    l2 = parama.endTime;
    paramArrayList = paramArrayList.toString();
    p.g(paramArrayList, "reqContent.toString()");
    paramConcurrentHashMap = paramConcurrentHashMap.toString();
    p.g(paramConcurrentHashMap, "respContent.toString()");
    parama = new e();
    parama.jdMethod_if(paramInt);
    parama.bp(l4);
    parama.bq(l3);
    parama.br(l1);
    parama.bs(l2);
    parama.gE(paramArrayList);
    parama.gF(paramConcurrentHashMap);
    parama.bt(l4 + l3);
    parama.aLk();
    com.tencent.mm.sdk.platformtools.ad.i(TAG, parama.RE());
    AppMethodBeat.o(197152);
  }
  
  public static void dKa()
  {
    AppMethodBeat.i(197150);
    if (ygM.size() <= 0)
    {
      AppMethodBeat.o(197150);
      return;
    }
    ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap((Map)ygM);
    ygM.clear();
    ArrayList localArrayList = new ArrayList();
    Object localObject = ((Map)localConcurrentHashMap).entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      com.tencent.mm.sdk.platformtools.ad.d(TAG, String.valueOf(localEntry.getValue()));
      localArrayList.add(localEntry.getKey());
    }
    j.sort((List)localArrayList);
    localObject = a(localArrayList, 300000L, 5000L);
    if (((a)localObject).result)
    {
      a(1, localArrayList, localConcurrentHashMap, (a)localObject);
      AppMethodBeat.o(197150);
      return;
    }
    localObject = a(localArrayList, 3600000L, 60000L);
    if (((a)localObject).result)
    {
      a(2, localArrayList, localConcurrentHashMap, (a)localObject);
      AppMethodBeat.o(197150);
      return;
    }
    localObject = d.crP().b("clicfg_android_data_package_frequency_statistic_other_report_switch", "1", false, true);
    com.tencent.mm.sdk.platformtools.ad.d(TAG, "canStatisticsOtherStratagy() sw:%s", new Object[] { localObject });
    if (bt.lQ((String)localObject, "1"))
    {
      localObject = localArrayList.get(0);
      p.g(localObject, "timeList[0]");
      long l = ((Number)localObject).longValue();
      localObject = localArrayList.get(localArrayList.size() - 1);
      p.g(localObject, "timeList[timeList.size - 1]");
      a(3, localArrayList, localConcurrentHashMap, new a(false, l, ((Number)localObject).longValue()));
    }
    AppMethodBeat.o(197150);
  }
  
  public static boolean dKb()
  {
    AppMethodBeat.i(197154);
    String str = d.crP().b("clicfg_android_data_package_frequency_statistic_switch", "1", false, true);
    com.tencent.mm.sdk.platformtools.ad.d(TAG, "canDataPackageFrequencyStatistics() sw:%s", new Object[] { str });
    boolean bool = bt.lQ(str, "1");
    AppMethodBeat.o(197154);
    return bool;
  }
  
  public static boolean dKc()
  {
    AppMethodBeat.i(197155);
    String str = d.crP().b("clicfg_android_data_package_frequency_statistic_only_huawei_switch", "0", false, true);
    com.tencent.mm.sdk.platformtools.ad.d(TAG, "dataPackageStatisticsOnlyHuawei() sw:%s", new Object[] { str });
    boolean bool = bt.lQ(str, "1");
    AppMethodBeat.o(197155);
    return bool;
  }
  
  public static String sc(long paramLong)
  {
    AppMethodBeat.i(197153);
    Object localObject = new Date(paramLong);
    localObject = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format((Date)localObject);
    AppMethodBeat.o(197153);
    return localObject;
  }
  
  public final void D(int paramInt, long paramLong)
  {
    AppMethodBeat.i(197148);
    if (cSW)
    {
      long l = System.currentTimeMillis();
      ygM.put(Long.valueOf(l), new b(l, true, paramInt, "", paramLong));
    }
    AppMethodBeat.o(197148);
  }
  
  public final void K(String paramString, long paramLong)
  {
    AppMethodBeat.i(197149);
    long l;
    ConcurrentHashMap localConcurrentHashMap;
    if (cSW)
    {
      l = System.currentTimeMillis();
      localConcurrentHashMap = ygM;
      if (paramString != null) {
        break label61;
      }
      paramString = "";
    }
    label61:
    for (;;)
    {
      localConcurrentHashMap.put(Long.valueOf(l), new b(l, false, -1, paramString, paramLong));
      AppMethodBeat.o(197149);
      return;
    }
  }
  
  public final void d(Application paramApplication)
  {
    AppMethodBeat.i(197147);
    p.h(paramApplication, "application");
    if (aj.fkG())
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.SCREEN_ON");
      localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
      paramApplication.registerReceiver((BroadcastReceiver)ygL, localIntentFilter);
      com.tencent.mm.network.ad.a((ad.a)this);
    }
    AppMethodBeat.o(197147);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/report/business/DataPackageFrequencyDetect$Receiver;", "Landroid/content/BroadcastReceiver;", "()V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "plugin-report_release"})
  public static final class Receiver
    extends BroadcastReceiver
  {
    public final void onReceive(Context paramContext, Intent paramIntent)
    {
      AppMethodBeat.i(197146);
      if (paramIntent != null)
      {
        paramContext = paramIntent.getAction();
        paramIntent = DataPackageFrequencyDetect.ygN;
        paramIntent = DataPackageFrequencyDetect.dKd();
        StringBuilder localStringBuilder = new StringBuilder("ACTION_SCREEN:").append(bt.bI(paramContext, "")).append(" isScreenOff:");
        DataPackageFrequencyDetect localDataPackageFrequencyDetect = DataPackageFrequencyDetect.ygN;
        localStringBuilder = localStringBuilder.append(DataPackageFrequencyDetect.dKe()).append(" dataPackageInfoList:");
        localDataPackageFrequencyDetect = DataPackageFrequencyDetect.ygN;
        com.tencent.mm.sdk.platformtools.ad.i(paramIntent, DataPackageFrequencyDetect.dKf().size());
        paramIntent = DataPackageFrequencyDetect.ygN;
        DataPackageFrequencyDetect.qn(p.i("android.intent.action.SCREEN_OFF", paramContext));
        paramContext = DataPackageFrequencyDetect.ygN;
        if (!DataPackageFrequencyDetect.dKe()) {
          try
          {
            paramContext = DataPackageFrequencyDetect.ygN;
            if (DataPackageFrequencyDetect.dKb())
            {
              paramContext = DataPackageFrequencyDetect.ygN;
              boolean bool = DataPackageFrequencyDetect.dKc();
              if ((!bool) || ((bool) && (a.fmo())))
              {
                paramContext = DataPackageFrequencyDetect.ygN;
                DataPackageFrequencyDetect.dKa();
                AppMethodBeat.o(197146);
                return;
              }
            }
          }
          catch (Exception paramContext)
          {
            paramIntent = DataPackageFrequencyDetect.ygN;
            com.tencent.mm.sdk.platformtools.ad.e(DataPackageFrequencyDetect.dKd(), paramContext.getClass().getSimpleName() + ", " + paramContext.getMessage());
          }
        }
        AppMethodBeat.o(197146);
        return;
      }
      AppMethodBeat.o(197146);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/report/business/DataPackageFrequencyDetect$CheckResult;", "", "result", "", "startTime", "", "endTime", "(ZJJ)V", "getEndTime", "()J", "getResult", "()Z", "getStartTime", "plugin-report_release"})
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
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/report/business/DataPackageFrequencyDetect$DataPackageInfo;", "", "time", "", "req", "", "type", "", "cgi", "", "length", "(JZILjava/lang/String;J)V", "getCgi", "()Ljava/lang/String;", "getLength", "()J", "getReq", "()Z", "getTime", "getType", "()I", "toString", "plugin-report_release"})
  public static final class b
  {
    final String cgi;
    private final long length;
    private final long time;
    final int type;
    final boolean ygO;
    
    public b(long paramLong1, boolean paramBoolean, int paramInt, String paramString, long paramLong2)
    {
      AppMethodBeat.i(197145);
      this.time = paramLong1;
      this.ygO = paramBoolean;
      this.type = paramInt;
      this.cgi = paramString;
      this.length = paramLong2;
      AppMethodBeat.o(197145);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(197144);
      StringBuilder localStringBuilder = new StringBuilder("DataPackageInfo(time=");
      Object localObject = DataPackageFrequencyDetect.ygN;
      String str = DataPackageFrequencyDetect.sc(this.time);
      localObject = str;
      if (str == null) {
        localObject = Long.valueOf(this.time);
      }
      localObject = localObject + ", req=" + this.ygO + ", type=" + this.type + ", cgi='" + this.cgi + "', length=" + this.length + ')';
      AppMethodBeat.o(197144);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.report.business.DataPackageFrequencyDetect
 * JD-Core Version:    0.7.0.1
 */