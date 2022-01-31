import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.Conversation;

public class aani
  extends BroadcastReceiver
{
  public aani(Conversation paramConversation) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("login".equals(paramIntent.getStringExtra("status")))
    {
      this.a.a.a(26, 2);
      this.a.a.b = paramIntent.getStringExtra("loginInfo");
      this.a.a.a = paramIntent.getLongExtra("subappid", 1L);
      this.a.a.a(-1, null);
      return;
    }
    this.a.a.k();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aani
 * JD-Core Version:    0.7.0.1
 */