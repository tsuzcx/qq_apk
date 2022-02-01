import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.GeneralSettingActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.msgbackup.fragment.MsgBackupWelcomeFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aeby
  implements View.OnClickListener
{
  public aeby(GeneralSettingActivity paramGeneralSettingActivity) {}
  
  public void onClick(View paramView)
  {
    axct.a("0X800A22D");
    PublicFragmentActivity.a(this.a.getActivity(), MsgBackupWelcomeFragment.class);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeby
 * JD-Core Version:    0.7.0.1
 */