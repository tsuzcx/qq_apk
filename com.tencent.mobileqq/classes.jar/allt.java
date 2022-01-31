import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import com.tencent.mobileqq.apollo.view.ApolloGameViewBinder.GameListAdapter.2;
import com.tencent.mobileqq.apollo.view.ApolloGameViewBinder.GameListAdapter.2.1.1;

public class allt
  implements Animation.AnimationListener
{
  public allt(ApolloGameViewBinder.GameListAdapter.2 param2) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.a.setVisibility(8);
    this.a.a.postDelayed(new ApolloGameViewBinder.GameListAdapter.2.1.1(this), 300L);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     allt
 * JD-Core Version:    0.7.0.1
 */