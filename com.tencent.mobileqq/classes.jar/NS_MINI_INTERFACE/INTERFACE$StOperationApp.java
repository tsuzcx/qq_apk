package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class INTERFACE$StOperationApp
  extends MessageMicro<StOperationApp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "app", "name", "icon", "nightIcon" }, new Object[] { null, "", "", "" }, StOperationApp.class);
  public INTERFACE.StUserAppInfo app = new INTERFACE.StUserAppInfo();
  public final PBStringField icon = PBField.initString("");
  public final PBStringField name = PBField.initString("");
  public final PBStringField nightIcon = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MINI_INTERFACE.INTERFACE.StOperationApp
 * JD-Core Version:    0.7.0.1
 */