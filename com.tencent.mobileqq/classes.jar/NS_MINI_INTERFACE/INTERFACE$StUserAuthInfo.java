package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class INTERFACE$StUserAuthInfo
  extends MessageMicro<StUserAuthInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34 }, new String[] { "scope", "desc", "authState", "settingPageTitle" }, new Object[] { "", "", Integer.valueOf(0), "" }, StUserAuthInfo.class);
  public final PBInt32Field authState = PBField.initInt32(0);
  public final PBStringField desc = PBField.initString("");
  public final PBStringField scope = PBField.initString("");
  public final PBStringField settingPageTitle = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MINI_INTERFACE.INTERFACE.StUserAuthInfo
 * JD-Core Version:    0.7.0.1
 */