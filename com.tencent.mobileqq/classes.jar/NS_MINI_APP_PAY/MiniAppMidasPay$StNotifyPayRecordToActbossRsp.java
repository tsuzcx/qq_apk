package NS_MINI_APP_PAY;

import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;

public final class MiniAppMidasPay$StNotifyPayRecordToActbossRsp
  extends MessageMicro<StNotifyPayRecordToActbossRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  public final PBInt64Field lottery_count = PBField.initInt64(0L);
  public final PBInt64Field surplus = PBField.initInt64(0L);
  public final PBInt64Field total_pay = PBField.initInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32 }, new String[] { "extInfo", "total_pay", "surplus", "lottery_count" }, new Object[] { null, localLong, localLong, localLong }, StNotifyPayRecordToActbossRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MINI_APP_PAY.MiniAppMidasPay.StNotifyPayRecordToActbossRsp
 * JD-Core Version:    0.7.0.1
 */