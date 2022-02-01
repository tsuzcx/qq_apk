import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.im.s2c.msgtype0x210.submsgtype0x26.submsgtype0x26.AppID;
import tencent.im.s2c.msgtype0x210.submsgtype0x26.submsgtype0x26.AppTipNotify;
import tencent.im.s2c.msgtype0x210.submsgtype0x26.submsgtype0x26.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x26.submsgtype0x26.MsgBody.SubCmd0x1UpdateAppUnreadNum;
import tencent.im.s2c.msgtype0x210.submsgtype0x26.submsgtype0x26.MsgBody.SubCmd0x3UpdateDiscussAppInfo;

public class acqo
  implements acpi
{
  private static long a(QQAppInterface paramQQAppInterface, submsgtype0x26.MsgBody paramMsgBody)
  {
    long l1 = 0L;
    long l2 = l1;
    if (paramMsgBody.uint32_sub_cmd.get() == 1)
    {
      l2 = l1;
      if (paramMsgBody.rpt_msg_subcmd_0x1_push_body.has())
      {
        paramMsgBody = paramMsgBody.rpt_msg_subcmd_0x1_push_body.get();
        int i = 0;
        l2 = l1;
        if (i < paramMsgBody.size())
        {
          Object localObject = (submsgtype0x26.MsgBody.SubCmd0x1UpdateAppUnreadNum)paramMsgBody.get(i);
          l1 = ((submsgtype0x26.MsgBody.SubCmd0x1UpdateAppUnreadNum)localObject).uint64_group_code.get();
          l2 = ((submsgtype0x26.MsgBody.SubCmd0x1UpdateAppUnreadNum)localObject).msg_app_id.uint64_app_id.get();
          int j = ((submsgtype0x26.MsgBody.SubCmd0x1UpdateAppUnreadNum)localObject).sint32_unread_num.get();
          localObject = (bgbg)paramQQAppInterface.getManager(QQManagerFactory.TROOP_SHORTCUTBAR_MANAGER);
          if (localObject != null)
          {
            if (l2 != 101846662L) {
              break label182;
            }
            ((bgbg)localObject).a(l1);
            if (QLog.isColorLevel()) {
              QLog.d("SubType0x26", 2, "handleAioShortcutBarPush SHORTCUTBAR_STATUS_CHANGE_APPID troopUin:" + l1);
            }
          }
          for (;;)
          {
            ((bgbg)localObject).a(l1, l2, j);
            i += 1;
            break;
            label182:
            if (l2 == 101896870L)
            {
              ((bgbg)localObject).a(l1, j);
              if (QLog.isColorLevel()) {
                QLog.d("SubType0x26", 2, "handleAioShortcutBarPush REMIND_GRAYTIP_APPID troopUin:" + l1 + " unreadNum:" + j);
              }
            }
          }
        }
      }
    }
    return l2;
  }
  
  public static void a(acnk paramacnk, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "handleMsgType0x210SubMsgType0x26");
    }
    submsgtype0x26.MsgBody localMsgBody = new submsgtype0x26.MsgBody();
    do
    {
      try
      {
        localMsgBody.mergeFrom(paramArrayOfByte);
        if (!localMsgBody.uint32_sub_cmd.has())
        {
          if (QLog.isColorLevel()) {
            QLog.e("Q.msg.BaseMessageProcessor", 2, "handleMsgType0x210SubMsgType0x26 : msg has not body");
          }
          return;
        }
      }
      catch (Exception paramacnk)
      {
        while (!QLog.isColorLevel()) {}
        QLog.e("Q.msg.BaseMessageProcessor", 2, "handleMsgType0x210SubMsgType0x26 : fail to parse submsgtype0x26.");
        return;
      }
      b(paramacnk.a(), localMsgBody);
      long l = a(paramacnk.a(), localMsgBody);
      if (l != 0L)
      {
        bgbe localbgbe = (bgbe)paramacnk.a().getBusinessHandler(BusinessHandlerFactory.TROOP_SHORTCUTBAR_HANDLE);
        if (localbgbe != null) {
          localbgbe.notifyUI(3, true, new Object[] { Long.valueOf(l) });
        }
      }
      if ((localMsgBody.uint32_sub_cmd.get() == 1) || (localMsgBody.uint32_sub_cmd.get() == 4))
      {
        ((aoep)paramacnk.a().getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).a(paramArrayOfByte);
        return;
      }
    } while (localMsgBody.uint32_sub_cmd.get() != 3);
    a(paramacnk.a(), localMsgBody);
  }
  
  private static void a(QQAppInterface paramQQAppInterface, submsgtype0x26.MsgBody.SubCmd0x1UpdateAppUnreadNum paramSubCmd0x1UpdateAppUnreadNum)
  {
    if (paramSubCmd0x1UpdateAppUnreadNum == null) {}
    label151:
    label175:
    for (;;)
    {
      return;
      aoep localaoep = (aoep)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
      if (localaoep != null)
      {
        String str2 = paramQQAppInterface.getCurrentAccountUin();
        String str1 = String.valueOf(paramSubCmd0x1UpdateAppUnreadNum.uint64_group_code.get());
        boolean bool;
        if (paramSubCmd0x1UpdateAppUnreadNum.sint32_unread_num.get() != 0)
        {
          bool = true;
          if (bool) {
            break label151;
          }
          bhdf.a(str2, str1, bool, "");
          localaoep.notifyUI(153, true, new Object[] { str1, Boolean.valueOf(bool), "" });
          paramQQAppInterface = "";
        }
        for (;;)
        {
          if (!QLog.isColorLevel()) {
            break label175;
          }
          QLog.d("Q.msg.BaseMessageProcessor", 2, "handleTroopMemberActiveRankingRedPoint isShowRedPoint = " + bool + ", troopUin = " + str1 + ",wording = " + paramQQAppInterface);
          return;
          bool = false;
          break;
          paramQQAppInterface = bhdf.a(str2, str1, "");
          bhdf.a(str2, str1, bool, paramQQAppInterface);
          localaoep.A(str1);
        }
      }
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, submsgtype0x26.MsgBody paramMsgBody)
  {
    if ((!paramMsgBody.msg_subcmd_0x3_push_body.has()) && (QLog.isColorLevel())) {
      QLog.e("Q.msg.BaseMessageProcessor", 2, "handleMsgType0x210SubMsgType0x26 : msg has not 0x3_push_body");
    }
    paramMsgBody = (submsgtype0x26.MsgBody.SubCmd0x3UpdateDiscussAppInfo)paramMsgBody.msg_subcmd_0x3_push_body.get();
    if ((paramMsgBody.uint64_conf_uin.has()) && (paramMsgBody.msg_app_tip_notify.has()))
    {
      paramMsgBody.uint64_conf_uin.get();
      paramMsgBody = (submsgtype0x26.AppTipNotify)paramMsgBody.msg_app_tip_notify.get();
      if (paramMsgBody.bytes_text.has())
      {
        paramMsgBody = paramMsgBody.bytes_text.get().toByteArray();
        if (paramMsgBody.length > 0) {
          paramQQAppInterface.getGAudioHandler().c(paramMsgBody);
        }
      }
    }
  }
  
  private static void b(QQAppInterface paramQQAppInterface, submsgtype0x26.MsgBody paramMsgBody)
  {
    if (paramMsgBody == null) {}
    do
    {
      do
      {
        return;
      } while ((paramMsgBody.uint32_sub_cmd.get() != 1) || (!paramMsgBody.rpt_msg_subcmd_0x1_push_body.has()));
      paramMsgBody = paramMsgBody.rpt_msg_subcmd_0x1_push_body.get();
    } while (paramMsgBody == null);
    int i = 0;
    label40:
    submsgtype0x26.MsgBody.SubCmd0x1UpdateAppUnreadNum localSubCmd0x1UpdateAppUnreadNum;
    if (i < paramMsgBody.size())
    {
      localSubCmd0x1UpdateAppUnreadNum = (submsgtype0x26.MsgBody.SubCmd0x1UpdateAppUnreadNum)paramMsgBody.get(i);
      if (localSubCmd0x1UpdateAppUnreadNum != null) {
        break label72;
      }
    }
    for (;;)
    {
      i += 1;
      break label40;
      break;
      label72:
      if (localSubCmd0x1UpdateAppUnreadNum.msg_app_id.uint64_app_id.get() == 101890494L) {
        a(paramQQAppInterface, localSubCmd0x1UpdateAppUnreadNum);
      }
    }
  }
  
  public MessageRecord a(acnk paramacnk, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a(paramacnk, paramMsgType0x210.vProtobuf);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acqo
 * JD-Core Version:    0.7.0.1
 */