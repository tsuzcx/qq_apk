import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.history.ChatHistoryC2CDateFragment;
import java.lang.ref.WeakReference;

public class aiwd
  implements DialogInterface.OnCancelListener
{
  private final WeakReference<ChatHistoryC2CDateFragment> a;
  
  aiwd(ChatHistoryC2CDateFragment paramChatHistoryC2CDateFragment)
  {
    this.a = new WeakReference(paramChatHistoryC2CDateFragment);
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    ChatHistoryC2CDateFragment localChatHistoryC2CDateFragment = (ChatHistoryC2CDateFragment)this.a.get();
    if ((localChatHistoryC2CDateFragment != null) && (localChatHistoryC2CDateFragment.getActivity() != null) && (!localChatHistoryC2CDateFragment.getActivity().isFinishing())) {
      paramDialogInterface.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiwd
 * JD-Core Version:    0.7.0.1
 */