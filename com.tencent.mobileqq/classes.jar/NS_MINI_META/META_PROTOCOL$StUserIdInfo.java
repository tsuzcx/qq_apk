package NS_MINI_META;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class META_PROTOCOL$StUserIdInfo
  extends MessageMicro<StUserIdInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "uin", "appid", "openid" }, new Object[] { "", "", "" }, StUserIdInfo.class);
  public final PBStringField appid = PBField.initString("");
  public final PBStringField openid = PBField.initString("");
  public final PBStringField uin = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MINI_META.META_PROTOCOL.StUserIdInfo
 * JD-Core Version:    0.7.0.1
 */