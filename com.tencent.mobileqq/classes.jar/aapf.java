import com.tencent.mobileqq.ark.API.ArkAppEventObserverManager;
import com.tencent.mobileqq.ark.API.ArkAppEventObserverManager.ConnectionCallback;

class aapf
  implements Runnable
{
  aapf(aaoz paramaaoz) {}
  
  public void run()
  {
    if ((ArkAppEventObserverManager.a(this.a.a) != null) && (!"none".equals(ArkAppEventObserverManager.a(this.a.a))))
    {
      ArkAppEventObserverManager.a(this.a.a).a(true, "none");
      ArkAppEventObserverManager.a(this.a.a, "none");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aapf
 * JD-Core Version:    0.7.0.1
 */