import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import com.tencent.mobileqq.profile.PersonalityLabel.CornerImageView;

class admn
  implements View.OnTouchListener
{
  admn(admm paramadmm) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    case 2: 
    default: 
      return true;
    case 0: 
      admm.a(this.a).jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      admm.a(this.a).jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setPressed(true);
      return true;
    case 3: 
      admm.a(this.a).jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      admm.a(this.a).jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setPressed(false);
      return true;
    }
    admm.a(this.a).jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    admm.a(this.a).jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setPressed(false);
    paramView.performClick();
    admm.a(this.a, paramView);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     admn
 * JD-Core Version:    0.7.0.1
 */