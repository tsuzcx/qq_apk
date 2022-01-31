import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.GeneralSettingActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.fragment.QQSettingAutoDownloadAndSaveFragment;

public class abhl
  implements View.OnClickListener
{
  public abhl(GeneralSettingActivity paramGeneralSettingActivity) {}
  
  public void onClick(View paramView)
  {
    PublicFragmentActivity.a(this.a.getActivity(), QQSettingAutoDownloadAndSaveFragment.class);
    axqy.b(null, "CliOper", "", "", "0X800A2DB", "0X800A2DB", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     abhl
 * JD-Core Version:    0.7.0.1
 */