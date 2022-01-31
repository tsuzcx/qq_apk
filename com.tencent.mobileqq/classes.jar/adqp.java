import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.immersion.stickersampleapp.HapticManager;
import com.tencent.mobileqq.activity.aio.item.UnlimitedBladeWorks;
import com.tencent.mobileqq.activity.history.ChatHistoryActivity;
import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.dinifly.ViewAnimation;
import com.tencent.qphone.base.util.QLog;

class adqp
  extends AnimatorListenerAdapter
{
  adqp(adqe paramadqe, adqq paramadqq, MessageForPoke paramMessageForPoke) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    int i = 1;
    super.onAnimationEnd(paramAnimator);
    adqe.f = false;
    this.jdField_a_of_type_Adqq.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(8);
    this.jdField_a_of_type_Adqq.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.jdField_a_of_type_Adqq.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.clearAnimation();
    this.jdField_a_of_type_Adqq.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks.setVisibility(8);
    if ((!this.jdField_a_of_type_ComTencentMobileqqDataMessageForPoke.isSend()) && (this.jdField_a_of_type_Adqq.b == adqe.a()) && (!(this.jdField_a_of_type_Adqe.jdField_a_of_type_AndroidContentContext instanceof ChatHistoryActivity)) && (!adqe.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPoke))) {
      this.jdField_a_of_type_Adqq.c.setVisibility(0);
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqDataMessageForPoke.isPlayed) {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForPoke.setPlayed(this.jdField_a_of_type_Adqe.b);
    }
    if (!adwj.a("fullscreen", this.jdField_a_of_type_ComTencentMobileqqDataMessageForPoke.subId))
    {
      if (ajfh.a(this.jdField_a_of_type_Adqe.b).d == 1) {
        i = 0;
      }
      if (i != 0)
      {
        ajey.a(this.jdField_a_of_type_Adqe.b, "vas_poke", false);
        if (QLog.isColorLevel()) {
          QLog.i("GivingHeart.sprite", 2, "show sprite (normal) in bubble.");
        }
      }
    }
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    super.onAnimationStart(paramAnimator);
    adqe.f = true;
    if (adwj.a()) {
      HapticManager.a().a(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPoke.subId), 2);
    }
    adwf.a().a(7, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPoke.subId, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPoke.isSend());
    if (this.jdField_a_of_type_Adqe.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.isAnimating()) {
      this.jdField_a_of_type_Adqe.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.endAnimation();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForPoke.isSend()) {
      this.jdField_a_of_type_Adqe.jdField_a_of_type_ComTencentMobileqqDiniflyViewAnimation.setEnableXCoordinateMirrored(false);
    }
    for (;;)
    {
      adwj.a(this.jdField_a_of_type_Adqe.b, this.jdField_a_of_type_Adqe.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Adqe.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView, null, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPoke.subId, "view_aio");
      return;
      this.jdField_a_of_type_Adqe.jdField_a_of_type_ComTencentMobileqqDiniflyViewAnimation.setEnableXCoordinateMirrored(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adqp
 * JD-Core Version:    0.7.0.1
 */