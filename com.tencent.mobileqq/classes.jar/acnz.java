import android.app.Activity;
import android.app.Application;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class acnz
  implements DialogInterface.OnDismissListener
{
  acnz(acnw paramacnw) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    acnw.a(this.a).setIntent(acnw.a(this.a));
    acnw.a(this.a).getApplication().unregisterActivityLifecycleCallbacks(acnw.a(this.a));
    acnw.a(this.a).o();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acnz
 * JD-Core Version:    0.7.0.1
 */