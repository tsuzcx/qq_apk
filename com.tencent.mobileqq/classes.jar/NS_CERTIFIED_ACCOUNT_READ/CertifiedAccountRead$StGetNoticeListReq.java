package NS_CERTIFIED_ACCOUNT_READ;

import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class CertifiedAccountRead$StGetNoticeListReq
  extends MessageMicro<StGetNoticeListReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "extInfo", "listNum" }, new Object[] { null, Integer.valueOf(0) }, StGetNoticeListReq.class);
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  public final PBUInt32Field listNum = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetNoticeListReq
 * JD-Core Version:    0.7.0.1
 */