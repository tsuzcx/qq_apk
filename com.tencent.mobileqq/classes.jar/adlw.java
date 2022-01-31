import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.biz.common.util.OpenIdObserver;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.mobileqq.forward.ForwardAbility.ForwardAbilityType;
import com.tencent.mobileqq.forward.ForwardSdkShareOption;
import com.tencent.qphone.base.util.QLog;

public class adlw
  extends OpenIdObserver
{
  public adlw(ForwardSdkShareOption paramForwardSdkShareOption) {}
  
  protected void a(boolean paramBoolean, OpenID paramOpenID)
  {
    if ((this.a.jdField_a_of_type_AndroidAppActivity.isFinishing()) || (this.a.h)) {}
    do
    {
      return;
      this.a.t();
      if (this.a.jdField_a_of_type_AndroidOsHandler != null) {
        this.a.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      }
      if ((paramBoolean) && (paramOpenID != null) && (paramOpenID.openID != null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ForwardOption.ForwardSdkShareOption", 2, "openIdObserver success");
        }
        if (!paramOpenID.openID.equals(this.a.f))
        {
          if (QLog.isColorLevel()) {
            QLog.w("ForwardOption.ForwardSdkShareOption", 2, "-->onGetOpenId--openid doesn't equal current openid");
          }
          this.a.z();
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("ForwardOption.ForwardSdkShareOption", 2, "openIdObserver fail");
      }
    } while (!ForwardSdkShareOption.a(this.a));
    this.a.jdField_a_of_type_AndroidOsBundle.putString("uin", String.valueOf("-1010"));
    this.a.jdField_a_of_type_AndroidOsBundle.putInt("uintype", -1);
    this.a.jdField_a_of_type_AndroidOsBundle.putInt("key_forward_ability_type", ForwardAbility.ForwardAbilityType.e.intValue());
    this.a.j();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     adlw
 * JD-Core Version:    0.7.0.1
 */