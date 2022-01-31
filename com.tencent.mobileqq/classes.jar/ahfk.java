import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.activity.contact.addcontact.face2face.LoadingAvatarProgressView;

public class ahfk
  implements ValueAnimator.AnimatorUpdateListener
{
  public ahfk(LoadingAvatarProgressView paramLoadingAvatarProgressView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    LoadingAvatarProgressView.a(this.a, ((Float)paramValueAnimator.getAnimatedValue()).floatValue() * LoadingAvatarProgressView.a(this.a));
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahfk
 * JD-Core Version:    0.7.0.1
 */