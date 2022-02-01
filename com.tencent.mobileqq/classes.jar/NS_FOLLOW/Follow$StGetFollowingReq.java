package NS_FOLLOW;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class Follow$StGetFollowingReq
  extends MessageMicro<StGetFollowingReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField business = PBField.initString("");
  public final PBStringField follower = PBField.initString("");
  public final PBUInt32Field listSize = PBField.initUInt32(0);
  public final PBInt32Field order = PBField.initInt32(0);
  public final PBUInt32Field start = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40 }, new String[] { "business", "follower", "start", "order", "listSize" }, new Object[] { "", "", localInteger, localInteger, localInteger }, StGetFollowingReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_FOLLOW.Follow.StGetFollowingReq
 * JD-Core Version:    0.7.0.1
 */