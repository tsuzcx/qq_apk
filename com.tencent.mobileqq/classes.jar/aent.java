import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.qphone.base.util.QLog;

class aent
  extends akav
{
  aent(aeno paramaeno) {}
  
  protected void a(String paramString1, int paramInt1, int paramInt2, SendMessageHandler paramSendMessageHandler, long paramLong1, long paramLong2, String paramString2, int paramInt3)
  {
    if ((paramString1 == null) || (!paramString1.equals(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) || (paramInt1 != this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int) || (paramInt3 != this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "onUpdateSendMsgError_confess err uin " + paramString1 + " type " + paramInt1 + " uniseq " + paramLong2 + " topicId " + paramInt3);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "onUpdateSendMsgError_confess uin " + paramString1 + " type " + paramInt1 + " uniseq " + paramLong2 + " errorCode " + paramInt2 + " topicId " + paramInt3);
    }
    this.a.e(196608);
  }
  
  protected void a(boolean paramBoolean, String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    if ((paramString == null) || (!paramString.equals(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) || (paramInt1 != this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int) || (paramInt2 != this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.e))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "onSendResult_confess err uin " + paramString + " type " + paramInt1 + " uniseq " + paramLong + " topicId " + paramInt2);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "onSendResult_confess uin " + paramString + " type " + paramInt1 + " uniseq " + paramLong + " topicId " + paramInt2);
    }
    this.a.u = true;
    this.a.a(262144, null, paramLong);
  }
  
  protected void c(boolean paramBoolean, String paramString)
  {
    this.a.e(65536);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aent
 * JD-Core Version:    0.7.0.1
 */