import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import tencent.im.s2c.msgtype0x210.submsgtype0x117.submsgtype0x117.MsgBody;

public class adcu
  implements adci
{
  private static void a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {}
    Object localObject;
    do
    {
      for (;;)
      {
        return;
        localObject = new submsgtype0x117.MsgBody();
        try
        {
          ((submsgtype0x117.MsgBody)localObject).mergeFrom(paramArrayOfByte);
          paramArrayOfByte = ((submsgtype0x117.MsgBody)localObject).rpt_uint32_moudle_id.get();
          l = ((submsgtype0x117.MsgBody)localObject).uint64_uin.get();
          if ((paramArrayOfByte == null) || (paramArrayOfByte.size() == 0))
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("Q.msg.BaseMessageProcessor", 2, "handleMsgType0x210SuMsgType0x117 音视频测试环境push,moudleIds==null || moudleIds.size()== 0");
          }
        }
        catch (InvalidProtocolBufferMicroException paramArrayOfByte)
        {
          long l;
          for (;;)
          {
            paramArrayOfByte.printStackTrace();
          }
          localObject = new StringBuilder(anzj.a(2131706718));
          ((StringBuilder)localObject).append(l);
          paramArrayOfByte = paramArrayOfByte.iterator();
          while (paramArrayOfByte.hasNext())
          {
            int i = ((Integer)paramArrayOfByte.next()).intValue();
            if (i == 92) {
              ((StringBuilder)localObject).append("|音视频");
            } else if (i == 93) {
              ((StringBuilder)localObject).append("|双人");
            } else if (i == 94) {
              ((StringBuilder)localObject).append("|多人");
            }
          }
          ((StringBuilder)localObject).append("】");
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.msg.BaseMessageProcessor", 2, "handleMsgType0x210SuMsgType0x117 音视频测试环境push" + ((StringBuilder)localObject).toString());
  }
  
  public MessageRecord a(adan paramadan, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a(paramMsgType0x210.vProtobuf);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adcu
 * JD-Core Version:    0.7.0.1
 */