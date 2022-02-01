package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class INTERFACE$StCacheController
  extends MessageMicro<StCacheController>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "appInfo", "cachePkg" }, new Object[] { null, Integer.valueOf(0) }, StCacheController.class);
  public INTERFACE.StApiAppInfo appInfo = new INTERFACE.StApiAppInfo();
  public final PBInt32Field cachePkg = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MINI_INTERFACE.INTERFACE.StCacheController
 * JD-Core Version:    0.7.0.1
 */