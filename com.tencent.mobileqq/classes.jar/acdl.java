import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0xef.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class acdl
  implements abzb
{
  private static void a(MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "onLinePush receive 0x210_0xef, [linkstar push test]");
    }
    int i = paramMsgType0x210.vProtobuf.length;
    if (i < 6) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "onLinePush receive 0x210_0xef, [linkstar push test]. vProtoBuf.length is " + i);
    }
    int j;
    byte[] arrayOfByte1;
    do
    {
      return;
      j = (paramMsgType0x210.vProtobuf[0] << 4) + paramMsgType0x210.vProtobuf[1];
      arrayOfByte1 = new byte[4];
      System.arraycopy(paramMsgType0x210.vProtobuf, 2, arrayOfByte1, 0, 4);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessor", 2, "onLinePush receive 0x210_0xef, [linkstar push test]. msgType=" + j);
      }
      ThreadManager.getUIHandler().post(new SubType0xef.1(j));
    } while (i <= 6);
    byte[] arrayOfByte2 = new byte[i - 6];
    System.arraycopy(paramMsgType0x210.vProtobuf, 6, arrayOfByte2, 0, i - 6);
    anwy.a(j, arrayOfByte1, arrayOfByte2);
  }
  
  public MessageRecord a(abxc paramabxc, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a(paramMsgType0x210);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acdl
 * JD-Core Version:    0.7.0.1
 */