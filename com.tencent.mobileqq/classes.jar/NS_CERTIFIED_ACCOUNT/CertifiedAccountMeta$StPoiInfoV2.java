package NS_CERTIFIED_ACCOUNT;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class CertifiedAccountMeta$StPoiInfoV2
  extends MessageMicro<StPoiInfoV2>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 42, 48, 58, 64, 72, 82, 90, 98, 106, 112, 120, 130, 138, 146 }, new String[] { "poiId", "name", "poiType", "typeName", "address", "districtCode", "gps", "distance", "hotValue", "phone", "country", "province", "city", "poiNum", "poiOrderType", "defaultName", "district", "dianPingId" }, new Object[] { "", "", Integer.valueOf(0), "", "", Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), "", "", "", "", Integer.valueOf(0), Integer.valueOf(0), "", "", "" }, StPoiInfoV2.class);
  public final PBStringField address = PBField.initString("");
  public final PBStringField city = PBField.initString("");
  public final PBStringField country = PBField.initString("");
  public final PBStringField defaultName = PBField.initString("");
  public final PBStringField dianPingId = PBField.initString("");
  public final PBInt32Field distance = PBField.initInt32(0);
  public final PBStringField district = PBField.initString("");
  public final PBInt32Field districtCode = PBField.initInt32(0);
  public CertifiedAccountMeta.StGPSV2 gps = new CertifiedAccountMeta.StGPSV2();
  public final PBInt32Field hotValue = PBField.initInt32(0);
  public final PBStringField name = PBField.initString("");
  public final PBStringField phone = PBField.initString("");
  public final PBStringField poiId = PBField.initString("");
  public final PBInt32Field poiNum = PBField.initInt32(0);
  public final PBInt32Field poiOrderType = PBField.initInt32(0);
  public final PBInt32Field poiType = PBField.initInt32(0);
  public final PBStringField province = PBField.initString("");
  public final PBStringField typeName = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StPoiInfoV2
 * JD-Core Version:    0.7.0.1
 */