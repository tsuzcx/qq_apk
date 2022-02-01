import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class agtf
  implements CompoundButton.OnCheckedChangeListener
{
  public agtf(AIOLongShotHelper paramAIOLongShotHelper) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    AIOLongShotHelper.a(this.a, paramCompoundButton, paramBoolean);
    AIOLongShotHelper.a("0X8009DE8");
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agtf
 * JD-Core Version:    0.7.0.1
 */