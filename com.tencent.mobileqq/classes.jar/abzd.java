import com.tencent.mobileqq.confess.ConfessManager;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.qphone.base.util.QLog;

public final class abzd
  implements Runnable
{
  public abzd(ConfessManager paramConfessManager, String paramString, abyz paramabyz, long paramLong1, long paramLong2) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqConfessConfessManager.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Abyz, this.jdField_a_of_type_Long, this.jdField_a_of_type_Long, this.b);
    if (QLog.isColorLevel())
    {
      long l = MessageCache.a();
      QLog.i("ConfessMsgUtil", 2, "decodeConfessMsgElem 1 strConfessorDesc:" + this.jdField_a_of_type_Abyz.f + " msgTime:" + this.jdField_a_of_type_Long + " msgSeq:" + this.b + " nowTime" + l);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abzd
 * JD-Core Version:    0.7.0.1
 */