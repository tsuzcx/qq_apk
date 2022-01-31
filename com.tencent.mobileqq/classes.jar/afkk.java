import android.text.TextUtils;
import android.util.Base64;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import tencent.im.pushsvr.pushsvrExt.ExtData;
import tencent.im.s2c.msgtype0x210.submsgtype0x101.SubMsgType0x27.ClientReport;
import tencent.im.s2c.msgtype0x210.submsgtype0x101.SubMsgType0x27.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x101.SubMsgType0x27.PushPlatform;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public class afkk
{
  private static final AtomicInteger a = new AtomicInteger(1);
  
  public static int a(MessageRecord paramMessageRecord)
  {
    paramMessageRecord = MessageForSystemMsg.parseStructMsg(paramMessageRecord.msgData);
    if (paramMessageRecord.msg_type.get() == 1) {
      return paramMessageRecord.msg.sub_type.get();
    }
    return -1;
  }
  
  public static final void a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2, short paramShort, msg_comm.Msg paramMsg, int paramInt)
  {
    if ((paramShort != 188) && (paramShort != 189)) {
      return;
    }
    Object localObject2 = (msg_comm.MsgHead)paramMsg.msg_head.get();
    Object localObject1;
    boolean bool1;
    boolean bool2;
    if (localObject2 != null)
    {
      paramMsg = "" + ((msg_comm.MsgHead)localObject2).auth_uin.get();
      localObject1 = ((msg_comm.MsgHead)localObject2).auth_nick.get();
      localObject2 = ((msg_comm.MsgHead)localObject2).auth_remark.get();
      bool1 = TextUtils.isEmpty(paramMsg);
      bool2 = TextUtils.isEmpty((CharSequence)localObject1);
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        paramMsg = (msg_comm.Msg)localObject2;
        label109:
        if (TextUtils.isEmpty(paramMsg)) {
          break label434;
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("NewFriendPushUtil", 2, String.format(Locale.getDefault(), "handleNewFrdSystemPush [0x%x,%d,%s,%d]", new Object[] { Short.valueOf(paramShort), Long.valueOf(paramLong2), paramMsg, Integer.valueOf(paramInt) }));
      }
      localObject2 = new SubMsgType0x27.MsgBody();
      SubMsgType0x27.PushPlatform localPushPlatform = new SubMsgType0x27.PushPlatform();
      SubMsgType0x27.ClientReport localClientReport = new SubMsgType0x27.ClientReport();
      localClientReport.uint32_service_id.set(1005);
      PBStringField localPBStringField = localClientReport.str_content_id;
      if (paramShort == 188) {}
      for (localObject1 = "0xbc";; localObject1 = "0xbd")
      {
        localPBStringField.set((String)localObject1);
        ((SubMsgType0x27.MsgBody)localObject2).msg_client_report.set(localClientReport);
        localPushPlatform.uint32_forward_type.set(1);
        localPushPlatform.uint64_from_uin.set(paramLong2);
        localObject1 = String.format(ajya.a(2131707504), new Object[] { paramMsg });
        localPushPlatform.str_desc.set((String)localObject1);
        localPushPlatform.str_target_url.set(Base64.encodeToString("newfrd_add".getBytes(), 0));
        localPushPlatform.str_title.set(ajya.a(2131707506));
        localObject1 = new pushsvrExt.ExtData();
        ((pushsvrExt.ExtData)localObject1).uint64_to_uin.set(paramLong2);
        ((pushsvrExt.ExtData)localObject1).str_remark.set(ByteStringMicro.copyFromUtf8(paramMsg));
        localPushPlatform.bytes_ext_data.set(ByteStringMicro.copyFrom(((pushsvrExt.ExtData)localObject1).toByteArray()));
        ((SubMsgType0x27.MsgBody)localObject2).msg_push_platform.set(localPushPlatform);
        ((aseq)paramQQAppInterface.getManager(284)).a((SubMsgType0x27.MsgBody)localObject2, (short)(a.getAndIncrement() % 32767), paramInt);
        return;
        if (!bool2)
        {
          paramMsg = (msg_comm.Msg)localObject1;
          break label109;
        }
        if (!bool1) {
          break label109;
        }
        paramMsg = String.valueOf(paramLong2);
        break label109;
        label434:
        break;
      }
      paramMsg = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     afkk
 * JD-Core Version:    0.7.0.1
 */