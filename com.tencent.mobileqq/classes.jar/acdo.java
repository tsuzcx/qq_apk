import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.now.enter.pb.NowPushMsgList.MsgBody;
import com.tencent.mobileqq.now.enter.pb.NowPushMsgList.NowPushMsg;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class acdo
  implements abzb
{
  private static void a(abxc paramabxc, MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "onLinePush receive 0x210_0xfb");
    }
    try
    {
      Object localObject = new NowPushMsgList.MsgBody();
      if (paramabxc.a(paramMsgType0x210))
      {
        ((NowPushMsgList.MsgBody)localObject).mergeFrom(paramMsgType0x210.vProtobuf);
        paramMsgType0x210 = ((NowPushMsgList.MsgBody)localObject).rpt_now_push_msg.get().iterator();
        while (paramMsgType0x210.hasNext())
        {
          localObject = (NowPushMsgList.NowPushMsg)paramMsgType0x210.next();
          ((axir)paramabxc.a().getManager(266)).a((NowPushMsgList.NowPushMsg)localObject);
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageProcessor", 2, "onLinePush receive 0x210_0xfb " + ((NowPushMsgList.NowPushMsg)localObject).uint32_switch.get() + "  uint32_task_id " + ((NowPushMsgList.NowPushMsg)localObject).uint32_task_id.get() + "  uint32_type " + ((NowPushMsgList.NowPushMsg)localObject).uint32_type.get() + "  uint64_start_time " + ((NowPushMsgList.NowPushMsg)localObject).uint64_start_time.get() + "  uint64_end_time " + ((NowPushMsgList.NowPushMsg)localObject).uint64_end_time.get());
          }
        }
      }
      return;
    }
    catch (Exception paramabxc)
    {
      QLog.e("Q.msg.BaseMessageProcessor", 1, "[msg0x210.uSubMsgType == 0xfb], errInfo->" + paramabxc.getMessage());
    }
  }
  
  public MessageRecord a(abxc paramabxc, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a(paramabxc, paramMsgType0x210);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acdo
 * JD-Core Version:    0.7.0.1
 */