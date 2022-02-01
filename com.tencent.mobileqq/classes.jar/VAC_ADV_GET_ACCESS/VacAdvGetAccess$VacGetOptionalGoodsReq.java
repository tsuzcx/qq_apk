package VAC_ADV_GET_ACCESS;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class VacAdvGetAccess$VacGetOptionalGoodsReq
  extends MessageMicro<VacGetOptionalGoodsReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField content_id = PBField.initString("");
  public final PBInt32Field content_type = PBField.initInt32(0);
  public final PBStringField group_owner_openid = PBField.initString("");
  public final PBInt32Field media_type = PBField.initInt32(0);
  public final PBInt32Field page_number = PBField.initInt32(0);
  public final PBInt32Field page_size = PBField.initInt32(0);
  public final PBUInt64Field seller_id = PBField.initUInt64(0L);
  public final PBEnumField ware_house_id = PBField.initEnum(100);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 48, 58, 64 }, new String[] { "ware_house_id", "media_type", "content_type", "content_id", "page_number", "page_size", "group_owner_openid", "seller_id" }, new Object[] { Integer.valueOf(100), localInteger, localInteger, "", localInteger, localInteger, "", Long.valueOf(0L) }, VacGetOptionalGoodsReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     VAC_ADV_GET_ACCESS.VacAdvGetAccess.VacGetOptionalGoodsReq
 * JD-Core Version:    0.7.0.1
 */