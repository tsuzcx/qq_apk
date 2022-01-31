package NS_MINI_APP_PAY;

import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class MiniAppMidasPay$StMiniPayRsp
  extends MessageMicro<StMiniPayRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 42 }, new String[] { "extInfo", "bill_no", "balance", "used_gen_amt", "trade_id" }, new Object[] { null, "", Integer.valueOf(0), Integer.valueOf(0), "" }, StMiniPayRsp.class);
  public final PBInt32Field balance = PBField.initInt32(0);
  public final PBStringField bill_no = PBField.initString("");
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  public final PBStringField trade_id = PBField.initString("");
  public final PBInt32Field used_gen_amt = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MINI_APP_PAY.MiniAppMidasPay.StMiniPayRsp
 * JD-Core Version:    0.7.0.1
 */