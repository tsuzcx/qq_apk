package NS_CERTIFIED_ACCOUNT_READ;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class CertifiedAccountRead$GetPortalRsp$RoomLstItem
  extends MessageMicro<RoomLstItem>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "tab_info", "sub_tab_lst", "banner_lst", "room_lst" }, new Object[] { null, null, null, null }, RoomLstItem.class);
  public final PBRepeatMessageField<CertifiedAccountRead.GetPortalRsp.BannerItem> banner_lst = PBField.initRepeatMessage(CertifiedAccountRead.GetPortalRsp.BannerItem.class);
  public final PBRepeatMessageField<CertifiedAccountRead.GetPortalRsp.RoomItem> room_lst = PBField.initRepeatMessage(CertifiedAccountRead.GetPortalRsp.RoomItem.class);
  public final PBRepeatMessageField<CertifiedAccountRead.GetPortalRsp.SubTabItem> sub_tab_lst = PBField.initRepeatMessage(CertifiedAccountRead.GetPortalRsp.SubTabItem.class);
  public CertifiedAccountRead.GetPortalRsp.TabItem tab_info = new CertifiedAccountRead.GetPortalRsp.TabItem();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.GetPortalRsp.RoomLstItem
 * JD-Core Version:    0.7.0.1
 */