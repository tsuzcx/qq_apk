package NS_CERTIFIED_ACCOUNT;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class FeedbackReport$UserInfo
  extends MessageMicro<UserInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50 }, new String[] { "uid", "qq", "openid", "imei", "idfa", "idfv" }, new Object[] { "", "", "", "", "", "" }, UserInfo.class);
  public final PBStringField idfa = PBField.initString("");
  public final PBStringField idfv = PBField.initString("");
  public final PBStringField imei = PBField.initString("");
  public final PBStringField openid = PBField.initString("");
  public final PBStringField qq = PBField.initString("");
  public final PBStringField uid = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_CERTIFIED_ACCOUNT.FeedbackReport.UserInfo
 * JD-Core Version:    0.7.0.1
 */