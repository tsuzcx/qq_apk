import com.tencent.mobileqq.richmedia.mediacodec.recorder.HWVideoRecorder;
import com.tencent.mobileqq.richmedia.mediacodec.utils.ThumbnailUtil.ThumbnailCallback;
import com.tencent.qphone.base.util.QLog;

public class ahtj
  implements ThumbnailUtil.ThumbnailCallback
{
  public ahtj(HWVideoRecorder paramHWVideoRecorder) {}
  
  public void a(boolean paramBoolean, String paramString)
  {
    HWVideoRecorder.a(this.a, true);
    if ((QLog.isColorLevel()) && (QLog.isColorLevel())) {
      QLog.d("HWVideoRecorder", 2, "Generate thumbnail result. success = " + paramBoolean + " ; file path = " + paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahtj
 * JD-Core Version:    0.7.0.1
 */