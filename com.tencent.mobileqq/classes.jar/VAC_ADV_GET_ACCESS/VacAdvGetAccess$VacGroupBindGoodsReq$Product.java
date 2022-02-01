package VAC_ADV_GET_ACCESS;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class VacAdvGetAccess$VacGroupBindGoodsReq$Product
  extends MessageMicro<Product>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt64Field index = PBField.initInt64(0L);
  public final PBInt64Field product_id = PBField.initInt64(0L);
  public final PBStringField production_token = PBField.initString("");
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "product_id", "index", "production_token" }, new Object[] { localLong, localLong, "" }, Product.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     VAC_ADV_GET_ACCESS.VacAdvGetAccess.VacGroupBindGoodsReq.Product
 * JD-Core Version:    0.7.0.1
 */