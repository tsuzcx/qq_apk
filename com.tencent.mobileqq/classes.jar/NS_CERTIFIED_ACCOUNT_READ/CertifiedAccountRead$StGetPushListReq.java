package NS_CERTIFIED_ACCOUNT_READ;

import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class CertifiedAccountRead$StGetPushListReq
  extends MessageMicro<StGetPushListReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32 }, new String[] { "extInfo", "userId", "listNum", "from" }, new Object[] { null, "", Integer.valueOf(0), Integer.valueOf(0) }, StGetPushListReq.class);
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  public final PBInt32Field from = PBField.initInt32(0);
  public final PBUInt32Field listNum = PBField.initUInt32(0);
  public final PBStringField userId = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetPushListReq
 * JD-Core Version:    0.7.0.1
 */