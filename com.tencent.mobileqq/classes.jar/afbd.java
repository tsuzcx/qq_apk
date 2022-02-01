import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.TroopAssisSettingActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class afbd
  implements CompoundButton.OnCheckedChangeListener
{
  public afbd(TroopAssisSettingActivity paramTroopAssisSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    switch (paramCompoundButton.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      awtz.a().a(this.a.app, paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afbd
 * JD-Core Version:    0.7.0.1
 */