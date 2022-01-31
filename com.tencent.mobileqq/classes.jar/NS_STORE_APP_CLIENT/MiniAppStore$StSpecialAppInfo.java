package NS_STORE_APP_CLIENT;

import NS_MINI_INTERFACE.INTERFACE.StUserAppInfo;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class MiniAppStore$StSpecialAppInfo
  extends MessageMicro<StSpecialAppInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42 }, new String[] { "stAppInfo", "stFirstPicInfo", "vecPicInfo", "stVideoInfo", "strText" }, new Object[] { null, null, null, null, "" }, StSpecialAppInfo.class);
  public INTERFACE.StUserAppInfo stAppInfo = new INTERFACE.StUserAppInfo();
  public MiniAppStore.StPicInfo stFirstPicInfo = new MiniAppStore.StPicInfo();
  public MiniAppStore.StVideoInfo stVideoInfo = new MiniAppStore.StVideoInfo();
  public final PBStringField strText = PBField.initString("");
  public final PBRepeatMessageField<MiniAppStore.StPicInfo> vecPicInfo = PBField.initRepeatMessage(MiniAppStore.StPicInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_STORE_APP_CLIENT.MiniAppStore.StSpecialAppInfo
 * JD-Core Version:    0.7.0.1
 */