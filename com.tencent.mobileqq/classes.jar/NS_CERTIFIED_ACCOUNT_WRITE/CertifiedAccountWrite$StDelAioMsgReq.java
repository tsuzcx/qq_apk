package NS_CERTIFIED_ACCOUNT_WRITE;

import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

public final class CertifiedAccountWrite$StDelAioMsgReq
  extends MessageMicro<StDelAioMsgReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "vecMsgId" }, new Object[] { null, "" }, StDelAioMsgReq.class);
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  public final PBRepeatField<String> vecMsgId = PBField.initRepeat(PBStringField.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_CERTIFIED_ACCOUNT_WRITE.CertifiedAccountWrite.StDelAioMsgReq
 * JD-Core Version:    0.7.0.1
 */