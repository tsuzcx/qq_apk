import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.PhoneUnityChangeActivity;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;

class abro
  implements DialogInterface.OnClickListener
{
  abro(abrm paramabrm) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    if (!bbfj.d(this.a.a))
    {
      PhoneUnityChangeActivity.a(this.a.a, 2131694673);
      return;
    }
    if (this.a.a.b == null)
    {
      this.a.a.b = new abrp(this);
      this.a.a.app.registObserver(this.a.a.b);
    }
    PhoneUnityChangeActivity.a(this.a.a).a(true, false);
    PhoneUnityChangeActivity.a(this.a.a, 2131719292, 0L, true);
    axqy.b(this.a.a.app, "CliOper", "", "", "0X8005B81", "0X8005B81", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abro
 * JD-Core Version:    0.7.0.1
 */