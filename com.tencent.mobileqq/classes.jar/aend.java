import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.PhoneUnityChangeActivity;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;

class aend
  implements DialogInterface.OnClickListener
{
  aend(aenb paramaenb) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    if (!NetworkUtil.isNetSupport(this.a.a))
    {
      PhoneUnityChangeActivity.a(this.a.a, 2131694305);
      return;
    }
    if (this.a.a.b == null)
    {
      this.a.a.b = new aene(this);
      this.a.a.app.registObserver(this.a.a.b);
    }
    PhoneUnityChangeActivity.a(this.a.a).a(true, false);
    PhoneUnityChangeActivity.a(this.a.a, 2131718527, 0L, true);
    bdla.b(this.a.a.app, "CliOper", "", "", "0X8005B81", "0X8005B81", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aend
 * JD-Core Version:    0.7.0.1
 */