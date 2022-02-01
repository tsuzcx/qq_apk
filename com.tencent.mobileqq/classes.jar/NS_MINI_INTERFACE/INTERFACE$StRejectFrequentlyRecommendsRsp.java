package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class INTERFACE$StRejectFrequentlyRecommendsRsp
  extends MessageMicro<StRejectFrequentlyRecommendsRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "state", "msg" }, new Object[] { Integer.valueOf(0), "" }, StRejectFrequentlyRecommendsRsp.class);
  public final PBStringField msg = PBField.initString("");
  public final PBUInt32Field state = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MINI_INTERFACE.INTERFACE.StRejectFrequentlyRecommendsRsp
 * JD-Core Version:    0.7.0.1
 */