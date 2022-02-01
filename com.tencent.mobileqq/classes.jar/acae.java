import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import trpc.qq_vgame.nofity.AvGameNotify.NotifyMatchUserEnterRoom;
import trpc.qq_vgame.nofity.AvGameNotify.NotifyMsg;

public class acae
  implements abzb
{
  public MessageRecord a(abxc paramabxc, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SubType0x138", 2, "SubType0x138 receive");
    }
    paramMsgType0x210 = nbf.a(paramMsgType0x210);
    int i;
    if (paramMsgType0x210 != null)
    {
      i = paramMsgType0x210.type.get();
      if (i != 401) {
        break label121;
      }
      mzo.a("SubType0x138", null, null, new MessageMicro[] { paramMsgType0x210 });
      if (paramMsgType0x210.match_user_enter_room.has())
      {
        paramLong = ((AvGameNotify.NotifyMatchUserEnterRoom)paramMsgType0x210.match_user_enter_room.get()).roomid.get();
        ((mxx)paramabxc.a().getBusinessHandler(178)).notifyUI(11, true, new Object[] { Integer.valueOf(2), Long.valueOf(paramLong) });
      }
    }
    label121:
    while (i != 402) {
      return null;
    }
    mzo.a("SubType0x138", null, null, new MessageMicro[] { paramMsgType0x210 });
    ((mxx)paramabxc.a().getBusinessHandler(178)).notifyUI(11, true, new Object[] { Integer.valueOf(1), Long.valueOf(0L) });
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acae
 * JD-Core Version:    0.7.0.1
 */