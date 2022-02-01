import com.tencent.biz.subscribe.fragments.SubscribeVideoDetailFragment;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISuperPlayer;

public class aalr
  extends vxr
{
  public aalr(SubscribeVideoDetailFragment paramSubscribeVideoDetailFragment) {}
  
  public void a(ISuperPlayer paramISuperPlayer)
  {
    try
    {
      if (QQPlayerService.a()) {
        QQPlayerService.c(this.a.getActivity());
      }
      return;
    }
    catch (Exception paramISuperPlayer)
    {
      if (QLog.isColorLevel()) {
        QLog.e("SubscribeVideoDetailFragment", 2, "QQPlayerService.stopPlayMusic exception!", paramISuperPlayer);
      }
      paramISuperPlayer.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aalr
 * JD-Core Version:    0.7.0.1
 */