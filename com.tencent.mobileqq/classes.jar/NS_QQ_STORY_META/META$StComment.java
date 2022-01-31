package NS_QQ_STORY_META;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class META$StComment
  extends MessageMicro<StComment>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 40, 48, 58 }, new String[] { "id", "postUser", "createTime", "content", "vecAtUin", "replyCount", "vecReply" }, new Object[] { "", null, Long.valueOf(0L), "", Long.valueOf(0L), Integer.valueOf(0), null }, StComment.class);
  public final PBStringField content = PBField.initString("");
  public final PBUInt64Field createTime = PBField.initUInt64(0L);
  public final PBStringField id = PBField.initString("");
  public META.StUser postUser = new META.StUser();
  public final PBUInt32Field replyCount = PBField.initUInt32(0);
  public final PBRepeatField<Long> vecAtUin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBRepeatMessageField<META.StReply> vecReply = PBField.initRepeatMessage(META.StReply.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_QQ_STORY_META.META.StComment
 * JD-Core Version:    0.7.0.1
 */