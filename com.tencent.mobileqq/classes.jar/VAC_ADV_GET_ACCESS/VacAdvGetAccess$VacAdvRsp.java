package VAC_ADV_GET_ACCESS;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class VacAdvGetAccess$VacAdvRsp
  extends MessageMicro<VacAdvRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "err_code", "err_msg", "vac_adv_msgs" }, new Object[] { Integer.valueOf(0), "", null }, VacAdvRsp.class);
  public final PBInt32Field err_code = PBField.initInt32(0);
  public final PBStringField err_msg = PBField.initString("");
  public final PBRepeatMessageField<VacAdvGetAccess.VacAdvMetaMsg> vac_adv_msgs = PBField.initRepeatMessage(VacAdvGetAccess.VacAdvMetaMsg.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     VAC_ADV_GET_ACCESS.VacAdvGetAccess.VacAdvRsp
 * JD-Core Version:    0.7.0.1
 */