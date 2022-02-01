import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageForQQWalletTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import org.jetbrains.annotations.Nullable;
import tencent.im.s2c.msgtype0x210.submsgtype0xa2.MsgBody;

public class acsj
  implements acpi
{
  @Nullable
  private static MessageRecord a(QQAppInterface paramQQAppInterface, MsgInfo paramMsgInfo, MsgType0x210 paramMsgType0x210)
  {
    Object localObject = (anvk)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    MsgBody localMsgBody = new MsgBody();
    localMessageForQQWalletTips = (MessageForQQWalletTips)bcsa.a(-2029);
    try
    {
      localMsgBody.mergeFrom(paramMsgType0x210.vProtobuf);
      String str1 = localMsgBody.uint64_sender_uin.get() + "";
      String str2 = localMsgBody.uint64_receiver_uin.get() + "";
      if (paramQQAppInterface.getCurrentAccountUin().equals(str1))
      {
        paramMsgType0x210 = str2;
        localObject = ((anvk)localObject).e(paramMsgType0x210);
        if ((localObject == null) || (!((Friends)localObject).isFriend())) {
          break label270;
        }
      }
      label270:
      for (int i = 0;; i = 1001)
      {
        localMessageForQQWalletTips.senderUin = str1;
        localMessageForQQWalletTips.reciverUin = str2;
        localMessageForQQWalletTips.senderContent = localMsgBody.bytes_sender_rich_content.get().toStringUtf8();
        localMessageForQQWalletTips.reciverContent = localMsgBody.bytes_receiver_rich_content.get().toStringUtf8();
        localMessageForQQWalletTips.authKey = localMsgBody.bytes_authkey.get().toStringUtf8();
        localMessageForQQWalletTips.init(paramQQAppInterface.getCurrentAccountUin(), paramMsgType0x210, "", "[QQWallet Tips]", paramMsgInfo.getUMsgTime(), -2029, i, paramMsgInfo.getShMsgSeq());
        localMessageForQQWalletTips.isread = true;
        localMessageForQQWalletTips.shmsgseq = paramMsgInfo.shMsgSeq;
        localMessageForQQWalletTips.msgUid = paramMsgInfo.lMsgUid;
        localMessageForQQWalletTips.getBytes();
        localMessageForQQWalletTips.onReceiveGrapTips();
        return localMessageForQQWalletTips;
        paramMsgType0x210 = str1;
        break;
      }
      return localMessageForQQWalletTips;
    }
    catch (Exception paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
    }
  }
  
  public MessageRecord a(acnk paramacnk, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    return a(paramacnk.a(), paramMsgInfo, paramMsgType0x210);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acsj
 * JD-Core Version:    0.7.0.1
 */