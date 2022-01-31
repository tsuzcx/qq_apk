package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;

public final class INTERFACE$StAppMode
  extends MessageMicro<StAppMode>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 64, 72, 80, 88 }, new String[] { "interMode", "authoritySilent", "keepOffPullList", "closeTopRightCapsule", "openNativeApi", "hideAppSearch", "isAppStore", "isWangKa", "interLoading", "closeWebviewBounce", "isLimitedAccess" }, new Object[] { Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(false) }, StAppMode.class);
  public final PBBoolField authoritySilent = PBField.initBool(false);
  public final PBBoolField closeTopRightCapsule = PBField.initBool(false);
  public final PBBoolField closeWebviewBounce = PBField.initBool(false);
  public final PBBoolField hideAppSearch = PBField.initBool(false);
  public final PBBoolField interLoading = PBField.initBool(false);
  public final PBBoolField interMode = PBField.initBool(false);
  public final PBBoolField isAppStore = PBField.initBool(false);
  public final PBBoolField isLimitedAccess = PBField.initBool(false);
  public final PBBoolField isWangKa = PBField.initBool(false);
  public final PBBoolField keepOffPullList = PBField.initBool(false);
  public final PBBoolField openNativeApi = PBField.initBool(false);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MINI_INTERFACE.INTERFACE.StAppMode
 * JD-Core Version:    0.7.0.1
 */