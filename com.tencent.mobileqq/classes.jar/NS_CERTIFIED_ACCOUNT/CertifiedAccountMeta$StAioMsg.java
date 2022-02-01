package NS_CERTIFIED_ACCOUNT;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class CertifiedAccountMeta$StAioMsg
  extends MessageMicro<StAioMsg>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34 }, new String[] { "id", "sendUser", "createTime", "msgContent" }, new Object[] { "", null, Long.valueOf(0L), "" }, StAioMsg.class);
  public final PBUInt64Field createTime = PBField.initUInt64(0L);
  public final PBStringField id = PBField.initString("");
  public final PBStringField msgContent = PBField.initString("");
  public CertifiedAccountMeta.StUser sendUser = new CertifiedAccountMeta.StUser();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StAioMsg
 * JD-Core Version:    0.7.0.1
 */