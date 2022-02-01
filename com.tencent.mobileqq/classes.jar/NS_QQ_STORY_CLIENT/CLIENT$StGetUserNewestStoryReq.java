package NS_QQ_STORY_CLIENT;

import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class CLIENT$StGetUserNewestStoryReq
  extends MessageMicro<StGetUserNewestStoryReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "extInfo", "vecUinTime", "fromScene" }, new Object[] { null, null, Integer.valueOf(0) }, StGetUserNewestStoryReq.class);
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  public final PBUInt32Field fromScene = PBField.initUInt32(0);
  public final PBRepeatMessageField<CLIENT.StUinTime> vecUinTime = PBField.initRepeatMessage(CLIENT.StUinTime.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_QQ_STORY_CLIENT.CLIENT.StGetUserNewestStoryReq
 * JD-Core Version:    0.7.0.1
 */