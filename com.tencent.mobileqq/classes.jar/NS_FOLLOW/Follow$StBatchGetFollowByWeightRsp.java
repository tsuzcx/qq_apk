package NS_FOLLOW;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class Follow$StBatchGetFollowByWeightRsp
  extends MessageMicro<StBatchGetFollowByWeightRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "startList" }, new Object[] { null }, StBatchGetFollowByWeightRsp.class);
  public final PBRepeatMessageField<Follow.StStarList> startList = PBField.initRepeatMessage(Follow.StStarList.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_FOLLOW.Follow.StBatchGetFollowByWeightRsp
 * JD-Core Version:    0.7.0.1
 */