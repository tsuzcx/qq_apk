import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForQQWalletTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import org.jetbrains.annotations.Nullable;
import tencent.im.s2c.msgtype0x210.submsgtype0x9f.MsgBody;

public class adff
  implements adci
{
  @Nullable
  private static MessageRecord a(QQAppInterface paramQQAppInterface, MsgInfo paramMsgInfo, MsgType0x210 paramMsgType0x210)
  {
    MsgBody localMsgBody = new MsgBody();
    MessageForQQWalletTips localMessageForQQWalletTips = (MessageForQQWalletTips)bcry.a(-2029);
    for (;;)
    {
      int j;
      String str;
      try
      {
        localMsgBody.mergeFrom(paramMsgType0x210.vProtobuf);
        j = 0;
        str = "";
        paramMsgType0x210 = str;
        i = j;
        switch (localMsgBody.sint32_sessiontype.get())
        {
        case 5: 
          localMessageForQQWalletTips.senderUin = (localMsgBody.uint64_sender_uin.get() + "");
          localMessageForQQWalletTips.reciverUin = (localMsgBody.uint64_receiver_uin.get() + "");
          localMessageForQQWalletTips.senderContent = localMsgBody.bytes_sender_rich_content.get().toStringUtf8();
          localMessageForQQWalletTips.reciverContent = localMsgBody.bytes_receiver_rich_content.get().toStringUtf8();
          localMessageForQQWalletTips.authKey = localMsgBody.bytes_authkey.get().toStringUtf8();
          str = paramQQAppInterface.getCurrentAccountUin();
          if (paramQQAppInterface.getCurrentAccountUin().equals(localMessageForQQWalletTips.senderUin))
          {
            paramQQAppInterface = localMessageForQQWalletTips.reciverUin;
            localMessageForQQWalletTips.init(str, paramQQAppInterface, paramMsgType0x210, "[QQWallet Tips]", paramMsgInfo.getUMsgTime(), -2029, i, paramMsgInfo.getShMsgSeq());
            localMessageForQQWalletTips.isread = true;
            localMessageForQQWalletTips.shmsgseq = paramMsgInfo.shMsgSeq;
            localMessageForQQWalletTips.msgUid = paramMsgInfo.lMsgUid;
            localMessageForQQWalletTips.getBytes();
            localMessageForQQWalletTips.onReceiveGrapTips();
            return localMessageForQQWalletTips;
          }
        case 3: 
          i = 1000;
          paramMsgType0x210 = String.valueOf(localMsgBody.uint64_group_uin.get());
          break;
        case 4: 
          i = 1004;
          paramMsgType0x210 = String.valueOf(localMsgBody.uint64_group_uin.get());
          continue;
          paramQQAppInterface = localMessageForQQWalletTips.senderUin;
          break;
        default: 
          paramMsgType0x210 = str;
        }
      }
      catch (Exception paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
        return localMessageForQQWalletTips;
      }
      int i = j;
      continue;
      i = 1001;
      paramMsgType0x210 = str;
    }
  }
  
  public MessageRecord a(adan paramadan, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    return a(paramadan.a(), paramMsgInfo, paramMsgType0x210);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adff
 * JD-Core Version:    0.7.0.1
 */