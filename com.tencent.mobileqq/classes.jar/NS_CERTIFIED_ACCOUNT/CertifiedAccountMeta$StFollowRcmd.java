package NS_CERTIFIED_ACCOUNT;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class CertifiedAccountMeta$StFollowRcmd
  extends MessageMicro<StFollowRcmd>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32 }, new String[] { "user", "feedList", "reason", "fansCount" }, new Object[] { null, null, "", Integer.valueOf(0) }, StFollowRcmd.class);
  public final PBUInt32Field fansCount = PBField.initUInt32(0);
  public final PBRepeatMessageField<CertifiedAccountMeta.StFeed> feedList = PBField.initRepeatMessage(CertifiedAccountMeta.StFeed.class);
  public final PBStringField reason = PBField.initString("");
  public CertifiedAccountMeta.StUser user = new CertifiedAccountMeta.StUser();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFollowRcmd
 * JD-Core Version:    0.7.0.1
 */