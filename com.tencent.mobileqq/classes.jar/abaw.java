import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.armap.wealthgod.ARMapLoadingActivity;
import com.tencent.mobileqq.armap.wealthgod.ARMapLoadingActivity.LoadingTimeStamp;
import com.tencent.mobileqq.armap.wealthgod.ARMapSplashView;
import com.tencent.qphone.base.util.QLog;

public class abaw
  implements View.OnClickListener
{
  public abaw(ARMapLoadingActivity paramARMapLoadingActivity) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapLoadingActivity", 2, "onClick to retry...");
    }
    ARMapLoadingActivity.a(this.a).a();
    ARMapLoadingActivity.a(this.a).a = System.currentTimeMillis();
    ARMapLoadingActivity.a(this.a).setWealthGodInfo(ARMapLoadingActivity.a(this.a), ARMapLoadingActivity.d(this.a));
    ARMapLoadingActivity.a(this.a).setLoadStatus(0);
    ARMapLoadingActivity.b(this.a, ARMapLoadingActivity.a(this.a).a());
    if (ARMapLoadingActivity.a(this.a) == null)
    {
      ARMapLoadingActivity.a(this.a).removeMessages(100);
      ARMapLoadingActivity.a(this.a).sendEmptyMessageDelayed(100, 200L);
    }
    for (;;)
    {
      ARMapLoadingActivity.c(this.a);
      ARMapLoadingActivity.d(this.a);
      ARMapLoadingActivity.c(this.a, false);
      ARMapLoadingActivity.d(this.a, false);
      return;
      if (ARMapLoadingActivity.b(this.a) == 5) {
        ARMapLoadingActivity.a(this.a).c();
      }
      ARMapLoadingActivity.a(this.a).removeMessages(102);
      ARMapLoadingActivity.a(this.a).sendEmptyMessageDelayed(102, 200L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abaw
 * JD-Core Version:    0.7.0.1
 */