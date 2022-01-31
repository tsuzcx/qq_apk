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

public class ajls
  implements Handler.Callback
{
  private ajlp jdField_a_of_type_Ajlp;
  private ajmj jdField_a_of_type_Ajmj;
  private bfnk jdField_a_of_type_Bfnk = new bfnk(ThreadManager.getSubThreadLooper(), this);
  private Set<Integer> jdField_a_of_type_JavaUtilSet = new CopyOnWriteArraySet();
  private ConcurrentHashMap<Integer, ajmk> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(-1);
  private Set<Integer> jdField_b_of_type_JavaUtilSet = new CopyOnWriteArraySet();
  private ConcurrentHashMap<String, ajmg> jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public static ajls a()
  {
    return ajlu.a();
  }
  
  public static boolean a()
  {
    return ajmr.a;
  }
  
  private void b(int paramInt, Bundle paramBundle)
  {
    ajmk localajmk = (ajmk)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
    if (localajmk != null)
    {
      localajmk.a();
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Integer.valueOf(paramInt), localajmk);
    }
    localajmk = new ajmk(paramInt);
    paramBundle.putBoolean("isSampleFocus", a(paramInt));
    localajmk.a(paramBundle);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt), localajmk);
  }
  
  private void c(int paramInt, Bundle paramBundle)
  {
    ajmk localajmk = (ajmk)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
    if (localajmk == null)
    {
      QLog.e("TraceReport" + this.jdField_a_of_type_Ajlp.a(paramInt), 1, new Object[] { "already end the trace, featureId:", Integer.valueOf(paramInt) });
      return;
    }
    localajmk.c(paramBundle);
    paramBundle = paramBundle.getString("featureKey");
    a().a(paramBundle);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Integer.valueOf(paramInt), localajmk);
    this.jdField_b_of_type_JavaUtilSet.add(Integer.valueOf(paramInt));
  }
  
  private void d(int paramInt, Bundle paramBundle)
  {
    ajmk localajmk = (ajmk)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
    if (localajmk == null) {
      return;
    }
    localajmk.b(paramBundle);
  }
  
  private void e(int paramInt, Bundle paramBundle)
  {
    ajmk localajmk = (ajmk)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
    if (localajmk == null) {
      return;
    }
    localajmk.d(paramBundle);
  }
  
  public int a(int paramInt, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (!this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString)) {
      return paramInt;
    }
    return ((ajmg)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString)).a;
  }
  
  public int a(int paramInt, String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return paramInt;
      if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString)) {
        return ((ajmg)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString)).b;
      }
    } while (!paramBoolean);
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() <= -2147483648) {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(-1);
    }
    int i = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.decrementAndGet();
    ajmg localajmg = new ajmg(paramInt, i);
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localajmg);
    return i;
  }
  
  public ajlp a()
  {
    return this.jdField_a_of_type_Ajlp;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Bfnk.sendEmptyMessage(4);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_a_of_type_JavaUtilSet.clear();
    this.jdField_b_of_type_JavaUtilSet.clear();
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    if (this.jdField_a_of_type_Ajlp != null) {
      this.jdField_a_of_type_Ajlp.a().a();
    }
    this.jdField_a_of_type_Bfnk.removeMessages(6);
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    this.jdField_a_of_type_Bfnk.obtainMessage(5, paramBundle).sendToTarget();
  }
  
  public void a(int paramInt, String paramString, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_Ajlp == null) {
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
      paramBundle.putInt("initJavaHeap", ajlx.c());
      paramBundle.putInt("initNativeHeap", ajlx.d());
    }
    this.jdField_a_of_type_Bfnk.obtainMessage(1, paramBundle).sendToTarget();
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
  
  public void a(ajlp paramajlp)
  {
    ajlp localajlp = paramajlp;
    if (paramajlp == null)
    {
      localajlp = ajlx.a();
      QLog.e("TraceReport", 1, "init error, outside not init config");
    }
    this.jdField_a_of_type_Ajlp = localajlp;
    if (this.jdField_a_of_type_Ajmj == null) {
      this.jdField_a_of_type_Ajmj = new ajmj();
    }
    this.jdField_a_of_type_Ajmj.a(localajlp);
    this.jdField_a_of_type_Bfnk.sendEmptyMessage(0);
  }
  
  public void a(TraceData paramTraceData)
  {
    if ((!a()) || (paramTraceData.featureId < 0)) {}
    do
    {
      return;
      if ((this.jdField_a_of_type_Ajmj != null) && (this.jdField_a_of_type_Ajlp != null))
      {
        if (this.jdField_a_of_type_Ajmj.a(paramTraceData))
        {
          this.jdField_a_of_type_Bfnk.removeMessages(6);
          this.jdField_a_of_type_Bfnk.sendEmptyMessageDelayed(6, ajmj.a);
          return;
        }
        this.jdField_a_of_type_Bfnk.removeMessages(6);
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
    if (this.jdField_a_of_type_Ajlp == null) {
      return false;
    }
    return this.jdField_a_of_type_Ajlp.a(paramInt);
  }
  
  public void b(int paramInt, String paramString, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_Ajlp == null) {
      a(null);
    }
    int i = a(paramInt, paramString, false);
    if (this.jdField_a_of_type_JavaUtilSet.contains(Integer.valueOf(i))) {
      return;
    }
    paramBundle.putInt("featureId", i);
    if (a(paramInt))
    {
      paramBundle.putInt("endJavaHeap", ajlx.c());
      paramBundle.putInt("endNativeHeap", ajlx.d());
    }
    this.jdField_a_of_type_Bfnk.obtainMessage(2, paramBundle).sendToTarget();
  }
  
  public void c(int paramInt, String paramString, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_Ajlp == null) {
      a(null);
    }
    paramInt = a(paramInt, paramString, false);
    if (this.jdField_a_of_type_JavaUtilSet.contains(Integer.valueOf(paramInt))) {}
    while (this.jdField_b_of_type_JavaUtilSet.contains(Integer.valueOf(paramInt))) {
      return;
    }
    paramBundle.putInt("featureId", paramInt);
    this.jdField_a_of_type_Bfnk.obtainMessage(3, paramBundle).sendToTarget();
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
      if (this.jdField_a_of_type_Ajmj != null)
      {
        this.jdField_a_of_type_Ajmj.a();
        continue;
        b(paramMessage.getInt("featureId"), paramMessage);
        continue;
        c(paramMessage.getInt("featureId"), paramMessage);
        continue;
        d(paramMessage.getInt("featureId"), paramMessage);
        continue;
        if (this.jdField_a_of_type_Ajmj != null)
        {
          this.jdField_a_of_type_Ajmj.c();
          continue;
          e(paramMessage.getInt("featureId"), paramMessage);
          continue;
          if (this.jdField_a_of_type_Ajmj != null) {
            this.jdField_a_of_type_Ajmj.b();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajls
 * JD-Core Version:    0.7.0.1
 */