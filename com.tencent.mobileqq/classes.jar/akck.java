import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class akck
  extends ajzy
{
  public akck(QQAppInterface paramQQAppInterface, QQMessageFacade paramQQMessageFacade)
  {
    super(paramQQAppInterface, paramQQMessageFacade);
  }
  
  public long a(MessageRecord paramMessageRecord)
  {
    return 0L;
  }
  
  public void a(MessageRecord paramMessageRecord, atmp paramatmp, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, ajzz paramajzz)
  {
    if (paramMessageRecord == null) {
      return;
    }
    if (paramMessageRecord.time == 0L) {
      paramMessageRecord.time = awao.a();
    }
    if (paramMessageRecord.msgseq == 0L) {
      paramMessageRecord.msgseq = ((int)paramMessageRecord.time);
    }
    a(paramMessageRecord, true, 1);
  }
  
  public void a(String paramString, int paramInt, List<MessageRecord> paramList1, List<MessageRecord> paramList2, Bundle paramBundle) {}
  
  public void a(String paramString, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageManager", 2, "SubMessageManager setReaded uin=" + paramString + ",type=" + paramInt1 + ",needDelMark=" + paramBoolean2);
    }
    if (paramString == null) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "SubMessageManager setReaded return : uin=null");
      }
    }
    label120:
    do
    {
      do
      {
        return;
        if (!ajed.x.equals(paramString)) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageManager", 2, "SubMessageManager setReaded return : clean all");
        }
        paramString = (axat)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(61);
      } while (paramString == null);
      paramString = paramString.a().iterator();
      Object localObject1;
      Object localObject2;
      akaq localakaq;
      while (paramString.hasNext())
      {
        localObject1 = (String)paramString.next();
        if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((String)localObject1, paramInt1) > 0))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageManager", 2, "SubMessageManager setReaded clean one uin = " + (String)localObject1);
          }
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a((String)localObject1, paramInt1);
          localakaq = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
          if (localObject2 == null) {
            break label274;
          }
        }
      }
      for (long l = a((MessageRecord)localObject2);; l = 0L)
      {
        localakaq.a((String)localObject1, paramInt1, l, paramBoolean1, paramBoolean2);
        a((String)localObject1, paramInt1);
        this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a((String)localObject1, paramInt1));
        break label120;
        break;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramInt1) > 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageManager", 2, "SubMessageManager setReaded clean only one, uin = " + paramString);
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1).a(paramString, paramInt1);
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        if (localObject1 != null) {}
        for (l = a((MessageRecord)localObject1);; l = 0L)
        {
          ((akaq)localObject2).a(paramString, paramInt1, l, paramBoolean1, paramBoolean2);
          a(paramString, paramInt1);
          this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(paramString, paramInt1));
          return;
        }
      }
    } while (!QLog.isColorLevel());
    label274:
    QLog.d("Q.msg.BaseMessageManager", 2, "SubMessageManager setReaded unread=0, no clean");
  }
  
  public void b(String paramString, int paramInt1, int paramInt2, akcg paramakcg) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akck
 * JD-Core Version:    0.7.0.1
 */