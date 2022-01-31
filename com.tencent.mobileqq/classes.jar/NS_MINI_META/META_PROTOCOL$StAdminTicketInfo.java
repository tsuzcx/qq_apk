package NS_MINI_META;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class META_PROTOCOL$StAdminTicketInfo
  extends MessageMicro<StAdminTicketInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 42, 50 }, new String[] { "developerId", "createTimestamp", "renewTimestamp", "pwd", "uin", "A2Key" }, new Object[] { "", Integer.valueOf(0), Integer.valueOf(0), "", "", "" }, StAdminTicketInfo.class);
  public final PBStringField A2Key = PBField.initString("");
  public final PBUInt32Field createTimestamp = PBField.initUInt32(0);
  public final PBStringField developerId = PBField.initString("");
  public final PBStringField pwd = PBField.initString("");
  public final PBUInt32Field renewTimestamp = PBField.initUInt32(0);
  public final PBStringField uin = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MINI_META.META_PROTOCOL.StAdminTicketInfo
 * JD-Core Version:    0.7.0.1
 */