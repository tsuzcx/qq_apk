import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.mobileqq.ocr.view.ScanOcrView;

public class aghz
  extends AnimatorListenerAdapter
{
  public aghz(ScanOcrView paramScanOcrView, int paramInt) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqOcrViewScanOcrView.b) {
      ScanOcrView.a(this.jdField_a_of_type_ComTencentMobileqqOcrViewScanOcrView, this.jdField_a_of_type_Int + 1);
    }
    if (this.jdField_a_of_type_Int == 2) {
      this.jdField_a_of_type_ComTencentMobileqqOcrViewScanOcrView.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aghz
 * JD-Core Version:    0.7.0.1
 */