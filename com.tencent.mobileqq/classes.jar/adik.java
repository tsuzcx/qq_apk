import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AssistantSettingActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.fragment.BottomTabSettingFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class adik
  implements View.OnClickListener
{
  public adik(AssistantSettingActivity paramAssistantSettingActivity) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent();
    localIntent.addFlags(268435456);
    localIntent.addFlags(536870912);
    localIntent.addFlags(67108864);
    aeow.a(paramView.getContext(), localIntent, PublicFragmentActivity.class, BottomTabSettingFragment.class);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adik
 * JD-Core Version:    0.7.0.1
 */