import com.tencent.device.datadef.DeviceInfo;
import com.tencent.mobileqq.activity.contacts.fragment.DeviceFragment;
import java.util.ArrayList;

public class afqx
  extends yag
{
  public afqx(DeviceFragment paramDeviceFragment) {}
  
  protected void a(ArrayList<DeviceInfo> paramArrayList)
  {
    if (this.a.e)
    {
      this.a.e = false;
      if (this.a.jdField_a_of_type_Afqs != null) {
        this.a.jdField_a_of_type_Afqs.a(this.a.b(), true, null);
      }
    }
    if (this.a.jdField_a_of_type_Afpj == null) {
      return;
    }
    this.a.jdField_a_of_type_Afpj.a = ((ArrayList)paramArrayList.clone());
    this.a.jdField_a_of_type_Afpj.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afqx
 * JD-Core Version:    0.7.0.1
 */