import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import com.tencent.mobileqq.activity.specialcare.QQSpecialCareSettingActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class akeo
  extends Handler
{
  public akeo(QQSpecialCareSettingActivity paramQQSpecialCareSettingActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 8193: 
    case 8194: 
      do
      {
        do
        {
          do
          {
            return;
            if (QQSpecialCareSettingActivity.a(this.a) == null)
            {
              QQSpecialCareSettingActivity.a(this.a, new bety(this.a, this.a.getTitleBarHeight()));
              if ((paramMessage.obj != null) && ((paramMessage.obj instanceof String))) {
                QQSpecialCareSettingActivity.a(this.a).a((String)paramMessage.obj);
              }
            }
          } while ((this.a.isFinishing()) || (QQSpecialCareSettingActivity.a(this.a).isShowing()));
          try
          {
            QQSpecialCareSettingActivity.a(this.a).show();
            return;
          }
          catch (Exception paramMessage) {}
        } while (!QLog.isColorLevel());
        QLog.e("QQSpecialCareSettingActivity", 2, "QQProgressDialog show exception.", paramMessage);
        return;
      } while ((QQSpecialCareSettingActivity.a(this.a) == null) || (!QQSpecialCareSettingActivity.a(this.a).isShowing()));
      QQSpecialCareSettingActivity.a(this.a).dismiss();
      QQSpecialCareSettingActivity.a(this.a, null);
      return;
    }
    if (QQSpecialCareSettingActivity.a(this.a) != null) {
      QQSpecialCareSettingActivity.a(this.a).cancel();
    }
    QQSpecialCareSettingActivity.a(this.a, QQToast.a(this.a, paramMessage.arg1, paramMessage.arg2, 0).b(this.a.getTitleBarHeight()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akeo
 * JD-Core Version:    0.7.0.1
 */