import android.app.Activity;
import android.app.Application;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class aaks
  implements DialogInterface.OnDismissListener
{
  aaks(aakp paramaakp) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    aakp.a(this.a).setIntent(aakp.a(this.a));
    aakp.a(this.a).getApplication().unregisterActivityLifecycleCallbacks(aakp.a(this.a));
    aakp.a(this.a).i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaks
 * JD-Core Version:    0.7.0.1
 */