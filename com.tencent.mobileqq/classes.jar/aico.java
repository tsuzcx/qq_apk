import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DPCObserver;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.transfile.RichMediaStrategy.OldEngineDPCProfile;

public class aico
  implements DeviceProfileManager.DPCObserver
{
  public aico(RichMediaStrategy.OldEngineDPCProfile paramOldEngineDPCProfile) {}
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      String str = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.HttpTimeoutParam.name());
      this.a.a(str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     aico
 * JD-Core Version:    0.7.0.1
 */