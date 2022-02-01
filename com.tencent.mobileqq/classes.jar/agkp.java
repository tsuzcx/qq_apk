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

class agkp
  extends anqd
{
  agkp(agki paramagki) {}
  
  public void a(boolean paramBoolean1, List<MessageRecord> paramList, boolean paramBoolean2)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("MsgRevoke", 4, "onMsgRevokeNotice isSuccess=" + paramBoolean1);
    }
    boolean bool = agki.a(this.a).a().e();
    agki.a(this.a).a().removeMessages(267387140);
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
    agki.a(this.a, paramBoolean1, paramBoolean2, bool, localArrayList);
    super.a(paramBoolean1, paramList, paramBoolean2);
  }
  
  public void a(boolean paramBoolean, String[] paramArrayOfString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIORevokeMsgHelper", 2, new Object[] { "[onGetTroopMsgFin], isSuc:", Boolean.valueOf(paramBoolean) });
    }
    if ((agki.a(this.a) == null) || (agki.a(this.a) == null) || (!paramBoolean)) {
      return;
    }
    ((amgz)agki.a(this.a).getManager(211)).a(3, agki.a(this.a).jdField_a_of_type_JavaLangString, agki.a(this.a).jdField_a_of_type_Int);
  }
  
  public void b(int paramInt)
  {
    if ((agki.a(this.a).jdField_a_of_type_Int == 0) || (agki.a(this.a).jdField_a_of_type_Int == 3000) || (agki.a(this.a).jdField_a_of_type_Int == 1)) {
      agki.a(this.a, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agkp
 * JD-Core Version:    0.7.0.1
 */