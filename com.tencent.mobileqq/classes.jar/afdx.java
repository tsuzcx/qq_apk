import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

class afdx
  extends alwx
{
  afdx(afdq paramafdq) {}
  
  public void a(boolean paramBoolean1, List<MessageRecord> paramList, boolean paramBoolean2)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("MsgRevoke", 4, "onMsgRevokeNotice isSuccess=" + paramBoolean1);
    }
    boolean bool = afdq.a(this.a).a().e();
    afdq.a(this.a).a().removeMessages(267387140);
    ArrayList localArrayList = new ArrayList();
    if ((paramList != null) && (paramList.size() > 0))
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add((ChatMessage)localIterator.next());
      }
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("MsgRevoke", 4, "onMsgRevokeNotice chatlist=" + localArrayList.size());
    }
    afdq.a(this.a, paramBoolean1, paramBoolean2, bool, localArrayList);
    super.a(paramBoolean1, paramList, paramBoolean2);
  }
  
  public void a(boolean paramBoolean, String[] paramArrayOfString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIORevokeMsgHelper", 2, new Object[] { "[onGetTroopMsgFin], isSuc:", Boolean.valueOf(paramBoolean) });
    }
    if ((afdq.a(this.a) == null) || (afdq.a(this.a) == null) || (!paramBoolean)) {
      return;
    }
    ((aknt)afdq.a(this.a).getManager(211)).a(3, afdq.a(this.a).jdField_a_of_type_JavaLangString, afdq.a(this.a).jdField_a_of_type_Int);
  }
  
  public void b(int paramInt)
  {
    if ((afdq.a(this.a).jdField_a_of_type_Int == 0) || (afdq.a(this.a).jdField_a_of_type_Int == 3000) || (afdq.a(this.a).jdField_a_of_type_Int == 1)) {
      afdq.a(this.a, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afdx
 * JD-Core Version:    0.7.0.1
 */