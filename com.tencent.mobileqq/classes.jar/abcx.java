import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarRecordActivity;
import com.tencent.mobileqq.widget.CircleProgress;

public class abcx
  implements Runnable
{
  public abcx(DynamicAvatarRecordActivity paramDynamicAvatarRecordActivity) {}
  
  public void run()
  {
    this.a.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    this.a.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
    this.a.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
    this.a.jdField_b_of_type_AndroidWidgetButton.setEnabled(true);
    this.a.jdField_a_of_type_AndroidWidgetTextView.setText("0\"");
    this.a.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    if (this.a.jdField_e_of_type_Boolean) {
      this.a.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    for (;;)
    {
      this.a.d.setVisibility(4);
      this.a.c.setVisibility(0);
      this.a.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.a.jdField_a_of_type_AndroidWidgetImageView.setEnabled(true);
      this.a.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setVisibility(4);
      this.a.jdField_e_of_type_AndroidWidgetTextView.setVisibility(4);
      return;
      this.a.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     abcx
 * JD-Core Version:    0.7.0.1
 */