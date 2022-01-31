package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class INTERFACE$StUserSettingInfo
  extends MessageMicro<StUserSettingInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "settingItem", "desc", "authState" }, new Object[] { "", "", Integer.valueOf(0) }, StUserSettingInfo.class);
  public final PBInt32Field authState = PBField.initInt32(0);
  public final PBStringField desc = PBField.initString("");
  public final PBStringField settingItem = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MINI_INTERFACE.INTERFACE.StUserSettingInfo
 * JD-Core Version:    0.7.0.1
 */