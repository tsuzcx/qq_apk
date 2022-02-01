package NS_QQ_STORY_META;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class META$StEmoji
  extends MessageMicro<StEmoji>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "emojiList", "totalCount" }, new Object[] { null, Long.valueOf(0L) }, StEmoji.class);
  public final PBRepeatMessageField<META.EmojiMeta> emojiList = PBField.initRepeatMessage(META.EmojiMeta.class);
  public final PBUInt64Field totalCount = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_QQ_STORY_META.META.StEmoji
 * JD-Core Version:    0.7.0.1
 */