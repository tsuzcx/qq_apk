package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class INTERFACE$StAppFixInfoExt
  extends MessageMicro<StAppFixInfoExt>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "clearAuths", "prepayId" }, new Object[] { Integer.valueOf(0), "" }, StAppFixInfoExt.class);
  public final PBInt32Field clearAuths = PBField.initInt32(0);
  public final PBStringField prepayId = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MINI_INTERFACE.INTERFACE.StAppFixInfoExt
 * JD-Core Version:    0.7.0.1
 */