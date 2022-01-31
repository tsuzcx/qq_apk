import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMediaFragment;

public class ahwx
  implements DialogInterface.OnClickListener
{
  public ahwx(ChatHistoryTroopMediaFragment paramChatHistoryTroopMediaFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.a.getActivity().setResult(8001);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahwx
 * JD-Core Version:    0.7.0.1
 */