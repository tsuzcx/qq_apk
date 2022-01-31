import com.tencent.mobileqq.ar.ARRecord.ARRecordUtils;
import com.tencent.mobileqq.ar.ARRecord.VideoEncoderUtils;
import com.tencent.mobileqq.arcard.ARCardCameraRecordFragment;
import com.tencent.mobileqq.arcard.ARCardCamereButtonLayout.CaptureButtonListener;
import com.tencent.qphone.base.util.QLog;

public class aase
  implements ARCardCamereButtonLayout.CaptureButtonListener
{
  public aase(ARCardCameraRecordFragment paramARCardCameraRecordFragment) {}
  
  public void a()
  {
    QLog.d("ARCardCameraRecordFragment", 2, "onCaptureButtonPhoto");
  }
  
  public void b()
  {
    QLog.d("ARCardCameraRecordFragment", 2, "onCaptureButtonVideoStart");
    if (!VideoEncoderUtils.a())
    {
      ARRecordUtils.a("该机型不支持录制，无法参与活动", true);
      return;
    }
    if (!ARRecordUtils.a(104857600L))
    {
      ARRecordUtils.a("无法录制", "sdcard剩余空间不足");
      return;
    }
    if (!this.a.b())
    {
      ARCardCameraRecordFragment.a(this.a, false);
      ARRecordUtils.a("录制间隔太短，请稍候重试", true);
      return;
    }
    ARCardCameraRecordFragment.a(this.a, true);
  }
  
  public void c()
  {
    QLog.d("ARCardCameraRecordFragment", 2, "onCaptureButtonVideoStop");
    this.a.c();
    ARCardCameraRecordFragment.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aase
 * JD-Core Version:    0.7.0.1
 */