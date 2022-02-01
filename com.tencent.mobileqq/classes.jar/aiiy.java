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

public class aiiy
  extends aijf
{
  public int a;
  public long a;
  public String a;
  public long b;
  public String b;
  public long c;
  public String c;
  public long d;
  public String d;
  public long e;
  public String e;
  
  public aiiy(structmsg.StructMsg paramStructMsg)
  {
    super(paramStructMsg);
  }
  
  public void a(structmsg.StructMsg paramStructMsg)
  {
    if ((paramStructMsg != null) && (paramStructMsg.msg.bytes_transparent_group_notify.has()))
    {
      paramStructMsg = paramStructMsg.msg.bytes_transparent_group_notify.get();
      if (paramStructMsg == null) {}
    }
    for (;;)
    {
      try
      {
        paramStructMsg = paramStructMsg.toByteArray();
        Object localObject = new general_group_notify.GroupNotify();
        ((general_group_notify.GroupNotify)localObject).mergeFrom(paramStructMsg);
        this.jdField_b_of_type_Int = ((general_group_notify.GroupNotify)localObject).opt_uint32_msg_type.get();
        if ((this.jdField_b_of_type_Int == 1) && (((general_group_notify.GroupNotify)localObject).opt_st_alliance_notify.has()))
        {
          localObject = (general_group_notify.GroupAllianceNotify)((general_group_notify.GroupNotify)localObject).opt_st_alliance_notify.get();
          if (localObject != null)
          {
            this.jdField_c_of_type_Int = ((general_group_notify.GroupAllianceNotify)localObject).uint32_alliance_notify_type.get();
            if (!((general_group_notify.GroupAllianceNotify)localObject).bytes_alliance_name.has()) {
              break label350;
            }
            paramStructMsg = ((general_group_notify.GroupAllianceNotify)localObject).bytes_alliance_name.get().toStringUtf8();
            this.jdField_a_of_type_JavaLangString = paramStructMsg;
            this.jdField_a_of_type_Long = ((general_group_notify.GroupAllianceNotify)localObject).uint64_alliance_id.get();
            if (!((general_group_notify.GroupAllianceNotify)localObject).bytes_alliance_owner_name.has()) {
              break label356;
            }
            paramStructMsg = ((general_group_notify.GroupAllianceNotify)localObject).bytes_alliance_owner_name.get().toStringUtf8();
            this.jdField_b_of_type_JavaLangString = paramStructMsg;
            this.jdField_b_of_type_Long = ((general_group_notify.GroupAllianceNotify)localObject).uint64_leader_group_code.get();
            this.jdField_a_of_type_Int = ((general_group_notify.GroupAllianceNotify)localObject).uint32_result.get();
            if (((general_group_notify.GroupAllianceNotify)localObject).st_apply_alliance.has())
            {
              localObject = (general_group_notify.ApplyAlliance)((general_group_notify.GroupAllianceNotify)localObject).st_apply_alliance.get();
              this.jdField_c_of_type_Long = ((general_group_notify.ApplyAlliance)localObject).uint64_apply_group_code.get();
              if (!((general_group_notify.ApplyAlliance)localObject).bytes_apply_group_name.has()) {
                break label362;
              }
              paramStructMsg = ((general_group_notify.ApplyAlliance)localObject).bytes_apply_group_name.get().toStringUtf8();
              this.jdField_c_of_type_JavaLangString = paramStructMsg;
              this.jdField_d_of_type_Long = ((general_group_notify.ApplyAlliance)localObject).uint64_apply_group_owner_uin.get();
              if (!((general_group_notify.ApplyAlliance)localObject).bytes_apply_group_owner_name.has()) {
                break label368;
              }
              paramStructMsg = ((general_group_notify.ApplyAlliance)localObject).bytes_apply_group_owner_name.get().toStringUtf8();
              this.jdField_d_of_type_JavaLangString = paramStructMsg;
              this.jdField_e_of_type_Long = ((general_group_notify.ApplyAlliance)localObject).uint64_source_group_uin.get();
              if (!((general_group_notify.ApplyAlliance)localObject).bytes_source_group_name.has()) {
                continue;
              }
              paramStructMsg = ((general_group_notify.ApplyAlliance)localObject).bytes_source_group_name.get().toStringUtf8();
              this.jdField_e_of_type_JavaLangString = paramStructMsg;
            }
          }
        }
        this.jdField_a_of_type_Boolean = true;
        return;
        paramStructMsg = "";
        continue;
        return;
      }
      catch (InvalidProtocolBufferMicroException paramStructMsg)
      {
        paramStructMsg.printStackTrace();
        QLog.d("GeneralGroupNotifyParser", 1, "bindTroopSystemMsgView_setThirdLineText", paramStructMsg);
      }
      label350:
      paramStructMsg = "";
      continue;
      label356:
      paramStructMsg = "";
      continue;
      label362:
      paramStructMsg = "";
      continue;
      label368:
      paramStructMsg = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiiy
 * JD-Core Version:    0.7.0.1
 */