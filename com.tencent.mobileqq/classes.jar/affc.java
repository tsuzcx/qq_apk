import com.tencent.device.datadef.DeviceInfo;
import com.tencent.mobileqq.activity.contacts.fragment.DeviceFragment;
import java.util.ArrayList;

public class affc
  extends xrg
{
  public affc(DeviceFragment paramDeviceFragment) {}
  
  protected void a(ArrayList<DeviceInfo> paramArrayList)
  {
    if (this.a.e)
    {
      this.a.e = false;
      if (this.a.jdField_a_of_type_Afex != null) {
        this.a.jdField_a_of_type_Afex.a(this.a.b(), true, null);
      }
    }
    if (this.a.jdField_a_of_type_Afdp == null) {
      return;
    }
    this.a.jdField_a_of_type_Afdp.a = ((ArrayList)paramArrayList.clone());
    this.a.jdField_a_of_type_Afdp.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     affc
 * JD-Core Version:    0.7.0.1
 */