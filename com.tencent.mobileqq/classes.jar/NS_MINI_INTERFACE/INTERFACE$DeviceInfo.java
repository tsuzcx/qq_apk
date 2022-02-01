package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class INTERFACE$DeviceInfo
  extends MessageMicro<DeviceInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField aid_ticket = PBField.initString("");
  public final PBStringField android_id = PBField.initString("");
  public final PBStringField android_imei = PBField.initString("");
  public final PBUInt32Field app_version_id = PBField.initUInt32(0);
  public final PBUInt32Field carrier_code = PBField.initUInt32(0);
  public final PBStringField client_ip = PBField.initString("");
  public final PBStringField client_ipv4 = PBField.initString("");
  public final PBUInt32Field conn = PBField.initUInt32(0);
  public final PBStringField device_brand_and_model = PBField.initString("");
  public final PBUInt32Field device_orientation = PBField.initUInt32(0);
  public final PBStringField ios_idfa = PBField.initString("");
  public final PBStringField ios_qidfa = PBField.initString("");
  public final PBBoolField is_googleplay_version = PBField.initBool(false);
  public final PBBoolField is_ios_review_state = PBField.initBool(false);
  public final PBBoolField is_wk_webview = PBField.initBool(false);
  public INTERFACE.Location location = new INTERFACE.Location();
  public final PBStringField mac = PBField.initString("");
  public final PBStringField manufacturer = PBField.initString("");
  public final PBStringField md5_android_id = PBField.initString("");
  public final PBStringField md5_mac = PBField.initString("");
  public final PBStringField muid = PBField.initString("");
  public final PBUInt32Field muid_type = PBField.initUInt32(0);
  public final PBStringField oaid = PBField.initString("");
  public final PBUInt32Field os_type = PBField.initUInt32(0);
  public final PBStringField os_ver = PBField.initString("");
  public final PBStringField qadid = PBField.initString("");
  public final PBStringField qq_ver = PBField.initString("");
  public final PBStringField taid_ticket = PBField.initString("");
  
  static
  {
    Boolean localBoolean = Boolean.valueOf(false);
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 42, 50, 56, 66, 74, 82, 88, 98, 106, 114, 120, 128, 138, 146, 154, 162, 168, 176, 186, 194, 202, 210, 218, 226 }, new String[] { "muid", "muid_type", "conn", "carrier_code", "os_ver", "qq_ver", "os_type", "client_ip", "ios_qidfa", "location", "is_wk_webview", "manufacturer", "device_brand_and_model", "qadid", "app_version_id", "device_orientation", "android_imei", "ios_idfa", "android_id", "mac", "is_googleplay_version", "is_ios_review_state", "oaid", "taid_ticket", "md5_mac", "md5_android_id", "client_ipv4", "aid_ticket" }, new Object[] { "", localInteger, localInteger, localInteger, "", "", localInteger, "", "", null, localBoolean, "", "", "", localInteger, localInteger, "", "", "", "", localBoolean, localBoolean, "", "", "", "", "", "" }, DeviceInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MINI_INTERFACE.INTERFACE.DeviceInfo
 * JD-Core Version:    0.7.0.1
 */