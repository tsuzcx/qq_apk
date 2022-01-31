import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.contact.newfriend.SystemMsgListView;

public class aezu
  extends Handler
{
  public aezu(SystemMsgListView paramSystemMsgListView) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 1012: 
      do
      {
        return;
      } while (SystemMsgListView.a(this.a) == null);
      this.a.i();
      SystemMsgListView.a(this.a).notifyDataSetChanged();
      return;
    }
    paramMessage = SystemMsgListView.a(this.a).getResources().getString(2131654092);
    bbmy.a(SystemMsgListView.a(this.a), 1, paramMessage, 0).b(this.a.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aezu
 * JD-Core Version:    0.7.0.1
 */