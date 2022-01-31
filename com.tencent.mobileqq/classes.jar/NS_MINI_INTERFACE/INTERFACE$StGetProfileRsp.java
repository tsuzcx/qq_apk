package NS_MINI_INTERFACE;

import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class INTERFACE$StGetProfileRsp
  extends MessageMicro<StGetProfileRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50 }, new String[] { "extInfo", "user", "rawData", "signature", "encryptedData", "iv" }, new Object[] { null, null, "", "", "", "" }, StGetProfileRsp.class);
  public final PBStringField encryptedData = PBField.initString("");
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  public final PBStringField iv = PBField.initString("");
  public final PBStringField rawData = PBField.initString("");
  public final PBStringField signature = PBField.initString("");
  public INTERFACE.StApiUserInfo user = new INTERFACE.StApiUserInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MINI_INTERFACE.INTERFACE.StGetProfileRsp
 * JD-Core Version:    0.7.0.1
 */