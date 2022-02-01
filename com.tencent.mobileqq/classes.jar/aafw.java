import com.tencent.biz.qqstory.utils.ffmpeg.FFmpegExecuteResponseCallback;
import com.tencent.qphone.base.util.QLog;

public class aafw
  implements FFmpegExecuteResponseCallback
{
  aafw(aafb paramaafb) {}
  
  public void a(boolean paramBoolean) {}
  
  public void onFailure(String paramString)
  {
    a(false);
    if (QLog.isColorLevel()) {
      QLog.d(".troop.VideoCombineHelper", 2, "ffmpeg onFailure" + paramString);
    }
  }
  
  public void onFinish(boolean paramBoolean) {}
  
  public void onProgress(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(".troop.VideoCombineHelper", 2, "ffmpeg onProgress" + paramString);
    }
  }
  
  public void onStart()
  {
    if (QLog.isColorLevel()) {
      QLog.d(".troop.VideoCombineHelper", 2, "ffmpeg onStart");
    }
  }
  
  public void onSuccess(String paramString)
  {
    a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aafw
 * JD-Core Version:    0.7.0.1
 */