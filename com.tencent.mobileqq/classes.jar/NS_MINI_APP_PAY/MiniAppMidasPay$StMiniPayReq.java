package NS_MINI_APP_PAY;

import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class MiniAppMidasPay$StMiniPayReq
  extends MessageMicro<StMiniPayReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt64Field amt = PBField.initInt64(0L);
  public final PBStringField app_remark = PBField.initString("");
  public final PBStringField appid = PBField.initString("");
  public final PBStringField bill_no = PBField.initString("");
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  public final PBStringField offer_id = PBField.initString("");
  public final PBStringField openid = PBField.initString("");
  public final PBStringField openkey = PBField.initString("");
  public final PBStringField pay_item = PBField.initString("");
  public final PBStringField pf = PBField.initString("");
  public final PBStringField qq_sig = PBField.initString("");
  public final PBInt64Field sandbox_env = PBField.initInt64(0L);
  public final PBStringField sig = PBField.initString("");
  public final PBInt64Field ts = PBField.initInt64(0L);
  public final PBStringField user_ip = PBField.initString("");
  public final PBStringField zone_id = PBField.initString("");
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40, 50, 58, 66, 72, 82, 90, 98, 106, 114, 120, 130 }, new String[] { "extInfo", "openid", "appid", "offer_id", "ts", "zone_id", "pf", "user_ip", "amt", "bill_no", "pay_item", "app_remark", "sig", "qq_sig", "sandbox_env", "openkey" }, new Object[] { null, "", "", "", localLong, "", "", "", localLong, "", "", "", "", "", localLong, "" }, StMiniPayReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MINI_APP_PAY.MiniAppMidasPay.StMiniPayReq
 * JD-Core Version:    0.7.0.1
 */