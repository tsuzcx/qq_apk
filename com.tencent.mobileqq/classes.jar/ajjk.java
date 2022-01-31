import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.UpgradeDetailActivity;
import com.tencent.mobileqq.activity.registerGuideLogin.LoginView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.upgrade.UpgradeDetailWrapper;

public class ajjk
  implements DialogInterface.OnClickListener
{
  public ajjk(LoginView paramLoginView) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = (UpgradeDetailWrapper)this.a.a.getIntent().getParcelableExtra(UpgradeDetailWrapper.class.getSimpleName());
    UpgradeDetailActivity.a(this.a.a, paramDialogInterface, true, false, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajjk
 * JD-Core Version:    0.7.0.1
 */