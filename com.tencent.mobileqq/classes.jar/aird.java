import com.tencent.mobileqq.activity.qwallet.RedPacketEmojiFragment;
import com.tencent.mobileqq.activity.qwallet.RedPacketEmojiFragment.4.1;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.PathResult;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class aird
  implements aivw
{
  public aird(RedPacketEmojiFragment paramRedPacketEmojiFragment) {}
  
  public void onResult(int paramInt, PreloadManager.PathResult paramPathResult)
  {
    ThreadManager.getUIHandler().post(new RedPacketEmojiFragment.4.1(this, paramInt, paramPathResult));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aird
 * JD-Core Version:    0.7.0.1
 */