import com.tencent.av.avgesture.AVGestureWrapper.AVUploadReport;
import com.tencent.mobileqq.shortvideo.facedancegame.GestureDetectManager;
import com.tencent.sveffects.Reporter;
import com.tencent.sveffects.SdkContext;

public class ahnb
  implements AVGestureWrapper.AVUploadReport
{
  public ahnb(GestureDetectManager paramGestureDetectManager) {}
  
  public void avGestureUploadReport(String paramString1, String paramString2)
  {
    SdkContext.a().a().a("dc00898", "", paramString1, paramString1, 0, 0, "", "", paramString2, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahnb
 * JD-Core Version:    0.7.0.1
 */