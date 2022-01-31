package NS_MINI_APP_MISC;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class MISC$StTrans4RoomidReq
  extends MessageMicro<StTrans4RoomidReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "appid", "groupid" }, new Object[] { "", "" }, StTrans4RoomidReq.class);
  public final PBStringField appid = PBField.initString("");
  public final PBStringField groupid = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MINI_APP_MISC.MISC.StTrans4RoomidReq
 * JD-Core Version:    0.7.0.1
 */