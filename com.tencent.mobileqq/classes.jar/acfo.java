import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.activity.ThemeNoviceGuideActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class acfo
  extends Handler
{
  public acfo(ThemeNoviceGuideActivity paramThemeNoviceGuideActivity, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    paramMessage = this.a.findViewById(2131377230);
    if (paramMessage != null) {}
    try
    {
      paramMessage.setBackgroundResource(2130849455);
      axqw.b(this.a.app, "CliOper", "", this.a.app.getCurrentAccountUin(), "theme_mall", "theme_popup", 0, 0, "", "", "", "");
      return;
    }
    catch (OutOfMemoryError paramMessage)
    {
      for (;;)
      {
        QLog.e("ThemeNoviceGuideActivity", 1, "handleMessage oom e = " + paramMessage);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     acfo
 * JD-Core Version:    0.7.0.1
 */