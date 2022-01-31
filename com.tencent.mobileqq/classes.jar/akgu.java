import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.musicpendant.MusicPendantManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.MusicPendantView;

public class akgu
  implements Runnable
{
  public akgu(MusicPendantView paramMusicPendantView) {}
  
  public void run()
  {
    Card localCard = MusicPendantManager.a().a();
    if ((localCard != null) && (localCard.autoPlayMusicPendant) && (!NetworkUtil.b(BaseApplicationImpl.getContext()))) {
      MusicPendantManager.a().b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     akgu
 * JD-Core Version:    0.7.0.1
 */