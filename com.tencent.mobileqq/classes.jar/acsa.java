import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;

public class acsa
  implements acpi
{
  private static void a(QQAppInterface paramQQAppInterface, MessageHandler paramMessageHandler, MsgInfo paramMsgInfo, MsgType0x210 paramMsgType0x210)
  {
    ((aozf)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.READINJOY_HANDLER)).a(paramMsgType0x210.vProtobuf);
    bcrx.a(paramMessageHandler, paramMsgInfo.lFromUin, paramMsgInfo.shMsgSeq, paramMsgInfo.lMsgUid, paramMsgInfo.shMsgType);
  }
  
  public MessageRecord a(acnk paramacnk, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a(paramacnk.a(), paramacnk.a().getMsgHandler(), paramMsgInfo, paramMsgType0x210);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acsa
 * JD-Core Version:    0.7.0.1
 */