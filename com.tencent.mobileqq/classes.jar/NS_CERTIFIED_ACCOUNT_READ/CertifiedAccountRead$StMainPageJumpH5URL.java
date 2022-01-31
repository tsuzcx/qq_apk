package NS_CERTIFIED_ACCOUNT_READ;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class CertifiedAccountRead$StMainPageJumpH5URL
  extends MessageMicro<StMainPageJumpH5URL>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "pushSetURL", "pushListURL", "editPageURL" }, new Object[] { "", "", "" }, StMainPageJumpH5URL.class);
  public final PBStringField editPageURL = PBField.initString("");
  public final PBStringField pushListURL = PBField.initString("");
  public final PBStringField pushSetURL = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StMainPageJumpH5URL
 * JD-Core Version:    0.7.0.1
 */