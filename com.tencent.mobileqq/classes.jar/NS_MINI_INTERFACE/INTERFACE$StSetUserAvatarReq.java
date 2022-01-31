package NS_MINI_INTERFACE;

import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class INTERFACE$StSetUserAvatarReq
  extends MessageMicro<StSetUserAvatarReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 42, 50 }, new String[] { "extInfo", "appid", "uin", "set_type", "item_id", "busi_info" }, new Object[] { null, "", "", Integer.valueOf(0), "", "" }, StSetUserAvatarReq.class);
  public final PBStringField appid = PBField.initString("");
  public final PBStringField busi_info = PBField.initString("");
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  public final PBStringField item_id = PBField.initString("");
  public final PBInt32Field set_type = PBField.initInt32(0);
  public final PBStringField uin = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MINI_INTERFACE.INTERFACE.StSetUserAvatarReq
 * JD-Core Version:    0.7.0.1
 */