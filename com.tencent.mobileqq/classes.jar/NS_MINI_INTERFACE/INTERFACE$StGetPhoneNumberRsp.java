package NS_MINI_INTERFACE;

import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class INTERFACE$StGetPhoneNumberRsp
  extends MessageMicro<StGetPhoneNumberRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50 }, new String[] { "extInfo", "purePhoneNumber", "countryCode", "encryptedData", "iv", "phoneLists" }, new Object[] { null, "", "", "", "", null }, StGetPhoneNumberRsp.class);
  public final PBStringField countryCode = PBField.initString("");
  public final PBStringField encryptedData = PBField.initString("");
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  public final PBStringField iv = PBField.initString("");
  public final PBRepeatMessageField<INTERFACE.StPhoneNumber> phoneLists = PBField.initRepeatMessage(INTERFACE.StPhoneNumber.class);
  public final PBStringField purePhoneNumber = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MINI_INTERFACE.INTERFACE.StGetPhoneNumberRsp
 * JD-Core Version:    0.7.0.1
 */