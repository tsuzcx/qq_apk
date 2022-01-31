import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.apollo.view.ApolloGameViewBinder.GameListAdapter.2;
import com.tencent.mobileqq.apollo.view.ApolloGameViewBinder.GameListAdapter.2.1.1;

public class ajpu
  implements Animation.AnimationListener
{
  public ajpu(ApolloGameViewBinder.GameListAdapter.2.1.1 param1) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.a.a.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.a.a.a.jdField_a_of_type_AndroidViewViewGroup.removeView(this.a.a.a.jdField_a_of_type_AndroidWidgetRelativeLayout);
    this.a.a.a.jdField_a_of_type_Ajpv.a = null;
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ajpu
 * JD-Core Version:    0.7.0.1
 */