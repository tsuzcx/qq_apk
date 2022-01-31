package NS_CERTIFIED_ACCOUNT_READ;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StNotice;
import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class CertifiedAccountRead$StGetNoticeListRsp
  extends MessageMicro<StGetNoticeListRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32 }, new String[] { "extInfo", "vecNotice", "totalNum", "isFinish" }, new Object[] { null, null, Integer.valueOf(0), Integer.valueOf(0) }, StGetNoticeListRsp.class);
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  public final PBUInt32Field isFinish = PBField.initUInt32(0);
  public final PBUInt32Field totalNum = PBField.initUInt32(0);
  public final PBRepeatMessageField<CertifiedAccountMeta.StNotice> vecNotice = PBField.initRepeatMessage(CertifiedAccountMeta.StNotice.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetNoticeListRsp
 * JD-Core Version:    0.7.0.1
 */