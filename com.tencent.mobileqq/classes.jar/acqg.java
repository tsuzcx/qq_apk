import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.activity.LoginActivity;

public class acqg
  implements DialogInterface.OnClickListener
{
  public acqg(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      paramDialogInterface = new Intent(this.a, LoginActivity.class);
      paramDialogInterface.putExtra("is_change_account", true);
      paramDialogInterface.putExtra("if_check_account_same", true);
      paramDialogInterface.putExtras(this.a.getIntent().getExtras());
      paramDialogInterface.putExtra("key_action", ChatSettingForTroop.class.getSimpleName());
      paramDialogInterface.addFlags(268435456);
      paramDialogInterface.addFlags(67108864);
      this.a.a.cancel();
      this.a.startActivity(paramDialogInterface);
      this.a.finish();
    }
    while (paramInt != 0) {
      return;
    }
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acqg
 * JD-Core Version:    0.7.0.1
 */