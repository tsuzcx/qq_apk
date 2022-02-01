package NS_CERTIFIED_ACCOUNT;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class CertifiedAccountMeta$StLive
  extends MessageMicro<StLive>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField anchorIcon = PBField.initString("");
  public final PBStringField anchorName = PBField.initString("");
  public final PBRepeatMessageField<CertifiedAccountMeta.StLiveGoods> goodsInfo = PBField.initRepeatMessage(CertifiedAccountMeta.StLiveGoods.class);
  public final PBInt32Field liveState = PBField.initInt32(0);
  public final PBUInt64Field liveUin = PBField.initUInt64(0L);
  public final PBStringField marketStatus = PBField.initString("");
  public final PBRepeatMessageField<CertifiedAccountMeta.StLive.RoomIcon> roomIcon = PBField.initRepeatMessage(CertifiedAccountMeta.StLive.RoomIcon.class);
  public final PBUInt64Field roomId = PBField.initUInt64(0L);
  public final PBStringField roomTitle = PBField.initString("");
  public final PBStringField rtmpURL = PBField.initString("");
  public final PBInt32Field totalGoods = PBField.initInt32(0);
  public final PBStringField typeIcon = PBField.initString("");
  public final PBUInt64Field viewer = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40, 50, 58, 64, 74, 80, 90, 98, 106 }, new String[] { "liveUin", "liveState", "anchorName", "anchorIcon", "roomId", "roomTitle", "roomIcon", "viewer", "marketStatus", "totalGoods", "goodsInfo", "rtmpURL", "typeIcon" }, new Object[] { localLong, localInteger, "", "", localLong, "", null, localLong, "", localInteger, null, "", "" }, StLive.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StLive
 * JD-Core Version:    0.7.0.1
 */