package mqq.app;

import android.widget.Toast;

class MainService$MyErrorHandler$3$1
  implements Runnable
{
  MainService$MyErrorHandler$3$1(MainService.MyErrorHandler.3 param3) {}
  
  public void run()
  {
    MobileQQ localMobileQQ = MainService.access$000(this.this$2.this$1.this$0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[mqq]");
    localStringBuilder.append(this.this$2.val$reason);
    localStringBuilder.append("\n");
    localStringBuilder.append(this.this$2.val$title);
    localStringBuilder.append("\n");
    localStringBuilder.append(this.this$2.val$msg);
    Toast.makeText(localMobileQQ, localStringBuilder.toString(), 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     mqq.app.MainService.MyErrorHandler.3.1
 * JD-Core Version:    0.7.0.1
 */