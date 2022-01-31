package NS_MINI_META;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class META_PROTOCOL$StVersionAuditInfo
  extends MessageMicro<StVersionAuditInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 42, 50 }, new String[] { "versionId", "createTime", "updateTime", "updateInstruction", "testAccount", "rejectReason" }, new Object[] { "", Integer.valueOf(0), Integer.valueOf(0), "", null, "" }, StVersionAuditInfo.class);
  public final PBUInt32Field createTime = PBField.initUInt32(0);
  public final PBStringField rejectReason = PBField.initString("");
  public final PBRepeatMessageField<META_PROTOCOL.StTestAccount> testAccount = PBField.initRepeatMessage(META_PROTOCOL.StTestAccount.class);
  public final PBStringField updateInstruction = PBField.initString("");
  public final PBUInt32Field updateTime = PBField.initUInt32(0);
  public final PBStringField versionId = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MINI_META.META_PROTOCOL.StVersionAuditInfo
 * JD-Core Version:    0.7.0.1
 */