package NS_MINI_APP_PAY;

import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class MiniAppMidasPay$StCheckGamePayReq
  extends MessageMicro<StCheckGamePayReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50 }, new String[] { "extInfo", "openid", "appid", "prepay_id", "bill_no", "sig" }, new Object[] { null, "", "", "", "", "" }, StCheckGamePayReq.class);
  public final PBStringField appid = PBField.initString("");
  public final PBStringField bill_no = PBField.initString("");
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  public final PBStringField openid = PBField.initString("");
  public final PBStringField prepay_id = PBField.initString("");
  public final PBStringField sig = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MINI_APP_PAY.MiniAppMidasPay.StCheckGamePayReq
 * JD-Core Version:    0.7.0.1
 */