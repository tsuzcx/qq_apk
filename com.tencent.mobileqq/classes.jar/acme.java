import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.ChatHistory;

public class acme
  extends Handler
{
  public acme(ChatHistory paramChatHistory) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1)
    {
      if ((this.a.a != null) && (this.a.a.isShowing()) && (!this.a.isFinishing())) {
        this.a.a.dismiss();
      }
      this.a.a = new bety(this.a, this.a.getTitleBarHeight());
      this.a.a.setCancelable(false);
      this.a.a.c(2131691584);
      if (!this.a.isFinishing()) {
        this.a.a.show();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acme
 * JD-Core Version:    0.7.0.1
 */