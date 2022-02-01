package VAC_ADV_GET_ACCESS;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class VacAdvGetAccess$MiniProgramInfo
  extends MessageMicro<MiniProgramInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "username", "path", "type", "app_id" }, new Object[] { "", "", "", "" }, MiniProgramInfo.class);
  public final PBStringField app_id = PBField.initString("");
  public final PBStringField path = PBField.initString("");
  public final PBStringField type = PBField.initString("");
  public final PBStringField username = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     VAC_ADV_GET_ACCESS.VacAdvGetAccess.MiniProgramInfo
 * JD-Core Version:    0.7.0.1
 */