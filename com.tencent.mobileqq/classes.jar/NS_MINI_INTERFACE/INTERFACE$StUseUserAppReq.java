package NS_MINI_INTERFACE;

import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class INTERFACE$StUseUserAppReq
  extends MessageMicro<StUseUserAppReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 33, 40, 48, 58, 66 }, new String[] { "extInfo", "appId", "verType", "useTime", "source", "needRecommend", "oldRecommendList", "channelInfo" }, new Object[] { null, "", Integer.valueOf(0), Double.valueOf(0.0D), Integer.valueOf(0), Integer.valueOf(0), null, null }, StUseUserAppReq.class);
  public final PBStringField appId = PBField.initString("");
  public INTERFACE.StCurrChannelInfo channelInfo = new INTERFACE.StCurrChannelInfo();
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  public final PBInt32Field needRecommend = PBField.initInt32(0);
  public final PBRepeatMessageField<INTERFACE.StRecommendApp> oldRecommendList = PBField.initRepeatMessage(INTERFACE.StRecommendApp.class);
  public final PBInt32Field source = PBField.initInt32(0);
  public final PBDoubleField useTime = PBField.initDouble(0.0D);
  public final PBEnumField verType = PBField.initEnum(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MINI_INTERFACE.INTERFACE.StUseUserAppReq
 * JD-Core Version:    0.7.0.1
 */