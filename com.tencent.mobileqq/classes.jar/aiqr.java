import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DPCObserver;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.transfile.RichMediaStrategy.OldEngineDPCProfile;

public class aiqr
  implements DeviceProfileManager.DPCObserver
{
  public aiqr(RichMediaStrategy.OldEngineDPCProfile paramOldEngineDPCProfile) {}
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      String str = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.HttpTimeoutParam.name());
      this.a.a(str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiqr
 * JD-Core Version:    0.7.0.1
 */