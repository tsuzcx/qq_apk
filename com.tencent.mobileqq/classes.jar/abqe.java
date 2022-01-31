import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarManager;
import com.tencent.mobileqq.shortvideo.ShortVideoResDownload;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;

public class abqe
  implements Runnable
{
  public abqe(DynamicAvatarManager paramDynamicAvatarManager) {}
  
  public void run()
  {
    if ((!VideoEnvironment.e(DynamicAvatarManager.a(this.a))) && ((DynamicAvatarManager.a(this.a) instanceof QQAppInterface))) {
      ShortVideoResDownload.a((QQAppInterface)DynamicAvatarManager.a(this.a), false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abqe
 * JD-Core Version:    0.7.0.1
 */