import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.arcard.ArCardSelectMemberActivity;

public class aago
  implements DialogInterface.OnClickListener
{
  public aago(ArCardSelectMemberActivity paramArCardSelectMemberActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    ArCardSelectMemberActivity.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aago
 * JD-Core Version:    0.7.0.1
 */