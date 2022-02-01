package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

public final class INTERFACE$StSearchModuleInfo
  extends MessageMicro<StSearchModuleInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "searchApp", "keywords" }, new Object[] { null, "" }, StSearchModuleInfo.class);
  public final PBRepeatField<String> keywords = PBField.initRepeat(PBStringField.__repeatHelper__);
  public INTERFACE.StUserAppInfo searchApp = new INTERFACE.StUserAppInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MINI_INTERFACE.INTERFACE.StSearchModuleInfo
 * JD-Core Version:    0.7.0.1
 */