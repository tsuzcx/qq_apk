import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatHistory;

public class acmq
  implements View.OnClickListener
{
  public acmq(ChatHistory paramChatHistory) {}
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if (l - this.a.b > 1000L)
    {
      this.a.b = l;
      this.a.b();
      azqs.b(this.a.app, "CliOper", "", "", "0X800568D", "0X800568D", this.a.k, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acmq
 * JD-Core Version:    0.7.0.1
 */