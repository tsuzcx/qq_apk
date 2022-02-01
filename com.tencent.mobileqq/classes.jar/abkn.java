import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.device.msg.activities.DeviceTipActivity;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class abkn
  implements View.OnClickListener
{
  public abkn(DeviceTipActivity paramDeviceTipActivity) {}
  
  public void onClick(View paramView)
  {
    if (!NetworkUtil.isNetworkAvailable(this.a)) {
      QQToast.a(this.a, anvx.a(2131702713), 2000).a();
    }
    DeviceTipActivity.a(this.a, 2);
    this.a.finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abkn
 * JD-Core Version:    0.7.0.1
 */