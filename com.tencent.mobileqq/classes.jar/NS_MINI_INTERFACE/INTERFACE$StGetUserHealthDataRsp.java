package NS_MINI_INTERFACE;

import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class INTERFACE$StGetUserHealthDataRsp
  extends MessageMicro<StGetUserHealthDataRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42 }, new String[] { "extInfo", "appid", "encryptedData", "iv", "cloudID" }, new Object[] { null, "", "", "", "" }, StGetUserHealthDataRsp.class);
  public final PBStringField appid = PBField.initString("");
  public final PBStringField cloudID = PBField.initString("");
  public final PBStringField encryptedData = PBField.initString("");
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  public final PBStringField iv = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MINI_INTERFACE.INTERFACE.StGetUserHealthDataRsp
 * JD-Core Version:    0.7.0.1
 */