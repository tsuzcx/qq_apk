package NS_MINI_AD;

import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class MiniAppAd$StGetPopAdBannerRsp
  extends MessageMicro<StGetPopAdBannerRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42 }, new String[] { "extInfo", "strAdTitle", "strImgUrl", "strJumpUrl", "strAdTrace" }, new Object[] { null, "", "", "", "" }, StGetPopAdBannerRsp.class);
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  public final PBStringField strAdTitle = PBField.initString("");
  public final PBStringField strAdTrace = PBField.initString("");
  public final PBStringField strImgUrl = PBField.initString("");
  public final PBStringField strJumpUrl = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MINI_AD.MiniAppAd.StGetPopAdBannerRsp
 * JD-Core Version:    0.7.0.1
 */