package NS_MINI_META;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class META_PROTOCOL$StAnnouncementInfo
  extends MessageMicro<StAnnouncementInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34 }, new String[] { "announceId", "announceTime", "announceTitle", "contentUrl" }, new Object[] { "", Integer.valueOf(0), "", "" }, StAnnouncementInfo.class);
  public final PBStringField announceId = PBField.initString("");
  public final PBUInt32Field announceTime = PBField.initUInt32(0);
  public final PBStringField announceTitle = PBField.initString("");
  public final PBStringField contentUrl = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MINI_META.META_PROTOCOL.StAnnouncementInfo
 * JD-Core Version:    0.7.0.1
 */