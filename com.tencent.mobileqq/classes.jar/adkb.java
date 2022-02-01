import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.FriendProfileMoreInfoActivity;

public class adkb
  implements DialogInterface.OnDismissListener
{
  public adkb(FriendProfileMoreInfoActivity paramFriendProfileMoreInfoActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.a(FriendProfileMoreInfoActivity.a(this.a), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adkb
 * JD-Core Version:    0.7.0.1
 */