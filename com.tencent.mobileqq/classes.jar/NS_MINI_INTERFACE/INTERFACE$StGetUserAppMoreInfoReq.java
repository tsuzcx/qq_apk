package NS_MINI_INTERFACE;

import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

public final class INTERFACE$StGetUserAppMoreInfoReq
  extends MessageMicro<StGetUserAppMoreInfoReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "extInfo", "appIds", "verType" }, new Object[] { null, "", Integer.valueOf(0) }, StGetUserAppMoreInfoReq.class);
  public final PBRepeatField<String> appIds = PBField.initRepeat(PBStringField.__repeatHelper__);
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  public final PBEnumField verType = PBField.initEnum(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MINI_INTERFACE.INTERFACE.StGetUserAppMoreInfoReq
 * JD-Core Version:    0.7.0.1
 */