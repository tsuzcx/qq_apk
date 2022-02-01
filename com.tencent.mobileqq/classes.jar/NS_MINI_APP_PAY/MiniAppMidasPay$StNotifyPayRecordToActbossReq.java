package NS_MINI_APP_PAY;

import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class MiniAppMidasPay$StNotifyPayRecordToActbossReq
  extends MessageMicro<StNotifyPayRecordToActbossReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "uin" }, new Object[] { null, "" }, StNotifyPayRecordToActbossReq.class);
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  public final PBStringField uin = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MINI_APP_PAY.MiniAppMidasPay.StNotifyPayRecordToActbossReq
 * JD-Core Version:    0.7.0.1
 */