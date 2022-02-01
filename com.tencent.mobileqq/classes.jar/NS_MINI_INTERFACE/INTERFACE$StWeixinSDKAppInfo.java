package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class INTERFACE$StWeixinSDKAppInfo
  extends MessageMicro<StWeixinSDKAppInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40 }, new String[] { "appid", "appName", "appIcon", "appDesc", "appType" }, new Object[] { "", "", "", "", Integer.valueOf(0) }, StWeixinSDKAppInfo.class);
  public final PBStringField appDesc = PBField.initString("");
  public final PBStringField appIcon = PBField.initString("");
  public final PBStringField appName = PBField.initString("");
  public final PBUInt32Field appType = PBField.initUInt32(0);
  public final PBStringField appid = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MINI_INTERFACE.INTERFACE.StWeixinSDKAppInfo
 * JD-Core Version:    0.7.0.1
 */