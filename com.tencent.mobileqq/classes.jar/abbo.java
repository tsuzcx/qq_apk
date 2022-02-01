import android.graphics.Bitmap;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class abbo
  implements bbmo
{
  public long a;
  
  abbo(abbn paramabbn, List paramList, abbh paramabbh, abbi paramabbi) {}
  
  private boolean a()
  {
    boolean bool2 = false;
    int i;
    if (abbn.a(this.jdField_a_of_type_Abbn).size() == 1) {
      i = 0;
    }
    int j;
    do
    {
      long l = 1000000 * abbn.c(this.jdField_a_of_type_Abbn);
      boolean bool1 = bool2;
      if (abbn.a(this.jdField_a_of_type_Abbn) != null)
      {
        bool1 = bool2;
        if (((Integer)abbn.a(this.jdField_a_of_type_Abbn).get(i)).intValue() > 0)
        {
          bool1 = bool2;
          if (abbn.a(this.jdField_a_of_type_Abbn) < abbn.b(this.jdField_a_of_type_Abbn) * 1000000L)
          {
            abbn.a(this.jdField_a_of_type_Abbn).a(3553, ((Integer)abbn.a(this.jdField_a_of_type_Abbn).get(0)).intValue(), null, null, abbn.a(this.jdField_a_of_type_Abbn));
            abbn.a(this.jdField_a_of_type_Abbn, abbn.a(this.jdField_a_of_type_Abbn) + l);
            bool1 = true;
          }
        }
      }
      return bool1;
      j = (int)(abbn.a(this.jdField_a_of_type_Abbn) / (Long.valueOf("2").longValue() * 1000L * 1000000L));
      i = j;
    } while (j < abbn.a(this.jdField_a_of_type_Abbn).size());
    return false;
  }
  
  public void a()
  {
    long l1 = System.currentTimeMillis();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    if (localIterator.hasNext())
    {
      Bitmap localBitmap = (Bitmap)localIterator.next();
      if (!abbn.a(this.jdField_a_of_type_Abbn)) {}
      for (int i = abbn.a(this.jdField_a_of_type_Abbn, localBitmap, abbn.a(this.jdField_a_of_type_Abbn), abbn.b(this.jdField_a_of_type_Abbn));; i = abbn.b(this.jdField_a_of_type_Abbn, localBitmap, abbn.a(this.jdField_a_of_type_Abbn), abbn.b(this.jdField_a_of_type_Abbn)))
      {
        abbn.a(this.jdField_a_of_type_Abbn).add(Integer.valueOf(i));
        break;
      }
    }
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("MuiltiImageToVideo", 2, "onEncodeStart preProcess cost: " + (l2 - l1) + " ms mGpuBlur:" + abbn.a(this.jdField_a_of_type_Abbn));
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    a();
  }
  
  public void a(String arg1)
  {
    long l = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("MuiltiImageToVideo", 2, "onEncodeStart encode cost: " + (l - this.jdField_a_of_type_Long) + " ms mGpuBlur:" + abbn.a(this.jdField_a_of_type_Abbn));
    }
    if (this.jdField_a_of_type_Abbh != null) {
      this.jdField_a_of_type_Abbh.a(this.jdField_a_of_type_Abbi);
    }
    if (abbn.a(this.jdField_a_of_type_Abbn) != null)
    {
      abbn.a(this.jdField_a_of_type_Abbn).surfaceDestroyed();
      abbn.a(this.jdField_a_of_type_Abbn, null);
    }
    if (abbn.a(this.jdField_a_of_type_Abbn) != null)
    {
      abbn.a(this.jdField_a_of_type_Abbn).c();
      abbn.a(this.jdField_a_of_type_Abbn, null);
    }
    if (abbn.a(this.jdField_a_of_type_Abbn) != null) {
      abbn.a(this.jdField_a_of_type_Abbn).clear();
    }
    synchronized (this.jdField_a_of_type_Abbn)
    {
      this.jdField_a_of_type_Abbn.notifyAll();
      return;
    }
  }
  
  public void a_(int paramInt, Throwable paramThrowable)
  {
    if (QLog.isColorLevel()) {
      QLog.e("MuiltiImageToVideo", 2, "onEncodeError, code:" + paramInt);
    }
    synchronized (this.jdField_a_of_type_Abbn)
    {
      this.jdField_a_of_type_Abbn.notifyAll();
      if (this.jdField_a_of_type_Abbh != null)
      {
        this.jdField_a_of_type_Abbi.a(paramThrowable.getMessage());
        this.jdField_a_of_type_Abbi.a(943001);
        this.jdField_a_of_type_Abbh.b(this.jdField_a_of_type_Abbi);
      }
      return;
    }
  }
  
  public void b()
  {
    QLog.d("MuiltiImageToVideo", 2, "onEncodeFrame() ");
    if ((!a()) && (abbn.a(this.jdField_a_of_type_Abbn) != null)) {
      abbn.a(this.jdField_a_of_type_Abbn).b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abbo
 * JD-Core Version:    0.7.0.1
 */