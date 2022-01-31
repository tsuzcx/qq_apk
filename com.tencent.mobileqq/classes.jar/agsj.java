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

class agsj
  implements Observer
{
  agsj(agse paramagse) {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof avui))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "new FriendSystemMessage,:");
      }
      paramObservable = ((avui)paramObject).a.getSystemMsg();
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
          QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "FRIEND_ADDSUCCESS, uin:" + paramObservable + " badd:" + agse.a(this.a));
        }
      } while ((TextUtils.isEmpty(paramObservable)) || (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (!paramObservable.equals(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)));
      if (!agse.a(this.a))
      {
        agse.a(this.a, true);
        atlt.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramObservable);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "FRIEND_ADDSUCCESS, processed:");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agsj
 * JD-Core Version:    0.7.0.1
 */