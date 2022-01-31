import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.UpgradeActivity;
import com.tencent.mobileqq.activity.UpgradeActivity.15.1;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class acok
  implements DialogInterface.OnClickListener
{
  public acok(UpgradeActivity paramUpgradeActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    bdii.b("qqBaseActivity", bdfj.a(10010, 1, 3, 200));
    bdfh.a().a(17, bdfj.a(10010, 1, 3, 200));
    if (!bdlr.a().b()) {
      bdis.a().a(ajya.a(2131715921));
    }
    for (;;)
    {
      ThreadManager.getSubThreadHandler().postDelayed(new UpgradeActivity.15.1(this), 500L);
      return;
      bbfk.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     acok
 * JD-Core Version:    0.7.0.1
 */