import com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;

public final class akwc
  implements Runnable
{
  public void run()
  {
    if (SwiftBrowserCookieMonster.a == null) {
      synchronized (SwiftBrowserCookieMonster.a())
      {
        if (SwiftBrowserCookieMonster.a == null)
        {
          Object localObject1 = MobileQQ.sMobileQQ.waitAppRuntime(null);
          if (localObject1 != null)
          {
            localObject1 = (TicketManager)((AppRuntime)localObject1).getManager(2);
            if (localObject1 != null)
            {
              SwiftBrowserCookieMonster.a = new akwd();
              ((TicketManager)localObject1).registTicketManagerListener(SwiftBrowserCookieMonster.a);
            }
          }
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akwc
 * JD-Core Version:    0.7.0.1
 */