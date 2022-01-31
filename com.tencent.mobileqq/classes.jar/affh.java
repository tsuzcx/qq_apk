import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.LightingColorFilter;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.tencent.mobileqq.nearby.now.view.viewmodel.PlayOperationViewModel;

public class affh
  extends AnimatorListenerAdapter
{
  public affh(PlayOperationViewModel paramPlayOperationViewModel) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.a.c = false;
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.c = false;
    this.a.jdField_b_of_type_AndroidViewView.findViewById(2131370615).setVisibility(8);
    this.a.jdField_b_of_type_AndroidViewView.findViewById(2131367537).setTranslationY(0.0F);
    this.a.jdField_b_of_type_AndroidViewView.findViewById(2131370618).setTranslationY(0.0F);
    this.a.jdField_b_of_type_AndroidViewView.findViewById(2131370619).setVisibility(8);
  }
  
  public void onAnimationPause(Animator paramAnimator)
  {
    this.a.c = false;
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.a.c = true;
    int i = this.a.jdField_b_of_type_Int;
    this.a.jdField_b_of_type_AndroidViewView.findViewById(2131370617).setBackgroundResource(2130842787);
    this.a.jdField_b_of_type_AndroidViewView.findViewById(2131370617).getBackground().setColorFilter(new LightingColorFilter(-16777216, i));
    this.a.jdField_b_of_type_AndroidViewView.findViewById(2131370616).setBackgroundColor(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     affh
 * JD-Core Version:    0.7.0.1
 */