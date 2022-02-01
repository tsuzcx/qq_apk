package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class INTERFACE$StExpandItem
  extends MessageMicro<StExpandItem>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32 }, new String[] { "appInfo", "icon", "name", "adId" }, new Object[] { null, "", "", Integer.valueOf(0) }, StExpandItem.class);
  public final PBUInt32Field adId = PBField.initUInt32(0);
  public INTERFACE.StApiAppInfo appInfo = new INTERFACE.StApiAppInfo();
  public final PBStringField icon = PBField.initString("");
  public final PBStringField name = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MINI_INTERFACE.INTERFACE.StExpandItem
 * JD-Core Version:    0.7.0.1
 */