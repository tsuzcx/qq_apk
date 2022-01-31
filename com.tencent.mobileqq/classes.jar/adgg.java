import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class adgg
  extends adge
{
  void a(long paramLong1, long paramLong2)
  {
    if (this.b == null)
    {
      this.b = new HashSet();
      this.b.add(Long.valueOf(paramLong1));
      if (this.jdField_a_of_type_JavaUtilSet != null) {
        break label77;
      }
      this.jdField_a_of_type_JavaUtilSet = new HashSet();
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilSet.add(Long.valueOf(paramLong1));
      return;
      this.b.clear();
      break;
      label77:
      this.jdField_a_of_type_JavaUtilSet.clear();
    }
  }
  
  void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    if ((this.b != null) && (this.b.size() > 0) && (a(this.jdField_a_of_type_JavaUtilSet) == paramMessageRecord.uniseq) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null))
    {
      paramQQAppInterface = aaod.a(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_JavaLangString = "";
      if ((paramQQAppInterface != null) && (paramQQAppInterface.length > 0)) {
        this.jdField_a_of_type_Long = paramQQAppInterface[0];
      }
    }
  }
  
  boolean a(long paramLong, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (Object localObject = this.b; (localObject != null) && (((Set)localObject).size() > 0); localObject = this.jdField_a_of_type_JavaUtilSet)
    {
      localObject = ((Set)localObject).iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
      } while (((Long)((Iterator)localObject).next()).longValue() != paramLong);
      return true;
    }
    return false;
  }
  
  boolean a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_JavaUtilSet != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_JavaUtilSet.size() > 0)
      {
        bool1 = bool2;
        if (a(this.jdField_a_of_type_JavaUtilSet) == paramLong)
        {
          bool1 = bool2;
          if (a(this.jdField_a_of_type_JavaUtilSet) == paramLong)
          {
            bool1 = bool2;
            if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null)
            {
              bool1 = bool2;
              if (this.jdField_a_of_type_Long > 0L)
              {
                MessageRecord localMessageRecord = paramQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_Long);
                if (localMessageRecord != null) {
                  paramQQAppInterface.a().b(localMessageRecord, null, false);
                }
                this.jdField_a_of_type_Long = 0L;
                a();
                bool1 = true;
              }
            }
          }
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adgg
 * JD-Core Version:    0.7.0.1
 */