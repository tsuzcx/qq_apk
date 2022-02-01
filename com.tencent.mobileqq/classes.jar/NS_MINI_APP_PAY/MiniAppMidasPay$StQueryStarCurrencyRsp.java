package NS_MINI_APP_PAY;

import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class MiniAppMidasPay$StQueryStarCurrencyRsp
  extends MessageMicro<StQueryStarCurrencyRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  public final PBStringField offerid = PBField.initString("");
  public final PBInt32Field rechargeNum = PBField.initInt32(0);
  public final PBInt32Field remainder = PBField.initInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34 }, new String[] { "extInfo", "remainder", "rechargeNum", "offerid" }, new Object[] { null, localInteger, localInteger, "" }, StQueryStarCurrencyRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MINI_APP_PAY.MiniAppMidasPay.StQueryStarCurrencyRsp
 * JD-Core Version:    0.7.0.1
 */