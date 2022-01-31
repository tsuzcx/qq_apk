import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper;

public class acwc
  implements CompoundButton.OnCheckedChangeListener
{
  public acwc(AIOLongShotHelper paramAIOLongShotHelper) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    AIOLongShotHelper.a(this.a, paramCompoundButton, paramBoolean);
    AIOLongShotHelper.a("0X8009DE8");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     acwc
 * JD-Core Version:    0.7.0.1
 */