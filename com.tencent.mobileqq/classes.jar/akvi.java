import android.widget.ImageView;
import com.tencent.mobileqq.widget.PAVideoView;

public class akvi
  implements Runnable
{
  public akvi(PAVideoView paramPAVideoView, ImageView paramImageView) {}
  
  public void run()
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840918);
    this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
    this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(this.jdField_a_of_type_ComTencentMobileqqWidgetPAVideoView.a);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetPAVideoView.j == 4) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPAVideoView.b(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akvi
 * JD-Core Version:    0.7.0.1
 */