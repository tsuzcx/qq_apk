import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.MoveToGroupActivity;

public class adrl
  implements DialogInterface.OnDismissListener
{
  public adrl(MoveToGroupActivity paramMoveToGroupActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    MoveToGroupActivity.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adrl
 * JD-Core Version:    0.7.0.1
 */