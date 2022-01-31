import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import com.tencent.mobileqq.profile.PersonalityLabel.CornerImageView;

class afym
  implements View.OnTouchListener
{
  afym(afyl paramafyl) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    case 2: 
    default: 
      return true;
    case 0: 
      afyl.a(this.a).jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      afyl.a(this.a).jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setPressed(true);
      return true;
    case 3: 
      afyl.a(this.a).jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      afyl.a(this.a).jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setPressed(false);
      return true;
    }
    afyl.a(this.a).jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    afyl.a(this.a).jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setPressed(false);
    paramView.performClick();
    afyl.a(this.a, paramView);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afym
 * JD-Core Version:    0.7.0.1
 */