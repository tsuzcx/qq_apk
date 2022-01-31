import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.SoundAndVibrateActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class acdh
  implements CompoundButton.OnCheckedChangeListener
{
  public acdh(SoundAndVibrateActivity paramSoundAndVibrateActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int i = 1;
    if (paramBoolean)
    {
      this.a.app.c(1);
      paramCompoundButton = this.a.app;
      if (!paramBoolean) {
        break label68;
      }
    }
    for (;;)
    {
      axqw.b(paramCompoundButton, "CliOper", "", "", "Setting_tab", "Clk_notice_gupsound", 0, i, "", "", "", "");
      return;
      this.a.app.c(0);
      break;
      label68:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     acdh
 * JD-Core Version:    0.7.0.1
 */