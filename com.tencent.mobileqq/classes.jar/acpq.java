import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.ChatSettingForTroop;

public class acpq
  implements DialogInterface.OnClickListener
{
  public acpq(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ChatSettingForTroop.i(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acpq
 * JD-Core Version:    0.7.0.1
 */