package NS_FOLLOW;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class Follow$StGetFollowerCountReq
  extends MessageMicro<StGetFollowerCountReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "business", "star" }, new Object[] { "", "" }, StGetFollowerCountReq.class);
  public final PBStringField business = PBField.initString("");
  public final PBStringField star = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_FOLLOW.Follow.StGetFollowerCountReq
 * JD-Core Version:    0.7.0.1
 */