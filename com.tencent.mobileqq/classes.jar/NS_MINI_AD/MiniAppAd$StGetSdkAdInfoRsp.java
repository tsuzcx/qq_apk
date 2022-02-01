package NS_MINI_AD;

import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class MiniAppAd$StGetSdkAdInfoRsp
  extends MessageMicro<StGetSdkAdInfoRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "extInfo", "strSourceFrom", "strMiniCategory", "strPosId" }, new Object[] { null, "", "", "" }, StGetSdkAdInfoRsp.class);
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  public final PBStringField strMiniCategory = PBField.initString("");
  public final PBStringField strPosId = PBField.initString("");
  public final PBStringField strSourceFrom = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MINI_AD.MiniAppAd.StGetSdkAdInfoRsp
 * JD-Core Version:    0.7.0.1
 */