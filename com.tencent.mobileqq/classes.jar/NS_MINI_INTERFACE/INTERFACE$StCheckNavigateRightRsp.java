package NS_MINI_INTERFACE;

import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class INTERFACE$StCheckNavigateRightRsp
  extends MessageMicro<StCheckNavigateRightRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field actionCode = PBField.initInt32(0);
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  public final PBInt32Field skipLocalCheck = PBField.initInt32(0);
  public final PBStringField wording = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34 }, new String[] { "extInfo", "actionCode", "skipLocalCheck", "wording" }, new Object[] { null, localInteger, localInteger, "" }, StCheckNavigateRightRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MINI_INTERFACE.INTERFACE.StCheckNavigateRightRsp
 * JD-Core Version:    0.7.0.1
 */