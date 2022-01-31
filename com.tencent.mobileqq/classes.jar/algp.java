import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.apollo.view.ApolloFavViewBinder.1;
import com.tencent.mobileqq.apollo.view.ApolloFavViewBinder.1.1.1;

public class algp
  implements Animation.AnimationListener
{
  public algp(ApolloFavViewBinder.1.1.1 param1) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.a.a.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.a.a.a.b.removeView(this.a.a.a.jdField_a_of_type_AndroidWidgetRelativeLayout);
    this.a.a.a.jdField_a_of_type_Alhm.a = null;
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     algp
 * JD-Core Version:    0.7.0.1
 */