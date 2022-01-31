package NS_CERTIFIED_ACCOUNT;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class CertifiedAccountMeta$StMessageStatus
  extends MessageMicro<StMessageStatus>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "readStatus", "jumpURL", "noticeCount" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0) }, StMessageStatus.class);
  public final PBStringField jumpURL = PBField.initString("");
  public final PBUInt32Field noticeCount = PBField.initUInt32(0);
  public final PBUInt32Field readStatus = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StMessageStatus
 * JD-Core Version:    0.7.0.1
 */