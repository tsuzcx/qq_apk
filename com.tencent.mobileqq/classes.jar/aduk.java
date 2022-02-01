import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mobileqq.activity.DialogActivity;

public class aduk
  implements DialogInterface.OnCancelListener
{
  public aduk(DialogActivity paramDialogActivity) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aduk
 * JD-Core Version:    0.7.0.1
 */