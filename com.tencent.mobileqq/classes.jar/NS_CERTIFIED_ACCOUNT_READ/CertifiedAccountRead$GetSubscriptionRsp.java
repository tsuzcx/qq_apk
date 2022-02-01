package NS_CERTIFIED_ACCOUNT_READ;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class CertifiedAccountRead$GetSubscriptionRsp
  extends MessageMicro<GetSubscriptionRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "room_lst", "bottom", "page_info" }, new Object[] { null, null, "" }, GetSubscriptionRsp.class);
  public CertifiedAccountRead.GetSubscriptionRsp.Bottom bottom = new CertifiedAccountRead.GetSubscriptionRsp.Bottom();
  public final PBStringField page_info = PBField.initString("");
  public final PBRepeatMessageField<CertifiedAccountRead.GetPortalRsp.RoomLstItem> room_lst = PBField.initRepeatMessage(CertifiedAccountRead.GetPortalRsp.RoomLstItem.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.GetSubscriptionRsp
 * JD-Core Version:    0.7.0.1
 */