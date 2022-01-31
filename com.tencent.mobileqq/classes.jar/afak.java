import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.LightingColorFilter;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.tencent.mobileqq.nearby.now.view.viewmodel.PlayOperationViewModel;

public class afak
  extends AnimatorListenerAdapter
{
  public afak(PlayOperationViewModel paramPlayOperationViewModel) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.a.c = false;
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.c = false;
    this.a.jdField_b_of_type_AndroidViewView.findViewById(2131370624).setVisibility(8);
    this.a.jdField_b_of_type_AndroidViewView.findViewById(2131367530).setTranslationY(0.0F);
    this.a.jdField_b_of_type_AndroidViewView.findViewById(2131370627).setTranslationY(0.0F);
    this.a.jdField_b_of_type_AndroidViewView.findViewById(2131370628).setVisibility(8);
  }
  
  public void onAnimationPause(Animator paramAnimator)
  {
    this.a.c = false;
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.a.c = true;
    int i = this.a.jdField_b_of_type_Int;
    this.a.jdField_b_of_type_AndroidViewView.findViewById(2131370626).setBackgroundResource(2130842752);
    this.a.jdField_b_of_type_AndroidViewView.findViewById(2131370626).getBackground().setColorFilter(new LightingColorFilter(-16777216, i));
    this.a.jdField_b_of_type_AndroidViewView.findViewById(2131370625).setBackgroundColor(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     afak
 * JD-Core Version:    0.7.0.1
 */