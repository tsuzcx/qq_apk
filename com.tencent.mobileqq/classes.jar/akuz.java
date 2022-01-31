import android.os.Handler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.musicpendant.MusicPendantManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.ArcImageView;
import com.tencent.mobileqq.widget.MusicPendantView;
import com.tencent.qphone.base.util.QLog;

class akuz
  implements Runnable
{
  akuz(akuy paramakuy) {}
  
  public void run()
  {
    Object localObject;
    try
    {
      QQAppInterface localQQAppInterface = MusicPendantManager.a().a();
      if (MusicPendantView.a(this.a.a) != null) {
        MusicPendantView.a(this.a.a).removeMessages(1001);
      }
      localObject = MusicPendantManager.a();
      if ((localObject != null) && (((MusicPendantManager)localObject).a())) {
        ReportController.b(localQQAppInterface, "CliOper", "", "", "0X8006A78", "0X8006A78", 0, 0, "", "", "", "");
      }
      while ((localObject != null) && (((MusicPendantManager)localObject).a()) && ((((MusicPendantManager)localObject).a() == null) || (1 > ((MusicPendantManager)localObject).a().length)))
      {
        this.a.a.b();
        return;
        ReportController.b(localQQAppInterface, "CliOper", "", "", "0X8006A8C", "0X8006A8C", 0, 0, "", "", "", "");
      }
      if (localObject == null) {
        break label159;
      }
    }
    catch (Exception localException)
    {
      QLog.e("MusicPendantView", 1, "mPlayClickListener.onClick() exception", localException);
      return;
    }
    ((MusicPendantManager)localObject).c();
    label159:
    if (MusicPendantView.a(this.a.a) != null) {
      MusicPendantView.a(this.a.a).sendEmptyMessage(1005);
    }
    if ((MusicPendantView.a(this.a.a) != null) && (MusicPendantView.a(this.a.a).a()))
    {
      MusicPendantView.a(this.a.a).a(false);
      MusicPendantView.a(true);
      FriendsManager localFriendsManager;
      label264:
      MusicPendantManager localMusicPendantManager;
      if (localException != null)
      {
        localFriendsManager = (FriendsManager)localException.getManager(50);
        if (localFriendsManager == null) {
          break label325;
        }
        localObject = localFriendsManager.a(((MusicPendantManager)localObject).b());
        if ((localObject == null) || (!((Card)localObject).showRedPointMusicPendant)) {
          return;
        }
        localMusicPendantManager = MusicPendantManager.a();
        if (!((Card)localObject).showRedPointMusicPendant) {
          break label330;
        }
      }
      label325:
      label330:
      for (int i = 0;; i = 1)
      {
        localMusicPendantManager.a(4059, i);
        ((Card)localObject).showRedPointMusicPendant = false;
        if (localFriendsManager.a((Card)localObject)) {
          return;
        }
        QLog.e("MusicPendantView", 1, "onClick(): save card in db failed ");
        return;
        localFriendsManager = null;
        break;
        localObject = null;
        break label264;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akuz
 * JD-Core Version:    0.7.0.1
 */