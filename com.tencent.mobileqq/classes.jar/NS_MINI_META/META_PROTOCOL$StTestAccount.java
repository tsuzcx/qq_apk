package NS_MINI_META;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class META_PROTOCOL$StTestAccount
  extends MessageMicro<StTestAccount>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "uin", "pwd", "comment" }, new Object[] { "", "", "" }, StTestAccount.class);
  public final PBStringField comment = PBField.initString("");
  public final PBStringField pwd = PBField.initString("");
  public final PBStringField uin = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MINI_META.META_PROTOCOL.StTestAccount
 * JD-Core Version:    0.7.0.1
 */