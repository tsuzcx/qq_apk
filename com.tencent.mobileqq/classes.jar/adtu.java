import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.forward.ForwardSdkBaseOption;
import com.tencent.mobileqq.structmsg.CGILoader;

public class adtu
  implements Runnable
{
  public adtu(ForwardSdkBaseOption paramForwardSdkBaseOption, String paramString) {}
  
  public void run()
  {
    String str = CGILoader.a(this.jdField_a_of_type_ComTencentMobileqqForwardForwardSdkBaseOption.jdField_a_of_type_AndroidAppActivity.getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqForwardForwardSdkBaseOption.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), this.jdField_a_of_type_JavaLangString);
    if (!TextUtils.isEmpty(str))
    {
      this.jdField_a_of_type_ComTencentMobileqqForwardForwardSdkBaseOption.jdField_a_of_type_AndroidOsBundle.putString("video_url", str);
      this.jdField_a_of_type_ComTencentMobileqqForwardForwardSdkBaseOption.jdField_a_of_type_AndroidOsBundle.putBoolean("video_url_load", true);
    }
    ForwardSdkBaseOption.c(this.jdField_a_of_type_ComTencentMobileqqForwardForwardSdkBaseOption);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     adtu
 * JD-Core Version:    0.7.0.1
 */