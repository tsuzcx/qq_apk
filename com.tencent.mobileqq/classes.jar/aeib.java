import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.aio.PlusPanel;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0xc96.oidb_cmd0xc96.RspBody;

class aeib
  extends akih
{
  boolean jdField_a_of_type_Boolean;
  
  aeib(aegy paramaegy) {}
  
  public int a()
  {
    return 4;
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof oidb_cmd0xc96.RspBody))
    {
      paramObject = (oidb_cmd0xc96.RspBody)paramObject;
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_Aegy.jdField_a_of_type_JavaLangString, 2, new Object[] { "0xc96 responseBody success, wording=", paramObject.wording.get() });
      }
      ndn.a(this.jdField_a_of_type_Aegy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0x8005750", "0x8005750", 0, 0, this.jdField_a_of_type_Aegy.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "", false);
      paramObject = (ajoy)this.jdField_a_of_type_Aegy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56);
      if (paramObject == null) {
        break label256;
      }
      paramObject = paramObject.a(this.jdField_a_of_type_Aegy.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if (paramObject == null) {
        break label240;
      }
      if (this.jdField_a_of_type_Aegy.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler == null) {
        this.jdField_a_of_type_Aegy.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler = ((PublicAccountHandler)this.jdField_a_of_type_Aegy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(11));
      }
      this.jdField_a_of_type_Aegy.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler.a(paramObject);
    }
    for (;;)
    {
      this.jdField_a_of_type_Aegy.T = true;
      this.jdField_a_of_type_Aegy.Y = true;
      this.jdField_a_of_type_Aegy.bo();
      if ((this.jdField_a_of_type_Aegy.an) && (aegy.c(this.jdField_a_of_type_Aegy) != null)) {
        aegy.d(this.jdField_a_of_type_Aegy).d();
      }
      this.jdField_a_of_type_Aegy.c(this.jdField_a_of_type_Aegy.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent());
      return;
      label240:
      this.jdField_a_of_type_Aegy.D();
      this.jdField_a_of_type_Boolean = false;
      continue;
      label256:
      this.jdField_a_of_type_Aegy.D();
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  public void a(boolean paramBoolean, Object paramObject)
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void b(Object paramObject)
  {
    this.jdField_a_of_type_Aegy.B(2131629887);
  }
  
  public void b(boolean paramBoolean, Object paramObject)
  {
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Aegy.bn();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aeib
 * JD-Core Version:    0.7.0.1
 */