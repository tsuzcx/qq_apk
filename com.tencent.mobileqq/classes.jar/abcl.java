import com.tencent.mobileqq.app.DeviceProfileManager.DPCObserver;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarManager;
import mqq.util.WeakReference;

public class abcl
  implements DeviceProfileManager.DPCObserver
{
  WeakReference a;
  
  public abcl(DynamicAvatarManager paramDynamicAvatarManager)
  {
    this.a = new WeakReference(paramDynamicAvatarManager);
  }
  
  public void a(boolean paramBoolean)
  {
    DynamicAvatarManager localDynamicAvatarManager = (DynamicAvatarManager)this.a.get();
    if (localDynamicAvatarManager != null) {
      localDynamicAvatarManager.a(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     abcl
 * JD-Core Version:    0.7.0.1
 */