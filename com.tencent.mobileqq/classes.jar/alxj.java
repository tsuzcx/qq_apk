import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.activity.richmedia.VideoFilterViewPager;
import com.tencent.qphone.base.util.QLog;

public class alxj
  implements Animation.AnimationListener
{
  private int jdField_a_of_type_Int;
  private alxk jdField_a_of_type_Alxk;
  
  public alxj(VideoFilterViewPager paramVideoFilterViewPager, alxk paramalxk, int paramInt)
  {
    this.jdField_a_of_type_Alxk = paramalxk;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if ((this.jdField_a_of_type_Alxk != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterViewPager.getCurrentItem() == this.jdField_a_of_type_Int))
    {
      this.jdField_a_of_type_Alxk.a(1);
      if (QLog.isColorLevel()) {
        QLog.d("VideoFilterViewPager", 2, "OnViewPagerItemVisiableChangeListener animation dismiss state: 1");
      }
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alxj
 * JD-Core Version:    0.7.0.1
 */