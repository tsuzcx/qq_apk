import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.LoginActivity;

public class aagp
  implements DialogInterface.OnClickListener
{
  public aagp(AddFriendLogicActivity paramAddFriendLogicActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      paramDialogInterface = new Intent(this.a, LoginActivity.class);
      paramDialogInterface.putExtra("is_change_account", true);
      paramDialogInterface.putExtra("if_check_account_same", true);
      paramDialogInterface.putExtras(this.a.getIntent().getExtras());
      paramDialogInterface.putExtra("appid", AddFriendLogicActivity.c(this.a));
      paramDialogInterface.putExtra("openid", AddFriendLogicActivity.jdField_a_of_type_JavaLangString);
      paramDialogInterface.putExtra("key_action", AddFriendLogicActivity.class.getSimpleName());
      paramDialogInterface.addFlags(268435456);
      paramDialogInterface.addFlags(67108864);
      this.a.jdField_a_of_type_Bbgu.cancel();
      this.a.startActivity(paramDialogInterface);
      this.a.finish();
    }
    while (paramInt != 0) {
      return;
    }
    this.a.setResult(0);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aagp
 * JD-Core Version:    0.7.0.1
 */