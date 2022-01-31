import android.graphics.Bitmap;
import android.graphics.Rect;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class aljj
  implements asjt
{
  aljj(alji paramalji, Rect paramRect, long paramLong, Object paramObject, asjq paramasjq, boolean[] paramArrayOfBoolean, Bitmap paramBitmap) {}
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_Asjq != null) && (alji.a(this.jdField_a_of_type_Alji) != null)) {
      this.jdField_a_of_type_ArrayOfBoolean[0] = this.jdField_a_of_type_Asjq.a(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_Long);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("MiniRecog.MiniCodeController", 2, "detectSync onDetectReady exec=" + this.jdField_a_of_type_ArrayOfBoolean[0]);
      }
      if (this.jdField_a_of_type_ArrayOfBoolean[0] == 0) {}
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        this.jdField_a_of_type_JavaLangObject.notifyAll();
        return;
        this.jdField_a_of_type_ArrayOfBoolean[0] = false;
      }
    }
  }
  
  public void a(long paramLong) {}
  
  public void a(List<alje> arg1, long paramLong)
  {
    int i = 0;
    label55:
    boolean bool;
    label68:
    int j;
    int k;
    int m;
    if (i < ???.size())
    {
      if (((alje)???.get(i)).jdField_a_of_type_Int != 2) {
        break label217;
      }
      ??? = (alje)???.get(i);
      this.jdField_a_of_type_AndroidGraphicsRect.set(???.jdField_a_of_type_AndroidGraphicsRect);
      if (QLog.isColorLevel())
      {
        if (??? == null) {
          break label226;
        }
        bool = true;
        i = this.jdField_a_of_type_AndroidGraphicsRect.left;
        j = this.jdField_a_of_type_AndroidGraphicsRect.top;
        k = this.jdField_a_of_type_AndroidGraphicsRect.width();
        m = this.jdField_a_of_type_AndroidGraphicsRect.height();
        if (??? == null) {
          break label232;
        }
      }
    }
    label217:
    label226:
    label232:
    for (float f = ???.jdField_a_of_type_Float;; f = 0.0F)
    {
      QLog.i("MiniRecog.MiniCodeController", 2, String.format("detectSync onDetectResult=%b [left,top,w,h,score]=[%d, %d, %d, %d]", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Float.valueOf(f) }));
      if (paramLong == this.jdField_a_of_type_Long)
      {
        synchronized (this.jdField_a_of_type_JavaLangObject)
        {
          this.jdField_a_of_type_JavaLangObject.notifyAll();
          return;
        }
        ??? = null;
        break label55;
      }
      return;
      i += 1;
      break;
      bool = false;
      break label68;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aljj
 * JD-Core Version:    0.7.0.1
 */