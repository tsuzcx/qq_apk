package VAC_ADV_GET_ACCESS;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import common.QqAdGetProtos.QQAdGet.DeviceInfo;

public final class VacAdvGetAccess$VacManagerGetGoodsListReq
  extends MessageMicro<VacManagerGetGoodsListReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField content_id = PBField.initString("");
  public final PBInt32Field content_type = PBField.initInt32(0);
  public QqAdGetProtos.QQAdGet.DeviceInfo device_info = new QqAdGetProtos.QQAdGet.DeviceInfo();
  public final PBStringField group_owner_openid = PBField.initString("");
  public final PBInt32Field media_type = PBField.initInt32(0);
  public final PBInt32Field page_number = PBField.initInt32(0);
  public final PBInt32Field page_size = PBField.initInt32(0);
  public final PBUInt64Field seller_id = PBField.initUInt64(0L);
  public final PBEnumField ware_house_id = PBField.initEnum(100);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 48, 58, 66, 72 }, new String[] { "ware_house_id", "media_type", "content_type", "content_id", "page_number", "page_size", "group_owner_openid", "device_info", "seller_id" }, new Object[] { Integer.valueOf(100), localInteger, localInteger, "", localInteger, localInteger, "", null, Long.valueOf(0L) }, VacManagerGetGoodsListReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     VAC_ADV_GET_ACCESS.VacAdvGetAccess.VacManagerGetGoodsListReq
 * JD-Core Version:    0.7.0.1
 */