package NS_MINI_INTERFACE;

import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class INTERFACE$StBatchGetPluginPkgReq
  extends MessageMicro<StBatchGetPluginPkgReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "pluginPkgInfos" }, new Object[] { null, null }, StBatchGetPluginPkgReq.class);
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  public final PBRepeatMessageField<INTERFACE.StPluginPkgInfo> pluginPkgInfos = PBField.initRepeatMessage(INTERFACE.StPluginPkgInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MINI_INTERFACE.INTERFACE.StBatchGetPluginPkgReq
 * JD-Core Version:    0.7.0.1
 */