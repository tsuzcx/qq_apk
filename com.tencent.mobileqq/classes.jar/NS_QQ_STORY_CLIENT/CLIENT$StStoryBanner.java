package NS_QQ_STORY_CLIENT;

import NS_QQ_STORY_META.META.StStoryFeed;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class CLIENT$StStoryBanner
  extends MessageMicro<StStoryBanner>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "vecStoryFeed", "unreadCount" }, new Object[] { null, Integer.valueOf(0) }, StStoryBanner.class);
  public final PBUInt32Field unreadCount = PBField.initUInt32(0);
  public final PBRepeatMessageField<META.StStoryFeed> vecStoryFeed = PBField.initRepeatMessage(META.StStoryFeed.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_QQ_STORY_CLIENT.CLIENT.StStoryBanner
 * JD-Core Version:    0.7.0.1
 */