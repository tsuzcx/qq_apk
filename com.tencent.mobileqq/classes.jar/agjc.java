import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class agjc
  extends Handler
{
  private long jdField_a_of_type_Long = 1000L;
  public CopyOnWriteArrayList<agjd> a;
  private boolean jdField_a_of_type_Boolean;
  private long jdField_b_of_type_Long;
  private boolean jdField_b_of_type_Boolean;
  
  public agjc()
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  }
  
  public agjc(Looper paramLooper)
  {
    super(paramLooper);
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  }
  
  public void a()
  {
    this.jdField_b_of_type_Boolean = false;
    b();
    c();
  }
  
  public void a(long paramLong)
  {
    this.jdField_b_of_type_Long = Math.max(SystemClock.elapsedRealtime() + 1000L * paramLong, this.jdField_b_of_type_Long);
    f();
  }
  
  public void a(agjd paramagjd)
  {
    long l = SystemClock.elapsedRealtime();
    if (agjd.a(paramagjd) > l)
    {
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(paramagjd);
      a(agjd.a(paramagjd) - l);
      return;
    }
    paramagjd.b();
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.isEmpty()) {
      g();
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext()) {
      ((agjd)localIterator.next()).a();
    }
  }
  
  public void b(agjd paramagjd)
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(paramagjd);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() < 2) {
      g();
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext()) {
      ((agjd)localIterator.next()).b();
    }
  }
  
  public void d()
  {
    removeMessages(1);
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void e()
  {
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_b_of_type_Long >= SystemClock.elapsedRealtime()) {
      sendMessage(obtainMessage(1));
    }
  }
  
  public void f()
  {
    for (;;)
    {
      try
      {
        boolean bool = this.jdField_b_of_type_Boolean;
        if (bool) {
          return;
        }
        if (this.jdField_b_of_type_Long <= SystemClock.elapsedRealtime())
        {
          a();
          continue;
        }
        this.jdField_b_of_type_Boolean = true;
      }
      finally {}
      sendMessage(obtainMessage(1));
    }
  }
  
  public void g()
  {
    this.jdField_b_of_type_Boolean = false;
    removeMessages(1);
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
  }
  
  public void handleMessage(Message paramMessage)
  {
    for (;;)
    {
      try
      {
        l = this.jdField_b_of_type_Long - SystemClock.elapsedRealtime();
        if (l <= 0L)
        {
          a();
          return;
        }
        if (l < this.jdField_a_of_type_Long)
        {
          sendMessageDelayed(obtainMessage(1), l);
          continue;
        }
        l = SystemClock.elapsedRealtime();
      }
      finally {}
      b();
      for (long l = l + this.jdField_a_of_type_Long - SystemClock.elapsedRealtime(); l < 0L; l += this.jdField_a_of_type_Long) {}
      sendMessageDelayed(obtainMessage(1), l);
    }
  }
  
  public boolean sendMessageAtTime(Message paramMessage, long paramLong)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return super.sendMessageAtTime(paramMessage, paramLong);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agjc
 * JD-Core Version:    0.7.0.1
 */