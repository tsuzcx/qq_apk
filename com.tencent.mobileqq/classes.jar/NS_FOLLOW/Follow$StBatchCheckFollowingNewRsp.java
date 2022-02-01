package NS_FOLLOW;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class Follow$StBatchCheckFollowingNewRsp
  extends MessageMicro<StBatchCheckFollowingNewRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "results" }, new Object[] { null }, StBatchCheckFollowingNewRsp.class);
  public final PBRepeatMessageField<Follow.StCheckResult> results = PBField.initRepeatMessage(Follow.StCheckResult.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_FOLLOW.Follow.StBatchCheckFollowingNewRsp
 * JD-Core Version:    0.7.0.1
 */