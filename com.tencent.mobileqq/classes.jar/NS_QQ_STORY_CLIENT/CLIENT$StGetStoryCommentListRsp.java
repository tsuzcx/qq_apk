package NS_QQ_STORY_CLIENT;

import NS_COMM.COMM.StCommonExt;
import NS_QQ_STORY_META.META.StComment;
import NS_QQ_STORY_META.META.StStoryFeed;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class CLIENT$StGetStoryCommentListRsp
  extends MessageMicro<StGetStoryCommentListRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  public final PBUInt32Field isFinish = PBField.initUInt32(0);
  public META.StStoryFeed storyFeed = new META.StStoryFeed();
  public final PBUInt32Field totalNum = PBField.initUInt32(0);
  public final PBRepeatMessageField<META.StComment> vecComment = PBField.initRepeatMessage(META.StComment.class);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 42 }, new String[] { "extInfo", "vecComment", "totalNum", "isFinish", "storyFeed" }, new Object[] { null, null, localInteger, localInteger, null }, StGetStoryCommentListRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_QQ_STORY_CLIENT.CLIENT.StGetStoryCommentListRsp
 * JD-Core Version:    0.7.0.1
 */