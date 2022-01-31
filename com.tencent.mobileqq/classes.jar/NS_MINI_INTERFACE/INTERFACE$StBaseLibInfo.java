package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class INTERFACE$StBaseLibInfo
  extends MessageMicro<StBaseLibInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34 }, new String[] { "version", "downloadUrl", "libType", "extInfo" }, new Object[] { "", "", Integer.valueOf(0), "" }, StBaseLibInfo.class);
  public final PBStringField downloadUrl = PBField.initString("");
  public final PBStringField extInfo = PBField.initString("");
  public final PBInt32Field libType = PBField.initInt32(0);
  public final PBStringField version = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MINI_INTERFACE.INTERFACE.StBaseLibInfo
 * JD-Core Version:    0.7.0.1
 */