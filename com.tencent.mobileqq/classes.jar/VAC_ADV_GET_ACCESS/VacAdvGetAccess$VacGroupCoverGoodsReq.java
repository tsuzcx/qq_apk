package VAC_ADV_GET_ACCESS;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class VacAdvGetAccess$VacGroupCoverGoodsReq
  extends MessageMicro<VacGroupCoverGoodsReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 40, 50, 56 }, new String[] { "ware_house_id", "media_type", "content_id", "content_type", "product_id_list", "product_list", "seller_id" }, new Object[] { Integer.valueOf(100), Integer.valueOf(0), "", Integer.valueOf(0), Long.valueOf(0L), null, Long.valueOf(0L) }, VacGroupCoverGoodsReq.class);
  public final PBStringField content_id = PBField.initString("");
  public final PBInt32Field content_type = PBField.initInt32(0);
  public final PBInt32Field media_type = PBField.initInt32(0);
  public final PBRepeatField<Long> product_id_list = PBField.initRepeat(PBInt64Field.__repeatHelper__);
  public final PBRepeatMessageField<VacAdvGetAccess.VacGroupCoverGoodsReq.Product> product_list = PBField.initRepeatMessage(VacAdvGetAccess.VacGroupCoverGoodsReq.Product.class);
  public final PBUInt64Field seller_id = PBField.initUInt64(0L);
  public final PBEnumField ware_house_id = PBField.initEnum(100);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     VAC_ADV_GET_ACCESS.VacAdvGetAccess.VacGroupCoverGoodsReq
 * JD-Core Version:    0.7.0.1
 */