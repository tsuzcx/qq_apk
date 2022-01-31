package NS_MINI_META;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class META_PROTOCOL$StServerDomainInfo
  extends MessageMicro<StServerDomainInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 48, 56 }, new String[] { "appid", "requestDomain", "socketDomain", "uploadFileDomain", "downloadFileDomain", "createTimestamp", "updateTimestamp" }, new Object[] { "", "", "", "", "", Integer.valueOf(0), Integer.valueOf(0) }, StServerDomainInfo.class);
  public final PBStringField appid = PBField.initString("");
  public final PBUInt32Field createTimestamp = PBField.initUInt32(0);
  public final PBRepeatField<String> downloadFileDomain = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBRepeatField<String> requestDomain = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBRepeatField<String> socketDomain = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBUInt32Field updateTimestamp = PBField.initUInt32(0);
  public final PBRepeatField<String> uploadFileDomain = PBField.initRepeat(PBStringField.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MINI_META.META_PROTOCOL.StServerDomainInfo
 * JD-Core Version:    0.7.0.1
 */