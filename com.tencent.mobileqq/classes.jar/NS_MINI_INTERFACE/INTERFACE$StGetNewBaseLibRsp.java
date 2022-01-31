package NS_MINI_INTERFACE;

import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class INTERFACE$StGetNewBaseLibRsp
  extends MessageMicro<StGetNewBaseLibRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34 }, new String[] { "extInfo", "libInfo", "interval", "jsOrsoLibs" }, new Object[] { null, null, Integer.valueOf(0), null }, StGetNewBaseLibRsp.class);
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  public final PBInt32Field interval = PBField.initInt32(0);
  public final PBRepeatMessageField<INTERFACE.StBaseLibInfo> jsOrsoLibs = PBField.initRepeatMessage(INTERFACE.StBaseLibInfo.class);
  public INTERFACE.StBaseLibInfo libInfo = new INTERFACE.StBaseLibInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MINI_INTERFACE.INTERFACE.StGetNewBaseLibRsp
 * JD-Core Version:    0.7.0.1
 */