package NS_CERTIFIED_ACCOUNT_READ;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StMessageStatus;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StPushSet;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StQQGroup;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StShare;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class CertifiedAccountRead$StGetMainPageRsp
  extends MessageMicro<StGetMainPageRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 50, 56, 66, 74, 80, 88, 98, 106, 114 }, new String[] { "extInfo", "user", "feedCount", "fansCount", "followCount", "vecFeed", "isFinish", "share", "vecGroup", "ytdFansCount", "viewTotalCount", "pushFeed", "messStatus", "jumpURLs" }, new Object[] { null, null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), null, null, Long.valueOf(0L), Long.valueOf(0L), null, null, null }, StGetMainPageRsp.class);
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  public final PBUInt32Field fansCount = PBField.initUInt32(0);
  public final PBUInt32Field feedCount = PBField.initUInt32(0);
  public final PBUInt32Field followCount = PBField.initUInt32(0);
  public final PBUInt32Field isFinish = PBField.initUInt32(0);
  public CertifiedAccountRead.StMainPageJumpH5URL jumpURLs = new CertifiedAccountRead.StMainPageJumpH5URL();
  public CertifiedAccountMeta.StMessageStatus messStatus = new CertifiedAccountMeta.StMessageStatus();
  public CertifiedAccountMeta.StPushSet pushFeed = new CertifiedAccountMeta.StPushSet();
  public CertifiedAccountMeta.StShare share = new CertifiedAccountMeta.StShare();
  public CertifiedAccountMeta.StUser user = new CertifiedAccountMeta.StUser();
  public final PBRepeatMessageField<CertifiedAccountMeta.StFeed> vecFeed = PBField.initRepeatMessage(CertifiedAccountMeta.StFeed.class);
  public final PBRepeatMessageField<CertifiedAccountMeta.StQQGroup> vecGroup = PBField.initRepeatMessage(CertifiedAccountMeta.StQQGroup.class);
  public final PBUInt64Field viewTotalCount = PBField.initUInt64(0L);
  public final PBUInt64Field ytdFansCount = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetMainPageRsp
 * JD-Core Version:    0.7.0.1
 */