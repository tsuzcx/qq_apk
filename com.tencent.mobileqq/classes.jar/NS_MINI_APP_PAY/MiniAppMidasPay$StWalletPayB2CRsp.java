package NS_MINI_APP_PAY;

import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class MiniAppMidasPay$StWalletPayB2CRsp
  extends MessageMicro<StWalletPayB2CRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58 }, new String[] { "extInfo", "retcode", "retmsg", "mch_id", "trade_no", "transaction_id", "transaction_state" }, new Object[] { null, "", "", "", "", "", "" }, StWalletPayB2CRsp.class);
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  public final PBStringField mch_id = PBField.initString("");
  public final PBStringField retcode = PBField.initString("");
  public final PBStringField retmsg = PBField.initString("");
  public final PBStringField trade_no = PBField.initString("");
  public final PBStringField transaction_id = PBField.initString("");
  public final PBStringField transaction_state = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MINI_APP_PAY.MiniAppMidasPay.StWalletPayB2CRsp
 * JD-Core Version:    0.7.0.1
 */