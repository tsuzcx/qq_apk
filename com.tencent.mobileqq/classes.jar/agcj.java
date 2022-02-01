import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qipc.QIPCModule;
import eipc.EIPCResult;

public class agcj
  extends QIPCModule
  implements agcq
{
  private static volatile agcj a;
  
  public agcj(String paramString)
  {
    super(paramString);
  }
  
  public static agcj a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new agcj("QQNotifyIPCModule");
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
        agdi.c((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramBundle.getString("msgid"), new agck(this, agcp.a(paramInt)));
      }
    }
  }
  
  public void queryHasSetNotify(Bundle paramBundle1, Bundle paramBundle2)
  {
    callbackResult(agcp.a(paramBundle2), EIPCResult.createResult(0, paramBundle1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agcj
 * JD-Core Version:    0.7.0.1
 */