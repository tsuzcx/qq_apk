package NS_STORE_APP_CLIENT;

import NS_MINI_INTERFACE.INTERFACE.StUserAppInfo;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class STORE_APP_CLIENT$StoreAppInfo
  extends MessageMicro<StoreAppInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 42, 48, 58, 66, 74, 82, 90, 98 }, new String[] { "userAppInfo", "userNum", "bgIcon", "via", "users", "newestFriTime", "bossTrace", "recommendReason", "closeFri", "rcmdTrace", "playingFriText", "serviceCategoryText" }, new Object[] { null, Integer.valueOf(0), "", "", null, Long.valueOf(0L), "", "", null, "", "", "" }, StoreAppInfo.class);
  public final PBStringField bgIcon = PBField.initString("");
  public final PBStringField bossTrace = PBField.initString("");
  public STORE_APP_CLIENT.StUserInfo closeFri = new STORE_APP_CLIENT.StUserInfo();
  public final PBUInt64Field newestFriTime = PBField.initUInt64(0L);
  public final PBStringField playingFriText = PBField.initString("");
  public final PBStringField rcmdTrace = PBField.initString("");
  public final PBStringField recommendReason = PBField.initString("");
  public final PBStringField serviceCategoryText = PBField.initString("");
  public INTERFACE.StUserAppInfo userAppInfo = new INTERFACE.StUserAppInfo();
  public final PBInt32Field userNum = PBField.initInt32(0);
  public final PBRepeatMessageField<STORE_APP_CLIENT.StUserInfo> users = PBField.initRepeatMessage(STORE_APP_CLIENT.StUserInfo.class);
  public final PBStringField via = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_STORE_APP_CLIENT.STORE_APP_CLIENT.StoreAppInfo
 * JD-Core Version:    0.7.0.1
 */