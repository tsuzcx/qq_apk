import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.photo.AIOShortVideoData;
import com.tencent.mobileqq.shortvideo.redbag.RedBagVideoManager;
import com.tencent.mobileqq.shortvideo.redbag.VideoPlayIPCClient;

public class ahoy
  implements Runnable
{
  public ahoy(RedBagVideoManager paramRedBagVideoManager) {}
  
  public void run()
  {
    if (RedBagVideoManager.a(this.a) != null)
    {
      RedBagVideoManager.a(this.a).g = 1;
      long l = RedBagVideoManager.a(this.a).a;
      String str = RedBagVideoManager.a(this.a).e;
      int i = RedBagVideoManager.a(this.a).h;
      Bundle localBundle = new Bundle();
      localBundle.putLong("VALUE_MSG_UINSEQ", l);
      localBundle.putString("VALUE_MSG_FRIENDUIN", str);
      localBundle.putInt("VALUE_MSG_ISTROOP", i);
      localBundle.putString("VALUE_MSG_VIDEO_ID", RedBagVideoManager.a(this.a).c);
      VideoPlayIPCClient.a().a("CMD_UPDATE_MSG_FOR_VIDEO_REDBAG_STAT", localBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ahoy
 * JD-Core Version:    0.7.0.1
 */