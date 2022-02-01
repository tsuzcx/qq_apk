import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import java.lang.ref.WeakReference;

public class alwn
  implements DialogInterface.OnCancelListener
{
  private final WeakReference<Activity> a;
  
  public alwn(Activity paramActivity)
  {
    this.a = new WeakReference(paramActivity);
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    Activity localActivity = (Activity)this.a.get();
    if ((localActivity != null) && (!localActivity.isFinishing())) {
      paramDialogInterface.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alwn
 * JD-Core Version:    0.7.0.1
 */