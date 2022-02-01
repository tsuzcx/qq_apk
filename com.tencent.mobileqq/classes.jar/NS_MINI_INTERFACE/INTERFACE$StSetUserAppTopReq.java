package NS_MINI_INTERFACE;

import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class INTERFACE$StSetUserAppTopReq
  extends MessageMicro<StSetUserAppTopReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField appId = PBField.initString("");
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  public final PBInt32Field fromNewDownload = PBField.initInt32(0);
  public final PBInt32Field newIdx = PBField.initInt32(0);
  public final PBInt32Field oldIdx = PBField.initInt32(0);
  public final PBUInt32Field putTop = PBField.initUInt32(0);
  public final PBEnumField verType = PBField.initEnum(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 48, 56 }, new String[] { "extInfo", "appId", "putTop", "verType", "oldIdx", "newIdx", "fromNewDownload" }, new Object[] { null, "", localInteger, localInteger, localInteger, localInteger, localInteger }, StSetUserAppTopReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MINI_INTERFACE.INTERFACE.StSetUserAppTopReq
 * JD-Core Version:    0.7.0.1
 */