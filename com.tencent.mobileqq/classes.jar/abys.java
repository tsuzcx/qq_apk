import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.device.msg.activities.DeviceTipActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class abys
  implements View.OnClickListener
{
  public abys(DeviceTipActivity paramDeviceTipActivity) {}
  
  public void onClick(View paramView)
  {
    if (!bhnv.g(this.a)) {
      QQToast.a(this.a, anzj.a(2131702127), 2000).a();
    }
    DeviceTipActivity.a(this.a, 2);
    this.a.finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abys
 * JD-Core Version:    0.7.0.1
 */