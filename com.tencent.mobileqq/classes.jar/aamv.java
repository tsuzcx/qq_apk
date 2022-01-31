import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.gdtad.jsbridge.GdtDeviceInfoJsCallHandler.1;
import java.lang.ref.WeakReference;

public class aamv
  implements aanf
{
  public boolean a(aamm paramaamm, String paramString, String... paramVarArgs)
  {
    Object localObject = null;
    WeakReference localWeakReference = new WeakReference(paramaamm);
    AdThreadManager.INSTANCE.post(new GdtDeviceInfoJsCallHandler.1(this, localWeakReference, paramVarArgs, paramString), 4);
    if (paramaamm != null) {}
    for (paramString = paramaamm.a();; paramString = null)
    {
      paramVarArgs = localObject;
      if (paramaamm != null) {
        paramVarArgs = paramaamm.a();
      }
      AdReporterForAnalysis.reportForJSBridgeInvoked(paramString, true, "getDeviceInfo", paramVarArgs);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aamv
 * JD-Core Version:    0.7.0.1
 */