package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class INTERFACE$StContactInfo
  extends MessageMicro<StContactInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "appId", "plugin_list" }, new Object[] { "", null }, StContactInfo.class);
  public final PBStringField appId = PBField.initString("");
  public final PBRepeatMessageField<INTERFACE.StPluginDetail> plugin_list = PBField.initRepeatMessage(INTERFACE.StPluginDetail.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MINI_INTERFACE.INTERFACE.StContactInfo
 * JD-Core Version:    0.7.0.1
 */