import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarManager;
import com.tencent.mobileqq.util.DynamicFaceDrawable;
import mqq.os.MqqHandler;

public class abql
  implements Runnable
{
  public abql(DynamicAvatarManager paramDynamicAvatarManager) {}
  
  public void run()
  {
    synchronized (DynamicFaceDrawable.a)
    {
      DynamicFaceDrawable.b = false;
      ThreadManager.getUIHandler().post(new abqm(this));
      this.a.c();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abql
 * JD-Core Version:    0.7.0.1
 */