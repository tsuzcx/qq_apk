import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import com.tencent.mobileqq.profile.PersonalityLabel.CornerImageView;

class adxm
  implements View.OnTouchListener
{
  adxm(adxl paramadxl) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    case 2: 
    default: 
      return true;
    case 0: 
      adxl.a(this.a).jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      adxl.a(this.a).jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setPressed(true);
      return true;
    case 3: 
      adxl.a(this.a).jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      adxl.a(this.a).jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setPressed(false);
      return true;
    }
    adxl.a(this.a).jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    adxl.a(this.a).jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelCornerImageView.setPressed(false);
    paramView.performClick();
    adxl.a(this.a, paramView);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adxm
 * JD-Core Version:    0.7.0.1
 */