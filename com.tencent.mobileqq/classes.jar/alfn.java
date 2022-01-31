import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.worldcup.ARWorldCupGameLogicManager;

class alfn
  implements Runnable
{
  alfn(alfm paramalfm, Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3) {}
  
  public void run()
  {
    Object localObject = new StateListDrawable();
    BitmapDrawable localBitmapDrawable = new BitmapDrawable(this.jdField_a_of_type_AndroidGraphicsBitmap);
    ((StateListDrawable)localObject).addState(new int[] { 16842919 }, localBitmapDrawable);
    localBitmapDrawable = new BitmapDrawable(this.b);
    ((StateListDrawable)localObject).addState(new int[0], localBitmapDrawable);
    if (ARWorldCupGameLogicManager.a(this.jdField_a_of_type_Alfm.a) != null) {
      ARWorldCupGameLogicManager.a(this.jdField_a_of_type_Alfm.a).setBackgroundDrawable((Drawable)localObject);
    }
    localObject = new BitmapDrawable(this.c);
    if (ARWorldCupGameLogicManager.a(this.jdField_a_of_type_Alfm.a) != null) {
      ARWorldCupGameLogicManager.a(this.jdField_a_of_type_Alfm.a).setBackgroundDrawable((Drawable)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     alfn
 * JD-Core Version:    0.7.0.1
 */