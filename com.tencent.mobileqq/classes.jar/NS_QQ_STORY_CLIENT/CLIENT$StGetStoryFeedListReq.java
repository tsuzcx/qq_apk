package NS_QQ_STORY_CLIENT;

import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class CLIENT$StGetStoryFeedListReq
  extends MessageMicro<StGetStoryFeedListReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34 }, new String[] { "extInfo", "listType", "listNum", "uinTime" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(0), null }, StGetStoryFeedListReq.class);
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  public final PBUInt32Field listNum = PBField.initUInt32(0);
  public final PBEnumField listType = PBField.initEnum(0);
  public CLIENT.StUinTime uinTime = new CLIENT.StUinTime();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_QQ_STORY_CLIENT.CLIENT.StGetStoryFeedListReq
 * JD-Core Version:    0.7.0.1
 */