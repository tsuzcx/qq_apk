import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import tencent.im.apollo_game_status.STCMGameMessage;
import tencent.im.apollo_game_status.STCMGameMessage.STMsgComm;
import tencent.im.s2c.msgtype0x210.submsgtype0xdf.submsgtype0xdf.MsgBody;

public class acde
  implements abzb
{
  private static void a(QQAppInterface paramQQAppInterface, long paramLong, MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameManager", 2, "onLinePush receive 0x210_0xdf, [C2C push]");
    }
    long l;
    try
    {
      Object localObject = new submsgtype0xdf.MsgBody();
      ((submsgtype0xdf.MsgBody)localObject).mergeFrom(paramMsgType0x210.vProtobuf);
      if (((submsgtype0xdf.MsgBody)localObject).msg_game_state.has())
      {
        paramMsgType0x210 = (apollo_game_status.STCMGameMessage)((submsgtype0xdf.MsgBody)localObject).msg_game_state.get();
        localObject = (apollo_game_status.STCMGameMessage.STMsgComm)paramMsgType0x210.msg_comm.get();
        l = bftf.a(((apollo_game_status.STCMGameMessage.STMsgComm)localObject).uint32_session_id.get());
        paramQQAppInterface = (alnn)paramQQAppInterface.getManager(211);
        if (paramLong != l) {
          break label194;
        }
        localObject = ((apollo_game_status.STCMGameMessage.STMsgComm)localObject).rpt_uint32_session_list.get();
        if ((localObject != null) && (((List)localObject).size() > 0))
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            l = bftf.a(((Integer)((Iterator)localObject).next()).intValue());
            if (l != paramLong) {
              paramQQAppInterface.a(0, 0, Long.toString(l), paramMsgType0x210);
            }
          }
        }
      }
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      QLog.e("ApolloGameManager", 1, "onLinePush 0x210_0xdf push exception : ", paramQQAppInterface);
    }
    label194:
    paramQQAppInterface.a(0, 0, Long.toString(l), paramMsgType0x210);
  }
  
  public MessageRecord a(abxc paramabxc, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a(paramabxc.a(), paramLong, paramMsgType0x210);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acde
 * JD-Core Version:    0.7.0.1
 */