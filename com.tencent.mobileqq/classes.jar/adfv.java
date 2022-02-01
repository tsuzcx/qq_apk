import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;

public class adfv
  implements adci
{
  public static void a(adan paramadan, byte[] paramArrayOfByte, long paramLong)
  {
    ((KandianMergeManager)paramadan.a().getManager(162)).a(paramArrayOfByte, paramLong, paramadan);
  }
  
  public MessageRecord a(adan paramadan, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a(paramadan, paramMsgType0x210.vProtobuf, paramMsgInfo.uRealMsgTime);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adfv
 * JD-Core Version:    0.7.0.1
 */