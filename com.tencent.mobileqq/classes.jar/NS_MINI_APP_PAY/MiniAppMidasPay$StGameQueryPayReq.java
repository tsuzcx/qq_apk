package NS_MINI_APP_PAY;

import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class MiniAppMidasPay$StGameQueryPayReq
  extends MessageMicro<StGameQueryPayReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "extInfo", "prepayId", "sig" }, new Object[] { null, "", "" }, StGameQueryPayReq.class);
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  public final PBStringField prepayId = PBField.initString("");
  public final PBStringField sig = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MINI_APP_PAY.MiniAppMidasPay.StGameQueryPayReq
 * JD-Core Version:    0.7.0.1
 */