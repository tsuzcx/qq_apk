import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;

class ambn
  extends AnimatorListenerAdapter
{
  ambn(ambi paramambi, ambp paramambp) {}
  
  public void onAnimationEnd(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BubbleInterActiveAnim", 2, "animHolder.animView.startPassiveAnimator!");
    }
    if ((this.jdField_a_of_type_Ambp != null) && (this.jdField_a_of_type_Ambp.b != null))
    {
      paramAnimator = "";
      if (this.jdField_a_of_type_Ambp.b.istroop != 0) {
        break label84;
      }
      paramAnimator = "1";
    }
    for (;;)
    {
      VasWebviewUtil.reportCommercialDrainage("", "Bubble", "Passive_dync", paramAnimator, 1, 0, 0, "", String.valueOf(akfv.a(this.jdField_a_of_type_Ambp.b.vipBubbleID)), "");
      return;
      label84:
      if (this.jdField_a_of_type_Ambp.b.istroop == 1) {
        paramAnimator = "2";
      } else if (this.jdField_a_of_type_Ambp.b.istroop == 3000) {
        paramAnimator = "3";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ambn
 * JD-Core Version:    0.7.0.1
 */