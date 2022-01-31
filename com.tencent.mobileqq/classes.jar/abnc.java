import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.armap.config.ARMapConfigManager;
import com.tencent.mobileqq.armap.ipc.ArMapIPCProxy;
import com.tencent.mobileqq.armap.ipc.IPCConstants;
import com.tencent.mobileqq.armap.wealthgod.WealthGodInfo;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

public class abnc
  extends QIPCModule
{
  public abnc(ArMapIPCProxy paramArMapIPCProxy, String paramString)
  {
    super(paramString);
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (!QQAppInterface.class.isInstance(BaseApplicationImpl.sApplication.getRuntime()))
    {
      if (QLog.isColorLevel()) {
        QLog.e("ArMapIPCProxy", 2, "[onCall] get app failed.");
      }
      callbackResult(paramInt, EIPCResult.createResult(-102, null));
      paramString = null;
      return paramString;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("action", paramString);
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    if ((ArMapIPCProxy.a(this.a) == null) || (localQQAppInterface != ArMapIPCProxy.a(this.a)))
    {
      if (QLog.isColorLevel()) {
        QLog.e("ArMapIPCProxy", 2, "[onCall] app changed. app:" + ArMapIPCProxy.a(this.a) + "  lastly:" + localQQAppInterface);
      }
      ArMapIPCProxy.a(this.a, localQQAppInterface);
    }
    if (paramString.equals(IPCConstants.f))
    {
      paramString = ((ARMapConfigManager)ArMapIPCProxy.a(this.a).getManager(189)).a();
      if (paramString != null) {
        localBundle.putParcelable("armap_config", paramString);
      }
    }
    for (;;)
    {
      paramBundle = EIPCResult.createResult(0, localBundle);
      paramString = paramBundle;
      if (paramInt < 0) {
        break;
      }
      callbackResult(paramInt, paramBundle);
      return paramBundle;
      if (paramString.equals(IPCConstants.g))
      {
        if (paramBundle != null)
        {
          paramString = (ARMapConfigManager)ArMapIPCProxy.a(this.a).getManager(189);
          paramBundle.setClassLoader(WealthGodInfo.class.getClassLoader());
          long l = paramBundle.getLong(IPCConstants.i);
          double d1 = paramBundle.getDouble(IPCConstants.j);
          double d2 = paramBundle.getDouble(IPCConstants.k);
          paramBundle = (WealthGodInfo)paramBundle.getParcelable(IPCConstants.l);
          if (QLog.isColorLevel()) {
            QLog.d("ArMapIPCProxy", 2, String.format("ACTION_SYNC_ARMAP_INFO adCode=%s longitude=%s latitude=%s wealthGodInfo=%s", new Object[] { Long.valueOf(l), Double.valueOf(d1), Double.valueOf(d2), paramBundle }));
          }
          if (l > 0L) {
            paramString.a(l, true);
          }
          if ((d1 > 0.0D) && (d2 > 0.0D)) {
            paramString.a(d1, d2);
          }
          if (paramBundle != null) {
            paramString.a(paramBundle);
          }
        }
      }
      else if (paramString.equals(IPCConstants.h))
      {
        paramString = (ARMapConfigManager)ArMapIPCProxy.a(this.a).getManager(189);
        if (QLog.isColorLevel()) {
          QLog.d("ArMapIPCProxy", 2, "ACTION_NOTIFY_ENTER_ARMAP mapConfigManager=" + paramString + " app:" + ArMapIPCProxy.a(this.a));
        }
        paramString.d();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abnc
 * JD-Core Version:    0.7.0.1
 */