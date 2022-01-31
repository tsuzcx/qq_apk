package NS_CERTIFIED_ACCOUNT_WRITE;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StComment;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class CertifiedAccountWrite$StDoCommentReq
  extends MessageMicro<StDoCommentReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 40 }, new String[] { "extInfo", "commentType", "comment", "feed", "from" }, new Object[] { null, Integer.valueOf(0), null, null, Integer.valueOf(0) }, StDoCommentReq.class);
  public CertifiedAccountMeta.StComment comment = new CertifiedAccountMeta.StComment();
  public final PBUInt32Field commentType = PBField.initUInt32(0);
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  public CertifiedAccountMeta.StFeed feed = new CertifiedAccountMeta.StFeed();
  public final PBInt32Field from = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_CERTIFIED_ACCOUNT_WRITE.CertifiedAccountWrite.StDoCommentReq
 * JD-Core Version:    0.7.0.1
 */