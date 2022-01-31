import com.tencent.mobileqq.troop.utils.TroopNameHelper;
import java.util.concurrent.ConcurrentLinkedQueue;

public abstract class ajca
  implements Runnable
{
  public volatile boolean a;
  
  public ajca(TroopNameHelper paramTroopNameHelper) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     ajca
 * JD-Core Version:    0.7.0.1
 */