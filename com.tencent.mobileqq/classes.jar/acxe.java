import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ForwardFriendListActivity;

public class acxe
  implements DialogInterface.OnClickListener
{
  public acxe(ForwardFriendListActivity paramForwardFriendListActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = ForwardFriendListActivity.a(this.a).getInputValue();
    if (!TextUtils.isEmpty(paramDialogInterface))
    {
      ForwardFriendListActivity.a(this.a, ForwardFriendListActivity.a(this.a).getEditText());
      Intent localIntent = new Intent();
      localIntent.putExtras(this.a.getIntent().getExtras());
      localIntent.putExtra("extra_choose_friend_name", paramDialogInterface);
      this.a.setResult(-1, localIntent);
      this.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acxe
 * JD-Core Version:    0.7.0.1
 */