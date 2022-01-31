import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.ar.ARScanFragment;
import com.tencent.mobileqq.ar.arengine.AREngine;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;
import com.tencent.qphone.base.util.QLog;

public class agey
  implements View.OnClickListener
{
  public agey(ScanTorchActivity paramScanTorchActivity) {}
  
  public void onClick(View paramView)
  {
    boolean bool2 = false;
    if ((this.a.a != null) && (this.a.a.a != null))
    {
      if (!ScanTorchActivity.g(this.a)) {
        break label152;
      }
      paramView = this.a.a.a;
      if (ScanTorchActivity.h(this.a)) {
        break label142;
      }
      bool1 = true;
      if (paramView.b(bool1))
      {
        paramView = this.a;
        if (ScanTorchActivity.h(this.a)) {
          break label147;
        }
        bool1 = true;
        ScanTorchActivity.k(paramView, bool1);
        paramView = this.a.a.a;
        bool1 = bool2;
        if (!ScanTorchActivity.h(this.a)) {
          bool1 = true;
        }
        paramView.g(bool1);
        ScanTorchActivity.a(this.a, true);
        ScanTorchActivity.b(this.a, ScanTorchActivity.h(this.a));
      }
    }
    label142:
    label147:
    label152:
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        return;
        boolean bool1 = false;
        continue;
        bool1 = false;
      }
    }
    QLog.d("ScanTorchActivity", 2, "initView click mFlashLightTips when view invisble.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agey
 * JD-Core Version:    0.7.0.1
 */