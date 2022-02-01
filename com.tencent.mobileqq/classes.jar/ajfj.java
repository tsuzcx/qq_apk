import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Set;

class ajfj
  extends RecyclerView.ViewHolder
  implements Animator.AnimatorListener, View.OnClickListener
{
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  DiniFlyAnimationView jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView;
  String jdField_a_of_type_JavaLangString;
  
  public ajfj(ajfh paramajfh, View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView = ((DiniFlyAnimationView)paramView.findViewById(2131376963));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368212));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371647));
  }
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(4);
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.cancelAnimation();
    this.jdField_a_of_type_AndroidWidgetImageView.setAlpha(1.0F);
    ajfh.a(this.jdField_a_of_type_Ajfh).add(this.jdField_a_of_type_JavaLangString);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ajfh.a(this.jdField_a_of_type_Ajfh, this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajfj
 * JD-Core Version:    0.7.0.1
 */