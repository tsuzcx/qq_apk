import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

class aeyl
  extends aeye
{
  private void c(long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOrderManager", 2, "ForwardOrder realMapUniSeq newSeq -> " + paramLong1 + ", originSeq -> " + paramLong2 + ", forwardID -> " + this.jdField_a_of_type_Int);
    }
    if ((this.b != null) && (!this.b.isEmpty()) && (a(paramLong2, this.b)) && (this.jdField_a_of_type_JavaUtilHashMap != null))
    {
      this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(paramLong1), Long.valueOf(paramLong2));
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOrderManager", 2, "ForwardOrder realMapUniSeq map do put, forwardID -> " + this.jdField_a_of_type_Int);
      }
    }
  }
  
  void a(long paramLong1, long paramLong2)
  {
    if (a(paramLong2, this.b))
    {
      c(paramLong1, paramLong2);
      return;
    }
    a(paramLong1);
    c(paramLong1, paramLong1);
  }
  
  void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    if ((this.jdField_a_of_type_JavaUtilHashMap != null) && (this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramMessageRecord.uniseq)) != null))
    {
      paramMessageRecord = (Long)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramMessageRecord.uniseq));
      if ((paramMessageRecord != null) && (a(paramMessageRecord.longValue(), this.b)))
      {
        this.b.remove(paramMessageRecord);
        if ((this.b.size() <= 0) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null))
        {
          paramQQAppInterface = acex.a(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_JavaLangString = "";
          if ((paramQQAppInterface != null) && (paramQQAppInterface.length > 0)) {
            this.jdField_a_of_type_Long = paramQQAppInterface[0];
          }
        }
      }
    }
  }
  
  boolean a(long paramLong, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (Object localObject = this.b; (localObject != null) && (((Set)localObject).size() > 0); localObject = this.jdField_a_of_type_JavaUtilSet)
    {
      localObject = ((Set)localObject).iterator();
      long l;
      Long localLong;
      do
      {
        do
        {
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          l = ((Long)((Iterator)localObject).next()).longValue();
        } while ((this.jdField_a_of_type_JavaUtilHashMap == null) || (this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong)) == null));
        localLong = (Long)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
      } while ((localLong == null) || (localLong.longValue() <= 0L) || (localLong.longValue() != l));
      return true;
    }
    return false;
  }
  
  boolean a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    try
    {
      if ((this.jdField_a_of_type_JavaUtilHashMap != null) && (this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong)) != null))
      {
        Object localObject = (Long)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
        if ((localObject != null) && (a(((Long)localObject).longValue(), this.jdField_a_of_type_JavaUtilSet)))
        {
          this.jdField_a_of_type_JavaUtilSet.remove(localObject);
          if (QLog.isColorLevel()) {
            QLog.d("ForwardOrderManager", 2, "SeparateForwardOrder onSendResult mChatMsgListAfter remove originUniSeq " + localObject + "， mChatMsgListAfter.size() -> " + this.jdField_a_of_type_JavaUtilSet.size() + ", forwardID -> " + this.jdField_a_of_type_Int);
          }
          if ((this.jdField_a_of_type_JavaUtilSet.size() <= 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.jdField_a_of_type_Long > 0L))
          {
            localObject = paramQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_Long);
            if (localObject != null)
            {
              if (QLog.isColorLevel()) {
                QLog.d("ForwardOrderManager", 2, "SeparateForwardOrder onSendResult query msg and send, newSeq -> " + paramLong + ", forwardID -> " + this.jdField_a_of_type_Int);
              }
              paramQQAppInterface.a().b((MessageRecord)localObject, null, false);
              this.jdField_a_of_type_Long = 0L;
              a();
              return true;
            }
          }
        }
      }
      return false;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeyl
 * JD-Core Version:    0.7.0.1
 */