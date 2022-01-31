import android.graphics.Bitmap;
import com.tencent.mobileqq.arcard.ARBlessWordFragment;
import com.tencent.mobileqq.arcard.ARCardUtils;

public class aasc
  implements Runnable
{
  public aasc(ARBlessWordFragment paramARBlessWordFragment, Bitmap paramBitmap, Runnable paramRunnable) {}
  
  public void run()
  {
    ARBlessWordFragment.a(this.jdField_a_of_type_ComTencentMobileqqArcardARBlessWordFragment, ARCardUtils.a(this.jdField_a_of_type_AndroidGraphicsBitmap, null, false));
    ARBlessWordFragment.a(this.jdField_a_of_type_ComTencentMobileqqArcardARBlessWordFragment, false);
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      this.jdField_a_of_type_JavaLangRunnable.run();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aasc
 * JD-Core Version:    0.7.0.1
 */