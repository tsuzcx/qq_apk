package NS_MINI_USERAUTH;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class MiniUserAuth$StApiScopeEntry
  extends MessageMicro<StApiScopeEntry>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "api", "scope" }, new Object[] { null, "" }, StApiScopeEntry.class);
  public MiniUserAuth.StApiNameItem api = new MiniUserAuth.StApiNameItem();
  public final PBStringField scope = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MINI_USERAUTH.MiniUserAuth.StApiScopeEntry
 * JD-Core Version:    0.7.0.1
 */