package NS_MINI_AD;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class MiniAppAd$StAppPlayingFriList
  extends MessageMicro<StAppPlayingFriList>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "strAppId", "vecFriUin", "total" }, new Object[] { "", Long.valueOf(0L), Integer.valueOf(0) }, StAppPlayingFriList.class);
  public final PBStringField strAppId = PBField.initString("");
  public final PBUInt32Field total = PBField.initUInt32(0);
  public final PBRepeatField<Long> vecFriUin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MINI_AD.MiniAppAd.StAppPlayingFriList
 * JD-Core Version:    0.7.0.1
 */