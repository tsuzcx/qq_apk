import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtBaseAdItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCModule;
import eipc.EIPCResult;

public class actq
  extends QIPCModule
{
  private static volatile actq a;
  
  private actq(String paramString)
  {
    super(paramString);
  }
  
  public static actq a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new actq("gdt_ipc");
      }
      return a;
    }
    finally {}
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    acvc.b("gdt_ipc", "Action  " + paramString);
    if ("do_app_jump".equals(paramString))
    {
      if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface))
      {
        paramString = (acvd)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a(110);
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
 * Qualified Name:     actq
 * JD-Core Version:    0.7.0.1
 */