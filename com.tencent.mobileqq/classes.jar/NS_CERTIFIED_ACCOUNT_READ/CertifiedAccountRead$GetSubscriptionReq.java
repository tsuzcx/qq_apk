package NS_CERTIFIED_ACCOUNT_READ;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class CertifiedAccountRead$GetSubscriptionReq
  extends MessageMicro<GetSubscriptionReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uin", "page_id", "page_info" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), "" }, GetSubscriptionReq.class);
  public final PBInt32Field page_id = PBField.initInt32(0);
  public final PBStringField page_info = PBField.initString("");
  public final PBUInt64Field uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.GetSubscriptionReq
 * JD-Core Version:    0.7.0.1
 */