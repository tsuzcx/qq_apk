package VAC_ADV_GET_ACCESS;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class VacAdvGetAccess$VacMemberGetOrderCntReq
  extends MessageMicro<VacMemberGetOrderCntReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "ware_house_id", "media_type", "buyer_id" }, new Object[] { Integer.valueOf(102), Integer.valueOf(0), "" }, VacMemberGetOrderCntReq.class);
  public final PBStringField buyer_id = PBField.initString("");
  public final PBInt32Field media_type = PBField.initInt32(0);
  public final PBEnumField ware_house_id = PBField.initEnum(102);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     VAC_ADV_GET_ACCESS.VacAdvGetAccess.VacMemberGetOrderCntReq
 * JD-Core Version:    0.7.0.1
 */