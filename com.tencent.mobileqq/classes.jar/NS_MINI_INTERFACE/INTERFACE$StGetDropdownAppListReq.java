package NS_MINI_INTERFACE;

import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class INTERFACE$StGetDropdownAppListReq
  extends MessageMicro<StGetDropdownAppListReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 50, 56, 66 }, new String[] { "extInfo", "oldRecommendList", "feiqi", "types", "hasCache", "deviceInfo", "subTypes", "itemIds" }, new Object[] { null, null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), "" }, StGetDropdownAppListReq.class);
  public INTERFACE.DeviceInfo deviceInfo = new INTERFACE.DeviceInfo();
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  public final PBInt32Field feiqi = PBField.initInt32(0);
  public final PBInt32Field hasCache = PBField.initInt32(0);
  public final PBRepeatField<String> itemIds = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBRepeatMessageField<INTERFACE.StRecommendApp> oldRecommendList = PBField.initRepeatMessage(INTERFACE.StRecommendApp.class);
  public final PBRepeatField<Integer> subTypes = PBField.initRepeat(PBInt32Field.__repeatHelper__);
  public final PBRepeatField<Integer> types = PBField.initRepeat(PBInt32Field.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MINI_INTERFACE.INTERFACE.StGetDropdownAppListReq
 * JD-Core Version:    0.7.0.1
 */