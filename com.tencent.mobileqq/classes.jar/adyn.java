import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.SoundAndVibrateActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class adyn
  implements CompoundButton.OnCheckedChangeListener
{
  public adyn(SoundAndVibrateActivity paramSoundAndVibrateActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int i = 1;
    if (paramBoolean)
    {
      this.a.app.d(1);
      paramCompoundButton = this.a.app;
      if (!paramBoolean) {
        break label68;
      }
    }
    for (;;)
    {
      azqs.b(paramCompoundButton, "CliOper", "", "", "Setting_tab", "Clk_notice_grpshake", 0, i, "", "", "", "");
      return;
      this.a.app.d(0);
      break;
      label68:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adyn
 * JD-Core Version:    0.7.0.1
 */