package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class INTERFACE$StTinyidOpenidPair
  extends MessageMicro<StTinyidOpenidPair>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "tinyid", "openid" }, new Object[] { Long.valueOf(0L), "" }, StTinyidOpenidPair.class);
  public final PBStringField openid = PBField.initString("");
  public final PBUInt64Field tinyid = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MINI_INTERFACE.INTERFACE.StTinyidOpenidPair
 * JD-Core Version:    0.7.0.1
 */