import android.view.View;
import android.view.animation.AlphaAnimation;
import com.tencent.mobileqq.ark.ArkAiBubbleView;
import com.tencent.mobileqq.ark.ArkAiScrollBar;
import com.tencent.qphone.base.util.QLog;

public class aarw
  implements Runnable
{
  public aarw(ArkAiBubbleView paramArkAiBubbleView) {}
  
  public void run()
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqArkArkAiScrollBar == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ark.ai", 2, String.format("ArkAiBubbleView.mScrollBar == null: %h", new Object[] { this.a }));
      }
      this.a.c();
      return;
    }
    this.a.b = true;
    if (this.a.jdField_a_of_type_ComTencentMobileqqArkArkAiScrollBar.b())
    {
      this.a.c();
      return;
    }
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(500L);
    localAlphaAnimation.setAnimationListener(this.a);
    this.a.jdField_a_of_type_AndroidViewView.startAnimation(localAlphaAnimation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aarw
 * JD-Core Version:    0.7.0.1
 */