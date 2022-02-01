package NS_FOLLOW;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class Follow$StCheckFollowReq
  extends MessageMicro<StCheckFollowReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "business", "follower", "star" }, new Object[] { "", "", "" }, StCheckFollowReq.class);
  public final PBStringField business = PBField.initString("");
  public final PBStringField follower = PBField.initString("");
  public final PBStringField star = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_FOLLOW.Follow.StCheckFollowReq
 * JD-Core Version:    0.7.0.1
 */