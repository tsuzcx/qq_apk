import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForQQWalletTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.s2c.msgtype0x210.submsgtype0x85.SubMsgType0x85.MsgBody;

public class acrv
  implements acpi
{
  private static MessageRecord a(QQAppInterface paramQQAppInterface, MsgInfo paramMsgInfo, MsgType0x210 paramMsgType0x210)
  {
    Object localObject = new SubMsgType0x85.MsgBody();
    MessageForQQWalletTips localMessageForQQWalletTips = (MessageForQQWalletTips)bcsa.a(-2029);
    for (;;)
    {
      try
      {
        ((SubMsgType0x85.MsgBody)localObject).mergeFrom(paramMsgType0x210.vProtobuf);
        localMessageForQQWalletTips.senderUin = (((SubMsgType0x85.MsgBody)localObject).uint64_sender_uin.get() + "");
        localMessageForQQWalletTips.reciverUin = (((SubMsgType0x85.MsgBody)localObject).uint64_receiver_uin.get() + "");
        localMessageForQQWalletTips.senderContent = ((SubMsgType0x85.MsgBody)localObject).bytes_sender_rich_content.get().toStringUtf8();
        localMessageForQQWalletTips.reciverContent = ((SubMsgType0x85.MsgBody)localObject).bytes_receiver_rich_content.get().toStringUtf8();
        localMessageForQQWalletTips.authKey = ((SubMsgType0x85.MsgBody)localObject).bytes_authkey.get().toStringUtf8();
        localMessageForQQWalletTips.type = ((SubMsgType0x85.MsgBody)localObject).uint32_type.get();
        localMessageForQQWalletTips.subType = ((SubMsgType0x85.MsgBody)localObject).uint32_sub_type.get();
        localMessageForQQWalletTips.bytes_jumpurl = ((SubMsgType0x85.MsgBody)localObject).bytes_jumpurl.get().toStringUtf8();
        localObject = paramQQAppInterface.getCurrentAccountUin();
        if (!paramQQAppInterface.getCurrentAccountUin().equals(localMessageForQQWalletTips.senderUin)) {
          continue;
        }
        paramMsgType0x210 = localMessageForQQWalletTips.reciverUin;
        localMessageForQQWalletTips.init((String)localObject, paramMsgType0x210, "", "[QQWallet Tips]", paramMsgInfo.getUMsgTime(), -2029, 0, paramMsgInfo.getShMsgSeq());
        localMessageForQQWalletTips.isread = true;
        localMessageForQQWalletTips.shmsgseq = paramMsgInfo.shMsgSeq;
        localMessageForQQWalletTips.msgUid = paramMsgInfo.lMsgUid;
        localMessageForQQWalletTips.getBytes();
        localMessageForQQWalletTips.onReceiveGrapTips();
        if (QLog.isColorLevel())
        {
          QLog.d("Q.msg.BaseMessageProcessor", 2, "0x85 push type: " + localMessageForQQWalletTips.type + ", subtype: " + localMessageForQQWalletTips.subType);
          QLog.d("Q.msg.BaseMessageProcessor", 2, "0x85 push jumpurl: " + localMessageForQQWalletTips.bytes_jumpurl);
        }
      }
      catch (Exception paramMsgInfo)
      {
        String str;
        paramMsgInfo.printStackTrace();
        continue;
        if (!paramMsgType0x210.equals(localMessageForQQWalletTips.reciverUin)) {
          continue;
        }
        paramMsgInfo = localMessageForQQWalletTips.reciverContent;
        continue;
      }
      if ((localMessageForQQWalletTips.type == 1) && (localMessageForQQWalletTips.subType == 0)) {
        break label489;
      }
      paramMsgInfo = localMessageForQQWalletTips;
      if (localMessageForQQWalletTips.type == 1)
      {
        paramMsgType0x210 = paramQQAppInterface.getCurrentAccountUin();
        paramMsgInfo = null;
        if (!paramMsgType0x210.equals(localMessageForQQWalletTips.senderUin)) {
          continue;
        }
        paramMsgInfo = localMessageForQQWalletTips.senderContent;
        paramMsgType0x210 = anvx.a(2131707293);
        localObject = anvx.a(2131707292);
        str = localMessageForQQWalletTips.getQQWalletTips(paramQQAppInterface, paramMsgInfo);
        paramMsgInfo = localMessageForQQWalletTips;
        if (!TextUtils.isEmpty(str)) {
          if (!str.equals(paramMsgType0x210))
          {
            paramMsgInfo = localMessageForQQWalletTips;
            if (!str.equals(localObject)) {}
          }
          else
          {
            localMessageForQQWalletTips.addQQWalletTips(paramQQAppInterface, str, localMessageForQQWalletTips.highLightStart, localMessageForQQWalletTips.highLightEnd, localMessageForQQWalletTips.textColor, localMessageForQQWalletTips.url);
            paramMsgInfo = null;
          }
        }
      }
      return paramMsgInfo;
      paramMsgType0x210 = localMessageForQQWalletTips.senderUin;
    }
    label489:
    return null;
  }
  
  public MessageRecord a(acnk paramacnk, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    return a(paramacnk.a(), paramMsgInfo, paramMsgType0x210);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acrv
 * JD-Core Version:    0.7.0.1
 */