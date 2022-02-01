package NS_MINI_FILE_MATERIAL;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class MiniAppFileMaterial$AppMaterialInfo
  extends MessageMicro<AppMaterialInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50 }, new String[] { "appid", "name", "icon", "desc", "path", "vt" }, new Object[] { "", "", "", "", "", "" }, AppMaterialInfo.class);
  public final PBStringField appid = PBField.initString("");
  public final PBStringField desc = PBField.initString("");
  public final PBStringField icon = PBField.initString("");
  public final PBStringField name = PBField.initString("");
  public final PBStringField path = PBField.initString("");
  public final PBStringField vt = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MINI_FILE_MATERIAL.MiniAppFileMaterial.AppMaterialInfo
 * JD-Core Version:    0.7.0.1
 */