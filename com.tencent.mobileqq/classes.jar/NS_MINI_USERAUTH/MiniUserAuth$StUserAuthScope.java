package NS_MINI_USERAUTH;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class MiniUserAuth$StUserAuthScope
  extends MessageMicro<StUserAuthScope>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34 }, new String[] { "scope", "authType", "desc", "settingPageTitle" }, new Object[] { "", Integer.valueOf(0), "", "" }, StUserAuthScope.class);
  public final PBInt32Field authType = PBField.initInt32(0);
  public final PBStringField desc = PBField.initString("");
  public final PBStringField scope = PBField.initString("");
  public final PBStringField settingPageTitle = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MINI_USERAUTH.MiniUserAuth.StUserAuthScope
 * JD-Core Version:    0.7.0.1
 */