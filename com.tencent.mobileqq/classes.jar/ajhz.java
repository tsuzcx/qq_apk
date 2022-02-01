import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.general_group_notify.general_group_notify.GroupNotify;
import tencent.im.oidb.general_group_notify.general_group_notify.InviteJoinGroupSecFront;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public class ajhz
  extends ajhx
{
  public ajia a(structmsg.StructMsg paramStructMsg)
  {
    general_group_notify.GroupNotify localGroupNotify = null;
    Object localObject = localGroupNotify;
    ByteStringMicro localByteStringMicro;
    if (paramStructMsg != null)
    {
      localObject = localGroupNotify;
      if (paramStructMsg.msg.bytes_transparent_group_notify.has())
      {
        localByteStringMicro = paramStructMsg.msg.bytes_transparent_group_notify.get();
        localObject = localGroupNotify;
        if (localByteStringMicro == null) {}
      }
    }
    for (;;)
    {
      try
      {
        paramStructMsg = new ajia();
        int i;
        localInvalidProtocolBufferMicroException1.printStackTrace();
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException1)
      {
        try
        {
          localObject = localByteStringMicro.toByteArray();
          localGroupNotify = new general_group_notify.GroupNotify();
          localGroupNotify.mergeFrom((byte[])localObject);
          i = localGroupNotify.opt_uint32_msg_type.get();
          paramStructMsg.b = i;
          if ((i == 2) && (localGroupNotify.opt_st_sec_front_info.has()))
          {
            localObject = (general_group_notify.InviteJoinGroupSecFront)localGroupNotify.opt_st_sec_front_info.get();
            if (localObject != null) {
              paramStructMsg.a = ((general_group_notify.InviteJoinGroupSecFront)localObject).opt_uint32_index.get();
            }
          }
          localObject = paramStructMsg;
          if ((localObject != null) && (QLog.isColorLevel())) {
            QLog.i(this.a, 1, "info:" + ((ajia)localObject).toString());
          }
          return localObject;
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException2)
        {
          structmsg.StructMsg localStructMsg;
          break label180;
        }
        localInvalidProtocolBufferMicroException1 = localInvalidProtocolBufferMicroException1;
        paramStructMsg = null;
      }
      label180:
      QLog.d(this.a, 1, "InviteJoinGroupSecFrontInfo", localInvalidProtocolBufferMicroException1);
      localStructMsg = paramStructMsg;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajhz
 * JD-Core Version:    0.7.0.1
 */