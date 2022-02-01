package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class INTERFACE$StUserInfoExtra
  extends MessageMicro<StUserInfoExtra>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBoolField is_qq_svip = PBField.initBool(false);
  public final PBBoolField is_qq_vip = PBField.initBool(false);
  public final PBBoolField is_year_vip = PBField.initBool(false);
  public final PBBoolField is_yellow_svip = PBField.initBool(false);
  public final PBBoolField is_yellow_vip = PBField.initBool(false);
  public final PBBoolField is_yellow_year_vip = PBField.initBool(false);
  public final PBInt32Field level_of_qq_vip = PBField.initInt32(0);
  public final PBInt32Field level_of_yellow_vip = PBField.initInt32(0);
  public final PBStringField openid = PBField.initString("");
  public final PBStringField uin = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Boolean localBoolean = Boolean.valueOf(false);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 48, 56, 64, 72, 80 }, new String[] { "uin", "openid", "is_qq_vip", "is_qq_svip", "is_year_vip", "is_yellow_vip", "is_yellow_svip", "is_yellow_year_vip", "level_of_qq_vip", "level_of_yellow_vip" }, new Object[] { "", "", localBoolean, localBoolean, localBoolean, localBoolean, localBoolean, localBoolean, localInteger, localInteger }, StUserInfoExtra.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MINI_INTERFACE.INTERFACE.StUserInfoExtra
 * JD-Core Version:    0.7.0.1
 */