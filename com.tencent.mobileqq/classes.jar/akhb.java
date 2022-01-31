import android.widget.ImageView;
import com.tencent.mobileqq.widget.PAVideoView;

public class akhb
  implements Runnable
{
  public akhb(PAVideoView paramPAVideoView, ImageView paramImageView) {}
  
  public void run()
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840881);
    this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
    this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(this.jdField_a_of_type_ComTencentMobileqqWidgetPAVideoView.a);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetPAVideoView.j == 4) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPAVideoView.b(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     akhb
 * JD-Core Version:    0.7.0.1
 */