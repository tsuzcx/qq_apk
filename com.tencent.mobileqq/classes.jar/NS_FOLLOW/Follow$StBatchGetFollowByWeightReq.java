package NS_FOLLOW;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

public final class Follow$StBatchGetFollowByWeightReq
  extends MessageMicro<StBatchGetFollowByWeightReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField business = PBField.initString("");
  public final PBDoubleField endWeight = PBField.initDouble(0.0D);
  public final PBRepeatField<String> followers = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBDoubleField startWeight = PBField.initDouble(0.0D);
  
  static
  {
    Double localDouble = Double.valueOf(0.0D);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 25, 33 }, new String[] { "business", "followers", "startWeight", "endWeight" }, new Object[] { "", "", localDouble, localDouble }, StBatchGetFollowByWeightReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_FOLLOW.Follow.StBatchGetFollowByWeightReq
 * JD-Core Version:    0.7.0.1
 */