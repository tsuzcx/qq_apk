import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QQLSActivity;
import com.tencent.mobileqq.activity.QQLSUnlockActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;

public class aewu
  extends Handler
{
  public aewu(QQLSActivity paramQQLSActivity, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 5: 
    case 6: 
    case 4: 
    case 3: 
    case 1: 
    case 2: 
    case 16: 
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    case 11: 
    case 12: 
      do
      {
        boolean bool;
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  return;
                } while (QQLSActivity.b(this.a));
                if (hasMessages(5)) {
                  removeMessages(5);
                }
                QQLSActivity.b(this.a);
                if (QQLSActivity.a(this.a) != null) {
                  ((InputMethodManager)this.a.getSystemService("input_method")).hideSoftInputFromWindow(QQLSActivity.a(this.a).getWindowToken(), 0);
                }
                QQLSActivity.b(this.a).setVisibility(0);
                paramMessage = obtainMessage(3);
                if (hasMessages(3)) {
                  removeMessages(3);
                }
                sendMessageDelayed(paramMessage, 1200L);
                return;
              } while (QQLSActivity.b(this.a));
              if (hasMessages(6)) {
                removeMessages(6);
              }
              QQLSActivity.b(this.a);
              if (QQLSActivity.a(this.a) != null) {
                ((InputMethodManager)this.a.getSystemService("input_method")).hideSoftInputFromWindow(QQLSActivity.a(this.a).getWindowToken(), 0);
              }
              QQLSActivity.a(this.a).setVisibility(0);
              paramMessage = obtainMessage(4);
              if (hasMessages(4)) {
                removeMessages(4);
              }
              sendMessageDelayed(paramMessage, 1200L);
              return;
              QQLSActivity.a(this.a).setVisibility(4);
              return;
              QQLSActivity.b(this.a).setVisibility(4);
              return;
              this.a.c();
              if (QLog.isColorLevel()) {
                QLog.d("QQLSActivity", 2, "message send finish");
              }
              QQLSActivity.a(this.a);
              return;
              if (QLog.isColorLevel()) {
                QLog.d("QQLSActivity", 2, "message finish activity finish");
              }
              this.a.finish();
              return;
              if (QLog.isColorLevel()) {
                QLog.d("QQLSActivity", 2, "message finish activity finish, enter aio");
              }
              this.a.finish();
              return;
            } while ((QQLSActivity.c(this.a)) || (!QQLSActivity.d(this.a)));
            if (QLog.isColorLevel()) {
              QLog.d("QQLSActivity", 2, "sensor don't callback 1000ms later");
            }
            QQLSActivity.c(this.a);
            return;
            this.a.a();
            return;
          } while (QQLSActivity.a(this.a));
          bcst.b(QQLSActivity.a(this.a), "CliOper", "", "", "0X800444B", "0X800444B", 0, 0, "", "", "", "");
          paramMessage = new Intent(this.a, QQLSUnlockActivity.class);
          this.a.startActivity(paramMessage);
          return;
          paramMessage = new Intent(this.a, QQLSActivity.class);
          paramMessage.addFlags(131072);
          this.a.startActivity(paramMessage);
          return;
          bool = QQLSActivity.e(this.a);
          if (QLog.isColorLevel()) {
            QLog.d("QQLSActivity", 2, "LS MSG_CHECKISLOCK" + bool);
          }
        } while (bool);
        this.a.finish();
        return;
        if (QLog.isColorLevel()) {
          QLog.d("QQLSActivity", 2, "check sensor HasCallBack ====" + QQLSActivity.c(this.a));
        }
        if (QQLSActivity.c(this.a))
        {
          QQLSActivity.d(this.a);
          return;
        }
      } while (!QQLSActivity.d(this.a));
      QQLSActivity.c(this.a);
      return;
    case 13: 
      QQLSActivity.e(this.a);
      return;
    case 14: 
      QQLSActivity.a(this.a, false);
      return;
    case 15: 
      QQLSActivity.f(this.a);
      return;
    }
    this.a.a.a(QQLSActivity.a(this.a), (String)paramMessage.obj, 1008, false, -1, false);
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aewu
 * JD-Core Version:    0.7.0.1
 */