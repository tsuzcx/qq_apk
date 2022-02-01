package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;

public final class INTERFACE$StAppMode
  extends MessageMicro<StAppMode>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBoolField authoritySilent = PBField.initBool(false);
  public final PBBoolField closeTopRightCapsule = PBField.initBool(false);
  public final PBBoolField closeWebviewBounce = PBField.initBool(false);
  public final PBBoolField disableAddToMyApp = PBField.initBool(false);
  public final PBBoolField disableAddToMyFavor = PBField.initBool(false);
  public final PBBoolField disableShareToAIO = PBField.initBool(false);
  public final PBBoolField disableShareToQZone = PBField.initBool(false);
  public final PBBoolField disableShareToWeChat = PBField.initBool(false);
  public final PBBoolField hideAppSearch = PBField.initBool(false);
  public final PBBoolField interLoading = PBField.initBool(false);
  public final PBBoolField interMode = PBField.initBool(false);
  public final PBBoolField isAppStore = PBField.initBool(false);
  public final PBBoolField isLimitedAccess = PBField.initBool(false);
  public final PBBoolField isPayForFriend = PBField.initBool(false);
  public final PBBoolField isWangKa = PBField.initBool(false);
  public final PBBoolField keepOffPullList = PBField.initBool(false);
  public final PBBoolField openNativeApi = PBField.initBool(false);
  public final PBBoolField reloadWithFirstPageChange = PBField.initBool(false);
  public final PBBoolField unlimitedApiRight = PBField.initBool(false);
  public final PBBoolField useAppInfoWhenNavigate = PBField.initBool(false);
  
  static
  {
    Boolean localBoolean = Boolean.valueOf(false);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 64, 72, 80, 88, 96, 104, 112, 120, 128, 136, 144, 152, 160 }, new String[] { "interMode", "authoritySilent", "keepOffPullList", "closeTopRightCapsule", "openNativeApi", "hideAppSearch", "isAppStore", "isWangKa", "interLoading", "closeWebviewBounce", "isLimitedAccess", "isPayForFriend", "useAppInfoWhenNavigate", "disableAddToMyApp", "disableAddToMyFavor", "reloadWithFirstPageChange", "unlimitedApiRight", "disableShareToAIO", "disableShareToQZone", "disableShareToWeChat" }, new Object[] { localBoolean, localBoolean, localBoolean, localBoolean, localBoolean, localBoolean, localBoolean, localBoolean, localBoolean, localBoolean, localBoolean, localBoolean, localBoolean, localBoolean, localBoolean, localBoolean, localBoolean, localBoolean, localBoolean, localBoolean }, StAppMode.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MINI_INTERFACE.INTERFACE.StAppMode
 * JD-Core Version:    0.7.0.1
 */