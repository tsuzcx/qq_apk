import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.recent.msgbox.TempMsgBoxFragment;
import com.tencent.mobileqq.fragment.TempMsgSettingFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class almf
  implements View.OnClickListener
{
  public almf(TempMsgBoxFragment paramTempMsgBoxFragment) {}
  
  public void onClick(View paramView)
  {
    PublicFragmentActivity.a(TempMsgBoxFragment.a(this.a), TempMsgSettingFragment.class);
    bdla.b(this.a.a, "dc00898", "", "", "0X800B1C1", "0X800B1C1", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     almf
 * JD-Core Version:    0.7.0.1
 */