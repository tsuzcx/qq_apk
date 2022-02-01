package VAC_ADV_GET_ACCESS;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class VacAdvGetAccess$VacGetWindowStateRsp$StateInfo
  extends MessageMicro<StateInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "state", "content_name", "media_name", "image_url" }, new Object[] { Integer.valueOf(0), "", "", "" }, StateInfo.class);
  public final PBStringField content_name = PBField.initString("");
  public final PBStringField image_url = PBField.initString("");
  public final PBStringField media_name = PBField.initString("");
  public final PBInt32Field state = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     VAC_ADV_GET_ACCESS.VacAdvGetAccess.VacGetWindowStateRsp.StateInfo
 * JD-Core Version:    0.7.0.1
 */