import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.PhoneUnityChangeActivity;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;

class adiw
  implements DialogInterface.OnClickListener
{
  adiw(adiu paramadiu) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    if (!bdee.d(this.a.a))
    {
      PhoneUnityChangeActivity.a(this.a.a, 2131694829);
      return;
    }
    if (this.a.a.b == null)
    {
      this.a.a.b = new adix(this);
      this.a.a.app.registObserver(this.a.a.b);
    }
    PhoneUnityChangeActivity.a(this.a.a).a(true, false);
    PhoneUnityChangeActivity.a(this.a.a, 2131719773, 0L, true);
    azmj.b(this.a.a.app, "CliOper", "", "", "0X8005B81", "0X8005B81", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adiw
 * JD-Core Version:    0.7.0.1
 */