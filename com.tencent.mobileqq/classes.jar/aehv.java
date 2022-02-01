import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.Conversation;

public class aehv
  implements DialogInterface.OnDismissListener
{
  public aehv(Conversation paramConversation) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (paramDialogInterface == Conversation.a(this.a)) {
      Conversation.a(this.a, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aehv
 * JD-Core Version:    0.7.0.1
 */