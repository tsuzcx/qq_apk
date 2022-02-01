package VAC_ADV_GET_ACCESS;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class VacAdvGetAccess$VacGroupCoverGoodsReq$Product
  extends MessageMicro<Product>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "product_id", "production_token" }, new Object[] { Long.valueOf(0L), "" }, Product.class);
  public final PBInt64Field product_id = PBField.initInt64(0L);
  public final PBStringField production_token = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     VAC_ADV_GET_ACCESS.VacAdvGetAccess.VacGroupCoverGoodsReq.Product
 * JD-Core Version:    0.7.0.1
 */