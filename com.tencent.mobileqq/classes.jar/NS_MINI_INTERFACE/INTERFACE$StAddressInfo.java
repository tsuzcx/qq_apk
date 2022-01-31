package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class INTERFACE$StAddressInfo
  extends MessageMicro<StAddressInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "country", "province", "city" }, new Object[] { "", "", "" }, StAddressInfo.class);
  public final PBStringField city = PBField.initString("");
  public final PBStringField country = PBField.initString("");
  public final PBStringField province = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MINI_INTERFACE.INTERFACE.StAddressInfo
 * JD-Core Version:    0.7.0.1
 */