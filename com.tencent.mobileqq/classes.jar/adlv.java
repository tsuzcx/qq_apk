import android.app.Activity;
import android.os.Bundle;
import com.tencent.mobileqq.forward.ForwardAbility.ForwardAbilityType;
import com.tencent.mobileqq.forward.ForwardSdkShareOption;
import com.tencent.qphone.base.util.QLog;

public class adlv
  implements Runnable
{
  public adlv(ForwardSdkShareOption paramForwardSdkShareOption) {}
  
  public void run()
  {
    if (this.a.jdField_a_of_type_AndroidAppActivity.isFinishing()) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.w("ForwardOption.ForwardSdkShareOption", 2, "-->preForward--fetch openid timeout");
      }
      this.a.h = true;
      this.a.t();
    } while (!ForwardSdkShareOption.a(this.a));
    this.a.jdField_a_of_type_AndroidOsBundle.putString("uin", String.valueOf("-1010"));
    this.a.jdField_a_of_type_AndroidOsBundle.putInt("uintype", -1);
    this.a.jdField_a_of_type_AndroidOsBundle.putInt("key_forward_ability_type", ForwardAbility.ForwardAbilityType.e.intValue());
    this.a.j();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     adlv
 * JD-Core Version:    0.7.0.1
 */