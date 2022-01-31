import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.apollo.trace.sdk.data.TraceData;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

public class alim
  implements alio, alip
{
  private int jdField_a_of_type_Int = 0;
  private alhq jdField_a_of_type_Alhq;
  private alin jdField_a_of_type_Alin;
  private TraceData jdField_a_of_type_ComTencentMobileqqApolloTraceSdkDataTraceData = new TraceData();
  private ConcurrentHashMap<Integer, alik> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private boolean jdField_a_of_type_Boolean;
  
  public alim(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloTraceSdkDataTraceData.featureId = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqApolloTraceSdkDataTraceData.version = "8.3.5";
    this.jdField_a_of_type_Alin = new alin(this);
    this.jdField_a_of_type_Alhq = alht.a().a();
    this.jdField_a_of_type_Alin.a(this.jdField_a_of_type_Alhq.b(), this);
  }
  
  private long a()
  {
    return (System.currentTimeMillis() & 0xFFFFFFFF) << 10 | (int)(Math.random() * 1000.0D) & 0x3FF;
  }
  
  private int b(Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloTraceSdkDataTraceData.traceId = a();
    this.jdField_a_of_type_ComTencentMobileqqApolloTraceSdkDataTraceData.timestamp = paramBundle.getLong("timestamp");
    this.jdField_a_of_type_ComTencentMobileqqApolloTraceSdkDataTraceData.startTime = paramBundle.getLong("startTime");
    this.jdField_a_of_type_ComTencentMobileqqApolloTraceSdkDataTraceData.serverTime = paramBundle.getLong("serverTime");
    this.jdField_a_of_type_ComTencentMobileqqApolloTraceSdkDataTraceData.featureKey = paramBundle.getString("featureKey");
    this.jdField_a_of_type_ComTencentMobileqqApolloTraceSdkDataTraceData.isSampleFocus = paramBundle.getBoolean("isSampleFocus");
    this.jdField_a_of_type_ComTencentMobileqqApolloTraceSdkDataTraceData.initJavaHeap = paramBundle.getInt("initJavaHeap");
    this.jdField_a_of_type_ComTencentMobileqqApolloTraceSdkDataTraceData.initNativeHeap = paramBundle.getInt("initNativeHeap");
    return -1;
  }
  
  private int c(Bundle paramBundle)
  {
    int i = paramBundle.getInt("spanId");
    int j = paramBundle.getInt("errCode", -100);
    Object localObject = paramBundle.getString("msg");
    long l1 = paramBundle.getLong("timestamp");
    long l2 = paramBundle.getLong("serverTime");
    long l3 = paramBundle.getLong("startTime");
    int k = paramBundle.getInt("extKey");
    long l4 = paramBundle.getLong("extValue");
    paramBundle = (alik)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(i));
    if (paramBundle == null)
    {
      paramBundle = new alik(i);
      paramBundle.c = l3;
      paramBundle.jdField_a_of_type_Long = l1;
      paramBundle.b = l2;
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(i), paramBundle);
    }
    for (;;)
    {
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        if (paramBundle.jdField_a_of_type_JavaUtilConcurrentBlockingQueue == null) {
          paramBundle.jdField_a_of_type_JavaUtilConcurrentBlockingQueue = new LinkedBlockingQueue();
        }
        localObject = a((String)localObject, l1, l2);
        paramBundle.jdField_a_of_type_JavaUtilConcurrentBlockingQueue.offer(localObject);
      }
      if (k > 0)
      {
        if (paramBundle.jdField_a_of_type_JavaUtilMap == null) {
          paramBundle.jdField_a_of_type_JavaUtilMap = new HashMap();
        }
        paramBundle.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(k), Long.valueOf(l4));
      }
      if (j != -100)
      {
        this.jdField_a_of_type_Int = 2;
        return 0;
      }
      return -1;
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_Alin.b();
    this.jdField_a_of_type_Alin.a();
    this.jdField_a_of_type_Alin = null;
  }
  
  private int d(Bundle paramBundle)
  {
    int i = paramBundle.getInt("spanId");
    int j = paramBundle.getInt("errCode");
    long l = paramBundle.getLong("endTime");
    paramBundle = paramBundle.getString("featureKey");
    alht.a().a(this.jdField_a_of_type_ComTencentMobileqqApolloTraceSdkDataTraceData.featureId, paramBundle);
    paramBundle = (alik)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(i));
    if (paramBundle == null) {
      throw new IllegalArgumentException("illegal span");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloTraceSdkDataTraceData.mSpanQueue == null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloTraceSdkDataTraceData.mSpanQueue = new LinkedBlockingQueue();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloTraceSdkDataTraceData.mSpanQueue.contains(paramBundle)) {
      this.jdField_a_of_type_ComTencentMobileqqApolloTraceSdkDataTraceData.mSpanQueue.remove(paramBundle);
    }
    paramBundle.jdField_a_of_type_Alij = a(j, paramBundle.c, l);
    paramBundle.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqApolloTraceSdkDataTraceData.mSpanQueue.offer(paramBundle);
    if (j != 0)
    {
      this.jdField_a_of_type_Int = 3;
      return 0;
    }
    return -1;
  }
  
  private void d()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.values().iterator();
    while (localIterator.hasNext())
    {
      alik localalik = (alik)localIterator.next();
      if (!localalik.jdField_a_of_type_Boolean)
      {
        if (localalik.jdField_a_of_type_JavaUtilConcurrentBlockingQueue == null) {
          localalik.jdField_a_of_type_JavaUtilConcurrentBlockingQueue = new LinkedBlockingQueue();
        }
        alih localalih = a("timeout fail", 0L, 0L);
        localalik.jdField_a_of_type_JavaUtilConcurrentBlockingQueue.offer(localalih);
        if (this.jdField_a_of_type_ComTencentMobileqqApolloTraceSdkDataTraceData.mSpanQueue == null) {
          this.jdField_a_of_type_ComTencentMobileqqApolloTraceSdkDataTraceData.mSpanQueue = new LinkedBlockingQueue();
        }
        localalik.jdField_a_of_type_Alij = a(-101, localalik.c, localalik.c);
        localalik.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentMobileqqApolloTraceSdkDataTraceData.mSpanQueue.offer(localalik);
      }
    }
  }
  
  private int e(Bundle paramBundle)
  {
    this.jdField_a_of_type_Boolean = true;
    int j = paramBundle.getInt("featureId");
    String str2 = paramBundle.getString("featureKey");
    int i = j;
    if (j == 0) {
      i = this.jdField_a_of_type_ComTencentMobileqqApolloTraceSdkDataTraceData.featureId;
    }
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = this.jdField_a_of_type_ComTencentMobileqqApolloTraceSdkDataTraceData.featureKey;
    }
    j = alht.a().a(i, str1);
    if (((i < 0) || (!TextUtils.isEmpty(str1))) && (QLog.isColorLevel())) {
      QLog.d("TraceReport" + this.jdField_a_of_type_Alhq.a(j), 1, new Object[] { "featureId:", Integer.valueOf(j), ",traceId:", Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloTraceSdkDataTraceData.traceId), ",mappingFeatureId:", Integer.valueOf(i), ",featureKey:", str1 });
    }
    i = paramBundle.getInt("errCode", 0);
    long l = paramBundle.getLong("endTime");
    if (i == -101) {
      d();
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloTraceSdkDataTraceData.featureId = j;
    this.jdField_a_of_type_ComTencentMobileqqApolloTraceSdkDataTraceData.result = a(i, this.jdField_a_of_type_ComTencentMobileqqApolloTraceSdkDataTraceData.startTime, l);
    if (this.jdField_a_of_type_ComTencentMobileqqApolloTraceSdkDataTraceData.isSampleFocus)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloTraceSdkDataTraceData.endJavaHeap = paramBundle.getInt("endJavaHeap");
      this.jdField_a_of_type_ComTencentMobileqqApolloTraceSdkDataTraceData.endNativeHeap = paramBundle.getInt("endNativeHeap");
      if ((this.jdField_a_of_type_ComTencentMobileqqApolloTraceSdkDataTraceData.endJavaHeap == 0) && (this.jdField_a_of_type_ComTencentMobileqqApolloTraceSdkDataTraceData.endNativeHeap == 0))
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloTraceSdkDataTraceData.endJavaHeap = alhz.c();
        this.jdField_a_of_type_ComTencentMobileqqApolloTraceSdkDataTraceData.endNativeHeap = alhz.d();
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloTraceSdkDataTraceData.result.f = (this.jdField_a_of_type_ComTencentMobileqqApolloTraceSdkDataTraceData.endJavaHeap - this.jdField_a_of_type_ComTencentMobileqqApolloTraceSdkDataTraceData.initJavaHeap);
      this.jdField_a_of_type_ComTencentMobileqqApolloTraceSdkDataTraceData.result.g = (this.jdField_a_of_type_ComTencentMobileqqApolloTraceSdkDataTraceData.endNativeHeap - this.jdField_a_of_type_ComTencentMobileqqApolloTraceSdkDataTraceData.initNativeHeap);
    }
    if (i != 0) {
      QLog.e("TraceReport" + this.jdField_a_of_type_Alhq.a(j), 1, new Object[] { "traceEnd:", this.jdField_a_of_type_ComTencentMobileqqApolloTraceSdkDataTraceData.toString() });
    }
    for (;;)
    {
      alht.a().a(this.jdField_a_of_type_ComTencentMobileqqApolloTraceSdkDataTraceData);
      this.jdField_a_of_type_Int = 4;
      return 0;
      QLog.i("TraceReport" + this.jdField_a_of_type_Alhq.a(j), 1, "traceEnd:" + this.jdField_a_of_type_ComTencentMobileqqApolloTraceSdkDataTraceData.toString());
    }
  }
  
  public int a(Bundle paramBundle)
  {
    int i = this.jdField_a_of_type_Int;
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      c();
      return -1;
    case 0: 
      return b(paramBundle);
    case 3: 
      return e(paramBundle);
    case 1: 
      return c(paramBundle);
    }
    return d(paramBundle);
  }
  
  public alih a(String paramString, long paramLong1, long paramLong2)
  {
    return new alih(paramString, paramLong1, paramLong2);
  }
  
  public alij a(int paramInt, long paramLong1, long paramLong2)
  {
    long l = 0L;
    alij localalij = new alij();
    localalij.jdField_a_of_type_Int = paramInt;
    localalij.e = bdin.a(null);
    if (paramLong2 > 0L)
    {
      paramLong1 = paramLong2 - paramLong1;
      if (paramLong1 >= 0L) {
        break label83;
      }
      paramLong1 = l;
    }
    label83:
    for (;;)
    {
      if (paramLong1 > 2147483647L) {}
      for (paramInt = 2147483647;; paramInt = (int)paramLong1)
      {
        localalij.b = paramInt;
        return localalij;
        paramLong2 = SystemClock.uptimeMillis();
        break;
      }
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean) {}
    while (this.jdField_a_of_type_Int == 4) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = 4;
    this.jdField_a_of_type_Alin.a(new Bundle());
  }
  
  public void a(Bundle paramBundle)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Alin.a(paramBundle);
  }
  
  public void b()
  {
    this.jdField_a_of_type_Int = 3;
    Bundle localBundle = new Bundle();
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() > 0) {
      localBundle.putInt("errCode", -101);
    }
    this.jdField_a_of_type_Alin.a(localBundle);
  }
  
  public void b(Bundle paramBundle)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_Alin.a(paramBundle);
  }
  
  public void c(Bundle paramBundle)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Int = 3;
    this.jdField_a_of_type_Alin.a(paramBundle);
  }
  
  public void d(Bundle paramBundle)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloTraceSdkDataTraceData == null) {}
    do
    {
      return;
      String str = paramBundle.getString("tuid");
      this.jdField_a_of_type_ComTencentMobileqqApolloTraceSdkDataTraceData.extra1 = paramBundle.getInt("extra1");
      this.jdField_a_of_type_ComTencentMobileqqApolloTraceSdkDataTraceData.extra2 = paramBundle.getInt("extra2");
      this.jdField_a_of_type_ComTencentMobileqqApolloTraceSdkDataTraceData.extra3 = paramBundle.getInt("extra3");
      if (!TextUtils.isEmpty(str)) {
        this.jdField_a_of_type_ComTencentMobileqqApolloTraceSdkDataTraceData.tUid = str;
      }
    } while (!QLog.isColorLevel());
    QLog.d("TraceReport" + this.jdField_a_of_type_Alhq.a(this.jdField_a_of_type_ComTencentMobileqqApolloTraceSdkDataTraceData.featureId), 2, new Object[] { "updateTraceData:", paramBundle.toString() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alim
 * JD-Core Version:    0.7.0.1
 */