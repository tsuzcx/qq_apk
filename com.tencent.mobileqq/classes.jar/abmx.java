import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.armap.ARMapManager;
import com.tencent.mobileqq.armap.ArMapInterface;
import com.tencent.mobileqq.armap.config.ARMapConfig;
import com.tencent.mobileqq.armap.ipc.IPCConstants;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import mqq.app.AppRuntime;

public final class abmx
  extends QIPCModule
{
  public abmx(String paramString)
  {
    super(paramString);
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    Bundle localBundle = null;
    AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
    if (!ArMapInterface.class.isInstance(localAppRuntime))
    {
      if (QLog.isColorLevel()) {
        QLog.e("ArMapIPC", 2, "[onCall] get app failed.");
      }
      callbackResult(paramInt, EIPCResult.createResult(-102, null));
      paramString = localBundle;
    }
    do
    {
      return paramString;
      localBundle = new Bundle();
      localBundle.putString("action", paramString);
      if (IPCConstants.e.equals(paramString))
      {
        paramString = (ARMapConfig)paramBundle.getParcelable("armap_config");
        if (paramString != null) {
          ((ARMapManager)((ArMapInterface)localAppRuntime).getManager(209)).a(paramString);
        }
      }
      paramBundle = EIPCResult.createResult(0, localBundle);
      paramString = paramBundle;
    } while (paramInt < 0);
    callbackResult(paramInt, paramBundle);
    return paramBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abmx
 * JD-Core Version:    0.7.0.1
 */