package mqq.app;

import android.content.Intent;
import com.tencent.qphone.base.util.QLog;

class MainService$4$1
  implements Runnable
{
  MainService$4$1(MainService.4 param4, String paramString) {}
  
  public void run()
  {
    try
    {
      Intent localIntent = new Intent("mqq.intent.action.OVERLOAD_PUSH");
      localIntent.putExtra("msg", this.val$msg);
      localIntent.addFlags(268435456);
      MainService.access$000(this.this$1.this$0).startActivity(localIntent);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("overload push notify fail, except: ");
      localStringBuilder.append(localException.getMessage());
      QLog.d("mqq", 1, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mqq.app.MainService.4.1
 * JD-Core Version:    0.7.0.1
 */