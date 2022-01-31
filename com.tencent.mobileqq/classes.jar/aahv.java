import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.ark.API.ArkAppEventObserverManager;
import com.tencent.mobileqq.ark.API.ArkAppEventObserverManager.PositionCallback;

class aahv
  implements Runnable
{
  aahv(aaht paramaaht) {}
  
  public void run()
  {
    if (ArkAppEventObserverManager.a(this.a.a) != null) {
      ArkAppEventObserverManager.a(this.a.a).a(false, 0.0D, 0.0D);
    }
    SosoInterface.b(ArkAppEventObserverManager.a(this.a.a));
    ArkAppEventObserverManager.a(this.a.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aahv
 * JD-Core Version:    0.7.0.1
 */