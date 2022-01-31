package NS_MINI_META;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class META_PROTOCOL$StCodeInfo
  extends MessageMicro<StCodeInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40, 48 }, new String[] { "uin", "A2Key", "appid", "openid", "createTimestamp", "used" }, new Object[] { "", "", "", "", Integer.valueOf(0), Integer.valueOf(0) }, StCodeInfo.class);
  public final PBStringField A2Key = PBField.initString("");
  public final PBStringField appid = PBField.initString("");
  public final PBUInt32Field createTimestamp = PBField.initUInt32(0);
  public final PBStringField openid = PBField.initString("");
  public final PBStringField uin = PBField.initString("");
  public final PBInt32Field used = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MINI_META.META_PROTOCOL.StCodeInfo
 * JD-Core Version:    0.7.0.1
 */