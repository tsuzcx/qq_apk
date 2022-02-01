package NS_CERTIFIED_ACCOUNT_WRITE;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StPushSet;
import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class CertifiedAccountWrite$StPushFeedRsp
  extends MessageMicro<StPushFeedRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "extInfo", "pFeed", "pushFeedResult" }, new Object[] { null, null, Integer.valueOf(0) }, StPushFeedRsp.class);
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  public CertifiedAccountMeta.StPushSet pFeed = new CertifiedAccountMeta.StPushSet();
  public final PBUInt32Field pushFeedResult = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_CERTIFIED_ACCOUNT_WRITE.CertifiedAccountWrite.StPushFeedRsp
 * JD-Core Version:    0.7.0.1
 */