import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.richmedia.capture.util.CaptureReportUtil;
import com.tencent.mobileqq.richmedia.capture.util.CaptureUtil;
import com.tencent.mobileqq.richmedia.capture.util.ProviderViewBuilder;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureButtonLayout;
import com.tencent.mobileqq.richmedia.capture.view.EffectsCameraCaptureView;
import com.tencent.mobileqq.richmedia.capture.view.ProviderContainerView;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class agyi
  implements View.OnClickListener
{
  public agyi(ProviderContainerView paramProviderContainerView) {}
  
  public void onClick(View paramView)
  {
    int i = ProviderContainerView.a(this.a).b(((Integer)paramView.getTag()).intValue());
    if (i == 102)
    {
      CaptureReportUtil.b();
      if (!PtvFilterSoLoad.b(this.a.getContext())) {
        QQToast.a(this.a.getContext(), "挂件尚未准备完成，请稍候。", 0).a();
      }
    }
    boolean bool;
    do
    {
      do
      {
        return;
        if (CaptureUtil.a == 0)
        {
          QQToast.a(this.a.getContext(), "挂件插件加载失败，请重启QQ再试。", 0).a();
          return;
        }
        if (CaptureUtil.a != -1) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("ProviderContainerView", 2, "ptv template so library hasn't loaded");
      return;
      if (CaptureUtil.a == 2)
      {
        bool = CaptureUtil.b();
        if (QLog.isColorLevel()) {
          QLog.d("ProviderContainerView", 2, "ProviderContainerView oncilck soLoaded=" + bool);
        }
        if (ProviderContainerView.a(this.a) != null) {
          ProviderContainerView.a(this.a).t();
        }
      }
      if (i != 103) {
        break label320;
      }
      CaptureReportUtil.e();
      CaptureReportUtil.b();
      if (!PtvFilterSoLoad.b(this.a.getContext()))
      {
        QQToast.a(this.a.getContext(), "美颜插件尚未准备完成，请稍候再试。", 0).a();
        return;
      }
      if (CaptureUtil.a == 0)
      {
        QQToast.a(this.a.getContext(), "美颜插件加载失败，请重启QQ再试。", 0).a();
        return;
      }
      if (CaptureUtil.a != -1) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ProviderContainerView", 2, "ptv template so library hasn't loaded for beauty");
    return;
    if (CaptureUtil.a == 2)
    {
      bool = CaptureUtil.b();
      if (QLog.isColorLevel()) {
        QLog.d("ProviderContainerView", 2, "ProviderContainerView oncilck beauty soLoaded=" + bool);
      }
      if (ProviderContainerView.a(this.a) != null) {
        ProviderContainerView.a(this.a).t();
      }
    }
    label320:
    if (i == 101)
    {
      CaptureReportUtil.d();
      if (CaptureUtil.b != 2) {
        break label434;
      }
      bool = CaptureUtil.d();
      if (QLog.isColorLevel()) {
        QLog.d("ProviderContainerView", 2, "svaf so should reload, needUpdate:" + bool);
      }
    }
    for (;;)
    {
      if (i == 104)
      {
        ReportController.b(null, "dc00898", "", "", "0X8008756", "0X8008756", 0, 0, "", "", "", "");
        CaptureReportUtil.c();
      }
      if (ProviderContainerView.a(this.a) != null) {
        ProviderContainerView.a(this.a).a();
      }
      ProviderContainerView.a(this.a, paramView, i);
      return;
      label434:
      if ((CaptureUtil.b != 1) && (QLog.isColorLevel())) {
        QLog.d("ProviderContainerView", 2, "svaf so hasn't loaded, status:" + CaptureUtil.b);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     agyi
 * JD-Core Version:    0.7.0.1
 */