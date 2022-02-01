package NS_MINI_INTERFACE;

import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class INTERFACE$StCreateUpdatableMsgReq
  extends MessageMicro<StCreateUpdatableMsgReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40 }, new String[] { "extInfo", "appid", "shareInfo", "templateId", "from" }, new Object[] { null, "", null, "", Integer.valueOf(0) }, StCreateUpdatableMsgReq.class);
  public final PBStringField appid = PBField.initString("");
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  public final PBUInt32Field from = PBField.initUInt32(0);
  public INTERFACE.StUpdatableMsgShareInfo shareInfo = new INTERFACE.StUpdatableMsgShareInfo();
  public final PBStringField templateId = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MINI_INTERFACE.INTERFACE.StCreateUpdatableMsgReq
 * JD-Core Version:    0.7.0.1
 */