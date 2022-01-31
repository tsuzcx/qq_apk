import android.widget.TextView;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarRecordActivity;
import com.tencent.mobileqq.widget.CircleProgress;

public class abcn
  implements Runnable
{
  public abcn(DynamicAvatarRecordActivity paramDynamicAvatarRecordActivity, int paramInt) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     abcn
 * JD-Core Version:    0.7.0.1
 */