import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.Observable;
import java.util.Observer;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

class ahhv
  implements Observer
{
  ahhv(ahhp paramahhp) {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof aigj))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.a.tag, 2, "new FriendSystemMessage,:");
      }
      paramObservable = ((aigj)paramObject).a.getSystemMsg();
      if (paramObservable != null) {
        break label42;
      }
    }
    label42:
    do
    {
      do
      {
        do
        {
          return;
        } while (paramObservable.msg.sub_type.get() != 9);
        paramObservable = String.valueOf(paramObservable.req_uin.get());
        if (QLog.isColorLevel()) {
          QLog.d(this.a.tag, 2, "FRIEND_ADDSUCCESS, uin:" + paramObservable + " badd:" + ahhp.b(this.a));
        }
      } while ((TextUtils.isEmpty(paramObservable)) || (this.a.sessionInfo == null) || (!paramObservable.equals(this.a.sessionInfo.curFriendUin)));
      if (!ahhp.b(this.a))
      {
        ahhp.a(this.a, true);
        auyo.a(this.a.app, paramObservable);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d(this.a.tag, 2, "FRIEND_ADDSUCCESS, processed:");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahhv
 * JD-Core Version:    0.7.0.1
 */