import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.ForwardFriendListActivity;

public class aasd
  implements DialogInterface.OnClickListener
{
  public aasd(ForwardFriendListActivity paramForwardFriendListActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ForwardFriendListActivity.a(this.a).dismiss();
    ForwardFriendListActivity.a(this.a, ForwardFriendListActivity.a(this.a).getEditText());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aasd
 * JD-Core Version:    0.7.0.1
 */