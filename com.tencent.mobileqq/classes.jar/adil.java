import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.AssistantSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.screendetect.ScreenShotDetector;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class adil
  implements CompoundButton.OnCheckedChangeListener
{
  public adil(AssistantSettingActivity paramAssistantSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    ScreenShotDetector.a(paramBoolean);
    QQAppInterface localQQAppInterface = this.a.app;
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      bdla.b(localQQAppInterface, "dc00898", "", "", "0X800B4E7", "0X800B4E7", i, 0, "", "", "", "");
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adil
 * JD-Core Version:    0.7.0.1
 */