import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.StructLongMessageDownloadProcessor;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0xc96.oidb_cmd0xc96.RspBody;

class aesk
  extends akws
{
  aesk(aert paramaert, String paramString) {}
  
  public int a()
  {
    return 5;
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof oidb_cmd0xc96.RspBody))
    {
      paramObject = (oidb_cmd0xc96.RspBody)paramObject;
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_Aert.jdField_a_of_type_JavaLangString, 2, new Object[] { "0xc96 responseBody success, wording=", paramObject.wording.get() });
      }
      aert.a(this.jdField_a_of_type_Aert, aert.a(this.jdField_a_of_type_Aert));
      nol.a(this.jdField_a_of_type_Aert.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.jdField_a_of_type_JavaLangString, "0X8005A2D", "0X8005A2D", 0, 0, "", "", "", "", false);
      StructLongMessageDownloadProcessor.a(this.jdField_a_of_type_Aert.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString);
      ((bajo)this.jdField_a_of_type_Aert.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(132)).a(this.jdField_a_of_type_Aert.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      aert.b(this.jdField_a_of_type_Aert, false);
      if ((this.jdField_a_of_type_Aert.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.jdField_a_of_type_Aert.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramObject.appid.get() + ""))) {
        this.jdField_a_of_type_Aert.b(1);
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_Aert.c(this.jdField_a_of_type_Aert.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent());
  }
  
  public void a(boolean paramBoolean, Object paramObject) {}
  
  public void b(Object paramObject)
  {
    this.jdField_a_of_type_Aert.B(2131695569);
  }
  
  public void b(boolean paramBoolean, Object paramObject)
  {
    aert.c(this.jdField_a_of_type_Aert);
    if (aert.d(this.jdField_a_of_type_Aert) == 0) {
      this.jdField_a_of_type_Aert.bp();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aesk
 * JD-Core Version:    0.7.0.1
 */