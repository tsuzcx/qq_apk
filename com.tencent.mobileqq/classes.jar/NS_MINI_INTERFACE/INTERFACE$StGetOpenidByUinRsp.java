package NS_MINI_INTERFACE;

import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class INTERFACE$StGetOpenidByUinRsp
  extends MessageMicro<StGetOpenidByUinRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "openid" }, new Object[] { null, "" }, StGetOpenidByUinRsp.class);
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  public final PBStringField openid = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MINI_INTERFACE.INTERFACE.StGetOpenidByUinRsp
 * JD-Core Version:    0.7.0.1
 */