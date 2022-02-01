package NS_CERTIFIED_ACCOUNT;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class CertifiedAccountMeta$StOperation
  extends MessageMicro<StOperation>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 42 }, new String[] { "opType", "opUser", "opTime", "comment", "like" }, new Object[] { Integer.valueOf(0), null, Long.valueOf(0L), null, null }, StOperation.class);
  public CertifiedAccountMeta.StComment comment = new CertifiedAccountMeta.StComment();
  public CertifiedAccountMeta.StLike like = new CertifiedAccountMeta.StLike();
  public final PBUInt64Field opTime = PBField.initUInt64(0L);
  public final PBUInt32Field opType = PBField.initUInt32(0);
  public CertifiedAccountMeta.StUser opUser = new CertifiedAccountMeta.StUser();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StOperation
 * JD-Core Version:    0.7.0.1
 */