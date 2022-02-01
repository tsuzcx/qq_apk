import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mobileqq.activity.ContactSyncJumpActivity;

public class adtt
  implements DialogInterface.OnCancelListener
{
  public adtt(ContactSyncJumpActivity paramContactSyncJumpActivity) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     adtt
 * JD-Core Version:    0.7.0.1
 */