import android.graphics.Bitmap;
import com.tencent.mobileqq.arcard.ARBlessWordFragment;
import com.tencent.mobileqq.arcard.ARCardUtils;

public class aaeh
  implements Runnable
{
  public aaeh(ARBlessWordFragment paramARBlessWordFragment, Bitmap paramBitmap, Runnable paramRunnable) {}
  
  public void run()
  {
    ARBlessWordFragment.a(this.jdField_a_of_type_ComTencentMobileqqArcardARBlessWordFragment, ARCardUtils.a(this.jdField_a_of_type_AndroidGraphicsBitmap, null, false));
    ARBlessWordFragment.a(this.jdField_a_of_type_ComTencentMobileqqArcardARBlessWordFragment, false);
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      this.jdField_a_of_type_JavaLangRunnable.run();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aaeh
 * JD-Core Version:    0.7.0.1
 */