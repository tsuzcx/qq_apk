import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

abstract class agfd
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  String jdField_a_of_type_JavaLangString;
  HashMap<Long, Long> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  Set<Long> jdField_a_of_type_JavaUtilSet;
  Set<Long> b;
  
  long a(Set<Long> paramSet)
  {
    if ((paramSet != null) && (paramSet.size() > 0))
    {
      paramSet = paramSet.toArray();
      if ((paramSet != null) && (paramSet.length > 0))
      {
        paramSet = paramSet[0];
        if ((paramSet instanceof Long)) {
          return ((Long)paramSet).longValue();
        }
      }
    }
    return 0L;
  }
  
  agfd a(SessionInfo paramSessionInfo, String paramString, List<Long> paramList, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_JavaLangString = paramString;
    if (paramList != null)
    {
      this.jdField_a_of_type_JavaUtilSet = new HashSet(paramList);
      this.b = new HashSet(paramList);
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOrderManager", 2, "Forward order onPreForward mChatMsgListAfter.size() -> " + this.jdField_a_of_type_JavaUtilSet.size() + ", mChatMsgListBefore.size() -> " + this.b.size() + ", ForwardID -> " + paramInt);
      }
    }
    return this;
  }
  
  void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOrderManager", 2, "ForwardOrder onDestroy forward id -> " + this.jdField_a_of_type_Int);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = null;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Long = 0L;
    if (this.jdField_a_of_type_JavaUtilSet != null)
    {
      this.jdField_a_of_type_JavaUtilSet.clear();
      this.jdField_a_of_type_JavaUtilSet = null;
    }
    if (this.b != null)
    {
      this.b.clear();
      this.b = null;
    }
    if (this.jdField_a_of_type_JavaUtilHashMap != null)
    {
      this.jdField_a_of_type_JavaUtilHashMap.clear();
      this.jdField_a_of_type_JavaUtilHashMap = null;
    }
  }
  
  void a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOrderManager", 2, "ForwardOrder msgIDToSend id -> " + paramLong);
    }
    if (this.jdField_a_of_type_JavaUtilSet != null)
    {
      this.jdField_a_of_type_JavaUtilSet.add(Long.valueOf(paramLong));
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOrderManager", 2, "ForwardOrder mChatMsgListAfter add id -> " + paramLong);
      }
    }
    if (this.b != null)
    {
      this.b.add(Long.valueOf(paramLong));
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOrderManager", 2, "ForwardOrder mChatMsgListBefore add id -> " + paramLong);
      }
    }
  }
  
  abstract void a(long paramLong1, long paramLong2);
  
  void a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    try
    {
      if ((this.b != null) && (this.b.size() > 0))
      {
        Iterator localIterator = this.b.iterator();
        while (localIterator.hasNext()) {
          if (((Long)localIterator.next()).longValue() == paramLong) {
            localIterator.remove();
          }
        }
        if ((this.b.size() <= 0) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null))
        {
          paramQQAppInterface = admh.a(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_JavaLangString = "";
          if ((paramQQAppInterface != null) && (paramQQAppInterface.length > 0)) {
            this.jdField_a_of_type_Long = paramQQAppInterface[0];
          }
        }
      }
      return;
    }
    finally {}
  }
  
  abstract void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord);
  
  boolean a(long paramLong, Set<Long> paramSet)
  {
    if (paramSet != null) {}
    try
    {
      if (!paramSet.isEmpty())
      {
        paramSet = paramSet.iterator();
        while (paramSet.hasNext()) {
          if (((Long)paramSet.next()).longValue() == paramLong) {
            return true;
          }
        }
      }
      return false;
    }
    finally {}
  }
  
  abstract boolean a(long paramLong, boolean paramBoolean);
  
  abstract boolean a(QQAppInterface paramQQAppInterface, long paramLong);
  
  void b(long paramLong1, long paramLong2)
  {
    if ((this.jdField_a_of_type_JavaUtilSet != null) && (this.jdField_a_of_type_JavaUtilSet.size() > 0) && (this.jdField_a_of_type_JavaUtilSet.contains(Long.valueOf(paramLong1))))
    {
      this.jdField_a_of_type_JavaUtilSet.remove(Long.valueOf(paramLong1));
      this.jdField_a_of_type_JavaUtilSet.add(Long.valueOf(paramLong2));
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOrderManager", 2, "Forward order replaceOriginChatMsg mChatMsgListAfter.size() -> " + this.jdField_a_of_type_JavaUtilSet.size() + ", mChatMsgListAfter remove uniSeq -> " + paramLong1 + ", mChatMsgListAfter add uniSeq -> " + paramLong2 + ", ForwardID -> " + this.jdField_a_of_type_Int);
      }
    }
    if ((this.b != null) && (this.b.size() > 0) && (this.b.contains(Long.valueOf(paramLong1))))
    {
      this.b.remove(Long.valueOf(paramLong1));
      this.b.add(Long.valueOf(paramLong2));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agfd
 * JD-Core Version:    0.7.0.1
 */