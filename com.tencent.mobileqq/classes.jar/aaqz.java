import android.os.Bundle;
import com.tencent.ad.tangram.ipc.AdIPCManager;
import com.tencent.ad.tangram.ipc.AdIPCManager.Params;
import com.tencent.ad.tangram.ipc.AdIPCManager.Result;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtBaseAdItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCModule;
import eipc.EIPCResult;

public class aaqz
  extends QIPCModule
{
  private static volatile aaqz a;
  
  private aaqz(String paramString)
  {
    super(paramString);
  }
  
  public static aaqz a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new aaqz("gdt_ipc");
      }
      return a;
    }
    finally {}
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    aase.b("gdt_ipc", "Action  " + paramString);
    if ("do_app_jump".equals(paramString))
    {
      if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface))
      {
        paramString = (aasf)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a(110);
        paramBundle.setClassLoader(getClass().getClassLoader());
        paramBundle = (GdtBaseAdItem)paramBundle.getParcelable("gdtBaseAdItem");
        paramString.a(BaseApplicationImpl.getContext(), paramBundle);
        callbackResult(paramInt, EIPCResult.createSuccessResult(null));
      }
      for (;;)
      {
        return null;
        callbackResult(paramInt, EIPCResult.createResult(-1, null));
      }
    }
    AdIPCManager.Params localParams = new AdIPCManager.Params();
    localParams.bundle = paramBundle;
    paramString = AdIPCManager.INSTANCE.receive(paramString, localParams);
    if (paramString == null) {
      return null;
    }
    paramBundle = new EIPCResult();
    if (paramString.success) {}
    for (paramInt = 0;; paramInt = -102)
    {
      paramBundle.code = paramInt;
      paramBundle.data = paramString.bundle;
      return paramBundle;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaqz
 * JD-Core Version:    0.7.0.1
 */