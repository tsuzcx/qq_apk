import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.aio.PlusPanel;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0xc96.oidb_cmd0xc96.RspBody;

class aesw
  extends akws
{
  boolean jdField_a_of_type_Boolean;
  
  aesw(aert paramaert) {}
  
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
        QLog.d(this.jdField_a_of_type_Aert.jdField_a_of_type_JavaLangString, 2, new Object[] { "0xc96 responseBody success, wording=", paramObject.wording.get() });
      }
      nol.a(this.jdField_a_of_type_Aert.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0x8005750", "0x8005750", 0, 0, this.jdField_a_of_type_Aert.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "", false);
      paramObject = (akdh)this.jdField_a_of_type_Aert.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56);
      if (paramObject == null) {
        break label256;
      }
      paramObject = paramObject.a(this.jdField_a_of_type_Aert.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if (paramObject == null) {
        break label240;
      }
      if (this.jdField_a_of_type_Aert.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler == null) {
        this.jdField_a_of_type_Aert.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler = ((PublicAccountHandler)this.jdField_a_of_type_Aert.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(11));
      }
      this.jdField_a_of_type_Aert.jdField_a_of_type_ComTencentMobileqqAppPublicAccountHandler.a(paramObject);
    }
    for (;;)
    {
      this.jdField_a_of_type_Aert.T = true;
      this.jdField_a_of_type_Aert.Y = true;
      this.jdField_a_of_type_Aert.bq();
      if ((this.jdField_a_of_type_Aert.an) && (aert.c(this.jdField_a_of_type_Aert) != null)) {
        aert.d(this.jdField_a_of_type_Aert).d();
      }
      this.jdField_a_of_type_Aert.c(this.jdField_a_of_type_Aert.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent());
      return;
      label240:
      this.jdField_a_of_type_Aert.D();
      this.jdField_a_of_type_Boolean = false;
      continue;
      label256:
      this.jdField_a_of_type_Aert.D();
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  public void a(boolean paramBoolean, Object paramObject)
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void b(Object paramObject)
  {
    this.jdField_a_of_type_Aert.B(2131695569);
  }
  
  public void b(boolean paramBoolean, Object paramObject)
  {
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Aert.bp();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aesw
 * JD-Core Version:    0.7.0.1
 */