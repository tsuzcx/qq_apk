package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class INTERFACE$StPluginProfile
  extends MessageMicro<StPluginProfile>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatField<String> download_domain = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBStringField host_sign = PBField.initString("");
  public final PBStringField noncestr = PBField.initString("");
  public final PBStringField plugin_id = PBField.initString("");
  public final PBRepeatField<String> request_domain = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBUInt32Field running_flag_info = PBField.initUInt32(0);
  public final PBUInt32Field timestamp = PBField.initUInt32(0);
  public final PBRepeatField<String> upload_domain = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBRepeatField<String> wsrequest_domain = PBField.initRepeat(PBStringField.__repeatHelper__);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 64, 72 }, new String[] { "plugin_id", "download_domain", "request_domain", "wsrequest_domain", "upload_domain", "host_sign", "noncestr", "timestamp", "running_flag_info" }, new Object[] { "", "", "", "", "", "", "", localInteger, localInteger }, StPluginProfile.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MINI_INTERFACE.INTERFACE.StPluginProfile
 * JD-Core Version:    0.7.0.1
 */