import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Handler;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.SearchDialogDismissRunnable;

public class akej
  implements DialogInterface.OnDismissListener
{
  public akej(ChatHistoryTroopMemberFragment paramChatHistoryTroopMemberFragment) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.b.postDelayed(new ChatHistoryTroopMemberFragment.SearchDialogDismissRunnable(this.a), 150L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akej
 * JD-Core Version:    0.7.0.1
 */