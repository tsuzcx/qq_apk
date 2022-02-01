import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;

public class adgq
  implements adci
{
  public static void a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte, long paramLong)
  {
    ((KandianMergeManager)paramQQAppInterface.getManager(162)).a(paramArrayOfByte, paramLong);
  }
  
  public MessageRecord a(adan paramadan, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a(paramadan.a(), paramMsgType0x210.vProtobuf, paramMsgInfo.uRealMsgTime);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adgq
 * JD-Core Version:    0.7.0.1
 */