package NS_MINI_INTERFACE;

import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class INTERFACE$StGetNAppForJumpReq
  extends MessageMicro<StGetNAppForJumpReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 48 }, new String[] { "extInfo", "mini_appid", "native_appid", "android_pkg_name", "ios_bundleid", "scene" }, new Object[] { null, "", "", "", "", Integer.valueOf(0) }, StGetNAppForJumpReq.class);
  public final PBStringField android_pkg_name = PBField.initString("");
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  public final PBStringField ios_bundleid = PBField.initString("");
  public final PBStringField mini_appid = PBField.initString("");
  public final PBStringField native_appid = PBField.initString("");
  public final PBInt32Field scene = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MINI_INTERFACE.INTERFACE.StGetNAppForJumpReq
 * JD-Core Version:    0.7.0.1
 */