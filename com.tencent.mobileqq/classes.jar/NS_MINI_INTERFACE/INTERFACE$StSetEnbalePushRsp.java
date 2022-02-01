package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class INTERFACE$StSetEnbalePushRsp
  extends MessageMicro<StSetEnbalePushRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "enablePush" }, new Object[] { Integer.valueOf(0) }, StSetEnbalePushRsp.class);
  public final PBUInt32Field enablePush = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MINI_INTERFACE.INTERFACE.StSetEnbalePushRsp
 * JD-Core Version:    0.7.0.1
 */