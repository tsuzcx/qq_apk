import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.NotifyPushSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;

public class adly
  implements CompoundButton.OnCheckedChangeListener
{
  public adly(NotifyPushSettingActivity paramNotifyPushSettingActivity, BubbleManager paramBubbleManager) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a(paramBoolean);
    String str = this.jdField_a_of_type_ComTencentMobileqqActivityNotifyPushSettingActivity.app.getCurrentAccountUin();
    if (paramBoolean) {}
    for (paramCompoundButton = "1";; paramCompoundButton = "0")
    {
      VasWebviewUtil.reportCommercialDrainage(str, "bubble_new", "change", "0", 0, 0, 0, "", "", paramCompoundButton, "", "", "", "", 0, 0, 0, 0);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adly
 * JD-Core Version:    0.7.0.1
 */