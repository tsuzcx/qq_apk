package NS_MINI_INTERFACE;

import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class INTERFACE$StGetRecommendAppListReq
  extends MessageMicro<StGetRecommendAppListReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 33, 42, 50 }, new String[] { "extInfo", "appId", "verType", "useTime", "oldRecommendList", "deviceInfo" }, new Object[] { null, "", Integer.valueOf(0), Double.valueOf(0.0D), null, null }, StGetRecommendAppListReq.class);
  public final PBStringField appId = PBField.initString("");
  public INTERFACE.DeviceInfo deviceInfo = new INTERFACE.DeviceInfo();
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  public final PBRepeatMessageField<INTERFACE.StRecommendApp> oldRecommendList = PBField.initRepeatMessage(INTERFACE.StRecommendApp.class);
  public final PBDoubleField useTime = PBField.initDouble(0.0D);
  public final PBEnumField verType = PBField.initEnum(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MINI_INTERFACE.INTERFACE.StGetRecommendAppListReq
 * JD-Core Version:    0.7.0.1
 */