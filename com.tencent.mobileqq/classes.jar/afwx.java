import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.history.ChatHistoryC2CAllFragment;
import java.lang.ref.WeakReference;

public class afwx
  implements DialogInterface.OnCancelListener
{
  private final WeakReference<ChatHistoryC2CAllFragment> a;
  
  public afwx(ChatHistoryC2CAllFragment paramChatHistoryC2CAllFragment)
  {
    this.a = new WeakReference(paramChatHistoryC2CAllFragment);
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    ChatHistoryC2CAllFragment localChatHistoryC2CAllFragment = (ChatHistoryC2CAllFragment)this.a.get();
    if ((localChatHistoryC2CAllFragment != null) && (localChatHistoryC2CAllFragment.getActivity() != null) && (!localChatHistoryC2CAllFragment.getActivity().isFinishing())) {
      paramDialogInterface.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afwx
 * JD-Core Version:    0.7.0.1
 */