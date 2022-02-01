import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageRecord;

public class actv
  implements acpi
{
  public static void a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte, int paramInt, MsgInfo paramMsgInfo)
  {
    ((avqv)paramQQAppInterface.getManager(QQManagerFactory.IMAX_AD_VIDEO_PRELOAD_MANAGER)).a(paramArrayOfByte, paramInt, paramMsgInfo);
  }
  
  public MessageRecord a(acnk paramacnk, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a(paramacnk.a(), paramMsgType0x210.vProtobuf, 1, paramMsgInfo);
    bcrx.a(paramacnk.a().getMsgHandler(), paramMsgInfo.lFromUin, paramMsgInfo.shMsgSeq, paramMsgInfo.lMsgUid, paramMsgInfo.shMsgType);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     actv
 * JD-Core Version:    0.7.0.1
 */