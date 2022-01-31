import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;

public class ahuv
  implements CompoundButton.OnCheckedChangeListener
{
  public ahuv(NewFlowCameraActivity paramNewFlowCameraActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    NewFlowCameraActivity.a(this.a, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ahuv
 * JD-Core Version:    0.7.0.1
 */