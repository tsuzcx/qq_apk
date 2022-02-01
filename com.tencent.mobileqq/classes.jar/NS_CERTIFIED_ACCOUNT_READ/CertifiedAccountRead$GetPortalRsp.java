package NS_CERTIFIED_ACCOUNT_READ;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class CertifiedAccountRead$GetPortalRsp
  extends MessageMicro<GetPortalRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 82 }, new String[] { "tab_lst", "room_lst", "trace_info" }, new Object[] { null, null, "" }, GetPortalRsp.class);
  public final PBRepeatMessageField<CertifiedAccountRead.GetPortalRsp.RoomLstItem> room_lst = PBField.initRepeatMessage(CertifiedAccountRead.GetPortalRsp.RoomLstItem.class);
  public final PBRepeatMessageField<CertifiedAccountRead.GetPortalRsp.TabItem> tab_lst = PBField.initRepeatMessage(CertifiedAccountRead.GetPortalRsp.TabItem.class);
  public final PBStringField trace_info = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.GetPortalRsp
 * JD-Core Version:    0.7.0.1
 */