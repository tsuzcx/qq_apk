import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.ChatSettingForTroop;

public class adsx
  implements DialogInterface.OnDismissListener
{
  public adsx(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    ChatSettingForTroop.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adsx
 * JD-Core Version:    0.7.0.1
 */