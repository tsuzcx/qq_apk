package NS_CERTIFIED_ACCOUNT;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class CertifiedAccountMeta$StNotice
  extends MessageMicro<StNotice>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 42 }, new String[] { "feedId", "noticeType", "createTime", "operation", "feed" }, new Object[] { "", Integer.valueOf(0), Long.valueOf(0L), null, null }, StNotice.class);
  public final PBUInt64Field createTime = PBField.initUInt64(0L);
  public CertifiedAccountMeta.StFeed feed = new CertifiedAccountMeta.StFeed();
  public final PBStringField feedId = PBField.initString("");
  public final PBUInt32Field noticeType = PBField.initUInt32(0);
  public CertifiedAccountMeta.StOperation operation = new CertifiedAccountMeta.StOperation();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StNotice
 * JD-Core Version:    0.7.0.1
 */