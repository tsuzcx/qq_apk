package NS_MINI_AD;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class MiniAppAd$UserInfo
  extends MessageMicro<UserInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField media_specified_id = PBField.initString("");
  public final PBUInt64Field qq = PBField.initUInt64(0L);
  public final PBUInt64Field qq_appid = PBField.initUInt64(0L);
  public final PBStringField qq_openid = PBField.initString("");
  public final PBStringField wx_appid = PBField.initString("");
  public final PBStringField wx_openid = PBField.initString("");
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 50 }, new String[] { "qq", "wx_appid", "wx_openid", "media_specified_id", "qq_appid", "qq_openid" }, new Object[] { localLong, "", "", "", localLong, "" }, UserInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MINI_AD.MiniAppAd.UserInfo
 * JD-Core Version:    0.7.0.1
 */