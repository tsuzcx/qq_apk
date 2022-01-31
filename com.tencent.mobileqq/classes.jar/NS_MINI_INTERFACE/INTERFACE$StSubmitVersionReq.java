package NS_MINI_INTERFACE;

import NS_COMM.COMM.StCommonExt;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class INTERFACE$StSubmitVersionReq
  extends MessageMicro<StSubmitVersionReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 42, 50, 58, 64, 74, 82, 88, 96, 104, 114, 122 }, new String[] { "extInfo", "appid", "version", "versionType", "intro", "mainPkg", "subPkgs", "pkgType", "firstPage", "roomId", "supportOffline", "skipDomainCheck", "property", "usePlugin", "ideConfig" }, new Object[] { null, "", "", Integer.valueOf(0), "", null, null, Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, null }, StSubmitVersionReq.class);
  public final PBStringField appid = PBField.initString("");
  public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  public final PBStringField firstPage = PBField.initString("");
  public INTERFACE.StIdeConfig ideConfig = new INTERFACE.StIdeConfig();
  public final PBStringField intro = PBField.initString("");
  public INTERFACE.StMainPkgInfo mainPkg = new INTERFACE.StMainPkgInfo();
  public final PBUInt32Field pkgType = PBField.initUInt32(0);
  public final PBInt32Field property = PBField.initInt32(0);
  public final PBStringField roomId = PBField.initString("");
  public final PBInt32Field skipDomainCheck = PBField.initInt32(0);
  public final PBRepeatMessageField<INTERFACE.StSplitPkgInfo> subPkgs = PBField.initRepeatMessage(INTERFACE.StSplitPkgInfo.class);
  public final PBInt32Field supportOffline = PBField.initInt32(0);
  public INTERFACE.StUsePlugin usePlugin = new INTERFACE.StUsePlugin();
  public final PBStringField version = PBField.initString("");
  public final PBInt32Field versionType = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     NS_MINI_INTERFACE.INTERFACE.StSubmitVersionReq
 * JD-Core Version:    0.7.0.1
 */