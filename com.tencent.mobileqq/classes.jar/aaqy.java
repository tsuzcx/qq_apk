import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.ad.tangram.process.AdProcessManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qipc.QIPCModule;
import eipc.EIPCResult;

final class aaqy
  extends QIPCModule
{
  private static volatile aaqy a;
  
  private aaqy(String paramString)
  {
    super(paramString);
  }
  
  public static aaqy a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new aaqy("gdt_ipc_module_server_to_client");
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
      aase.b("GdtIPCManager", String.format("ServerToClientIPCModule.callbackResult success:%b", new Object[] { Boolean.valueOf(bool) }));
      super.callbackResult(paramInt, paramEIPCResult);
      return;
    }
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    aaqw localaaqw = new aaqw(paramBundle);
    String str;
    if (localaaqw != null)
    {
      paramBundle = localaaqw.a();
      if (localaaqw == null) {
        break label70;
      }
      str = localaaqw.b();
      label33:
      aase.b("GdtIPCManager", String.format("ServerToClientIPCModule.onCall action:%s to:%s", new Object[] { paramBundle, str }));
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
      } while ((!localaaqw.a()) || (!TextUtils.equals(localaaqw.a(), paramString)) || (!TextUtils.equals(AdProcessManager.INSTANCE.getCurrentProcessName(BaseApplicationImpl.getContext()), localaaqw.b())));
      paramString = aaqp.a(aaqp.a(), paramString);
    } while (paramString == null);
    paramString = paramString.a(localaaqw);
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
 * Qualified Name:     aaqy
 * JD-Core Version:    0.7.0.1
 */