package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class INTERFACE$StSchemeResult
  extends MessageMicro<StSchemeResult>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "mini_appid", "schema", "ret" }, new Object[] { "", "", Integer.valueOf(0) }, StSchemeResult.class);
  public final PBStringField mini_appid = PBField.initString("");
  public final PBInt32Field ret = PBField.initInt32(0);
  public final PBStringField schema = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MINI_INTERFACE.INTERFACE.StSchemeResult
 * JD-Core Version:    0.7.0.1
 */