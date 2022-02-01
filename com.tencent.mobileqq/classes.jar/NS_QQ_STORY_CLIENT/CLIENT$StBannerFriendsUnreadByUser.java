package NS_QQ_STORY_CLIENT;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class CLIENT$StBannerFriendsUnreadByUser
  extends MessageMicro<StBannerFriendsUnreadByUser>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField attachInfo = PBField.initString("");
  public final PBUInt32Field isFinish = PBField.initUInt32(0);
  public final PBUInt32Field total = PBField.initUInt32(0);
  public final PBRepeatMessageField<CLIENT.StStoryBanner> userStoryList = PBField.initRepeatMessage(CLIENT.StStoryBanner.class);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34 }, new String[] { "userStoryList", "total", "isFinish", "attachInfo" }, new Object[] { null, localInteger, localInteger, "" }, StBannerFriendsUnreadByUser.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_QQ_STORY_CLIENT.CLIENT.StBannerFriendsUnreadByUser
 * JD-Core Version:    0.7.0.1
 */