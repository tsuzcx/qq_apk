package NS_CERTIFIED_ACCOUNT_READ;

import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class CertifiedAccountRead$StGetFollowFeedsReq
  extends MessageMicro<StGetFollowFeedsReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "livePageInfo" }, new Object[] { null, "" }, StGetFollowFeedsReq.class);
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  public final PBStringField livePageInfo = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetFollowFeedsReq
 * JD-Core Version:    0.7.0.1
 */