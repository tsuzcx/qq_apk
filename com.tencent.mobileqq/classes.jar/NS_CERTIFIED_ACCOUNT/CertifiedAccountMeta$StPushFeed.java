package NS_CERTIFIED_ACCOUNT;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class CertifiedAccountMeta$StPushFeed
  extends MessageMicro<StPushFeed>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40, 48 }, new String[] { "feedId", "cover", "userId", "title", "type", "feedCreateTime" }, new Object[] { "", null, "", "", Integer.valueOf(0), Integer.valueOf(0) }, StPushFeed.class);
  public CertifiedAccountMeta.StImage cover = new CertifiedAccountMeta.StImage();
  public final PBUInt32Field feedCreateTime = PBField.initUInt32(0);
  public final PBStringField feedId = PBField.initString("");
  public final PBStringField title = PBField.initString("");
  public final PBUInt32Field type = PBField.initUInt32(0);
  public final PBStringField userId = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StPushFeed
 * JD-Core Version:    0.7.0.1
 */