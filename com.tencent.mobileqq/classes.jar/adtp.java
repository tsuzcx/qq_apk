import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.forward.ForwardSdkBaseOption;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.open.base.ShareProcessorUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.util.HandlerPlus;

public class adtp
  implements Runnable
{
  public adtp(ForwardSdkBaseOption paramForwardSdkBaseOption, String paramString) {}
  
  public void run()
  {
    long l = System.currentTimeMillis();
    Object localObject = ShareProcessorUtil.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqForwardForwardSdkBaseOption.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
    int i = ((Integer)localObject[0]).intValue();
    boolean bool = ((Boolean)localObject[1]).booleanValue();
    String str = (String)localObject[2];
    l = System.currentTimeMillis() - l;
    if (QLog.isColorLevel()) {
      QLog.d("ForwardSdkBaseOption", 2, "changeRemoteUrl|ret=" + i + ",needRich=" + bool + ",url=" + str + ",cost=" + l);
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("report_type", "102");
    localBundle.putString("act_type", "19");
    localBundle.putString("intext_1", "" + i);
    if (bool)
    {
      localObject = "1";
      localBundle.putString("intext_2", (String)localObject);
      localBundle.putString("intext_3", "0");
      localBundle.putString("intext_5", "" + l);
      localBundle.putString("stringext_2", this.jdField_a_of_type_JavaLangString);
      ReportCenter.a().a(localBundle, "" + this.jdField_a_of_type_ComTencentMobileqqForwardForwardSdkBaseOption.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqForwardForwardSdkBaseOption.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), false);
      if ((!bool) || (this.jdField_a_of_type_ComTencentMobileqqForwardForwardSdkBaseOption.l)) {
        break label359;
      }
      QLog.d("ForwardSdkBaseOption", 1, "changeRemoteUrl|need rich since invalid url=" + this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqForwardForwardSdkBaseOption.jdField_a_of_type_AndroidOsBundle.putString("image_url_remote", "");
      ForwardSdkBaseOption.a(this.jdField_a_of_type_ComTencentMobileqqForwardForwardSdkBaseOption).sendEmptyMessage(0);
    }
    for (;;)
    {
      return;
      localObject = "0";
      break;
      label359:
      if (i != -1) {}
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqForwardForwardSdkBaseOption.jdField_a_of_type_AndroidOsBundle.putByte("struct_share_key_image_url_status", (byte)3);
        if ((i != 0) || (TextUtils.isEmpty(str))) {
          continue;
        }
        ShareProcessorUtil.a(false, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, str);
        this.jdField_a_of_type_ComTencentMobileqqForwardForwardSdkBaseOption.jdField_a_of_type_AndroidOsBundle.putString("image_url_remote", str);
        if (this.jdField_a_of_type_ComTencentMobileqqForwardForwardSdkBaseOption.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg == null) {
          continue;
        }
        this.jdField_a_of_type_ComTencentMobileqqForwardForwardSdkBaseOption.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.updateCover(str);
        ForwardSdkBaseOption.a(this.jdField_a_of_type_ComTencentMobileqqForwardForwardSdkBaseOption).sendEmptyMessage(2);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("ForwardOption.ForwardSdkBaseOption", 2, localException, new Object[0]);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     adtp
 * JD-Core Version:    0.7.0.1
 */