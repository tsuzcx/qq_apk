package NS_CERTIFIED_ACCOUNT;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class CertifiedAccountMeta$StLike
  extends MessageMicro<StLike>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34 }, new String[] { "id", "count", "status", "vecUser" }, new Object[] { "", Integer.valueOf(0), Integer.valueOf(0), null }, StLike.class);
  public final PBUInt32Field count = PBField.initUInt32(0);
  public final PBStringField id = PBField.initString("");
  public final PBUInt32Field status = PBField.initUInt32(0);
  public final PBRepeatMessageField<CertifiedAccountMeta.StUser> vecUser = PBField.initRepeatMessage(CertifiedAccountMeta.StUser.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StLike
 * JD-Core Version:    0.7.0.1
 */