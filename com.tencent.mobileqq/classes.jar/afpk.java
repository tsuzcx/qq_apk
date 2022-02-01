import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

class afpk
  extends amwl
{
  afpk(afpd paramafpd) {}
  
  public void onGetTroopMsgFin(boolean paramBoolean, String[] paramArrayOfString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIORevokeMsgHelper", 2, new Object[] { "[onGetTroopMsgFin], isSuc:", Boolean.valueOf(paramBoolean) });
    }
    if ((afpd.a(this.a) == null) || (afpd.a(this.a) == null) || (!paramBoolean)) {
      return;
    }
    ((alnn)afpd.a(this.a).getManager(211)).a(3, afpd.a(this.a).curFriendUin, afpd.a(this.a).curType);
  }
  
  public void onMsgForwardWXResult(int paramInt)
  {
    if ((afpd.a(this.a).curType == 0) || (afpd.a(this.a).curType == 3000) || (afpd.a(this.a).curType == 1)) {
      afpd.a(this.a, paramInt);
    }
  }
  
  public void onMsgRevokeNotice(boolean paramBoolean1, List<MessageRecord> paramList, boolean paramBoolean2)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("MsgRevoke", 4, "onMsgRevokeNotice isSuccess=" + paramBoolean1);
    }
    boolean bool = afpd.a(this.a).getMsgCache().e();
    afpd.a(this.a).getUIHandler().removeMessages(267387140);
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
    afpd.a(this.a, paramBoolean1, paramBoolean2, bool, localArrayList);
    super.onMsgRevokeNotice(paramBoolean1, paramList, paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afpk
 * JD-Core Version:    0.7.0.1
 */