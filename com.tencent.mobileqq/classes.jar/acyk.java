import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.GeneralSettingActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.fragment.QQSettingChatOperationFragment;

public class acyk
  implements View.OnClickListener
{
  public acyk(GeneralSettingActivity paramGeneralSettingActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent();
    paramView.putExtra("set_display_type", 1);
    PublicFragmentActivity.a(this.a.getActivity(), paramView, QQSettingChatOperationFragment.class);
    azmj.b(null, "CliOper", "", "", "0X800A22C", "0X800A22C", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acyk
 * JD-Core Version:    0.7.0.1
 */