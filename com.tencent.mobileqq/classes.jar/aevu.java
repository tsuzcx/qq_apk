import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.tencent.qphone.base.util.QLog;

public class aevu
  extends Drawable
{
  public int a;
  public Bitmap a;
  Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint(6);
  Rect jdField_a_of_type_AndroidGraphicsRect;
  boolean jdField_a_of_type_Boolean;
  
  public void a(Bitmap paramBitmap, int paramInt)
  {
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect(0, 0, paramInt, paramBitmap.getHeight());
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
      QLog.e("VoicePrintView", 1, "onDraw(), bmp==null");
    }
    int i;
    do
    {
      return;
      i = 0;
      if (this.jdField_a_of_type_Boolean)
      {
        i = paramCanvas.save();
        paramCanvas.scale(-1.0F, 1.0F, this.jdField_a_of_type_Int / 2.0F, getBounds().exactCenterY());
      }
      paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_AndroidGraphicsRect, getBounds(), this.jdField_a_of_type_AndroidGraphicsPaint);
    } while (!this.jdField_a_of_type_Boolean);
    paramCanvas.restoreToCount(i);
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public void setAlpha(int paramInt)
  {
    if (paramInt != this.jdField_a_of_type_AndroidGraphicsPaint.getAlpha())
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(paramInt);
      super.invalidateSelf();
    }
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setColorFilter(paramColorFilter);
    super.invalidateSelf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aevu
 * JD-Core Version:    0.7.0.1
 */