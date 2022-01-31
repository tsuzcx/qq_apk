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

class aefy
  implements Observer
{
  aefy(aefv paramaefv) {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof atcp))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "new FriendSystemMessage,:");
      }
      paramObservable = ((atcp)paramObject).a.getSystemMsg();
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
          QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "FRIEND_ADDSUCCESS, uin:" + paramObservable + " badd:" + aefv.a(this.a));
        }
      } while ((TextUtils.isEmpty(paramObservable)) || (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (!paramObservable.equals(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)));
      if (!aefv.a(this.a))
      {
        aefv.a(this.a, true);
        aqux.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramObservable);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "FRIEND_ADDSUCCESS, processed:");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aefy
 * JD-Core Version:    0.7.0.1
 */