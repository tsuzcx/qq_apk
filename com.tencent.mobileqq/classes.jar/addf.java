import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.GeneralSettingActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.msgbackup.fragment.MsgBackupWelcomeFragment;

public class addf
  implements View.OnClickListener
{
  public addf(GeneralSettingActivity paramGeneralSettingActivity) {}
  
  public void onClick(View paramView)
  {
    aujo.a("0X800A22D");
    PublicFragmentActivity.a(this.a.getActivity(), MsgBackupWelcomeFragment.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     addf
 * JD-Core Version:    0.7.0.1
 */