package NS_QQ_STORY_CLIENT;

import NS_COMM.COMM.StCommonExt;
import NS_QQ_STORY_META.META.StStoryFeed;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class CLIENT$StGetStoryFeedListRsp
  extends MessageMicro<StGetStoryFeedListRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  public final PBUInt32Field hasNewStory = PBField.initUInt32(0);
  public final PBUInt32Field isFinish = PBField.initUInt32(0);
  public final PBUInt32Field isShowCamera = PBField.initUInt32(0);
  public final PBBytesField storyBannerBuff = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field totalNum = PBField.initUInt32(0);
  public final PBRepeatMessageField<META.StStoryFeed> vecStoryFeed = PBField.initRepeatMessage(META.StStoryFeed.class);
  public final PBRepeatMessageField<CLIENT.StUinStory> vecUinStory = PBField.initRepeatMessage(CLIENT.StUinStory.class);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 50, 56, 66 }, new String[] { "extInfo", "vecStoryFeed", "totalNum", "isFinish", "isShowCamera", "vecUinStory", "hasNewStory", "storyBannerBuff" }, new Object[] { null, null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), localByteStringMicro }, StGetStoryFeedListRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_QQ_STORY_CLIENT.CLIENT.StGetStoryFeedListRsp
 * JD-Core Version:    0.7.0.1
 */