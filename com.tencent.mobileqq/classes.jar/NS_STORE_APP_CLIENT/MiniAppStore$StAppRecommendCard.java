package NS_STORE_APP_CLIENT;

import NS_MINI_INTERFACE.INTERFACE.StUserAppInfo;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class MiniAppStore$StAppRecommendCard
  extends MessageMicro<StAppRecommendCard>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public MiniAppStore.StSpecialAppInfo stSpecialAppInfo = new MiniAppStore.StSpecialAppInfo();
  public final PBStringField strCardId = PBField.initString("");
  public final PBStringField strCardSubTitle = PBField.initString("");
  public final PBStringField strCardTitle = PBField.initString("");
  public final PBUInt32Field uiCardStatus = PBField.initUInt32(0);
  public final PBUInt32Field uiCardType = PBField.initUInt32(0);
  public final PBRepeatMessageField<INTERFACE.StUserAppInfo> vecAppInfo = PBField.initRepeatMessage(INTERFACE.StUserAppInfo.class);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 42, 50, 56 }, new String[] { "strCardId", "strCardTitle", "strCardSubTitle", "uiCardType", "vecAppInfo", "stSpecialAppInfo", "uiCardStatus" }, new Object[] { "", "", "", localInteger, null, null, localInteger }, StAppRecommendCard.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_STORE_APP_CLIENT.MiniAppStore.StAppRecommendCard
 * JD-Core Version:    0.7.0.1
 */