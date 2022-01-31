package NS_CERTIFIED_ACCOUNT_READ;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class CertifiedAccountRead$StGetFollowFeedsRsp
  extends MessageMicro<StGetFollowFeedsRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32 }, new String[] { "extInfo", "feeds", "isFinish", "noticeCount" }, new Object[] { null, null, Integer.valueOf(0), Integer.valueOf(0) }, StGetFollowFeedsRsp.class);
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  public final PBRepeatMessageField<CertifiedAccountMeta.StFeed> feeds = PBField.initRepeatMessage(CertifiedAccountMeta.StFeed.class);
  public final PBUInt32Field isFinish = PBField.initUInt32(0);
  public final PBUInt32Field noticeCount = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetFollowFeedsRsp
 * JD-Core Version:    0.7.0.1
 */