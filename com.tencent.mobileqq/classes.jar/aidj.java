import com.tencent.mobileqq.highway.api.ITransCallbackForReport;
import com.tencent.mobileqq.transfile.ShortVideoUploadProcessor;

public class aidj
  implements ITransCallbackForReport
{
  public aidj(ShortVideoUploadProcessor paramShortVideoUploadProcessor) {}
  
  public void onFailed(int paramInt, String paramString1, String paramString2)
  {
    this.a.a(false, this.a.j, paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aidj
 * JD-Core Version:    0.7.0.1
 */