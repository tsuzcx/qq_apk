import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCModule;
import eipc.EIPCResult;

public class afmo
  extends QIPCModule
  implements afmv
{
  private static volatile afmo a;
  
  public afmo(String paramString)
  {
    super(paramString);
  }
  
  public static afmo a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new afmo("QQNotifyIPCModule");
      }
      return a;
    }
    finally {}
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if ("newSubscribe".equals(paramString)) {}
    for (;;)
    {
      return EIPCResult.createResult(-100, null);
      if ("query".equals(paramString)) {
        afnn.b((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramBundle.getString("msgid"), new afmp(this, afmu.a(paramInt)));
      }
    }
  }
  
  public void queryHasSetNotify(Bundle paramBundle1, Bundle paramBundle2)
  {
    callbackResult(afmu.a(paramBundle2), EIPCResult.createResult(0, paramBundle1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afmo
 * JD-Core Version:    0.7.0.1
 */