package NS_CERTIFIED_ACCOUNT_READ;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StAutoAioReply;
import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class CertifiedAccountRead$StGetAutoAioReplyRsp
  extends MessageMicro<StGetAutoAioReplyRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "autoAioReply" }, new Object[] { null, null }, StGetAutoAioReplyRsp.class);
  public CertifiedAccountMeta.StAutoAioReply autoAioReply = new CertifiedAccountMeta.StAutoAioReply();
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetAutoAioReplyRsp
 * JD-Core Version:    0.7.0.1
 */