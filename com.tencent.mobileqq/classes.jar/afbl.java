import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.activity.NotifyPushSettingActivity;
import com.tencent.mobileqq.widget.FormSwitchItem;

public class afbl
  implements Handler.Callback
{
  public afbl(NotifyPushSettingActivity paramNotifyPushSettingActivity) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    for (;;)
    {
      try
      {
        int i = paramMessage.what;
        switch (i)
        {
        default: 
          bool = false;
          return bool;
        }
      }
      finally {}
      boolean bool = ((Boolean)paramMessage.obj).booleanValue();
      NotifyPushSettingActivity.g(this.a).setChecked(bool);
      break label163;
      paramMessage = (String)paramMessage.obj;
      NotifyPushSettingActivity.a(this.a, paramMessage);
      break label163;
      paramMessage = (String)paramMessage.obj;
      NotifyPushSettingActivity.b(this.a, paramMessage);
      break label163;
      bool = ((Boolean)paramMessage.obj).booleanValue();
      NotifyPushSettingActivity.h(this.a).setChecked(bool);
      break label163;
      NotifyPushSettingActivity.i(this.a).setChecked(((Boolean)paramMessage.obj).booleanValue());
      label163:
      bool = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afbl
 * JD-Core Version:    0.7.0.1
 */