package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class INTERFACE$StUsePlugin
  extends MessageMicro<StUsePlugin>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "pluginId", "pluginVersion", "pluginName" }, new Object[] { "", "", "" }, StUsePlugin.class);
  public final PBStringField pluginId = PBField.initString("");
  public final PBStringField pluginName = PBField.initString("");
  public final PBStringField pluginVersion = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MINI_INTERFACE.INTERFACE.StUsePlugin
 * JD-Core Version:    0.7.0.1
 */