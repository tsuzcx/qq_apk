package NS_STORE_APP_CLIENT;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class STORE_APP_CLIENT$StUserInfo
  extends MessageMicro<StUserInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "uin", "avatar", "nick" }, new Object[] { "", "", "" }, StUserInfo.class);
  public final PBStringField avatar = PBField.initString("");
  public final PBStringField nick = PBField.initString("");
  public final PBStringField uin = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_STORE_APP_CLIENT.STORE_APP_CLIENT.StUserInfo
 * JD-Core Version:    0.7.0.1
 */