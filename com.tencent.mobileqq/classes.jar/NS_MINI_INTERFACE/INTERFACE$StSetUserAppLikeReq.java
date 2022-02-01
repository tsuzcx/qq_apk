package NS_MINI_INTERFACE;

import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class INTERFACE$StSetUserAppLikeReq
  extends MessageMicro<StSetUserAppLikeReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "extInfo", "appId", "doLike" }, new Object[] { null, "", Integer.valueOf(0) }, StSetUserAppLikeReq.class);
  public final PBStringField appId = PBField.initString("");
  public final PBUInt32Field doLike = PBField.initUInt32(0);
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MINI_INTERFACE.INTERFACE.StSetUserAppLikeReq
 * JD-Core Version:    0.7.0.1
 */