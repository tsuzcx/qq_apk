import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;

public class adsi
  implements DialogInterface.OnClickListener
{
  public adsi(AddFriendLogicActivity paramAddFriendLogicActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (AddFriendLogicActivity.d(this.a) == 1)
    {
      this.a.finish();
      return;
    }
    AddFriendLogicActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adsi
 * JD-Core Version:    0.7.0.1
 */