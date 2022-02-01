package NS_MINI_META;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class META_PROTOCOL$StLoginTicket
  extends MessageMicro<StLoginTicket>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field createTimestamp = PBField.initUInt32(0);
  public final PBStringField key = PBField.initString("");
  public final PBUInt32Field renewTimestamp = PBField.initUInt32(0);
  public final PBInt32Field reqFrm = PBField.initInt32(0);
  public final PBStringField uin = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40 }, new String[] { "reqFrm", "uin", "key", "createTimestamp", "renewTimestamp" }, new Object[] { localInteger, "", "", localInteger, localInteger }, StLoginTicket.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MINI_META.META_PROTOCOL.StLoginTicket
 * JD-Core Version:    0.7.0.1
 */