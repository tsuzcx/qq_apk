import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.gdtad.web.GdtLandingPageReport.3.1;

public class aclf
  implements acli
{
  aclf(acld paramacld) {}
  
  public void a(String paramString)
  {
    acho.d("GdtLandingPageReport", " webviewGetPerformanceResult onResponse ==" + paramString);
    if ((paramString != null) && (!paramString.equals("null")))
    {
      AdThreadManager.INSTANCE.post(new GdtLandingPageReport.3.1(this, paramString), 4);
      acho.d("GdtLandingPageReport", " webviewGetPerformanceResult report response ==" + paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aclf
 * JD-Core Version:    0.7.0.1
 */