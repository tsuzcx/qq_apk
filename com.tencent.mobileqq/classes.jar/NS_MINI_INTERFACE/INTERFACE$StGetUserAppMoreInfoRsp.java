package NS_MINI_INTERFACE;

import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class INTERFACE$StGetUserAppMoreInfoRsp
  extends MessageMicro<StGetUserAppMoreInfoRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "appMoreInfoList" }, new Object[] { null, null }, StGetUserAppMoreInfoRsp.class);
  public final PBRepeatMessageField<INTERFACE.StApiAppMoreInfo> appMoreInfoList = PBField.initRepeatMessage(INTERFACE.StApiAppMoreInfo.class);
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MINI_INTERFACE.INTERFACE.StGetUserAppMoreInfoRsp
 * JD-Core Version:    0.7.0.1
 */