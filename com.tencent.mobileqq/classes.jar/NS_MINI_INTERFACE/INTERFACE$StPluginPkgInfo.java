package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class INTERFACE$StPluginPkgInfo
  extends MessageMicro<StPluginPkgInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "pluginId", "version", "pkgUrl" }, new Object[] { "", "", "" }, StPluginPkgInfo.class);
  public final PBStringField pkgUrl = PBField.initString("");
  public final PBStringField pluginId = PBField.initString("");
  public final PBStringField version = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MINI_INTERFACE.INTERFACE.StPluginPkgInfo
 * JD-Core Version:    0.7.0.1
 */