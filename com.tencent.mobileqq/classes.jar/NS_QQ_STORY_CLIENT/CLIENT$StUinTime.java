package NS_QQ_STORY_CLIENT;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class CLIENT$StUinTime
  extends MessageMicro<StUinTime>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uin", "newestTime" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L) }, StUinTime.class);
  public final PBUInt64Field newestTime = PBField.initUInt64(0L);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_QQ_STORY_CLIENT.CLIENT.StUinTime
 * JD-Core Version:    0.7.0.1
 */