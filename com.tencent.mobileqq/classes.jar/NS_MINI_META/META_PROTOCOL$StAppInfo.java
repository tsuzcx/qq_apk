package NS_MINI_META;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

public final class META_PROTOCOL$StAppInfo
  extends MessageMicro<StAppInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 66 }, new String[] { "appid", "appSecret", "developerId", "appname", "appIcon", "appDesc", "serviceCategory", "baselibMiniVersion" }, new Object[] { "", "", "", "", "", "", "", "" }, StAppInfo.class);
  public final PBStringField appDesc = PBField.initString("");
  public final PBStringField appIcon = PBField.initString("");
  public final PBStringField appSecret = PBField.initString("");
  public final PBStringField appid = PBField.initString("");
  public final PBStringField appname = PBField.initString("");
  public final PBStringField baselibMiniVersion = PBField.initString("");
  public final PBStringField developerId = PBField.initString("");
  public final PBRepeatField<String> serviceCategory = PBField.initRepeat(PBStringField.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MINI_META.META_PROTOCOL.StAppInfo
 * JD-Core Version:    0.7.0.1
 */