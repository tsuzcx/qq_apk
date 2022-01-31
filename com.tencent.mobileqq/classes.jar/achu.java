import com.tencent.mobileqq.emosm.favroaming.FavroamingManager;
import com.tencent.mobileqq.emosm.favroaming.SyncListener;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class achu
  implements Runnable
{
  public achu(FavroamingManager paramFavroamingManager) {}
  
  public void run()
  {
    int i = 0;
    while (i < this.a.a.size())
    {
      if (this.a.a.get(i) != null)
      {
        SyncListener localSyncListener = (SyncListener)((WeakReference)this.a.a.get(i)).get();
        if (localSyncListener != null)
        {
          localSyncListener.a(null, FavroamingManager.a(), FavroamingManager.a().get());
          if (QLog.isColorLevel()) {
            QLog.i("FavroamingManager", 2, "now notify listener on file done!");
          }
        }
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     achu
 * JD-Core Version:    0.7.0.1
 */