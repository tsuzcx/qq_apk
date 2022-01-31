package NS_CERTIFIED_ACCOUNT;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class CertifiedAccountMeta$StAutoAioReply
  extends MessageMicro<StAutoAioReply>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34 }, new String[] { "autoState", "replyType", "replyText", "replyImage" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", null }, StAutoAioReply.class);
  public final PBUInt32Field autoState = PBField.initUInt32(0);
  public CertifiedAccountMeta.StImage replyImage = new CertifiedAccountMeta.StImage();
  public final PBStringField replyText = PBField.initString("");
  public final PBUInt32Field replyType = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StAutoAioReply
 * JD-Core Version:    0.7.0.1
 */