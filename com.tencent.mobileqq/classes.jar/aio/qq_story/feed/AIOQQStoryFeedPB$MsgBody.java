package aio.qq_story.feed;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class AIOQQStoryFeedPB$MsgBody
  extends MessageMicro<MsgBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32 }, new String[] { "uint32_keep_time", "uint32_latest_qzone_time", "msg_aio_feed", "uint64_msg_time" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null, Long.valueOf(0L) }, MsgBody.class);
  public AIOQQStoryFeedPB.AIOQQStoryFeed msg_aio_feed = new AIOQQStoryFeedPB.AIOQQStoryFeed();
  public final PBUInt32Field uint32_keep_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_latest_qzone_time = PBField.initUInt32(0);
  public final PBUInt64Field uint64_msg_time = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aio.qq_story.feed.AIOQQStoryFeedPB.MsgBody
 * JD-Core Version:    0.7.0.1
 */