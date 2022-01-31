import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.arcard.ArCardSelectMemberActivity;

public class aauj
  implements DialogInterface.OnClickListener
{
  public aauj(ArCardSelectMemberActivity paramArCardSelectMemberActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    ArCardSelectMemberActivity.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aauj
 * JD-Core Version:    0.7.0.1
 */