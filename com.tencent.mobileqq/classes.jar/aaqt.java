import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.ad.tangram.process.AdProcessManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import eipc.EIPCResult;

public final class aaqt
  extends QIPCModule
{
  private static volatile aaqt a;
  
  private aaqt(String paramString)
  {
    super(paramString);
  }
  
  public static aaqt a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new aaqt("gdt_ipc_module_client_to_server");
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
      aase.b("GdtIPCManager", String.format("ClientToServerIPCModule.callbackResult success:%b", new Object[] { Boolean.valueOf(bool) }));
      super.callbackResult(paramInt, paramEIPCResult);
      return;
    }
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    aaqw localaaqw = new aaqw(paramBundle);
    String str1;
    String str2;
    if (localaaqw != null)
    {
      str1 = localaaqw.a();
      if (localaaqw == null) {
        break label73;
      }
      str2 = localaaqw.b();
      label34:
      aase.b("GdtIPCManager", String.format("ClientToServerIPCModule.onCall action:%s to:%s", new Object[] { str1, str2 }));
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
        return null;
        str1 = null;
        break;
        str2 = null;
        break label34;
      } while ((!localaaqw.a()) || (!TextUtils.equals(localaaqw.a(), paramString)));
      str1 = AdProcessManager.INSTANCE.getCurrentProcessName(BaseApplicationImpl.getContext());
      paramString = aaqp.a(aaqp.a(), paramString);
      if (!TextUtils.equals(str1, localaaqw.b())) {
        break label206;
      }
    } while (paramString == null);
    paramString = paramString.a(localaaqw);
    paramBundle = new EIPCResult();
    int i;
    if ((paramString != null) && (paramString.jdField_a_of_type_Boolean))
    {
      i = 0;
      paramBundle.code = i;
      if (paramString == null) {
        break label201;
      }
    }
    label201:
    for (paramString = paramString.jdField_a_of_type_AndroidOsBundle;; paramString = null)
    {
      paramBundle.data = paramString;
      callbackResult(paramInt, paramBundle);
      return null;
      i = -102;
      break;
    }
    label206:
    QIPCServerHelper.getInstance().callClient(localaaqw.b(), "gdt_ipc_module_server_to_client", localaaqw.a(), paramBundle, new aaqu(this, localaaqw, paramInt));
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaqt
 * JD-Core Version:    0.7.0.1
 */