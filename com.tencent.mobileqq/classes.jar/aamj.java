import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.ad.tangram.process.AdProcessManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qipc.QIPCModule;
import eipc.EIPCResult;

final class aamj
  extends QIPCModule
{
  private static volatile aamj a;
  
  private aamj(String paramString)
  {
    super(paramString);
  }
  
  public static aamj a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new aamj("gdt_ipc_module_server_to_client");
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
      aanp.b("GdtIPCManager", String.format("ServerToClientIPCModule.callbackResult success:%b", new Object[] { Boolean.valueOf(bool) }));
      super.callbackResult(paramInt, paramEIPCResult);
      return;
    }
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    aamh localaamh = new aamh(paramBundle);
    String str;
    if (localaamh != null)
    {
      paramBundle = localaamh.a();
      if (localaamh == null) {
        break label70;
      }
      str = localaamh.b();
      label33:
      aanp.b("GdtIPCManager", String.format("ServerToClientIPCModule.onCall action:%s to:%s", new Object[] { paramBundle, str }));
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
      } while ((!localaamh.a()) || (!TextUtils.equals(localaamh.a(), paramString)) || (!TextUtils.equals(AdProcessManager.INSTANCE.getCurrentProcessName(BaseApplicationImpl.getContext()), localaamh.b())));
      paramString = aama.a(aama.a(), paramString);
    } while (paramString == null);
    paramString = paramString.a(localaamh);
    paramBundle = new EIPCResult();
    int i;
    if ((paramString != null) && (paramString.jdField_a_of_type_Boolean))
    {
      i = 0;
      paramBundle.code = i;
      if (paramString == null) {
        break label194;
      }
    }
    label194:
    for (paramString = paramString.jdField_a_of_type_AndroidOsBundle;; paramString = null)
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
 * Qualified Name:     aamj
 * JD-Core Version:    0.7.0.1
 */