package NS_MINI_APP_PAY;

import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class MiniAppMidasPay$StRequrirePayByFriendReq
  extends MessageMicro<StRequrirePayByFriendReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 42, 50, 56 }, new String[] { "extInfo", "appid", "prepayId", "goodsDesc", "goodsPicUrl", "sandboxEnv" }, new Object[] { null, "", "", "", "", Integer.valueOf(0) }, StRequrirePayByFriendReq.class);
  public final PBStringField appid = PBField.initString("");
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  public final PBStringField goodsDesc = PBField.initString("");
  public final PBStringField goodsPicUrl = PBField.initString("");
  public final PBStringField prepayId = PBField.initString("");
  public final PBInt32Field sandboxEnv = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MINI_APP_PAY.MiniAppMidasPay.StRequrirePayByFriendReq
 * JD-Core Version:    0.7.0.1
 */