import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

class adhq
  extends akav
{
  adhq(adho paramadho) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, List<MessageRecord> paramList)
  {
    bafe localbafe;
    if (paramBoolean1)
    {
      if (QLog.isColorLevel()) {
        QLog.i("AppShortcutBarAIOHelper", 2, "onGetSystemMsgFin.success");
      }
      List localList = adho.a(this.a).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(ajsf.N, 0);
      localbafe = null;
      paramList = localbafe;
      if (localList != null)
      {
        paramList = localbafe;
        if (localList.size() - 1 >= 0) {
          paramList = (MessageRecord)localList.get(localList.size() - 1);
        }
      }
      if ((paramList != null) && ((paramList instanceof MessageForSystemMsg))) {
        break label98;
      }
    }
    label98:
    do
    {
      do
      {
        long l;
        do
        {
          int i;
          do
          {
            do
            {
              return;
              paramList = ((MessageForSystemMsg)paramList).getSystemMsg();
            } while ((paramList.msg_type.get() != 2) || (paramList.msg.get() == null));
            i = paramList.msg.group_msg_type.get();
          } while ((i != 3) && (i != 15));
          l = paramList.msg.group_code.get();
        } while ((adho.a(this.a).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a == null) || (!adho.a(this.a).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a.equalsIgnoreCase("" + l)));
        paramList = ((TroopManager)adho.a(this.a).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(adho.a(this.a).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      } while (paramList == null);
      localbafe = adho.a(this.a).a(Long.valueOf(Long.parseLong(adho.a(this.a).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)));
      if (localbafe != null)
      {
        localbafe.c(0);
        adho.a(this.a).a(Long.parseLong(adho.a(this.a).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a), (int)paramList.dwGroupClassExt);
      }
      localbafe = adho.a(this.a).b(Long.valueOf(Long.parseLong(adho.a(this.a).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)));
    } while (localbafe == null);
    localbafe.c(0);
    adho.a(this.a).b(Long.parseLong(adho.a(this.a).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a), (int)paramList.dwGroupClassExt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adhq
 * JD-Core Version:    0.7.0.1
 */