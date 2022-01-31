import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.FriendProfileMoreInfoActivity;

public class acxm
  implements DialogInterface.OnDismissListener
{
  public acxm(FriendProfileMoreInfoActivity paramFriendProfileMoreInfoActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.a(FriendProfileMoreInfoActivity.a(this.a), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acxm
 * JD-Core Version:    0.7.0.1
 */