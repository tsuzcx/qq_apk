import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.bless.BlessSelectMemberActivity;

public class afbj
  implements DialogInterface.OnClickListener
{
  public afbj(BlessSelectMemberActivity paramBlessSelectMemberActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    BlessSelectMemberActivity.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afbj
 * JD-Core Version:    0.7.0.1
 */