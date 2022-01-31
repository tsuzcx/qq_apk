import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;

public class aiws
  implements Animation.AnimationListener
{
  public aiws(TroopAvatarWallPreviewActivity paramTroopAvatarWallPreviewActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (this.a.jdField_b_of_type_AndroidViewView == null) {
      return;
    }
    this.a.jdField_b_of_type_AndroidViewView.post(new aiwt(this));
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (this.a.jdField_b_of_type_AndroidWidgetTextView == null) {
      return;
    }
    this.a.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiws
 * JD-Core Version:    0.7.0.1
 */