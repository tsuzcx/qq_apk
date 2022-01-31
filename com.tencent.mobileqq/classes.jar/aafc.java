import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;

public class aafc
  implements View.OnClickListener
{
  public aafc(AccountManageActivity paramAccountManageActivity) {}
  
  public void onClick(View paramView)
  {
    axqw.b(this.a.app, "CliOper", "", "", "Quit", "Setting_Quit", 0, 0, "2", "", "", "");
    if (SettingCloneUtil.readValue(this.a.app.getApplication(), this.a.app.getAccount(), null, "pcactive_config", false)) {
      this.a.app.startPCActivePolling(this.a.app.getAccount(), "logout");
    }
    AccountManageActivity.a(this.a.getActivity(), this.a.app);
    if ((this.a.b != null) && (this.a.b.isShowing())) {
      this.a.b.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aafc
 * JD-Core Version:    0.7.0.1
 */