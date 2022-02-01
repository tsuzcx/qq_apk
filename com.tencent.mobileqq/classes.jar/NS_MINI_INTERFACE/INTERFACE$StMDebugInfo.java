package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class INTERFACE$StMDebugInfo
  extends MessageMicro<StMDebugInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "roomId", "wsUrl" }, new Object[] { "", "" }, StMDebugInfo.class);
  public final PBStringField roomId = PBField.initString("");
  public final PBStringField wsUrl = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MINI_INTERFACE.INTERFACE.StMDebugInfo
 * JD-Core Version:    0.7.0.1
 */