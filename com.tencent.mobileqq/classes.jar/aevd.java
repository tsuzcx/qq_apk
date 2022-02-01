import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCModule;
import eipc.EIPCResult;

public class aevd
  extends QIPCModule
  implements aevk
{
  private static volatile aevd a;
  
  public aevd(String paramString)
  {
    super(paramString);
  }
  
  public static aevd a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new aevd("QQNotifyIPCModule");
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
        aewc.c((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramBundle.getString("msgid"), new aeve(this, aevj.a(paramInt)));
      }
    }
  }
  
  public void queryHasSetNotify(Bundle paramBundle1, Bundle paramBundle2)
  {
    callbackResult(aevj.a(paramBundle2), EIPCResult.createResult(0, paramBundle1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aevd
 * JD-Core Version:    0.7.0.1
 */