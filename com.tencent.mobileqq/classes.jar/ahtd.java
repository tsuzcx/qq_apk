import com.tencent.device.datadef.DeviceInfo;
import com.tencent.mobileqq.activity.contacts.fragment.DeviceFragment;
import java.util.ArrayList;

public class ahtd
  extends zto
{
  public ahtd(DeviceFragment paramDeviceFragment) {}
  
  protected void a(ArrayList<DeviceInfo> paramArrayList)
  {
    if (this.a.e)
    {
      this.a.e = false;
      if (this.a.jdField_a_of_type_Ahsy != null) {
        this.a.jdField_a_of_type_Ahsy.a(this.a.b(), true, null);
      }
    }
    if (this.a.jdField_a_of_type_Ahrp == null) {
      return;
    }
    this.a.jdField_a_of_type_Ahrp.a = ((ArrayList)paramArrayList.clone());
    this.a.jdField_a_of_type_Ahrp.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahtd
 * JD-Core Version:    0.7.0.1
 */