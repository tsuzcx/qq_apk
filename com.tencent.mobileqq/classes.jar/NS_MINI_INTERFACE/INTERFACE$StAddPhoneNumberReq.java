package NS_MINI_INTERFACE;

import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class INTERFACE$StAddPhoneNumberReq
  extends MessageMicro<StAddPhoneNumberReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40 }, new String[] { "extInfo", "appId", "purePhoneNumber", "countryCode", "isSave" }, new Object[] { null, "", "", "", Integer.valueOf(0) }, StAddPhoneNumberReq.class);
  public final PBStringField appId = PBField.initString("");
  public final PBStringField countryCode = PBField.initString("");
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  public final PBInt32Field isSave = PBField.initInt32(0);
  public final PBStringField purePhoneNumber = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MINI_INTERFACE.INTERFACE.StAddPhoneNumberReq
 * JD-Core Version:    0.7.0.1
 */