package NS_MINI_INTERFACE;

import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class INTERFACE$StGetSchemaReq
  extends MessageMicro<StGetSchemaReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 56, 66, 74, 82 }, new String[] { "extInfo", "mini_appid", "path", "sig_querystring", "querystring", "extradata", "versionType", "versionId", "referer", "via" }, new Object[] { null, "", "", "", "", "", Integer.valueOf(0), "", "", "" }, StGetSchemaReq.class);
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  public final PBStringField extradata = PBField.initString("");
  public final PBStringField mini_appid = PBField.initString("");
  public final PBStringField path = PBField.initString("");
  public final PBStringField querystring = PBField.initString("");
  public final PBStringField referer = PBField.initString("");
  public final PBStringField sig_querystring = PBField.initString("");
  public final PBStringField versionId = PBField.initString("");
  public final PBInt32Field versionType = PBField.initInt32(0);
  public final PBStringField via = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MINI_INTERFACE.INTERFACE.StGetSchemaReq
 * JD-Core Version:    0.7.0.1
 */