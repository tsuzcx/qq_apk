import android.graphics.Bitmap;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class aaxl
  implements batv
{
  public long a;
  
  aaxl(aaxk paramaaxk, List paramList, aaxe paramaaxe, aaxf paramaaxf) {}
  
  private boolean a()
  {
    boolean bool2 = false;
    int i;
    if (aaxk.a(this.jdField_a_of_type_Aaxk).size() == 1) {
      i = 0;
    }
    int j;
    do
    {
      long l = 1000000 * aaxk.c(this.jdField_a_of_type_Aaxk);
      boolean bool1 = bool2;
      if (aaxk.a(this.jdField_a_of_type_Aaxk) != null)
      {
        bool1 = bool2;
        if (((Integer)aaxk.a(this.jdField_a_of_type_Aaxk).get(i)).intValue() > 0)
        {
          bool1 = bool2;
          if (aaxk.a(this.jdField_a_of_type_Aaxk) < aaxk.b(this.jdField_a_of_type_Aaxk) * 1000000L)
          {
            aaxk.a(this.jdField_a_of_type_Aaxk).a(3553, ((Integer)aaxk.a(this.jdField_a_of_type_Aaxk).get(0)).intValue(), null, null, aaxk.a(this.jdField_a_of_type_Aaxk));
            aaxk.a(this.jdField_a_of_type_Aaxk, aaxk.a(this.jdField_a_of_type_Aaxk) + l);
            bool1 = true;
          }
        }
      }
      return bool1;
      j = (int)(aaxk.a(this.jdField_a_of_type_Aaxk) / (Long.valueOf("2").longValue() * 1000L * 1000000L));
      i = j;
    } while (j < aaxk.a(this.jdField_a_of_type_Aaxk).size());
    return false;
  }
  
  public void a()
  {
    long l1 = System.currentTimeMillis();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    if (localIterator.hasNext())
    {
      Bitmap localBitmap = (Bitmap)localIterator.next();
      if (!aaxk.a(this.jdField_a_of_type_Aaxk)) {}
      for (int i = aaxk.a(this.jdField_a_of_type_Aaxk, localBitmap, aaxk.a(this.jdField_a_of_type_Aaxk), aaxk.b(this.jdField_a_of_type_Aaxk));; i = aaxk.b(this.jdField_a_of_type_Aaxk, localBitmap, aaxk.a(this.jdField_a_of_type_Aaxk), aaxk.b(this.jdField_a_of_type_Aaxk)))
      {
        aaxk.a(this.jdField_a_of_type_Aaxk).add(Integer.valueOf(i));
        break;
      }
    }
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("MuiltiImageToVideo", 2, "onEncodeStart preProcess cost: " + (l2 - l1) + " ms mGpuBlur:" + aaxk.a(this.jdField_a_of_type_Aaxk));
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    a();
  }
  
  public void a(String arg1)
  {
    long l = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("MuiltiImageToVideo", 2, "onEncodeStart encode cost: " + (l - this.jdField_a_of_type_Long) + " ms mGpuBlur:" + aaxk.a(this.jdField_a_of_type_Aaxk));
    }
    if (this.jdField_a_of_type_Aaxe != null) {
      this.jdField_a_of_type_Aaxe.a(this.jdField_a_of_type_Aaxf);
    }
    if (aaxk.a(this.jdField_a_of_type_Aaxk) != null)
    {
      aaxk.a(this.jdField_a_of_type_Aaxk).surfaceDestroyed();
      aaxk.a(this.jdField_a_of_type_Aaxk, null);
    }
    if (aaxk.a(this.jdField_a_of_type_Aaxk) != null)
    {
      aaxk.a(this.jdField_a_of_type_Aaxk).c();
      aaxk.a(this.jdField_a_of_type_Aaxk, null);
    }
    if (aaxk.a(this.jdField_a_of_type_Aaxk) != null) {
      aaxk.a(this.jdField_a_of_type_Aaxk).clear();
    }
    synchronized (this.jdField_a_of_type_Aaxk)
    {
      this.jdField_a_of_type_Aaxk.notifyAll();
      return;
    }
  }
  
  public void a_(int paramInt, Throwable paramThrowable)
  {
    if (QLog.isColorLevel()) {
      QLog.e("MuiltiImageToVideo", 2, "onEncodeError, code:" + paramInt);
    }
    synchronized (this.jdField_a_of_type_Aaxk)
    {
      this.jdField_a_of_type_Aaxk.notifyAll();
      if (this.jdField_a_of_type_Aaxe != null)
      {
        this.jdField_a_of_type_Aaxf.a(paramThrowable.getMessage());
        this.jdField_a_of_type_Aaxf.a(943001);
        this.jdField_a_of_type_Aaxe.b(this.jdField_a_of_type_Aaxf);
      }
      return;
    }
  }
  
  public void b()
  {
    QLog.d("MuiltiImageToVideo", 2, "onEncodeFrame() ");
    if ((!a()) && (aaxk.a(this.jdField_a_of_type_Aaxk) != null)) {
      aaxk.a(this.jdField_a_of_type_Aaxk).b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaxl
 * JD-Core Version:    0.7.0.1
 */