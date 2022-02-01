package VAC_ADV_GET_ACCESS;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class VacAdvGetAccess$VacMemberGetOrderCntRsp
  extends MessageMicro<VacMemberGetOrderCntRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "order_states" }, new Object[] { null }, VacMemberGetOrderCntRsp.class);
  public final PBRepeatMessageField<VacAdvGetAccess.OrderStateInfo> order_states = PBField.initRepeatMessage(VacAdvGetAccess.OrderStateInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     VAC_ADV_GET_ACCESS.VacAdvGetAccess.VacMemberGetOrderCntRsp
 * JD-Core Version:    0.7.0.1
 */