package NS_CERTIFIED_ACCOUNT_READ;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StShare;
import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class CertifiedAccountRead$StGetFeedDetailRsp
  extends MessageMicro<StGetFeedDetailRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 48, 58 }, new String[] { "extInfo", "detailUrl", "feed", "vecRcmdFeed", "share", "isFinish", "adAttchInfo" }, new Object[] { null, "", null, null, null, Integer.valueOf(0), "" }, StGetFeedDetailRsp.class);
  public final PBStringField adAttchInfo = PBField.initString("");
  public final PBStringField detailUrl = PBField.initString("");
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  public CertifiedAccountMeta.StFeed feed = new CertifiedAccountMeta.StFeed();
  public final PBUInt32Field isFinish = PBField.initUInt32(0);
  public CertifiedAccountMeta.StShare share = new CertifiedAccountMeta.StShare();
  public final PBRepeatMessageField<CertifiedAccountMeta.StFeed> vecRcmdFeed = PBField.initRepeatMessage(CertifiedAccountMeta.StFeed.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetFeedDetailRsp
 * JD-Core Version:    0.7.0.1
 */