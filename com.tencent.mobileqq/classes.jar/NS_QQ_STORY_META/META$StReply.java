package NS_QQ_STORY_META;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class META$StReply
  extends MessageMicro<StReply>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField content = PBField.initString("");
  public final PBUInt64Field createTime = PBField.initUInt64(0L);
  public final PBStringField id = PBField.initString("");
  public META.StUser postUser = new META.StUser();
  public META.StUser targetUser = new META.StUser();
  public final PBRepeatField<Long> vecAtUin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 42, 48 }, new String[] { "id", "postUser", "createTime", "content", "targetUser", "vecAtUin" }, new Object[] { "", null, localLong, "", null, localLong }, StReply.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_QQ_STORY_META.META.StReply
 * JD-Core Version:    0.7.0.1
 */