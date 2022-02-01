package com.tencent.mm.plugin.report.business;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.e;
import com.tencent.mm.network.ad;
import com.tencent.mm.network.ad.a;
import com.tencent.mm.plugin.expt.h.d;
import com.tencent.mm.sdk.h.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
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

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/report/business/DataPackageFrequencyDetect;", "Lcom/tencent/mm/network/MMPushCore$IDataPackageReporter;", "()V", "TAG", "", "dataPackageInfoList", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/report/business/DataPackageFrequencyDetect$DataPackageInfo;", "isScreenOff", "", "receiver", "Lcom/tencent/mm/plugin/report/business/DataPackageFrequencyDetect$Receiver;", "addNetReq", "", "type", "", "length", "addNetResp", "cgi", "canDataPackageFrequencyStatistics", "canStatisticsOtherStratagy", "dataPackageStatisticsOnlyHuawei", "formatTimeMillis", "timeMillis", "ifMatchHuaweiBatteryStratagy", "Lcom/tencent/mm/plugin/report/business/DataPackageFrequencyDetect$CheckResult;", "sortedTimeList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "maxInterval", "eachInterval", "init", "application", "Landroid/app/Application;", "reportDataFrequency", "action", "reqNum", "respNum", "dataStartTime", "dataEndTime", "reqContent", "respContent", "checkResult", "reportDataPackageFrequency", "CheckResult", "DataPackageInfo", "Receiver", "plugin-report_release"})
public final class DataPackageFrequencyDetect
  implements ad.a
{
  private static final String TAG = "MicroMsg.DataPackageFrequencyDetect";
  private static boolean cTG;
  private static final Receiver ywC;
  private static final ConcurrentHashMap<Long, b> ywD;
  public static final DataPackageFrequencyDetect ywE;
  
  static
  {
    AppMethodBeat.i(221094);
    ywE = new DataPackageFrequencyDetect();
    TAG = "MicroMsg.DataPackageFrequencyDetect";
    ywC = new Receiver();
    ywD = new ConcurrentHashMap();
    AppMethodBeat.o(221094);
  }
  
  private static a a(ArrayList<Long> paramArrayList, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(221089);
    if (paramArrayList.size() < 2)
    {
      paramArrayList = new a(false, 0L, 0L);
      AppMethodBeat.o(221089);
      return paramArrayList;
    }
    long l1 = ((Number)paramArrayList.get(paramArrayList.size() - 1)).longValue();
    Object localObject1 = paramArrayList.get(0);
    p.g(localObject1, "sortedTimeList[0]");
    if (l1 - ((Number)localObject1).longValue() < paramLong1)
    {
      paramArrayList = new a(false, 0L, 0L);
      AppMethodBeat.o(221089);
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
        j.gkd();
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
      AppMethodBeat.o(221089);
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
        AppMethodBeat.o(221089);
        return paramArrayList;
      }
      p.g(localObject2, "i");
      localObject2 = paramArrayList.get(((Integer)localObject2).intValue());
      p.g(localObject2, "sortedTimeList[i]");
      paramLong2 = ((Number)localObject2).longValue();
    }
    paramArrayList = new a(false, 0L, 0L);
    AppMethodBeat.o(221089);
    return paramArrayList;
  }
  
  private static void a(int paramInt, ArrayList<Long> paramArrayList, ConcurrentHashMap<Long, b> paramConcurrentHashMap, a parama)
  {
    AppMethodBeat.i(221090);
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
        if (!((b)localObject3).ywF) {
          break label229;
        }
        l2 = l3 + 1L;
        j = 0;
        if (((HashMap)localObject2).containsKey(Integer.valueOf(((b)localObject3).type)))
        {
          localObject4 = ((HashMap)localObject2).get(Integer.valueOf(((b)localObject3).type));
          if (localObject4 == null) {
            p.gkB();
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
            p.gkB();
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
      localObject3 = n.nL((String)localObject3, "/");
      paramConcurrentHashMap.append((String)localObject3 + '_' + (Integer)((Map.Entry)localObject2).getValue() + ';');
    }
    l1 = parama.startTime;
    l2 = parama.endTime;
    paramArrayList = paramArrayList.toString();
    p.g(paramArrayList, "reqContent.toString()");
    paramConcurrentHashMap = paramConcurrentHashMap.toString();
    p.g(paramConcurrentHashMap, "respContent.toString()");
    parama = new e();
    parama.ih(paramInt);
    parama.bp(l4);
    parama.bq(l3);
    parama.br(l1);
    parama.bs(l2);
    parama.gK(paramArrayList);
    parama.gL(paramConcurrentHashMap);
    parama.bt(l4 + l3);
    parama.aLH();
    ae.i(TAG, parama.RD());
    AppMethodBeat.o(221090);
  }
  
  public static void dNs()
  {
    AppMethodBeat.i(221088);
    if (ywD.size() <= 0)
    {
      AppMethodBeat.o(221088);
      return;
    }
    ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap((Map)ywD);
    ywD.clear();
    ArrayList localArrayList = new ArrayList();
    Object localObject = ((Map)localConcurrentHashMap).entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      ae.d(TAG, String.valueOf(localEntry.getValue()));
      localArrayList.add(localEntry.getKey());
    }
    j.sort((List)localArrayList);
    localObject = a(localArrayList, 300000L, 5000L);
    if (((a)localObject).result)
    {
      a(1, localArrayList, localConcurrentHashMap, (a)localObject);
      AppMethodBeat.o(221088);
      return;
    }
    localObject = a(localArrayList, 3600000L, 60000L);
    if (((a)localObject).result)
    {
      a(2, localArrayList, localConcurrentHashMap, (a)localObject);
      AppMethodBeat.o(221088);
      return;
    }
    localObject = d.ctr().b("clicfg_android_data_package_frequency_statistic_other_report_switch", "1", false, true);
    ae.d(TAG, "canStatisticsOtherStratagy() sw:%s", new Object[] { localObject });
    if (bu.lX((String)localObject, "1"))
    {
      localObject = localArrayList.get(0);
      p.g(localObject, "timeList[0]");
      long l = ((Number)localObject).longValue();
      localObject = localArrayList.get(localArrayList.size() - 1);
      p.g(localObject, "timeList[timeList.size - 1]");
      a(3, localArrayList, localConcurrentHashMap, new a(false, l, ((Number)localObject).longValue()));
    }
    AppMethodBeat.o(221088);
  }
  
  public static boolean dNt()
  {
    AppMethodBeat.i(221092);
    String str = d.ctr().b("clicfg_android_data_package_frequency_statistic_switch", "1", false, true);
    ae.d(TAG, "canDataPackageFrequencyStatistics() sw:%s", new Object[] { str });
    boolean bool = bu.lX(str, "1");
    AppMethodBeat.o(221092);
    return bool;
  }
  
  public static boolean dNu()
  {
    AppMethodBeat.i(221093);
    String str = d.ctr().b("clicfg_android_data_package_frequency_statistic_only_huawei_switch", "0", false, true);
    ae.d(TAG, "dataPackageStatisticsOnlyHuawei() sw:%s", new Object[] { str });
    boolean bool = bu.lX(str, "1");
    AppMethodBeat.o(221093);
    return bool;
  }
  
  public static String sp(long paramLong)
  {
    AppMethodBeat.i(221091);
    Object localObject = new Date(paramLong);
    localObject = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format((Date)localObject);
    AppMethodBeat.o(221091);
    return localObject;
  }
  
  public final void C(int paramInt, long paramLong)
  {
    AppMethodBeat.i(221086);
    if (cTG)
    {
      long l = System.currentTimeMillis();
      ywD.put(Long.valueOf(l), new b(l, true, paramInt, "", paramLong));
    }
    AppMethodBeat.o(221086);
  }
  
  public final void K(String paramString, long paramLong)
  {
    AppMethodBeat.i(221087);
    long l;
    ConcurrentHashMap localConcurrentHashMap;
    if (cTG)
    {
      l = System.currentTimeMillis();
      localConcurrentHashMap = ywD;
      if (paramString != null) {
        break label61;
      }
      paramString = "";
    }
    label61:
    for (;;)
    {
      localConcurrentHashMap.put(Long.valueOf(l), new b(l, false, -1, paramString, paramLong));
      AppMethodBeat.o(221087);
      return;
    }
  }
  
  public final void d(Application paramApplication)
  {
    AppMethodBeat.i(221085);
    p.h(paramApplication, "application");
    if (ak.foA())
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.SCREEN_ON");
      localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
      paramApplication.registerReceiver((BroadcastReceiver)ywC, localIntentFilter);
      ad.a((ad.a)this);
    }
    AppMethodBeat.o(221085);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/report/business/DataPackageFrequencyDetect$Receiver;", "Landroid/content/BroadcastReceiver;", "()V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "plugin-report_release"})
  public static final class Receiver
    extends BroadcastReceiver
  {
    public final void onReceive(Context paramContext, Intent paramIntent)
    {
      AppMethodBeat.i(221084);
      if (paramIntent != null)
      {
        paramContext = paramIntent.getAction();
        paramIntent = DataPackageFrequencyDetect.ywE;
        paramIntent = DataPackageFrequencyDetect.dNv();
        StringBuilder localStringBuilder = new StringBuilder("ACTION_SCREEN:").append(bu.bI(paramContext, "")).append(" isScreenOff:");
        DataPackageFrequencyDetect localDataPackageFrequencyDetect = DataPackageFrequencyDetect.ywE;
        localStringBuilder = localStringBuilder.append(DataPackageFrequencyDetect.dNw()).append(" dataPackageInfoList:");
        localDataPackageFrequencyDetect = DataPackageFrequencyDetect.ywE;
        ae.i(paramIntent, DataPackageFrequencyDetect.dNx().size());
        paramIntent = DataPackageFrequencyDetect.ywE;
        DataPackageFrequencyDetect.qu(p.i("android.intent.action.SCREEN_OFF", paramContext));
        paramContext = DataPackageFrequencyDetect.ywE;
        if (!DataPackageFrequencyDetect.dNw()) {
          try
          {
            paramContext = DataPackageFrequencyDetect.ywE;
            if (DataPackageFrequencyDetect.dNt())
            {
              paramContext = DataPackageFrequencyDetect.ywE;
              boolean bool = DataPackageFrequencyDetect.dNu();
              if ((!bool) || ((bool) && (a.fqj())))
              {
                paramContext = DataPackageFrequencyDetect.ywE;
                DataPackageFrequencyDetect.dNs();
                AppMethodBeat.o(221084);
                return;
              }
            }
          }
          catch (Exception paramContext)
          {
            paramIntent = DataPackageFrequencyDetect.ywE;
            ae.e(DataPackageFrequencyDetect.dNv(), paramContext.getClass().getSimpleName() + ", " + paramContext.getMessage());
          }
        }
        AppMethodBeat.o(221084);
        return;
      }
      AppMethodBeat.o(221084);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/report/business/DataPackageFrequencyDetect$CheckResult;", "", "result", "", "startTime", "", "endTime", "(ZJJ)V", "getEndTime", "()J", "getResult", "()Z", "getStartTime", "plugin-report_release"})
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
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/report/business/DataPackageFrequencyDetect$DataPackageInfo;", "", "time", "", "req", "", "type", "", "cgi", "", "length", "(JZILjava/lang/String;J)V", "getCgi", "()Ljava/lang/String;", "getLength", "()J", "getReq", "()Z", "getTime", "getType", "()I", "toString", "plugin-report_release"})
  public static final class b
  {
    final String cgi;
    private final long length;
    private final long time;
    final int type;
    final boolean ywF;
    
    public b(long paramLong1, boolean paramBoolean, int paramInt, String paramString, long paramLong2)
    {
      AppMethodBeat.i(221083);
      this.time = paramLong1;
      this.ywF = paramBoolean;
      this.type = paramInt;
      this.cgi = paramString;
      this.length = paramLong2;
      AppMethodBeat.o(221083);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(221082);
      StringBuilder localStringBuilder = new StringBuilder("DataPackageInfo(time=");
      Object localObject = DataPackageFrequencyDetect.ywE;
      String str = DataPackageFrequencyDetect.sp(this.time);
      localObject = str;
      if (str == null) {
        localObject = Long.valueOf(this.time);
      }
      localObject = localObject + ", req=" + this.ywF + ", type=" + this.type + ", cgi='" + this.cgi + "', length=" + this.length + ')';
      AppMethodBeat.o(221082);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.report.business.DataPackageFrequencyDetect
 * JD-Core Version:    0.7.0.1
 */