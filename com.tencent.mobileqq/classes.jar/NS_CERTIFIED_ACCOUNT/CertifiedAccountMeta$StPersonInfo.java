package NS_CERTIFIED_ACCOUNT;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class CertifiedAccountMeta$StPersonInfo
  extends MessageMicro<StPersonInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42 }, new String[] { "sex", "birthday", "constellation", "school", "location" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), "", "", "" }, StPersonInfo.class);
  public final PBUInt64Field birthday = PBField.initUInt64(0L);
  public final PBStringField constellation = PBField.initString("");
  public final PBStringField location = PBField.initString("");
  public final PBStringField school = PBField.initString("");
  public final PBUInt32Field sex = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StPersonInfo
 * JD-Core Version:    0.7.0.1
 */