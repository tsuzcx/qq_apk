import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.GeneralSettingActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.fragment.QQSettingAutoDownloadAndSaveFragment;

public class acyl
  implements View.OnClickListener
{
  public acyl(GeneralSettingActivity paramGeneralSettingActivity) {}
  
  public void onClick(View paramView)
  {
    PublicFragmentActivity.a(this.a.getActivity(), QQSettingAutoDownloadAndSaveFragment.class);
    azmj.b(null, "CliOper", "", "", "0X800A2DB", "0X800A2DB", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acyl
 * JD-Core Version:    0.7.0.1
 */