import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.musicpendant.MusicPendantListener;
import com.tencent.mobileqq.musicpendant.MusicPendantManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

public class aetl
  implements Runnable
{
  public aetl(MusicPendantManager paramMusicPendantManager) {}
  
  public void run()
  {
    Card localCard = null;
    for (;;)
    {
      try
      {
        Object localObject2 = this.a.b();
        localObject1 = this.a.a();
        if (localObject1 != null)
        {
          localObject1 = (FriendsManager)((QQAppInterface)localObject1).getManager(50);
          if (localObject1 != null) {
            localCard = ((FriendsManager)localObject1).a((String)localObject2);
          }
          localObject1 = MusicPendantManager.a().iterator();
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (MusicPendantListener)((WeakReference)((Iterator)localObject1).next()).get();
            if (localObject2 == null) {
              continue;
            }
            ((MusicPendantListener)localObject2).a(localCard);
            continue;
          }
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.e("MusicPendantManager", 1, "setMusicPendantSongList().run() exception", localException);
      }
      Object localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aetl
 * JD-Core Version:    0.7.0.1
 */