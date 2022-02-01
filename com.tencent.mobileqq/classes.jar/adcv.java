import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import Wallet.AcsMsg;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;
import tencent.im.s2c.msgtype0x210.submsgtype0x118.submsgtype0x118.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x118.submsgtype0x118.SystemNotify;

public class adcv
  implements adci
{
  private static void a(QQAppInterface paramQQAppInterface, MsgInfo paramMsgInfo, MsgType0x210 paramMsgType0x210)
  {
    agdj localagdj = (agdj)paramQQAppInterface.getManager(378);
    if (!((aold)paramQQAppInterface.getManager(85)).a(paramMsgInfo.shMsgSeq))
    {
      Object localObject = new submsgtype0x118.MsgBody();
      int i;
      for (;;)
      {
        try
        {
          ((submsgtype0x118.MsgBody)localObject).mergeFrom(paramMsgType0x210.vProtobuf);
          i = ((submsgtype0x118.MsgBody)localObject).uint32_push_type.get();
          if (i == 0)
          {
            paramMsgInfo = ((submsgtype0x118.SystemNotify)((submsgtype0x118.MsgBody)localObject).msg_system_notify.get()).bytes_msg_title.get().toStringUtf8();
            paramMsgType0x210 = new JSONObject(((submsgtype0x118.MsgBody)localObject).bytes_push_data.get().toStringUtf8());
            if (QLog.isColorLevel()) {
              QLog.d("SubType0x118", 2, "-----qq reminder-----title: " + paramMsgInfo + "---msgId: " + paramMsgType0x210.optString("msg_id") + "---notice_time: " + paramMsgType0x210.optLong("notice_time"));
            }
            localObject = new AcsMsg();
            ((AcsMsg)localObject).msg_id = paramMsgType0x210.optString("msg_id");
            ((AcsMsg)localObject).type = i;
            ((AcsMsg)localObject).notice_time = paramMsgType0x210.optLong("notice_time");
            ((AcsMsg)localObject).title = paramMsgInfo;
            localagdj.b((AcsMsg)localObject);
            if (QLog.isColorLevel()) {
              QLog.d("SubType0x118", 2, "do report: QQnotice.list.push");
            }
            bdll.b(paramQQAppInterface, "P_CliOper", "QQnotice", "", "", "QQnotice.list.push", 0, 0, "", "", paramMsgType0x210.optString("msg_id"), "");
            return;
          }
          if (i != 1) {
            break;
          }
          paramQQAppInterface = new JSONObject(((submsgtype0x118.MsgBody)localObject).bytes_push_data.get().toStringUtf8());
          if (QLog.isColorLevel()) {
            QLog.d("SubType0x118", 2, "[notify][push] multiple tskTriPushData: " + paramQQAppInterface);
          }
          paramMsgInfo = new AcsMsg();
          paramMsgInfo.msg_id = paramQQAppInterface.optString("msg_id");
          paramMsgInfo.type = i;
          paramMsgInfo.title = paramQQAppInterface.getString("title");
          paramMsgInfo.content = paramQQAppInterface.getString("msg");
          paramMsgInfo.btn_text = paramQQAppInterface.getString("btn_text");
          paramMsgInfo.notice_time = NetConnInfoCenter.getServerTime();
          paramMsgInfo.sub_time = NetConnInfoCenter.getServerTimeMillis();
          i = paramQQAppInterface.getInt("jump_type");
          if (i != 0) {
            break label452;
          }
          paramMsgInfo.jump_url = paramQQAppInterface.getString("jump_url");
          paramMsgInfo.banner_type = paramQQAppInterface.getInt("banner_type");
          paramMsgInfo.banner_url = paramQQAppInterface.getString("banner_url");
          paramMsgInfo.banner_type = paramQQAppInterface.getInt("banner_type");
          localagdj.b(paramMsgInfo);
          return;
        }
        catch (Exception paramQQAppInterface)
        {
          if (!QLog.isColorLevel()) {
            return;
          }
        }
        QLog.d("QQReminder", 2, "parse push got error.", paramQQAppInterface);
        return;
        label452:
        if (i == 4) {
          paramMsgInfo.applet_jump_url = paramQQAppInterface.getString("jump_url");
        } else {
          QLog.e("SubType0x118", 1, "[notify][push] unknown jump type: " + i);
        }
      }
      QLog.e("SubType0x118", 1, "[notify][push] unknown push type: " + i);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SubType0x118", 2, "receive same message, seq = " + paramMsgInfo.shMsgSeq);
    }
  }
  
  public MessageRecord a(adan paramadan, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a(paramadan.a(), paramMsgInfo, paramMsgType0x210);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adcv
 * JD-Core Version:    0.7.0.1
 */