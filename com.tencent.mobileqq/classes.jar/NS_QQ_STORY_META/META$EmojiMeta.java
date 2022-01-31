package NS_QQ_STORY_META;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class META$EmojiMeta
  extends MessageMicro<EmojiMeta>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "emojiType", "count", "createtime" }, new Object[] { Integer.valueOf(1), Long.valueOf(0L), Long.valueOf(0L) }, EmojiMeta.class);
  public final PBUInt64Field count = PBField.initUInt64(0L);
  public final PBUInt64Field createtime = PBField.initUInt64(0L);
  public final PBEnumField emojiType = PBField.initEnum(1);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_QQ_STORY_META.META.EmojiMeta
 * JD-Core Version:    0.7.0.1
 */