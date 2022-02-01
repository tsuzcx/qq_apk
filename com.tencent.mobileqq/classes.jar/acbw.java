import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mqp.app.sec.d;

public class acbw
  implements abzb
{
  private static void a(MsgType0x210 paramMsgType0x210)
  {
    try
    {
      d.e1(2, d.x(), paramMsgType0x210.vProtobuf);
      return;
    }
    catch (Throwable paramMsgType0x210)
    {
      paramMsgType0x210.printStackTrace();
    }
  }
  
  public MessageRecord a(abxc paramabxc, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a(paramMsgType0x210);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acbw
 * JD-Core Version:    0.7.0.1
 */