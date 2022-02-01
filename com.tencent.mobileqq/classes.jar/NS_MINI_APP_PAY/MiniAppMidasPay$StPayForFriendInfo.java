package NS_MINI_APP_PAY;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class MiniAppMidasPay$StPayForFriendInfo
  extends MessageMicro<StPayForFriendInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 56, 66 }, new String[] { "appid", "prepayId", "hostUin", "goodsDesc", "goodsPicUrl", "sandboxEnv", "friendUin" }, new Object[] { "", "", "", "", "", Integer.valueOf(0), "" }, StPayForFriendInfo.class);
  public final PBStringField appid = PBField.initString("");
  public final PBStringField friendUin = PBField.initString("");
  public final PBStringField goodsDesc = PBField.initString("");
  public final PBStringField goodsPicUrl = PBField.initString("");
  public final PBStringField hostUin = PBField.initString("");
  public final PBStringField prepayId = PBField.initString("");
  public final PBInt32Field sandboxEnv = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MINI_APP_PAY.MiniAppMidasPay.StPayForFriendInfo
 * JD-Core Version:    0.7.0.1
 */