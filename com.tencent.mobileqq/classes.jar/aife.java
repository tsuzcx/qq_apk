import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.QLog;

class aife
  extends Handler
{
  aife(aiez paramaiez, Looper paramLooper)
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
          paramMessage = this.a.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getString(2131719556);
        }
        for (String str = this.a.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getString(2131719555);; str = this.a.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getString(2131719558))
        {
          try
          {
            if (this.a.jdField_a_of_type_Bdjz != null)
            {
              if (this.a.jdField_a_of_type_Bdjz.isShowing()) {
                this.a.jdField_a_of_type_Bdjz.dismiss();
              }
              this.a.jdField_a_of_type_Bdjz = null;
            }
            this.a.jdField_a_of_type_Bdjz = bdgm.a(this.a.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity, 230, paramMessage, str, new aiff(this), null);
            this.a.jdField_a_of_type_Bdjz.setOnCancelListener(new aifg(this));
            this.a.jdField_a_of_type_Bdjz.setOnDismissListener(new aifh(this));
            this.a.jdField_a_of_type_Bdjz.show();
            return;
          }
          catch (Exception paramMessage) {}
          if (!QLog.isColorLevel()) {
            break;
          }
          paramMessage.printStackTrace();
          return;
          paramMessage = this.a.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getString(2131719559);
        }
      }
    } while (this.a.jdField_a_of_type_Bdjz == null);
    this.a.jdField_a_of_type_Bdjz.dismiss();
    return;
    paramMessage = (BusinessInfoCheckUpdate.RedTypeInfo)paramMessage.obj;
    this.a.a(34, paramMessage);
    return;
    paramMessage = (BusinessInfoCheckUpdate.RedTypeInfo)paramMessage.obj;
    this.a.a(33, paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aife
 * JD-Core Version:    0.7.0.1
 */