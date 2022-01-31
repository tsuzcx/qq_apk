import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.arcard.ArCardSelectMemberActivity;

public class aanp
  implements DialogInterface.OnClickListener
{
  public aanp(ArCardSelectMemberActivity paramArCardSelectMemberActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    ArCardSelectMemberActivity.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aanp
 * JD-Core Version:    0.7.0.1
 */