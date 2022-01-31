package NS_MINI_META;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class META_PROTOCOL$StSessionKeyInfo
  extends MessageMicro<StSessionKeyInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 40 }, new String[] { "uin", "openid", "sessionKey", "createTimestamp", "renewTimestamp" }, new Object[] { "", "", "", Integer.valueOf(0), Integer.valueOf(0) }, StSessionKeyInfo.class);
  public final PBUInt32Field createTimestamp = PBField.initUInt32(0);
  public final PBStringField openid = PBField.initString("");
  public final PBUInt32Field renewTimestamp = PBField.initUInt32(0);
  public final PBStringField sessionKey = PBField.initString("");
  public final PBStringField uin = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MINI_META.META_PROTOCOL.StSessionKeyInfo
 * JD-Core Version:    0.7.0.1
 */