import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;

class alna
  extends AnimatorListenerAdapter
{
  alna(almv paramalmv, alnc paramalnc) {}
  
  public void onAnimationEnd(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BubbleInterActiveAnim", 2, "animHolder.animView.startPassiveAnimator!");
    }
    if ((this.jdField_a_of_type_Alnc != null) && (this.jdField_a_of_type_Alnc.b != null))
    {
      paramAnimator = "";
      if (this.jdField_a_of_type_Alnc.b.istroop != 0) {
        break label84;
      }
      paramAnimator = "1";
    }
    for (;;)
    {
      VasWebviewUtil.reportCommercialDrainage("", "Bubble", "Passive_dync", paramAnimator, 1, 0, 0, "", String.valueOf(ajrm.a(this.jdField_a_of_type_Alnc.b.vipBubbleID)), "");
      return;
      label84:
      if (this.jdField_a_of_type_Alnc.b.istroop == 1) {
        paramAnimator = "2";
      } else if (this.jdField_a_of_type_Alnc.b.istroop == 3000) {
        paramAnimator = "3";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     alna
 * JD-Core Version:    0.7.0.1
 */