package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class INTERFACE$StSubscribeMessage
  extends MessageMicro<StSubscribeMessage>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "templateId", "authState", "example" }, new Object[] { "", Integer.valueOf(0), null }, StSubscribeMessage.class);
  public final PBInt32Field authState = PBField.initInt32(0);
  public INTERFACE.StExampleDetail example = new INTERFACE.StExampleDetail();
  public final PBStringField templateId = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MINI_INTERFACE.INTERFACE.StSubscribeMessage
 * JD-Core Version:    0.7.0.1
 */