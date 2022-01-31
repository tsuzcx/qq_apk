package NS_MINI_APP_PAY;

import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class MiniAppMidasPay$StGamePrePayReq
  extends MessageMicro<StGamePrePayReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 42, 50, 58, 64, 74, 82, 88, 98, 106 }, new String[] { "extInfo", "openid", "appid", "ts", "zone_id", "pf", "user_ip", "amt", "bill_no", "goodid", "good_num", "app_remark", "sig" }, new Object[] { null, "", "", Long.valueOf(0L), "", "", "", Long.valueOf(0L), "", "", Integer.valueOf(0), "", "" }, StGamePrePayReq.class);
  public final PBInt64Field amt = PBField.initInt64(0L);
  public final PBStringField app_remark = PBField.initString("");
  public final PBStringField appid = PBField.initString("");
  public final PBStringField bill_no = PBField.initString("");
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  public final PBInt32Field good_num = PBField.initInt32(0);
  public final PBStringField goodid = PBField.initString("");
  public final PBStringField openid = PBField.initString("");
  public final PBStringField pf = PBField.initString("");
  public final PBStringField sig = PBField.initString("");
  public final PBInt64Field ts = PBField.initInt64(0L);
  public final PBStringField user_ip = PBField.initString("");
  public final PBStringField zone_id = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MINI_APP_PAY.MiniAppMidasPay.StGamePrePayReq
 * JD-Core Version:    0.7.0.1
 */