import android.view.animation.Animation;
import android.widget.TextView;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.widget.immersive.ImmersiveTitleBar2;

public class abez
  extends bfmx
{
  public abez(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (this.a.d == null) {
      return;
    }
    if (paramAnimation == FriendProfileCardActivity.b(this.a)) {
      this.a.i(1);
    }
    this.a.d.clearAnimation();
    this.a.a.clearAnimation();
  }
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (this.a.d == null) {}
    while (paramAnimation != FriendProfileCardActivity.a(this.a)) {
      return;
    }
    this.a.i(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abez
 * JD-Core Version:    0.7.0.1
 */