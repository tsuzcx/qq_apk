import android.widget.TextView;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarRecordActivity;
import com.tencent.mobileqq.widget.CircleProgress;

public class abjo
  implements Runnable
{
  public abjo(DynamicAvatarRecordActivity paramDynamicAvatarRecordActivity, int paramInt) {}
  
  public void run()
  {
    int i = this.jdField_a_of_type_Int / 1000;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(i);
    localStringBuilder.append("\"");
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarRecordActivity.jdField_a_of_type_AndroidWidgetTextView.setText(localStringBuilder);
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarRecordActivity.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setProgress(this.jdField_a_of_type_Int / 80);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abjo
 * JD-Core Version:    0.7.0.1
 */