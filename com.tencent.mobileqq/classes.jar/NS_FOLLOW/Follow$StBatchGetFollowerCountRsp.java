package NS_FOLLOW;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class Follow$StBatchGetFollowerCountRsp
  extends MessageMicro<StBatchGetFollowerCountRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "followersCount" }, new Object[] { Integer.valueOf(0) }, StBatchGetFollowerCountRsp.class);
  public final PBRepeatField<Integer> followersCount = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_FOLLOW.Follow.StBatchGetFollowerCountRsp
 * JD-Core Version:    0.7.0.1
 */