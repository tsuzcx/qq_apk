package NS_FOLLOW;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class Follow$StBatchGetFollowingCountRsp
  extends MessageMicro<StBatchGetFollowingCountRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "followingCounts" }, new Object[] { null }, StBatchGetFollowingCountRsp.class);
  public final PBRepeatMessageField<Follow.StCountResult> followingCounts = PBField.initRepeatMessage(Follow.StCountResult.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_FOLLOW.Follow.StBatchGetFollowingCountRsp
 * JD-Core Version:    0.7.0.1
 */