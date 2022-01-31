import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.Gravity;

public class afcu
  extends Drawable
{
  private static final RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private static final Rect jdField_b_of_type_AndroidGraphicsRect = new Rect();
  private float jdField_a_of_type_Float;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint(1);
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private Paint jdField_b_of_type_AndroidGraphicsPaint;
  
  public afcu(int paramInt, float paramFloat)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(paramInt);
    this.jdField_a_of_type_Float = paramFloat;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_AndroidGraphicsPaint = new Paint(1);
    this.jdField_b_of_type_AndroidGraphicsPaint.setTextSize(paramInt1);
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(paramInt2);
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
  }
  
  public void draw(Canvas paramCanvas)
  {
    float f1 = 0.0F;
    int i = getLevel();
    if (i == 0) {}
    Rect localRect1;
    Rect localRect2;
    int j;
    int k;
    int m;
    do
    {
      return;
      localRect1 = jdField_b_of_type_AndroidGraphicsRect;
      localRect2 = getBounds();
      j = localRect2.width();
      k = localRect2.height();
      k -= (10000 - i) * k / 10000;
      m = paramCanvas.getHeight();
      Gravity.apply(48, j, k, localRect2, localRect1);
    } while ((j <= 0) || (k <= 0));
    this.jdField_a_of_type_JavaLangString = (100 - i / 100 + "%");
    paramCanvas.save();
    float f2;
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_b_of_type_AndroidGraphicsPaint.getTextBounds(this.jdField_a_of_type_JavaLangString, 0, this.jdField_a_of_type_JavaLangString.length(), this.jdField_a_of_type_AndroidGraphicsRect);
      f2 = (paramCanvas.getWidth() - this.jdField_a_of_type_AndroidGraphicsRect.width()) / 2;
      f1 = (this.jdField_a_of_type_AndroidGraphicsRect.height() + m) / 2;
      paramCanvas.drawText(this.jdField_a_of_type_JavaLangString, f2, f1, this.jdField_b_of_type_AndroidGraphicsPaint);
    }
    for (;;)
    {
      paramCanvas.clipRect(localRect1);
      jdField_a_of_type_AndroidGraphicsRectF.set(localRect2);
      paramCanvas.drawRoundRect(jdField_a_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_Float, this.jdField_a_of_type_Float, this.jdField_a_of_type_AndroidGraphicsPaint);
      if (this.jdField_a_of_type_Boolean) {
        paramCanvas.drawText(this.jdField_a_of_type_JavaLangString, f2, f1, this.jdField_b_of_type_AndroidGraphicsPaint);
      }
      paramCanvas.restore();
      return;
      f2 = 0.0F;
    }
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afcu
 * JD-Core Version:    0.7.0.1
 */