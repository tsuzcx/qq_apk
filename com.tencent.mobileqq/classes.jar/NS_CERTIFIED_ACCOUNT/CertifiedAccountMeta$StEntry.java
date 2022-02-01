package NS_CERTIFIED_ACCOUNT;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class CertifiedAccountMeta$StEntry
  extends MessageMicro<StEntry>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public CertifiedAccountMeta.StImage cover = new CertifiedAccountMeta.StImage();
  public final PBStringField title = PBField.initString("");
  public final PBUInt32Field type = PBField.initUInt32(0);
  public final PBUInt32Field updateCount = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32 }, new String[] { "cover", "title", "updateCount", "type" }, new Object[] { null, "", localInteger, localInteger }, StEntry.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StEntry
 * JD-Core Version:    0.7.0.1
 */