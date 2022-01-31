import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.app.FrameHelperActivity;

public class alok
  implements DialogInterface.OnDismissListener
{
  public alok(FrameHelperActivity paramFrameHelperActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    FrameHelperActivity.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     alok
 * JD-Core Version:    0.7.0.1
 */