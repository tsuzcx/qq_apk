import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.AvatarPendantManager;

class alnm
  extends AnimatorListenerAdapter
{
  alnm(alni paramalni, alns paramalns) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if ((this.jdField_a_of_type_Alni.d != null) && (this.jdField_a_of_type_Alni.e != null))
    {
      this.jdField_a_of_type_Alni.d.setVisibility(4);
      this.jdField_a_of_type_Alni.e.setVisibility(0);
      paramAnimator = (AvatarPendantManager)this.jdField_a_of_type_Alni.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(46);
      paramAnimator.jdField_a_of_type_Long = -1L;
      this.jdField_a_of_type_Alni.a("show pendant, " + this.jdField_a_of_type_Alni.jdField_a_of_type_Long);
      paramAnimator.b();
    }
    if (this.jdField_a_of_type_Alni.c != null) {
      this.jdField_a_of_type_Alni.c.setVisibility(0);
    }
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if ((this.jdField_a_of_type_Alni.d != null) && (this.jdField_a_of_type_Alni.e != null))
    {
      this.jdField_a_of_type_Alni.d.setVisibility(0);
      this.jdField_a_of_type_Alni.e.setVisibility(4);
      paramAnimator = (AvatarPendantManager)this.jdField_a_of_type_Alni.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(46);
      this.jdField_a_of_type_Alni.a("stop show pendant, " + this.jdField_a_of_type_Alni.jdField_a_of_type_Long);
      paramAnimator.jdField_a_of_type_Long = this.jdField_a_of_type_Alni.jdField_a_of_type_Long;
      paramAnimator.a();
    }
    if ((this.jdField_a_of_type_Alni.c != null) && (TextUtils.isEmpty(this.jdField_a_of_type_Alns.e))) {
      this.jdField_a_of_type_Alni.c.setVisibility(4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     alnm
 * JD-Core Version:    0.7.0.1
 */