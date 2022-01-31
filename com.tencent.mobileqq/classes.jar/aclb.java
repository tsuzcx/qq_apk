import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.ChatSettingForTroop;

public class aclb
  implements DialogInterface.OnClickListener
{
  public aclb(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ChatSettingForTroop.i(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aclb
 * JD-Core Version:    0.7.0.1
 */