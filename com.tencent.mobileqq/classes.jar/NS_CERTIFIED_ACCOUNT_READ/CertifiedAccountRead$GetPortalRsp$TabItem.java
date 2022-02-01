package NS_CERTIFIED_ACCOUNT_READ;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class CertifiedAccountRead$GetPortalRsp$TabItem
  extends MessageMicro<TabItem>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "id", "name" }, new Object[] { Integer.valueOf(0), "" }, TabItem.class);
  public final PBInt32Field id = PBField.initInt32(0);
  public final PBStringField name = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.GetPortalRsp.TabItem
 * JD-Core Version:    0.7.0.1
 */