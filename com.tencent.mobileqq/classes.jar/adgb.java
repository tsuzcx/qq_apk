import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import android.text.TextUtils;
import com.tencent.gamecenter.appointment.GameCenterCheck;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;
import tencent.im.s2c.msgtype0x210.submsgtype0xce.submsgtype0xce.MsgBody;

public class adgb
  implements adci
{
  private static void a(QQAppInterface paramQQAppInterface, MsgType0x210 paramMsgType0x210)
  {
    int k = 0;
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "OnLinePushMessageProcessor receive 0xce push message ");
    }
    Object localObject = new submsgtype0xce.MsgBody();
    try
    {
      ((submsgtype0xce.MsgBody)localObject).mergeFrom(paramMsgType0x210.vProtobuf);
      paramMsgType0x210 = ((submsgtype0xce.MsgBody)localObject).string_params.get();
      if (QLog.isColorLevel()) {
        bkad.c("Q.msg.BaseMessageProcessor", "yuyue(push):OnLinePushMessageProcessor receive 0xce strJson=" + paramMsgType0x210);
      }
      localObject = new JSONObject(paramMsgType0x210).optString("appid");
      String[] arrayOfString = acik.a("APPOINTMENT_DOWNLOAD_LIST").split("\\|");
      int i = 0;
      for (;;)
      {
        int j = k;
        if (i < arrayOfString.length)
        {
          if ((!TextUtils.isEmpty(arrayOfString[i])) && (!TextUtils.isEmpty((CharSequence)localObject)) && (arrayOfString[i].equals(localObject))) {
            j = 1;
          }
        }
        else
        {
          if ((j == 0) && (!TextUtils.isEmpty((CharSequence)localObject)))
          {
            acik.c((String)localObject, "APPOINTMENT_LIST");
            acik.a((String)localObject, paramMsgType0x210, "APPOINT_APPID_DETAIL_");
            acig.a();
          }
          GameCenterCheck.a();
          acik.a(paramQQAppInterface, "426", "202136", (String)localObject, "42601", "1", "116");
          return;
        }
        i += 1;
      }
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
    }
  }
  
  public MessageRecord a(adan paramadan, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a(paramadan.a(), paramMsgType0x210);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adgb
 * JD-Core Version:    0.7.0.1
 */