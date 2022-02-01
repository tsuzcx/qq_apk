import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;
import tencent.im.s2c.msgtype0x210.submsgtype0x83.SubMsgType0x83.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x83.SubMsgType0x83.MsgParams;

public class acru
  implements acpi
{
  private static void a(acnk paramacnk, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "handleMsgType0x210SubMsgType0x83");
    }
    Object localObject = new SubMsgType0x83.MsgBody();
    do
    {
      try
      {
        ((SubMsgType0x83.MsgBody)localObject).mergeFrom(paramArrayOfByte);
        if (!((SubMsgType0x83.MsgBody)localObject).uint64_group_id.has())
        {
          if (QLog.isColorLevel()) {
            QLog.e("Q.msg.BaseMessageProcessor", 2, "handleMsgType0x210SubMsgType0x83 : msg has not uint64_group_id");
          }
          return;
        }
      }
      catch (Exception paramacnk)
      {
        while (!QLog.isColorLevel()) {}
        QLog.e("Q.msg.BaseMessageProcessor", 2, "handleMsgType0x210SubMsgType0x83 : fail to parse submsgtype0x83.");
        return;
      }
    } while (!((SubMsgType0x83.MsgBody)localObject).rpt_msg_params.has());
    paramArrayOfByte = ((SubMsgType0x83.MsgBody)localObject).rpt_msg_params;
    if (((SubMsgType0x83.MsgBody)localObject).uint64_seq.has()) {}
    for (long l1 = ((SubMsgType0x83.MsgBody)localObject).uint64_seq.get();; l1 = -1L)
    {
      if (((SubMsgType0x83.MsgBody)localObject).uint64_group_id.has()) {}
      for (long l2 = ((SubMsgType0x83.MsgBody)localObject).uint64_group_id.get();; l2 = -1L)
      {
        int i = 0;
        label133:
        if (i < paramArrayOfByte.size())
        {
          localObject = (SubMsgType0x83.MsgParams)paramArrayOfByte.get(i);
          if ((localObject != null) && (((SubMsgType0x83.MsgParams)localObject).uint32_type.has())) {
            break label174;
          }
        }
        for (;;)
        {
          i += 1;
          break label133;
          break;
          label174:
          int j = ((SubMsgType0x83.MsgParams)localObject).uint32_type.get();
          a(paramacnk.a(), l1, l2, (SubMsgType0x83.MsgParams)localObject, j);
        }
      }
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2, SubMsgType0x83.MsgParams paramMsgParams, int paramInt)
  {
    if ((paramInt >= 2001) && (paramInt <= 3000)) {
      if ((paramMsgParams.str_data.has()) && (paramMsgParams.uint64_from_uin.has()) && (paramMsgParams.uint64_to_uin.has())) {}
    }
    do
    {
      int i;
      do
      {
        return;
        localObject = paramMsgParams.str_data.get();
        try
        {
          i = new JSONObject((String)localObject).getInt("count");
          paramQQAppInterface.getGAudioHandler().a(paramInt, paramMsgParams.uint64_from_uin.get(), paramMsgParams.uint64_to_uin.get(), i, paramLong1, paramLong2);
          return;
        }
        catch (Exception paramQQAppInterface)
        {
          return;
        }
        if (paramInt != 1005) {
          break;
        }
      } while ((!paramMsgParams.str_data.has()) || (!paramMsgParams.uint64_from_uin.has()) || (!paramMsgParams.uint64_to_uin.has()));
      Object localObject = paramMsgParams.str_data.get();
      try
      {
        localObject = new JSONObject((String)localObject);
        paramInt = ((JSONObject)localObject).optInt("enable");
        i = ((JSONObject)localObject).optInt("level");
        paramQQAppInterface.getGAudioHandler().a(paramMsgParams.uint32_type.get(), paramMsgParams.uint64_from_uin.get(), paramMsgParams.uint64_to_uin.get(), paramInt, i, paramLong1, paramLong2);
        return;
      }
      catch (Exception paramQQAppInterface)
      {
        return;
      }
    } while ((paramInt != 1010) || (!paramMsgParams.bytes_data.has()));
    paramMsgParams = new String(paramMsgParams.bytes_data.get().toByteArray());
    for (;;)
    {
      try
      {
        paramMsgParams = new JSONObject(paramMsgParams);
        if (paramMsgParams.getInt("sndRank") != 0)
        {
          paramInt = 1;
          boolean bool = paramMsgParams.getBoolean("rank_changed");
          if ((paramInt == 0) || (!bool)) {
            break;
          }
          paramQQAppInterface.getGAudioHandler().a(paramLong2);
          return;
        }
      }
      catch (Exception paramQQAppInterface)
      {
        return;
      }
      paramInt = 0;
    }
  }
  
  public MessageRecord a(acnk paramacnk, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a(paramacnk, paramMsgType0x210.vProtobuf);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acru
 * JD-Core Version:    0.7.0.1
 */