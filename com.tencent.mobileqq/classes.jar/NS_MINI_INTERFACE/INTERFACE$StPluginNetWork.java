package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

public final class INTERFACE$StPluginNetWork
  extends MessageMicro<StPluginNetWork>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50 }, new String[] { "RequestDomain", "UploadDomain", "DownloadDomain", "BizDomain", "UDPDomain", "WsRequestDomain" }, new Object[] { "", "", "", "", "", "" }, StPluginNetWork.class);
  public final PBRepeatField<String> BizDomain = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBRepeatField<String> DownloadDomain = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBRepeatField<String> RequestDomain = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBRepeatField<String> UDPDomain = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBRepeatField<String> UploadDomain = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBRepeatField<String> WsRequestDomain = PBField.initRepeat(PBStringField.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MINI_INTERFACE.INTERFACE.StPluginNetWork
 * JD-Core Version:    0.7.0.1
 */