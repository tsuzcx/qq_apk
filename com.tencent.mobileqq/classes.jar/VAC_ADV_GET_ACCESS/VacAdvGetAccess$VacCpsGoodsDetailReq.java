package VAC_ADV_GET_ACCESS;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class VacAdvGetAccess$VacCpsGoodsDetailReq
  extends MessageMicro<VacCpsGoodsDetailReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "uid", "goods_id", "ware_house_id" }, new Object[] { "", "", Integer.valueOf(0) }, VacCpsGoodsDetailReq.class);
  public final PBStringField goods_id = PBField.initString("");
  public final PBStringField uid = PBField.initString("");
  public final PBInt32Field ware_house_id = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     VAC_ADV_GET_ACCESS.VacAdvGetAccess.VacCpsGoodsDetailReq
 * JD-Core Version:    0.7.0.1
 */