package NS_MINI_INTERFACE;

import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class INTERFACE$StGetAppInfoByIdRsp
  extends MessageMicro<StGetAppInfoByIdRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "appInfo" }, new Object[] { null, null }, StGetAppInfoByIdRsp.class);
  public INTERFACE.StApiAppInfo appInfo = new INTERFACE.StApiAppInfo();
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MINI_INTERFACE.INTERFACE.StGetAppInfoByIdRsp
 * JD-Core Version:    0.7.0.1
 */