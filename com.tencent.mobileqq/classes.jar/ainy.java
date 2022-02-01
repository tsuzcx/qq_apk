import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.StructLongMessageDownloadProcessor;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0xc96.oidb_cmd0xc96.RspBody;

class ainy
  extends apee
{
  ainy(ainh paramainh, String paramString) {}
  
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
        QLog.d(this.jdField_a_of_type_Ainh.jdField_a_of_type_JavaLangString, 2, new Object[] { "0xc96 responseBody success, wording=", paramObject.wording.get() });
      }
      ainh.a(this.jdField_a_of_type_Ainh, ainh.a(this.jdField_a_of_type_Ainh));
      ocd.a(this.jdField_a_of_type_Ainh.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.jdField_a_of_type_JavaLangString, "0X8005A2D", "0X8005A2D", 0, 0, "", "", "", "", false);
      StructLongMessageDownloadProcessor.a(this.jdField_a_of_type_Ainh.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString);
      ((bgre)this.jdField_a_of_type_Ainh.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(132)).a(this.jdField_a_of_type_Ainh.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      ainh.b(this.jdField_a_of_type_Ainh, false);
      if ((this.jdField_a_of_type_Ainh.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.jdField_a_of_type_Ainh.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramObject.appid.get() + ""))) {
        this.jdField_a_of_type_Ainh.b(1);
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_Ainh.c(this.jdField_a_of_type_Ainh.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent());
  }
  
  public void a(boolean paramBoolean, Object paramObject) {}
  
  public void b(Object paramObject)
  {
    this.jdField_a_of_type_Ainh.A(2131694659);
  }
  
  public void b(boolean paramBoolean, Object paramObject)
  {
    ainh.c(this.jdField_a_of_type_Ainh);
    if (ainh.d(this.jdField_a_of_type_Ainh) == 0) {
      this.jdField_a_of_type_Ainh.bp();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ainy
 * JD-Core Version:    0.7.0.1
 */