package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class INTERFACE$UseUserInfo
  extends MessageMicro<UseUserInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "uin", "avatar", "nick" }, new Object[] { "", "", "" }, UseUserInfo.class);
  public final PBStringField avatar = PBField.initString("");
  public final PBStringField nick = PBField.initString("");
  public final PBStringField uin = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MINI_INTERFACE.INTERFACE.UseUserInfo
 * JD-Core Version:    0.7.0.1
 */