package NS_FOLLOW;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class Follow$StCheckResult
  extends MessageMicro<StCheckResult>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "stars", "result" }, new Object[] { "", Integer.valueOf(0) }, StCheckResult.class);
  public final PBInt32Field result = PBField.initInt32(0);
  public final PBStringField stars = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_FOLLOW.Follow.StCheckResult
 * JD-Core Version:    0.7.0.1
 */