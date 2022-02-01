import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.AssistantSettingActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class adii
  implements CompoundButton.OnCheckedChangeListener
{
  public adii(AssistantSettingActivity paramAssistantSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool = true;
    if (!NetworkUtil.isNetSupport(this.a.getActivity()))
    {
      AssistantSettingActivity.a(this.a, 2131694305, 1);
      AssistantSettingActivity localAssistantSettingActivity = this.a;
      if (!paramBoolean) {
        AssistantSettingActivity.a(localAssistantSettingActivity, bool, this);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      bool = false;
      break;
      ((anri)this.a.app.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).q(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adii
 * JD-Core Version:    0.7.0.1
 */