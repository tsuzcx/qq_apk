package NS_MINI_USERAUTH;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class MiniUserAuth$StApiScopeConfig
  extends MessageMicro<StApiScopeConfig>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "scopeList", "apiToScope" }, new Object[] { null, null }, StApiScopeConfig.class);
  public final PBRepeatMessageField<MiniUserAuth.StApiScopeEntry> apiToScope = PBField.initRepeatMessage(MiniUserAuth.StApiScopeEntry.class);
  public final PBRepeatMessageField<MiniUserAuth.StUserAuthScope> scopeList = PBField.initRepeatMessage(MiniUserAuth.StUserAuthScope.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MINI_USERAUTH.MiniUserAuth.StApiScopeConfig
 * JD-Core Version:    0.7.0.1
 */