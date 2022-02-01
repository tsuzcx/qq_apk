package NS_QQ_STORY_CLIENT;

import NS_COMM.COMM.StCommonExt;
import NS_QQ_STORY_META.META.StStoryFeed;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class CLIENT$StGetUserNewestStoryRsp
  extends MessageMicro<StGetUserNewestStoryRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32 }, new String[] { "extInfo", "vecStoryFeed", "vecUinStory", "hasNewStory" }, new Object[] { null, null, null, Integer.valueOf(0) }, StGetUserNewestStoryRsp.class);
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  public final PBUInt32Field hasNewStory = PBField.initUInt32(0);
  public final PBRepeatMessageField<META.StStoryFeed> vecStoryFeed = PBField.initRepeatMessage(META.StStoryFeed.class);
  public final PBRepeatMessageField<CLIENT.StUinStory> vecUinStory = PBField.initRepeatMessage(CLIENT.StUinStory.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_QQ_STORY_CLIENT.CLIENT.StGetUserNewestStoryRsp
 * JD-Core Version:    0.7.0.1
 */