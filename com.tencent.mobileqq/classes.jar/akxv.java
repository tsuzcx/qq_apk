import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.StateListDrawable;
import android.widget.Button;
import com.tencent.mobileqq.worldcup.ARWorldCupGameLogicManager;

public class akxv
  implements Runnable
{
  public akxv(ARWorldCupGameLogicManager paramARWorldCupGameLogicManager, Bitmap paramBitmap1, Bitmap paramBitmap2) {}
  
  public void run()
  {
    StateListDrawable localStateListDrawable = new StateListDrawable();
    BitmapDrawable localBitmapDrawable = new BitmapDrawable(this.jdField_a_of_type_AndroidGraphicsBitmap);
    localStateListDrawable.addState(new int[] { 16842919 }, localBitmapDrawable);
    localBitmapDrawable = new BitmapDrawable(this.b);
    localStateListDrawable.addState(new int[0], localBitmapDrawable);
    if (ARWorldCupGameLogicManager.a(this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupGameLogicManager) != null) {
      ARWorldCupGameLogicManager.a(this.jdField_a_of_type_ComTencentMobileqqWorldcupARWorldCupGameLogicManager).setBackgroundDrawable(localStateListDrawable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akxv
 * JD-Core Version:    0.7.0.1
 */