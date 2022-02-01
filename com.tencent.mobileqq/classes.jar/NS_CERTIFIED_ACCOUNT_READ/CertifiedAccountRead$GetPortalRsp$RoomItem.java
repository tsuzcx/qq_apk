package NS_CERTIFIED_ACCOUNT_READ;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class CertifiedAccountRead$GetPortalRsp$RoomItem
  extends MessageMicro<RoomItem>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 42, 50, 58, 66, 74, 82, 90 }, new String[] { "room_id", "pgc_openid", "pgc_uid", "nick", "title", "portrait", "pic_url", "program_id", "report_trace_info", "good_info", "icon_info" }, new Object[] { "", "", Long.valueOf(0L), "", "", "", "", "", "", null, null }, RoomItem.class);
  public CertifiedAccountRead.GetPortalRsp.RoomGoodInfo good_info = new CertifiedAccountRead.GetPortalRsp.RoomGoodInfo();
  public CertifiedAccountRead.GetPortalRsp.RoomIconInfo icon_info = new CertifiedAccountRead.GetPortalRsp.RoomIconInfo();
  public final PBStringField nick = PBField.initString("");
  public final PBStringField pgc_openid = PBField.initString("");
  public final PBUInt64Field pgc_uid = PBField.initUInt64(0L);
  public final PBStringField pic_url = PBField.initString("");
  public final PBStringField portrait = PBField.initString("");
  public final PBStringField program_id = PBField.initString("");
  public final PBStringField report_trace_info = PBField.initString("");
  public final PBStringField room_id = PBField.initString("");
  public final PBStringField title = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.GetPortalRsp.RoomItem
 * JD-Core Version:    0.7.0.1
 */