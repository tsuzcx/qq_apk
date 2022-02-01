import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.TextView;
import com.tencent.biz.videostory.widget.easylyric.SingleLyricView;

public class aayc
  extends AnimatorListenerAdapter
{
  public aayc(SingleLyricView paramSingleLyricView, String paramString) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    super.onAnimationCancel(paramAnimator);
    if (SingleLyricView.a(this.jdField_a_of_type_ComTencentBizVideostoryWidgetEasylyricSingleLyricView) != null) {
      SingleLyricView.a(this.jdField_a_of_type_ComTencentBizVideostoryWidgetEasylyricSingleLyricView).setText(this.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (SingleLyricView.a(this.jdField_a_of_type_ComTencentBizVideostoryWidgetEasylyricSingleLyricView) != null)
    {
      SingleLyricView.a(this.jdField_a_of_type_ComTencentBizVideostoryWidgetEasylyricSingleLyricView).setText(this.jdField_a_of_type_JavaLangString);
      SingleLyricView.a(this.jdField_a_of_type_ComTencentBizVideostoryWidgetEasylyricSingleLyricView).setAlpha(0.3F);
    }
  }
  
  public void onAnimationStart(Animator paramAnimator, boolean paramBoolean)
  {
    SingleLyricView.a(this.jdField_a_of_type_ComTencentBizVideostoryWidgetEasylyricSingleLyricView).setAlpha(1.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aayc
 * JD-Core Version:    0.7.0.1
 */