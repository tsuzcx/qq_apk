import com.tencent.qphone.base.util.QLog;
import oicq.wlogin_sdk.request.Ticket;
import oicq.wlogin_sdk.request.WtTicketPromise;
import oicq.wlogin_sdk.tools.ErrMsg;

public final class ajzz
  implements WtTicketPromise
{
  public void Done(Ticket paramTicket)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SwiftBrowserCookieMonster", 2, "preGetKeyInPreloadService : Done");
    }
  }
  
  public void Failed(ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SwiftBrowserCookieMonster", 2, "preGetKeyInPreloadService failed " + paramErrMsg);
    }
  }
  
  public void Timeout(ErrMsg paramErrMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SwiftBrowserCookieMonster", 2, "preGetKeyInPreloadService timeout!" + paramErrMsg);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ajzz
 * JD-Core Version:    0.7.0.1
 */