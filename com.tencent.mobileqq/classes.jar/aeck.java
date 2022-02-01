import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.GeneralSettingActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.fragment.QQSettingChatOperationFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aeck
  implements View.OnClickListener
{
  public aeck(GeneralSettingActivity paramGeneralSettingActivity) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("set_display_type", 1);
    PublicFragmentActivity.a(this.a.getActivity(), localIntent, QQSettingChatOperationFragment.class);
    bdla.b(null, "CliOper", "", "", "0X800A22C", "0X800A22C", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeck
 * JD-Core Version:    0.7.0.1
 */