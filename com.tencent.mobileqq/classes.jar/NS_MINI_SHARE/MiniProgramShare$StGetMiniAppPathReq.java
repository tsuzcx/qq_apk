package NS_MINI_SHARE;

import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class MiniProgramShare$StGetMiniAppPathReq
  extends MessageMicro<StGetMiniAppPathReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40, 50, 58 }, new String[] { "extInfo", "main_appid", "appid", "path", "miniAppType", "webURL", "content" }, new Object[] { null, "", "", "", Integer.valueOf(0), "", "" }, StGetMiniAppPathReq.class);
  public final PBStringField appid = PBField.initString("");
  public final PBStringField content = PBField.initString("");
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  public final PBStringField main_appid = PBField.initString("");
  public final PBInt32Field miniAppType = PBField.initInt32(0);
  public final PBStringField path = PBField.initString("");
  public final PBStringField webURL = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     NS_MINI_SHARE.MiniProgramShare.StGetMiniAppPathReq
 * JD-Core Version:    0.7.0.1
 */