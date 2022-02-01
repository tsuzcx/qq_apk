import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageRecord;

public class acsx
  implements acpi
{
  public static void a(acnk paramacnk, byte[] paramArrayOfByte, long paramLong)
  {
    ((KandianMergeManager)paramacnk.a().getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).a(paramArrayOfByte, paramLong, paramacnk);
  }
  
  public MessageRecord a(acnk paramacnk, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a(paramacnk, paramMsgType0x210.vProtobuf, paramMsgInfo.uRealMsgTime);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acsx
 * JD-Core Version:    0.7.0.1
 */