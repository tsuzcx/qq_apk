package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class INTERFACE$StGetProfileReq
  extends MessageMicro<StGetProfileReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "appid", "withCredentials", "lang" }, new Object[] { "", Integer.valueOf(0), "" }, StGetProfileReq.class);
  public final PBStringField appid = PBField.initString("");
  public final PBStringField lang = PBField.initString("");
  public final PBInt32Field withCredentials = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MINI_INTERFACE.INTERFACE.StGetProfileReq
 * JD-Core Version:    0.7.0.1
 */