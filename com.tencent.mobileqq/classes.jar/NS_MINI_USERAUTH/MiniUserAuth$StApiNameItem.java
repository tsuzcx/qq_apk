package NS_MINI_USERAUTH;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class MiniUserAuth$StApiNameItem
  extends MessageMicro<StApiNameItem>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "eventName", "apiName" }, new Object[] { "", "" }, StApiNameItem.class);
  public final PBStringField apiName = PBField.initString("");
  public final PBStringField eventName = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MINI_USERAUTH.MiniUserAuth.StApiNameItem
 * JD-Core Version:    0.7.0.1
 */