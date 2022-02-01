import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.gdtad.jsbridge.GdtDeviceInfoJsCallHandler.1;
import java.lang.ref.WeakReference;

public class acuc
  implements acun
{
  public boolean a(acts paramacts, String paramString, String... paramVarArgs)
  {
    Object localObject = null;
    WeakReference localWeakReference = new WeakReference(paramacts);
    AdThreadManager.INSTANCE.post(new GdtDeviceInfoJsCallHandler.1(this, localWeakReference, paramVarArgs, paramString), 4);
    if (paramacts != null) {}
    for (paramString = paramacts.a();; paramString = null)
    {
      paramVarArgs = localObject;
      if (paramacts != null) {
        paramVarArgs = paramacts.a();
      }
      AdReporterForAnalysis.reportForJSBridgeInvoked(paramString, true, "getDeviceInfo", paramVarArgs);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acuc
 * JD-Core Version:    0.7.0.1
 */