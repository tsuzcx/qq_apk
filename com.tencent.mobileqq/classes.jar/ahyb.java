import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public final class ahyb
  implements DialogInterface.OnClickListener
{
  public ahyb(QQAppInterface paramQQAppInterface, Context paramContext, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      paramDialogInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("tim_convert_teamwork_pre_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 0).getString("tim_convert_teamwork_download_url", "https://eim.connect.qq.com/guide/install.html?install=1");
      FileManagerUtil.a(this.jdField_a_of_type_AndroidContentContext, paramDialogInterface);
      return;
    }
    catch (Exception paramDialogInterface)
    {
      QLog.i(this.jdField_a_of_type_JavaLangString, 1, paramDialogInterface.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ahyb
 * JD-Core Version:    0.7.0.1
 */