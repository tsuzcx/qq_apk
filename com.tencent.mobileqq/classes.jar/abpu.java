import com.tencent.mobileqq.dating.HotChatFlashPicActivity;
import java.util.concurrent.atomic.AtomicBoolean;

public class abpu
  implements Runnable
{
  public abpu(HotChatFlashPicActivity paramHotChatFlashPicActivity) {}
  
  public void run()
  {
    if (HotChatFlashPicActivity.a(this.a)) {
      HotChatFlashPicActivity.c(this.a, HotChatFlashPicActivity.d(this.a));
    }
    HotChatFlashPicActivity.a(this.a).set(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abpu
 * JD-Core Version:    0.7.0.1
 */