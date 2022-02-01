package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

public final class INTERFACE$StDomainConfig
  extends MessageMicro<StDomainConfig>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50 }, new String[] { "requestDomain", "socketDomain", "uploadFileDomain", "downloadFileDomain", "businessDomain", "udpIpList" }, new Object[] { "", "", "", "", "", "" }, StDomainConfig.class);
  public final PBRepeatField<String> businessDomain = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBRepeatField<String> downloadFileDomain = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBRepeatField<String> requestDomain = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBRepeatField<String> socketDomain = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBRepeatField<String> udpIpList = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBRepeatField<String> uploadFileDomain = PBField.initRepeat(PBStringField.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MINI_INTERFACE.INTERFACE.StDomainConfig
 * JD-Core Version:    0.7.0.1
 */