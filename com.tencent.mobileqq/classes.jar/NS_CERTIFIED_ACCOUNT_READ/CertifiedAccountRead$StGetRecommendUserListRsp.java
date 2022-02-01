package NS_CERTIFIED_ACCOUNT_READ;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StEntry;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class CertifiedAccountRead$StGetRecommendUserListRsp
  extends MessageMicro<StGetRecommendUserListRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public CertifiedAccountMeta.StEntry entry = new CertifiedAccountMeta.StEntry();
  public final PBUInt32Field expType = PBField.initUInt32(0);
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  public final PBUInt32Field isFinish = PBField.initUInt32(0);
  public final PBUInt32Field noticeCount = PBField.initUInt32(0);
  public final PBUInt32Field totalNum = PBField.initUInt32(0);
  public final PBRepeatMessageField<CertifiedAccountMeta.StUser> vecUser = PBField.initRepeatMessage(CertifiedAccountMeta.StUser.class);
  public final PBRepeatMessageField<CertifiedAccountMeta.StFeed> vecUserWithFeed = PBField.initRepeatMessage(CertifiedAccountMeta.StFeed.class);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 42, 48, 56, 66 }, new String[] { "extInfo", "vecUser", "totalNum", "isFinish", "entry", "noticeCount", "expType", "vecUserWithFeed" }, new Object[] { null, null, localInteger, localInteger, null, localInteger, localInteger, null }, StGetRecommendUserListRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetRecommendUserListRsp
 * JD-Core Version:    0.7.0.1
 */