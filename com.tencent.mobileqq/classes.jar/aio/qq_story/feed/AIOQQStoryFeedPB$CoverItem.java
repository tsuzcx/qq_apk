package aio.qq_story.feed;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class AIOQQStoryFeedPB$CoverItem
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "str_cover", "str_jump_url" }, new Object[] { "", "" }, CoverItem.class);
  public final PBStringField str_cover = PBField.initString("");
  public final PBStringField str_jump_url = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\acom1.jar
 * Qualified Name:     aio.qq_story.feed.AIOQQStoryFeedPB.CoverItem
 * JD-Core Version:    0.7.0.1
 */