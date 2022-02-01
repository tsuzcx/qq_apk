package NS_QQ_STORY_CLIENT;

import NS_COMM.COMM.StCommonExt;
import NS_QQ_STORY_META.META.StStoryFeed;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class CLIENT$StPublishStoryFeedReq
  extends MessageMicro<StPublishStoryFeedReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "storyFeed" }, new Object[] { null, null }, StPublishStoryFeedReq.class);
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  public META.StStoryFeed storyFeed = new META.StStoryFeed();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_QQ_STORY_CLIENT.CLIENT.StPublishStoryFeedReq
 * JD-Core Version:    0.7.0.1
 */