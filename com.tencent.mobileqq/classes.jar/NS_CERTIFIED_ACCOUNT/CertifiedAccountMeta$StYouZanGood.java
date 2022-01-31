package NS_CERTIFIED_ACCOUNT;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class CertifiedAccountMeta$StYouZanGood
  extends MessageMicro<StYouZanGood>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 40, 50 }, new String[] { "title", "img", "price", "url", "itemID", "alias" }, new Object[] { "", "", Long.valueOf(0L), "", Long.valueOf(0L), "" }, StYouZanGood.class);
  public final PBStringField alias = PBField.initString("");
  public final PBStringField img = PBField.initString("");
  public final PBInt64Field itemID = PBField.initInt64(0L);
  public final PBUInt64Field price = PBField.initUInt64(0L);
  public final PBStringField title = PBField.initString("");
  public final PBStringField url = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StYouZanGood
 * JD-Core Version:    0.7.0.1
 */