package NS_MINI_APP_PAY;

import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class MiniAppMidasPay$StGetWalletPayLinkReq
  extends MessageMicro<StGetWalletPayLinkReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "extInfo", "prepayId", "appid" }, new Object[] { null, "", "" }, StGetWalletPayLinkReq.class);
  public final PBStringField appid = PBField.initString("");
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  public final PBStringField prepayId = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MINI_APP_PAY.MiniAppMidasPay.StGetWalletPayLinkReq
 * JD-Core Version:    0.7.0.1
 */