import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;

class ambm
  extends AnimatorListenerAdapter
{
  ambm(ambj paramambj, ObjectAnimator paramObjectAnimator, ambq paramambq) {}
  
  public void onAnimationEnd(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BubbleInterActiveAnim", 2, "animHolder.animView.startAnimation!");
    }
    if (this.jdField_a_of_type_AndroidAnimationObjectAnimator != null) {
      this.jdField_a_of_type_AndroidAnimationObjectAnimator.start();
    }
    if ((this.jdField_a_of_type_Ambq != null) && (this.jdField_a_of_type_Ambq.a != null))
    {
      paramAnimator = "";
      if (this.jdField_a_of_type_Ambq.a.istroop != 0) {
        break label98;
      }
      paramAnimator = "1";
    }
    for (;;)
    {
      VasWebviewUtil.reportCommercialDrainage("", "Bubble", "Active_dync", paramAnimator, 1, 0, 0, "", String.valueOf(akfw.a(this.jdField_a_of_type_Ambq.a.vipBubbleID)), "");
      return;
      label98:
      if (this.jdField_a_of_type_Ambq.a.istroop == 1) {
        paramAnimator = "2";
      } else if (this.jdField_a_of_type_Ambq.a.istroop == 3000) {
        paramAnimator = "3";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ambm
 * JD-Core Version:    0.7.0.1
 */