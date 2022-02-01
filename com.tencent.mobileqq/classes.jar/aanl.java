import android.graphics.Bitmap;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class aanl
  implements bbmy
{
  public long a;
  
  aanl(aank paramaank, List paramList, aane paramaane, aanf paramaanf) {}
  
  private boolean a()
  {
    boolean bool2 = false;
    int i;
    if (aank.a(this.jdField_a_of_type_Aank).size() == 1) {
      i = 0;
    }
    int j;
    do
    {
      long l = 1000000 * aank.c(this.jdField_a_of_type_Aank);
      boolean bool1 = bool2;
      if (aank.a(this.jdField_a_of_type_Aank) != null)
      {
        bool1 = bool2;
        if (((Integer)aank.a(this.jdField_a_of_type_Aank).get(i)).intValue() > 0)
        {
          bool1 = bool2;
          if (aank.a(this.jdField_a_of_type_Aank) < aank.b(this.jdField_a_of_type_Aank) * 1000000L)
          {
            aank.a(this.jdField_a_of_type_Aank).a(3553, ((Integer)aank.a(this.jdField_a_of_type_Aank).get(0)).intValue(), null, null, aank.a(this.jdField_a_of_type_Aank));
            aank.a(this.jdField_a_of_type_Aank, aank.a(this.jdField_a_of_type_Aank) + l);
            bool1 = true;
          }
        }
      }
      return bool1;
      j = (int)(aank.a(this.jdField_a_of_type_Aank) / (Long.valueOf("2").longValue() * 1000L * 1000000L));
      i = j;
    } while (j < aank.a(this.jdField_a_of_type_Aank).size());
    return false;
  }
  
  public void onEncodeError(int paramInt, Throwable paramThrowable)
  {
    if (QLog.isColorLevel()) {
      QLog.e("MuiltiImageToVideo", 2, "onEncodeError, code:" + paramInt);
    }
    synchronized (this.jdField_a_of_type_Aank)
    {
      this.jdField_a_of_type_Aank.notifyAll();
      if (this.jdField_a_of_type_Aane != null)
      {
        this.jdField_a_of_type_Aanf.a(paramThrowable.getMessage());
        this.jdField_a_of_type_Aanf.a(943001);
        this.jdField_a_of_type_Aane.failed(this.jdField_a_of_type_Aanf);
      }
      return;
    }
  }
  
  public void onEncodeFinish(String arg1)
  {
    long l = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("MuiltiImageToVideo", 2, "onEncodeStart encode cost: " + (l - this.jdField_a_of_type_Long) + " ms mGpuBlur:" + aank.a(this.jdField_a_of_type_Aank));
    }
    if (this.jdField_a_of_type_Aane != null) {
      this.jdField_a_of_type_Aane.success(this.jdField_a_of_type_Aanf);
    }
    if (aank.a(this.jdField_a_of_type_Aank) != null)
    {
      aank.a(this.jdField_a_of_type_Aank).surfaceDestroyed();
      aank.a(this.jdField_a_of_type_Aank, null);
    }
    if (aank.a(this.jdField_a_of_type_Aank) != null)
    {
      aank.a(this.jdField_a_of_type_Aank).c();
      aank.a(this.jdField_a_of_type_Aank, null);
    }
    if (aank.a(this.jdField_a_of_type_Aank) != null) {
      aank.a(this.jdField_a_of_type_Aank).clear();
    }
    synchronized (this.jdField_a_of_type_Aank)
    {
      this.jdField_a_of_type_Aank.notifyAll();
      return;
    }
  }
  
  public void onEncodeFrame()
  {
    QLog.d("MuiltiImageToVideo", 2, "onEncodeFrame() ");
    if ((!a()) && (aank.a(this.jdField_a_of_type_Aank) != null)) {
      aank.a(this.jdField_a_of_type_Aank).b();
    }
  }
  
  public void onEncodeStart()
  {
    long l1 = System.currentTimeMillis();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    if (localIterator.hasNext())
    {
      Bitmap localBitmap = (Bitmap)localIterator.next();
      if (!aank.a(this.jdField_a_of_type_Aank)) {}
      for (int i = aank.a(this.jdField_a_of_type_Aank, localBitmap, aank.a(this.jdField_a_of_type_Aank), aank.b(this.jdField_a_of_type_Aank));; i = aank.b(this.jdField_a_of_type_Aank, localBitmap, aank.a(this.jdField_a_of_type_Aank), aank.b(this.jdField_a_of_type_Aank)))
      {
        aank.a(this.jdField_a_of_type_Aank).add(Integer.valueOf(i));
        break;
      }
    }
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("MuiltiImageToVideo", 2, "onEncodeStart preProcess cost: " + (l2 - l1) + " ms mGpuBlur:" + aank.a(this.jdField_a_of_type_Aank));
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aanl
 * JD-Core Version:    0.7.0.1
 */