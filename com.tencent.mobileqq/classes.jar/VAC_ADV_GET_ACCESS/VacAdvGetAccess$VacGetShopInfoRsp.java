package VAC_ADV_GET_ACCESS;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class VacAdvGetAccess$VacGetShopInfoRsp
  extends MessageMicro<VacGetShopInfoRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "err_code", "err_msg", "shop_info" }, new Object[] { Integer.valueOf(0), "", null }, VacGetShopInfoRsp.class);
  public final PBInt32Field err_code = PBField.initInt32(0);
  public final PBStringField err_msg = PBField.initString("");
  public VacAdvGetAccess.VacGetShopInfoRsp.ShopInfo shop_info = new VacAdvGetAccess.VacGetShopInfoRsp.ShopInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     VAC_ADV_GET_ACCESS.VacAdvGetAccess.VacGetShopInfoRsp
 * JD-Core Version:    0.7.0.1
 */