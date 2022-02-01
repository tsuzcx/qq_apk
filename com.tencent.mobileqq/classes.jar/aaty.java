import com.tencent.qphone.base.util.QLog;

public class aaty
  implements zqq
{
  aaty(aatd paramaatd) {}
  
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
 * Qualified Name:     aaty
 * JD-Core Version:    0.7.0.1
 */