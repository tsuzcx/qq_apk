import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForNewGrayTips;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import tencent.im.s2c.msgtype0x210.submsgtype0xc9.submsgtype0xc9.BusinessMsg;
import tencent.im.s2c.msgtype0x210.submsgtype0xc9.submsgtype0xc9.MsgBody;

public class acta
  implements acpi
{
  private static void a(QQAppInterface paramQQAppInterface, MsgType0x210 paramMsgType0x210)
  {
    String str1;
    int i;
    int j;
    Object localObject3;
    label336:
    do
    {
      for (;;)
      {
        try
        {
          Object localObject1 = new submsgtype0xc9.MsgBody();
          ((submsgtype0xc9.MsgBody)localObject1).mergeFrom(paramMsgType0x210.vProtobuf);
          if (((submsgtype0xc9.MsgBody)localObject1).uint32_type.get() == 1)
          {
            str1 = ((submsgtype0xc9.MsgBody)localObject1).uint64_from_uin.get() + "";
            String str2 = ((submsgtype0xc9.MsgBody)localObject1).uint64_action_uin.get() + "";
            if (((submsgtype0xc9.MsgBody)localObject1).source.get() != 2) {
              break label336;
            }
            i = 1001;
            if (((submsgtype0xc9.MsgBody)localObject1).bool_new_friend.get())
            {
              i = 0;
              localObject2 = (FriendListHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
              ((FriendListHandler)localObject2).notifyUI(63, true, str1);
              ((FriendListHandler)localObject2).getFriendInfo(str1);
            }
            localObject1 = ((submsgtype0xc9.MsgBody)localObject1).rpt_msg_business_msg.get().iterator();
            if (((Iterator)localObject1).hasNext())
            {
              localObject2 = (submsgtype0xc9.BusinessMsg)((Iterator)localObject1).next();
              j = ((submsgtype0xc9.BusinessMsg)localObject2).msg_type.get();
              if (j != 1) {
                break;
              }
              localObject3 = (MessageForText)bcsa.a(-1000);
              ((MessageForText)localObject3).frienduin = str1;
              if (paramQQAppInterface.getCurrentAccountUin().equals(str2)) {
                ((MessageForText)localObject3).issend = 1;
              }
              ((MessageForText)localObject3).init(paramQQAppInterface.getCurrentAccountUin(), str1, str2, ((submsgtype0xc9.BusinessMsg)localObject2).bytes_msg_data.get().toStringUtf8(), NetConnInfoCenter.getServerTime(), -1000, i, paramQQAppInterface.getMessageFacade().getLastMessage(str1, i).shmsgseq + 1L);
              ((MessageForText)localObject3).isread = false;
              paramQQAppInterface.getMessageFacade().addMessage((MessageRecord)localObject3, paramQQAppInterface.getCurrentAccountUin());
              continue;
            }
          }
          return;
        }
        catch (InvalidProtocolBufferMicroException paramQQAppInterface)
        {
          if (QLog.isColorLevel()) {
            QLog.e("Q.msg.BaseMessageProcessorQ.nearby.follow", 2, "附近、部落关注关系变化通知小灰条InvalidProtocolBufferMicroException|msg0x210.uSubMsgType:" + paramMsgType0x210.uSubMsgType);
          }
        }
        i = 10002;
      }
    } while (j != 2);
    boolean bool = ((submsgtype0xc9.BusinessMsg)localObject2).bool_tab_visible.get();
    Object localObject2 = ((submsgtype0xc9.BusinessMsg)localObject2).bytes_msg_data.get().toStringUtf8();
    if (bool)
    {
      localObject3 = (MessageForNewGrayTips)bcsa.a(-5001);
      ((MessageForNewGrayTips)localObject3).init(paramQQAppInterface.getCurrentAccountUin(), str1, str1, (String)localObject2, NetConnInfoCenter.getServerTime(), -5001, i, 1L + paramQQAppInterface.getMessageFacade().getLastMessage(str1, i).shmsgseq);
      ((MessageForNewGrayTips)localObject3).isread = true;
      ((MessageForNewGrayTips)localObject3).mNeedTimeStamp = true;
      ((MessageForNewGrayTips)localObject3).updateMsgData();
      paramQQAppInterface.getMessageFacade().addMessage((MessageRecord)localObject3, paramQQAppInterface.getCurrentAccountUin());
    }
    while (QLog.isColorLevel())
    {
      QLog.d("Q.msg.BaseMessageProcessorQ.nearby.follow", 2, "附近、部落关注关系变化通知小灰条.grayTipsTabVisable:" + bool + "|msg:" + (String)localObject2);
      break;
      localObject3 = bcsa.a(-5000);
      ((MessageRecord)localObject3).init(paramQQAppInterface.getCurrentAccountUin(), str1, str1, (String)localObject2, NetConnInfoCenter.getServerTime(), -5000, i, 1L + paramQQAppInterface.getMessageFacade().getLastMessage(str1, i).shmsgseq);
      ((MessageRecord)localObject3).isread = true;
      paramQQAppInterface.getMessageFacade().addMessage((MessageRecord)localObject3, paramQQAppInterface.getCurrentAccountUin());
    }
  }
  
  public MessageRecord a(acnk paramacnk, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a(paramacnk.a(), paramMsgType0x210);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acta
 * JD-Core Version:    0.7.0.1
 */