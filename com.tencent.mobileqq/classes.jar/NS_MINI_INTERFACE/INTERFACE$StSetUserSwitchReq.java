package NS_MINI_INTERFACE;

import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class INTERFACE$StSetUserSwitchReq
  extends MessageMicro<StSetUserSwitchReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "extInfo", "key", "value" }, new Object[] { null, "", Integer.valueOf(0) }, StSetUserSwitchReq.class);
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  public final PBStringField key = PBField.initString("");
  public final PBInt32Field value = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MINI_INTERFACE.INTERFACE.StSetUserSwitchReq
 * JD-Core Version:    0.7.0.1
 */