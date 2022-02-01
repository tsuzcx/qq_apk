package NS_FOLLOW;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class Follow$StCountResult
  extends MessageMicro<StCountResult>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field count = PBField.initUInt32(0);
  public final PBStringField follower = PBField.initString("");
  public final PBInt32Field retCode = PBField.initInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "follower", "retCode", "count" }, new Object[] { "", localInteger, localInteger }, StCountResult.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_FOLLOW.Follow.StCountResult
 * JD-Core Version:    0.7.0.1
 */