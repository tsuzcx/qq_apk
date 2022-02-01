package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class INTERFACE$StCheckBindingStateReq
  extends MessageMicro<StCheckBindingStateReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "appId", "uid", "bindType" }, new Object[] { "", "", Integer.valueOf(0) }, StCheckBindingStateReq.class);
  public final PBStringField appId = PBField.initString("");
  public final PBEnumField bindType = PBField.initEnum(0);
  public final PBStringField uid = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MINI_INTERFACE.INTERFACE.StCheckBindingStateReq
 * JD-Core Version:    0.7.0.1
 */