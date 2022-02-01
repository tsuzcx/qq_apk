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

public final class acjk
  extends QIPCModule
{
  private static volatile acjk a;
  
  private acjk(String paramString)
  {
    super(paramString);
  }
  
  public static acjk a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new acjk("gdt_ipc_sync_module_client_to_server");
      }
      return a;
    }
    finally {}
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    Object localObject2 = null;
    AdIPCManager.Params localParams = new AdIPCManager.Params(paramBundle);
    if (localParams != null)
    {
      paramBundle = localParams.getAction();
      if (localParams == null) {
        break label73;
      }
      localObject1 = localParams.getToProcessName();
      label36:
      acqy.b("GdtIPCAdapter", String.format("ClientToServerIPCSyncModule.onCall action:%s to:%s", new Object[] { paramBundle, localObject1 }));
      if (!TextUtils.isEmpty(paramString)) {
        break label79;
      }
    }
    label73:
    label79:
    do
    {
      do
      {
        do
        {
          return null;
          paramBundle = null;
          break;
          localObject1 = null;
          break label36;
        } while ((!localParams.isValid()) || (!TextUtils.equals(localParams.getAction(), paramString)));
        paramBundle = AdProcessManager.INSTANCE.isOnMainProcess();
      } while ((paramBundle == null) || (!paramBundle.booleanValue()) || (!TextUtils.equals(AdProcessManager.INSTANCE.getCurrentProcessName(BaseApplicationImpl.getContext()), localParams.getToProcessName())));
      paramString = AdIPCManager.INSTANCE.getHandler(paramString);
    } while (paramString == null);
    Object localObject1 = paramString.handle(localParams);
    paramBundle = new EIPCResult();
    if ((localObject1 != null) && (((AdIPCManager.Result)localObject1).success)) {}
    for (paramInt = 0;; paramInt = -102)
    {
      paramBundle.code = paramInt;
      paramString = localObject2;
      if (localObject1 != null) {
        paramString = ((AdIPCManager.Result)localObject1).bundle;
      }
      paramBundle.data = paramString;
      return paramBundle;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acjk
 * JD-Core Version:    0.7.0.1
 */