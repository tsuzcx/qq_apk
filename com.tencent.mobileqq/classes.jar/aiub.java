import com.tencent.mobileqq.highway.api.ITransCallbackForReport;
import com.tencent.mobileqq.transfile.C2CPicUploadProcessor;

public class aiub
  implements ITransCallbackForReport
{
  public aiub(C2CPicUploadProcessor paramC2CPicUploadProcessor) {}
  
  public void onFailed(int paramInt, String paramString1, String paramString2)
  {
    this.a.a(false, this.a.j, paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiub
 * JD-Core Version:    0.7.0.1
 */