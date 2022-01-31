import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import com.tencent.mobileqq.apollo.view.ApolloFavViewBinder.1;
import com.tencent.mobileqq.apollo.view.ApolloFavViewBinder.1.1.1;

public class alld
  implements Animation.AnimationListener
{
  public alld(ApolloFavViewBinder.1 param1) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.a.setVisibility(8);
    this.a.a.postDelayed(new ApolloFavViewBinder.1.1.1(this), 300L);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alld
 * JD-Core Version:    0.7.0.1
 */