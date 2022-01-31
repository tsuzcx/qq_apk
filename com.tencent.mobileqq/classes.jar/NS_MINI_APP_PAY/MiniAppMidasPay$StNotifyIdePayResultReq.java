package NS_MINI_APP_PAY;

import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class MiniAppMidasPay$StNotifyIdePayResultReq
  extends MessageMicro<StNotifyIdePayResultReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 40, 48 }, new String[] { "extInfo", "appId", "id", "amt", "scene", "result" }, new Object[] { null, "", "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, StNotifyIdePayResultReq.class);
  public final PBInt32Field amt = PBField.initInt32(0);
  public final PBStringField appId = PBField.initString("");
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  public final PBStringField id = PBField.initString("");
  public final PBInt32Field result = PBField.initInt32(0);
  public final PBInt32Field scene = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MINI_APP_PAY.MiniAppMidasPay.StNotifyIdePayResultReq
 * JD-Core Version:    0.7.0.1
 */