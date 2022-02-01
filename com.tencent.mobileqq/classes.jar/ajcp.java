import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class ajcp
  extends BroadcastReceiver
{
  public ajcp(Conversation paramConversation) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (("android.intent.action.TIME_SET".equals(paramContext)) || ("android.intent.action.TIMEZONE_CHANGED".equals(paramContext)) || ("android.intent.action.DATE_CHANGED".equals(paramContext))) {
      ThreadManager.getSubThreadHandler().post(Conversation.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajcp
 * JD-Core Version:    0.7.0.1
 */