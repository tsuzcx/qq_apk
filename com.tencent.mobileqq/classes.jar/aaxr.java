import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import com.tencent.mobileqq.armap.TreasureBaseActivity;

public class aaxr
  extends BitmapDrawable
{
  public aaxr(TreasureBaseActivity paramTreasureBaseActivity, Resources paramResources, Bitmap paramBitmap1, float paramFloat, Bitmap paramBitmap2)
  {
    super(paramResources, paramBitmap1);
  }
  
  public void draw(Canvas paramCanvas)
  {
    paramCanvas.save();
    paramCanvas.rotate(this.jdField_a_of_type_Float, this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() / 2, this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() / 2);
    super.draw(paramCanvas);
    paramCanvas.restore();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aaxr
 * JD-Core Version:    0.7.0.1
 */