package NS_FOLLOW;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class Follow$StCheckFollowRsp
  extends MessageMicro<StCheckFollowRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "star" }, new Object[] { null }, StCheckFollowRsp.class);
  public Follow.StStar star = new Follow.StStar();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_FOLLOW.Follow.StCheckFollowRsp
 * JD-Core Version:    0.7.0.1
 */