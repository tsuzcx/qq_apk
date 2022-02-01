package NS_MINI_INTERFACE;

import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class INTERFACE$StGetAppInfoByIdReq
  extends MessageMicro<StGetAppInfoByIdReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 42, 50, 58 }, new String[] { "extInfo", "appid", "needVersionInfo", "checkDevRight", "firstPath", "envVersion", "fromAppid" }, new Object[] { null, "", Integer.valueOf(0), Integer.valueOf(0), "", "", "" }, StGetAppInfoByIdReq.class);
  public final PBStringField appid = PBField.initString("");
  public final PBInt32Field checkDevRight = PBField.initInt32(0);
  public final PBStringField envVersion = PBField.initString("");
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  public final PBStringField firstPath = PBField.initString("");
  public final PBStringField fromAppid = PBField.initString("");
  public final PBInt32Field needVersionInfo = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MINI_INTERFACE.INTERFACE.StGetAppInfoByIdReq
 * JD-Core Version:    0.7.0.1
 */