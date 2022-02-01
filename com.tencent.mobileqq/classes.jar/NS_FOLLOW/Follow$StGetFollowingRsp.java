package NS_FOLLOW;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class Follow$StGetFollowingRsp
  extends MessageMicro<StGetFollowingRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field finished = PBField.initUInt32(0);
  public final PBUInt32Field nextStart = PBField.initUInt32(0);
  public final PBRepeatMessageField<Follow.StStar> stars = PBField.initRepeatMessage(Follow.StStar.class);
  public final PBUInt32Field totalNum = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32 }, new String[] { "stars", "nextStart", "finished", "totalNum" }, new Object[] { null, localInteger, localInteger, localInteger }, StGetFollowingRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_FOLLOW.Follow.StGetFollowingRsp
 * JD-Core Version:    0.7.0.1
 */