package NS_MINI_APP_PAY;

import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class MiniAppMidasPay$StMiniPresentReq
  extends MessageMicro<StMiniPresentReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField bill_no = PBField.initString("");
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  public final PBStringField offer_id = PBField.initString("");
  public final PBStringField openid = PBField.initString("");
  public final PBStringField openkey = PBField.initString("");
  public final PBStringField pf = PBField.initString("");
  public final PBStringField pfkey = PBField.initString("");
  public final PBInt64Field present_counts = PBField.initInt64(0L);
  public final PBStringField qq_appid = PBField.initString("");
  public final PBStringField qq_sig = PBField.initString("");
  public final PBInt64Field sandbox_env = PBField.initInt64(0L);
  public final PBStringField sig = PBField.initString("");
  public final PBInt64Field ts = PBField.initInt64(0L);
  public final PBStringField user_ip = PBField.initString("");
  public final PBStringField zone_id = PBField.initString("");
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40, 50, 58, 66, 74, 80, 90, 98, 106, 112, 122 }, new String[] { "extInfo", "openid", "qq_appid", "offer_id", "ts", "zone_id", "pf", "pfkey", "user_ip", "present_counts", "bill_no", "sig", "qq_sig", "sandbox_env", "openkey" }, new Object[] { null, "", "", "", localLong, "", "", "", "", localLong, "", "", "", localLong, "" }, StMiniPresentReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MINI_APP_PAY.MiniAppMidasPay.StMiniPresentReq
 * JD-Core Version:    0.7.0.1
 */