package NS_MINI_INTERFACE;

import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class INTERFACE$StGetTCBTicketRsp
  extends MessageMicro<StGetTCBTicketRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field createTime = PBField.initUInt32(0);
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  public final PBUInt32Field period = PBField.initUInt32(0);
  public final PBStringField ticket = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32 }, new String[] { "extInfo", "ticket", "createTime", "period" }, new Object[] { null, "", localInteger, localInteger }, StGetTCBTicketRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MINI_INTERFACE.INTERFACE.StGetTCBTicketRsp
 * JD-Core Version:    0.7.0.1
 */