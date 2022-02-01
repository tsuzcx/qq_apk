package NS_CERTIFIED_ACCOUNT_READ;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class CertifiedAccountRead$GetPortalRsp$RoomItem
  extends MessageMicro<RoomItem>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatMessageField<CertifiedAccountRead.GetPortalRsp.KV> ext_info = PBField.initRepeatMessage(CertifiedAccountRead.GetPortalRsp.KV.class);
  public final PBUInt32Field game_id = PBField.initUInt32(0);
  public final PBUInt32Field game_tag_id = PBField.initUInt32(0);
  public CertifiedAccountRead.GetPortalRsp.RoomGoodInfo good_info = new CertifiedAccountRead.GetPortalRsp.RoomGoodInfo();
  public CertifiedAccountRead.GetPortalRsp.RoomIconInfo icon_info = new CertifiedAccountRead.GetPortalRsp.RoomIconInfo();
  public final PBStringField nick = PBField.initString("");
  public final PBStringField pgc_openid = PBField.initString("");
  public final PBUInt64Field pgc_uid = PBField.initUInt64(0L);
  public final PBStringField pic_url = PBField.initString("");
  public final PBStringField portrait = PBField.initString("");
  public final PBStringField program_id = PBField.initString("");
  public final PBStringField recom_info = PBField.initString("");
  public final PBStringField report_trace_info = PBField.initString("");
  public final PBStringField room_id = PBField.initString("");
  public final PBUInt32Field room_type = PBField.initUInt32(0);
  public final PBStringField title = PBField.initString("");
  public final PBUInt64Field video_source = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 42, 50, 58, 66, 74, 82, 90, 98, 106, 112, 120, 128, 136 }, new String[] { "room_id", "pgc_openid", "pgc_uid", "nick", "title", "portrait", "pic_url", "program_id", "report_trace_info", "good_info", "icon_info", "ext_info", "recom_info", "room_type", "video_source", "game_id", "game_tag_id" }, new Object[] { "", "", Long.valueOf(0L), "", "", "", "", "", "", null, null, null, "", localInteger, Long.valueOf(0L), localInteger, localInteger }, RoomItem.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.GetPortalRsp.RoomItem
 * JD-Core Version:    0.7.0.1
 */