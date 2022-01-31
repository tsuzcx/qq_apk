import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
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

class afeh
  extends alwx
{
  afeh(afee paramafee) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, List<MessageRecord> paramList)
  {
    bcin localbcin;
    if (paramBoolean1)
    {
      if (QLog.isColorLevel()) {
        QLog.i("AppShortcutBarAIOHelper", 2, "onGetSystemMsgFin.success");
      }
      List localList = afee.a(this.a).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(alof.N, 0);
      localbcin = null;
      paramList = localbcin;
      if (localList != null)
      {
        paramList = localbcin;
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
        } while ((afee.a(this.a).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a == null) || (!afee.a(this.a).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a.equalsIgnoreCase("" + l)));
        paramList = ((TroopManager)afee.a(this.a).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(afee.a(this.a).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      } while (paramList == null);
      localbcin = afee.a(this.a).a(Long.valueOf(Long.parseLong(afee.a(this.a).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)));
      if (localbcin != null)
      {
        localbcin.c(0);
        afee.a(this.a).a(Long.parseLong(afee.a(this.a).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a), (int)paramList.dwGroupClassExt);
      }
      localbcin = afee.a(this.a).b(Long.valueOf(Long.parseLong(afee.a(this.a).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)));
    } while (localbcin == null);
    localbcin.c(0);
    afee.a(this.a).b(Long.parseLong(afee.a(this.a).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a), (int)paramList.dwGroupClassExt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afeh
 * JD-Core Version:    0.7.0.1
 */