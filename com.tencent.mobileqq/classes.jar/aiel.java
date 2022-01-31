import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class aiel
  implements DialogInterface.OnClickListener
{
  aiel(aiek paramaiek) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(aiek.a(this.a), 2, "On Click Left Button! ");
    }
    if (this.a.mRuntime.a() != null) {
      this.a.mRuntime.a().finish();
    }
    for (;;)
    {
      aiek.a(this.a, 1);
      return;
      if (QLog.isDevelopLevel()) {
        QLog.d(aiek.a(this.a), 4, "Call back object is null!");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiel
 * JD-Core Version:    0.7.0.1
 */