package VAC_ADV_GET_ACCESS;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class VacAdvGetAccess$VacShopUnbindWindowReq
  extends MessageMicro<VacShopUnbindWindowReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField content_id = PBField.initString("");
  public final PBInt32Field content_type = PBField.initInt32(0);
  public final PBInt32Field media_type = PBField.initInt32(0);
  public final PBEnumField ware_house_id = PBField.initEnum(100);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "ware_house_id", "media_type", "content_type", "content_id" }, new Object[] { Integer.valueOf(100), localInteger, localInteger, "" }, VacShopUnbindWindowReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     VAC_ADV_GET_ACCESS.VacAdvGetAccess.VacShopUnbindWindowReq
 * JD-Core Version:    0.7.0.1
 */