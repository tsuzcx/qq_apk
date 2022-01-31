package NS_CERTIFIED_ACCOUNT_WRITE;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StAutoAioReply;
import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class CertifiedAccountWrite$StModAutoAioReplyReq
  extends MessageMicro<StModAutoAioReplyReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34 }, new String[] { "extInfo", "sceneType", "modType", "autoAioReply" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(0), null }, StModAutoAioReplyReq.class);
  public CertifiedAccountMeta.StAutoAioReply autoAioReply = new CertifiedAccountMeta.StAutoAioReply();
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  public final PBUInt32Field modType = PBField.initUInt32(0);
  public final PBUInt32Field sceneType = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_CERTIFIED_ACCOUNT_WRITE.CertifiedAccountWrite.StModAutoAioReplyReq
 * JD-Core Version:    0.7.0.1
 */