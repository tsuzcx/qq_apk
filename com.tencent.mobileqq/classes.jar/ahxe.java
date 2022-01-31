import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.activity.richmedia.VideoFilterViewPager;
import com.tencent.qphone.base.util.QLog;

public class ahxe
  implements Animation.AnimationListener
{
  private int jdField_a_of_type_Int;
  private ahxf jdField_a_of_type_Ahxf;
  
  public ahxe(VideoFilterViewPager paramVideoFilterViewPager, ahxf paramahxf, int paramInt)
  {
    this.jdField_a_of_type_Ahxf = paramahxf;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if ((this.jdField_a_of_type_Ahxf != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterViewPager.getCurrentItem() == this.jdField_a_of_type_Int))
    {
      this.jdField_a_of_type_Ahxf.a(1);
      if (QLog.isColorLevel()) {
        QLog.d("VideoFilterViewPager", 2, "OnViewPagerItemVisiableChangeListener animation dismiss state: 1");
      }
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahxe
 * JD-Core Version:    0.7.0.1
 */