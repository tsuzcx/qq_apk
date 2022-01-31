package NS_CERTIFIED_ACCOUNT_WRITE;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StLike;
import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class CertifiedAccountWrite$StDoLikeRsp
  extends MessageMicro<StDoLikeRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "like" }, new Object[] { null, null }, StDoLikeRsp.class);
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  public CertifiedAccountMeta.StLike like = new CertifiedAccountMeta.StLike();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_CERTIFIED_ACCOUNT_WRITE.CertifiedAccountWrite.StDoLikeRsp
 * JD-Core Version:    0.7.0.1
 */