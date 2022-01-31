package NS_CERTIFIED_ACCOUNT_WRITE;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StComment;
import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class CertifiedAccountWrite$StDoCommentRsp
  extends MessageMicro<StDoCommentRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "comment" }, new Object[] { null, null }, StDoCommentRsp.class);
  public CertifiedAccountMeta.StComment comment = new CertifiedAccountMeta.StComment();
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_CERTIFIED_ACCOUNT_WRITE.CertifiedAccountWrite.StDoCommentRsp
 * JD-Core Version:    0.7.0.1
 */