package NS_CERTIFIED_ACCOUNT;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class CertifiedAccountMeta$StComment
  extends MessageMicro<StComment>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField content = PBField.initString("");
  public final PBUInt64Field createTime = PBField.initUInt64(0L);
  public final PBStringField id = PBField.initString("");
  public CertifiedAccountMeta.StUser postUser = new CertifiedAccountMeta.StUser();
  public final PBUInt32Field replyCount = PBField.initUInt32(0);
  public final PBRepeatField<Long> vecAtUin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBRepeatMessageField<CertifiedAccountMeta.StReply> vecReply = PBField.initRepeatMessage(CertifiedAccountMeta.StReply.class);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 40, 48, 58 }, new String[] { "id", "postUser", "createTime", "content", "vecAtUin", "replyCount", "vecReply" }, new Object[] { "", null, localLong, "", localLong, Integer.valueOf(0), null }, StComment.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StComment
 * JD-Core Version:    0.7.0.1
 */