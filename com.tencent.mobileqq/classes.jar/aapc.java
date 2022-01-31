import com.tencent.mobileqq.ark.API.ArkAppEventObserverManager;
import com.tencent.mobileqq.ark.API.ArkAppEventObserverManager.ConnectionCallback;

class aapc
  implements Runnable
{
  aapc(aaoz paramaaoz) {}
  
  public void run()
  {
    if ((ArkAppEventObserverManager.a(this.a.a) != null) && (!"wifi".equals(ArkAppEventObserverManager.a(this.a.a))))
    {
      ArkAppEventObserverManager.a(this.a.a).a(true, "wifi");
      ArkAppEventObserverManager.a(this.a.a, "wifi");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aapc
 * JD-Core Version:    0.7.0.1
 */