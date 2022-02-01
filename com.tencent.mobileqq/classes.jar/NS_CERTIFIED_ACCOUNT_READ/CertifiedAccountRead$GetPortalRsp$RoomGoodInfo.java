package NS_CERTIFIED_ACCOUNT_READ;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class CertifiedAccountRead$GetPortalRsp$RoomGoodInfo
  extends MessageMicro<RoomGoodInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 58, 64 }, new String[] { "has_good", "pic_url", "name", "price", "jump_url", "recomm_url", "recom_pic", "goods_num" }, new Object[] { Integer.valueOf(0), "", "", "", "", "", "", Long.valueOf(0L) }, RoomGoodInfo.class);
  public final PBUInt64Field goods_num = PBField.initUInt64(0L);
  public final PBInt32Field has_good = PBField.initInt32(0);
  public final PBStringField jump_url = PBField.initString("");
  public final PBStringField name = PBField.initString("");
  public final PBStringField pic_url = PBField.initString("");
  public final PBStringField price = PBField.initString("");
  public final PBStringField recom_pic = PBField.initString("");
  public final PBStringField recomm_url = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.GetPortalRsp.RoomGoodInfo
 * JD-Core Version:    0.7.0.1
 */