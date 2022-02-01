import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtBaseAdItem;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCModule;
import eipc.EIPCResult;

public class acfu
  extends QIPCModule
{
  private static volatile acfu a;
  
  private acfu(String paramString)
  {
    super(paramString);
  }
  
  public static acfu a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new acfu("gdt_ipc");
      }
      return a;
    }
    finally {}
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    acho.b("gdt_ipc", "Action  " + paramString);
    if ("do_app_jump".equals(paramString))
    {
      if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface))
      {
        paramString = (achp)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getBusinessHandler(BusinessHandlerFactory.GDT_AD_HANDLER);
        paramBundle.setClassLoader(getClass().getClassLoader());
        paramBundle = (GdtBaseAdItem)paramBundle.getParcelable("gdtBaseAdItem");
        paramString.a(BaseApplicationImpl.getContext(), paramBundle);
        callbackResult(paramInt, EIPCResult.createSuccessResult(null));
      }
    }
    else {
      return null;
    }
    callbackResult(paramInt, EIPCResult.createResult(-1, null));
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acfu
 * JD-Core Version:    0.7.0.1
 */