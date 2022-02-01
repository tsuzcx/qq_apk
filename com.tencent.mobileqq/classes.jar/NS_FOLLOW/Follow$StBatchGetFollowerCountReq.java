package NS_FOLLOW;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

public final class Follow$StBatchGetFollowerCountReq
  extends MessageMicro<StBatchGetFollowerCountReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "business", "stars" }, new Object[] { "", "" }, StBatchGetFollowerCountReq.class);
  public final PBStringField business = PBField.initString("");
  public final PBRepeatField<String> stars = PBField.initRepeat(PBStringField.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_FOLLOW.Follow.StBatchGetFollowerCountReq
 * JD-Core Version:    0.7.0.1
 */