import com.tencent.mobileqq.troop.utils.TroopNameHelper;
import java.util.concurrent.ConcurrentLinkedQueue;

public abstract class ajxr
  implements Runnable
{
  public volatile boolean a;
  
  public ajxr(TroopNameHelper paramTroopNameHelper) {}
  
  public abstract void a();
  
  public final void run()
  {
    this.a = true;
    a();
    this.a = false;
    this.b.a.remove(this);
    TroopNameHelper.a(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajxr
 * JD-Core Version:    0.7.0.1
 */