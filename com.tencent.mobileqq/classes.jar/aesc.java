import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.GeneralSettingActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.fragment.LangSettingFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aesc
  implements View.OnClickListener
{
  public aesc(GeneralSettingActivity paramGeneralSettingActivity) {}
  
  public void onClick(View paramView)
  {
    PublicFragmentActivity.a(this.a, LangSettingFragment.class);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aesc
 * JD-Core Version:    0.7.0.1
 */