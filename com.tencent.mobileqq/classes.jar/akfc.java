import android.app.Activity;
import android.content.Intent;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.activity.miniaio.MiniMsgTabFragment;

class akfc
  implements Animation.AnimationListener
{
  akfc(akfb paramakfb, Activity paramActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if ((this.jdField_a_of_type_Akfb.a.a.getCount() == 1) && (!MiniMsgTabFragment.b(this.jdField_a_of_type_Akfb.a)))
    {
      paramAnimation = MiniMsgTabFragment.a(this.jdField_a_of_type_Akfb.a);
      paramAnimation.putExtra("miniAppID", MiniMsgTabFragment.a(this.jdField_a_of_type_Akfb.a));
      paramAnimation.putExtra("clickID", -1);
      this.jdField_a_of_type_AndroidAppActivity.setResult(-1, paramAnimation);
      this.jdField_a_of_type_AndroidAppActivity.finish();
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akfc
 * JD-Core Version:    0.7.0.1
 */