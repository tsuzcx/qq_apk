package NS_QQ_STORY_CLIENT;

import NS_COMM.COMM.StCommonExt;
import NS_QQ_STORY_META.META.StComment;
import NS_QQ_STORY_META.META.StStoryFeed;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class CLIENT$StGetStoryReplyListReq
  extends MessageMicro<StGetStoryReplyListReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32 }, new String[] { "extInfo", "storyFeed", "comment", "listNum" }, new Object[] { null, null, null, Integer.valueOf(0) }, StGetStoryReplyListReq.class);
  public META.StComment comment = new META.StComment();
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  public final PBUInt32Field listNum = PBField.initUInt32(0);
  public META.StStoryFeed storyFeed = new META.StStoryFeed();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_QQ_STORY_CLIENT.CLIENT.StGetStoryReplyListReq
 * JD-Core Version:    0.7.0.1
 */