import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.activity.ChatHistory.17.1;
import com.tencent.mobileqq.app.ThreadManager;

public class adoa
  implements DialogInterface.OnClickListener
{
  public adoa(ChatHistory paramChatHistory) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ThreadManager.post(new ChatHistory.17.1(this), 8, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adoa
 * JD-Core Version:    0.7.0.1
 */