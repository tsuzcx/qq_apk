import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.UpgradeActivity;
import com.tencent.mobileqq.activity.UpgradeActivity.15.1;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class aekj
  implements DialogInterface.OnClickListener
{
  public aekj(UpgradeActivity paramUpgradeActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    bflp.b("qqBaseActivity", bfiq.a(10010, 1, 3, 200));
    bfio.a().a(17, bfiq.a(10010, 1, 3, 200));
    if (!bfox.a().b()) {
      bflz.a().a(alud.a(2131716305));
    }
    for (;;)
    {
      ThreadManager.getSubThreadHandler().postDelayed(new UpgradeActivity.15.1(this), 500L);
      return;
      bdio.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aekj
 * JD-Core Version:    0.7.0.1
 */