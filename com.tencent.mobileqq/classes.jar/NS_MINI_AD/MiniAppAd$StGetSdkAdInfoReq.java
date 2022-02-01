package NS_MINI_AD;

import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class MiniAppAd$StGetSdkAdInfoReq
  extends MessageMicro<StGetSdkAdInfoReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32 }, new String[] { "extInfo", "strSubPosId", "strAppid", "iAdType" }, new Object[] { null, "", "", Integer.valueOf(0) }, StGetSdkAdInfoReq.class);
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  public final PBInt32Field iAdType = PBField.initInt32(0);
  public final PBStringField strAppid = PBField.initString("");
  public final PBStringField strSubPosId = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MINI_AD.MiniAppAd.StGetSdkAdInfoReq
 * JD-Core Version:    0.7.0.1
 */