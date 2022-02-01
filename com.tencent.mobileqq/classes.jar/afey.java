import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.SoundAndVibrateActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class afey
  implements CompoundButton.OnCheckedChangeListener
{
  public afey(SoundAndVibrateActivity paramSoundAndVibrateActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int i = 1;
    QQAppInterface localQQAppInterface;
    if (paramBoolean)
    {
      this.a.app.d(1);
      localQQAppInterface = this.a.app;
      if (!paramBoolean) {
        break label78;
      }
    }
    for (;;)
    {
      bcst.b(localQQAppInterface, "CliOper", "", "", "Setting_tab", "Clk_notice_grpshake", 0, i, "", "", "", "");
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      this.a.app.d(0);
      break;
      label78:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afey
 * JD-Core Version:    0.7.0.1
 */