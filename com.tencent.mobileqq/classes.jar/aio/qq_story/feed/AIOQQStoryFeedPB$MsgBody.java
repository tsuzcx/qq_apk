package aio.qq_story.feed;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class AIOQQStoryFeedPB$MsgBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint32_keep_time", "uint32_latest_qzone_time", "msg_aio_feed" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null }, MsgBody.class);
  public AIOQQStoryFeedPB.AIOQQStoryFeed msg_aio_feed = new AIOQQStoryFeedPB.AIOQQStoryFeed();
  public final PBUInt32Field uint32_keep_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_latest_qzone_time = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\acom1.jar
 * Qualified Name:     aio.qq_story.feed.AIOQQStoryFeedPB.MsgBody
 * JD-Core Version:    0.7.0.1
 */