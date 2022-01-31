import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.apollo.lightGame.CmGameLoadingView;
import com.tencent.mobileqq.apollo.store.ApolloGameActivity;

public class ajhg
  implements Animation.AnimationListener
{
  public ajhg(ApolloGameActivity paramApolloGameActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    ApolloGameActivity.a(this.a).d();
    ApolloGameActivity.a(this.a).setVisibility(4);
    ApolloGameActivity.d(this.a);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajhg
 * JD-Core Version:    0.7.0.1
 */