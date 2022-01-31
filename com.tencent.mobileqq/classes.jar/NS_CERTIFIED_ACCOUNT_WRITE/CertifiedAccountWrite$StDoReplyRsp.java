package NS_CERTIFIED_ACCOUNT_WRITE;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StReply;
import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class CertifiedAccountWrite$StDoReplyRsp
  extends MessageMicro<StDoReplyRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "reply" }, new Object[] { null, null }, StDoReplyRsp.class);
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  public CertifiedAccountMeta.StReply reply = new CertifiedAccountMeta.StReply();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_CERTIFIED_ACCOUNT_WRITE.CertifiedAccountWrite.StDoReplyRsp
 * JD-Core Version:    0.7.0.1
 */