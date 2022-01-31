import android.os.SystemClock;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;

public class ajwl
  implements Runnable
{
  public ajwl(TroopFileTransferManager paramTroopFileTransferManager) {}
  
  public void run()
  {
    for (;;)
    {
      synchronized (this.a)
      {
        if (TroopFileTransferManager.a(this.a) == 0L) {
          return;
        }
        if (SystemClock.uptimeMillis() > TroopFileTransferManager.a(this.a) + 10000L)
        {
          TroopFileTransferManager.a(this.a, 0L);
          this.a.a();
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajwl
 * JD-Core Version:    0.7.0.1
 */