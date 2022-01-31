import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Rect;
import com.tencent.mobileqq.ocr.view.ScanOcrView;

public class agia
  implements ValueAnimator.AnimatorUpdateListener
{
  public agia(ScanOcrView paramScanOcrView, agic paramagic) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    int j = (int)(this.jdField_a_of_type_Agic.a * f);
    int i = (int)(f * this.jdField_a_of_type_Agic.jdField_b_of_type_Int);
    int m = j - this.jdField_a_of_type_Agic.a;
    int k = i - this.jdField_a_of_type_Agic.jdField_b_of_type_Int;
    j = (int)(paramValueAnimator.getAnimatedFraction() * 255.0F);
    i = j;
    if (j > 255) {
      i = 255;
    }
    j = i;
    if (i < 0) {
      j = 0;
    }
    i = this.jdField_a_of_type_Agic.jdField_b_of_type_AndroidGraphicsRect.left;
    int n = m / 2;
    int i1 = this.jdField_a_of_type_Agic.jdField_b_of_type_AndroidGraphicsRect.top;
    int i2 = k / 2;
    int i3 = this.jdField_a_of_type_Agic.jdField_b_of_type_AndroidGraphicsRect.right;
    m /= 2;
    int i4 = this.jdField_a_of_type_Agic.jdField_b_of_type_AndroidGraphicsRect.bottom;
    k /= 2;
    this.jdField_a_of_type_Agic.e = j;
    this.jdField_a_of_type_Agic.c.set(i - n, i1 - i2, m + i3, k + i4);
    this.jdField_a_of_type_ComTencentMobileqqOcrViewScanOcrView.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     agia
 * JD-Core Version:    0.7.0.1
 */