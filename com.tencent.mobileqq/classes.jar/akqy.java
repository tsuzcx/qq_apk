import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import tencent.mobileim.structmsg.structmsg.RspHead;
import tencent.mobileim.structmsg.structmsg.RspNextSystemMsg;
import tencent.mobileim.structmsg.structmsg.StructMsg;

class akqy
  implements aytj
{
  akqy(akqw paramakqw) {}
  
  public void a(aytl paramaytl, aytk paramaytk)
  {
    if (paramaytl.a.getResultCode() != 1000) {
      this.a.a(4006, false, null);
    }
    Object localObject1;
    do
    {
      return;
      try
      {
        if ((paramaytk.a == null) || (!(paramaytk.a instanceof Integer))) {
          break label720;
        }
        i = ((Integer)paramaytk.a).intValue();
        paramaytk = this.a.a.getAccount();
        localObject1 = new structmsg.RspNextSystemMsg();
        ((structmsg.RspNextSystemMsg)localObject1).mergeFrom((byte[])paramaytl.a.getWupBuffer());
        new StringBuilder();
        if ((localObject1 == null) || (((structmsg.RspNextSystemMsg)localObject1).head.result.get() != 0)) {
          this.a.a(4006, false, null);
        }
        if (i != 3) {
          break;
        }
        afoo.a(this.a, this.a.a, (structmsg.RspNextSystemMsg)localObject1, paramaytk);
        return;
      }
      catch (Exception paramaytl) {}
    } while (!QLog.isColorLevel());
    QLog.d("Q.systemmsg.", 2, "clearFriendSystemMsgResp exception", paramaytl);
    return;
    paramaytl = new ArrayList();
    Object localObject2 = ((structmsg.RspNextSystemMsg)localObject1).msgs.get();
    int j = ((List)localObject2).size();
    if (QLog.isColorLevel()) {
      QLog.e("Q.systemmsg.", 2, "<---sendGetNextGroupSystemMsg Resp : decode pb size = " + j);
    }
    HashSet localHashSet = new HashSet();
    int i = 0;
    label239:
    if (i < j)
    {
      structmsg.StructMsg localStructMsg = (structmsg.StructMsg)((structmsg.StructMsg)((List)localObject2).get(i)).get();
      if ((localStructMsg == null) || (!localStructMsg.msg_seq.has()) || (!localHashSet.contains(Long.valueOf(localStructMsg.msg_seq.get()))))
      {
        MessageRecord localMessageRecord = axas.a(-2018);
        localMessageRecord.msgtype = -2018;
        localMessageRecord.selfuin = paramaytk;
        localMessageRecord.frienduin = ajsd.N;
        localMessageRecord.senderuin = (((structmsg.StructMsg)((List)localObject2).get(i)).req_uin.get() + "");
        localMessageRecord.istroop = 0;
        MessageForSystemMsg localMessageForSystemMsg = (MessageForSystemMsg)localMessageRecord;
        localMessageForSystemMsg.structMsg = ((structmsg.StructMsg)((structmsg.StructMsg)((List)localObject2).get(i)).get());
        localMessageRecord.msgData = localMessageForSystemMsg.structMsg.toByteArray();
        paramaytl.add(localMessageForSystemMsg);
        if ((localStructMsg != null) && (localStructMsg.msg_seq.has())) {
          localHashSet.add(Long.valueOf(localStructMsg.msg_seq.get()));
        }
      }
    }
    else
    {
      localObject2 = (asks)this.a.a.getManager(37);
      if (paramaytl.size() > 0)
      {
        if (paramaytl.size() < 20)
        {
          aydd.a().a(true, this.a.a);
          if (localObject2 != null) {
            ((asks)localObject2).a(true);
          }
        }
        long l2 = ((structmsg.RspNextSystemMsg)localObject1).following_group_seq.get();
        long l1 = l2;
        if (l2 <= 0L) {
          l1 = this.a.a.a().e("following_group_seq");
        }
        if (QLog.isColorLevel()) {
          QLog.e("Q.systemmsg.", 2, "<---sendGetNextGroupSystemMsg : decode pb following_group_seq" + l1);
        }
        this.a.a.a().e("following_group_seq", l1);
        localObject1 = this.a.a.a();
        paramaytk = String.valueOf(paramaytk);
        if ((!akas.a(paramaytl)) || (!this.a.a.isBackground_Stop)) {
          break label732;
        }
      }
    }
    label720:
    label732:
    for (boolean bool = true;; bool = false)
    {
      ((QQMessageFacade)localObject1).a(paramaytl, paramaytk, bool);
      this.a.a("handleGetSystemMsgResp", true, paramaytl.size(), false, false);
      for (;;)
      {
        this.a.a(4005, true, paramaytl);
        return;
        aydd.a().a(true, this.a.a);
        if (localObject2 != null) {
          ((asks)localObject2).a(true);
        }
      }
      i = 0;
      break;
      i += 1;
      break label239;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akqy
 * JD-Core Version:    0.7.0.1
 */