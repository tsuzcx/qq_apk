import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.mobileqq.emoticon.EmojiStickerManager.StickerFrameLayout;
import com.tencent.mobileqq.emoticonview.StickerGestureDetector;

public class acoz
  implements Animator.AnimatorListener
{
  public acoz(StickerGestureDetector paramStickerGestureDetector) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (this.a.a != null)
    {
      float f = this.a.a.getTranslationX();
      this.a.a.setTranslationX(0.0F);
      this.a.a((int)(this.a.a.getLeft() + f), this.a.a.getTop(), (int)(f + this.a.a.getLeft() + this.a.a.getWidth()), this.a.a.getBottom());
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acoz
 * JD-Core Version:    0.7.0.1
 */