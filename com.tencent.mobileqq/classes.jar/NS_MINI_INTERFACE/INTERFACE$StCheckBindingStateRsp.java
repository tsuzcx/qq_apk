package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class INTERFACE$StCheckBindingStateRsp
  extends MessageMicro<StCheckBindingStateRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "bindingState", "msg" }, new Object[] { Integer.valueOf(0), "" }, StCheckBindingStateRsp.class);
  public final PBEnumField bindingState = PBField.initEnum(0);
  public final PBStringField msg = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MINI_INTERFACE.INTERFACE.StCheckBindingStateRsp
 * JD-Core Version:    0.7.0.1
 */