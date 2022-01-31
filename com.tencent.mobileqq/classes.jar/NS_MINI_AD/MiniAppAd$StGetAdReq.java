package NS_MINI_AD;

import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class MiniAppAd$StGetAdReq
  extends MessageMicro<StGetAdReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 64, 74, 80, 16010 }, new String[] { "extInfo", "user_info", "position_info", "device_info", "context_info", "debug_info", "gdt_cookie", "support_https", "appid", "ad_type", "busi_cookie" }, new Object[] { null, null, null, null, null, null, "", Boolean.valueOf(false), "", Integer.valueOf(0), "" }, StGetAdReq.class);
  public final PBInt32Field ad_type = PBField.initInt32(0);
  public final PBStringField appid = PBField.initString("");
  public final PBStringField busi_cookie = PBField.initString("");
  public MiniAppAd.ContextInfo context_info = new MiniAppAd.ContextInfo();
  public MiniAppAd.DebugInfo debug_info = new MiniAppAd.DebugInfo();
  public MiniAppAd.DeviceInfo device_info = new MiniAppAd.DeviceInfo();
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  public final PBStringField gdt_cookie = PBField.initString("");
  public final PBRepeatMessageField<MiniAppAd.PositionInfo> position_info = PBField.initRepeatMessage(MiniAppAd.PositionInfo.class);
  public final PBBoolField support_https = PBField.initBool(false);
  public MiniAppAd.UserInfo user_info = new MiniAppAd.UserInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MINI_AD.MiniAppAd.StGetAdReq
 * JD-Core Version:    0.7.0.1
 */