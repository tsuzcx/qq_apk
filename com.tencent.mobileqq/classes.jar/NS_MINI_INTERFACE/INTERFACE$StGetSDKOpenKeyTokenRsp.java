package NS_MINI_INTERFACE;

import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class INTERFACE$StGetSDKOpenKeyTokenRsp
  extends MessageMicro<StGetSDKOpenKeyTokenRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "token" }, new Object[] { null, "" }, StGetSDKOpenKeyTokenRsp.class);
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  public final PBStringField token = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MINI_INTERFACE.INTERFACE.StGetSDKOpenKeyTokenRsp
 * JD-Core Version:    0.7.0.1
 */