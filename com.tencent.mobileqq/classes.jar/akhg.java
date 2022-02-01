import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.QLog;

class akhg
  extends Handler
{
  akhg(akha paramakha, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity == null) || (this.a.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app == null) || (!this.a.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.isLogin())) {}
    do
    {
      do
      {
        return;
        switch (paramMessage.what)
        {
        default: 
          return;
        case 0: 
          paramMessage = (BusinessInfoCheckUpdate.RedTypeInfo)paramMessage.obj;
          this.a.a(35, paramMessage);
          return;
        case 28929: 
          paramMessage = paramMessage.getData();
        }
      } while (paramMessage == null);
      int i = paramMessage.getInt("result");
      if ((i == -1) || (i == -2))
      {
        if (i == -1) {
          paramMessage = this.a.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getString(2131717726);
        }
        for (String str = this.a.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getString(2131717725);; str = this.a.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getString(2131717727))
        {
          try
          {
            if (this.a.jdField_a_of_type_Bhpc != null)
            {
              if (this.a.jdField_a_of_type_Bhpc.isShowing()) {
                this.a.jdField_a_of_type_Bhpc.dismiss();
              }
              this.a.jdField_a_of_type_Bhpc = null;
            }
            this.a.jdField_a_of_type_Bhpc = bhlq.a(this.a.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity, 230, paramMessage, str, new akhh(this), null);
            this.a.jdField_a_of_type_Bhpc.setOnCancelListener(new akhi(this));
            this.a.jdField_a_of_type_Bhpc.setOnDismissListener(new akhj(this));
            this.a.jdField_a_of_type_Bhpc.show();
            return;
          }
          catch (Exception paramMessage) {}
          if (!QLog.isColorLevel()) {
            break;
          }
          paramMessage.printStackTrace();
          return;
          paramMessage = this.a.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getString(2131717728);
        }
      }
    } while (this.a.jdField_a_of_type_Bhpc == null);
    this.a.jdField_a_of_type_Bhpc.dismiss();
    return;
    paramMessage = (BusinessInfoCheckUpdate.RedTypeInfo)paramMessage.obj;
    this.a.a(34, paramMessage);
    return;
    paramMessage = (BusinessInfoCheckUpdate.RedTypeInfo)paramMessage.obj;
    this.a.a(33, paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akhg
 * JD-Core Version:    0.7.0.1
 */