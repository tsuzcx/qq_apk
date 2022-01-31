package NS_CERTIFIED_ACCOUNT;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class CertifiedAccountMeta$StUser
  extends MessageMicro<StUser>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40, 48, 58, 66, 72, 82, 90, 98, 106, 114 }, new String[] { "id", "nick", "icon", "desc", "followState", "type", "email", "telNum", "attr", "youZhan", "yzOrderPage", "registerCertifiedAccountUrl", "personInfo", "iconInfo" }, new Object[] { "", "", "", "", Integer.valueOf(0), Integer.valueOf(0), "", "", Long.valueOf(0L), null, "", "", null, null }, StUser.class);
  public final PBUInt64Field attr = PBField.initUInt64(0L);
  public final PBStringField desc = PBField.initString("");
  public final PBStringField email = PBField.initString("");
  public final PBUInt32Field followState = PBField.initUInt32(0);
  public final PBStringField icon = PBField.initString("");
  public CertifiedAccountMeta.StIconInfo iconInfo = new CertifiedAccountMeta.StIconInfo();
  public final PBStringField id = PBField.initString("");
  public final PBStringField nick = PBField.initString("");
  public CertifiedAccountMeta.StPersonInfo personInfo = new CertifiedAccountMeta.StPersonInfo();
  public final PBStringField registerCertifiedAccountUrl = PBField.initString("");
  public final PBStringField telNum = PBField.initString("");
  public final PBUInt32Field type = PBField.initUInt32(0);
  public final PBRepeatMessageField<CertifiedAccountMeta.StYouZanShop> youZhan = PBField.initRepeatMessage(CertifiedAccountMeta.StYouZanShop.class);
  public final PBStringField yzOrderPage = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser
 * JD-Core Version:    0.7.0.1
 */