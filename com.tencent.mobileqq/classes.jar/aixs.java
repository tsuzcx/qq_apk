import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.apollo.trace.sdk.data.TraceData;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

public class aixs
  implements Handler.Callback
{
  private aixp jdField_a_of_type_Aixp;
  private aiyj jdField_a_of_type_Aiyj;
  private beez jdField_a_of_type_Beez = new beez(ThreadManager.getSubThreadLooper(), this);
  private Set<Integer> jdField_a_of_type_JavaUtilSet = new CopyOnWriteArraySet();
  private ConcurrentHashMap<Integer, aiyk> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(-1);
  private Set<Integer> jdField_b_of_type_JavaUtilSet = new CopyOnWriteArraySet();
  private ConcurrentHashMap<String, aiyg> jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public static aixs a()
  {
    return aixu.a();
  }
  
  public static boolean a()
  {
    return aiyr.a;
  }
  
  private void b(int paramInt, Bundle paramBundle)
  {
    aiyk localaiyk = (aiyk)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
    if (localaiyk != null)
    {
      localaiyk.a();
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Integer.valueOf(paramInt), localaiyk);
    }
    localaiyk = new aiyk(paramInt);
    paramBundle.putBoolean("isSampleFocus", a(paramInt));
    localaiyk.a(paramBundle);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt), localaiyk);
  }
  
  private void c(int paramInt, Bundle paramBundle)
  {
    aiyk localaiyk = (aiyk)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
    if (localaiyk == null)
    {
      QLog.e("TraceReport" + this.jdField_a_of_type_Aixp.a(paramInt), 1, new Object[] { "already end the trace, featureId:", Integer.valueOf(paramInt) });
      return;
    }
    localaiyk.c(paramBundle);
    paramBundle = paramBundle.getString("featureKey");
    a().a(paramBundle);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Integer.valueOf(paramInt), localaiyk);
    this.jdField_b_of_type_JavaUtilSet.add(Integer.valueOf(paramInt));
  }
  
  private void d(int paramInt, Bundle paramBundle)
  {
    aiyk localaiyk = (aiyk)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
    if (localaiyk == null) {
      return;
    }
    localaiyk.b(paramBundle);
  }
  
  private void e(int paramInt, Bundle paramBundle)
  {
    aiyk localaiyk = (aiyk)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
    if (localaiyk == null) {
      return;
    }
    localaiyk.d(paramBundle);
  }
  
  public int a(int paramInt, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (!this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString)) {
      return paramInt;
    }
    return ((aiyg)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString)).a;
  }
  
  public int a(int paramInt, String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return paramInt;
      if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString)) {
        return ((aiyg)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString)).b;
      }
    } while (!paramBoolean);
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() <= -2147483648) {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(-1);
    }
    int i = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.decrementAndGet();
    aiyg localaiyg = new aiyg(paramInt, i);
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localaiyg);
    return i;
  }
  
  public aixp a()
  {
    return this.jdField_a_of_type_Aixp;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Beez.sendEmptyMessage(4);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_a_of_type_JavaUtilSet.clear();
    this.jdField_b_of_type_JavaUtilSet.clear();
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    if (this.jdField_a_of_type_Aixp != null) {
      this.jdField_a_of_type_Aixp.a().a();
    }
    this.jdField_a_of_type_Beez.removeMessages(6);
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    this.jdField_a_of_type_Beez.obtainMessage(5, paramBundle).sendToTarget();
  }
  
  public void a(int paramInt, String paramString, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_Aixp == null) {
      a(null);
    }
    int i = a(paramInt, paramString, true);
    if (this.jdField_a_of_type_JavaUtilSet.contains(Integer.valueOf(i))) {
      return;
    }
    this.jdField_b_of_type_JavaUtilSet.remove(Integer.valueOf(i));
    paramBundle.putInt("featureId", i);
    if (a(paramInt))
    {
      paramBundle.putInt("initJavaHeap", aixx.c());
      paramBundle.putInt("initNativeHeap", aixx.d());
    }
    this.jdField_a_of_type_Beez.obtainMessage(1, paramBundle).sendToTarget();
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      this.jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(paramInt));
      return;
    }
    this.jdField_a_of_type_JavaUtilSet.remove(Integer.valueOf(paramInt));
  }
  
  public void a(aixp paramaixp)
  {
    aixp localaixp = paramaixp;
    if (paramaixp == null)
    {
      localaixp = aixx.a();
      QLog.e("TraceReport", 1, "init error, outside not init config");
    }
    this.jdField_a_of_type_Aixp = localaixp;
    if (this.jdField_a_of_type_Aiyj == null) {
      this.jdField_a_of_type_Aiyj = new aiyj();
    }
    this.jdField_a_of_type_Aiyj.a(localaixp);
    this.jdField_a_of_type_Beez.sendEmptyMessage(0);
  }
  
  public void a(TraceData paramTraceData)
  {
    if ((!a()) || (paramTraceData.featureId < 0)) {}
    do
    {
      return;
      if ((this.jdField_a_of_type_Aiyj != null) && (this.jdField_a_of_type_Aixp != null))
      {
        if (this.jdField_a_of_type_Aiyj.a(paramTraceData))
        {
          this.jdField_a_of_type_Beez.removeMessages(6);
          this.jdField_a_of_type_Beez.sendEmptyMessageDelayed(6, aiyj.a);
          return;
        }
        this.jdField_a_of_type_Beez.removeMessages(6);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("TraceReport", 2, "sendTraceReport mTraceReportControl or config is null");
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
  }
  
  public boolean a(int paramInt)
  {
    if (this.jdField_a_of_type_Aixp == null) {
      return false;
    }
    return this.jdField_a_of_type_Aixp.a(paramInt);
  }
  
  public void b(int paramInt, String paramString, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_Aixp == null) {
      a(null);
    }
    int i = a(paramInt, paramString, false);
    if (this.jdField_a_of_type_JavaUtilSet.contains(Integer.valueOf(i))) {
      return;
    }
    paramBundle.putInt("featureId", i);
    if (a(paramInt))
    {
      paramBundle.putInt("endJavaHeap", aixx.c());
      paramBundle.putInt("endNativeHeap", aixx.d());
    }
    this.jdField_a_of_type_Beez.obtainMessage(2, paramBundle).sendToTarget();
  }
  
  public void c(int paramInt, String paramString, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_Aixp == null) {
      a(null);
    }
    paramInt = a(paramInt, paramString, false);
    if (this.jdField_a_of_type_JavaUtilSet.contains(Integer.valueOf(paramInt))) {}
    while (this.jdField_b_of_type_JavaUtilSet.contains(Integer.valueOf(paramInt))) {
      return;
    }
    paramBundle.putInt("featureId", paramInt);
    this.jdField_a_of_type_Beez.obtainMessage(3, paramBundle).sendToTarget();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    paramMessage = (Bundle)paramMessage.obj;
    switch (i)
    {
    }
    for (;;)
    {
      return false;
      if (this.jdField_a_of_type_Aiyj != null)
      {
        this.jdField_a_of_type_Aiyj.a();
        continue;
        b(paramMessage.getInt("featureId"), paramMessage);
        continue;
        c(paramMessage.getInt("featureId"), paramMessage);
        continue;
        d(paramMessage.getInt("featureId"), paramMessage);
        continue;
        if (this.jdField_a_of_type_Aiyj != null)
        {
          this.jdField_a_of_type_Aiyj.c();
          continue;
          e(paramMessage.getInt("featureId"), paramMessage);
          continue;
          if (this.jdField_a_of_type_Aiyj != null) {
            this.jdField_a_of_type_Aiyj.b();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aixs
 * JD-Core Version:    0.7.0.1
 */