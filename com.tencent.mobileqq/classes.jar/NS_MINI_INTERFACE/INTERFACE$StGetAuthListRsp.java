package NS_MINI_INTERFACE;

import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class INTERFACE$StGetAuthListRsp
  extends MessageMicro<StGetAuthListRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "extInfo", "auths", "settings" }, new Object[] { null, null, null }, StGetAuthListRsp.class);
  public final PBRepeatMessageField<INTERFACE.StUserAuthInfo> auths = PBField.initRepeatMessage(INTERFACE.StUserAuthInfo.class);
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  public final PBRepeatMessageField<INTERFACE.StUserSettingInfo> settings = PBField.initRepeatMessage(INTERFACE.StUserSettingInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MINI_INTERFACE.INTERFACE.StGetAuthListRsp
 * JD-Core Version:    0.7.0.1
 */