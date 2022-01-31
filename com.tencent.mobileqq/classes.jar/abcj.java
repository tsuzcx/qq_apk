import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarManager;
import com.tencent.mobileqq.util.DynamicFaceDrawable;
import mqq.os.MqqHandler;

public class abcj
  implements Runnable
{
  public abcj(DynamicAvatarManager paramDynamicAvatarManager) {}
  
  public void run()
  {
    synchronized (DynamicFaceDrawable.a)
    {
      DynamicFaceDrawable.b = false;
      ThreadManager.getUIHandler().post(new abck(this));
      this.a.c();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     abcj
 * JD-Core Version:    0.7.0.1
 */