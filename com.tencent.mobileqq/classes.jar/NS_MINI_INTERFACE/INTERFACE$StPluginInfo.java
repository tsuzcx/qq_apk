package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class INTERFACE$StPluginInfo
  extends MessageMicro<StPluginInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40 }, new String[] { "pluginId", "pluginName", "version", "url", "fileSize" }, new Object[] { "", "", "", "", Integer.valueOf(0) }, StPluginInfo.class);
  public final PBInt32Field fileSize = PBField.initInt32(0);
  public final PBStringField pluginId = PBField.initString("");
  public final PBStringField pluginName = PBField.initString("");
  public final PBStringField url = PBField.initString("");
  public final PBStringField version = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MINI_INTERFACE.INTERFACE.StPluginInfo
 * JD-Core Version:    0.7.0.1
 */