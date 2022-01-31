package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class INTERFACE$StApiUserInfo
  extends MessageMicro<StApiUserInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 42, 50 }, new String[] { "nick", "avatar", "gender", "address", "language", "openid" }, new Object[] { "", "", Integer.valueOf(0), null, "", "" }, StApiUserInfo.class);
  public INTERFACE.StAddressInfo address = new INTERFACE.StAddressInfo();
  public final PBStringField avatar = PBField.initString("");
  public final PBInt32Field gender = PBField.initInt32(0);
  public final PBStringField language = PBField.initString("");
  public final PBStringField nick = PBField.initString("");
  public final PBStringField openid = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MINI_INTERFACE.INTERFACE.StApiUserInfo
 * JD-Core Version:    0.7.0.1
 */