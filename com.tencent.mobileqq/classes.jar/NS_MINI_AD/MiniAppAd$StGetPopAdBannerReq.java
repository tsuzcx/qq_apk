package NS_MINI_AD;

import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class MiniAppAd$StGetPopAdBannerReq
  extends MessageMicro<StGetPopAdBannerReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "extInfo", "strAppId", "strRefer" }, new Object[] { null, "", "" }, StGetPopAdBannerReq.class);
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  public final PBStringField strAppId = PBField.initString("");
  public final PBStringField strRefer = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MINI_AD.MiniAppAd.StGetPopAdBannerReq
 * JD-Core Version:    0.7.0.1
 */