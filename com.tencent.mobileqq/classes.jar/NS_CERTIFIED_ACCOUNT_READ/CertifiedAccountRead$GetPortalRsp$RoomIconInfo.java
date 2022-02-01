package NS_CERTIFIED_ACCOUNT_READ;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class CertifiedAccountRead$GetPortalRsp$RoomIconInfo
  extends MessageMicro<RoomIconInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "icon_url", "icon_title", "audience_num" }, new Object[] { "", "", Long.valueOf(0L) }, RoomIconInfo.class);
  public final PBUInt64Field audience_num = PBField.initUInt64(0L);
  public final PBStringField icon_title = PBField.initString("");
  public final PBStringField icon_url = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.GetPortalRsp.RoomIconInfo
 * JD-Core Version:    0.7.0.1
 */