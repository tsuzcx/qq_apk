package NS_CERTIFIED_ACCOUNT;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class CertifiedAccountMeta$StReply
  extends MessageMicro<StReply>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField content = PBField.initString("");
  public final PBUInt64Field createTime = PBField.initUInt64(0L);
  public final PBStringField id = PBField.initString("");
  public CertifiedAccountMeta.StUser postUser = new CertifiedAccountMeta.StUser();
  public CertifiedAccountMeta.StUser targetUser = new CertifiedAccountMeta.StUser();
  public final PBRepeatField<Long> vecAtUin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 42, 48 }, new String[] { "id", "postUser", "createTime", "content", "targetUser", "vecAtUin" }, new Object[] { "", null, localLong, "", null, localLong }, StReply.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StReply
 * JD-Core Version:    0.7.0.1
 */