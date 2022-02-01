package VAC_ADV_GET_ACCESS;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class VacAdvGetAccess$VacGetShopInfoReq
  extends MessageMicro<VacGetShopInfoReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "ware_house_id", "media_type", "invitation_code", "invitation_code_str" }, new Object[] { Integer.valueOf(100), Integer.valueOf(0), Long.valueOf(0L), "" }, VacGetShopInfoReq.class);
  public final PBInt64Field invitation_code = PBField.initInt64(0L);
  public final PBStringField invitation_code_str = PBField.initString("");
  public final PBInt32Field media_type = PBField.initInt32(0);
  public final PBEnumField ware_house_id = PBField.initEnum(100);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     VAC_ADV_GET_ACCESS.VacAdvGetAccess.VacGetShopInfoReq
 * JD-Core Version:    0.7.0.1
 */