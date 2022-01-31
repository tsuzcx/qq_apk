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

public class alht
  implements Handler.Callback
{
  private alhq jdField_a_of_type_Alhq;
  private alil jdField_a_of_type_Alil;
  private bhsl jdField_a_of_type_Bhsl = new bhsl(ThreadManager.getSubThreadLooper(), this);
  private Set<Integer> jdField_a_of_type_JavaUtilSet = new CopyOnWriteArraySet();
  private ConcurrentHashMap<Integer, alim> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(-1);
  private Set<Integer> jdField_b_of_type_JavaUtilSet = new CopyOnWriteArraySet();
  private ConcurrentHashMap<String, alii> jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public static alht a()
  {
    return alhv.a();
  }
  
  public static boolean a()
  {
    return alit.a;
  }
  
  private void b(int paramInt, Bundle paramBundle)
  {
    alim localalim = (alim)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
    if (localalim != null)
    {
      localalim.a();
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Integer.valueOf(paramInt), localalim);
    }
    localalim = new alim(paramInt);
    paramBundle.putBoolean("isSampleFocus", a(paramInt));
    localalim.a(paramBundle);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt), localalim);
  }
  
  private void c(int paramInt, Bundle paramBundle)
  {
    alim localalim = (alim)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
    if (localalim == null)
    {
      QLog.e("TraceReport" + this.jdField_a_of_type_Alhq.a(paramInt), 1, new Object[] { "already end the trace, featureId:", Integer.valueOf(paramInt) });
      return;
    }
    localalim.c(paramBundle);
    paramBundle = paramBundle.getString("featureKey");
    a().a(paramBundle);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Integer.valueOf(paramInt), localalim);
    this.jdField_b_of_type_JavaUtilSet.add(Integer.valueOf(paramInt));
  }
  
  private void d(int paramInt, Bundle paramBundle)
  {
    alim localalim = (alim)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
    if (localalim == null) {
      return;
    }
    localalim.b(paramBundle);
  }
  
  private void e(int paramInt, Bundle paramBundle)
  {
    alim localalim = (alim)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
    if (localalim == null) {
      return;
    }
    localalim.d(paramBundle);
  }
  
  public int a(int paramInt, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (!this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString)) {
      return paramInt;
    }
    return ((alii)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString)).a;
  }
  
  public int a(int paramInt, String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return paramInt;
      if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString)) {
        return ((alii)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString)).b;
      }
    } while (!paramBoolean);
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() <= -2147483648) {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(-1);
    }
    int i = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.decrementAndGet();
    alii localalii = new alii(paramInt, i);
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localalii);
    return i;
  }
  
  public alhq a()
  {
    return this.jdField_a_of_type_Alhq;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Bhsl.sendEmptyMessage(4);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_a_of_type_JavaUtilSet.clear();
    this.jdField_b_of_type_JavaUtilSet.clear();
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    if (this.jdField_a_of_type_Alhq != null) {
      this.jdField_a_of_type_Alhq.a().a();
    }
    this.jdField_a_of_type_Bhsl.removeMessages(6);
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    this.jdField_a_of_type_Bhsl.obtainMessage(5, paramBundle).sendToTarget();
  }
  
  public void a(int paramInt, String paramString, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_Alhq == null) {
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
      paramBundle.putInt("initJavaHeap", alhz.c());
      paramBundle.putInt("initNativeHeap", alhz.d());
    }
    this.jdField_a_of_type_Bhsl.obtainMessage(1, paramBundle).sendToTarget();
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
  
  public void a(alhq paramalhq)
  {
    alhq localalhq = paramalhq;
    if (paramalhq == null)
    {
      localalhq = alhz.a();
      QLog.e("TraceReport", 1, "init error, outside not init config");
    }
    this.jdField_a_of_type_Alhq = localalhq;
    if (this.jdField_a_of_type_Alil == null) {
      this.jdField_a_of_type_Alil = new alil();
    }
    this.jdField_a_of_type_Alil.a(localalhq);
    this.jdField_a_of_type_Bhsl.sendEmptyMessage(0);
  }
  
  public void a(TraceData paramTraceData)
  {
    if ((!a()) || (paramTraceData.featureId < 0)) {}
    do
    {
      return;
      if ((this.jdField_a_of_type_Alil != null) && (this.jdField_a_of_type_Alhq != null))
      {
        if (this.jdField_a_of_type_Alil.a(paramTraceData))
        {
          this.jdField_a_of_type_Bhsl.removeMessages(6);
          this.jdField_a_of_type_Bhsl.sendEmptyMessageDelayed(6, alil.a);
          return;
        }
        this.jdField_a_of_type_Bhsl.removeMessages(6);
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
    if (this.jdField_a_of_type_Alhq == null) {
      return false;
    }
    return this.jdField_a_of_type_Alhq.a(paramInt);
  }
  
  public void b(int paramInt, String paramString, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_Alhq == null) {
      a(null);
    }
    int i = a(paramInt, paramString, false);
    if (this.jdField_a_of_type_JavaUtilSet.contains(Integer.valueOf(i))) {
      return;
    }
    paramBundle.putInt("featureId", i);
    if (a(paramInt))
    {
      paramBundle.putInt("endJavaHeap", alhz.c());
      paramBundle.putInt("endNativeHeap", alhz.d());
    }
    this.jdField_a_of_type_Bhsl.obtainMessage(2, paramBundle).sendToTarget();
  }
  
  public void c(int paramInt, String paramString, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_Alhq == null) {
      a(null);
    }
    paramInt = a(paramInt, paramString, false);
    if (this.jdField_a_of_type_JavaUtilSet.contains(Integer.valueOf(paramInt))) {}
    while (this.jdField_b_of_type_JavaUtilSet.contains(Integer.valueOf(paramInt))) {
      return;
    }
    paramBundle.putInt("featureId", paramInt);
    this.jdField_a_of_type_Bhsl.obtainMessage(3, paramBundle).sendToTarget();
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
      if (this.jdField_a_of_type_Alil != null)
      {
        this.jdField_a_of_type_Alil.a();
        continue;
        b(paramMessage.getInt("featureId"), paramMessage);
        continue;
        c(paramMessage.getInt("featureId"), paramMessage);
        continue;
        d(paramMessage.getInt("featureId"), paramMessage);
        continue;
        if (this.jdField_a_of_type_Alil != null)
        {
          this.jdField_a_of_type_Alil.c();
          continue;
          e(paramMessage.getInt("featureId"), paramMessage);
          continue;
          if (this.jdField_a_of_type_Alil != null) {
            this.jdField_a_of_type_Alil.b();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alht
 * JD-Core Version:    0.7.0.1
 */