import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.s2c.msgtype0x210.submsgtype0x98.submsgtype0x98.ModBlock;
import tencent.im.s2c.msgtype0x210.submsgtype0x98.submsgtype0x98.MsgBody;

public class acby
  implements abzb
{
  private static void a(MsgType0x210 paramMsgType0x210)
  {
    submsgtype0x98.MsgBody localMsgBody = new submsgtype0x98.MsgBody();
    try
    {
      localMsgBody.mergeFrom(paramMsgType0x210.vProtobuf);
      label17:
      localMsgBody.uint64_uin.get();
      localMsgBody.uint32_sub_cmd.get();
      ((submsgtype0x98.ModBlock)localMsgBody.msg_mod_block.get()).uint32_op.get();
      return;
    }
    catch (Throwable paramMsgType0x210)
    {
      break label17;
    }
  }
  
  public MessageRecord a(abxc paramabxc, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a(paramMsgType0x210);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acby
 * JD-Core Version:    0.7.0.1
 */