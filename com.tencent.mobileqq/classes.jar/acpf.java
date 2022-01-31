import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.DialogActivity;

public class acpf
  implements DialogInterface.OnDismissListener
{
  public acpf(DialogActivity paramDialogActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acpf
 * JD-Core Version:    0.7.0.1
 */