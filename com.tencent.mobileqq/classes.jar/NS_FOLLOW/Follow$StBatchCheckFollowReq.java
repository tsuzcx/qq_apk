package NS_FOLLOW;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

public final class Follow$StBatchCheckFollowReq
  extends MessageMicro<StBatchCheckFollowReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "business", "followers", "star" }, new Object[] { "", "", "" }, StBatchCheckFollowReq.class);
  public final PBStringField business = PBField.initString("");
  public final PBRepeatField<String> followers = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBStringField star = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_FOLLOW.Follow.StBatchCheckFollowReq
 * JD-Core Version:    0.7.0.1
 */