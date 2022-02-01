package NS_MINI_APP_PAY;

import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class MiniAppMidasPay$StWalletPayB2CReq
  extends MessageMicro<StWalletPayB2CReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 64 }, new String[] { "extInfo", "mch_id", "trade_no", "appid", "openid", "uin", "total_fee", "check_real_name" }, new Object[] { null, "", "", "", "", "", "", Integer.valueOf(0) }, StWalletPayB2CReq.class);
  public final PBStringField appid = PBField.initString("");
  public final PBInt32Field check_real_name = PBField.initInt32(0);
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  public final PBStringField mch_id = PBField.initString("");
  public final PBStringField openid = PBField.initString("");
  public final PBStringField total_fee = PBField.initString("");
  public final PBStringField trade_no = PBField.initString("");
  public final PBStringField uin = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MINI_APP_PAY.MiniAppMidasPay.StWalletPayB2CReq
 * JD-Core Version:    0.7.0.1
 */