package aio.qq_story.feed;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class AIOQQStoryFeedPB$AIOQQStoryFeed
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32 }, new String[] { "str_feed_id", "uint64_time", "msg_covers_info", "uint32_video_num" }, new Object[] { "", Long.valueOf(0L), null, Integer.valueOf(0) }, AIOQQStoryFeed.class);
  public AIOQQStoryFeedPB.CoverItem msg_covers_info = new AIOQQStoryFeedPB.CoverItem();
  public final PBStringField str_feed_id = PBField.initString("");
  public final PBUInt32Field uint32_video_num = PBField.initUInt32(0);
  public final PBUInt64Field uint64_time = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\acom1.jar
 * Qualified Name:     aio.qq_story.feed.AIOQQStoryFeedPB.AIOQQStoryFeed
 * JD-Core Version:    0.7.0.1
 */