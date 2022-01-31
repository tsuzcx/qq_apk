import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.QLog;

class agck
  extends Handler
{
  agck(agcf paramagcf, Looper paramLooper)
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
          paramMessage = this.a.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getString(2131719064);
        }
        for (String str = this.a.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getString(2131719063);; str = this.a.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getString(2131719066))
        {
          try
          {
            if (this.a.jdField_a_of_type_Bbgu != null)
            {
              if (this.a.jdField_a_of_type_Bbgu.isShowing()) {
                this.a.jdField_a_of_type_Bbgu.dismiss();
              }
              this.a.jdField_a_of_type_Bbgu = null;
            }
            this.a.jdField_a_of_type_Bbgu = bbdj.a(this.a.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity, 230, paramMessage, str, new agcl(this), null);
            this.a.jdField_a_of_type_Bbgu.setOnCancelListener(new agcm(this));
            this.a.jdField_a_of_type_Bbgu.setOnDismissListener(new agcn(this));
            this.a.jdField_a_of_type_Bbgu.show();
            return;
          }
          catch (Exception paramMessage) {}
          if (!QLog.isColorLevel()) {
            break;
          }
          paramMessage.printStackTrace();
          return;
          paramMessage = this.a.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.getString(2131719067);
        }
      }
    } while (this.a.jdField_a_of_type_Bbgu == null);
    this.a.jdField_a_of_type_Bbgu.dismiss();
    return;
    paramMessage = (BusinessInfoCheckUpdate.RedTypeInfo)paramMessage.obj;
    this.a.a(34, paramMessage);
    return;
    paramMessage = (BusinessInfoCheckUpdate.RedTypeInfo)paramMessage.obj;
    this.a.a(33, paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agck
 * JD-Core Version:    0.7.0.1
 */