package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class INTERFACE$StUserAppInfo
  extends MessageMicro<StUserAppInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40, 48, 58, 64, 74, 82 }, new String[] { "appInfo", "useTime", "putTop", "doLike", "likeNum", "enablePush", "openid", "tinyid", "bgPic", "motionPics" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Long.valueOf(0L), "", null }, StUserAppInfo.class);
  public INTERFACE.StApiAppInfo appInfo = new INTERFACE.StApiAppInfo();
  public final PBStringField bgPic = PBField.initString("");
  public final PBUInt32Field doLike = PBField.initUInt32(0);
  public final PBUInt32Field enablePush = PBField.initUInt32(0);
  public final PBUInt32Field likeNum = PBField.initUInt32(0);
  public final PBRepeatMessageField<INTERFACE.StMotionPicInfo> motionPics = PBField.initRepeatMessage(INTERFACE.StMotionPicInfo.class);
  public final PBStringField openid = PBField.initString("");
  public final PBUInt32Field putTop = PBField.initUInt32(0);
  public final PBUInt64Field tinyid = PBField.initUInt64(0L);
  public final PBUInt32Field useTime = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MINI_INTERFACE.INTERFACE.StUserAppInfo
 * JD-Core Version:    0.7.0.1
 */