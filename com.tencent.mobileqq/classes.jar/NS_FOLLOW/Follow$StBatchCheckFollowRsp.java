package NS_FOLLOW;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class Follow$StBatchCheckFollowRsp
  extends MessageMicro<StBatchCheckFollowRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "stars" }, new Object[] { null }, StBatchCheckFollowRsp.class);
  public final PBRepeatMessageField<Follow.StStar> stars = PBField.initRepeatMessage(Follow.StStar.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_FOLLOW.Follow.StBatchCheckFollowRsp
 * JD-Core Version:    0.7.0.1
 */