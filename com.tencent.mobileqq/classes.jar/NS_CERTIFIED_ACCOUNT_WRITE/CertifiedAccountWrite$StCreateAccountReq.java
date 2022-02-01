package NS_CERTIFIED_ACCOUNT_WRITE;

import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class CertifiedAccountWrite$StCreateAccountReq
  extends MessageMicro<StCreateAccountReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42 }, new String[] { "extInfo", "name", "desc", "logo", "adminqq" }, new Object[] { null, "", "", "", "" }, StCreateAccountReq.class);
  public final PBStringField adminqq = PBField.initString("");
  public final PBStringField desc = PBField.initString("");
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  public final PBStringField logo = PBField.initString("");
  public final PBStringField name = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_CERTIFIED_ACCOUNT_WRITE.CertifiedAccountWrite.StCreateAccountReq
 * JD-Core Version:    0.7.0.1
 */