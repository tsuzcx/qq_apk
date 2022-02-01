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
    AppMethodBeat.i(219952);
    this.consumerHashMap = new HashMap();
    AppMethodBeat.o(219952);
  }
  
  public static String appendKeys(Collection<String> paramCollection)
  {
    AppMethodBeat.i(219951);
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
    AppMethodBeat.o(219951);
    return paramCollection;
  }
  
  public static String appendReportKey(Collection<?> paramCollection)
  {
    AppMethodBeat.i(219950);
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
    AppMethodBeat.o(219950);
    return paramCollection;
  }
  
  public static MemoryReportHelper getInstance()
  {
    AppMethodBeat.i(219948);
    MemoryReportHelper localMemoryReportHelper = Instance.INSTANCE;
    AppMethodBeat.o(219948);
    return localMemoryReportHelper;
  }
  
  public static boolean isInIntervalTime()
  {
    AppMethodBeat.i(219949);
    long l = System.currentTimeMillis();
    if (l - lastTickTime < 1000L)
    {
      AppMethodBeat.o(219949);
      return true;
    }
    lastTickTime = l;
    AppMethodBeat.o(219949);
    return false;
  }
  
  public void clear()
  {
    AppMethodBeat.i(219956);
    this.consumerHashMap.clear();
    AppMethodBeat.o(219956);
  }
  
  public Map<String, Long> getAvgMBValues()
  {
    AppMethodBeat.i(219957);
    HashMap localHashMap = new HashMap();
    Iterator localIterator = this.consumerHashMap.values().iterator();
    while (localIterator.hasNext())
    {
      Consumer localConsumer = (Consumer)localIterator.next();
      if (localConsumer != null) {
        localHashMap.put(localConsumer.key, Long.valueOf(Consumer.access$300(localConsumer)));
      }
    }
    AppMethodBeat.o(219957);
    return localHashMap;
  }
  
  public Map<String, Long> getMaxMBValues()
  {
    AppMethodBeat.i(219958);
    HashMap localHashMap = new HashMap();
    Iterator localIterator = this.consumerHashMap.values().iterator();
    while (localIterator.hasNext())
    {
      Consumer localConsumer = (Consumer)localIterator.next();
      if (localConsumer != null) {
        localHashMap.put(localConsumer.key, Long.valueOf(localConsumer.getMaxM()));
      }
    }
    AppMethodBeat.o(219958);
    return localHashMap;
  }
  
  public int getPidMemorySize(int paramInt, Context paramContext)
  {
    AppMethodBeat.i(219955);
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getProcessMemoryInfo(new int[] { paramInt });
    paramContext[0].getTotalSharedDirty();
    paramInt = paramContext[0].getTotalPss();
    AppMethodBeat.o(219955);
    return paramInt;
  }
  
  public void init(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public void tick(String paramString)
  {
    AppMethodBeat.i(219953);
    if (this.context == null)
    {
      AppMethodBeat.o(219953);
      return;
    }
    tick(paramString, getPidMemorySize(Process.myPid(), this.context) / 1024);
    AppMethodBeat.o(219953);
  }
  
  public void tick(String paramString, long paramLong)
  {
    AppMethodBeat.i(219954);
    Consumer localConsumer2 = (Consumer)this.consumerHashMap.get(paramString);
    Consumer localConsumer1 = localConsumer2;
    if (localConsumer2 == null)
    {
      localConsumer1 = new Consumer(paramString);
      this.consumerHashMap.put(localConsumer1.key, localConsumer1);
    }
    Consumer.access$200(localConsumer1, paramLong);
    new StringBuilder("tick() called with: key = [").append(paramString).append("], MB = [").append(paramLong).append("]");
    AppMethodBeat.o(219954);
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
      AppMethodBeat.i(219947);
      INSTANCE = new MemoryReportHelper(null);
      AppMethodBeat.o(219947);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tavkit.report.MemoryReportHelper
 * JD-Core Version:    0.7.0.1
 */