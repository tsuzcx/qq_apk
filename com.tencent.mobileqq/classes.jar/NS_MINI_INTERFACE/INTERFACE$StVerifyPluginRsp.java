package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class INTERFACE$StVerifyPluginRsp
  extends MessageMicro<StVerifyPluginRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "pluginList" }, new Object[] { null }, StVerifyPluginRsp.class);
  public final PBRepeatMessageField<INTERFACE.StPluginProfile> pluginList = PBField.initRepeatMessage(INTERFACE.StPluginProfile.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MINI_INTERFACE.INTERFACE.StVerifyPluginRsp
 * JD-Core Version:    0.7.0.1
 */