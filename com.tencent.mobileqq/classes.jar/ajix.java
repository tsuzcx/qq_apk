import com.tencent.device.datadef.DeviceInfo;
import com.tencent.mobileqq.activity.contacts.device.DeviceFragment;
import java.util.ArrayList;

public class ajix
  extends abqm
{
  public ajix(DeviceFragment paramDeviceFragment) {}
  
  protected void a(ArrayList<DeviceInfo> paramArrayList)
  {
    if (this.a.e)
    {
      this.a.e = false;
      if (DeviceFragment.a(this.a) != null) {
        DeviceFragment.b(this.a).a(this.a.b(), true, null);
      }
    }
    if (this.a.a == null) {
      return;
    }
    this.a.a.a = ((ArrayList)paramArrayList.clone());
    this.a.a.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajix
 * JD-Core Version:    0.7.0.1
 */