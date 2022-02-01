import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.general_group_notify.general_group_notify.ApplyAlliance;
import tencent.im.oidb.general_group_notify.general_group_notify.GroupAllianceNotify;
import tencent.im.oidb.general_group_notify.general_group_notify.GroupNotify;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public class ajhv
  extends ajhx
{
  public ajhw a(structmsg.StructMsg paramStructMsg)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    ByteStringMicro localByteStringMicro;
    if (paramStructMsg != null)
    {
      localObject1 = localObject2;
      if (paramStructMsg.msg.bytes_transparent_group_notify.has())
      {
        localByteStringMicro = paramStructMsg.msg.bytes_transparent_group_notify.get();
        localObject1 = localObject2;
        if (localByteStringMicro == null) {}
      }
    }
    try
    {
      paramStructMsg = new ajhw();
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException1)
    {
      for (;;)
      {
        int i;
        label199:
        label372:
        paramStructMsg = null;
        label287:
        label327:
        localInvalidProtocolBufferMicroException1.printStackTrace();
        label416:
        label422:
        QLog.d(this.jdField_a_of_type_JavaLangString, 1, "AllianceGeneralGroupNotifyInfo", localInvalidProtocolBufferMicroException1);
        structmsg.StructMsg localStructMsg = paramStructMsg;
      }
    }
    try
    {
      localObject1 = localByteStringMicro.toByteArray();
      localObject2 = new general_group_notify.GroupNotify();
      ((general_group_notify.GroupNotify)localObject2).mergeFrom((byte[])localObject1);
      i = ((general_group_notify.GroupNotify)localObject2).opt_uint32_msg_type.get();
      paramStructMsg.jdField_b_of_type_Int = i;
      if ((i != 1) || (!((general_group_notify.GroupNotify)localObject2).opt_st_alliance_notify.has())) {
        break label372;
      }
      localObject2 = (general_group_notify.GroupAllianceNotify)((general_group_notify.GroupNotify)localObject2).opt_st_alliance_notify.get();
      if (localObject2 == null) {
        break label372;
      }
      paramStructMsg.jdField_c_of_type_Int = ((general_group_notify.GroupAllianceNotify)localObject2).uint32_alliance_notify_type.get();
      if (!((general_group_notify.GroupAllianceNotify)localObject2).bytes_alliance_name.has()) {
        break label416;
      }
      localObject1 = ((general_group_notify.GroupAllianceNotify)localObject2).bytes_alliance_name.get().toStringUtf8();
      paramStructMsg.jdField_a_of_type_JavaLangString = ((String)localObject1);
      paramStructMsg.jdField_a_of_type_Long = ((general_group_notify.GroupAllianceNotify)localObject2).uint64_alliance_id.get();
      if (!((general_group_notify.GroupAllianceNotify)localObject2).bytes_alliance_owner_name.has()) {
        break label455;
      }
      localObject1 = ((general_group_notify.GroupAllianceNotify)localObject2).bytes_alliance_owner_name.get().toStringUtf8();
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException2)
    {
      break label431;
      String str = "";
      break label199;
      str = "";
      break label287;
      str = "";
      break label327;
    }
    paramStructMsg.jdField_b_of_type_JavaLangString = ((String)localObject1);
    paramStructMsg.jdField_b_of_type_Long = ((general_group_notify.GroupAllianceNotify)localObject2).uint64_leader_group_code.get();
    paramStructMsg.jdField_a_of_type_Int = ((general_group_notify.GroupAllianceNotify)localObject2).uint32_result.get();
    if (((general_group_notify.GroupAllianceNotify)localObject2).st_apply_alliance.has())
    {
      localObject2 = (general_group_notify.ApplyAlliance)((general_group_notify.GroupAllianceNotify)localObject2).st_apply_alliance.get();
      paramStructMsg.jdField_c_of_type_Long = ((general_group_notify.ApplyAlliance)localObject2).uint64_apply_group_code.get();
      if (!((general_group_notify.ApplyAlliance)localObject2).bytes_apply_group_name.has()) {
        break label461;
      }
      localObject1 = ((general_group_notify.ApplyAlliance)localObject2).bytes_apply_group_name.get().toStringUtf8();
      paramStructMsg.jdField_c_of_type_JavaLangString = ((String)localObject1);
      paramStructMsg.jdField_d_of_type_Long = ((general_group_notify.ApplyAlliance)localObject2).uint64_apply_group_owner_uin.get();
      if (!((general_group_notify.ApplyAlliance)localObject2).bytes_apply_group_owner_name.has()) {
        break label467;
      }
      localObject1 = ((general_group_notify.ApplyAlliance)localObject2).bytes_apply_group_owner_name.get().toStringUtf8();
      paramStructMsg.jdField_d_of_type_JavaLangString = ((String)localObject1);
      paramStructMsg.jdField_e_of_type_Long = ((general_group_notify.ApplyAlliance)localObject2).uint64_source_group_uin.get();
      if (!((general_group_notify.ApplyAlliance)localObject2).bytes_source_group_name.has()) {
        break label422;
      }
    }
    for (localObject1 = ((general_group_notify.ApplyAlliance)localObject2).bytes_source_group_name.get().toStringUtf8();; localObject1 = "")
    {
      paramStructMsg.jdField_e_of_type_JavaLangString = ((String)localObject1);
      localObject1 = paramStructMsg;
      if ((localObject1 != null) && (QLog.isColorLevel())) {
        QLog.i(this.jdField_a_of_type_JavaLangString, 1, "info:" + ((ajhw)localObject1).toString());
      }
      return localObject1;
      localObject1 = "";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajhv
 * JD-Core Version:    0.7.0.1
 */