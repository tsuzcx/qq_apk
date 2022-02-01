package NS_MINI_INTERFACE;

import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class INTERFACE$StReportShareReq
  extends MessageMicro<StReportShareReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field appType = PBField.initInt32(0);
  public final PBStringField appid = PBField.initString("");
  public final PBStringField destId = PBField.initString("");
  public final PBUInt32Field destType = PBField.initUInt32(0);
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  public final PBInt64Field reportTime = PBField.initInt64(0L);
  public final PBUInt32Field shareScene = PBField.initUInt32(0);
  public final PBUInt32Field shareType = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32, 40, 48, 56, 66 }, new String[] { "extInfo", "reportTime", "appid", "appType", "shareScene", "shareType", "destType", "destId" }, new Object[] { null, Long.valueOf(0L), "", localInteger, localInteger, localInteger, localInteger, "" }, StReportShareReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MINI_INTERFACE.INTERFACE.StReportShareReq
 * JD-Core Version:    0.7.0.1
 */