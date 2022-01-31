package NS_MINI_INTERFACE;

import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class INTERFACE$StGetAppInfoByLinkRsp
  extends MessageMicro<StGetAppInfoByLinkRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "extInfo", "appInfo", "shareTicket" }, new Object[] { null, null, "" }, StGetAppInfoByLinkRsp.class);
  public INTERFACE.StApiAppInfo appInfo = new INTERFACE.StApiAppInfo();
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  public final PBStringField shareTicket = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MINI_INTERFACE.INTERFACE.StGetAppInfoByLinkRsp
 * JD-Core Version:    0.7.0.1
 */