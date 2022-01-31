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

public class alde
  implements Handler.Callback
{
  private aldb jdField_a_of_type_Aldb;
  private aldw jdField_a_of_type_Aldw;
  private bhoe jdField_a_of_type_Bhoe = new bhoe(ThreadManager.getSubThreadLooper(), this);
  private Set<Integer> jdField_a_of_type_JavaUtilSet = new CopyOnWriteArraySet();
  private ConcurrentHashMap<Integer, aldx> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(-1);
  private Set<Integer> jdField_b_of_type_JavaUtilSet = new CopyOnWriteArraySet();
  private ConcurrentHashMap<String, aldt> jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public static alde a()
  {
    return aldg.a();
  }
  
  public static boolean a()
  {
    return alee.a;
  }
  
  private void b(int paramInt, Bundle paramBundle)
  {
    aldx localaldx = (aldx)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
    if (localaldx != null)
    {
      localaldx.a();
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Integer.valueOf(paramInt), localaldx);
    }
    localaldx = new aldx(paramInt);
    paramBundle.putBoolean("isSampleFocus", a(paramInt));
    localaldx.a(paramBundle);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt), localaldx);
  }
  
  private void c(int paramInt, Bundle paramBundle)
  {
    aldx localaldx = (aldx)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
    if (localaldx == null)
    {
      QLog.e("TraceReport" + this.jdField_a_of_type_Aldb.a(paramInt), 1, new Object[] { "already end the trace, featureId:", Integer.valueOf(paramInt) });
      return;
    }
    localaldx.c(paramBundle);
    paramBundle = paramBundle.getString("featureKey");
    a().a(paramBundle);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Integer.valueOf(paramInt), localaldx);
    this.jdField_b_of_type_JavaUtilSet.add(Integer.valueOf(paramInt));
  }
  
  private void d(int paramInt, Bundle paramBundle)
  {
    aldx localaldx = (aldx)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
    if (localaldx == null) {
      return;
    }
    localaldx.b(paramBundle);
  }
  
  private void e(int paramInt, Bundle paramBundle)
  {
    aldx localaldx = (aldx)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
    if (localaldx == null) {
      return;
    }
    localaldx.d(paramBundle);
  }
  
  public int a(int paramInt, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (!this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString)) {
      return paramInt;
    }
    return ((aldt)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString)).a;
  }
  
  public int a(int paramInt, String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return paramInt;
      if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString)) {
        return ((aldt)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString)).b;
      }
    } while (!paramBoolean);
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() <= -2147483648) {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(-1);
    }
    int i = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.decrementAndGet();
    aldt localaldt = new aldt(paramInt, i);
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localaldt);
    return i;
  }
  
  public aldb a()
  {
    return this.jdField_a_of_type_Aldb;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Bhoe.sendEmptyMessage(4);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_a_of_type_JavaUtilSet.clear();
    this.jdField_b_of_type_JavaUtilSet.clear();
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    if (this.jdField_a_of_type_Aldb != null) {
      this.jdField_a_of_type_Aldb.a().a();
    }
    this.jdField_a_of_type_Bhoe.removeMessages(6);
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    this.jdField_a_of_type_Bhoe.obtainMessage(5, paramBundle).sendToTarget();
  }
  
  public void a(int paramInt, String paramString, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_Aldb == null) {
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
      paramBundle.putInt("initJavaHeap", aldk.c());
      paramBundle.putInt("initNativeHeap", aldk.d());
    }
    this.jdField_a_of_type_Bhoe.obtainMessage(1, paramBundle).sendToTarget();
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
  
  public void a(aldb paramaldb)
  {
    aldb localaldb = paramaldb;
    if (paramaldb == null)
    {
      localaldb = aldk.a();
      QLog.e("TraceReport", 1, "init error, outside not init config");
    }
    this.jdField_a_of_type_Aldb = localaldb;
    if (this.jdField_a_of_type_Aldw == null) {
      this.jdField_a_of_type_Aldw = new aldw();
    }
    this.jdField_a_of_type_Aldw.a(localaldb);
    this.jdField_a_of_type_Bhoe.sendEmptyMessage(0);
  }
  
  public void a(TraceData paramTraceData)
  {
    if ((!a()) || (paramTraceData.featureId < 0)) {}
    do
    {
      return;
      if ((this.jdField_a_of_type_Aldw != null) && (this.jdField_a_of_type_Aldb != null))
      {
        if (this.jdField_a_of_type_Aldw.a(paramTraceData))
        {
          this.jdField_a_of_type_Bhoe.removeMessages(6);
          this.jdField_a_of_type_Bhoe.sendEmptyMessageDelayed(6, aldw.a);
          return;
        }
        this.jdField_a_of_type_Bhoe.removeMessages(6);
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
    if (this.jdField_a_of_type_Aldb == null) {
      return false;
    }
    return this.jdField_a_of_type_Aldb.a(paramInt);
  }
  
  public void b(int paramInt, String paramString, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_Aldb == null) {
      a(null);
    }
    int i = a(paramInt, paramString, false);
    if (this.jdField_a_of_type_JavaUtilSet.contains(Integer.valueOf(i))) {
      return;
    }
    paramBundle.putInt("featureId", i);
    if (a(paramInt))
    {
      paramBundle.putInt("endJavaHeap", aldk.c());
      paramBundle.putInt("endNativeHeap", aldk.d());
    }
    this.jdField_a_of_type_Bhoe.obtainMessage(2, paramBundle).sendToTarget();
  }
  
  public void c(int paramInt, String paramString, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_Aldb == null) {
      a(null);
    }
    paramInt = a(paramInt, paramString, false);
    if (this.jdField_a_of_type_JavaUtilSet.contains(Integer.valueOf(paramInt))) {}
    while (this.jdField_b_of_type_JavaUtilSet.contains(Integer.valueOf(paramInt))) {
      return;
    }
    paramBundle.putInt("featureId", paramInt);
    this.jdField_a_of_type_Bhoe.obtainMessage(3, paramBundle).sendToTarget();
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
      if (this.jdField_a_of_type_Aldw != null)
      {
        this.jdField_a_of_type_Aldw.a();
        continue;
        b(paramMessage.getInt("featureId"), paramMessage);
        continue;
        c(paramMessage.getInt("featureId"), paramMessage);
        continue;
        d(paramMessage.getInt("featureId"), paramMessage);
        continue;
        if (this.jdField_a_of_type_Aldw != null)
        {
          this.jdField_a_of_type_Aldw.c();
          continue;
          e(paramMessage.getInt("featureId"), paramMessage);
          continue;
          if (this.jdField_a_of_type_Aldw != null) {
            this.jdField_a_of_type_Aldw.b();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alde
 * JD-Core Version:    0.7.0.1
 */