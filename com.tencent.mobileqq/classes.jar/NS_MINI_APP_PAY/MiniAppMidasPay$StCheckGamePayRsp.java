package NS_MINI_APP_PAY;

import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class MiniAppMidasPay$StCheckGamePayRsp
  extends MessageMicro<StCheckGamePayRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34 }, new String[] { "extInfo", "pay_state", "pay_time", "app_remark" }, new Object[] { null, Integer.valueOf(0), Long.valueOf(0L), "" }, StCheckGamePayRsp.class);
  public final PBStringField app_remark = PBField.initString("");
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  public final PBInt32Field pay_state = PBField.initInt32(0);
  public final PBInt64Field pay_time = PBField.initInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MINI_APP_PAY.MiniAppMidasPay.StCheckGamePayRsp
 * JD-Core Version:    0.7.0.1
 */