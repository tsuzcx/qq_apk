import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.qphone.base.util.QLog;

class aaob
  implements DialogInterface.OnClickListener
{
  aaob(aaoa paramaaoa) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      try
      {
        paramDialogInterface.dismiss();
        this.a.a.jdField_a_of_type_AndroidAppDialog = null;
        return;
      }
      catch (Exception paramDialogInterface) {}
      if (SettingCloneUtil.readValue(this.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), this.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), null, "pcactive_config", false)) {
        this.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startPCActivePolling(this.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "logout");
      }
      this.a.a.a(this.a.a.a(), this.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      continue;
      if (aaoa.a(this.a).startsWith("http")) {}
      for (;;)
      {
        try
        {
          Intent localIntent = new Intent(this.a.a.a(), QQBrowserActivity.class);
          localIntent.putExtra("url", aaoa.a(this.a));
          this.a.a.a().startActivity(localIntent);
          awqx.b(this.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8008273", "0X8008273", 0, 0, "", "", "", "");
        }
        catch (Exception localException)
        {
          if (!QLog.isDevelopLevel()) {
            continue;
          }
          localException.printStackTrace();
          continue;
        }
        if (aaoa.a(this.a).startsWith("mqqapi:")) {
          bade.a(this.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.a.a(), aaoa.a(this.a)).c();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aaob
 * JD-Core Version:    0.7.0.1
 */