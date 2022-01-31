import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.ChatSettingActivity;

public class aati
  implements DialogInterface.OnClickListener
{
  public aati(ChatSettingActivity paramChatSettingActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ChatSettingActivity.c(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aati
 * JD-Core Version:    0.7.0.1
 */