package com.tencent.tavkit.report;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Debug.MemoryInfo;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MemoryReportHelper
{
  public static final int MIN_TICK_INTERVAL_MS = 1000;
  private static final String TAG = "MemoryReportHelper";
  private static long lastTickTime;
  private Map<String, Consumer> consumerHashMap;
  private Context context;
  
  private MemoryReportHelper()
  {
    AppMethodBeat.i(197653);
    this.consumerHashMap = new HashMap();
    AppMethodBeat.o(197653);
  }
  
  public static String appendKeys(Collection<String> paramCollection)
  {
    AppMethodBeat.i(197652);
    StringBuilder localStringBuilder = new StringBuilder();
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      String str = (String)paramCollection.next();
      if (localStringBuilder.length() > 0) {
        localStringBuilder.append(",");
      }
      localStringBuilder.append(str);
    }
    paramCollection = localStringBuilder.toString();
    AppMethodBeat.o(197652);
    return paramCollection;
  }
  
  public static String appendReportKey(Collection<?> paramCollection)
  {
    AppMethodBeat.i(197651);
    ArrayList localArrayList = new ArrayList();
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      Object localObject = paramCollection.next();
      if ((localObject instanceof IReportable)) {
        localArrayList.add(((IReportable)localObject).getReportKey());
      }
    }
    paramCollection = appendKeys(localArrayList);
    AppMethodBeat.o(197651);
    return paramCollection;
  }
  
  public static MemoryReportHelper getInstance()
  {
    AppMethodBeat.i(197649);
    MemoryReportHelper localMemoryReportHelper = Instance.INSTANCE;
    AppMethodBeat.o(197649);
    return localMemoryReportHelper;
  }
  
  public static boolean isInIntervalTime()
  {
    AppMethodBeat.i(197650);
    long l = System.currentTimeMillis();
    if (l - lastTickTime < 1000L)
    {
      AppMethodBeat.o(197650);
      return true;
    }
    lastTickTime = l;
    AppMethodBeat.o(197650);
    return false;
  }
  
  public void clear()
  {
    AppMethodBeat.i(197657);
    this.consumerHashMap.clear();
    AppMethodBeat.o(197657);
  }
  
  public Map<String, Long> getAvgMBValues()
  {
    AppMethodBeat.i(197658);
    HashMap localHashMap = new HashMap();
    Iterator localIterator = this.consumerHashMap.values().iterator();
    while (localIterator.hasNext())
    {
      Consumer localConsumer = (Consumer)localIterator.next();
      if (localConsumer != null) {
        localHashMap.put(localConsumer.key, Long.valueOf(Consumer.access$300(localConsumer)));
      }
    }
    AppMethodBeat.o(197658);
    return localHashMap;
  }
  
  public Map<String, Long> getMaxMBValues()
  {
    AppMethodBeat.i(197659);
    HashMap localHashMap = new HashMap();
    Iterator localIterator = this.consumerHashMap.values().iterator();
    while (localIterator.hasNext())
    {
      Consumer localConsumer = (Consumer)localIterator.next();
      if (localConsumer != null) {
        localHashMap.put(localConsumer.key, Long.valueOf(localConsumer.getMaxM()));
      }
    }
    AppMethodBeat.o(197659);
    return localHashMap;
  }
  
  public int getPidMemorySize(int paramInt, Context paramContext)
  {
    AppMethodBeat.i(197656);
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getProcessMemoryInfo(new int[] { paramInt });
    paramContext[0].getTotalSharedDirty();
    paramInt = paramContext[0].getTotalPss();
    AppMethodBeat.o(197656);
    return paramInt;
  }
  
  public void init(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public void tick(String paramString)
  {
    AppMethodBeat.i(197654);
    if (this.context == null)
    {
      AppMethodBeat.o(197654);
      return;
    }
    tick(paramString, getPidMemorySize(Process.myPid(), this.context) / 1024);
    AppMethodBeat.o(197654);
  }
  
  public void tick(String paramString, long paramLong)
  {
    AppMethodBeat.i(197655);
    Consumer localConsumer2 = (Consumer)this.consumerHashMap.get(paramString);
    Consumer localConsumer1 = localConsumer2;
    if (localConsumer2 == null)
    {
      localConsumer1 = new Consumer(paramString);
      this.consumerHashMap.put(localConsumer1.key, localConsumer1);
    }
    Consumer.access$200(localConsumer1, paramLong);
    new StringBuilder("tick() called with: key = [").append(paramString).append("], MB = [").append(paramLong).append("]");
    AppMethodBeat.o(197655);
  }
  
  static class Consumer
  {
    private long count = 0L;
    private final String key;
    private long maxM = 0L;
    private long totalM = 0L;
    
    public Consumer(String paramString)
    {
      this.key = paramString;
    }
    
    private long getAvgMB()
    {
      if (this.count == 0L) {
        return 0L;
      }
      return this.totalM / this.count;
    }
    
    private void tick(long paramLong)
    {
      this.totalM += paramLong;
      this.count += 1L;
      if (paramLong > this.maxM) {
        this.maxM = paramLong;
      }
    }
    
    public long getMaxM()
    {
      return this.maxM;
    }
  }
  
  static class Instance
  {
    private static final MemoryReportHelper INSTANCE;
    
    static
    {
      AppMethodBeat.i(197648);
      INSTANCE = new MemoryReportHelper(null);
      AppMethodBeat.o(197648);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tavkit.report.MemoryReportHelper
 * JD-Core Version:    0.7.0.1
 */