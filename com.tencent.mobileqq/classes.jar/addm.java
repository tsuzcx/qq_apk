import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.mobileqq.app.QQAppInterface;
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

public class addm
  implements adci
{
  private static long a(QQAppInterface paramQQAppInterface, submsgtype0x26.MsgBody paramMsgBody)
  {
    long l2 = 0L;
    long l1 = l2;
    Object localObject1;
    int i;
    if (paramMsgBody.uint32_sub_cmd.get() == 1)
    {
      l1 = l2;
      if (paramMsgBody.rpt_msg_subcmd_0x1_push_body.has())
      {
        localObject1 = paramMsgBody.rpt_msg_subcmd_0x1_push_body.get();
        l1 = 0L;
        i = 0;
        while (i < ((List)localObject1).size())
        {
          Object localObject2 = (submsgtype0x26.MsgBody.SubCmd0x1UpdateAppUnreadNum)((List)localObject1).get(i);
          if (((submsgtype0x26.MsgBody.SubCmd0x1UpdateAppUnreadNum)localObject2).msg_app_id.uint64_app_id.get() == 101846662L)
          {
            l2 = ((submsgtype0x26.MsgBody.SubCmd0x1UpdateAppUnreadNum)localObject2).uint64_group_code.get();
            localObject2 = (bgks)paramQQAppInterface.getManager(355);
            l1 = l2;
            if (localObject2 != null)
            {
              ((bgks)localObject2).a(l2);
              l1 = l2;
            }
          }
          i += 1;
        }
      }
    }
    l2 = l1;
    if (paramMsgBody.uint32_sub_cmd.get() == 1)
    {
      l2 = l1;
      if (paramMsgBody.rpt_msg_subcmd_0x1_push_body.has())
      {
        paramMsgBody = paramMsgBody.rpt_msg_subcmd_0x1_push_body.get();
        i = 0;
        for (;;)
        {
          l2 = l1;
          if (i >= paramMsgBody.size()) {
            break;
          }
          localObject1 = (submsgtype0x26.MsgBody.SubCmd0x1UpdateAppUnreadNum)paramMsgBody.get(i);
          l1 = ((submsgtype0x26.MsgBody.SubCmd0x1UpdateAppUnreadNum)localObject1).uint64_group_code.get();
          l2 = ((submsgtype0x26.MsgBody.SubCmd0x1UpdateAppUnreadNum)localObject1).msg_app_id.uint64_app_id.get();
          int j = ((submsgtype0x26.MsgBody.SubCmd0x1UpdateAppUnreadNum)localObject1).sint32_unread_num.get();
          localObject1 = (bgks)paramQQAppInterface.getManager(355);
          if (localObject1 != null) {
            ((bgks)localObject1).a(l1, l2, j);
          }
          i += 1;
        }
      }
    }
    return l2;
  }
  
  public static void a(adan paramadan, byte[] paramArrayOfByte)
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
      catch (Exception paramadan)
      {
        while (!QLog.isColorLevel()) {}
        QLog.e("Q.msg.BaseMessageProcessor", 2, "handleMsgType0x210SubMsgType0x26 : fail to parse submsgtype0x26.");
        return;
      }
      b(paramadan.a(), localMsgBody);
      long l = a(paramadan.a(), localMsgBody);
      if (l != 0L)
      {
        bgkq localbgkq = (bgkq)paramadan.a().a(171);
        if (localbgkq != null) {
          localbgkq.notifyUI(3, true, new Object[] { Long.valueOf(l) });
        }
      }
      if ((localMsgBody.uint32_sub_cmd.get() == 1) || (localMsgBody.uint32_sub_cmd.get() == 4))
      {
        ((aoip)paramadan.a().a(20)).a(paramArrayOfByte);
        return;
      }
    } while (localMsgBody.uint32_sub_cmd.get() != 3);
    a(paramadan.a(), localMsgBody);
  }
  
  private static void a(QQAppInterface paramQQAppInterface, submsgtype0x26.MsgBody.SubCmd0x1UpdateAppUnreadNum paramSubCmd0x1UpdateAppUnreadNum)
  {
    if (paramSubCmd0x1UpdateAppUnreadNum == null) {}
    label150:
    label174:
    for (;;)
    {
      return;
      aoip localaoip = (aoip)paramQQAppInterface.a(20);
      if (localaoip != null)
      {
        String str2 = paramQQAppInterface.getCurrentAccountUin();
        String str1 = String.valueOf(paramSubCmd0x1UpdateAppUnreadNum.uint64_group_code.get());
        boolean bool;
        if (paramSubCmd0x1UpdateAppUnreadNum.sint32_unread_num.get() != 0)
        {
          bool = true;
          if (bool) {
            break label150;
          }
          bhlk.a(str2, str1, bool, "");
          localaoip.notifyUI(153, true, new Object[] { str1, Boolean.valueOf(bool), "" });
          paramQQAppInterface = "";
        }
        for (;;)
        {
          if (!QLog.isColorLevel()) {
            break label174;
          }
          QLog.d("Q.msg.BaseMessageProcessor", 2, "handleTroopMemberActiveRankingRedPoint isShowRedPoint = " + bool + ", troopUin = " + str1 + ",wording = " + paramQQAppInterface);
          return;
          bool = false;
          break;
          paramQQAppInterface = bhlk.a(str2, str1, "");
          bhlk.a(str2, str1, bool, paramQQAppInterface);
          localaoip.z(str1);
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
          paramQQAppInterface.a().c(paramMsgBody);
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
  
  public MessageRecord a(adan paramadan, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a(paramadan, paramMsgType0x210.vProtobuf);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     addm
 * JD-Core Version:    0.7.0.1
 */