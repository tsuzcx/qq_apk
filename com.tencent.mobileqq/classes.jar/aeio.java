import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.MoveToGroupActivity;

public class aeio
  implements DialogInterface.OnDismissListener
{
  public aeio(MoveToGroupActivity paramMoveToGroupActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    MoveToGroupActivity.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeio
 * JD-Core Version:    0.7.0.1
 */