import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;

public class aejx
  implements DialogInterface.OnClickListener
{
  public aejx(NotificationActivity paramNotificationActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (NotificationActivity.c(this.a))
    {
      bkki.a(this.a);
      NotificationActivity.a(this.a, "0X800B655");
      return;
    }
    bdla.a(this.a.app, "dc00898", "", NotificationActivity.c(this.a), "0X800AA31", "0X800AA31", 0, 0, "", "", "", NotificationActivity.a(this.a));
    paramDialogInterface = new Intent(this.a.getActivity(), QQBrowserActivity.class);
    this.a.startActivity(paramDialogInterface.putExtra("url", "https://myun.tenpay.com/mqq/banneduser/index.shtml?_wv=1027"));
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aejx
 * JD-Core Version:    0.7.0.1
 */