import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.AvatarPendantManager;

class ambz
  extends AnimatorListenerAdapter
{
  ambz(ambv paramambv, amcf paramamcf) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if ((this.jdField_a_of_type_Ambv.d != null) && (this.jdField_a_of_type_Ambv.e != null))
    {
      this.jdField_a_of_type_Ambv.d.setVisibility(4);
      this.jdField_a_of_type_Ambv.e.setVisibility(0);
      paramAnimator = (AvatarPendantManager)this.jdField_a_of_type_Ambv.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(46);
      paramAnimator.jdField_a_of_type_Long = -1L;
      this.jdField_a_of_type_Ambv.a("show pendant, " + this.jdField_a_of_type_Ambv.jdField_a_of_type_Long);
      paramAnimator.b();
    }
    if (this.jdField_a_of_type_Ambv.c != null) {
      this.jdField_a_of_type_Ambv.c.setVisibility(0);
    }
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if ((this.jdField_a_of_type_Ambv.d != null) && (this.jdField_a_of_type_Ambv.e != null))
    {
      this.jdField_a_of_type_Ambv.d.setVisibility(0);
      this.jdField_a_of_type_Ambv.e.setVisibility(4);
      paramAnimator = (AvatarPendantManager)this.jdField_a_of_type_Ambv.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(46);
      this.jdField_a_of_type_Ambv.a("stop show pendant, " + this.jdField_a_of_type_Ambv.jdField_a_of_type_Long);
      paramAnimator.jdField_a_of_type_Long = this.jdField_a_of_type_Ambv.jdField_a_of_type_Long;
      paramAnimator.a();
    }
    if ((this.jdField_a_of_type_Ambv.c != null) && (TextUtils.isEmpty(this.jdField_a_of_type_Amcf.e))) {
      this.jdField_a_of_type_Ambv.c.setVisibility(4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ambz
 * JD-Core Version:    0.7.0.1
 */