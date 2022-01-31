import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.activity.richmedia.VideoFilterViewPager;
import com.tencent.qphone.base.util.QLog;

public class ahkm
  implements Animation.AnimationListener
{
  private int jdField_a_of_type_Int;
  private ahkn jdField_a_of_type_Ahkn;
  
  public ahkm(VideoFilterViewPager paramVideoFilterViewPager, ahkn paramahkn, int paramInt)
  {
    this.jdField_a_of_type_Ahkn = paramahkn;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if ((this.jdField_a_of_type_Ahkn != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterViewPager.getCurrentItem() == this.jdField_a_of_type_Int))
    {
      this.jdField_a_of_type_Ahkn.a(1);
      if (QLog.isColorLevel()) {
        QLog.d("VideoFilterViewPager", 2, "OnViewPagerItemVisiableChangeListener animation dismiss state: 1");
      }
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahkm
 * JD-Core Version:    0.7.0.1
 */