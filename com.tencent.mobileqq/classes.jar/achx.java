import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatHistory;

public class achx
  implements View.OnClickListener
{
  public achx(ChatHistory paramChatHistory) {}
  
  public void onClick(View paramView)
  {
    this.a.startActivity(new Intent("android.settings.WIRELESS_SETTINGS"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     achx
 * JD-Core Version:    0.7.0.1
 */