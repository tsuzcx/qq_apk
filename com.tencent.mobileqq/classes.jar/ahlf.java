import android.content.Context;
import android.view.OrientationEventListener;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView;
import com.tencent.qphone.base.util.QLog;

public class ahlf
  extends OrientationEventListener
{
  public ahlf(CameraCaptureView paramCameraCaptureView, Context paramContext)
  {
    super(paramContext);
  }
  
  public void onOrientationChanged(int paramInt)
  {
    this.a.m = paramInt;
    if (paramInt == -1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CameraCaptureView", 2, "OrientationEventListener unknown");
      }
      this.a.n = 90;
    }
    if ((paramInt > 315) || (paramInt < 45)) {
      this.a.n = 90;
    }
    for (;;)
    {
      if (this.a.f) {
        this.a.l = this.a.n;
      }
      com.tencent.mobileqq.richmedia.capture.util.ReportUtil.a = this.a.l;
      return;
      if ((paramInt > 45) && (paramInt < 135)) {
        this.a.n = 180;
      } else if ((paramInt > 135) && (paramInt < 225)) {
        this.a.n = 270;
      } else if ((paramInt > 225) && (paramInt < 315)) {
        this.a.n = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahlf
 * JD-Core Version:    0.7.0.1
 */