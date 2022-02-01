package NS_FOLLOW;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class Follow$StGetFollowerCountRsp
  extends MessageMicro<StGetFollowerCountRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "followerCount" }, new Object[] { Integer.valueOf(0) }, StGetFollowerCountRsp.class);
  public final PBUInt32Field followerCount = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_FOLLOW.Follow.StGetFollowerCountRsp
 * JD-Core Version:    0.7.0.1
 */