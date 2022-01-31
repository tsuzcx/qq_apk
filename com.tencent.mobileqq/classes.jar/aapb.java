import com.tencent.mobileqq.ark.API.ArkAppEventObserverManager;
import com.tencent.mobileqq.ark.API.ArkAppEventObserverManager.ConnectionCallback;

class aapb
  implements Runnable
{
  aapb(aaoz paramaaoz) {}
  
  public void run()
  {
    if ((ArkAppEventObserverManager.a(this.a.a) != null) && (!"cellular".equals(ArkAppEventObserverManager.a(this.a.a))))
    {
      ArkAppEventObserverManager.a(this.a.a).a(true, "cellular");
      ArkAppEventObserverManager.a(this.a.a, "cellular");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aapb
 * JD-Core Version:    0.7.0.1
 */