package NS_CERTIFIED_ACCOUNT_READ;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StMessageStatus;
import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class CertifiedAccountRead$StGetFollowFeedsRsp
  extends MessageMicro<StGetFollowFeedsRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatMessageField<CertifiedAccountMeta.StFeed> careLive = PBField.initRepeatMessage(CertifiedAccountMeta.StFeed.class);
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  public final PBRepeatMessageField<CertifiedAccountMeta.StFeed> feeds = PBField.initRepeatMessage(CertifiedAccountMeta.StFeed.class);
  public final PBUInt32Field isFinish = PBField.initUInt32(0);
  public final PBStringField livePageInfo = PBField.initString("");
  public CertifiedAccountMeta.StMessageStatus messStatus = new CertifiedAccountMeta.StMessageStatus();
  public final PBUInt32Field noticeCount = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 42, 50, 66 }, new String[] { "extInfo", "feeds", "isFinish", "noticeCount", "messStatus", "careLive", "livePageInfo" }, new Object[] { null, null, localInteger, localInteger, null, null, "" }, StGetFollowFeedsRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetFollowFeedsRsp
 * JD-Core Version:    0.7.0.1
 */