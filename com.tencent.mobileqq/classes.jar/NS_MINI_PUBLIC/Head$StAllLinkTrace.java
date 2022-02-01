package NS_MINI_PUBLIC;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class Head$StAllLinkTrace
  extends MessageMicro<StAllLinkTrace>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32 }, new String[] { "traceId", "spanId", "parentSpanId", "sampled" }, new Object[] { "", "", "", Integer.valueOf(0) }, StAllLinkTrace.class);
  public final PBStringField parentSpanId = PBField.initString("");
  public final PBInt32Field sampled = PBField.initInt32(0);
  public final PBStringField spanId = PBField.initString("");
  public final PBStringField traceId = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MINI_PUBLIC.Head.StAllLinkTrace
 * JD-Core Version:    0.7.0.1
 */