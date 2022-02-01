import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.ad.tangram.ipc.AdIPCManager;
import com.tencent.ad.tangram.ipc.AdIPCManager.Handler;
import com.tencent.ad.tangram.ipc.AdIPCManager.Params;
import com.tencent.ad.tangram.ipc.AdIPCManager.Result;
import com.tencent.ad.tangram.process.AdProcessManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qipc.QIPCModule;
import eipc.EIPCResult;

final class acnp
  extends QIPCModule
{
  private static volatile acnp a;
  
  private acnp(String paramString)
  {
    super(paramString);
  }
  
  public static acnp a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new acnp("gdt_ipc_module_server_to_client");
      }
      return a;
    }
    finally {}
  }
  
  public void callbackResult(int paramInt, EIPCResult paramEIPCResult)
  {
    if (paramEIPCResult != null) {}
    for (boolean bool = paramEIPCResult.isSuccess();; bool = false)
    {
      acvc.b("GdtIPCAdapter", String.format("ServerToClientIPCModule.callbackResult success:%b", new Object[] { Boolean.valueOf(bool) }));
      super.callbackResult(paramInt, paramEIPCResult);
      return;
    }
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    AdIPCManager.Params localParams = new AdIPCManager.Params(paramBundle);
    String str;
    if (localParams != null)
    {
      paramBundle = localParams.getAction();
      if (localParams == null) {
        break label70;
      }
      str = localParams.getToProcessName();
      label33:
      acvc.b("GdtIPCAdapter", String.format("ServerToClientIPCModule.onCall action:%s to:%s", new Object[] { paramBundle, str }));
      if (!TextUtils.isEmpty(paramString)) {
        break label76;
      }
    }
    label70:
    label76:
    do
    {
      do
      {
        return null;
        paramBundle = null;
        break;
        str = null;
        break label33;
      } while ((!localParams.isValid()) || (!TextUtils.equals(localParams.getAction(), paramString)) || (!TextUtils.equals(AdProcessManager.INSTANCE.getCurrentProcessName(BaseApplicationImpl.getContext()), localParams.getToProcessName())));
      paramString = AdIPCManager.INSTANCE.getHandler(paramString);
    } while (paramString == null);
    paramString = paramString.handle(localParams);
    paramBundle = new EIPCResult();
    int i;
    if ((paramString != null) && (paramString.success))
    {
      i = 0;
      paramBundle.code = i;
      if (paramString == null) {
        break label194;
      }
    }
    label194:
    for (paramString = paramString.bundle;; paramString = null)
    {
      paramBundle.data = paramString;
      callbackResult(paramInt, paramBundle);
      return null;
      i = -102;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acnp
 * JD-Core Version:    0.7.0.1
 */