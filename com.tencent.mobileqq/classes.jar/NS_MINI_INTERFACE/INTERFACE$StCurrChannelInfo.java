package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class INTERFACE$StCurrChannelInfo
  extends MessageMicro<StCurrChannelInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "refer", "via" }, new Object[] { "", "" }, StCurrChannelInfo.class);
  public final PBStringField refer = PBField.initString("");
  public final PBStringField via = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MINI_INTERFACE.INTERFACE.StCurrChannelInfo
 * JD-Core Version:    0.7.0.1
 */