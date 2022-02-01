package NS_MINI_APP_PAY;

import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class MiniAppMidasPay$StGetPayForFriendInfoRsp
  extends MessageMicro<StGetPayForFriendInfoRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field expireAfter = PBField.initInt32(0);
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  public final PBStringField friendAvatar = PBField.initString("");
  public final PBStringField friendNick = PBField.initString("");
  public final PBStringField friendUin = PBField.initString("");
  public final PBStringField goodsDesc = PBField.initString("");
  public final PBStringField goodsPicUrl = PBField.initString("");
  public final PBStringField hostAvatar = PBField.initString("");
  public final PBStringField hostNick = PBField.initString("");
  public final PBStringField hostUin = PBField.initString("");
  public final PBInt32Field sandboxEnv = PBField.initInt32(0);
  public final PBInt64Field starCurrency = PBField.initInt64(0L);
  public final PBEnumField tradeStatus = PBField.initEnum(1);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40, 50, 58, 64, 72, 80, 90, 98, 106 }, new String[] { "extInfo", "hostUin", "hostNick", "hostAvatar", "starCurrency", "goodsDesc", "goodsPicUrl", "tradeStatus", "expireAfter", "sandboxEnv", "friendUin", "friendNick", "friendAvatar" }, new Object[] { null, "", "", "", Long.valueOf(0L), "", "", Integer.valueOf(1), localInteger, localInteger, "", "", "" }, StGetPayForFriendInfoRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MINI_APP_PAY.MiniAppMidasPay.StGetPayForFriendInfoRsp
 * JD-Core Version:    0.7.0.1
 */