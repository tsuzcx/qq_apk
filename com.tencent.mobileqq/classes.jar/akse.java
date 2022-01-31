import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class akse
  extends akrz<Canvas>
{
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint(2);
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private Rect b = new Rect();
  
  public boolean a(Canvas paramCanvas, float paramFloat)
  {
    boolean bool = false;
    if (paramCanvas == null) {
      return bool;
    }
    label25:
    aksc localaksc;
    Bitmap localBitmap;
    for (;;)
    {
      try
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        if (!localIterator.hasNext()) {
          break label360;
        }
        localaksc = (aksc)localIterator.next();
        localaksc.b();
        if (!localaksc.a())
        {
          localIterator.remove();
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("CanvasDisplay", 2, "remove invalidate barrage:" + localaksc);
          continue;
        }
        localBitmap = localaksc.a();
      }
      finally {}
      if ((localBitmap != null) && (!localBitmap.isRecycled()))
      {
        paramCanvas.save();
        if (paramFloat == 1.0F)
        {
          if (this.jdField_a_of_type_AndroidGraphicsPaint.getAlpha() != localaksc.d) {
            this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(localaksc.d);
          }
          label165:
          if (localaksc.h <= 0.0F) {
            break label388;
          }
        }
      }
    }
    label388:
    for (float f1 = localaksc.h;; f1 = 1.0F)
    {
      float f2 = localaksc.jdField_e_of_type_Float;
      float f3 = localaksc.jdField_f_of_type_Float;
      float f4 = localaksc.jdField_e_of_type_Float;
      float f5 = localaksc.jdField_e_of_type_Int;
      float f6 = localaksc.jdField_f_of_type_Float;
      paramCanvas.clipRect(f2, f3, f4 + f5 * f1, f1 * localaksc.jdField_f_of_type_Int + f6);
      paramCanvas.translate(localaksc.jdField_e_of_type_Float, localaksc.jdField_f_of_type_Float);
      if (localaksc.h != 0.0F) {
        paramCanvas.scale(localaksc.h, localaksc.h);
      }
      this.jdField_a_of_type_AndroidGraphicsRect.set(0, 0, localBitmap.getWidth(), localBitmap.getHeight());
      this.b.set(0, 0, localaksc.jdField_e_of_type_Int, localaksc.jdField_f_of_type_Int);
      paramCanvas.drawBitmap(localBitmap, this.jdField_a_of_type_AndroidGraphicsRect, this.b, this.jdField_a_of_type_AndroidGraphicsPaint);
      paramCanvas.restore();
      break label25;
      this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha((int)(255.0F * paramFloat));
      break label165;
      label360:
      bool = this.jdField_a_of_type_JavaUtilList.isEmpty();
      if (!bool) {}
      for (bool = true;; bool = false) {
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akse
 * JD-Core Version:    0.7.0.1
 */