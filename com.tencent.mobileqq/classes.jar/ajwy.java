import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.app.FrameHelperActivity;

public class ajwy
  implements DialogInterface.OnDismissListener
{
  public ajwy(FrameHelperActivity paramFrameHelperActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    FrameHelperActivity.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ajwy
 * JD-Core Version:    0.7.0.1
 */