import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.UpgradeActivity;
import com.tencent.mobileqq.activity.UpgradeActivity.15.1;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class acdz
  implements DialogInterface.OnClickListener
{
  public acdz(UpgradeActivity paramUpgradeActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    bcds.b("qqBaseActivity", bcat.a(10010, 1, 3, 200));
    bcar.a().a(17, bcat.a(10010, 1, 3, 200));
    if (!bchb.a().b()) {
      bcec.a().a(ajjy.a(2131650119));
    }
    for (;;)
    {
      ThreadManager.getSubThreadHandler().postDelayed(new UpgradeActivity.15.1(this), 500L);
      return;
      badr.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     acdz
 * JD-Core Version:    0.7.0.1
 */