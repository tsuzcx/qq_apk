import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import trpc.qq_vgame.nofity.AvGameNotify.NotifyMatchUserEnterRoom;
import trpc.qq_vgame.nofity.AvGameNotify.NotifyMsg;

public class acql
  implements acpi
{
  public MessageRecord a(acnk paramacnk, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SubType0x138", 2, "SubType0x138 receive");
    }
    paramMsgType0x210 = ngv.a(paramMsgType0x210);
    int i;
    if (paramMsgType0x210 != null)
    {
      i = paramMsgType0x210.type.get();
      if (i != 401) {
        break label121;
      }
      nff.a("SubType0x138", null, null, new MessageMicro[] { paramMsgType0x210 });
      if (paramMsgType0x210.match_user_enter_room.has())
      {
        paramLong = ((AvGameNotify.NotifyMatchUserEnterRoom)paramMsgType0x210.match_user_enter_room.get()).roomid.get();
        ((ndj)paramacnk.a().getBusinessHandler(BusinessHandlerFactory.AV_GAME_HANDLER)).notifyUI(11, true, new Object[] { Integer.valueOf(2), Long.valueOf(paramLong) });
      }
    }
    label121:
    while (i != 402) {
      return null;
    }
    nff.a("SubType0x138", null, null, new MessageMicro[] { paramMsgType0x210 });
    ((ndj)paramacnk.a().getBusinessHandler(BusinessHandlerFactory.AV_GAME_HANDLER)).notifyUI(11, true, new Object[] { Integer.valueOf(1), Long.valueOf(0L) });
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acql
 * JD-Core Version:    0.7.0.1
 */