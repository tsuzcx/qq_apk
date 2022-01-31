import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.emoticonview.StickerGestureDetector;

public class acpd
  implements Animator.AnimatorListener
{
  private acpd(StickerGestureDetector paramStickerGestureDetector) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.post(new acpe(this));
      this.a.c();
      this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.aN();
      this.a.jdField_b_of_type_Double = 1.0D;
      this.a.jdField_a_of_type_Double = 0.0D;
      if (this.a.jdField_a_of_type_AndroidViewView != null)
      {
        this.a.a(this.a.jdField_a_of_type_AndroidViewView, false);
        this.a.c = null;
      }
      if ((this.a.jdField_b_of_type_AndroidViewView != null) && ((this.a.jdField_b_of_type_AndroidViewView instanceof BaseChatItemLayout)))
      {
        ((BaseChatItemLayout)this.a.jdField_b_of_type_AndroidViewView).setStickerPressStatus(false);
        this.a.jdField_b_of_type_AndroidViewView = null;
      }
      com.tencent.mobileqq.emoticon.EmojiStickerManager.b = false;
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acpd
 * JD-Core Version:    0.7.0.1
 */