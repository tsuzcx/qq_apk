import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper;

public class afdo
  implements CompoundButton.OnCheckedChangeListener
{
  public afdo(AIOLongShotHelper paramAIOLongShotHelper) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    AIOLongShotHelper.a(this.a, paramCompoundButton, paramBoolean);
    AIOLongShotHelper.a("0X8009DE8");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afdo
 * JD-Core Version:    0.7.0.1
 */