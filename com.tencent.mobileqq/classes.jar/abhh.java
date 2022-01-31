import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.GeneralSettingActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.QQSettingMsgClearFragment;

public class abhh
  implements View.OnClickListener
{
  public abhh(GeneralSettingActivity paramGeneralSettingActivity) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    ((avpq)this.a.app.getManager(36)).b("100190.100194");
    paramView = new Intent();
    paramView.putExtra("set_display_type", 1);
    PublicFragmentActivity.a(this.a.getActivity(), paramView, QQSettingMsgClearFragment.class);
    axqw.b(this.a.app, "CliOper", "", "", "0X800A1F2", "0X800A1F2", 0, 0, "", "", "", "");
    axqw.b(this.a.app, "CliOper", "", "", "Setting_tab", "My_settab_log", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abhh
 * JD-Core Version:    0.7.0.1
 */