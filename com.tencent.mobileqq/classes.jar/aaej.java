import com.tencent.mobileqq.ar.ARRecord.ARRecordUtils;
import com.tencent.mobileqq.ar.ARRecord.VideoEncoderUtils;
import com.tencent.mobileqq.arcard.ARCardCameraRecordFragment;
import com.tencent.mobileqq.arcard.ARCardCamereButtonLayout.CaptureButtonListener;
import com.tencent.qphone.base.util.QLog;

public class aaej
  implements ARCardCamereButtonLayout.CaptureButtonListener
{
  public aaej(ARCardCameraRecordFragment paramARCardCameraRecordFragment) {}
  
  public void a()
  {
    QLog.d("ARCardCameraRecordFragment", 2, "onCaptureButtonPhoto");
  }
  
  public void b()
  {
    QLog.d("ARCardCameraRecordFragment", 2, "onCaptureButtonVideoStart");
    if (!VideoEncoderUtils.a()) {
      ARRecordUtils.a("该机型不支持录制，无法参与活动", true);
    }
    do
    {
      return;
      if (!ARRecordUtils.a(104857600L))
      {
        ARRecordUtils.a("无法录制", "sdcard剩余空间不足");
        return;
      }
    } while (this.a.b());
    ARRecordUtils.a("录制间隔太短，请稍候重试", true);
  }
  
  public void c()
  {
    QLog.d("ARCardCameraRecordFragment", 2, "onCaptureButtonVideoStop");
    this.a.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aaej
 * JD-Core Version:    0.7.0.1
 */