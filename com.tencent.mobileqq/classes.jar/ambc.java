import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

class ambc
  extends Drawable
{
  public int a;
  public Bitmap a;
  private Paint a;
  public boolean a;
  public int b = -1;
  
  public ambc(Bitmap paramBitmap)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint(6);
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    this.jdField_a_of_type_Int = paramBitmap.getWidth();
    this.b = paramBitmap.getHeight();
  }
  
  public void draw(Canvas paramCanvas)
  {
    Rect localRect = super.getBounds();
    if (this.jdField_a_of_type_Boolean)
    {
      paramCanvas.save();
      paramCanvas.scale(-1.0F, 1.0F, localRect.centerX(), localRect.centerY());
    }
    paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, null, super.getBounds(), this.jdField_a_of_type_AndroidGraphicsPaint);
    if (this.jdField_a_of_type_Boolean) {
      paramCanvas.restore();
    }
  }
  
  public int getIntrinsicHeight()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public int getIntrinsicWidth()
  {
    return this.b;
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
  
  public void setDither(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setDither(paramBoolean);
    super.invalidateSelf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ambc
 * JD-Core Version:    0.7.0.1
 */