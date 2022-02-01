import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.GeneralSettingActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.msgbackup.fragment.MsgBackupWelcomeFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aejd
  implements View.OnClickListener
{
  public aejd(GeneralSettingActivity paramGeneralSettingActivity) {}
  
  public void onClick(View paramView)
  {
    awqs.a("0X800A22D");
    PublicFragmentActivity.a(this.a.getActivity(), MsgBackupWelcomeFragment.class);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aejd
 * JD-Core Version:    0.7.0.1
 */