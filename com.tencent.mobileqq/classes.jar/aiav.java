import com.tencent.mobileqq.highway.api.ITransCallbackForReport;
import com.tencent.mobileqq.transfile.C2CPicUploadProcessor;

public class aiav
  implements ITransCallbackForReport
{
  public aiav(C2CPicUploadProcessor paramC2CPicUploadProcessor) {}
  
  public void onFailed(int paramInt, String paramString1, String paramString2)
  {
    this.a.a(false, this.a.j, paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aiav
 * JD-Core Version:    0.7.0.1
 */