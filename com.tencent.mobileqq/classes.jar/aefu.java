import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.UpgradeActivity;
import com.tencent.mobileqq.activity.UpgradeActivity.15.1;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class aefu
  implements DialogInterface.OnClickListener
{
  public aefu(UpgradeActivity paramUpgradeActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    bfhg.b("qqBaseActivity", bfeh.a(10010, 1, 3, 200));
    bfef.a().a(17, bfeh.a(10010, 1, 3, 200));
    if (!bfko.a().b()) {
      bfhq.a().a(alpo.a(2131716293));
    }
    for (;;)
    {
      ThreadManager.getSubThreadHandler().postDelayed(new UpgradeActivity.15.1(this), 500L);
      return;
      bdef.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aefu
 * JD-Core Version:    0.7.0.1
 */