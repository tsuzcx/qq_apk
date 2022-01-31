import android.content.Context;
import android.view.OrientationEventListener;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView;
import com.tencent.qphone.base.util.QLog;

public class ahpz
  extends OrientationEventListener
{
  public ahpz(CameraCaptureView paramCameraCaptureView, Context paramContext)
  {
    super(paramContext);
  }
  
  public void onOrientationChanged(int paramInt)
  {
    this.a.u = paramInt;
    if (paramInt == -1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CameraCaptureView", 2, "OrientationEventListener unknown");
      }
      this.a.v = 90;
    }
    if ((paramInt > 315) || (paramInt < 45)) {
      this.a.v = 90;
    }
    for (;;)
    {
      if (this.a.g) {
        this.a.t = this.a.v;
      }
      com.tencent.mobileqq.richmedia.capture.util.ReportUtil.a = this.a.t;
      return;
      if ((paramInt > 45) && (paramInt < 135)) {
        this.a.v = 180;
      } else if ((paramInt > 135) && (paramInt < 225)) {
        this.a.v = 270;
      } else if ((paramInt > 225) && (paramInt < 315)) {
        this.a.v = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahpz
 * JD-Core Version:    0.7.0.1
 */