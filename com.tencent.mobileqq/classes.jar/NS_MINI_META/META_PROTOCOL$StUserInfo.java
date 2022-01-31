package NS_MINI_META;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class META_PROTOCOL$StUserInfo
  extends MessageMicro<StUserInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 42 }, new String[] { "nick", "avatar", "gender", "address", "language" }, new Object[] { "", "", Integer.valueOf(0), null, "" }, StUserInfo.class);
  public META_PROTOCOL.StAddressInfo address = new META_PROTOCOL.StAddressInfo();
  public final PBStringField avatar = PBField.initString("");
  public final PBInt32Field gender = PBField.initInt32(0);
  public final PBStringField language = PBField.initString("");
  public final PBStringField nick = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MINI_META.META_PROTOCOL.StUserInfo
 * JD-Core Version:    0.7.0.1
 */