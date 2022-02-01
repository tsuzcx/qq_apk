package VAC_ADV_GET_ACCESS;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class VacAdvGetAccess$VacGetShopInfoRsp$ShopInfo
  extends MessageMicro<ShopInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "media_name", "image_url" }, new Object[] { "", "" }, ShopInfo.class);
  public final PBStringField image_url = PBField.initString("");
  public final PBStringField media_name = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     VAC_ADV_GET_ACCESS.VacAdvGetAccess.VacGetShopInfoRsp.ShopInfo
 * JD-Core Version:    0.7.0.1
 */