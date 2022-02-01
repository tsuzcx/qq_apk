package NS_MINI_PUBLIC;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Head$StLinkTrace
  extends MessageMicro<StLinkTrace>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field parentSpanId = PBField.initUInt64(0L);
  public final PBInt32Field sampled = PBField.initInt32(0);
  public final PBUInt64Field spanId = PBField.initUInt64(0L);
  public final PBUInt64Field traceId = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "traceId", "spanId", "parentSpanId", "sampled" }, new Object[] { localLong, localLong, localLong, Integer.valueOf(0) }, StLinkTrace.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MINI_PUBLIC.Head.StLinkTrace
 * JD-Core Version:    0.7.0.1
 */