package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class INTERFACE$StPublicAccount
  extends MessageMicro<StPublicAccount>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "id", "name", "icon", "desc" }, new Object[] { "", "", "", "" }, StPublicAccount.class);
  public final PBStringField desc = PBField.initString("");
  public final PBStringField icon = PBField.initString("");
  public final PBStringField id = PBField.initString("");
  public final PBStringField name = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MINI_INTERFACE.INTERFACE.StPublicAccount
 * JD-Core Version:    0.7.0.1
 */