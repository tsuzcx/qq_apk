package NS_MINI_INTERFACE;

import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class INTERFACE$StBatchQueryAppInfoRsp
  extends MessageMicro<StBatchQueryAppInfoRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "appInfos" }, new Object[] { null, null }, StBatchQueryAppInfoRsp.class);
  public final PBRepeatMessageField<INTERFACE.StApiAppInfo> appInfos = PBField.initRepeatMessage(INTERFACE.StApiAppInfo.class);
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MINI_INTERFACE.INTERFACE.StBatchQueryAppInfoRsp
 * JD-Core Version:    0.7.0.1
 */