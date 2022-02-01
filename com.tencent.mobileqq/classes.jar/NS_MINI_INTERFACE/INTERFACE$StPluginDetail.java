package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class INTERFACE$StPluginDetail
  extends MessageMicro<StPluginDetail>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58 }, new String[] { "PluginNetWork", "brandiconurl", "headimgurl", "id", "last_version", "nickname", "signature" }, new Object[] { null, "", "", "", null, "", "" }, StPluginDetail.class);
  public INTERFACE.StPluginNetWork PluginNetWork = new INTERFACE.StPluginNetWork();
  public final PBStringField brandiconurl = PBField.initString("");
  public final PBStringField headimgurl = PBField.initString("");
  public final PBStringField id = PBField.initString("");
  public INTERFACE.StLastVersion last_version = new INTERFACE.StLastVersion();
  public final PBStringField nickname = PBField.initString("");
  public final PBStringField signature = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MINI_INTERFACE.INTERFACE.StPluginDetail
 * JD-Core Version:    0.7.0.1
 */