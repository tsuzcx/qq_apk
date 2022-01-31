package NS_MINI_INTERFACE;

import NS_COMM.COMM.Result;
import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class INTERFACE$StCode2SessionKeyRsp
  extends MessageMicro<StCode2SessionKeyRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42 }, new String[] { "extInfo", "ret", "openid", "sessionKey", "unionid" }, new Object[] { null, null, "", "", "" }, StCode2SessionKeyRsp.class);
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  public final PBStringField openid = PBField.initString("");
  public COMM.Result ret = new COMM.Result();
  public final PBStringField sessionKey = PBField.initString("");
  public final PBStringField unionid = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MINI_INTERFACE.INTERFACE.StCode2SessionKeyRsp
 * JD-Core Version:    0.7.0.1
 */