import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.GeneralSettingActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.msgbackup.fragment.MsgBackupWelcomeFragment;

public class abhq
  implements View.OnClickListener
{
  public abhq(GeneralSettingActivity paramGeneralSettingActivity) {}
  
  public void onClick(View paramView)
  {
    asog.a("0X800A22D");
    PublicFragmentActivity.a(this.a.getActivity(), MsgBackupWelcomeFragment.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abhq
 * JD-Core Version:    0.7.0.1
 */