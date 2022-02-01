package NS_MINI_INTERFACE;

import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class INTERFACE$StBatchQueryAppInfoByPathReq
  extends MessageMicro<StBatchQueryAppInfoByPathReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "appPaths" }, new Object[] { null, null }, StBatchQueryAppInfoByPathReq.class);
  public final PBRepeatMessageField<INTERFACE.StAppPath> appPaths = PBField.initRepeatMessage(INTERFACE.StAppPath.class);
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MINI_INTERFACE.INTERFACE.StBatchQueryAppInfoByPathReq
 * JD-Core Version:    0.7.0.1
 */