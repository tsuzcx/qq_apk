import com.tencent.mobileqq.hotpic.VideoItemEventManager.onVideoItemEventListener;
import com.tencent.mobileqq.leba.LebaFeedsVideoPlayController;
import com.tencent.mobileqq.leba.LebaFeedsVideoPlayer;
import com.tencent.qphone.base.util.QLog;

public class aehi
  implements VideoItemEventManager.onVideoItemEventListener
{
  public aehi(LebaFeedsVideoPlayController paramLebaFeedsVideoPlayController) {}
  
  public void a() {}
  
  public void a(int paramInt)
  {
    LebaFeedsVideoPlayController.a(this.a, 1000L);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("LebaFeedsVideoPlayController", 2, "onVolumChange");
    }
    boolean bool;
    int i;
    if ((LebaFeedsVideoPlayController.a(this.a) != null) && (LebaFeedsVideoPlayController.a(this.a)) && (LebaFeedsVideoPlayController.a(this.a) != null))
    {
      bool = LebaFeedsVideoPlayController.a(this.a).c();
      if ((LebaFeedsVideoPlayController.a(this.a) == null) || (!LebaFeedsVideoPlayController.a(this.a).b())) {
        break label115;
      }
      i = 1;
      if (i == 0) {
        break label120;
      }
      LebaFeedsVideoPlayController.a(this.a).a(true);
      LebaFeedsVideoPlayController.a(this.a, true);
      LebaFeedsVideoPlayController.a(this.a, true);
    }
    label115:
    label120:
    while (!bool)
    {
      return;
      i = 0;
      break;
    }
    LebaFeedsVideoPlayController.a(this.a).a(false);
    LebaFeedsVideoPlayController.a(this.a, false);
    LebaFeedsVideoPlayController.a(this.a, false);
  }
  
  public void b(boolean paramBoolean) {}
  
  public void c(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aehi
 * JD-Core Version:    0.7.0.1
 */