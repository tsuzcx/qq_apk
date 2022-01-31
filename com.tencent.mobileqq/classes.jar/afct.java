import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

public class afct
  extends Drawable
{
  private static final Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private static final RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private ColorFilter jdField_a_of_type_AndroidGraphicsColorFilter;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint(1);
  
  public afct(int paramInt1, int paramInt2, float paramFloat)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(paramInt1);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(paramInt2);
    this.jdField_a_of_type_Float = paramFloat;
  }
  
  public void draw(Canvas paramCanvas)
  {
    Rect localRect = getBounds();
    int i = localRect.width();
    int j = localRect.height();
    if ((i > 0) && (j > 0))
    {
      paramCanvas.save();
      jdField_a_of_type_AndroidGraphicsRectF.set(localRect);
      paramCanvas.drawRoundRect(jdField_a_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_Float, this.jdField_a_of_type_Float, this.jdField_a_of_type_AndroidGraphicsPaint);
      paramCanvas.restore();
    }
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public void setAlpha(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.jdField_a_of_type_AndroidGraphicsColorFilter = paramColorFilter;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afct
 * JD-Core Version:    0.7.0.1
 */