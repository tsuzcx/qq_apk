import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.FriendProfileMoreInfoActivity;

public class adci
  implements DialogInterface.OnClickListener
{
  public adci(FriendProfileMoreInfoActivity paramFriendProfileMoreInfoActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    azqs.b(this.a.app, "dc00898", "", "", "0X800A0D8", "0X800A0D8", 0, 0, "", "", "", "");
    FriendProfileMoreInfoActivity.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adci
 * JD-Core Version:    0.7.0.1
 */