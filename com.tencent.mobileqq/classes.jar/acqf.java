import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import android.os.Bundle;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.s2c.msgtype0x210.submsgtype0x126.submsgtype0x126.MsgBody;

public class acqf
  implements acpi
{
  private static void a(acnk paramacnk, MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "onlinepush receive 0x210_0x126, push for webview");
    }
    for (;;)
    {
      int i;
      try
      {
        localObject = new submsgtype0x126.MsgBody();
        if (!paramacnk.a(paramMsgType0x210)) {
          break label261;
        }
        ((submsgtype0x126.MsgBody)localObject).mergeFrom(paramMsgType0x210.vProtobuf);
        if (!((submsgtype0x126.MsgBody)localObject).uint32_msg_type.has()) {
          break label262;
        }
        i = ((submsgtype0x126.MsgBody)localObject).uint32_msg_type.get();
        if (i != 4) {
          continue;
        }
        paramacnk.a().getAVNotifyCenter().a((submsgtype0x126.MsgBody)localObject);
        paramMsgType0x210 = "";
      }
      catch (Exception paramacnk)
      {
        try
        {
          boolean bool;
          paramMsgType0x210 = ((submsgtype0x126.MsgBody)localObject).str_msg_info.get().toStringUtf8();
          Object localObject = new Bundle();
          ((Bundle)localObject).putInt("msgType", i);
          ((Bundle)localObject).putString("info", paramMsgType0x210);
          paramacnk.a().notifyObservers(aogz.class, 11, true, (Bundle)localObject);
        }
        catch (Throwable paramMsgType0x210)
        {
          if (!QLog.isColorLevel()) {
            break label255;
          }
          QLog.i("Q.msg.BaseMessageProcessor", 2, "onlinepush receive 0x210_0x126 parse str_msg_info fail.", paramMsgType0x210);
        }
        paramacnk = paramacnk;
        QLog.e("Q.msg.BaseMessageProcessor", 1, "webview push errInfo->" + paramacnk.getMessage());
        return;
      }
      if (QLog.isColorLevel())
      {
        QLog.d("Q.msg.BaseMessageProcessor", 2, new Object[] { "webpush type:", Integer.valueOf(i), " info:", paramMsgType0x210 });
        return;
        if (i == 2)
        {
          paramacnk.a().getAVNotifyCenter().a((submsgtype0x126.MsgBody)localObject);
          paramMsgType0x210 = "";
        }
        else
        {
          bool = ((submsgtype0x126.MsgBody)localObject).str_msg_info.has();
          if (bool) {}
          label255:
          paramMsgType0x210 = "";
        }
      }
      else
      {
        label261:
        return;
        label262:
        i = 0;
      }
    }
  }
  
  public MessageRecord a(acnk paramacnk, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a(paramacnk, paramMsgType0x210);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acqf
 * JD-Core Version:    0.7.0.1
 */