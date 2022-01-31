package NS_MINI_INTERFACE;

import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class INTERFACE$StGetUserSettingRsp
  extends MessageMicro<StGetUserSettingRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "setting" }, new Object[] { null, null }, StGetUserSettingRsp.class);
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  public INTERFACE.StUserSettingInfo setting = new INTERFACE.StUserSettingInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MINI_INTERFACE.INTERFACE.StGetUserSettingRsp
 * JD-Core Version:    0.7.0.1
 */