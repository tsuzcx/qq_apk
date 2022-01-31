import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class aagn
  implements DialogInterface.OnClickListener
{
  public aagn(AddFriendLogicActivity paramAddFriendLogicActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    axqy.b(this.a.app, "P_CliOper", "Safe_AntiFraud", this.a.app.getCurrentAccountUin(), "AlertDialog", "UserClick", 0, AddFriendLogicActivity.d(this.a), "", "", "", "");
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aagn
 * JD-Core Version:    0.7.0.1
 */