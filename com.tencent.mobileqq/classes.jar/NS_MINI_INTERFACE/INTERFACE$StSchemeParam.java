package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class INTERFACE$StSchemeParam
  extends MessageMicro<StSchemeParam>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 48, 58, 66, 74, 82 }, new String[] { "mini_appid", "path", "sig_querystring", "querystring", "extradata", "versionType", "versionId", "referer", "via", "scene" }, new Object[] { "", "", "", "", "", Integer.valueOf(0), "", "", "", "" }, StSchemeParam.class);
  public final PBStringField extradata = PBField.initString("");
  public final PBStringField mini_appid = PBField.initString("");
  public final PBStringField path = PBField.initString("");
  public final PBStringField querystring = PBField.initString("");
  public final PBStringField referer = PBField.initString("");
  public final PBStringField scene = PBField.initString("");
  public final PBStringField sig_querystring = PBField.initString("");
  public final PBStringField versionId = PBField.initString("");
  public final PBInt32Field versionType = PBField.initInt32(0);
  public final PBStringField via = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MINI_INTERFACE.INTERFACE.StSchemeParam
 * JD-Core Version:    0.7.0.1
 */