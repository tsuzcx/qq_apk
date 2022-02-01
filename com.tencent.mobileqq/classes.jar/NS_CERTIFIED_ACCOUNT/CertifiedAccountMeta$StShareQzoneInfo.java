package NS_CERTIFIED_ACCOUNT;

import NS_COMM.COMM.Entry;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class CertifiedAccountMeta$StShareQzoneInfo
  extends MessageMicro<StShareQzoneInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "entrys" }, new Object[] { null }, StShareQzoneInfo.class);
  public final PBRepeatMessageField<COMM.Entry> entrys = PBField.initRepeatMessage(COMM.Entry.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StShareQzoneInfo
 * JD-Core Version:    0.7.0.1
 */