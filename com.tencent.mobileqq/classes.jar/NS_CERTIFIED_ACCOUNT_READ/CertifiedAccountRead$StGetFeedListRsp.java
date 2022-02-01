package NS_CERTIFIED_ACCOUNT_READ;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class CertifiedAccountRead$StGetFeedListRsp
  extends MessageMicro<StGetFeedListRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 42, 50, 58 }, new String[] { "extInfo", "vecFeed", "isFinish", "user", "adAttchInfo", "hotLive", "livePageInfo" }, new Object[] { null, null, Integer.valueOf(0), null, "", null, "" }, StGetFeedListRsp.class);
  public final PBStringField adAttchInfo = PBField.initString("");
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  public final PBRepeatMessageField<CertifiedAccountMeta.StFeed> hotLive = PBField.initRepeatMessage(CertifiedAccountMeta.StFeed.class);
  public final PBUInt32Field isFinish = PBField.initUInt32(0);
  public final PBStringField livePageInfo = PBField.initString("");
  public CertifiedAccountMeta.StUser user = new CertifiedAccountMeta.StUser();
  public final PBRepeatMessageField<CertifiedAccountMeta.StFeed> vecFeed = PBField.initRepeatMessage(CertifiedAccountMeta.StFeed.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetFeedListRsp
 * JD-Core Version:    0.7.0.1
 */