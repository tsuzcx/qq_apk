package NS_MINI_APP_MISC;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class MISC$StTrans4RoomidRsp
  extends MessageMicro<StTrans4RoomidRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "roomid", "openid", "tinyid" }, new Object[] { Integer.valueOf(0), "", Long.valueOf(0L) }, StTrans4RoomidRsp.class);
  public final PBStringField openid = PBField.initString("");
  public final PBUInt32Field roomid = PBField.initUInt32(0);
  public final PBUInt64Field tinyid = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MINI_APP_MISC.MISC.StTrans4RoomidRsp
 * JD-Core Version:    0.7.0.1
 */