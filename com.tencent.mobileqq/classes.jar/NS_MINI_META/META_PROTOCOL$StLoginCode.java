package NS_MINI_META;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class META_PROTOCOL$StLoginCode
  extends MessageMicro<StLoginCode>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field createTimestamp = PBField.initUInt32(0);
  public final PBInt32Field reqFrm = PBField.initInt32(0);
  public final PBInt32Field used = PBField.initInt32(0);
  public final PBStringField userIp = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32 }, new String[] { "reqFrm", "userIp", "createTimestamp", "used" }, new Object[] { localInteger, "", localInteger, localInteger }, StLoginCode.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MINI_META.META_PROTOCOL.StLoginCode
 * JD-Core Version:    0.7.0.1
 */