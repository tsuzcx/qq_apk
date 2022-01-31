import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.mobileqq.apollo.script.SpriteCommFunc;
import com.tencent.mobileqq.apollo.script.SpriteContext;
import com.tencent.mobileqq.apollo.script.SpriteUtil;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.FitSystemWindowsRelativeLayout;

public class ambp
  extends AnimatorListenerAdapter
{
  public ambp(FitSystemWindowsRelativeLayout paramFitSystemWindowsRelativeLayout) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    int i = 1;
    super.onAnimationEnd(paramAnimator);
    if (this.a.jdField_a_of_type_Boolean)
    {
      if (SpriteUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).c == 1) {
        i = 0;
      }
      if (i != 0)
      {
        SpriteCommFunc.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "vas_poke", false);
        if (QLog.isColorLevel()) {
          QLog.i("placeholder.sprite", 2, "show sprite (normal) in fullscreen.");
        }
      }
      this.a.jdField_a_of_type_Boolean = false;
      this.a.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setImageDrawable(null);
      this.a.removeView(this.a.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ambp
 * JD-Core Version:    0.7.0.1
 */