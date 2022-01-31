package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class INTERFACE$StVerifyPluginReq
  extends MessageMicro<StVerifyPluginReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "appid", "plugins" }, new Object[] { "", null }, StVerifyPluginReq.class);
  public final PBStringField appid = PBField.initString("");
  public final PBRepeatMessageField<INTERFACE.StPlugin> plugins = PBField.initRepeatMessage(INTERFACE.StPlugin.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MINI_INTERFACE.INTERFACE.StVerifyPluginReq
 * JD-Core Version:    0.7.0.1
 */