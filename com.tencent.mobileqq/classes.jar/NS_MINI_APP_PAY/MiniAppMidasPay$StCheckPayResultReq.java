package NS_MINI_APP_PAY;

import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class MiniAppMidasPay$StCheckPayResultReq
  extends MessageMicro<StCheckPayResultReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "extInfo", "id", "scene" }, new Object[] { null, "", Integer.valueOf(0) }, StCheckPayResultReq.class);
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  public final PBStringField id = PBField.initString("");
  public final PBInt32Field scene = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MINI_APP_PAY.MiniAppMidasPay.StCheckPayResultReq
 * JD-Core Version:    0.7.0.1
 */