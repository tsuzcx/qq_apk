package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class INTERFACE$StPhoneNumber
  extends MessageMicro<StPhoneNumber>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42 }, new String[] { "phoneType", "purePhoneNumber", "countryCode", "encryptedData", "iv" }, new Object[] { Integer.valueOf(0), "", "", "", "" }, StPhoneNumber.class);
  public final PBStringField countryCode = PBField.initString("");
  public final PBStringField encryptedData = PBField.initString("");
  public final PBStringField iv = PBField.initString("");
  public final PBInt32Field phoneType = PBField.initInt32(0);
  public final PBStringField purePhoneNumber = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MINI_INTERFACE.INTERFACE.StPhoneNumber
 * JD-Core Version:    0.7.0.1
 */