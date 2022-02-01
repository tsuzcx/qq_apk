package NS_MINI_INTERFACE;

import NS_COMM.COMM.Entry;
import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class INTERFACE$StContentAccelerateReq
  extends MessageMicro<StContentAccelerateReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 42 }, new String[] { "extInfo", "appid", "dataUrl", "needCode", "reqHeaders" }, new Object[] { null, "", "", Integer.valueOf(0), null }, StContentAccelerateReq.class);
  public final PBStringField appid = PBField.initString("");
  public final PBStringField dataUrl = PBField.initString("");
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  public final PBInt32Field needCode = PBField.initInt32(0);
  public final PBRepeatMessageField<COMM.Entry> reqHeaders = PBField.initRepeatMessage(COMM.Entry.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MINI_INTERFACE.INTERFACE.StContentAccelerateReq
 * JD-Core Version:    0.7.0.1
 */