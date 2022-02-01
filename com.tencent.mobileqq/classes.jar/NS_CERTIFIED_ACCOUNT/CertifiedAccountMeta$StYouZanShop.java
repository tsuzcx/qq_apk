package NS_CERTIFIED_ACCOUNT;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class CertifiedAccountMeta$StYouZanShop
  extends MessageMicro<StYouZanShop>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field goodNum = PBField.initUInt32(0);
  public final PBRepeatMessageField<CertifiedAccountMeta.StYouZanGood> goods = PBField.initRepeatMessage(CertifiedAccountMeta.StYouZanGood.class);
  public final PBStringField id = PBField.initString("");
  public final PBStringField name = PBField.initString("");
  public final PBStringField schema = PBField.initString("");
  public final PBUInt32Field type = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 50 }, new String[] { "type", "id", "name", "schema", "goodNum", "goods" }, new Object[] { localInteger, "", "", "", localInteger, null }, StYouZanShop.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StYouZanShop
 * JD-Core Version:    0.7.0.1
 */