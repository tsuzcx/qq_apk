import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.gdtad.jsbridge.GdtDeviceInfoJsCallHandler.1;
import java.lang.ref.WeakReference;

public class acgm
  implements acgx
{
  public boolean a(acfw paramacfw, String paramString, String... paramVarArgs)
  {
    Object localObject = null;
    WeakReference localWeakReference = new WeakReference(paramacfw);
    AdThreadManager.INSTANCE.post(new GdtDeviceInfoJsCallHandler.1(this, localWeakReference, paramVarArgs, paramString), 4);
    if (paramacfw != null) {}
    for (paramString = paramacfw.a();; paramString = null)
    {
      paramVarArgs = localObject;
      if (paramacfw != null) {
        paramVarArgs = paramacfw.a();
      }
      AdReporterForAnalysis.reportForJSBridgeInvoked(paramString, true, "getDeviceInfo", paramVarArgs);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acgm
 * JD-Core Version:    0.7.0.1
 */