package NS_MINI_INTERFACE;

import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class INTERFACE$StGetNAppForJumpRsp
  extends MessageMicro<StGetNAppForJumpRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 64 }, new String[] { "extInfo", "native_appid", "ios_bundleid", "ios_schema", "appName", "android_pkg", "ios_donwload_url", "onlyOpen" }, new Object[] { null, "", "", "", "", "", "", Integer.valueOf(0) }, StGetNAppForJumpRsp.class);
  public final PBStringField android_pkg = PBField.initString("");
  public final PBStringField appName = PBField.initString("");
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  public final PBStringField ios_bundleid = PBField.initString("");
  public final PBStringField ios_donwload_url = PBField.initString("");
  public final PBStringField ios_schema = PBField.initString("");
  public final PBStringField native_appid = PBField.initString("");
  public final PBInt32Field onlyOpen = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MINI_INTERFACE.INTERFACE.StGetNAppForJumpRsp
 * JD-Core Version:    0.7.0.1
 */