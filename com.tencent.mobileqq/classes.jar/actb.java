import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForNearbyLiveTip;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import tencent.im.s2c.msgtype0x210.submsgtype0xcb.SubMsgType0xcb.MsgBody;

public class actb
  implements acpi
{
  private static void a(acnk paramacnk, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    boolean bool2 = true;
    Object localObject = new SubMsgType0xcb.MsgBody();
    label468:
    String str;
    try
    {
      ((SubMsgType0xcb.MsgBody)localObject).mergeFrom(paramArrayOfByte);
      paramArrayOfByte = (MessageForNearbyLiveTip)bcsa.a(-2053);
      if (((SubMsgType0xcb.MsgBody)localObject).uint32_anchor_status.get() == 1)
      {
        bool1 = true;
        paramArrayOfByte.isLiving = bool1;
        paramArrayOfByte.jumpingUrl = ((SubMsgType0xcb.MsgBody)localObject).bytes_jump_schema.get().toStringUtf8();
        paramArrayOfByte.msg = ((SubMsgType0xcb.MsgBody)localObject).bytes_live_wording.get().toStringUtf8();
        paramArrayOfByte.headUrl = ((SubMsgType0xcb.MsgBody)localObject).bytes_anchor_head_url.get().toStringUtf8();
        paramArrayOfByte.nickName = ((SubMsgType0xcb.MsgBody)localObject).bytes_anchor_nickname.get().toStringUtf8();
        paramArrayOfByte.liveEndWording = ((SubMsgType0xcb.MsgBody)localObject).bytes_live_end_wording.get().toStringUtf8();
        paramArrayOfByte.c2cMsgWording = ((SubMsgType0xcb.MsgBody)localObject).bytes_c2c_msg_wording.get().toStringUtf8();
        paramArrayOfByte.startLiveWordingType = ((SubMsgType0xcb.MsgBody)localObject).uint32_live_wording_type.get();
        paramArrayOfByte.endLiveWordingType = ((SubMsgType0xcb.MsgBody)localObject).uint32_end_wording_type.get();
        paramArrayOfByte.time = paramMsgInfo.uRealMsgTime;
        paramArrayOfByte.msgseq = paramMsgInfo.uRealMsgTime;
        paramArrayOfByte.shmsgseq = paramMsgInfo.shMsgSeq;
        paramArrayOfByte.msgUid = paramMsgInfo.lMsgUid;
        paramArrayOfByte.selfuin = paramacnk.a().getCurrentAccountUin();
        paramArrayOfByte.istroop = 1001;
        paramArrayOfByte.senderuin = String.valueOf(paramMsgInfo.lFromUin + AppConstants.NOW_LIVE_TIP_UIN_BASE);
        paramArrayOfByte.frienduin = String.valueOf(paramMsgInfo.lFromUin + AppConstants.NOW_LIVE_TIP_UIN_BASE);
        paramArrayOfByte.getBytes();
        if (QLog.isColorLevel())
        {
          paramMsgInfo = new StringBuilder();
          paramMsgInfo.append("status=").append(paramArrayOfByte.isLiving).append("jumpingUrl=").append(paramArrayOfByte.jumpingUrl).append("liveWording=").append(paramArrayOfByte.msg).append("headUrl").append(paramArrayOfByte.headUrl).append("nickName").append(paramArrayOfByte.nickName).append("startLiveWordingType=").append(((SubMsgType0xcb.MsgBody)localObject).uint32_live_wording_type.get()).append("endLiveWordingType=").append(((SubMsgType0xcb.MsgBody)localObject).uint32_end_wording_type.get());
          QLog.i("Q.msg.BaseMessageProcessor", 2, paramMsgInfo.toString());
        }
        if ((!MessageForNearbyLiveTip.isHuayangTip(paramArrayOfByte.jumpingUrl)) || (MessageForNearbyLiveTip.isSupportHuayangBusinessType(paramArrayOfByte.jumpingUrl))) {
          break label468;
        }
        if (QLog.isColorLevel()) {
          QLog.i("Q.msg.BaseMessageProcessor", 2, "decodeNearbyLiveTipMsg discard a not support huayang tips message, jumpUrl=" + paramArrayOfByte.jumpingUrl);
        }
      }
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      do
      {
        for (;;)
        {
          if (QLog.isColorLevel())
          {
            QLog.i("Q.msg.BaseMessageProcessor", 2, "decodeNearbyLiveTipMsg decode failed" + paramArrayOfByte.toString());
            continue;
            bool1 = false;
          }
        }
        paramMsgInfo = new ArrayList();
      } while (anyv.a(paramacnk.a(), paramArrayOfByte, true));
      paramMsgInfo.add(paramArrayOfByte);
      boolean bool3 = paramArrayOfByte.senderuin.equals(String.valueOf(1822701914L + AppConstants.NOW_LIVE_TIP_UIN_BASE));
      if (bool3) {
        paramArrayOfByte.isLiving = true;
      }
      if (paramArrayOfByte.isLiving)
      {
        bool2 = anyv.a(paramMsgInfo);
        int i = acnh.a(paramMsgInfo, paramacnk.a());
        localObject = paramacnk.a().getMessageFacade();
        str = paramacnk.a().getCurrentAccountUin();
        if ((bool2) && (paramacnk.a().isBackgroundStop)) {}
        for (bool1 = true;; bool1 = false)
        {
          ((QQMessageFacade)localObject).addMessage(paramMsgInfo, str, bool1);
          paramacnk.a().getMsgCache().a((int)paramArrayOfByte.time);
          if ((bdvn.a()) || (!bool3)) {
            break;
          }
          paramacnk.a("handleGetBuddyMessageResp", true, i, paramacnk.a().getMsgHandler().a(bool2), false);
          return;
        }
      }
      localObject = paramacnk.a().getMessageFacade().getLastMessage(paramArrayOfByte.frienduin, paramArrayOfByte.istroop);
      if (localObject != null)
      {
        paramacnk.a().getMessageFacade().updateMsgContentByUniseq(paramArrayOfByte.frienduin, paramArrayOfByte.istroop, ((MessageRecord)localObject).uniseq, paramArrayOfByte.msgData);
        paramacnk.a().getMessageFacade().setChangeAndNotify(localObject);
        return;
      }
      bool1 = anyv.a(paramMsgInfo);
      localObject = paramacnk.a().getMessageFacade();
      str = paramacnk.a().getCurrentAccountUin();
      if (!bool1) {
        break label780;
      }
    }
    if (paramacnk.a().isBackgroundStop) {}
    label780:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((QQMessageFacade)localObject).addMessage(paramMsgInfo, str, bool1);
      paramacnk.a().getMsgCache().a((int)paramArrayOfByte.time);
      return;
    }
  }
  
  public MessageRecord a(acnk paramacnk, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a(paramacnk, paramMsgType0x210.vProtobuf, paramMsgInfo);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     actb
 * JD-Core Version:    0.7.0.1
 */