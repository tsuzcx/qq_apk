import android.app.Activity;
import android.app.Application;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class acsb
  implements DialogInterface.OnDismissListener
{
  acsb(acry paramacry) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    acry.a(this.a).setIntent(acry.a(this.a));
    acry.a(this.a).getApplication().unregisterActivityLifecycleCallbacks(acry.a(this.a));
    acry.a(this.a).o();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acsb
 * JD-Core Version:    0.7.0.1
 */