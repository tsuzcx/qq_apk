package NS_MINI_SHARE;

import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class MiniProgramShare$StAdaptShareInfoReq
  extends MessageMicro<StAdaptShareInfoReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40, 48, 56, 64, 74, 82, 90, 98, 104, 112, 122, 128, 138, 146, 154, 162 }, new String[] { "extInfo", "appid", "title", "desc", "time", "scene", "templetType", "businessType", "picUrl", "vidUrl", "jumpUrl", "iconUrl", "verType", "shareType", "versionId", "withShareTicket", "webURL", "appidRich", "template", "rcvOpenId" }, new Object[] { null, "", "", "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", "", "", "", Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), "", "", null, "" }, StAdaptShareInfoReq.class);
  public final PBStringField appid = PBField.initString("");
  public final PBStringField appidRich = PBField.initString("");
  public final PBEnumField businessType = PBField.initEnum(0);
  public final PBStringField desc = PBField.initString("");
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  public final PBStringField iconUrl = PBField.initString("");
  public final PBStringField jumpUrl = PBField.initString("");
  public final PBStringField picUrl = PBField.initString("");
  public final PBStringField rcvOpenId = PBField.initString("");
  public final PBEnumField scene = PBField.initEnum(0);
  public final PBInt32Field shareType = PBField.initInt32(0);
  public MiniProgramShare.StTemplateInfo template = new MiniProgramShare.StTemplateInfo();
  public final PBEnumField templetType = PBField.initEnum(0);
  public final PBUInt32Field time = PBField.initUInt32(0);
  public final PBStringField title = PBField.initString("");
  public final PBEnumField verType = PBField.initEnum(0);
  public final PBStringField versionId = PBField.initString("");
  public final PBStringField vidUrl = PBField.initString("");
  public final PBStringField webURL = PBField.initString("");
  public final PBInt32Field withShareTicket = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MINI_SHARE.MiniProgramShare.StAdaptShareInfoReq
 * JD-Core Version:    0.7.0.1
 */