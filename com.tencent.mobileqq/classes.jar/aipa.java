import com.tencent.mobileqq.activity.contacts.device.DeviceFragment;
import com.tencent.mobileqq.app.AppConstants;

public class aipa
  extends amwl
{
  public aipa(DeviceFragment paramDeviceFragment) {}
  
  protected void onSelfIpadOnlineStatusUpdateNotify(int paramInt1, int paramInt2)
  {
    if (this.a.a == null) {
      return;
    }
    DeviceFragment localDeviceFragment = this.a;
    if (paramInt1 != 0) {}
    for (boolean bool = true;; bool = false)
    {
      localDeviceFragment.d = bool;
      this.a.a.e();
      this.a.a.a(this.a.d, AppConstants.DATALINE_IPAD_UIN);
      this.a.a.notifyDataSetChanged();
      return;
    }
  }
  
  protected void onSelfPcOnlineStatusUpdateNotify(int paramInt1, int paramInt2)
  {
    if (this.a.a == null) {
      return;
    }
    DeviceFragment localDeviceFragment = this.a;
    if (paramInt1 != 0) {}
    for (boolean bool = true;; bool = false)
    {
      localDeviceFragment.c = bool;
      this.a.a.d();
      this.a.a.notifyDataSetChanged();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aipa
 * JD-Core Version:    0.7.0.1
 */